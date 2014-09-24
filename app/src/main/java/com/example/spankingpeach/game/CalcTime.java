package com.example.spankingpeach.game;

/**
 * 制限時間を計算
 */
public class CalcTime {
    private final int GAME_TIME = 30;
    private long mNowTime;
    private long mStartTime;

    public CalcTime() {
        this.mNowTime = GAME_TIME;
    }

    // 現在の時間を返す
    public long getNowTime(){
        return mNowTime;
    }
    public void setStartTime(){
        mStartTime = System.currentTimeMillis();
    }

    // 現在の時間を計算
    public boolean calc(){
        long current = System.currentTimeMillis();
        long time_gone = (current - mStartTime) / 1000;
        if(time_gone >= 30){
            mNowTime = 0;
        }else {
            mNowTime = GAME_TIME - time_gone;
        }
        if(mNowTime == 0) {
            return true;
        }
        return false;
    }
}
