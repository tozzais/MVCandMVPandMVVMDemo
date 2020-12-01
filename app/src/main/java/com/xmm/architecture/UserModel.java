package com.xmm.architecture;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserModel  extends BaseObservable{


    @Bindable
    private String username;

    private String password;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int checkUserValidity(String username, String password) {
        if (username == null || password == null ||
                username.isEmpty() ||
                password.isEmpty()) {
            return -1;
        }
        return 0;
    }
}
