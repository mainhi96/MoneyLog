package com.example.sony.mainhi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SONY on 4/6/2018.
 */

public class MoneyLogDAO {
    private static MoneyLogDAO moneyLogDAO=null;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public MoneyLogDAO(Context context){
        dbHelper= new DBHelper(context,DBHelper.DATABASE_NAME,null,DBHelper.DATBASE_VERSION);
        db= dbHelper.getWritableDatabase();
    }
    public static MoneyLogDAO getInstance(Context context){
        if (moneyLogDAO==null){
            moneyLogDAO= new MoneyLogDAO(context);
        }
        return moneyLogDAO;

    }

    public long insert(MoneyLog... moneyLogs){
        int count=0;
        ContentValues contentValues= new ContentValues();
        for (MoneyLog moneyLog:moneyLogs){
            contentValues.clear();
            contentValues.put(DBHelper.MONEYLOG_CONTENT,moneyLog.getContent());
            contentValues.put(DBHelper.MONEYLOG_AMOUNT,moneyLog.getAmount());
            contentValues.put(DBHelper.MONEYLOG_NOTE,moneyLog.getNote());
            if (db.insert(DBHelper.MONEYLOG_TABLENAME,null,contentValues)!=-1) count++;
        }
        return count;
    }
  /*  public long update(MoneyLog... moneyLogs){
        int count=0;
        ContentValues contentValues= new ContentValues();
        for (MoneyLog moneyLog:moneyLogs){
            contentValues.clear();
            contentValues.put(DBHelper.MONEYLOG_CONTENT,moneyLog.getContent());
            contentValues.put(DBHelper.MONEYLOG_AMOUNT,moneyLog.getAmount());
            contentValues.put(DBHelper.MONEYLOG_NOTE,moneyLog.getNote());
            count+=db.update(DBHelper.MONEYLOG_TABLENAME,contentValues,DBHelper.MONEYLOG_ID+"=?",new String[]{moneyLog.getId()+""});


        }
        return count;
    }*/
    public List<MoneyLog> query(){
        List<MoneyLog> moneyLogs= new ArrayList<>();
        Cursor cursor= db.query(DBHelper.MONEYLOG_TABLENAME,new String[]{DBHelper.MONEYLOG_ID,DBHelper.MONEYLOG_CONTENT,DBHelper.MONEYLOG_AMOUNT,DBHelper.MONEYLOG_NOTE},null,null,null,null,null);
        while (cursor.moveToNext()){
            String ccontent= cursor.getString(cursor.getColumnIndex(DBHelper.MONEYLOG_CONTENT));
            int camount= (int) cursor.getInt(cursor.getColumnIndex(DBHelper.MONEYLOG_AMOUNT));
            String ccategory= cursor.getString(cursor.getColumnIndex(DBHelper.MONEYLOG_CATEGORY));
            String cnote =cursor.getString(cursor.getColumnIndex(DBHelper.MONEYLOG_NOTE));
            String cdate =(String) cursor.getString(cursor.getColumnIndex(DBHelper.MONEYLOG_DATE));

            moneyLogs.add(new MoneyLog(camount,ccontent,ccategory,cdate,cnote));
        }
        return moneyLogs;
    }

}
