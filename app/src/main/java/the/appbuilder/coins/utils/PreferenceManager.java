package the.appbuilder.coins.utils;


import android.content.Context;
import android.content.SharedPreferences;

import the.appbuilder.coins.AppApplication;

public class PreferenceManager {


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static PreferenceManager preferenceManager;

    public static PreferenceManager getInstance() {
        if(preferenceManager == null) {
            preferenceManager = new PreferenceManager();
        }
        return preferenceManager;
    }

    // Constructor
    private PreferenceManager() {
        // init
        sharedPreferences = AppApplication.getInstance().getSharedPreferences("preferences",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void set(String key, String value) {
        if (value != null) {
            editor.putString(key, value);
        } else {
            editor.remove(key);
        }
        editor.apply();
    }

    public String get(String key, String defaultValue) {
        String value = sharedPreferences.getString(key, null);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }


}