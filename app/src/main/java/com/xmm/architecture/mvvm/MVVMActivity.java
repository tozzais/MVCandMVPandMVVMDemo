package com.xmm.architecture.mvvm;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.xmm.architecture.MainActivity;
import com.xmm.architecture.R;
import com.xmm.architecture.UserModel;
import com.xmm.architecture.databinding.ActivityMainMvvmBinding;

import java.lang.ref.WeakReference;

/**
 *
 * MVVM https://juejin.cn/post/6901200799242649607
 * 直接设置  binding.etName.setText("123456");
 *
 * 问题1：
 *  myHandler.sendEmptyMessage(0); 无法刷新组件
 *  问题2：
 *  afterTextChanged 属性没有
 *
 */
public class MVVMActivity extends AppCompatActivity implements View.OnClickListener {

    private Button tv_login;
    private Button tv_btn1;
    private Button tv_btn2;


    ProgressDialog pd;
    ActivityMainMvvmBinding binding;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main_mvvm);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        tv_btn1 = findViewById(R.id.tv_btn1);
        tv_btn1.setOnClickListener(this);

        tv_btn2 = findViewById(R.id.tv_btn2);
        tv_btn2.setOnClickListener(this);

        pd = new ProgressDialog(this);

//        MyHandler myHandler = new MyHandler(this);
//        myHandler.sendEmptyMessage(0);

        userModel = new UserModel("abd", "3452");
        binding.setUser(userModel);



    }



    private int i = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                //databing 基础入门
//                binding.setUser(new UserModel("123","3452"));
//                binding.etName.setText("123456");
                click();
                break;
            case R.id.tv_btn1:
                 userModel.setUsername("张三");
                break;
            case R.id.tv_btn2:
                Toast.makeText(this,userModel.getUsername(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
    /*
    https://www.jianshu.com/p/bd9016418af2
    实现数据变化自动驱动 UI 刷新的方式有三种：BaseObservable、ObservableField、ObservableCollection
     */
    private void click(){
    }


    static class MyHandler extends Handler{
        WeakReference<MVVMActivity> reference;

        public MyHandler(MVVMActivity reference) {
            this.reference = new WeakReference<>(reference);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            MVVMActivity context = reference.get();
            context.settext();


        }
    }
    private void settext(){
        binding.etName.setText("123456");
    }

    /**
     * 事件绑定
     */

    public class UserPresenter {

        public void onUserNameClick(UserModel user) {
            Toast.makeText(MVVMActivity.this, "用户名：" + user.getUsername(), Toast.LENGTH_SHORT).show();
        }

        public void afterTextChanged(Editable s) {
            userModel.setPrice(s.toString());
            binding.setUser(userModel);
        }


    }



}