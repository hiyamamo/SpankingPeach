package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.Task.BeforeChar;
import com.example.spankingpeach.game.Task.Bg;
import com.example.spankingpeach.game.Task.FpsController;
import com.example.spankingpeach.game.Task.Gage;
import com.example.spankingpeach.game.Task.ItemIcon;
import com.example.spankingpeach.game.Task.Peach;
import com.example.spankingpeach.game.Task.Task;
import com.example.spankingpeach.game.Task.Timer;

import java.sql.Time;
import java.util.LinkedList;

/**
 */
public class Before extends ConcreteState{
    private static State mBefore = new Before();
    private Before(){}
    public static State getInstance(){
        return mBefore;
    }

    @Override
    public void onTouch(GameMng manager, float x, float y) {
        manager.setState(InGame.getInstance());
        // タイマーを初期化
        Timer.getInstance().setStartTime();
    }

    @Override
    public void onUpdate(GameMng manager) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(BeforeChar.getIntance());

        execUpdate(taskList);
    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        super.onDraw(manager,c);
        taskList.add(BeforeChar.getIntance());
        execDraw(taskList, c);
    }
}
