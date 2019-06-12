package com.strikalov.unittestinghomework;

import android.app.Application;

import com.strikalov.unittestinghomework.di.AppComponent;
import com.strikalov.unittestinghomework.di.AppModule;
import com.strikalov.unittestinghomework.di.DaggerAppComponent;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
