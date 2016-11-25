package com.pvirtech.dagger2mvp.http;


import com.pvirtech.dagger2mvp.http.retrofit.LocalRetrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public LocalRetrofit providerLocalRetrofit(@Named("default") OkHttpClient okHttpClient) {
        return new LocalRetrofit(okHttpClient);
    }

}
