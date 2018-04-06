package com.example.sony.mainhi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SONY on 4/6/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    private Context context;//ngữ cảnh
    private String name; //tên bảng
    private int version;

    public static String DATABASE_NAME = "MoneyManagement.db";
    public static int DATBASE_VERSION = 1;

    public String getName() {
        return name;
    }

    public static String MONEYLOG_TABLENAME= "MoneyLog";

    public static String MONEYLOG_ID ="id";
    public static String MONEYLOG_CONTENT ="content";
    public static String MONEYLOG_AMOUNT="amount";
    public static String MONEYLOG_NOTE ="note";
    public static String MONEYLOG_CATEGORY ="category";
    public static String MONEYLOG_DATE ="date";


    public static String MONEYLOG_CREATETABLE= "CREATE TABLE "+ MONEYLOG_TABLENAME +"("+ MONEYLOG_ID+" INTEGER PRIMARY KEY,"
            + MONEYLOG_CONTENT + " TEXT,"
            + MONEYLOG_CATEGORY + " TEXT,"
            + MONEYLOG_DATE+ " TEXT"
            + MONEYLOG_AMOUNT +" INTEGER,"
            + MONEYLOG_NOTE+ " TEXT)";




    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MONEYLOG_CREATETABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
