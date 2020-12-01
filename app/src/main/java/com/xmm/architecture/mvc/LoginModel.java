package com.xmm.architecture.mvc;

import android.os.Handler;

/**
 *  mvc 中的  m层
 */
public class LoginModel {


    public  void login(String name,String pass,final Response response){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                response.onSuccess();
            }
        },2000);
    }
}
