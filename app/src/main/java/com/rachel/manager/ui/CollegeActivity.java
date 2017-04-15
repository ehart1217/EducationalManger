package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.CollegeTable;
import com.rachel.manager.database.MajorTable;
import com.rachel.manager.database.SchoolTable;
import com.rachel.manager.ui.adapter.MajorAdapter;
import com.rachel.manager.ui.adapter.SelectAdapter;
import com.rachel.manager.ui.picker.BaseEditDialog;
import com.rachel.manager.ui.picker.DateEditDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院列表页面
 * Created by Rachel on 17/4/5.
 */

public class CollegeActivity extends BaseActivity {

    private final static String KEY_SCHOOL_TABLE = "key_school_table";

    private SchoolTable mSchoolTable;
    private ListView mCollegeLv;
    private ListView mMajorLv;

    private SelectAdapter mCollegeAdapter;
    private MajorAdapter mMajorAdapter;
    private List<CollegeTable> mCollegeTableList;
    private List<String> mYearList = new ArrayList<>();

    private String mSelectedYear = "";
    private DateEditDialog mDialog;
    private CollegeTable mCurrentCollege;

    public static void start(Context context, SchoolTable schoolTable) {
        Intent starter = new Intent(context, CollegeActivity.class);
        starter.putExtra(KEY_SCHOOL_TABLE, schoolTable);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSchoolTable = (SchoolTable) getIntent().getSerializableExtra(KEY_SCHOOL_TABLE);
        if (mSchoolTable == null) {
            throw new IllegalArgumentException("school table cannot be null!");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mCollegeLv = (ListView) findViewById(R.id.activity_college_list_lv);
        mMajorLv = (ListView) findViewById(R.id.activity_major_list_lv);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mCollegeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 学院item被点击
                mCollegeAdapter.setSelectedIndex(position);
                mCurrentCollege = mCollegeTableList.get(position);
                updateView(mSelectedYear);
            }
        });

        mMajorLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 跳转到具体专业
                MajorTable majorTable = mMajorAdapter.getItem(position);
                MajorDetailActivity.start(CollegeActivity.this, majorTable.getId(), mSchoolTable.getId());
            }
        });

        mFunctionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = mFunctionTv.getText().toString();
                showChooseYearDialog(year);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        // 标题
        setTitle(mSchoolTable.getName());

        mCollegeTableList = mSchoolTable.getColleges();
        if (mCollegeTableList == null) {
            mCollegeTableList = new ArrayList<>();
        }
        mCollegeAdapter = new SelectAdapter(this, extractNameList(mCollegeTableList));
        mCollegeLv.setAdapter(mCollegeAdapter);

        List<MajorTable> majorTableList;

        if (mCollegeTableList.isEmpty()) {
            majorTableList = new ArrayList<>();
        } else {
            mCurrentCollege = mCollegeTableList.get(0);
            mYearList.addAll(mCurrentCollege.getYearList());
            if (mYearList.isEmpty()) {
                majorTableList = new ArrayList<>();
            } else {
                String year = mYearList.get(0);
                setFunctionWithArrow(year + "年");
                majorTableList = mCurrentCollege.getMajorByYear(mYearList.get(0));
            }
        }
        mMajorAdapter = new MajorAdapter(this, majorTableList);
        mMajorLv.setAdapter(mMajorAdapter);
    }

    private List<String> extractNameList(List<CollegeTable> tableList) {
        List<String> nameList = new ArrayList<>();
        for (CollegeTable collegeTable : tableList) {
            nameList.add(collegeTable.getName());
        }
        return nameList;
    }

    private void showChooseYearDialog(String defaultYear) {
        if (mDialog == null) {
            mDialog = new DateEditDialog(CollegeActivity.this);
            mDialog.setOnEditResult(new BaseEditDialog.OnEditResult() {
                @Override
                public void onResult(@NonNull Object... results) {
                    if (results.length == 0) {
                        return;
                    }
                    mSelectedYear = (String) results[0];
                    updateView(mSelectedYear);
                }
            });
        }
        mDialog.setData(mYearList, defaultYear);
        mDialog.show();
    }

    private void updateView(String year) {
        mYearList.clear();
        mYearList.addAll(mCurrentCollege.getYearList());

        if (mYearList.size() > 0) {
            if (TextUtils.isEmpty(year) || !mYearList.contains(year)) {
                year = mYearList.get(0);
            }
        }
        setFunctionWithArrow(year + "年");
        List<MajorTable> majorTables = mCurrentCollege.getMajorByYear(year);
        mMajorAdapter.update(majorTables);
    }
}
