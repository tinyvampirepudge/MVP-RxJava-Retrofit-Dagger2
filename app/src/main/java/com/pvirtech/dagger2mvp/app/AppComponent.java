package com.pvirtech.dagger2mvp.app;


import com.pvirtech.dagger2mvp.http.OkhttpModule;
import com.pvirtech.dagger2mvp.http.RetrofitModule;
import com.pvirtech.dagger2mvp.http.module.LocalServiceModule;
import com.pvirtech.dagger2mvp.main.component.MainComponent;
import com.pvirtech.dagger2mvp.main.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class,
        OkhttpModule.class,
        RetrofitModule.class,
        LocalServiceModule.class})
public interface AppComponent {
    MainComponent addSub(MainModule mainModule);
}
