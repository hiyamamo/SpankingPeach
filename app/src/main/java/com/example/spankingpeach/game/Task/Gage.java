package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.spankingpeach.App;
import com.example.spankingpeach.R;

/**
 * Gage Class
 * ゲージの表示、更新
 * Created by dev on 14/07/31.
 */
public class Gage extends Task{
    private static final float OUTER_LEFT = App.getWindowSize().x / 20;
    private static final float OUTER_TOP = 280;
    private static final int INNER_LEFT =(int)(OUTER_LEFT + 20);
    private static final int INNER_TOP = 300;
    private final int COUNTER_MAX = 30; // ゲージが移動し終わるまでのフレーム数
    private int currentPos;
    private int dstPos;
    private Paint paint = new Paint();
    private Rect dstR;
    private Rect srcR;

    private Bitmap outerBitmap;
    private Bitmap innerBitmap;
    private int counter; // 毎フレームカウント用カウンター
    private int innerHeight;
    private int innerWidth;
    public Gage() {
        counter = 0;
        Resources res =  App.getContext().getResources();
        outerBitmap = BitmapFactory.decodeResource(res, R.drawable.gage);
        innerBitmap = BitmapFactory.decodeResource(res, R.drawable.gage_innner);
        innerHeight = innerBitmap.getHeight();
        innerWidth = innerBitmap.getWidth();
        currentPos = INNER_TOP+innerHeight;
        dstPos = currentPos;
        srcR = new Rect(0,0,innerWidth,innerHeight);
        dstR = new Rect(INNER_LEFT,currentPos,INNER_LEFT+innerWidth-20,INNER_TOP+innerHeight-20);

    }

    @Override
    public void onTouch() {
        dstPos -= 30;
        counter = 0;
    }

    @Override
    public boolean onUpdate() {
        calcPosition();
        dstR.set(INNER_LEFT,currentPos,INNER_LEFT+innerWidth-20,INNER_TOP+innerHeight-20);
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(outerBitmap,OUTER_LEFT,OUTER_TOP,paint);
        c.drawBitmap(innerBitmap,srcR,dstR,paint);
    }

    private void calcPosition() {
        int offset = currentPos - dstPos;
        int inc = offset / (COUNTER_MAX - counter);
        if(inc > 0) {
            currentPos -= inc;
        }
        if(currentPos <= INNER_TOP){
            currentPos = INNER_TOP;
        }
        counter = ++counter % COUNTER_MAX;
    }

}
