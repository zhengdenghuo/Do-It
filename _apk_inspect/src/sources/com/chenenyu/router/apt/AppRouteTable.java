package com.chenenyu.router.apt;

import com.chenenyu.router.template.RouteTable;
import com.collectpoint.constants.Constants;
import com.collectpoint.moudle.MainActivity;
import com.collectpoint.moudle.login.LoginActivity;
import com.collectpoint.moudle.login.ResetPwdAct;
import com.collectpoint.moudle.login.TextLoginAct;
import com.collectpoint.moudle.login.TextLoginFrag;
import com.collectpoint.moudle.mine.MineAct;
import com.collectpoint.moudle.mine.about.AboutAct;
import com.collectpoint.moudle.mine.changepwd.ChangePwdAct;
import com.collectpoint.moudle.product.CouponListAct;
import com.collectpoint.moudle.product.CouponListTgAct;
import com.collectpoint.moudle.product.HallCartListAct;
import com.collectpoint.moudle.product.OrderDetailAct;
import com.collectpoint.moudle.product.OrderDetailHomeAct;
import com.collectpoint.moudle.product.OrderDetailListAct;
import com.collectpoint.moudle.product.OrderSettleAct;
import com.collectpoint.moudle.product.ProductListAct;
import com.collectpoint.moudle.product.ScanPlateAct;
import com.collectpoint.moudle.product.SwitchTableAct;
import com.collectpoint.widget.DialogActivity;
import com.collectpoint.widget.DialogGpsActivity;
import com.collectpoint.widget.DialogNetActivity;
import java.util.Map;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class AppRouteTable implements RouteTable {
    public void handle(Map<String, Class<?>> map) {
        map.put(Constants.SWITCHTABLE_ACT, SwitchTableAct.class);
        map.put(Constants.ORDERDETAILHOME_ACT, OrderDetailHomeAct.class);
        map.put(Constants.DIALOG_GPS_ACT, DialogGpsActivity.class);
        map.put(Constants.DIALOG_ACT, DialogActivity.class);
        map.put(Constants.MINE_ACT, MineAct.class);
        map.put(Constants.COUPONLISTTG_ACT, CouponListTgAct.class);
        map.put(Constants.RESET_PWD_ACT, ResetPwdAct.class);
        map.put(Constants.SCANPLATE_ACT, ScanPlateAct.class);
        map.put(Constants.TEXT_LOGIN_ACT, TextLoginAct.class);
        map.put(Constants.PRODUCTLIST_ACT, ProductListAct.class);
        map.put(Constants.ORDERSETTLE_ACT, OrderSettleAct.class);
        map.put(Constants.MAIN, MainActivity.class);
        map.put(Constants.LOGIN, LoginActivity.class);
        map.put(Constants.ABOUT_ACT, AboutAct.class);
        map.put(Constants.ORDERDETAILLIST_ACT, OrderDetailListAct.class);
        map.put(Constants.DIALOG_NET_ACT, DialogNetActivity.class);
        map.put(Constants.TEXT_LOGIN_FRAG, TextLoginFrag.class);
        map.put(Constants.COUPONLIST_ACT, CouponListAct.class);
        map.put(Constants.ORDERDETAIL_ACT, OrderDetailAct.class);
        map.put(Constants.CHANGE_PWD_ACT, ChangePwdAct.class);
        map.put(Constants.HALLCARTLIST_ACT, HallCartListAct.class);
    }
}
