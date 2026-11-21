package com.collectpoint.widget.popupwindow;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.bean.item.UserOrgListItem;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.ItemPopupSiteBinding;
import com.collectpoint.databinding.PopupSiteBinding;
import com.collectpoint.utils.AlphaUtils;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.decoration.MyItemDecoration1;
import com.liuwq.base.recyclerview.BaseListAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class SitePopupWindow extends PopupWindow implements View.OnClickListener {
    private Activity activity;
    private SiteAdapter mAdapter;
    private PopupSiteBinding mBinding;
    private View mContentView;
    private OnSiteClickListener mListener;
    private List<UserOrgListItem> mUserOrgList;
    private int position;

    public interface OnSiteClickListener {
        void onSiteSubmit(UserOrgListItem userOrgListItem);
    }

    private class SiteAdapter extends BaseListAdapter<UserOrgListItem, ViewHolder> {
        private int mPosition;

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ItemPopupSiteBinding mBinding;

            public ViewHolder(ViewDataBinding viewDataBinding) {
                super(viewDataBinding.getRoot());
                this.mBinding = (ItemPopupSiteBinding) viewDataBinding;
                this.itemView.setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                if (-1 == adapterPosition) {
                    return;
                }
                UserOrgListItem userOrgListItem = (UserOrgListItem) SiteAdapter.this.getData(adapterPosition);
                if (SiteAdapter.this.mPosition == adapterPosition) {
                    userOrgListItem.setChecked(!userOrgListItem.isChecked());
                } else if (SiteAdapter.this.mPosition != -1) {
                    ((UserOrgListItem) SiteAdapter.this.getData().get(SiteAdapter.this.mPosition)).setChecked(false);
                    userOrgListItem.setChecked(true);
                } else {
                    userOrgListItem.setChecked(true);
                }
                SiteAdapter.this.mPosition = adapterPosition;
                SiteAdapter.this.notifyDataSetChanged();
            }
        }

        public SiteAdapter(int i) {
            this.mPosition = i;
        }

        public UserOrgListItem ReturnItem() {
            UserOrgListItem userOrgListItem = new UserOrgListItem();
            for (UserOrgListItem userOrgListItem2 : getData()) {
                if (userOrgListItem2.isChecked()) {
                    userOrgListItem.setChecked(true);
                    userOrgListItem.setOrgNickName(userOrgListItem2.getOrgNickName());
                    userOrgListItem.setOrgCode(userOrgListItem2.getOrgCode());
                    userOrgListItem.setId(userOrgListItem2.getId());
                }
                userOrgListItem2.setChecked(false);
            }
            return userOrgListItem;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            UserOrgListItem userOrgListItem = (UserOrgListItem) getData(i);
            viewHolder.mBinding.tvName.setBackgroundResource(userOrgListItem.isChecked() ? 2131099835 : 2131100237);
            viewHolder.mBinding.tvName.setText(userOrgListItem.getOrgNickName());
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(DataBindingUtil.inflate(getLayoutInflater(), 2131493039, viewGroup, false));
        }
    }

    public SitePopupWindow(Activity activity, List<UserOrgListItem> list, OnSiteClickListener onSiteClickListener) {
        ArrayList arrayList = new ArrayList();
        this.mUserOrgList = arrayList;
        this.position = -1;
        this.activity = activity;
        this.mListener = onSiteClickListener;
        arrayList.clear();
        if (EmptyUtils.isNotEmpty(list)) {
            this.mUserOrgList.addAll(list);
        }
        View viewInflate = View.inflate(activity, 2131493090, null);
        this.mContentView = viewInflate;
        this.mBinding = PopupSiteBinding.bind(viewInflate);
        init();
        setPopupWindow();
    }

    private void init() {
        this.mBinding.rvRefreshable.getLayoutParams().height = ScreenUtils.getScreenHeight() / 3;
        String string = CacheUtils.getInstance().getCacheDoubleUtils().getString(Constants.KEY_ORG_NICK_NAME);
        if (EmptyUtils.isNotEmpty(this.mUserOrgList)) {
            if (EmptyUtils.isNotEmpty(string)) {
                int i = -1;
                for (UserOrgListItem userOrgListItem : this.mUserOrgList) {
                    i++;
                    if (TextUtils.equals(userOrgListItem.getOrgNickName(), string)) {
                        this.position = i;
                        userOrgListItem.setChecked(true);
                    } else {
                        userOrgListItem.setChecked(false);
                    }
                }
            }
            this.mBinding.rvRefreshable.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
            this.mAdapter = new SiteAdapter(this.position);
            this.mBinding.rvRefreshable.setAdapter(this.mAdapter);
            this.mBinding.rvRefreshable.addItemDecoration(new MyItemDecoration1(this.activity));
            this.mAdapter.setData(this.mUserOrgList);
        }
        this.mBinding.imgClose.setOnClickListener(this);
        this.mBinding.tvConfirm.setOnClickListener(this);
    }

    private void setPopupWindow() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (displayMetrics.widthPixels * 3) / 4;
        setHeight(-2);
        setWidth(i);
        setContentView(this.mContentView);
        setOutsideTouchable(false);
        setFocusable(false);
        setTouchable(true);
        setSoftInputMode(16);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        AlphaUtils.backgroundAlpha(this.activity, 1.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296568:
                dismiss();
                break;
            case 2131296981:
                if (!EmptyUtils.isEmpty(this.mUserOrgList)) {
                    UserOrgListItem userOrgListItemReturnItem = this.mAdapter.ReturnItem();
                    if (!userOrgListItemReturnItem.isChecked()) {
                        ToastUtils.showShort("请选择项目单位");
                        break;
                    } else {
                        this.mListener.onSiteSubmit(userOrgListItemReturnItem);
                        dismiss();
                        break;
                    }
                }
                break;
        }
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        AlphaUtils.backgroundAlpha(this.activity, 0.5f);
        showAtLocation(view, 17, 0, 0);
    }
}
