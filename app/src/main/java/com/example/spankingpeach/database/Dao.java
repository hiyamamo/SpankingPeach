package com.example.spankingpeach.database;

import android.database.Cursor;

/**
 * Created by hiroki on 2014/09/26.
 */
public interface Dao {
    public Cursor getCursor(int id);
    public void dbClose();
}
