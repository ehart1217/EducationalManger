package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.CollegeTable;
import com.rachel.manager.database.MajorTable;
import com.rachel.manager.database.SchoolTable;
import com.rachel.manager.ui.adapter.CollegeAdapter;
import com.rachel.manager.ui.adapter.MajorAdapter;

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

    private CollegeAdapter mCollegeAdapter;
    private MajorAdapter mMajorAdapter;

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

        setContentView(R.layout.activity_college_list);
        super.onCreate(savedInstanceState);
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

                List<MajorTable> majorTables = mCollegeAdapter.getItem(position).getMajors();
                if(majorTables == null){
                    majorTables = new ArrayList<>();
                }
                mMajorAdapter.update(majorTables);
            }
        });

        mMajorLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 跳转到具体专业
                MajorTable majorTable = mMajorAdapter.getItem(position);
                MajorDetailActivity.start(CollegeActivity.this, majorTable.getId(),mSchoolTable.getId());
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        setTitle(mSchoolTable.getName());
        List<CollegeTable> collegeTableList = mSchoolTable.getColleges();
        if (collegeTableList == null) {
            collegeTableList = new ArrayList<>();
        }
        mCollegeAdapter = new CollegeAdapter(this, collegeTableList);
        mCollegeLv.setAdapter(mCollegeAdapter);

        List<MajorTable> majorTableList;
        if (collegeTableList.isEmpty()) {
            majorTableList = new ArrayList<>();
        } else {
            majorTableList = collegeTableList.get(0).getMajors();
        }
        if(majorTableList == null){
            majorTableList = new ArrayList<>();
        }
        mMajorAdapter = new MajorAdapter(this, majorTableList);
        mMajorLv.setAdapter(mMajorAdapter);
    }
}
