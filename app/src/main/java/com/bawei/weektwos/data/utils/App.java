package com.bawei.weektwos.data.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
