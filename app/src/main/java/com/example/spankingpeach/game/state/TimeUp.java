package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.task.Task;

import java.util.LinkedList;

/**
 */
public class TimeUp extends ConcreteState {
    private static TimeUp mInstance = new TimeUp();
    public static TimeUp getInstance(){
        return mInstance;
    }

    @Override
    public void onDraw(GameMng manager, Canvas c, LinkedList<Task> tsklist) {
        super.onDraw(manager, c, tsklist);
    }

}
