package com.example.spankingpeach.game.task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.entity.Stage;
import com.example.spankingpeach.R;
import com.example.spankingpeach.game.Score;
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
    private ArrayList<Target> mTargets = new ArrayList<Target>();

    public static Peach getInstance(){
        return mInstance;
    }
    private long mPrevTime = 0;
    private long mNowTime = 0;
    private Stage mStage = Stage.getInstance();

    private Peach() {
        Resources res = App.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
        new_target();
    }
    public void init(){
        mPrevTime = 0;
        mNowTime = 0;
        mTargets.clear();
        new_target();
    }
    private void new_target(){
        mTargets.add(new Target(getRandomX(), 0, mStage.getSpeed()));
    }
    @Override
    public boolean onUpdate() {
        if(isNewTarget()) {
            new_target();
        }
        for(Iterator<Target> target = mTargets.iterator();target.hasNext();) {
            if(!target.next().calcCoord()){
                Score.life--;
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
        if(time_left > mStage.getInteravl()){
            mPrevTime = mNowTime;
            return true;
        }

        return false;
    }
    // ターゲットインスタンス作成時のx座標を返す
    private int getRandomX(){
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(400);
    }


    @Override
    public void onTouch(float x, float y) {
        for(Iterator<Target> target = mTargets.iterator();target.hasNext();) {
            if(isInTouchRange(x, y, target.next())) {
                target.remove();
                Score.hitScore++;
            }
        }
    }

    public boolean isInTouchRange(float x, float y, Target t){
        if( x > t.getX() && x < t.getX() + bitmap.getWidth() &&
                y > t.getY() && y < t.getY() + bitmap.getHeight()){
            return true;
        }
        return false;
    }


    @Override
    public void onDraw(Canvas c) {
        for(Target target : mTargets) {
            c.drawBitmap(bitmap, target.getX(),target.getY(),paint);
        }
    }
}
