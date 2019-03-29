package com.android.gmc;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context context;
    private static String TAG = "#App#";
    private long cacheExpiration = 15 * 60 * 1000;//15 minutes

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
