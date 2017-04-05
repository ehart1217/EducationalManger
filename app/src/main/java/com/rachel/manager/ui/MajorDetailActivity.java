package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.MajorTable;

/**
 * 专业页面
 * Created by Rachel on 17/4/6.
 */

public class MajorDetailActivity extends BaseActivity {

    private final static String KEY_MAJOR_TABLE = "key_major_table";

    private MajorTable mMajorTable;

    public static void start(Context context, MajorTable majorTable) {
        Intent starter = new Intent(context, MajorDetailActivity.class);
        starter.putExtra(KEY_MAJOR_TABLE,majorTable);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mMajorTable = (MajorTable) getIntent().getSerializableExtra(KEY_MAJOR_TABLE);
        if(mMajorTable == null){
            throw new IllegalArgumentException("major table cannot be null!");
        }

        super.onCreate(savedInstanceState);

    }
}
