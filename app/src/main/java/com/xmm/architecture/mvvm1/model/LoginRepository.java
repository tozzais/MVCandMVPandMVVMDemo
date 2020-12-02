package com.xmm.architecture.mvvm1.model;

import android.widget.Toast;

/**
 * 两个功能：
 * 一是通过网络请求实现登录，登录成功后会得到 UID；
 * 二是将登录账号保存到 SQLite，实现登录账号的缓存功能。
 */
public class LoginRepository {

    public String login(String userName, String password) {
//        // 调用网络请求
//        String uid = apiService.login(userName, password);
//        // 将userName缓存到本地数据库
//        cache.save("userName", userName);

        return "123456";
    }
    // 从缓存中获取登录账号
    public String getUserNameFromCache() {
        return "数据库中数据 123456";
    }

}
