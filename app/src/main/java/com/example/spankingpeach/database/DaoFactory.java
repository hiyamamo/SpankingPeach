package com.example.spankingpeach.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.spankingpeach.App;

import java.io.IOException;

/**
 * Created by hiroki on 2014/09/27.
 */
public class DaoFactory {
    public static Dao createItemDao(){
        return new ItemDao(getDataSource());
    }
    public static Dao createStageDao(){
        return new StageDao(getDataSource());
    }

    private static SQLiteDatabase getDataSource(){
        SQLiteDatabase db;
        OpenHelper helper = new OpenHelper(App.getContext());
        try{
            helper.createEmptyDatabase();
            db = helper.openDataBase();
        } catch (IOException e){
            throw new Error("Unable to create database");
        }catch (SQLiteException sqle){
            throw sqle;
        }
        return db;
    }

}
