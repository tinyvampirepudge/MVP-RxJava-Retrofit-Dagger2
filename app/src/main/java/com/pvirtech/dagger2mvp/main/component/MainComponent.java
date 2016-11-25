package com.pvirtech.dagger2mvp.main.component;


import com.pvirtech.dagger2mvp.app.ActivityScope;
import com.pvirtech.dagger2mvp.main.MvpDaggerActivity;
import com.pvirtech.dagger2mvp.main.module.MainModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MvpDaggerActivity mainActivity);
}
