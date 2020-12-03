package com.xmm.architecture.room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xmm.architecture.R;

import java.util.List;

/**
 * 不使用任何模式
 *
 */
public class RoomActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private EditText et_name;

    private Button tv_add;
    private Button tv_delete;
    private Button tv_update;
    private Button tv_query;
    private Button tv_queryALL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        tv = findViewById(R.id.tv);
        et_name = findViewById(R.id.et_name);

        tv_add = findViewById(R.id.tv_add);
        tv_add.setOnClickListener(this);
        tv_delete = findViewById(R.id.tv_delete);
        tv_delete.setOnClickListener(this);
        tv_update = findViewById(R.id.tv_update);
        tv_update.setOnClickListener(this);
        tv_query = findViewById(R.id.tv_query);
        tv_query.setOnClickListener(this);
        tv_queryALL = findViewById(R.id.tv_queryALL);
        tv_queryALL.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String trim = et_name.getText().toString().trim();
        switch (v.getId()){
            case R.id.tv_add:
                User user = new User(Integer.parseInt(trim),"123","123");
                AppDatabase.getDatabase(this).userDao().insertAll(user);
                break;
            case R.id.tv_delete:
                User user1 = new User(Integer.parseInt(trim),"123","123");
                AppDatabase.getDatabase(this).userDao().delete(user1);
                break;
            case R.id.tv_update:
                User user2 = new User(Integer.parseInt(trim),"1234","1234");
                AppDatabase.getDatabase(this).userDao().update(user2);
                break;
            case R.id.tv_queryALL:
                List<User> all = AppDatabase.getDatabase(this).userDao().getAll();
                tv.setText(all.size()+"");
                break;
            case R.id.tv_query:
                User byID = AppDatabase.getDatabase(this).userDao().findByID(trim);
                if (byID == null){
                    Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
                    return;
                }
                tv.setText(byID.toString());
                break;
        }

    }
}