package com.android.gmc.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import com.android.gmc.App;

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static SharedPreferenceHelper instance;

    private final String TAG = "#SharedPreferenceHelper#";

    public SharedPreferenceHelper() {
        sharedPreferences = App.getContext()
            .getSharedPreferences(Constants.PREFERENCES_FILENAME, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public synchronized boolean saveData(String key, String value) {
        editor.putString(key, value);
        return editor.commit();
    }

    public synchronized boolean saveData(String key, boolean value) {
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public synchronized boolean saveData(String key, long value) {
        editor.putLong(key, value);
        return editor.commit();
    }

    public synchronized boolean saveData(String key, float value) {
        editor.putFloat(key, value);
        return editor.commit();
    }

    public synchronized boolean saveData(String key, int value) {
        editor.putInt(key, value);
        return editor.commit();
    }

    public synchronized void saveData(String agroUser, Object data) {
        String jsonString = GsonUtils.getJsonString(data);
        saveData(agroUser, jsonString);
    }

    public synchronized boolean removeData(String key) {
        editor.remove(key);
        return editor.commit();
    }

    public synchronized Boolean getData(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public synchronized String getData(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public synchronized float getData(String key, float defaultValue) {

        return sharedPreferences.getFloat(key, defaultValue);
    }

    public synchronized int getData(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public synchronized long getData(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public synchronized void deleteAllData() {
        editor.clear();
        editor.commit();
    }

    public static SharedPreferenceHelper getInstance() {
        if (instance == null) {
            instance = new SharedPreferenceHelper();
        }
        return instance;
    }
}
