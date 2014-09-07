package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;

/**
 * ゲームの状態を管理するIF
 */
public interface State {
    public abstract void onUpdate(GameMng manager);
    public abstract void onTouch(GameMng manager); // 画面がタッチされた時の状態遷移
    public abstract void onDraw(GameMng manager, Canvas c);
}
