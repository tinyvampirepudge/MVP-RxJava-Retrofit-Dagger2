package com.pvirtech.dagger2mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.pvirtech.dagger2mvp.R;
import com.pvirtech.dagger2mvp.app.DaggerApplication;
import com.pvirtech.dagger2mvp.main.contract.MainContract;
import com.pvirtech.dagger2mvp.main.module.MainModule;
import com.pvirtech.dagger2mvp.main.presenter.MainPresenter;

import javax.inject.Inject;

public class MvpDaggerActivity extends AppCompatActivity implements MainContract.View {

    //注入presenter 对象
    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActivityComponent();
        bindView();
        mainPresenter.main();
    }

    /**
     *
     */
    private void bindView() {

    }

    /**
     * 初始化属于自己Activity的Component对象
     * 本例将MainComponent添加成为AppComponent的子Component
     */
    private void setupActivityComponent() {
        DaggerApplication.get(this)
                .getAppComponent()
                .addSub(new MainModule(this))
                .inject(this);
    }

    /**
     * MVP Presenter 中的回调
     */
    @Override
    public void showLocationInfo() {
        Log.d("test", "test");
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText("sucessed");
    }

    /**
     * MVP Presenter 中的回调
     */
    @Override
    public void showError(String message) {
        Toast.makeText(MvpDaggerActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
