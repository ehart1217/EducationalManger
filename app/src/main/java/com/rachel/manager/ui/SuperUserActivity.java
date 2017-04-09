package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataGenerator;

/**
 * 超级用户页面
 * Created by Rachel on 17/4/4.
 */

public class SuperUserActivity extends BaseActivity implements View.OnClickListener {

    private View mCreateBtn;
    private View mDeleteBtn;
    private View mDisplayBtn;
    private TextView mDisplayTv;

    public static void start(Context context) {
        Intent starter = new Intent(context, SuperUserActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_super_user);
        super.onCreate(savedInstanceState);

        findView();

        mCreateBtn = findViewById(R.id.activity_super_user_create_btn);
        mDeleteBtn = findViewById(R.id.activity_super_user_delete_btn);
        mDisplayBtn = findViewById(R.id.activity_super_user_display_btn);

        mDisplayTv = (TextView) findViewById(R.id.activity_super_user_display_tv);

        mCreateBtn.setOnClickListener(this);
        mDeleteBtn.setOnClickListener(this);
        mDisplayBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.activity_super_user_create_btn:
                DataGenerator.createData(this);
                Toast.makeText(this, "create data", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_super_user_delete_btn:
                DataGenerator.cleanData(this);
                Toast.makeText(this, "delete data", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_super_user_display_btn:
                String display = DataGenerator.checkData(this);
                mDisplayTv.setText(display);
                break;
        }
    }
}
