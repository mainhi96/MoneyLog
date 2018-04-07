package com.example.sony.mainhi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SONY on 4/6/2018.
 */

public class DBHelper extends SQLiteOpenHelper {


    public static String DATABASE_NAME = "MoneyManagement.db";
    public static int DATABASE_VERSION = 1;


    public static String MONEYLOG_TABLENAME= "MoneyLog";

    public static String MONEYLOG_ID ="id";
    public static String MONEYLOG_CONTENT ="content";
    public static String MONEYLOG_AMOUNT="amount";
    public static String MONEYLOG_NOTE ="note";
    public static String MONEYLOG_CATEGORY ="category";
    public static String MONEYLOG_DATE ="date";

    public static final String CREATE_TABLE_HOCVIEN = "CREATE TABLE "+MONEYLOG_TABLENAME+"(\n" +
            MONEYLOG_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            MONEYLOG_CONTENT+" TEXT NOT NULL,\n" +
            MONEYLOG_DATE+" TEXT,\n" +
            MONEYLOG_NOTE+" TEXT,\n" +
            MONEYLOG_AMOUNT+" DOUBLE NOT NULL);";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HOCVIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public SQLiteDatabase OpenDatabase(){
        return getWritableDatabase();
    }
    public void CloseDatabase(){
        close();
    }
}


  /*  public static String MONEYLOG_CREATETABLE= "CREATE TABLE "+ MONEYLOG_TABLENAME +"("+ MONEYLOG_ID+" INTEGER PRIMARY KEY,"
            + MONEYLOG_CONTENT + " TEXT,"
            + MONEYLOG_CATEGORY + " TEXT,"
            + MONEYLOG_DATE+ " TEXT"
            + MONEYLOG_AMOUNT +" INTEGER,"
            + MONEYLOG_NOTE+ " TEXT)";

    public SQLiteDatabase OpenDatabase(){
        return getWritableDatabase();
    }
    public void CloseDatabase(){
        close();
    }


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MONEYLOG_CREATETABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }*/

