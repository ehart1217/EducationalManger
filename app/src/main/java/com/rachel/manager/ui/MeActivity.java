package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.SchoolTable;
import com.rachel.manager.database.UserTable;

/**
 * 我 页面
 * Created by Rachel on 17/4/9.
 */

public class MeActivity extends BaseActivity implements View.OnClickListener {

    private TextView mNameTv;
    private View mSchoolContainer;
    private TextView mSchoolTv;
    private TextView mRightTv;
    private View mLogoutBtn;
    private UserTable mUserTable;

    public static void start(Context context) {
        Intent starter = new Intent(context, MeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mNameTv = (TextView) findViewById(R.id.activity_me_name_tv);
        mSchoolContainer = findViewById(R.id.activity_me_school_container);
        mSchoolTv = (TextView) findViewById(R.id.activity_me_school_tv);
        mRightTv = (TextView) findViewById(R.id.activity_me_right_tv);
        mLogoutBtn = findViewById(R.id.activity_me_logout_btn);

    }

    @Override
    protected void initData() {
        super.initData();
        setTitle("我");
        mUserTable = DataBaseManager.getCurrentUser();
        String name = mUserTable.getName();
        if (name == null) {
            name = "";
        }
        mNameTv.setText(name);

        String schoolName = "";
        SchoolTable school = mUserTable.getSchool();
        if (school != null) {
            if (school.getName() != null) {
                schoolName = school.getName();
            }
        }
        mSchoolTv.setText(schoolName);

        String rightStr;
        int role = mUserTable.getRole();
        if (role == UserTable.ROLE_USER) {
            rightStr = "学生";
        } else {
            rightStr = "管理员";
        }
        mRightTv.setText(rightStr);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mLogoutBtn.setOnClickListener(this);
        if (mUserTable.getSchool() != null) {
            mSchoolContainer.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.activity_me_logout_btn) {
            DataBaseManager.clearUser();
            LoginActivity.start(this);
            this.finish();
        } else if (id == R.id.activity_me_school_container) {
            SchoolDetailActivity.start(this, mUserTable.getSchool());
        }
    }
}
