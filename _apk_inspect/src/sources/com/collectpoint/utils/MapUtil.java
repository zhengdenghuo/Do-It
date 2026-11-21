package com.collectpoint.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.io.File;
import java.text.DecimalFormat;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class MapUtil {
    public static final String PN_BAIDU_MAP = "com.baidu.BaiduMap";
    public static final String PN_GAODE_MAP = "com.autonavi.minimap";
    public static final String PN_TENCENT_MAP = "com.tencent.map";

    public static double[] bdToGaoDe(double d, double d2) {
        double d3 = d2 - 0.0065d;
        double d4 = d - 0.006d;
        double dSqrt = Math.sqrt((d3 * d3) + (d4 * d4)) - (Math.sin(d4 * 52.35987755982988d) * 2.0E-5d);
        double dAtan2 = Math.atan2(d4, d3) - (Math.cos(d3 * 52.35987755982988d) * 3.0E-6d);
        return new double[]{Math.cos(dAtan2) * dSqrt, Math.sin(dAtan2) * dSqrt};
    }

    private static double[] gaoDeToBaidu(double d, double d2) {
        double dSqrt = Math.sqrt((d * d) + (d2 * d2)) + (Math.sin(d2 * 52.35987755982988d) * 2.0E-5d);
        double dAtan2 = Math.atan2(d2, d) + (Math.cos(d * 52.35987755982988d) * 3.0E-6d);
        return new double[]{(Math.cos(dAtan2) * dSqrt) + 0.0065d, (Math.sin(dAtan2) * dSqrt) + 0.006d};
    }

    public static double getMapDis(double d, double d2, double d3, double d4) {
        return getMapDis(new LatLng(d, d2), new LatLng(d3, d4));
    }

    public static double getMapDis(LatLng latLng, LatLng latLng2) {
        return AMapUtils.calculateLineDistance(latLng, latLng2) / 1000.0f;
    }

    public static String getMapDistp(LatLng latLng, LatLng latLng2) {
        double mapDis = getMapDis(latLng, latLng2);
        try {
            return new DecimalFormat("####.##").format(mapDis);
        } catch (Exception e) {
            return mapDis + "";
        }
    }

    public static boolean isBaiduMapInstalled() {
        return isInstallPackage(PN_BAIDU_MAP);
    }

    public static boolean isGdMapInstalled() {
        return isInstallPackage(PN_GAODE_MAP);
    }

    private static boolean isInstallPackage(String str) {
        return new File("/data/data/" + str).exists();
    }

    public static boolean isTencentMapInstalled() {
        return isInstallPackage(PN_TENCENT_MAP);
    }

    public static void openBaiDuNavi(Context context, double d, double d2, String str, double d3, double d4, String str2) {
        double[] dArrGaoDeToBaidu = gaoDeToBaidu(d3, d4);
        double d5 = dArrGaoDeToBaidu[0];
        double d6 = dArrGaoDeToBaidu[1];
        StringBuilder sb = new StringBuilder("baidumap://map/direction?mode=driving&");
        if (d != 0.0d) {
            double[] dArrGaoDeToBaidu2 = gaoDeToBaidu(d, d2);
            double d7 = dArrGaoDeToBaidu2[0];
            sb.append("origin=latlng:").append(d7).append(",").append(dArrGaoDeToBaidu2[1]).append("|name:").append(str);
        }
        sb.append("&destination=latlng:").append(d5).append(",").append(d6).append("|name:").append(str2);
        String string = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(PN_BAIDU_MAP);
        intent.setData(Uri.parse(string));
        context.startActivity(intent);
    }

    public static void openGaoDeNavi(Context context, double d, double d2, String str, double d3, double d4, String str2) {
        StringBuilder sb = new StringBuilder("amapuri://route/plan?sourceApplication=maxuslife");
        if (d != 0.0d) {
            sb.append("&sname=").append(str).append("&slat=").append(d).append("&slon=").append(d2);
        }
        sb.append("&dlat=").append(d3).append("&dlon=").append(d4).append("&dname=").append(str2).append("&dev=0").append("&t=0");
        String string = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(PN_GAODE_MAP);
        intent.setData(Uri.parse(string));
        context.startActivity(intent);
    }

    public static void openTencentMap(Context context, double d, double d2, String str, double d3, double d4, String str2) {
        StringBuilder sb = new StringBuilder("qqmap://map/routeplan?type=drive&policy=0&referer=zhongshuo");
        if (d != 0.0d) {
            sb.append("&from=").append(str).append("&fromcoord=").append(d).append(",").append(d2);
        }
        sb.append("&to=").append(str2).append("&tocoord=").append(d3).append(",").append(d4);
        String string = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(PN_TENCENT_MAP);
        intent.setData(Uri.parse(string));
        context.startActivity(intent);
    }
}
