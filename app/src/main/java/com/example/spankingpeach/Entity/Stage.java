package com.example.spankingpeach.Entity;

import android.database.Cursor;

import com.example.spankingpeach.database.Dao;
import com.example.spankingpeach.database.DaoFactory;

/**
 * Created by hiroki on 2014/09/28.
 */
public class Stage extends Entity {
    private String mName;
    public Stage(int id) {
        super(id);
    }

    @Override
    protected void setParams() {
        Dao dao = DaoFactory.createStageDao();
        Cursor cursor = dao.getCursor(mId);
        if(cursor.moveToFirst()){
            mName = cursor.getString(cursor.getColumnIndex("name"));
        }
        dao.dbClose();
    }
    public String getName(){
        return mName;
    }
}
