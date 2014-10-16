package com.example.spankingpeach.game.task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.entity.Item;

/**
 * Created by hiroki on 2014/09/27.
 */
public class ItemIcon extends Task {
    public static ItemIcon mInstance = new ItemIcon();
    private String mName;
    private Paint mPaint = new Paint();
    private ItemIcon(){
        Item item = new Item(1);
        mName = item.getName();
        mPaint.setTextSize(30);
        mPaint.setColor(Color.BLACK);
    }
    public static ItemIcon getInstance(){
        return mInstance;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(mName,550,100,mPaint);
    }
}
