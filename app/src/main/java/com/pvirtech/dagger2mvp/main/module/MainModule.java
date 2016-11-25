package com.pvirtech.dagger2mvp.main.module;


import com.pvirtech.dagger2mvp.app.ActivityScope;
import com.pvirtech.dagger2mvp.main.contract.MainContract;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view){
        this.view = view;
    }

    @ActivityScope
    @Provides
    public MainContract.View providerView(){
        return view;
    }

}
