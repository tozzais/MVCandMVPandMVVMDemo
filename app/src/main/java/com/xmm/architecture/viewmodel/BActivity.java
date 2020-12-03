package com.xmm.architecture.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.xmm.architecture.R;

/**
 * 不使用任何模式
 *
 */
public class BActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_pass;
    private Button tv_login;
    private TextView tv;
    private NumberViewModel i;


    private static final String TAG = "Activity__B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        i = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
                .get(NumberViewModel.class);

        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);
        tv = findViewById(R.id.tv);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        tv.setText("i=="+i.getNumber());

        Log.e(TAG, "onCreate"+i.getNumber());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                finish();
                break;
        }
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//
//    }
    //    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e(TAG, "onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(TAG, "onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e(TAG, "onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e(TAG, "onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e(TAG, "onDestroy");
//    }
//
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.e(TAG, "onRestart");
//    }
}