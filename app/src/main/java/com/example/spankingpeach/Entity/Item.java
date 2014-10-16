package com.example.spankingpeach.entity;

import android.database.Cursor;
import android.graphics.Bitmap;

import com.example.spankingpeach.database.Dao;
import com.example.spankingpeach.database.DaoFactory;

/**
 * Created by hiroki on 2014/09/25.
 */
public class Item extends Entity{
    private String name;
    private Bitmap icon;
    private Bitmap[] animation;

    public Item(int id) {
        super(id);
    }

    @Override
    protected void setParams(){
        Dao itemDao = DaoFactory.createItemDao();
        Cursor c = itemDao.getCursor(mId);
        if(c.moveToFirst()) {
            name = c.getString(c.getColumnIndex("name"));
        }
        itemDao.dbClose();
    }

    public String getName() {
        return name;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public Bitmap[] getAnimation() {
        return animation;
    }
}
