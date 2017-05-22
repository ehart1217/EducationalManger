package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.CommentTable;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.ui.adapter.CommentAdapter;

import java.util.List;

import static com.rachel.manager.ui.EditActivity.KEY_CONTENT;

/**
 * Created by Rachel on 17/5/23.
 */

public class CommentActivity extends BaseActivity {

    private static final String KEY_MAJOR_ID = "key_major_id";
    private static final int REQUEST_CODE = 1;

    private ListView mCommentLv;
    private String majorId;

    public static void start(Context context, String majorId) {
        Intent starter = new Intent(context, CommentActivity.class);
        starter.putExtra(KEY_MAJOR_ID, majorId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        mCommentLv = (ListView) findViewById(R.id.activity_comment_lv);
    }

    @Override
    protected void initData() {
        super.initData();

        setTitle("评论");
        setFunction("写评论");

        majorId = getIntent().getStringExtra(KEY_MAJOR_ID);
        updateListView(majorId);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mFunctionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditActivity.startForResult(CommentActivity.this,"新的评论","",true,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE && data != null){
            String comment = data.getStringExtra(KEY_CONTENT);
            if(!TextUtils.isEmpty(comment)){
                long time = System.currentTimeMillis();
                String userName = DataBaseManager.getCurrentUser().getName();
                CommentTable c = new CommentTable(comment,time,majorId,userName);
                DataBaseManager.insert(c);
                updateListView(majorId);
            }
        }
    }

    private void updateListView(String majorId){
        List<CommentTable> commentTableList = DataBaseManager.queryCommentList(majorId);

        CommentAdapter adapter = new CommentAdapter(this, commentTableList);
        mCommentLv.setAdapter(adapter);
    }
}
