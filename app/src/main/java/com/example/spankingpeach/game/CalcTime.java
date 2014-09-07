package com.example.spankingpeach.game;

/**
 * 制限時間を計算
 */
public class CalcTime {
    private final int GAME_TIME = 30;
    private final int FPS = 60;
    private int mCounter;
    private int mNowTime;

    public CalcTime() {
        this.mNowTime = GAME_TIME;
        this.mCounter = FPS;
    }

    // 現在の時間を返す
    public int getNowTime(){
        return mNowTime;
    }

    // 現在の時間を計算
    public void calc(){
        --mCounter;
        if(mCounter == 0){
            --mNowTime;
            mCounter = FPS;
        }
        if(mNowTime <= 0){
            mNowTime = 0;
        }
    }
}
