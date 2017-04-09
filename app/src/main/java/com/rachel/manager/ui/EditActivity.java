package com.rachel.manager.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;

/**
 * 用来编辑的页面
 * Created by Rachel on 17/4/9.
 */

public class EditActivity extends BaseActivity implements View.OnClickListener {

    private final static String KEY_TITLE = "key_title";
    public final static String KEY_CONTENT = "key_content";
    private final static String KEY_LARGE = "key_large";
    private String mTitle;
    private String mContent;
    private boolean large; //是否需要大号的编辑框
    private EditText mEditText;

    public static void startForResult(Activity activity, String title, String content, int requestCode) {
        startForResult(activity, title, content, false, requestCode);
    }

    public static void startForResult(Activity activity, String title, String content, boolean large, int requestCode) {
        Intent starter = new Intent(activity, EditActivity.class);
        starter.putExtra(KEY_TITLE, title);
        starter.putExtra(KEY_CONTENT, content);
        starter.putExtra(KEY_LARGE, large);
        activity.startActivityForResult(starter, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mTitle = getIntent().getStringExtra(KEY_TITLE);
        mContent = getIntent().getStringExtra(KEY_CONTENT);
        large = getIntent().getBooleanExtra(KEY_LARGE, false);
        if (mTitle == null) {
            mTitle = "";
        }
        if (mContent == null) {
            mContent = "";
        }

        findView();
        initData();
        addListener();
    }

    @Override
    protected void findView() {
        super.findView();
        EditText editLargeText = (EditText) findViewById(R.id.activity_edit_large_et);
        EditText editSmallText = (EditText) findViewById(R.id.activity_edit_small_et);
        if (large) {
            mEditText = editLargeText;
            editLargeText.setVisibility(View.VISIBLE);
            editSmallText.setVisibility(View.GONE);
        } else {
            mEditText = editSmallText;
            editLargeText.setVisibility(View.GONE);
            editSmallText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        setTitle(mTitle);
        setFunction("保存");
        mEditText.setText(mContent);
        mEditText.setHint("请输入" + mTitle);
        if (!TextUtils.isEmpty(mTitle)) {
            mEditText.setSelection(0, mContent.length());
        }
    }

    @Override
    protected void addListener() {
        super.addListener();
        mFunctionTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.common_function_tv) {
            // 保存
            Intent intent = new Intent();
            intent.putExtra(KEY_CONTENT, mEditText.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
