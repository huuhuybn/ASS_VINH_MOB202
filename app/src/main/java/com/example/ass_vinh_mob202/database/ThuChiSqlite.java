package com.example.ass_vinh_mob202.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.ArrayList;
import java.util.List;

public class ThuChiSqlite extends SQLiteOpenHelper {

    public ThuChiSqlite(Context context) {
        super(context, "thuchi.db", null, 1);
        //dinh nghia ra truy van con tro truy van

    }

    public static final String tc_id = "id";
    public static final String ten = "ten";
    public static final String tien = "tien";
    public static final String thoiGian = "thoiGian";
    public static final String khoanThuChi = "khoanThuChi";
    public static final String loaiThuChi = "loaiThuChi";
    public static final String bangThuChi = "thuChi";


    public static final String taoBangThuChi = "create table thuChi ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " ten TEXT, tien FLOAT , thoiGian text , khoanThuChi TEXT ,loaiThuChi text)";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(taoBangThuChi);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long delThuChi(String id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long kq = sqLiteDatabase.delete(bangThuChi, tc_id + "=?",
                new String[]{id});
        sqLiteDatabase.close();

        return kq;
    }

    public long insertThuChi(ThuChi thuChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ten, thuChi.ten);
        contentValues.put(tien, thuChi.tien);
        contentValues.put(thoiGian, thuChi.thoiGian);
        contentValues.put(khoanThuChi, thuChi.khoanThuChi);
        contentValues.put(loaiThuChi, thuChi.loaiThuChi);
        long kq = sqLiteDatabase.insert(bangThuChi, null, contentValues);
        return kq;
    }

    public List<ThuChi> getAllThu() {
        List<ThuChi> thuChis = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + bangThuChi + " WHERE " + khoanThuChi + " =?";
        Cursor cursor = sqLiteDatabase.rawQuery(query, new String[]{"THU"});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ThuChi thuChi = new ThuChi();
            thuChi.tien = cursor.getFloat(cursor.getColumnIndex(tien));
            thuChi.loaiThuChi = cursor.getString(cursor.getColumnIndex(loaiThuChi));
            thuChi.khoanThuChi = cursor.getString(cursor.getColumnIndex(khoanThuChi));
            thuChi.thoiGian = cursor.getString(cursor.getColumnIndex(thoiGian));
            thuChi.ten = cursor.getString(cursor.getColumnIndex(ten));
            thuChi.id = cursor.getString(cursor.getColumnIndex(tc_id));
            thuChis.add(thuChi);
            cursor.moveToNext();
        }
        return thuChis;
    }

    ;

    public List<ThuChi> getAllChi() {
        List<ThuChi> thuChis = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + bangThuChi + " WHERE " + khoanThuChi + " =?";
        Cursor cursor = sqLiteDatabase.rawQuery(query, new String[]{"CHI"});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ThuChi thuChi = new ThuChi();
            thuChi.tien = cursor.getFloat(cursor.getColumnIndex(tien));
            thuChi.loaiThuChi = cursor.getString(cursor.getColumnIndex(loaiThuChi));
            thuChi.khoanThuChi = cursor.getString(cursor.getColumnIndex(khoanThuChi));
            thuChi.thoiGian = cursor.getString(cursor.getColumnIndex(thoiGian));
            thuChi.ten = cursor.getString(cursor.getColumnIndex(ten));
            thuChi.id = cursor.getString(cursor.getColumnIndex(tc_id));
            thuChis.add(thuChi);
            cursor.moveToNext();
        }
        return thuChis;
    }

    public int updateThuChi(ThuChi thuChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ten, thuChi.ten);
        contentValues.put(tien, thuChi.tien);
        contentValues.put(thoiGian, thuChi.thoiGian);
        contentValues.put(khoanThuChi, thuChi.khoanThuChi);
        contentValues.put(loaiThuChi, thuChi.loaiThuChi);
        int kq = sqLiteDatabase.update(bangThuChi, contentValues, tc_id + "=?", new String[]{thuChi.id + ""});
        return kq;
    }
}