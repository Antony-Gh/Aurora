package com.example.aurora.ui.login;

import android.app.Application;

import cat.ereza.customactivityoncrash.config.CaocConfig;

public class app extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CaocConfig.Builder.create()
                .showErrorDetails(true)
                .showRestartButton(true)
                .trackActivities(true)
                .apply();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
