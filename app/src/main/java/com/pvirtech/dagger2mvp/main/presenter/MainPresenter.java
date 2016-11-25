package com.pvirtech.dagger2mvp.main.presenter;

import android.content.SharedPreferences;
import android.util.Log;

import com.pvirtech.dagger2mvp.http.service.UserService;
import com.pvirtech.dagger2mvp.http.vo.User;
import com.pvirtech.dagger2mvp.main.contract.MainContract;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainPresenter implements MainContract.presenter {

    private final MainContract.View view;
    private final SharedPreferences sharedPreferences;
    private final UserService userService;

    @Inject
    public MainPresenter(MainContract.View view,
                         @Named("default") SharedPreferences sharedPreferences,
                         UserService userService) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
        this.userService = userService;
    }

    public void main() {
        userService.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Subscriber<Response<List<User>>>() {
                            @Override
                            public void onCompleted() {
                                Log.d("test", "test");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("test", "test");
                            }

                            @Override
                            public void onNext(Response<List<User>> listResponse) {
                                Log.d("test", "test");
                                view.showLocationInfo();
                            }
                        });

    }


}
