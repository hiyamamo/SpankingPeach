package com.example.spankingpeach.Entity;

/**
 * Created by hiroki on 2014/09/28.
 */
public abstract class Entity {
    protected int mId;
    protected Entity(int id) {
        mId = id;
        setParams();
    }

    protected abstract void setParams();
    private int getId(){
        return mId;
    }
}
