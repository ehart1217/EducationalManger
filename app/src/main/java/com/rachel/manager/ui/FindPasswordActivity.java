package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.UserTable;
import com.rachel.manager.utils.MD5Utils;

/**
 * 找回密码
 * Created by Rachel on 17/4/18.
 */

public class FindPasswordActivity extends BaseActivity {

    private TextView userNameTv;
    private EditText pswEt;
    private View findBtn;

    public static void start(Context context, String userName) {
        Intent starter = new Intent(context, FindPasswordActivity.class);
        starter.putExtra("name", userName);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        userNameTv = (TextView) findViewById(R.id.activity_find_psw_name_et);
        pswEt = (EditText) findViewById(R.id.activity_find_password_psw_et);
        findBtn = findViewById(R.id.activity_find_password_btn);
    }

    @Override
    protected void initData() {
        super.initData();
        String userName = getIntent().getStringExtra("name");
        userNameTv.setText(userName);
        findBtn.setEnabled(true);
        setTitle("找回密码");
    }

    @Override
    protected void addListener() {
        super.addListener();
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String psw = pswEt.getText().toString();
                if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(FindPasswordActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                UserTable userTable = DataBaseManager.queryUserByUserName(userNameTv.getText().toString());
                if (userTable == null) {
                    Toast.makeText(FindPasswordActivity.this, "用户名不正确", Toast.LENGTH_SHORT).show();
                    FindPasswordActivity.this.finish();
                    return;
                }
                String pswReal = MD5Utils.encode(psw, MD5Utils.SALT);
                userTable.setPassword(pswReal);
                DataBaseManager.update(userTable);
                Toast.makeText(FindPasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                FindPasswordActivity.this.finish();
            }
        });
    }
}
