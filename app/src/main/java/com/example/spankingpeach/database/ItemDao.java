package com.example.spankingpeach.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hiroki on 2014/09/26.
 */
public class ItemDao implements Dao {
    private SQLiteDatabase mDb;
    private static final String TABLE_NAME = "item";
    private static final String COLUMN_ID = "_id";
    private static final String WHERE = "_id=";
    private static final String[] COLUMNS = {"_id","name","icon","animation"};
    public ItemDao(SQLiteDatabase db) {
        mDb  = db;
    }

    @Override
    public Cursor getCursor(int id) {
        Cursor cursor = mDb.query(
                TABLE_NAME,
                COLUMNS,
                WHERE + id,
                null,
                null,
                null,
                COLUMN_ID
        );
        return cursor;
    }
    @Override
    public void dbClose(){
        mDb.close();
    }
}
