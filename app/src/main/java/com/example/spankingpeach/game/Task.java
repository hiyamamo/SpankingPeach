package com.example.spankingpeach.game;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by dev on 14/07/29.
 * 各ゲームオブジェクトの基底クラス
 */
public abstract class Task {
    protected Task() {
    }

    public boolean onUpdate(){
        return true;
    }

    public void onDraw(Canvas c){}
}
