package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.SchoolTable;
import com.rachel.manager.helper.OnTouchEffectedListener;
import com.rachel.manager.ui.adapter.SchoolDescAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener ,AdapterView.OnItemClickListener{

    private ListView mSchoolLv;
    private View mMeBtn;
    private View mRankBtn;
    private View mFilterBtn;

    private SchoolDescAdapter mSchoolAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mSchoolLv = (ListView) findViewById(R.id.activity_main_lv);
        mMeBtn = findViewById(R.id.activity_main_me_btn);
        mRankBtn = findViewById(R.id.activity_main_rank_btn);
        mFilterBtn = findViewById(R.id.activity_main_filter_btn);
    }

    @Override
    protected void initData() {
        super.initData();

        mSchoolAdapter = new SchoolDescAdapter(this, DataBaseManager.queryAllSchool());
        mSchoolLv.setAdapter(mSchoolAdapter);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mMeBtn.setOnClickListener(this);
        mRankBtn.setOnClickListener(this);
        mFilterBtn.setOnClickListener(this);

        mMeBtn.setOnTouchListener(new OnTouchEffectedListener());
        mRankBtn.setOnTouchListener(new OnTouchEffectedListener());
        mFilterBtn .setOnTouchListener(new OnTouchEffectedListener());

        mSchoolLv.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.activity_main_me_btn:
                break;
            case R.id.activity_main_rank_btn:
                break;
            case R.id.activity_main_filter_btn:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SchoolTable schoolTable = mSchoolAdapter.getItem(position);
        SchoolDetailActivity.start(this,schoolTable);
    }
}
