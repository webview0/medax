package com.bignerdranch.android.splash;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Don't do this! This is just so cold launches take some time,
        // so you can see the splash screen.  It's a demonstration.  We
        // 'll remove this.
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
