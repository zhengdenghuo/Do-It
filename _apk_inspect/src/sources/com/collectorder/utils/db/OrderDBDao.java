package com.collectorder.utils.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.collectpoint.bean.req.OrderCacheReq;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.GsonUtil;
import com.google.gson.Gson;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes9.dex */
public class OrderDBDao {
    public static final String ORDER_CONTENT = "order_content";
    public static final String ORDER_ID = "order_id";
    public static final String POINT_ID = "point_id";
    public static final String TABLE_NAME = "Order2";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public OrderDBDao(Context context) {
        this.mContext = context;
    }

    public int deleSq(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.delete(TABLE_NAME, "order_id = ?", new String[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleSqCode(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.delete(TABLE_NAME, "order_id = ?", new String[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insertData(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_CONTENT, str2);
        contentValues.put(ORDER_ID, str);
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public OrderCacheReq queryT(String str) {
        Cursor cursorRawQuery;
        if (this.mDatabase != null && !EmptyUtils.isEmpty(str) && (cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM Order2 WHERE order_id=? ", new String[]{str}, null)) != null && cursorRawQuery.getCount() > 0) {
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ORDER_CONTENT));
                if (EmptyUtils.isNotEmpty(string)) {
                    OrderCacheReq orderCacheReq = (OrderCacheReq) GsonUtil.jsonToBean(string, OrderCacheReq.class);
                    cursorRawQuery.close();
                    return orderCacheReq;
                }
            }
            cursorRawQuery.close();
        }
        return null;
    }

    public void setDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    public int updata(String str, String str2) {
        if (this.mDatabase == null) {
            return 0;
        }
        OrderCacheReq orderCacheReqQueryT = queryT(str);
        if (EmptyUtils.isEmpty(orderCacheReqQueryT)) {
            insertData(str, str2);
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        orderCacheReqQueryT.setContent(str2);
        contentValues.put(ORDER_CONTENT, new Gson().toJson(orderCacheReqQueryT));
        int iUpdate = this.mDatabase.update(TABLE_NAME, contentValues, "order_id=?", new String[]{str});
        System.out.println("__");
        return iUpdate;
    }
}
