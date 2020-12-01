package com.xmm.architecture.mvp;

import android.os.Handler;

import com.xmm.architecture.UserModel;

/**
 * mvp 中的 p层
 * 作用是 完全分离 m 和 v层
 *
 * 持有 m 和v 并且都是双向操作
 *
 */

public class LoginPresenter implements IPresenter {

    private ILoginView loginView;

    private UserModel mUser;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        initUser();
    }

    private void initUser(){
        mUser = new UserModel(loginView.getUsername(),loginView.getPassword());
    }

    @Override
    public void login(String name, String pass) {
        loginView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgress();
                loginView.setPasswordError();
            }
        },2000);

    }
}
