package com.xmm.architecture.mvvm1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import com.xmm.architecture.R;
import com.xmm.architecture.databinding.ActivityLoginBinding;
import com.xmm.architecture.mvvm1.viewmodel.LoginViewModel;

/**
 * 不使用任何模式
 *
 */
public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 初始化viewModel
        LoginViewModel viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
                .get(LoginViewModel.class);
        // 与布局文件进行绑定
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setVm(viewModel);


    }
}