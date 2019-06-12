package com.strikalov.unittestinghomework.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.strikalov.unittestinghomework.model.network.WebApi;
import com.strikalov.unittestinghomework.view.MainView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = "LogMainPresenter";

    private WebApi webApi;

    @Inject
    public MainPresenter(WebApi webApi){
        this.webApi = webApi;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        downloadUser();
    }

    public void downloadUser(){
        webApi.downloadUserFromService().observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> getViewState().showUserName(user.login),
                        throwable -> Log.i(TAG, throwable.toString())
                );
    }
}
