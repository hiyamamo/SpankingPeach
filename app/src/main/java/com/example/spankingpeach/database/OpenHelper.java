package com.example.spankingpeach.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hiroki on 2014/09/25.
 */
public class OpenHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "peach";
    private static String DB_NAME_ASSET = "peach.db";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private final File mDatabasePath;
    public OpenHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        mContext = context;
        mDatabasePath = mContext.getDatabasePath(DB_NAME);
    }

    public void createEmptyDatabase() throws IOException{
        boolean dbExist = checkDatabaseExists();
        if(!dbExist){
           getReadableDatabase();

            try{
                copyDataBaseFromAsset();

                String dbPath = mDatabasePath.getAbsolutePath();
                SQLiteDatabase checkDb = null;
                try{
                    checkDb = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
                }catch (SQLiteException e){

                }
                if(checkDb != null){
                    checkDb.setVersion(DB_VERSION);
                    checkDb.close();
                }
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    /**
     * 再コピー防止のため、データベースがすでに存在しているか確認
     * @return 存在している場合 {@code true}
     */
    private boolean checkDatabaseExists(){
        String dbPath = mDatabasePath.getAbsolutePath();
        SQLiteDatabase checkDb = null;

        try {
            checkDb = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){
        }
        if(checkDb == null) {
            return false;
        }
        int oldVersion = checkDb.getVersion();
        int newVersion = DB_VERSION;
        if(oldVersion == newVersion){
            checkDb.close();
            return true;
        }
        File f = new File(dbPath);
        f.delete();
        return false;
    }

    /**
     * assetに格納したデータベースをデフォルトのデータベースパスに作成した空のデータベースにコピーする
     * @throws IOException
     */
    private void copyDataBaseFromAsset() throws IOException {
        InputStream input = mContext.getAssets().open(DB_NAME_ASSET);
        OutputStream output = new FileOutputStream(mDatabasePath);

        byte[] buffer = new byte[1024];
        int size;
        while((size = input.read(buffer)) > 0){
           output.write(buffer, 0, size);
        }
        output.flush();
        output.close();
        input.close();
    }

    public SQLiteDatabase openDataBase() throws SQLiteException{
        return getReadableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    @Override
    public synchronized void close() {
        if(mDataBase != null){
            mDataBase.close();
        }
        super.close();
    }
}
