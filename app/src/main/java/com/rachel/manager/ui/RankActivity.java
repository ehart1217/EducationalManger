package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.RankTable;
import com.rachel.manager.ui.adapter.SelectAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 排名
 * Created by Rachel on 17/4/10.
 */

public class RankActivity extends BaseActivity {

    private ArrayList<RankTable> mRankTables;
    private ListView mMajorLv;
    private TextView mContentTv;
    private SelectAdapter mMajorAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, RankActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mMajorLv = (ListView) findViewById(R.id.activity_rank_list_lv);
        mContentTv = (TextView) findViewById(R.id.activity_rank_content_tv);
    }

    @Override
    protected void initData() {
        super.initData();
        setTitle("专业排名");
        mRankTables = DataBaseManager.queryRanks();
        if(mRankTables == null || mRankTables.isEmpty()){
            return;
        }
        mMajorAdapter = new SelectAdapter(this, extractNameList(mRankTables));
        mMajorLv.setAdapter(mMajorAdapter);

        mContentTv.setText(mRankTables.get(0).getSchoolRanks());
    }

    @Override
    protected void addListener() {
        super.addListener();
        mMajorLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMajorAdapter.setSelectedIndex(position);
                mContentTv.setText(mRankTables.get(position).getSchoolRanks());
            }
        });
    }

    private List<String> extractNameList(List<RankTable> tableList) {
        List<String> nameList = new ArrayList<>();
        for (RankTable rankTable : tableList) {
            nameList.add(rankTable.getMajorName());
        }
        return nameList;
    }
}
