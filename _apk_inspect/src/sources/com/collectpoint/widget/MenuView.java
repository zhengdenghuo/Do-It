package com.collectpoint.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.collectpoint.MyApp;
import com.collectpoint.bean.item.ProjectObjectFirstListItem;
import com.collectpoint.utils.BackgroundLibUtil;
import com.collectpoint.utils.EmptyUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes3.dex */
public class MenuView extends ViewGroup {
    private static int DURATION = 500;
    private static final int PADDING_L_R = 50;
    private static final int PADDING_T_B = 10;
    private final int SMALL_RADIUS;
    private TextView childOne;
    private int currentIndex;
    private boolean isAnimating;
    private boolean isShown;
    private OnSiteClickListener onSiteClickListener;
    private int startX;
    private int startY;
    private ArrayList<LinearLayout> views;

    public interface OnSiteClickListener {
        void onSiteSubmit(boolean z, String str, String str2, String str3);
    }

    public MenuView(Context context) {
        super(context);
        this.views = new ArrayList<>();
        this.SMALL_RADIUS = (int) context.getResources().getDimension(2131165824);
        init(context);
    }

    public MenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.views = new ArrayList<>();
        this.SMALL_RADIUS = (int) context.getResources().getDimension(2131165824);
        init(context);
    }

    public MenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.views = new ArrayList<>();
        this.SMALL_RADIUS = (int) context.getResources().getDimension(2131165824);
        init(context);
    }

    static /* synthetic */ int access$008(MenuView menuView) {
        int i = menuView.currentIndex;
        menuView.currentIndex = i + 1;
        return i;
    }

    private int getChildOffset_b(int i, int i2, int i3) {
        return i2 + i3;
    }

    private int getChildOffset_l(int i, int i2, int i3) {
        return i - i3;
    }

    private int getChildOffset_r(int i, int i2, int i3) {
        return i + i3;
    }

    private int getChildOffset_t(int i, int i2, int i3) {
        return i2 - i3;
    }

    private void init(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        TextView textView = new TextView(context);
        this.childOne = textView;
        textView.setTextColor(ContextCompat.getColor(context, 2131100237));
        this.childOne.setGravity(17);
        this.childOne.setBackground(BackgroundLibUtil.getDrawable(2131165561, 2131099737));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(MyApp.getInstance().getResources().getDimensionPixelOffset(2131165568), MyApp.getInstance().getResources().getDimensionPixelOffset(2131165568));
        layoutParams.gravity = 17;
        linearLayout.addView(this.childOne, layoutParams);
        addView(linearLayout);
        this.views.add(linearLayout);
        this.childOne.setVisibility(4);
    }

    private void layout(View view, int i, int i2, int i3) {
        view.layout(getChildOffset_l(i, i2, i3), getChildOffset_t(i, i2, i3), getChildOffset_r(i, i2, i3), getChildOffset_b(i, i2, i3));
    }

    public void in() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        int size = this.views.size();
        for (int i = 0; i < size; i++) {
            final LinearLayout linearLayout = this.views.get(i);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (this.startX - linearLayout.getLeft()) - (linearLayout.getWidth() / 2), 0.0f, (this.startY - linearLayout.getTop()) + (linearLayout.getHeight() / 2));
            translateAnimation.setInterpolator(new OvershootInterpolator(1.2f));
            if (i >= size / 2) {
                translateAnimation.setDuration(DURATION - 100);
            } else {
                translateAnimation.setDuration(DURATION);
            }
            linearLayout.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.collectpoint.widget.MenuView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MenuView.access$008(MenuView.this);
                    linearLayout.setVisibility(4);
                    if (MenuView.this.currentIndex == MenuView.this.views.size()) {
                        MenuView.this.isAnimating = false;
                        MenuView.this.currentIndex = 0;
                        MenuView.this.isShown = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    public boolean isAnimating() {
        return this.isAnimating;
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.isShown;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.startX = getWidth() / 2;
        this.startY = (getHeight() - (MyApp.getInstance().getResources().getDimensionPixelOffset(2131165568) / 2)) - 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws Resources.NotFoundException {
        int i5;
        View view;
        double d;
        double dSin;
        int childCount = getChildCount();
        if (childCount != 0 && getChildAt(0) != null) {
            int measuredWidth = getMeasuredWidth() - 100;
            int measuredHeight = getMeasuredHeight() - 20;
            View childAt = getChildAt(0);
            int measuredWidth2 = (measuredWidth - childAt.getMeasuredWidth()) / 2;
            int dimensionPixelOffset = MyApp.getContext().getResources().getDimensionPixelOffset(2131165824);
            double d2 = ((childCount * 1.0d) / 2.0d) - 0.5d;
            int i6 = 0;
            while (i6 < childCount) {
                View childAt2 = getChildAt(i6);
                if (childAt2 == null) {
                    return;
                }
                if (i6 < d2) {
                    i5 = childCount;
                    view = childAt;
                    d = (1.5707963267948966d / d2) * (d2 - i6);
                    if (Double.isNaN(d)) {
                        d = 0.0d;
                    }
                    dSin = ((measuredWidth / 2) + PADDING_L_R) - (measuredWidth2 * Math.sin(d));
                } else {
                    i5 = childCount;
                    view = childAt;
                    d = (1.5707963267948966d / d2) * (i6 - d2);
                    if (Double.isNaN(d)) {
                        d = 0.0d;
                    }
                    dSin = (measuredWidth / 2) + PADDING_L_R + (measuredWidth2 * Math.sin(d));
                }
                layout(childAt2, (int) dSin, (int) ((measuredHeight - dimensionPixelOffset) - (measuredWidth2 * Math.cos(d))), dimensionPixelOffset);
                i6++;
                measuredWidth = measuredWidth;
                childCount = i5;
                childAt = view;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.SMALL_RADIUS, 1073741824), View.MeasureSpec.makeMeasureSpec(this.SMALL_RADIUS, 1073741824));
            }
        }
        int i4 = getResources().getDisplayMetrics().widthPixels;
        int measuredWidth = getChildAt(0).getMeasuredWidth();
        setMeasuredDimension(i4, (measuredWidth * 2) + ((i4 / 2) - measuredWidth) + 20);
    }

    public void out() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        int size = this.views.size();
        for (int i = 0; i < size; i++) {
            final LinearLayout linearLayout = this.views.get(i);
            TranslateAnimation translateAnimation = new TranslateAnimation(this.startX - linearLayout.getLeft(), 0.0f, this.startY - linearLayout.getTop(), 0.0f);
            translateAnimation.setInterpolator(new OvershootInterpolator(1.5f));
            translateAnimation.setDuration(DURATION);
            linearLayout.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.collectpoint.widget.MenuView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MenuView.access$008(MenuView.this);
                    linearLayout.setVisibility(0);
                    if (MenuView.this.currentIndex == MenuView.this.views.size()) {
                        MenuView.this.isAnimating = false;
                        MenuView.this.currentIndex = 0;
                        MenuView.this.isShown = true;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    public void setData(final List<ProjectObjectFirstListItem> list, Context context, OnSiteClickListener onSiteClickListener) {
        if (EmptyUtils.isEmpty(list)) {
            return;
        }
        System.out.println("______data " + list.size());
        this.onSiteClickListener = onSiteClickListener;
        this.childOne.setText(list.get(0).getCollectionName());
        this.childOne.setVisibility(0);
        this.childOne.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.MenuView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuView.this.onSiteClickListener.onSiteSubmit(false, ((ProjectObjectFirstListItem) list.get(0)).getCollectionCode(), ((ProjectObjectFirstListItem) list.get(0)).getCollectionName(), ((ProjectObjectFirstListItem) list.get(0)).getAppMapIcon());
            }
        });
        for (int i = 1; i < Math.min(list.size(), 8); i++) {
            final int i2 = i;
            LinearLayout linearLayout = new LinearLayout(context);
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setTextColor(ContextCompat.getColor(context, 2131100237));
            textView.setBackground(BackgroundLibUtil.getDrawable(2131165561, 2131099737));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(MyApp.getInstance().getResources().getDimensionPixelOffset(2131165568), MyApp.getInstance().getResources().getDimensionPixelOffset(2131165568));
            layoutParams.gravity = 17;
            linearLayout.addView(textView, layoutParams);
            addView(linearLayout);
            this.views.add(linearLayout);
            textView.setVisibility(0);
            if (list.size() <= 8 || i != 7) {
                textView.setText(list.get(i2).getCollectionName());
            } else {
                textView.setText("更多");
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.widget.MenuView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MenuView.this.onSiteClickListener != null) {
                        MenuView.this.onSiteClickListener.onSiteSubmit(list.size() > 8 && i2 == 7, ((ProjectObjectFirstListItem) list.get(i2)).getCollectionCode(), ((ProjectObjectFirstListItem) list.get(i2)).getCollectionName(), ((ProjectObjectFirstListItem) list.get(i2)).getAppMapIcon());
                    }
                }
            });
        }
        requestLayout();
    }
}
