package com.chenenyu.router.apt;

import com.chenenyu.router.RouteInterceptor;
import com.chenenyu.router.template.InterceptorTable;
import com.collectpoint.moudle.login.LoginInterceptor;
import java.util.Map;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes8.dex */
public class AppInterceptorTable implements InterceptorTable {
    public void handle(Map<String, Class<? extends RouteInterceptor>> map) {
        map.put("LoginInterceptor", LoginInterceptor.class);
    }
}
