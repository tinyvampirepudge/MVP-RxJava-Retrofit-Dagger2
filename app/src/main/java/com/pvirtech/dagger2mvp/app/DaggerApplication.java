package com.pvirtech.dagger2mvp.app;

import android.app.Application;
import android.content.Context;

public class DaggerApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static DaggerApplication get(Context context) {
        return (DaggerApplication) context.getApplicationContext();
    }

    private void setupApplicationComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            this.setupApplicationComponent();
        }
        return appComponent;
    }

}
