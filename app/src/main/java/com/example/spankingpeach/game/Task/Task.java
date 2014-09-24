package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;

/**
 * Created by dev on 14/07/29.
 * 各ゲームオブジェクトの基底クラス
 */
public abstract class Task {
    protected Task() {
    }

    //更新
    public boolean onUpdate(){
        return true;
    }

    //描画
    public void onDraw(Canvas c){}

    //タッチコールバック
    public void onTouch(float x, float y){}
}
