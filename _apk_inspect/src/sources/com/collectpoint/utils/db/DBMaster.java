package com.collectpoint.utils.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.collectorder.utils.db.OrderDBDao;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes5.dex */
public class DBMaster {
    public static final String DATABASE_NAME = "order.db";
    public static int DATABASE_VERSION = 1;
    private static final String sql_point_table = "CREATE TABLE IF NOT EXISTS Order2 (point_id integer primary key autoincrement,order_content varchar(9999),order_id varchar(100))";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private DBOpenHelper mDbOpenHelper;
    public OrderDBDao orderDBDao;

    public static class DBOpenHelper extends SQLiteOpenHelper {
        public DBOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(DBMaster.sql_point_table);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public DBMaster(Context context) {
        this.mContext = context;
        this.orderDBDao = new OrderDBDao(this.mContext);
    }

    public void closeDataBase() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public void openDataBase() {
        DBOpenHelper dBOpenHelper = new DBOpenHelper(this.mContext, DATABASE_NAME, null, DATABASE_VERSION);
        this.mDbOpenHelper = dBOpenHelper;
        try {
            this.mDatabase = dBOpenHelper.getWritableDatabase();
        } catch (SQLException e) {
            this.mDatabase = this.mDbOpenHelper.getReadableDatabase();
        }
        this.orderDBDao.setDatabase(this.mDatabase);
    }
}
