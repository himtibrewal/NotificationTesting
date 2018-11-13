package com.ayla.notificationtesting;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ubuntu on 29/8/17.
 */

public class AppPref {
    private static AppPref instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sEditor;
    private String SG_SHARED_PREFERENCE = "shared_preference";
    private String DEVICE_ID = "device_Id";
    private String FCM_ID = "fcm_id";

    private AppPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SG_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        sEditor = sharedPreferences.edit();
    }

    public static AppPref getInstance() {
        if (instance == null) {
            synchronized (AppPref.class) {
                if (instance == null) {
                    instance = new AppPref(NotificationApp.getInstance().getApplicationContext());
                }
            }
        }
        return instance;
    }

    public String getDEVICE_ID() {
        return sharedPreferences.getString(DEVICE_ID, "");
    }

    public void setDEVICE_ID(String device_id) {
        sEditor.putString(DEVICE_ID, device_id);
        sEditor.commit();
    }

    public String getFCM_ID() {
        return sharedPreferences.getString(FCM_ID, "");
    }

    public void setFCM_ID(String fcm_id) {
        sEditor.putString(FCM_ID, fcm_id);
        sEditor.commit();
    }

}
