package com.example.spankingpeach.Entity;

import android.database.Cursor;
import android.graphics.Bitmap;

import com.example.spankingpeach.database.Dao;
import com.example.spankingpeach.database.DaoFactory;

/**
 * Created by hiroki on 2014/09/25.
 */
public class Item{
    private int id;
    private String name;
    private Bitmap icon;
    private Bitmap[] animation;

    public Item(int id) {
        this.id = id;
        setParams();
    }

    private void setParams(){
        Dao itemDao = DaoFactory.createDao();
        Cursor c = itemDao.getCursor(id);
        if(c.moveToFirst()) {
            name = c.getString(c.getColumnIndex("name"));
        }
        itemDao.dbClose();
    }
    public int getId() {
        return id;
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
