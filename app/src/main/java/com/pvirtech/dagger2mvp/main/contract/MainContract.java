package com.pvirtech.dagger2mvp.main.contract;


public interface MainContract {
    interface View{

        void showLocationInfo();

        void showError(String message);
    }

    interface  presenter{

    }
}
