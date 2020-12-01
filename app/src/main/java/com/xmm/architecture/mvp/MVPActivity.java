package com.xmm.architecture.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xmm.architecture.R;

/**
 * mvp 中的 view层
 * 只提供和view 相关的操作
 *
 */
public class MVPActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText et_name;
    private EditText et_pass;
    private Button tv_login;

    ProgressDialog pd;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        pd = new ProgressDialog(this);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                loginPresenter.login(getUsername(),getPassword());
                break;
        }
    }

    @Override
    public void showProgress() {
        pd.show();
    }

    @Override
    public void hideProgress() {
        pd.cancel();
    }

    @Override
    public void setPasswordError() {
        et_pass.setError("passwrod error");
    }

    @Override
    public String getUsername() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_pass.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }
}