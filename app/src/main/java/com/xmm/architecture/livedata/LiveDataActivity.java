package com.xmm.architecture.livedata;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.xmm.architecture.R;

/**
 * 不使用任何模式
 *
 */
public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_pass;
    private Button tv_login;
    private String TAG = "LiveDataActivity";

    private TestViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "线程名： " +Thread.currentThread().getName());

        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_pass = findViewById(R.id.et_pass);
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);

        viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
                .get(TestViewModel.class);

//        TestViewModel1 viewModel = new ViewModelProvider(this,new TestViewModel1.Factory(""))
//                .get(TestViewModel1.class);

        MutableLiveData<String> nameEvent = viewModel.getNameEvent();
//        nameEvent.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.i(TAG, "线程名2： " +Thread.currentThread().getName());
//                et_name.setText(s+"=="+position);
//            }
//        });
        nameEvent.observeForever(s -> {
            Log.i(TAG, "线程名2： " +Thread.currentThread().getName());
            et_name.setText(s+"=="+position);
        });

    }
    private int position = 1;


    @Override
    public void onClick(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "线程名1： " +Thread.currentThread().getName());
                position++;
                viewModel.getNameEvent().postValue(" "+position);
            }
        }).start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause" );
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume" );
    }
}