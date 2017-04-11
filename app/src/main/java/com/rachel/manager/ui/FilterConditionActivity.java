package com.rachel.manager.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.ui.adapter.FilterAdapter;

import java.util.ArrayList;

/**
 * Created by Rachel on 17/4/12.
 */

public class FilterConditionActivity extends BaseActivity {

    public final static String KEY_FILTER_CONTENT = "key_filter_content";
    private final static String KEY_TITLE = "key_title";
    private final static String KEY_CONTENT = "key_content";
    private ListView mListView;
    private String mTitle;
    private ArrayList<String> mContentList;

    public static void startForResult(Activity activity, String filterTitle, ArrayList<String> contentList, int requestCode) {
        Intent starter = new Intent(activity, FilterConditionActivity.class);
        starter.putExtra(KEY_TITLE, filterTitle);
        starter.putStringArrayListExtra(KEY_CONTENT, contentList);
        activity.startActivityForResult(starter,requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        mTitle = getIntent().getStringExtra(KEY_TITLE);
        mContentList = getIntent().getStringArrayListExtra(KEY_CONTENT);

        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mListView = (ListView) findViewById(R.id.activity_filter_lv);
    }

    @Override
    protected void initData() {
        super.initData();
        setTitle("筛选" + mTitle);
        FilterAdapter adapter = new FilterAdapter(this, mContentList);
        mListView.setAdapter(adapter);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String filterContent = mContentList.get(position);
                Intent intent = new Intent();
                intent.putExtra(KEY_FILTER_CONTENT, filterContent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
