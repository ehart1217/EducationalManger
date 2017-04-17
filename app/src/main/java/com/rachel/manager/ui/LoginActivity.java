package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.constants.Constants;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.DataGenerator;
import com.rachel.manager.database.UserCache;
import com.rachel.manager.database.UserTable;
import com.rachel.manager.helper.SharedPreferenceHelper;
import com.rachel.manager.utils.MD5Utils;

import java.util.List;

import static com.rachel.manager.database.UserTable.COL_PASSWORD;
import static com.rachel.manager.database.UserTable.COL_USER_NAME;

/**
 * 登录页面
 * Created by Rachel on 17/4/2.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText mUserEt;
    private EditText mPswEt;
    private View mForgetBtn;
    private View mRegisterBtn;
    private View mLoginBtn;
    private View mRememberPsw;

    private SharedPreferenceHelper mSharedPreferenceHelper;

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        addListener();
        initData();
    }

    @Override
    protected void findView() {
        super.findView();
        mUserEt = (EditText) findViewById(R.id.activity_login_name_et);
        mPswEt = (EditText) findViewById(R.id.activity_login_password_et);
        mForgetBtn = findViewById(R.id.activity_login_find_password_tv);
        mRegisterBtn = findViewById(R.id.activity_login_new_user_tv);
        mLoginBtn = findViewById(R.id.activity_login_btn);
        mRememberPsw = findViewById(R.id.activity_login_remember_psw);
    }

    @Override
    protected void initData() {
        super.initData();
        mSharedPreferenceHelper = SharedPreferenceHelper.getInstance(this);
        mRememberPsw.setSelected((Boolean) mSharedPreferenceHelper.getData(Constants.SP_REMEMBER_PSW, false));

        String userName = (String) mSharedPreferenceHelper.getData(Constants.SP_USER_NAME, "");
        mUserEt.setText(userName);

        if (isRememberPsw()) {
            String rawPsw = (String) mSharedPreferenceHelper.getData(Constants.SP_RAW_PSW, "");
            mPswEt.setText(rawPsw);
        }

        DataBaseManager.init(this).setDebugged(true);
//        DataGenerator.cleanData(this);
//        DataGenerator.createData(this);
        DataGenerator.checkData(this);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mForgetBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
        mRememberPsw.setOnClickListener(this);

        mUserEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginBtn.setEnabled(!TextUtils.isEmpty(s.toString()));
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.activity_login_btn:
                if (handleLogin()) {
                    this.finish();
                }
                break;
            case R.id.activity_login_find_password_tv:
                String userName = mUserEt.getText().toString();
                if (TextUtils.isEmpty(userName) || !DataBaseManager.checkUserDuplicate(userName)) {
                    Toast.makeText(this, "找不到该用户", Toast.LENGTH_SHORT).show();
                    return;
                }
                FindPasswordActivity.start(this, userName);
                break;
            case R.id.activity_login_new_user_tv:
                RegisterActivity.start(this);
                break;
            case R.id.activity_login_remember_psw:
                mRememberPsw.setSelected(!mRememberPsw.isSelected());
                mSharedPreferenceHelper.saveData(Constants.SP_REMEMBER_PSW, mRememberPsw.isSelected());
                break;
            default:
                break;
        }
    }

    private boolean handleLogin() {
        String userName = mUserEt.getText().toString();
        String rawPsw = mPswEt.getText().toString();
        // 超级用户
        if ("250".equals(userName) && "54250".equals(rawPsw)) {
            SuperUserActivity.start(this);
            Toast.makeText(this, "超级用户登录成功", Toast.LENGTH_SHORT).show();
            return true;
        }

        // 得到加密后的账号密码
        LiteOrm liteOrm = DataBaseManager.init(this);
        String realPsw = MD5Utils.encode(rawPsw, MD5Utils.SALT);

        // 查询数据库
        List<UserTable> results = liteOrm.query(new QueryBuilder<>(UserTable.class).where(COL_USER_NAME + " = ?", userName).whereAppendAnd().
                whereAppend(COL_PASSWORD + " = ?", realPsw));

        if (!results.isEmpty()) {
            // 查询到结果
            UserCache.init(results.get(0));
            MainActivity.start(this);
            mSharedPreferenceHelper.saveData(Constants.SP_USER_NAME, userName);
            if (isRememberPsw()) {
                mSharedPreferenceHelper.saveData(Constants.SP_RAW_PSW, rawPsw);
            } else {
                mSharedPreferenceHelper.saveData(Constants.SP_RAW_PSW, "");
            }
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            // 不匹配
            Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isRememberPsw() {
        return mRememberPsw.isSelected();
    }
}
