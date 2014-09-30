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

/**
 * Created by dev on 14/07/29.
 */
public class Peach extends Task{
    private static Peach mInstance = new Peach();
    private Paint paint = new Paint();
    private Bitmap bitmap;
    private final float POSITION_X = 90; // X座標
    private final float POSITION_Y = 550; // Y座標
    private ArrayList<Target> mTarget;
    private int mInterval; // ターゲットが出現するインターバル. stageによって変化
    private int mStageLevel = 1;
    private Stage mStage = new Stage(mStageLevel);

    public static Peach getInstance(){
        return mInstance;
    }
    private float mTouchRangeMaxX;
    private float mTouchRangeMaxY;
    private boolean isTouched;

    private Peach() {
        Resources res = App.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);

        mTouchRangeMaxX = (bitmap.getWidth() + POSITION_X);
        mTouchRangeMaxY = (bitmap.getHeight() + POSITION_Y);
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
            mTarget.add(new Target(x, 0,mStage.getSpeed()));
        }
        return super.onUpdate();
    }
    // ターゲットのインスタンスを作成するか判定
    // 前回作成した時間と現在時間のオフセットがインターバルより大きければ作成する.
    private boolean isNewTarget(){
        int time_left = 30;
        if(time_left > mInterval){
            return true;
        }

        return false;
    }
    // ターゲットインスタンス作成時のx座標を返す
    private int getRandomX(){
        return 300;
    }

    public void nextStage(){
        mStageLevel++;
        mStage = new Stage(mStageLevel);
        mInterval = mStage.getInteravl();
    }

    @Override
    public void onTouch(float x, float y) {
        isTouched = checkTouchRange(x,y);
    }


    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,POSITION_X,POSITION_Y,paint);
    }
}
