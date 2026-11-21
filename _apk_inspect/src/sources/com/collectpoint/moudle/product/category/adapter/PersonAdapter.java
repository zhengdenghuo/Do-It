package com.collectpoint.moudle.product.category.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.collectpoint.moudle.product.category.entity.GoodsListBean;
import com.collectpoint.moudle.product.category.event.GoodsListEvent;
import com.collectpoint.moudle.product.category.event.MessageEvent;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class PersonAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ImageView buyImg;
    private int buyNum;
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> dataList;
    private int[] goodsNum;
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity> goodscatrgoryEntities;
    private Activity mActivity;
    private Context mContext;
    private int[] mGoodsCategoryBuyNums;
    private int[] mSectionIndices;
    private String[] mSectionLetters;
    private TextView shopCart;
    private int totalPrice;
    private List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> selectGoods = new ArrayList();
    private OnShopCartGoodsChangeListener mOnGoodsNunChangeListener = null;

    public interface OnShopCartGoodsChangeListener {
        void onNumChange();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView goodsCategoryName;
        public final LinearLayout goodsInfo;
        public final ImageView ivGoodsAdd;
        public final ImageView ivGoodsImage;
        public final ImageView ivGoodsMinus;
        public final View root;
        public final TextView tvGoodsDescription;
        public final TextView tvGoodsIntegral;
        public final TextView tvGoodsPrice;
        public final TextView tvGoodsSelectNum;

        public ViewHolder(View view) {
            super(view);
            this.ivGoodsImage = (ImageView) view.findViewById(2131296586);
            this.goodsCategoryName = (TextView) view.findViewById(2131296532);
            this.tvGoodsDescription = (TextView) view.findViewById(2131296945);
            this.goodsInfo = (LinearLayout) view.findViewById(2131296534);
            this.tvGoodsPrice = (TextView) view.findViewById(2131296948);
            this.tvGoodsIntegral = (TextView) view.findViewById(2131296946);
            this.ivGoodsMinus = (ImageView) view.findViewById(2131296587);
            this.tvGoodsSelectNum = (TextView) view.findViewById(2131296949);
            this.ivGoodsAdd = (ImageView) view.findViewById(2131296585);
            this.root = view;
        }
    }

    public PersonAdapter(Context context, List<GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity> list, List<GoodsListBean.DataEntity.GoodscatrgoryEntity> list2) {
        this.mContext = context;
        this.dataList = list;
        this.goodscatrgoryEntities = list2;
        initGoodsNum();
        this.mSectionIndices = getSectionIndices();
        this.mSectionLetters = getSectionLetters();
        this.mGoodsCategoryBuyNums = getBuyNums();
        setHasStableIds(true);
    }

    static /* synthetic */ int access$408(PersonAdapter personAdapter) {
        int i = personAdapter.buyNum;
        personAdapter.buyNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$410(PersonAdapter personAdapter) {
        int i = personAdapter.buyNum;
        personAdapter.buyNum = i - 1;
        return i;
    }

    static /* synthetic */ int access$512(PersonAdapter personAdapter, int i) {
        int i2 = personAdapter.totalPrice + i;
        personAdapter.totalPrice = i2;
        return i2;
    }

    static /* synthetic */ int access$520(PersonAdapter personAdapter, int i) {
        int i2 = personAdapter.totalPrice - i;
        personAdapter.totalPrice = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeShopCart() {
        EventBus.getDefault().post(new MessageEvent(this.buyNum, this.totalPrice, this.selectGoods));
        EventBus.getDefault().post(new GoodsListEvent(this.mGoodsCategoryBuyNums));
        TextView textView = this.shopCart;
        if (textView == null) {
            return;
        }
        if (this.buyNum <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            this.shopCart.setText(this.buyNum + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getHiddenAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 4.0f, 1, 0.0f, 1, 0.0f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setDuration(500L);
        return animationSet;
    }

    private int[] getSectionIndices() {
        ArrayList arrayList = new ArrayList();
        int id = -1;
        for (int i = 0; i < this.dataList.size(); i++) {
            if (this.dataList.get(i).getId() != id) {
                id = this.dataList.get(i).getId();
                arrayList.add(Integer.valueOf(i));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    private String[] getSectionLetters() {
        String[] strArr = new String[this.mSectionIndices.length];
        for (int i = 0; i < this.mSectionIndices.length; i++) {
            strArr[i] = this.goodscatrgoryEntities.get(i).getName();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getShowAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f));
        animationSet.addAnimation(new TranslateAnimation(1, 2.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.setDuration(500L);
        return animationSet;
    }

    private void initGoodsNum() {
        int size = this.dataList.size();
        this.goodsNum = new int[size];
        for (int i = 0; i < size; i++) {
            this.goodsNum[i] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isSelected(int i, ViewHolder viewHolder) {
        if (i == 0) {
            viewHolder.tvGoodsSelectNum.setVisibility(8);
            viewHolder.ivGoodsMinus.setVisibility(8);
        } else {
            viewHolder.tvGoodsSelectNum.setVisibility(0);
            viewHolder.tvGoodsSelectNum.setText(i + "");
            viewHolder.ivGoodsMinus.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim(View view) {
        ImageView imageView = new ImageView(this.mActivity);
        this.buyImg = imageView;
        imageView.setBackgroundResource(2131230945);
        view.getLocationInWindow(new int[2]);
        view.getLocationInWindow(new int[2]);
    }

    public void clear() {
        this.mSectionIndices = new int[0];
        this.mSectionLetters = new String[0];
        notifyDataSetChanged();
    }

    public int[] getBuyNums() {
        int[] iArr = new int[this.goodscatrgoryEntities.size()];
        for (int i = 0; i < this.goodscatrgoryEntities.size(); i++) {
            iArr[i] = this.goodscatrgoryEntities.get(i).getBugNum();
        }
        return iArr;
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public long getItemId(int i) {
        return this.dataList.get(i).hashCode();
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.goodsCategoryName.setText(this.dataList.get(i).getName());
        viewHolder.tvGoodsDescription.setText(this.dataList.get(i).getIntroduce());
        viewHolder.tvGoodsPrice.setText("¥" + this.dataList.get(i).getPrice());
        Glide.with(this.mContext).load(this.dataList.get(i).getGoodsImgUrl()).centerCrop().into(viewHolder.ivGoodsImage);
        isSelected(this.goodsNum[i], viewHolder);
        viewHolder.ivGoodsAdd.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.category.adapter.PersonAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int[] iArr = PersonAdapter.this.goodsNum;
                int i2 = i;
                iArr[i2] = iArr[i2] + 1;
                PersonAdapter.this.selectGoods.add((GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity) PersonAdapter.this.dataList.get(i));
                int[] iArr2 = PersonAdapter.this.mGoodsCategoryBuyNums;
                int id = ((GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity) PersonAdapter.this.dataList.get(i)).getId();
                iArr2[id] = iArr2[id] + 1;
                PersonAdapter.access$408(PersonAdapter.this);
                PersonAdapter personAdapter = PersonAdapter.this;
                PersonAdapter.access$512(personAdapter, ((GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity) personAdapter.dataList.get(i)).getPrice());
                if (PersonAdapter.this.goodsNum[i] <= 1) {
                    viewHolder.ivGoodsMinus.setAnimation(PersonAdapter.this.getShowAnimation());
                    viewHolder.tvGoodsSelectNum.setAnimation(PersonAdapter.this.getShowAnimation());
                    viewHolder.ivGoodsMinus.setVisibility(0);
                    viewHolder.tvGoodsSelectNum.setVisibility(0);
                }
                PersonAdapter.this.startAnim(viewHolder.ivGoodsAdd);
                PersonAdapter.this.changeShopCart();
                if (PersonAdapter.this.mOnGoodsNunChangeListener != null) {
                    PersonAdapter.this.mOnGoodsNunChangeListener.onNumChange();
                }
                PersonAdapter personAdapter2 = PersonAdapter.this;
                personAdapter2.isSelected(personAdapter2.goodsNum[i], viewHolder);
            }
        });
        viewHolder.ivGoodsMinus.setOnClickListener(new View.OnClickListener() { // from class: com.collectpoint.moudle.product.category.adapter.PersonAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonAdapter.this.goodsNum[i] > 0) {
                    PersonAdapter.this.goodsNum[i] = r0[r1] - 1;
                    PersonAdapter.this.selectGoods.remove(PersonAdapter.this.dataList.get(i));
                    PersonAdapter.this.mGoodsCategoryBuyNums[((GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity) PersonAdapter.this.dataList.get(i)).getId()] = r0[r1] - 1;
                    PersonAdapter personAdapter = PersonAdapter.this;
                    personAdapter.isSelected(personAdapter.goodsNum[i], viewHolder);
                    PersonAdapter.access$410(PersonAdapter.this);
                    PersonAdapter personAdapter2 = PersonAdapter.this;
                    PersonAdapter.access$520(personAdapter2, ((GoodsListBean.DataEntity.GoodscatrgoryEntity.GoodsitemEntity) personAdapter2.dataList.get(i)).getPrice());
                    if (PersonAdapter.this.goodsNum[i] <= 0) {
                        viewHolder.ivGoodsMinus.setAnimation(PersonAdapter.this.getHiddenAnimation());
                        viewHolder.tvGoodsSelectNum.setAnimation(PersonAdapter.this.getHiddenAnimation());
                        viewHolder.ivGoodsMinus.setVisibility(8);
                        viewHolder.tvGoodsSelectNum.setVisibility(8);
                    }
                    PersonAdapter.this.changeShopCart();
                    if (PersonAdapter.this.mOnGoodsNunChangeListener != null) {
                        PersonAdapter.this.mOnGoodsNunChangeListener.onNumChange();
                    }
                }
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131493021, viewGroup, false));
    }

    public void restore() {
        this.mSectionIndices = getSectionIndices();
        this.mSectionLetters = getSectionLetters();
        notifyDataSetChanged();
    }

    public void setOnShopCartGoodsChangeListener(OnShopCartGoodsChangeListener onShopCartGoodsChangeListener) {
        this.mOnGoodsNunChangeListener = onShopCartGoodsChangeListener;
    }

    public void setShopCart(TextView textView) {
        this.shopCart = textView;
    }

    public void setmActivity(Activity activity) {
        this.mActivity = activity;
    }
}
