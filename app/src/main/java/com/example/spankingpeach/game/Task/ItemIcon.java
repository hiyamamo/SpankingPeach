package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.Entity.Item;

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
        mPaint.setTextSize(20);
        mPaint.setColor(Color.BLACK);
    }
    public static ItemIcon getInstance(){
        return mInstance;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(mName,50,100,mPaint);
    }
}
