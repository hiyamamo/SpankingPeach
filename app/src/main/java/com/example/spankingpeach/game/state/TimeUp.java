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
    public void onDraw(GameMng manager, Canvas c) {
        super.onDraw(manager, c);
    }

}
