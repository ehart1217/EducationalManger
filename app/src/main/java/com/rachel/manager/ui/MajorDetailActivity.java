package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.MajorTable;
import com.rachel.manager.database.UserTable;

/**
 * 专业页面
 * Created by Rachel on 17/4/6.
 */

public class MajorDetailActivity extends BaseActivity {

    private final static String KEY_MAJOR_TABLE = "key_major_table";

    private MajorTable mMajorTable;
    private TextView mCodeTv;
    private TextView mYearTv;
    private TextView mMajorCountTv;
    private TextView mCollegeCountTv;
    private TextView mLineTv;
    private TextView mSubjectTv;
    private TextView mRetestSubjectTv;

    public static void start(Context context, MajorTable majorTable) {
        Intent starter = new Intent(context, MajorDetailActivity.class);
        starter.putExtra(KEY_MAJOR_TABLE, majorTable);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mMajorTable = (MajorTable) getIntent().getSerializableExtra(KEY_MAJOR_TABLE);
        if (mMajorTable == null) {
            throw new IllegalArgumentException("major table cannot be null!");
        }
        setContentView(R.layout.activity_major_detail);
        super.onCreate(savedInstanceState);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mCodeTv = (TextView) findViewById(R.id.activity_major_detail_code_tv);
        mYearTv = (TextView) findViewById(R.id.activity_major_detail_year_tv);
        mMajorCountTv = (TextView) findViewById(R.id.activity_major_detail_major_count_tv);
        mCollegeCountTv = (TextView) findViewById(R.id.activity_major_detail_college_count_tv);
        mLineTv = (TextView) findViewById(R.id.activity_major_detail_line_tv);
        mSubjectTv = (TextView) findViewById(R.id.activity_major_detail_subject);
        mRetestSubjectTv = (TextView) findViewById(R.id.activity_major_detail_retest_subject);
    }

    @Override
    protected void initData() {
        super.initData();
        initEditMark();
        mCodeTv.setText(mMajorTable.getName());
        mCodeTv.setText(String.valueOf(mMajorTable.getMajorId()));
        mYearTv.setText(mMajorTable.getYear());
        mMajorCountTv.setText(String.valueOf(mMajorTable.getMajorEnrollmentCount()));
        mCollegeCountTv.setText(String.valueOf(mMajorTable.getEnrollmentCount()));
        mLineTv.setText(String.valueOf(mMajorTable.getLastAdmissionLine()));

        mSubjectTv.setText(mMajorTable.getSubjects().toString());
        mRetestSubjectTv.setText(mMajorTable.getRetestSubjects().toString());
    }

    private void initEditMark() {

        if (DataBaseManager.getCurrentUser().getRole() == UserTable.ROLE_MANAGER) {
            View yearView = findViewById(R.id.activity_major_detail_year_iv);
            View majorCountView = findViewById(R.id.activity_major_detail_major_count_iv);
            View collegeCountView = findViewById(R.id.activity_major_detail_college_count_iv);
            View lineView = findViewById(R.id.activity_major_detail_line_iv);

            yearView.setVisibility(View.VISIBLE);
            majorCountView.setVisibility(View.VISIBLE);
            collegeCountView.setVisibility(View.VISIBLE);
            lineView.setVisibility(View.VISIBLE);
            setFunction("可编辑");
        }
    }

    @Override
    protected void addListener() {
        super.addListener();
    }
}
