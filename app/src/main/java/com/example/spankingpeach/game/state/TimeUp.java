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
public class TimeUp extends ConcreteState {
    private static TimeUp mInstance = new TimeUp();
    public static TimeUp getInstance(){
        return mInstance;
    }
    @Override
    public void onUpdate(GameMng manager) {
        LinkedList<Task> tasklist = new LinkedList<Task>();
        tasklist.add(FpsController.getInstance());

        execUpdate(tasklist);
    }

    @Override
    public void onTouch(GameMng manager, float x, float y) {

    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {
        LinkedList<Task> tasklist = new LinkedList<Task>();
        tasklist.add(Bg.getInstance());
        tasklist.add(FpsController.getInstance());
        tasklist.add(Peach.getInstance());
        tasklist.add(Gage.getInstance());
        tasklist.add(Timer.getInstance());

        execDraw(tasklist,c);


    }
}
