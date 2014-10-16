package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.task.Task;

import java.util.LinkedList;

/**
 * ゲームの状態を管理するIF
 */
public interface State {
    public abstract void onUpdate(GameMng manager);
    public abstract void onTouch(GameMng manager, float x, float y); // 画面がタッチされた時の状態遷移
    public abstract void onDraw(GameMng manager, Canvas c, LinkedList<Task> tsklist);
}
