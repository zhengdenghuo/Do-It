package com.collectpoint.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class GsonUtil {
    private static Gson gson;

    static {
        gson = null;
        gson = new Gson();
    }

    private GsonUtil() {
    }

    public static String GsonString(Object obj) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return gson2.toJson(obj);
        }
        return null;
    }

    public static <T> T GsonToBean(String str, Class<T> cls) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (T) gson2.fromJson(str, cls);
        }
        return null;
    }

    public static <T> List<T> GsonToList(String str, Class<T> cls) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (List) gson2.fromJson(str, new TypeToken<List<T>>() { // from class: com.collectpoint.utils.GsonUtil.1
            }.getType());
        }
        return null;
    }

    public static <T> List<Map<String, T>> GsonToListMaps(String str) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (List) gson2.fromJson(str, new TypeToken<List<Map<String, T>>>() { // from class: com.collectpoint.utils.GsonUtil.2
            }.getType());
        }
        return null;
    }

    public static <T> Map<String, T> GsonToMaps(String str) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (Map) gson2.fromJson(str, new TypeToken<Map<String, T>>() { // from class: com.collectpoint.utils.GsonUtil.3
            }.getType());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<T>] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List<T>] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static <T> List<T> jsonArrayToList(String str, List<T> list, Class<T> cls) {
        list = list;
        if (list == 0) {
            try {
                list = new ArrayList();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            ((List) list).add(GsonToBean(jSONArray.get(i).toString(), cls));
        }
        return (List<T>) list;
    }

    public static <T> T jsonToBean(String str, Class<T> cls) {
        try {
            return (T) gson.fromJson(str, cls);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> List<T> jsonToList(String str, Class<T> cls) {
        Gson gson2 = new Gson();
        ArrayList arrayList = new ArrayList();
        Iterator it = new JsonParser().parse(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(gson2.fromJson((JsonElement) it.next(), cls));
        }
        return arrayList;
    }
}
