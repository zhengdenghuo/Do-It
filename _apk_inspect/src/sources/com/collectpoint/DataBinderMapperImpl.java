package com.collectpoint;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.collectpoint.databinding.ActLoginBindingImpl;
import com.collectpoint.databinding.ActMainBindingImpl;
import com.collectpoint.databinding.ActivityMineBindingImpl;
import com.collectpoint.databinding.FragAboutBindingImpl;
import com.collectpoint.databinding.FragChangePwdBindingImpl;
import com.collectpoint.databinding.FragCloudDataBindingImpl;
import com.collectpoint.databinding.FragCoiledPointBindingImpl;
import com.collectpoint.databinding.FragCollectFzBindingImpl;
import com.collectpoint.databinding.FragCollectObjectBindingImpl;
import com.collectpoint.databinding.FragCollectTypeBindingImpl;
import com.collectpoint.databinding.FragCollectdataBindingImpl;
import com.collectpoint.databinding.FragCollectmydataBindingImpl;
import com.collectpoint.databinding.FragCollectmydataFqBindingImpl;
import com.collectpoint.databinding.FragCollectstylesetBindingImpl;
import com.collectpoint.databinding.FragCouponlistBindingImpl;
import com.collectpoint.databinding.FragCouponlistTgBindingImpl;
import com.collectpoint.databinding.FragHallcartlistBindingImpl;
import com.collectpoint.databinding.FragHomeBindingImpl;
import com.collectpoint.databinding.FragLayerBindingImpl;
import com.collectpoint.databinding.FragLocalDataBindingImpl;
import com.collectpoint.databinding.FragLocalSetBindingImpl;
import com.collectpoint.databinding.FragLocateAddBindingImpl;
import com.collectpoint.databinding.FragLocateReBindingImpl;
import com.collectpoint.databinding.FragLocationBindingImpl;
import com.collectpoint.databinding.FragMineBindingImpl;
import com.collectpoint.databinding.FragOrderBindingImpl;
import com.collectpoint.databinding.FragOrderList2BindingImpl;
import com.collectpoint.databinding.FragOrderdetailBindingImpl;
import com.collectpoint.databinding.FragOrderdetailHomeBindingImpl;
import com.collectpoint.databinding.FragOrderdetailListBindingImpl;
import com.collectpoint.databinding.FragOrdersettleBindingImpl;
import com.collectpoint.databinding.FragPointCollectBindingImpl;
import com.collectpoint.databinding.FragPointCollectCoiledBindingImpl;
import com.collectpoint.databinding.FragProductlistfragBindingImpl;
import com.collectpoint.databinding.FragResearchersTrackBindingImpl;
import com.collectpoint.databinding.FragResetPwdBindingImpl;
import com.collectpoint.databinding.FragScanplateBindingImpl;
import com.collectpoint.databinding.FragSearchDataBindingImpl;
import com.collectpoint.databinding.FragStoreBindingImpl;
import com.collectpoint.databinding.FragTextLoginBindingImpl;
import com.collectpoint.databinding.ItemCheckTableBindingImpl;
import com.collectpoint.databinding.ItemCheckUiBindingImpl;
import com.collectpoint.databinding.ItemCollectRecordBindingImpl;
import com.collectpoint.databinding.ItemCollectdataBindingImpl;
import com.collectpoint.databinding.ItemGrouptypeBindingImpl;
import com.collectpoint.databinding.ItemLocateAddBindingImpl;
import com.collectpoint.databinding.ItemMainTabBindingImpl;
import com.collectpoint.databinding.ItemMainTopBindingImpl;
import com.collectpoint.databinding.ItemOrderCoupon2BindingImpl;
import com.collectpoint.databinding.ItemOrderCoupon3BindingImpl;
import com.collectpoint.databinding.ItemOrderCouponBindingImpl;
import com.collectpoint.databinding.ItemOrderDetailBindingImpl;
import com.collectpoint.databinding.ItemOrderSettleBindingImpl;
import com.collectpoint.databinding.ItemOrderlistBindingImpl;
import com.collectpoint.databinding.ItemPayStyleBindingImpl;
import com.collectpoint.databinding.ItemPictureBindingImpl;
import com.collectpoint.databinding.ItemPointsBindingImpl;
import com.collectpoint.databinding.ItemPopupSiteBindingImpl;
import com.collectpoint.databinding.ItemProductBindingImpl;
import com.collectpoint.databinding.ItemScanPlateBindingImpl;
import com.collectpoint.databinding.ItemSeatBindingImpl;
import com.collectpoint.databinding.ItemText48BindingImpl;
import com.collectpoint.databinding.ItemText80BindingImpl;
import com.collectpoint.databinding.ItemTobedealBindingImpl;
import com.collectpoint.databinding.ItemTodayCollectBindingImpl;
import com.collectpoint.databinding.PopupDouyincouponBindingImpl;
import com.collectpoint.databinding.PopupHallcartBindingImpl;
import com.collectpoint.databinding.PopupMapBindingImpl;
import com.collectpoint.databinding.PopupNumBindingImpl;
import com.collectpoint.databinding.PopupPayBindingImpl;
import com.collectpoint.databinding.PopupPayDeBindingImpl;
import com.collectpoint.databinding.PopupPayXjBindingImpl;
import com.collectpoint.databinding.PopupSettleremarkBindingImpl;
import com.collectpoint.databinding.PopupSiteBindingImpl;
import com.collectpoint.databinding.RefreshableRvBindingImpl;
import com.collectpoint.databinding.SwipeMenuItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYMINE = 3;
    private static final int LAYOUT_ACTLOGIN = 1;
    private static final int LAYOUT_ACTMAIN = 2;
    private static final int LAYOUT_FRAGABOUT = 4;
    private static final int LAYOUT_FRAGCHANGEPWD = 5;
    private static final int LAYOUT_FRAGCLOUDDATA = 6;
    private static final int LAYOUT_FRAGCOILEDPOINT = 7;
    private static final int LAYOUT_FRAGCOLLECTDATA = 11;
    private static final int LAYOUT_FRAGCOLLECTFZ = 8;
    private static final int LAYOUT_FRAGCOLLECTMYDATA = 12;
    private static final int LAYOUT_FRAGCOLLECTMYDATAFQ = 13;
    private static final int LAYOUT_FRAGCOLLECTOBJECT = 9;
    private static final int LAYOUT_FRAGCOLLECTSTYLESET = 14;
    private static final int LAYOUT_FRAGCOLLECTTYPE = 10;
    private static final int LAYOUT_FRAGCOUPONLIST = 15;
    private static final int LAYOUT_FRAGCOUPONLISTTG = 16;
    private static final int LAYOUT_FRAGHALLCARTLIST = 17;
    private static final int LAYOUT_FRAGHOME = 18;
    private static final int LAYOUT_FRAGLAYER = 19;
    private static final int LAYOUT_FRAGLOCALDATA = 20;
    private static final int LAYOUT_FRAGLOCALSET = 21;
    private static final int LAYOUT_FRAGLOCATEADD = 22;
    private static final int LAYOUT_FRAGLOCATERE = 23;
    private static final int LAYOUT_FRAGLOCATION = 24;
    private static final int LAYOUT_FRAGMINE = 25;
    private static final int LAYOUT_FRAGORDER = 26;
    private static final int LAYOUT_FRAGORDERDETAIL = 28;
    private static final int LAYOUT_FRAGORDERDETAILHOME = 29;
    private static final int LAYOUT_FRAGORDERDETAILLIST = 30;
    private static final int LAYOUT_FRAGORDERLIST2 = 27;
    private static final int LAYOUT_FRAGORDERSETTLE = 31;
    private static final int LAYOUT_FRAGPOINTCOLLECT = 32;
    private static final int LAYOUT_FRAGPOINTCOLLECTCOILED = 33;
    private static final int LAYOUT_FRAGPRODUCTLISTFRAG = 34;
    private static final int LAYOUT_FRAGRESEARCHERSTRACK = 35;
    private static final int LAYOUT_FRAGRESETPWD = 36;
    private static final int LAYOUT_FRAGSCANPLATE = 37;
    private static final int LAYOUT_FRAGSEARCHDATA = 38;
    private static final int LAYOUT_FRAGSTORE = 39;
    private static final int LAYOUT_FRAGTEXTLOGIN = 40;
    private static final int LAYOUT_ITEMCHECKTABLE = 41;
    private static final int LAYOUT_ITEMCHECKUI = 42;
    private static final int LAYOUT_ITEMCOLLECTDATA = 44;
    private static final int LAYOUT_ITEMCOLLECTRECORD = 43;
    private static final int LAYOUT_ITEMGROUPTYPE = 45;
    private static final int LAYOUT_ITEMLOCATEADD = 46;
    private static final int LAYOUT_ITEMMAINTAB = 47;
    private static final int LAYOUT_ITEMMAINTOP = 48;
    private static final int LAYOUT_ITEMORDERCOUPON = 49;
    private static final int LAYOUT_ITEMORDERCOUPON2 = 50;
    private static final int LAYOUT_ITEMORDERCOUPON3 = 51;
    private static final int LAYOUT_ITEMORDERDETAIL = 52;
    private static final int LAYOUT_ITEMORDERLIST = 54;
    private static final int LAYOUT_ITEMORDERSETTLE = 53;
    private static final int LAYOUT_ITEMPAYSTYLE = 55;
    private static final int LAYOUT_ITEMPICTURE = 56;
    private static final int LAYOUT_ITEMPOINTS = 57;
    private static final int LAYOUT_ITEMPOPUPSITE = 58;
    private static final int LAYOUT_ITEMPRODUCT = 59;
    private static final int LAYOUT_ITEMSCANPLATE = 60;
    private static final int LAYOUT_ITEMSEAT = 61;
    private static final int LAYOUT_ITEMTEXT48 = 62;
    private static final int LAYOUT_ITEMTEXT80 = 63;
    private static final int LAYOUT_ITEMTOBEDEAL = 64;
    private static final int LAYOUT_ITEMTODAYCOLLECT = 65;
    private static final int LAYOUT_POPUPDOUYINCOUPON = 66;
    private static final int LAYOUT_POPUPHALLCART = 67;
    private static final int LAYOUT_POPUPMAP = 68;
    private static final int LAYOUT_POPUPNUM = 69;
    private static final int LAYOUT_POPUPPAY = 70;
    private static final int LAYOUT_POPUPPAYDE = 71;
    private static final int LAYOUT_POPUPPAYXJ = 72;
    private static final int LAYOUT_POPUPSETTLEREMARK = 73;
    private static final int LAYOUT_POPUPSITE = 74;
    private static final int LAYOUT_REFRESHABLERV = 75;
    private static final int LAYOUT_SWIPEMENUITEM = 76;

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "builder");
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> map = new HashMap<>(DataBinderMapperImpl.LAYOUT_SWIPEMENUITEM);
            sKeys = map;
            map.put("layout/act_login_0", 2131492892);
            map.put("layout/act_main_0", 2131492893);
            map.put("layout/activity_mine_0", 2131492900);
            map.put("layout/frag_about_0", 2131492957);
            map.put("layout/frag_change_pwd_0", 2131492959);
            map.put("layout/frag_cloud_data_0", 2131492960);
            map.put("layout/frag_coiled_point_0", 2131492961);
            map.put("layout/frag_collect_fz_0", 2131492962);
            map.put("layout/frag_collect_object_0", 2131492963);
            map.put("layout/frag_collect_type_0", 2131492964);
            map.put("layout/frag_collectdata_0", 2131492965);
            map.put("layout/frag_collectmydata_0", 2131492966);
            map.put("layout/frag_collectmydata_fq_0", 2131492967);
            map.put("layout/frag_collectstyleset_0", 2131492968);
            map.put("layout/frag_couponlist_0", 2131492969);
            map.put("layout/frag_couponlist_tg_0", 2131492970);
            map.put("layout/frag_hallcartlist_0", 2131492972);
            map.put("layout/frag_home_0", 2131492973);
            map.put("layout/frag_layer_0", 2131492974);
            map.put("layout/frag_local_data_0", 2131492975);
            map.put("layout/frag_local_set_0", 2131492976);
            map.put("layout/frag_locate_add_0", 2131492977);
            map.put("layout/frag_locate_re_0", 2131492978);
            map.put("layout/frag_location_0", 2131492979);
            map.put("layout/frag_mine_0", 2131492980);
            map.put("layout/frag_order_0", 2131492981);
            map.put("layout/frag_order_list2_0", 2131492982);
            map.put("layout/frag_orderdetail_0", 2131492983);
            map.put("layout/frag_orderdetail_home_0", 2131492984);
            map.put("layout/frag_orderdetail_list_0", 2131492985);
            map.put("layout/frag_ordersettle_0", 2131492986);
            map.put("layout/frag_point_collect_0", 2131492987);
            map.put("layout/frag_point_collect_coiled_0", 2131492988);
            map.put("layout/frag_productlistfrag_0", 2131492989);
            map.put("layout/frag_researchers_track_0", 2131492990);
            map.put("layout/frag_reset_pwd_0", 2131492991);
            map.put("layout/frag_scanplate_0", 2131492992);
            map.put("layout/frag_search_data_0", 2131492993);
            map.put("layout/frag_store_0", 2131492994);
            map.put("layout/frag_text_login_0", 2131492995);
            map.put("layout/item_check_table_0", 2131493011);
            map.put("layout/item_check_ui_0", 2131493012);
            map.put("layout/item_collect_record_0", 2131493013);
            map.put("layout/item_collectdata_0", 2131493014);
            map.put("layout/item_grouptype_0", 2131493021);
            map.put("layout/item_locate_add_0", 2131493025);
            map.put("layout/item_main_tab_0", 2131493026);
            map.put("layout/item_main_top_0", 2131493027);
            map.put("layout/item_order_coupon_0", 2131493030);
            map.put("layout/item_order_coupon2_0", 2131493031);
            map.put("layout/item_order_coupon3_0", 2131493032);
            map.put("layout/item_order_detail_0", 2131493033);
            map.put("layout/item_order_settle_0", 2131493034);
            map.put("layout/item_orderlist_0", 2131493035);
            map.put("layout/item_pay_style_0", 2131493036);
            map.put("layout/item_picture_0", 2131493037);
            map.put("layout/item_points_0", 2131493038);
            map.put("layout/item_popup_site_0", 2131493039);
            map.put("layout/item_product_0", 2131493040);
            map.put("layout/item_scan_plate_0", 2131493042);
            map.put("layout/item_seat_0", 2131493043);
            map.put("layout/item_text_48_0", 2131493044);
            map.put("layout/item_text_80_0", 2131493045);
            map.put("layout/item_tobedeal_0", 2131493046);
            map.put("layout/item_today_collect_0", 2131493047);
            map.put("layout/popup_douyincoupon_0", 2131493082);
            map.put("layout/popup_hallcart_0", 2131493083);
            map.put("layout/popup_map_0", 2131493084);
            map.put("layout/popup_num_0", 2131493085);
            map.put("layout/popup_pay_0", 2131493086);
            map.put("layout/popup_pay_de_0", 2131493087);
            map.put("layout/popup_pay_xj_0", 2131493088);
            map.put("layout/popup_settleremark_0", 2131493089);
            map.put("layout/popup_site_0", 2131493090);
            map.put("layout/refreshable_rv_0", 2131493091);
            map.put("layout/swipe_menu_item_0", 2131493102);
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(LAYOUT_SWIPEMENUITEM);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(2131492892, 1);
        sparseIntArray.put(2131492893, 2);
        sparseIntArray.put(2131492900, 3);
        sparseIntArray.put(2131492957, 4);
        sparseIntArray.put(2131492959, 5);
        sparseIntArray.put(2131492960, 6);
        sparseIntArray.put(2131492961, 7);
        sparseIntArray.put(2131492962, 8);
        sparseIntArray.put(2131492963, 9);
        sparseIntArray.put(2131492964, LAYOUT_FRAGCOLLECTTYPE);
        sparseIntArray.put(2131492965, LAYOUT_FRAGCOLLECTDATA);
        sparseIntArray.put(2131492966, LAYOUT_FRAGCOLLECTMYDATA);
        sparseIntArray.put(2131492967, LAYOUT_FRAGCOLLECTMYDATAFQ);
        sparseIntArray.put(2131492968, LAYOUT_FRAGCOLLECTSTYLESET);
        sparseIntArray.put(2131492969, LAYOUT_FRAGCOUPONLIST);
        sparseIntArray.put(2131492970, 16);
        sparseIntArray.put(2131492972, 17);
        sparseIntArray.put(2131492973, LAYOUT_FRAGHOME);
        sparseIntArray.put(2131492974, LAYOUT_FRAGLAYER);
        sparseIntArray.put(2131492975, LAYOUT_FRAGLOCALDATA);
        sparseIntArray.put(2131492976, LAYOUT_FRAGLOCALSET);
        sparseIntArray.put(2131492977, LAYOUT_FRAGLOCATEADD);
        sparseIntArray.put(2131492978, LAYOUT_FRAGLOCATERE);
        sparseIntArray.put(2131492979, LAYOUT_FRAGLOCATION);
        sparseIntArray.put(2131492980, LAYOUT_FRAGMINE);
        sparseIntArray.put(2131492981, LAYOUT_FRAGORDER);
        sparseIntArray.put(2131492982, LAYOUT_FRAGORDERLIST2);
        sparseIntArray.put(2131492983, LAYOUT_FRAGORDERDETAIL);
        sparseIntArray.put(2131492984, LAYOUT_FRAGORDERDETAILHOME);
        sparseIntArray.put(2131492985, LAYOUT_FRAGORDERDETAILLIST);
        sparseIntArray.put(2131492986, LAYOUT_FRAGORDERSETTLE);
        sparseIntArray.put(2131492987, LAYOUT_FRAGPOINTCOLLECT);
        sparseIntArray.put(2131492988, LAYOUT_FRAGPOINTCOLLECTCOILED);
        sparseIntArray.put(2131492989, LAYOUT_FRAGPRODUCTLISTFRAG);
        sparseIntArray.put(2131492990, LAYOUT_FRAGRESEARCHERSTRACK);
        sparseIntArray.put(2131492991, LAYOUT_FRAGRESETPWD);
        sparseIntArray.put(2131492992, LAYOUT_FRAGSCANPLATE);
        sparseIntArray.put(2131492993, LAYOUT_FRAGSEARCHDATA);
        sparseIntArray.put(2131492994, LAYOUT_FRAGSTORE);
        sparseIntArray.put(2131492995, LAYOUT_FRAGTEXTLOGIN);
        sparseIntArray.put(2131493011, LAYOUT_ITEMCHECKTABLE);
        sparseIntArray.put(2131493012, LAYOUT_ITEMCHECKUI);
        sparseIntArray.put(2131493013, LAYOUT_ITEMCOLLECTRECORD);
        sparseIntArray.put(2131493014, LAYOUT_ITEMCOLLECTDATA);
        sparseIntArray.put(2131493021, LAYOUT_ITEMGROUPTYPE);
        sparseIntArray.put(2131493025, LAYOUT_ITEMLOCATEADD);
        sparseIntArray.put(2131493026, LAYOUT_ITEMMAINTAB);
        sparseIntArray.put(2131493027, LAYOUT_ITEMMAINTOP);
        sparseIntArray.put(2131493030, LAYOUT_ITEMORDERCOUPON);
        sparseIntArray.put(2131493031, LAYOUT_ITEMORDERCOUPON2);
        sparseIntArray.put(2131493032, LAYOUT_ITEMORDERCOUPON3);
        sparseIntArray.put(2131493033, LAYOUT_ITEMORDERDETAIL);
        sparseIntArray.put(2131493034, LAYOUT_ITEMORDERSETTLE);
        sparseIntArray.put(2131493035, LAYOUT_ITEMORDERLIST);
        sparseIntArray.put(2131493036, LAYOUT_ITEMPAYSTYLE);
        sparseIntArray.put(2131493037, LAYOUT_ITEMPICTURE);
        sparseIntArray.put(2131493038, LAYOUT_ITEMPOINTS);
        sparseIntArray.put(2131493039, LAYOUT_ITEMPOPUPSITE);
        sparseIntArray.put(2131493040, LAYOUT_ITEMPRODUCT);
        sparseIntArray.put(2131493042, 60);
        sparseIntArray.put(2131493043, LAYOUT_ITEMSEAT);
        sparseIntArray.put(2131493044, LAYOUT_ITEMTEXT48);
        sparseIntArray.put(2131493045, LAYOUT_ITEMTEXT80);
        sparseIntArray.put(2131493046, LAYOUT_ITEMTOBEDEAL);
        sparseIntArray.put(2131493047, LAYOUT_ITEMTODAYCOLLECT);
        sparseIntArray.put(2131493082, LAYOUT_POPUPDOUYINCOUPON);
        sparseIntArray.put(2131493083, LAYOUT_POPUPHALLCART);
        sparseIntArray.put(2131493084, LAYOUT_POPUPMAP);
        sparseIntArray.put(2131493085, LAYOUT_POPUPNUM);
        sparseIntArray.put(2131493086, LAYOUT_POPUPPAY);
        sparseIntArray.put(2131493087, LAYOUT_POPUPPAYDE);
        sparseIntArray.put(2131493088, LAYOUT_POPUPPAYXJ);
        sparseIntArray.put(2131493089, LAYOUT_POPUPSETTLEREMARK);
        sparseIntArray.put(2131493090, LAYOUT_POPUPSITE);
        sparseIntArray.put(2131493091, LAYOUT_REFRESHABLERV);
        sparseIntArray.put(2131493102, LAYOUT_SWIPEMENUITEM);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/act_login_0".equals(obj)) {
                    return new ActLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for act_login is invalid. Received: " + obj);
            case 2:
                if ("layout/act_main_0".equals(obj)) {
                    return new ActMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for act_main is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_mine_0".equals(obj)) {
                    return new ActivityMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_mine is invalid. Received: " + obj);
            case 4:
                if ("layout/frag_about_0".equals(obj)) {
                    return new FragAboutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_about is invalid. Received: " + obj);
            case 5:
                if ("layout/frag_change_pwd_0".equals(obj)) {
                    return new FragChangePwdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_change_pwd is invalid. Received: " + obj);
            case 6:
                if ("layout/frag_cloud_data_0".equals(obj)) {
                    return new FragCloudDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_cloud_data is invalid. Received: " + obj);
            case 7:
                if ("layout/frag_coiled_point_0".equals(obj)) {
                    return new FragCoiledPointBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_coiled_point is invalid. Received: " + obj);
            case 8:
                if ("layout/frag_collect_fz_0".equals(obj)) {
                    return new FragCollectFzBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collect_fz is invalid. Received: " + obj);
            case 9:
                if ("layout/frag_collect_object_0".equals(obj)) {
                    return new FragCollectObjectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collect_object is invalid. Received: " + obj);
            case LAYOUT_FRAGCOLLECTTYPE /* 10 */:
                if ("layout/frag_collect_type_0".equals(obj)) {
                    return new FragCollectTypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collect_type is invalid. Received: " + obj);
            case LAYOUT_FRAGCOLLECTDATA /* 11 */:
                if ("layout/frag_collectdata_0".equals(obj)) {
                    return new FragCollectdataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collectdata is invalid. Received: " + obj);
            case LAYOUT_FRAGCOLLECTMYDATA /* 12 */:
                if ("layout/frag_collectmydata_0".equals(obj)) {
                    return new FragCollectmydataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collectmydata is invalid. Received: " + obj);
            case LAYOUT_FRAGCOLLECTMYDATAFQ /* 13 */:
                if ("layout/frag_collectmydata_fq_0".equals(obj)) {
                    return new FragCollectmydataFqBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collectmydata_fq is invalid. Received: " + obj);
            case LAYOUT_FRAGCOLLECTSTYLESET /* 14 */:
                if ("layout/frag_collectstyleset_0".equals(obj)) {
                    return new FragCollectstylesetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_collectstyleset is invalid. Received: " + obj);
            case LAYOUT_FRAGCOUPONLIST /* 15 */:
                if ("layout/frag_couponlist_0".equals(obj)) {
                    return new FragCouponlistBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_couponlist is invalid. Received: " + obj);
            case 16:
                if ("layout/frag_couponlist_tg_0".equals(obj)) {
                    return new FragCouponlistTgBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_couponlist_tg is invalid. Received: " + obj);
            case 17:
                if ("layout/frag_hallcartlist_0".equals(obj)) {
                    return new FragHallcartlistBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_hallcartlist is invalid. Received: " + obj);
            case LAYOUT_FRAGHOME /* 18 */:
                if ("layout/frag_home_0".equals(obj)) {
                    return new FragHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_home is invalid. Received: " + obj);
            case LAYOUT_FRAGLAYER /* 19 */:
                if ("layout/frag_layer_0".equals(obj)) {
                    return new FragLayerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_layer is invalid. Received: " + obj);
            case LAYOUT_FRAGLOCALDATA /* 20 */:
                if ("layout/frag_local_data_0".equals(obj)) {
                    return new FragLocalDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_local_data is invalid. Received: " + obj);
            case LAYOUT_FRAGLOCALSET /* 21 */:
                if ("layout/frag_local_set_0".equals(obj)) {
                    return new FragLocalSetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_local_set is invalid. Received: " + obj);
            case LAYOUT_FRAGLOCATEADD /* 22 */:
                if ("layout/frag_locate_add_0".equals(obj)) {
                    return new FragLocateAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_locate_add is invalid. Received: " + obj);
            case LAYOUT_FRAGLOCATERE /* 23 */:
                if ("layout/frag_locate_re_0".equals(obj)) {
                    return new FragLocateReBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_locate_re is invalid. Received: " + obj);
            case LAYOUT_FRAGLOCATION /* 24 */:
                if ("layout/frag_location_0".equals(obj)) {
                    return new FragLocationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_location is invalid. Received: " + obj);
            case LAYOUT_FRAGMINE /* 25 */:
                if ("layout/frag_mine_0".equals(obj)) {
                    return new FragMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_mine is invalid. Received: " + obj);
            case LAYOUT_FRAGORDER /* 26 */:
                if ("layout/frag_order_0".equals(obj)) {
                    return new FragOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_order is invalid. Received: " + obj);
            case LAYOUT_FRAGORDERLIST2 /* 27 */:
                if ("layout/frag_order_list2_0".equals(obj)) {
                    return new FragOrderList2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_order_list2 is invalid. Received: " + obj);
            case LAYOUT_FRAGORDERDETAIL /* 28 */:
                if ("layout/frag_orderdetail_0".equals(obj)) {
                    return new FragOrderdetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_orderdetail is invalid. Received: " + obj);
            case LAYOUT_FRAGORDERDETAILHOME /* 29 */:
                if ("layout/frag_orderdetail_home_0".equals(obj)) {
                    return new FragOrderdetailHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_orderdetail_home is invalid. Received: " + obj);
            case LAYOUT_FRAGORDERDETAILLIST /* 30 */:
                if ("layout/frag_orderdetail_list_0".equals(obj)) {
                    return new FragOrderdetailListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_orderdetail_list is invalid. Received: " + obj);
            case LAYOUT_FRAGORDERSETTLE /* 31 */:
                if ("layout/frag_ordersettle_0".equals(obj)) {
                    return new FragOrdersettleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_ordersettle is invalid. Received: " + obj);
            case LAYOUT_FRAGPOINTCOLLECT /* 32 */:
                if ("layout/frag_point_collect_0".equals(obj)) {
                    return new FragPointCollectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_point_collect is invalid. Received: " + obj);
            case LAYOUT_FRAGPOINTCOLLECTCOILED /* 33 */:
                if ("layout/frag_point_collect_coiled_0".equals(obj)) {
                    return new FragPointCollectCoiledBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_point_collect_coiled is invalid. Received: " + obj);
            case LAYOUT_FRAGPRODUCTLISTFRAG /* 34 */:
                if ("layout/frag_productlistfrag_0".equals(obj)) {
                    return new FragProductlistfragBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_productlistfrag is invalid. Received: " + obj);
            case LAYOUT_FRAGRESEARCHERSTRACK /* 35 */:
                if ("layout/frag_researchers_track_0".equals(obj)) {
                    return new FragResearchersTrackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_researchers_track is invalid. Received: " + obj);
            case LAYOUT_FRAGRESETPWD /* 36 */:
                if ("layout/frag_reset_pwd_0".equals(obj)) {
                    return new FragResetPwdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_reset_pwd is invalid. Received: " + obj);
            case LAYOUT_FRAGSCANPLATE /* 37 */:
                if ("layout/frag_scanplate_0".equals(obj)) {
                    return new FragScanplateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_scanplate is invalid. Received: " + obj);
            case LAYOUT_FRAGSEARCHDATA /* 38 */:
                if ("layout/frag_search_data_0".equals(obj)) {
                    return new FragSearchDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_search_data is invalid. Received: " + obj);
            case LAYOUT_FRAGSTORE /* 39 */:
                if ("layout/frag_store_0".equals(obj)) {
                    return new FragStoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_store is invalid. Received: " + obj);
            case LAYOUT_FRAGTEXTLOGIN /* 40 */:
                if ("layout/frag_text_login_0".equals(obj)) {
                    return new FragTextLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for frag_text_login is invalid. Received: " + obj);
            case LAYOUT_ITEMCHECKTABLE /* 41 */:
                if ("layout/item_check_table_0".equals(obj)) {
                    return new ItemCheckTableBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_check_table is invalid. Received: " + obj);
            case LAYOUT_ITEMCHECKUI /* 42 */:
                if ("layout/item_check_ui_0".equals(obj)) {
                    return new ItemCheckUiBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_check_ui is invalid. Received: " + obj);
            case LAYOUT_ITEMCOLLECTRECORD /* 43 */:
                if ("layout/item_collect_record_0".equals(obj)) {
                    return new ItemCollectRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collect_record is invalid. Received: " + obj);
            case LAYOUT_ITEMCOLLECTDATA /* 44 */:
                if ("layout/item_collectdata_0".equals(obj)) {
                    return new ItemCollectdataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_collectdata is invalid. Received: " + obj);
            case LAYOUT_ITEMGROUPTYPE /* 45 */:
                if ("layout/item_grouptype_0".equals(obj)) {
                    return new ItemGrouptypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_grouptype is invalid. Received: " + obj);
            case LAYOUT_ITEMLOCATEADD /* 46 */:
                if ("layout/item_locate_add_0".equals(obj)) {
                    return new ItemLocateAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_locate_add is invalid. Received: " + obj);
            case LAYOUT_ITEMMAINTAB /* 47 */:
                if ("layout/item_main_tab_0".equals(obj)) {
                    return new ItemMainTabBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_tab is invalid. Received: " + obj);
            case LAYOUT_ITEMMAINTOP /* 48 */:
                if ("layout/item_main_top_0".equals(obj)) {
                    return new ItemMainTopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_main_top is invalid. Received: " + obj);
            case LAYOUT_ITEMORDERCOUPON /* 49 */:
                if ("layout/item_order_coupon_0".equals(obj)) {
                    return new ItemOrderCouponBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_coupon is invalid. Received: " + obj);
            case LAYOUT_ITEMORDERCOUPON2 /* 50 */:
                if ("layout/item_order_coupon2_0".equals(obj)) {
                    return new ItemOrderCoupon2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_coupon2 is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case LAYOUT_ITEMORDERCOUPON3 /* 51 */:
                if ("layout/item_order_coupon3_0".equals(obj)) {
                    return new ItemOrderCoupon3BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_coupon3 is invalid. Received: " + obj);
            case LAYOUT_ITEMORDERDETAIL /* 52 */:
                if ("layout/item_order_detail_0".equals(obj)) {
                    return new ItemOrderDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_detail is invalid. Received: " + obj);
            case LAYOUT_ITEMORDERSETTLE /* 53 */:
                if ("layout/item_order_settle_0".equals(obj)) {
                    return new ItemOrderSettleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_settle is invalid. Received: " + obj);
            case LAYOUT_ITEMORDERLIST /* 54 */:
                if ("layout/item_orderlist_0".equals(obj)) {
                    return new ItemOrderlistBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_orderlist is invalid. Received: " + obj);
            case LAYOUT_ITEMPAYSTYLE /* 55 */:
                if ("layout/item_pay_style_0".equals(obj)) {
                    return new ItemPayStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pay_style is invalid. Received: " + obj);
            case LAYOUT_ITEMPICTURE /* 56 */:
                if ("layout/item_picture_0".equals(obj)) {
                    return new ItemPictureBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_picture is invalid. Received: " + obj);
            case LAYOUT_ITEMPOINTS /* 57 */:
                if ("layout/item_points_0".equals(obj)) {
                    return new ItemPointsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_points is invalid. Received: " + obj);
            case LAYOUT_ITEMPOPUPSITE /* 58 */:
                if ("layout/item_popup_site_0".equals(obj)) {
                    return new ItemPopupSiteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_popup_site is invalid. Received: " + obj);
            case LAYOUT_ITEMPRODUCT /* 59 */:
                if ("layout/item_product_0".equals(obj)) {
                    return new ItemProductBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_product is invalid. Received: " + obj);
            case 60:
                if ("layout/item_scan_plate_0".equals(obj)) {
                    return new ItemScanPlateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_scan_plate is invalid. Received: " + obj);
            case LAYOUT_ITEMSEAT /* 61 */:
                if ("layout/item_seat_0".equals(obj)) {
                    return new ItemSeatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_seat is invalid. Received: " + obj);
            case LAYOUT_ITEMTEXT48 /* 62 */:
                if ("layout/item_text_48_0".equals(obj)) {
                    return new ItemText48BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_48 is invalid. Received: " + obj);
            case LAYOUT_ITEMTEXT80 /* 63 */:
                if ("layout/item_text_80_0".equals(obj)) {
                    return new ItemText80BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_text_80 is invalid. Received: " + obj);
            case LAYOUT_ITEMTOBEDEAL /* 64 */:
                if ("layout/item_tobedeal_0".equals(obj)) {
                    return new ItemTobedealBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_tobedeal is invalid. Received: " + obj);
            case LAYOUT_ITEMTODAYCOLLECT /* 65 */:
                if ("layout/item_today_collect_0".equals(obj)) {
                    return new ItemTodayCollectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_today_collect is invalid. Received: " + obj);
            case LAYOUT_POPUPDOUYINCOUPON /* 66 */:
                if ("layout/popup_douyincoupon_0".equals(obj)) {
                    return new PopupDouyincouponBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_douyincoupon is invalid. Received: " + obj);
            case LAYOUT_POPUPHALLCART /* 67 */:
                if ("layout/popup_hallcart_0".equals(obj)) {
                    return new PopupHallcartBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_hallcart is invalid. Received: " + obj);
            case LAYOUT_POPUPMAP /* 68 */:
                if ("layout/popup_map_0".equals(obj)) {
                    return new PopupMapBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_map is invalid. Received: " + obj);
            case LAYOUT_POPUPNUM /* 69 */:
                if ("layout/popup_num_0".equals(obj)) {
                    return new PopupNumBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_num is invalid. Received: " + obj);
            case LAYOUT_POPUPPAY /* 70 */:
                if ("layout/popup_pay_0".equals(obj)) {
                    return new PopupPayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_pay is invalid. Received: " + obj);
            case LAYOUT_POPUPPAYDE /* 71 */:
                if ("layout/popup_pay_de_0".equals(obj)) {
                    return new PopupPayDeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_pay_de is invalid. Received: " + obj);
            case LAYOUT_POPUPPAYXJ /* 72 */:
                if ("layout/popup_pay_xj_0".equals(obj)) {
                    return new PopupPayXjBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_pay_xj is invalid. Received: " + obj);
            case LAYOUT_POPUPSETTLEREMARK /* 73 */:
                if ("layout/popup_settleremark_0".equals(obj)) {
                    return new PopupSettleremarkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_settleremark is invalid. Received: " + obj);
            case LAYOUT_POPUPSITE /* 74 */:
                if ("layout/popup_site_0".equals(obj)) {
                    return new PopupSiteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_site is invalid. Received: " + obj);
            case LAYOUT_REFRESHABLERV /* 75 */:
                if ("layout/refreshable_rv_0".equals(obj)) {
                    return new RefreshableRvBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for refreshable_rv is invalid. Received: " + obj);
            case LAYOUT_SWIPEMENUITEM /* 76 */:
                if ("layout/swipe_menu_item_0".equals(obj)) {
                    return new SwipeMenuItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for swipe_menu_item is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.liuwq.base.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch ((i2 - 1) / LAYOUT_ITEMORDERCOUPON2) {
            case 0:
                return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
            case 1:
                return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
