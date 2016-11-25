package com.pvirtech.dagger2mvp.http.module;


import com.pvirtech.dagger2mvp.http.retrofit.LocalRetrofit;
import com.pvirtech.dagger2mvp.http.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class LocalServiceModule {

    @Singleton
    @Provides
    public UserService providerUserService(LocalRetrofit retrofit) {
        return retrofit.getRetrofit().create(UserService.class);
    }
}
