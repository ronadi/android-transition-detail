package com.ronadi.example.transitiondetail;
/*
 * Created by ronadi on 5/23/17.
 */

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
