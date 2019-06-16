package com.strikalov.unittestinghomework.mockito;

import com.strikalov.unittestinghomework.model.entity.User;
import com.strikalov.unittestinghomework.model.network.WebApi;
import com.strikalov.unittestinghomework.presenter.MainPresenter;
import com.strikalov.unittestinghomework.view.MainView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Mock
    MainView mainView;

    @Mock
    WebApi webApi;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Before
    public void before(){
        mainPresenter = new MainPresenter(webApi);
    }

    @Test
    public void testDownloadUser(){
        User user = new User();
        user.login = "Sasha";
        Mockito.when(webApi.downloadUserFromService()).thenReturn(Observable.just(user));
        mainPresenter.attachView(mainView);
        Mockito.verify(mainView).showUserName("Sasha");
    }

}
