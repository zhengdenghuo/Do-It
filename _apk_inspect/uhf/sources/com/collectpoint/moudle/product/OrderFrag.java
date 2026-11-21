package com.collectpoint.moudle.product;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.chenenyu.router.Router;
import com.collectpoint.bean.even.SearchDataEvent;
import com.collectpoint.databinding.FragOrderBinding;
import com.collectpoint.net.vm.PatrolVm;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.widget.popupwindow.Confirm1Dialog;
import com.liuwq.base.MyActivityManager;
import com.liuwq.base.fragment.BaseFragment;
import com.liuwq.base.util.SystemUtil;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes11.dex */
public class OrderFrag extends BaseFragment implements View.OnClickListener {
    private FragOrderBinding mBinding;
    private PatrolVm mViewModel;

    public static OrderFrag newInstance() {
        Bundle args = new Bundle();
        OrderFrag fragment = new OrderFrag();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected View provideContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragOrderBinding fragOrderBindingInflate = DataBindingUtil.inflate(inflater, 2131492981, container, false);
        this.mBinding = fragOrderBindingInflate;
        fragOrderBindingInflate.setLifecycleOwner(this);
        this.mViewModel = OrderSettleAct.getViewModel(requireActivity());
        init();
        return this.mBinding.getRoot();
    }

    protected void onInit() {
    }

    private void initTabLayout() {
        this.mBinding.tlMain.setupWithViewPager(this.mBinding.vpMain);
        CustomerManageAdapter adapter = new CustomerManageAdapter(getChildFragmentManager());
        this.mBinding.vpMain.setAdapter(adapter);
        this.mBinding.tlMain.getTabAt(0).setText("全部");
        this.mBinding.tlMain.getTabAt(1).setText("未完成");
        this.mBinding.tlMain.getTabAt(2).setText("已完成");
        this.mBinding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.collectpoint.moudle.product.OrderFrag.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == 3 || actionId == 0) {
                    String searchName = OrderFrag.this.mBinding.edtSearch.getText().toString().trim();
                    OrderFrag.this.closeKeyboard();
                    OrderFrag.this.postEvent(new SearchDataEvent(searchName));
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296619:
                Router.build("SearchDataAct").go(this);
                break;
            case 2131297090:
                Confirm1Dialog myAlertInputDialog1 = new Confirm1Dialog(requireActivity());
                myAlertInputDialog1.setData("提示", "确定退出" + this.mBinding.tvProject.getText().toString() + "账号的登录？", "");
                myAlertInputDialog1.setOnConfirmClickListener(new Confirm1Dialog.OnConfirmClickListener() { // from class: com.collectpoint.moudle.product.OrderFrag.2
                    public void onClick(View view2) {
                        Router.build("login").with("status", true).go(OrderFrag.this.getContext());
                        OrderFrag.this.requireActivity().finish();
                        MyActivityManager.destroyAllActivity();
                    }
                });
                myAlertInputDialog1.show();
                break;
        }
    }

    private class CustomerManageAdapter extends FragmentPagerAdapter {
        public CustomerManageAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return OrderList2Frag.newInstance("");
                case OrderSettleFrag.REQUEST_CODE /* 1 */:
                    return OrderList2Frag.newInstance("0");
                default:
                    return OrderList2Frag.newInstance("1");
            }
        }

        public int getCount() {
            return 3;
        }
    }

    private void init() {
        ConstraintLayout.LayoutParams params = this.mBinding.vBar.getLayoutParams();
        params.height = SystemUtil.getStatusBarHeight(getContext());
        String nameProject = "";
        try {
            nameProject = CacheUtils.getInstance().getUserBean().getUser_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBinding.tvProject.setText(nameProject);
        this.mBinding.tvProject.setOnClickListener(this);
        initTabLayout();
    }
}
