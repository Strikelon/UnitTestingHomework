package com.strikalov.unittestinghomework.di;

import com.strikalov.unittestinghomework.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void injectMainActivity(MainActivity mainActivity);

}
