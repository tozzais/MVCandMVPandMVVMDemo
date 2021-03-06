package com.xmm.architecture.mvp;

public interface ILoginView {

    void showProgress();

    void hideProgress();

    void setPasswordError();

    String getUsername();

    String getPassword();

    void loginSuccess();
}
