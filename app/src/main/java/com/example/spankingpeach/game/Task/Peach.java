package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.Entity.Stage;
import com.example.spankingpeach.R;
import com.example.spankingpeach.game.target.Target;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by dev on 14/07/29.
 */
public class Peach extends Task{
    private static Peach mInstance = new Peach();
    private Paint paint = new Paint();
    private Bitmap bitmap;
    private final float POSITION_X = 90; // X座標
    private final float POSITION_Y = 550; // Y座標
    private ArrayList<Target> mTargets = new ArrayList<Target>();
    private int mInterval; // ターゲットが出現するインターバル. stageによって変化
    private int mStageLevel = 1;
    private Stage mStage = new Stage(mStageLevel);

    public static Peach getInstance(){
        return mInstance;
    }
    private float mTouchRangeMaxX;
    private float mTouchRangeMaxY;
    private boolean isTouched;
    private long mPrevTime = 0;
    private long mNowTime = 0;

    private Peach() {
        Resources res = App.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
        mTouchRangeMaxX = (bitmap.getWidth() + POSITION_X);
        mTouchRangeMaxY = (bitmap.getHeight() + POSITION_Y);
        mTargets.add(new Target(50,0,10));
        mInterval = 30;
    }

    public boolean checkTouchRange(float x,float y){
        if(x > POSITION_X && x < mTouchRangeMaxX && y > POSITION_Y && y < mTouchRangeMaxY){
            return true;
        }
        return false;
    }

    @Override
    public boolean onUpdate() {
        if(isNewTarget()) {
            int x = getRandomX();
            //mTargets.add(new Target(x, 0,mStage.getSpeed()));
            mTargets.add(new Target(x, 0, 10));
        }
        for(Iterator<Target> target = mTargets.iterator();target.hasNext();) {
            if(!target.next().calcCoord()){
                target.remove();
            }
        }
        mNowTime++;
        return super.onUpdate();
    }
    // ターゲットのインスタンスを作成するか判定
    // 前回作成した時間と現在時間のオフセットがインターバルより大きければ作成する.
    private boolean isNewTarget(){
        long time_left = mNowTime - mPrevTime;
        if(time_left > mInterval){
            mPrevTime = mNowTime;
            return true;
        }

        return false;
    }
    // ターゲットインスタンス作成時のx座標を返す
    private int getRandomX(){
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(400) + 50;
    }


    @Override
    public void onTouch(float x, float y) {
        isTouched = checkTouchRange(x,y);
    }


    @Override
    public void onDraw(Canvas c) {
        for(Target target : mTargets) {
            c.drawBitmap(bitmap, target.getX(),target.getY(),paint);
        }
    }
}
