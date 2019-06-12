package com.strikalov.unittestinghomework.model.network;

import com.strikalov.unittestinghomework.model.entity.User;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebApi {

    private static final String URL_REQUEST = "https://api.github.com";

    public Observable<User> downloadUserFromService(){

        WebApiService webApiService = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URL_REQUEST)
                .build()
                .create(WebApiService.class);

        return webApiService.getUser("JakeWharton").subscribeOn(Schedulers.io());

    }

}
