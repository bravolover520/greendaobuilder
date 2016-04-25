package com.purityboy.greendaobuilder;

import android.app.Application;

import com.purityboy.greendaobuilder.helper.DbCore;

/**
 * Created by John on 2016/4/25.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbCore.getInstance().init(this, "my_db");
    }
}
