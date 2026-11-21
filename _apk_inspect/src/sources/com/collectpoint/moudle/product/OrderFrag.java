package com.collectpoint.moudle.product;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.chenenyu.router.Router;
import com.collectpoint.bean.even.SearchDataEvent;
import com.collectpoint.constants.Constants;
import com.collectpoint.databinding.FragOrderBinding;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.BitmapMemoryCache;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.util.SystemUtil;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderFrag extends BaseFragment implements View.OnClickListener {
    private FragOrderBinding mBinding;
    private PatrolVm mViewModel;

    private class CustomerManageAdapter extends FragmentPagerAdapter {
        public CustomerManageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 3;
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return OrderList2Frag.newInstance("");
                case 1:
                    return OrderList2Frag.newInstance(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
                default:
                    return OrderList2Frag.newInstance("1");
            }
        }
    }

    private void init() {
        this.mBinding.vBar.getLayoutParams().height = SystemUtil.getStatusBarHeight(getContext());
        String user_name = "";
        try {
            user_name = CacheUtils.getInstance().getUserBean().getUser_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.tvProject.setText(user_name);
        this.mBinding.tvProject.setOnClickListener(this);
        initTabLayout();
    }

    private void initTabLayout() {
        this.mBinding.tlMain.setupWithViewPager(this.mBinding.vpMain);
        this.mBinding.vpMain.setAdapter(new CustomerManageAdapter(getChildFragmentManager()));
        this.mBinding.tlMain.getTabAt(0).setText("全部");
        this.mBinding.tlMain.getTabAt(1).setText("未完成");
        this.mBinding.tlMain.getTabAt(2).setText("已完成");
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.OrderFrag.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 0) {
                    return false;
                }
                String strTrim = OrderFrag.this.mBinding.edtSearch.getText().toString().trim();
                OrderFrag.this.closeKeyboard();
                OrderFrag.this.postEvent(new SearchDataEvent(strTrim));
                return true;
            }
        });
    }

    public static OrderFrag newInstance() {
        Bundle bundle = new Bundle();
        OrderFrag orderFrag = new OrderFrag();
        orderFrag.setArguments(bundle);
        return orderFrag;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296619:
                Router.build(Constants.SEARCHDATA_ACT).go(this);
                break;
            case 2131297090:
                Confirm1Dialog confirm1Dialog = new Confirm1Dialog(requireActivity());
                confirm1Dialog.setData("提示", "确定退出" + this.mBinding.tvProject.getText().toString() + "账号的登录？", "");
                confirm1Dialog.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderFrag.2
                    @Override // com.collectpoint.widget.popupwindow.Confirm1Dialog.OnConfirmClickListener
                    public void onClick(View view2) {
                        Router.build(Constants.LOGIN).with(Constants.KEY_STATUS, true).go(OrderFrag.this.getContext());
                        OrderFrag.this.requireActivity().finish();
                        MyActivityManager.destroyAllActivity();
                    }
                });
                confirm1Dialog.show();
                break;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onInit() {
    }

    protected View provideContentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragOrderBinding fragOrderBinding = (FragOrderBinding) DataBindingUtil.inflate(layoutInflater, 2131492981, viewGroup, false);
        this.mBinding = fragOrderBinding;
        fragOrderBinding.setLifecycleOwner(this);
        this.mViewModel = OrderSettleAct.getViewModel(requireActivity());
        init();
        return this.mBinding.getRoot();
    }
}
