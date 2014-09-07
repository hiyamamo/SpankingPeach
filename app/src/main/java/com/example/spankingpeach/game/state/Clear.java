package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.Task.Bg;
import com.example.spankingpeach.game.Task.FpsController;
import com.example.spankingpeach.game.Task.Gage;
import com.example.spankingpeach.game.Task.Peach;
import com.example.spankingpeach.game.Task.Task;
import com.example.spankingpeach.game.Task.Timer;

import java.util.LinkedList;

/**
 */
public class Clear extends ConcreteState{
    private static Clear mInstance = new Clear();
    public static Clear getInstance(){
        return mInstance;
    }
    private Clear(){}

    @Override
    public void onTouch(GameMng manager, float x, float y) {

    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(Bg.getInstance());
        taskList.add(FpsController.getInstance());
        taskList.add(Peach.getInstance());
        taskList.add(Gage.getInstance());
        taskList.add(Timer.getInstance());

        execDraw(taskList,c);

    }
}
