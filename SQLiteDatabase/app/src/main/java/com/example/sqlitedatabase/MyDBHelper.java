package com.example.sqlitedatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDB.db";

    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE_NO = "phone_number";

    public MyDBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table contacts ( id integer primary key, name text, phone_number text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists contacts");
        onCreate(sqLiteDatabase);
    }
    public boolean insertContact(String name, String phoneNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_PHONE_NO,phoneNumber);

        db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    @SuppressLint("Range")
    public ArrayList<String> getData(int id)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from contacts where id = "+id+" ",null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false)
        {
            arrayList.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            arrayList.add(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NO)));

            cursor.moveToNext();
        }

        return arrayList;
    }

    public boolean updateContact(int id,String name, String phone_number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_PHONE_NO,phone_number);


        db.update(TABLE_NAME,contentValues,"id = ?",new String[]{Integer.toString(id)});
        return true;
    }

    public boolean deleteContact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,"id = ?",new String[]{Integer.toString(id)});

        return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from contacts",null);

        return cursor;
    }

    @SuppressLint("Range")
    public ArrayList getAllContactsId()
    {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from contacts ",null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false)
        {
            arrayList.add(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
            cursor.moveToNext();
        }

        return arrayList;
    }
}
