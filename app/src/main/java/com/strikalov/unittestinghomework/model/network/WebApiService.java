package com.strikalov.unittestinghomework.model.network;

import com.strikalov.unittestinghomework.model.entity.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebApiService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String user);
}
