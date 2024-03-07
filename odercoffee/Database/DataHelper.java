package com.example.odercoffee.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "OrderCoffee.db";
    private static final int VERSION = 1;

    // BẢNG 1: NGƯỜI DÙNG
    private static final String TABLE1 = "NguoiDung";
    private static final String COLUMN1_T1 = "user";
    private static final String COLUMN1_T2 = "email";
    private static final String COLUMN1_T3 = "sdt";
    private static final String COLUMN1_T4 = "pass";

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tblND = "CREATE TABLE " + TABLE1 + "(" +
                COLUMN1_T1 + " TEXT PRIMARY KEY," +
                COLUMN1_T2 + " TEXT," +
                COLUMN1_T3 + " TEXT," +
                COLUMN1_T4 + " TEXT" +
                ")";
        db.execSQL(tblND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String droptbl1 = "DROP TABLE IF EXISTS " + TABLE1;
        db.execSQL(droptbl1);
        onCreate(db);
    }

    public boolean insertData(String user, String email, String sdt, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN1_T1, user);
        values.put(COLUMN1_T2, email);
        values.put(COLUMN1_T3, sdt);
        values.put(COLUMN1_T4, pass);
        long result = db.insert(TABLE1, null, values);
        return (result != -1);
    }

    public boolean checkLogin(String tenDN, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { COLUMN1_T1 };
        String selection = COLUMN1_T1 + " = ?" + " AND " + COLUMN1_T2 + " = ?";
        String[] selectionArgs = { tenDN, pass };

        Cursor cursor = db.query(TABLE1, columns, selection, selectionArgs,
                null, null, null);

        int count = cursor.getCount();
        cursor.close();

        return (count > 0);
    }
}
