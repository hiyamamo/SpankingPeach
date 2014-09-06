package com.example.spankingpeach;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by dev on 14/08/07.
 */
public class App extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
    public static Point getWindowSize(){
        WindowManager wm= (WindowManager)context.getSystemService(context.WINDOW_SERVICE) ;
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        return size;
    }
}
