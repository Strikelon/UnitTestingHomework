package com.strikalov.unittestinghomework.di;

import android.app.Application;
import android.content.Context;

import com.strikalov.unittestinghomework.model.network.WebApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public WebApi provideWebApi(){
        return new WebApi();
    }

}
