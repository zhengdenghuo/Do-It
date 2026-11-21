package com.collectpoint.utils.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.collectpoint.bean.item.CollectionTodaItem;
import com.collectpoint.bean.res.InsertPointInfoRes;
import com.collectpoint.utils.CacheUtils;
import com.collectpoint.utils.EmptyUtils;
import com.collectpoint.utils.GsonUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class PointFqDBDao {
    public static final String POINT_ADDRESS = "address";
    public static final String POINT_ID = "point_id";
    public static final String POINT_ISGOING = "isgoing";
    public static final String POINT_JSON = "jsons";
    public static final String POINT_NAME = "name";
    public static final String POINT_NUM = "num";
    public static final String POINT_TIME = "collection_time";
    public static final String POINT_TITLE = "title";
    public static final String POINT_TYPE = "collectionType";
    public static final String POINT_USERCODE = "usercode";
    public static final String TABLE_NAME = "PointFq";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public PointFqDBDao(Context context) {
        this.mContext = context;
    }

    public int deleSq(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.delete(TABLE_NAME, "collection_time = ?", new String[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insertData(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(POINT_TIME, str);
        contentValues.put(POINT_USERCODE, CacheUtils.getInstance().getUserBean().getUserCode());
        contentValues.put(POINT_JSON, str3);
        contentValues.put(POINT_TYPE, str2);
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void insertData(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(POINT_TIME, str2);
        contentValues.put(POINT_USERCODE, CacheUtils.getInstance().getUserBean().getUserCode());
        contentValues.put(POINT_JSON, str4);
        contentValues.put(POINT_TYPE, str3);
        contentValues.put(POINT_ISGOING, str);
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public boolean isToday(long j) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public List<CollectionTodaItem> query() {
        if (this.mDatabase == null || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean()) || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean().getUserCode())) {
            return null;
        }
        ArrayList arrayList = null;
        Cursor cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM PointFq WHERE usercode=?  ORDER BY collection_time ASC", new String[]{CacheUtils.getInstance().getUserBean().getUserCode()}, null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TYPE));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_JSON));
                CollectionTodaItem collectionTodaItem = new CollectionTodaItem();
                if (EmptyUtils.isNotEmpty(string2)) {
                    InsertPointInfoRes insertPointInfoRes = (InsertPointInfoRes) GsonUtil.jsonToBean(string2, InsertPointInfoRes.class);
                    collectionTodaItem.setCollectionTime(insertPointInfoRes.getCollectionTime());
                    collectionTodaItem.setAddress(insertPointInfoRes.getAddress());
                    collectionTodaItem.setLatitude(insertPointInfoRes.getLatitude());
                    collectionTodaItem.setLongitude(insertPointInfoRes.getLongitude());
                    collectionTodaItem.setCollectionPointName(insertPointInfoRes.getCollectionPointName());
                    collectionTodaItem.setCollectionCode(insertPointInfoRes.getCollectionCode());
                    collectionTodaItem.setProjectCollectionCode(insertPointInfoRes.getProjectCollectionCode());
                    collectionTodaItem.setAppMapIcon(insertPointInfoRes.getAppMapIcon());
                    collectionTodaItem.setRecordCode(insertPointInfoRes.getRecordCode());
                    collectionTodaItem.setCollectionType(string);
                    collectionTodaItem.setCollectionName(insertPointInfoRes.getCollectionName());
                    collectionTodaItem.setFirstCollectionCode(insertPointInfoRes.getFirstCollectionCode());
                    collectionTodaItem.setFirstCollectionName(insertPointInfoRes.getFirstCollectionName());
                    collectionTodaItem.setPointList(insertPointInfoRes.getPointList());
                    collectionTodaItem.setFieldList(insertPointInfoRes.getFieldList());
                    arrayList.add(collectionTodaItem);
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public List<CollectionTodaItem> queryIsGoing(String str) {
        if (this.mDatabase == null || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean()) || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean().getUserCode())) {
            return null;
        }
        ArrayList arrayList = null;
        Cursor cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM PointFq WHERE usercode=? and isgoing=? ", new String[]{CacheUtils.getInstance().getUserBean().getUserCode(), "1"}, null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TYPE));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TIME));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_JSON));
                CollectionTodaItem collectionTodaItem = new CollectionTodaItem();
                if (EmptyUtils.isNotEmpty(string3)) {
                    InsertPointInfoRes insertPointInfoRes = (InsertPointInfoRes) GsonUtil.jsonToBean(string3, InsertPointInfoRes.class);
                    if (TextUtils.equals(str, insertPointInfoRes.getProjectOrgCode())) {
                        collectionTodaItem.setCollectionTime(string2);
                        collectionTodaItem.setProjectOrgCode(insertPointInfoRes.getProjectOrgCode());
                        collectionTodaItem.setAddress(insertPointInfoRes.getAddress());
                        collectionTodaItem.setLatitude(insertPointInfoRes.getLatitude());
                        collectionTodaItem.setLongitude(insertPointInfoRes.getLongitude());
                        collectionTodaItem.setCollectionPointName(insertPointInfoRes.getCollectionPointName());
                        collectionTodaItem.setCollectionCode(insertPointInfoRes.getCollectionCode());
                        collectionTodaItem.setCollectionName(insertPointInfoRes.getCollectionName());
                        collectionTodaItem.setProjectCollectionCode(insertPointInfoRes.getProjectCollectionCode());
                        collectionTodaItem.setAppMapIcon(insertPointInfoRes.getAppMapIcon());
                        collectionTodaItem.setRecordCode(insertPointInfoRes.getRecordCode());
                        collectionTodaItem.setCollectionType(string);
                        collectionTodaItem.setFirstCollectionCode(insertPointInfoRes.getFirstCollectionCode());
                        collectionTodaItem.setFirstCollectionName(insertPointInfoRes.getFirstCollectionName());
                        collectionTodaItem.setPointList(insertPointInfoRes.getPointList());
                        collectionTodaItem.setIsGoing("1");
                        collectionTodaItem.setFieldList(insertPointInfoRes.getFieldList());
                        arrayList.add(collectionTodaItem);
                    }
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public List<CollectionTodaItem> querySearch(String str) {
        if (this.mDatabase == null || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean()) || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean().getUserCode())) {
            return null;
        }
        ArrayList arrayList = null;
        Cursor cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM PointFq WHERE usercode=?  ORDER BY collection_time ASC", new String[]{CacheUtils.getInstance().getUserBean().getUserCode()}, null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TYPE));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_JSON));
                CollectionTodaItem collectionTodaItem = new CollectionTodaItem();
                if (EmptyUtils.isNotEmpty(string2) && (EmptyUtils.isEmpty(str) || string2.contains(str))) {
                    InsertPointInfoRes insertPointInfoRes = (InsertPointInfoRes) GsonUtil.jsonToBean(string2, InsertPointInfoRes.class);
                    collectionTodaItem.setCollectionTime(insertPointInfoRes.getCollectionTime());
                    collectionTodaItem.setAddress(insertPointInfoRes.getAddress());
                    collectionTodaItem.setLatitude(insertPointInfoRes.getLatitude());
                    collectionTodaItem.setLongitude(insertPointInfoRes.getLongitude());
                    collectionTodaItem.setCollectionPointName(insertPointInfoRes.getCollectionPointName());
                    collectionTodaItem.setCollectionCode(insertPointInfoRes.getCollectionCode());
                    collectionTodaItem.setCollectionName(insertPointInfoRes.getCollectionName());
                    collectionTodaItem.setProjectCollectionCode(insertPointInfoRes.getProjectCollectionCode());
                    collectionTodaItem.setAppMapIcon(insertPointInfoRes.getAppMapIcon());
                    collectionTodaItem.setRecordCode(insertPointInfoRes.getRecordCode());
                    collectionTodaItem.setCollectionType(string);
                    collectionTodaItem.setFirstCollectionCode(insertPointInfoRes.getFirstCollectionCode());
                    collectionTodaItem.setFirstCollectionName(insertPointInfoRes.getFirstCollectionName());
                    collectionTodaItem.setPointList(insertPointInfoRes.getPointList());
                    collectionTodaItem.setFieldList(insertPointInfoRes.getFieldList());
                    arrayList.add(collectionTodaItem);
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public InsertPointInfoRes queryT(String str) {
        Cursor cursorRawQuery;
        if (this.mDatabase != null && !EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean()) && !EmptyUtils.isEmpty(str) && !EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean().getUserCode()) && (cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM PointFq WHERE usercode=? and collection_time=? ", new String[]{CacheUtils.getInstance().getUserBean().getUserCode(), str}, null)) != null && cursorRawQuery.getCount() > 0) {
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_JSON));
                if (EmptyUtils.isNotEmpty(string)) {
                    InsertPointInfoRes insertPointInfoRes = (InsertPointInfoRes) GsonUtil.jsonToBean(string, InsertPointInfoRes.class);
                    cursorRawQuery.close();
                    return insertPointInfoRes;
                }
            }
            cursorRawQuery.close();
        }
        return null;
    }

    public List<CollectionTodaItem> queryTodayData(String str) {
        if (this.mDatabase == null || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean()) || EmptyUtils.isEmpty(CacheUtils.getInstance().getUserBean().getUserCode())) {
            return null;
        }
        ArrayList arrayList = null;
        Cursor cursorRawQuery = this.mDatabase.rawQuery("SELECT * FROM PointFq WHERE usercode=?", new String[]{CacheUtils.getInstance().getUserBean().getUserCode()}, null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TYPE));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_TIME));
                if (isToday(Long.parseLong(string2))) {
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(POINT_JSON));
                    CollectionTodaItem collectionTodaItem = new CollectionTodaItem();
                    if (EmptyUtils.isNotEmpty(string3)) {
                        InsertPointInfoRes insertPointInfoRes = (InsertPointInfoRes) GsonUtil.jsonToBean(string3, InsertPointInfoRes.class);
                        if (TextUtils.equals(insertPointInfoRes.getFirstCollectionCode(), str)) {
                            collectionTodaItem.setCollectionTime(string2);
                            collectionTodaItem.setAddress(insertPointInfoRes.getAddress());
                            collectionTodaItem.setLatitude(insertPointInfoRes.getLatitude());
                            collectionTodaItem.setLongitude(insertPointInfoRes.getLongitude());
                            collectionTodaItem.setCollectionPointName(insertPointInfoRes.getCollectionPointName());
                            collectionTodaItem.setProjectCollectionCode(insertPointInfoRes.getProjectCollectionCode());
                            collectionTodaItem.setAppMapIcon(insertPointInfoRes.getAppMapIcon());
                            collectionTodaItem.setRecordCode(insertPointInfoRes.getRecordCode());
                            collectionTodaItem.setCollectionType(string);
                            collectionTodaItem.setCollectionCode(insertPointInfoRes.getCollectionCode());
                            collectionTodaItem.setCollectionName(insertPointInfoRes.getCollectionName());
                            collectionTodaItem.setFirstCollectionCode(insertPointInfoRes.getFirstCollectionCode());
                            collectionTodaItem.setFirstCollectionName(insertPointInfoRes.getFirstCollectionName());
                            collectionTodaItem.setPointList(insertPointInfoRes.getPointList());
                            collectionTodaItem.setIsGoing("1");
                            collectionTodaItem.setFieldList(insertPointInfoRes.getFieldList());
                            arrayList.add(collectionTodaItem);
                        }
                    }
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public void setDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }
}
