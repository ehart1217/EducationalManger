package com.rachel.manager.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.rachel.manager.R;

/**
 * 基础页面
 * Created by Rachel on 17/4/2.
 */

public class BaseActivity extends Activity {

    private TextView mTitleTv;
    protected TextView mFunctionTv;
    private View mBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitleTv = (TextView) findViewById(R.id.common_title_content_tv);
        mFunctionTv = (TextView) findViewById(R.id.common_function_tv);
        mBackBtn = findViewById(R.id.common_title_back_btn);

        if (mBackBtn != null) {
            mBackBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseActivity.this.finish();
                }
            });
        }
    }

    protected void findView() {
    }

    protected void initData() {
    }

    protected void addListener() {
    }

    protected void setTitle(String title) {
        if (mTitleTv != null) {
            if (TextUtils.isEmpty(title)) {
                mTitleTv.setVisibility(View.GONE);
            } else {
                mTitleTv.setVisibility(View.VISIBLE);
                mTitleTv.setText(title);
            }
        }
    }

    protected void setFunction(String function) {
        if (mFunctionTv != null) {
            if (TextUtils.isEmpty(function)) {
                mFunctionTv.setVisibility(View.GONE);
            } else {
                mFunctionTv.setVisibility(View.VISIBLE);
                mFunctionTv.setText(function);
            }
        }
    }

}
