package com.xmm.architecture.mvc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xmm.architecture.MainActivity;
import com.xmm.architecture.R;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_pass;
    private Button tv_login;

    ProgressDialog pd;

    LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        pd = new ProgressDialog(this);

        loginModel = new LoginModel();
    }

    @Override
    public void onClick(View v) {
        pd.show();
        String phoneNumber = et_name.getText().toString().trim();
        String password = et_pass.getText().toString().trim();
         loginModel.login(phoneNumber, password, new Response() {
                 @Override
                 public void onSuccess() {
                     pd.hide();
                     Toast.makeText(MVCActivity.this, "login success", Toast.LENGTH_SHORT).show();
                 }

                 @Override
                 public void onError() {

                 }
         });
    }
}