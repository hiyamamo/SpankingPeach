package com.example.spankingpeach.listener;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dev on 14/07/31.
 */
public class GameTouchListener implements View.OnTouchListener {

    public GameTouchListener() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
        }
        return false;
    }

}
