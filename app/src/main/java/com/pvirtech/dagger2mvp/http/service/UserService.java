package com.pvirtech.dagger2mvp.http.service;


import com.pvirtech.dagger2mvp.http.vo.User;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface UserService {

    @GET("/repos/square/retrofit/contributors")
    Observable<Response<List<User>>> getUser();

    @GET("/users/{id}")
    Observable<Response<User>> getUserById(@Path("id") String id);
}
