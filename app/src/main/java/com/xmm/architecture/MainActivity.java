package com.xmm.architecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 不使用任何模式
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_pass;
    private Button tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}