package com.example.spankingpeach.entity;

import android.database.Cursor;

import com.example.spankingpeach.database.Dao;
import com.example.spankingpeach.database.DaoFactory;

/**
 * Created by hiroki on 2014/09/28.
 */
public class Stage extends Entity {
    private static int mLevel = 1;
    private static Stage mInstance = new Stage(mLevel);
    private String mName;
    private int mInterval;
    private int mSpeed;

    private Stage(int id) {
        super(id);
    }
    public static Stage getInstance(){
        return mInstance;
    }

    @Override
    protected void setParams() {
        Dao dao = DaoFactory.createStageDao();
        Cursor cursor = dao.getCursor(mId);
        if(cursor.moveToFirst()){
            mName = cursor.getString(cursor.getColumnIndex("name"));
            mInterval = cursor.getInt(cursor.getColumnIndex("interval"));
            mSpeed = cursor.getInt(cursor.getColumnIndex("speed"));
        }
        dao.dbClose();
    }
    public static Stage nextLevel(){
        mInstance = new Stage(++mLevel);
        return mInstance;
    }
    public String getName(){
        return mName;
    }
    public int getInteravl(){
        return mInterval;
    }
    public int getSpeed(){
        return mSpeed;
    }
}
