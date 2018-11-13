package com.ayla.notificationtesting;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

public class NotificationApp extends Application {
    private static NotificationApp notificationApp;
    public static String device_id;
    public static synchronized NotificationApp getInstance() {
        if(notificationApp == null){
            notificationApp = new NotificationApp();
        }
        return notificationApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        notificationApp = this;
        device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
