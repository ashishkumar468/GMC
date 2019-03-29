package com.android.gmc.utils;

import android.util.Log;
import com.android.gmc.BuildConfig;

public class Logger {
    public static void logDebug(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void logError(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void logError(String tag, String message, boolean shouldSendToCrashlytics) {
        logError(tag, message);
        //TODO send to crashlytics
    }
}