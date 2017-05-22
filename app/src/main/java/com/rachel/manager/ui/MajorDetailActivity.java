package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.MajorTable;
import com.rachel.manager.database.UserTable;

/**
 * 专业页面
 * Created by Rachel on 17/4/6.
 */

public class MajorDetailActivity extends BaseActivity implements View.OnClickListener {

    private final static String KEY_MAJOR_ID = "key_major_table";
    private final static String KEY_SCHOOL_ID = "key_school_table";
    private final static int KEY_REQUEST_EDIT_CODE = 0;

    private MajorTable mMajorTable;
    private TextView mCodeTv;
    private TextView mYearTv;
    private TextView mMajorCountTv;
    private TextView mCollegeCountTv;
    private TextView mLineTv;
    private TextView mSubjectTv;
    private TextView mRetestSubjectTv;
    private TextView mEditingTv;
    private View mMajorCountContainer;
    private View mCollegeCountContainer;
    private View mLineContainer;

    private int mSchoolId;
    private View mCommentBtn;

    public static void start(Context context, int majorId,int schoolId) {
        Intent starter = new Intent(context, MajorDetailActivity.class);
        starter.putExtra(KEY_MAJOR_ID, majorId);
        starter.putExtra(KEY_SCHOOL_ID, schoolId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int id = getIntent().getIntExtra(KEY_MAJOR_ID, 0);
        mSchoolId = getIntent().getIntExtra(KEY_SCHOOL_ID, 0);

        mMajorTable = DataBaseManager.queryById(id, MajorTable.class);
        if (mMajorTable == null) {
            Toast.makeText(this, "找不到该专业", Toast.LENGTH_SHORT).show();
            this.finish();
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

        mMajorCountContainer = findViewById(R.id.activity_major_detail_major_count_container);
        mCollegeCountContainer = findViewById(R.id.activity_major_detail_college_count_container);
        mLineContainer = findViewById(R.id.activity_major_detail_line_container);

        mCommentBtn = findViewById(R.id.activity_major_comment_btn);

        mMajorCountContainer.setTag(mMajorCountTv);
        mCollegeCountContainer.setTag(mCollegeCountTv);
        mLineContainer.setTag(mLineTv);
    }

    @Override
    protected void initData() {
        super.initData();
        initEditMark();
        setTitle(mMajorTable.getName());
        mCodeTv.setText(String.valueOf(mMajorTable.getMajorId()));
        mYearTv.setText(mMajorTable.getYear());
        mMajorCountTv.setText(String.valueOf(mMajorTable.getMajorEnrollmentCount()));
        mCollegeCountTv.setText(String.valueOf(mMajorTable.getEnrollmentCount()));
        mLineTv.setText(String.valueOf(mMajorTable.getLastAdmissionLine()));
        mSubjectTv.setText(mMajorTable.getSubjects());
        mRetestSubjectTv.setText(mMajorTable.getRetestSubjects());
    }

    private void initEditMark() {

        if (canEdit()) {
            View majorCountView = findViewById(R.id.activity_major_detail_major_count_iv);
            View collegeCountView = findViewById(R.id.activity_major_detail_college_count_iv);
            View lineView = findViewById(R.id.activity_major_detail_line_iv);

            majorCountView.setVisibility(View.VISIBLE);
            collegeCountView.setVisibility(View.VISIBLE);
            lineView.setVisibility(View.VISIBLE);
            setFunction("可编辑");
        }
    }

    @Override
    protected void addListener() {
        mCommentBtn.setOnClickListener(this);
        if (canEdit()) {
            super.addListener();
            mMajorCountContainer.setOnClickListener(this);
            mCollegeCountContainer.setOnClickListener(this);
            mLineContainer.setOnClickListener(this);
            mSubjectTv.setOnClickListener(this);
            mRetestSubjectTv.setOnClickListener(this);

            mMajorCountTv.setTag("院招生人数");
            mCollegeCountTv.setTag("本专业招生人数");
            mLineTv.setTag("去年分数线");
            mSubjectTv.setTag("考试科目");
            mRetestSubjectTv.setTag("复试科目");
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if(id == R.id.activity_major_comment_btn){
            CommentActivity.start(this, mMajorTable.getMajorId());
            return;
        }

        mEditingTv = null;
        if (v instanceof TextView) {
            mEditingTv = (TextView) v;
        } else if (v instanceof LinearLayout) {
            mEditingTv = (TextView) v.getTag();
        }
        if (mEditingTv == null) {
            return;
        }

        boolean large = v == mSubjectTv || v == mRetestSubjectTv;
        String title = (String) mEditingTv.getTag();
        EditActivity.startForResult(this, title, mEditingTv.getText().toString(), large, KEY_REQUEST_EDIT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == KEY_REQUEST_EDIT_CODE) {

                String content = data.getStringExtra(EditActivity.KEY_CONTENT);
                if (content == null || mEditingTv == null) {
                    return;
                }

                Integer contentInt = null;
                try {
                    contentInt = Integer.parseInt(content);
                } catch (NumberFormatException exception) {
                    // do nothing
                }

                if (mEditingTv == mMajorCountTv) {
                    // 专业招生
                    if (contentInt != null) {
                        mMajorTable.setMajorEnrollmentCount(contentInt);
                        mEditingTv.setText(content);
                    }
                } else if (mEditingTv == mCollegeCountTv) {
                    // 学院招生
                    if (contentInt != null) {
                        mMajorTable.setEnrollmentCount(contentInt);
                        mEditingTv.setText(content);
                    }
                } else if (mEditingTv == mLineTv) {
                    // 分数线
                    mMajorTable.setLastAdmissionLine(content);
                    mEditingTv.setText(content);
                } else if (mEditingTv == mSubjectTv) {
                    // 科目
                    mMajorTable.setSubjects(content);
                    mEditingTv.setText(content);
                } else if (mEditingTv == mRetestSubjectTv) {
                    // 复试科目
                    mMajorTable.setRetestSubjects(content);
                    mEditingTv.setText(content);
                }

                DataBaseManager.update(mMajorTable);
            }
        }
    }

    private boolean canEdit(){
        UserTable userTable = DataBaseManager.getCurrentUser();
        return userTable.getRole() == UserTable.ROLE_MANAGER;
    }

}
