package com.android.gmc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import com.android.gmc.App;
import com.android.gmc.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiscUtils {
    private static final String TAG = "#MiscUtils#";

    public static String getDeviceId() {
        return Settings.Secure.getString(App.getContext().getContentResolver(),
            Settings.Secure.ANDROID_ID);
    }

    public static boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) App.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            Logger.logDebug(TAG, e.getMessage());
            return false;
        }
    }

    public static boolean isProduction() {
        return !BuildConfig.DEBUG;
    }

    public static boolean isMockOn() {
        return BuildConfig.DEBUG && false;
    }

    public static String getHumanReadableDate(long timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yy, HH a ");
        String dateString = formatter.format(new Date(timestamp));
        return dateString;
    }
}
