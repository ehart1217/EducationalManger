package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.UserTable;
import com.rachel.manager.ui.picker.BaseEditDialog;
import com.rachel.manager.ui.picker.DateEditDialog;
import com.rachel.manager.utils.MD5Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册页面
 * Created by Rachel on 17/4/17.
 */
public class RegisterActivity extends BaseActivity {

    private static final String STUDENT = "学生";
    private static final String MANAGER = "管理员";

    private EditText mUserNameEt;
    private EditText mPswEt;
    private EditText mNickNameEt;
    private TextView mRoleTv;
    private View mCommitBtn;
    private DateEditDialog dialog;

    public static void start(Context context) {
        Intent starter = new Intent(context, RegisterActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mUserNameEt = (EditText) findViewById(R.id.activity_register_user_name_et);
        mPswEt = (EditText) findViewById(R.id.activity_register_password_et);
        mNickNameEt = (EditText) findViewById(R.id.activity_register_nickname_et);
        mRoleTv = (TextView) findViewById(R.id.activity_register_role_tv);
        mCommitBtn = findViewById(R.id.activity_register_commit_btn);
    }

    @Override
    protected void initData() {
        super.initData();
        setTitle("注册");
    }

    @Override
    protected void addListener() {
        super.addListener();
        mUserNameEt.addTextChangedListener(mTextWatcher);
        mPswEt.addTextChangedListener(mTextWatcher);
        mNickNameEt.addTextChangedListener(mTextWatcher);
        mCommitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });
        mRoleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRoleDialog();
            }
        });
    }

    private void handleRegister() {
        String userName = mUserNameEt.getText().toString();
        String psw = mPswEt.getText().toString();
        String role = mRoleTv.getText().toString();
        String nickName = mNickNameEt.getText().toString();

        boolean duplicateUserName = DataBaseManager.checkUserDuplicate(userName);
        if (duplicateUserName) {
            Toast.makeText(this, "用户名重复！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(psw) || TextUtils.isEmpty(role) || TextUtils.isEmpty(nickName)) {
            Toast.makeText(this, "请补充完成的信息！", Toast.LENGTH_SHORT).show();
            return;
        }

        String realPsw = MD5Utils.encode(psw,MD5Utils.SALT);
        int roleInt = UserTable.ROLE_USER;
        if(MANAGER.equals(role)){
            roleInt = UserTable.ROLE_MANAGER;
        }
        UserTable userTable = new UserTable(userName,realPsw,roleInt);
        userTable.setName(nickName);
        DataBaseManager.newUser(userTable);
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            updateCommitBtn();
        }
    };

    private void showRoleDialog() {
        if (dialog == null) {
            dialog = new DateEditDialog(this);
            List<String> list = new ArrayList<>();
            list.add(STUDENT);
            list.add(MANAGER);
            dialog.setData(list, STUDENT);
            dialog.setDesc("");
            dialog.setOnEditResult(new BaseEditDialog.OnEditResult() {
                @Override
                public void onResult(@NonNull Object... results) {
                    mRoleTv.setText((String) results[0]);
                }
            });
        }
        dialog.show();
    }

    private void updateCommitBtn() {
        boolean userNameEmpty = TextUtils.isEmpty(mUserNameEt.getText());
        boolean pswEmpty = TextUtils.isEmpty(mUserNameEt.getText());
        boolean roleEmpty = TextUtils.isEmpty(mUserNameEt.getText());

        mCommitBtn.setEnabled(!userNameEmpty && !pswEmpty && !roleEmpty);
    }
}
