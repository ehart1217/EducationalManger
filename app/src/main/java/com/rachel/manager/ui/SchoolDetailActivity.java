package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.CollegeTable;
import com.rachel.manager.database.SchoolTable;

import java.util.List;

/**
 * 学校详情页面
 * Created by Rachel on 17/4/4.
 */

public class SchoolDetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String KEY_SCHOOL_TABLE = "key_school_table";

    private TextView mNameTv;
    private TextView mEnNameTv;
    private TextView mShortNameTv;
    private TextView mTypeTv;
    private TextView mPropertyTv;
    private TextView mAreaTv;
    private TextView mAdvantageTv;
    private View mAllMajorBtn;

    private SchoolTable mSchoolTable;

    public static void start(Context context, SchoolTable schoolTable) {
        Intent starter = new Intent(context, SchoolDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SCHOOL_TABLE, schoolTable);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_school_detail);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Object extra = intent.getSerializableExtra(KEY_SCHOOL_TABLE);
        if (extra == null || !(extra instanceof SchoolTable)) {
            throw new IllegalArgumentException("使用start方法传递一个schoolTable对象。");
        }
        mSchoolTable = (SchoolTable) extra;

        findView();
        initData();
        addListener();


    }

    @Override
    protected void findView() {
        super.findView();
        mNameTv = (TextView) findViewById(R.id.activity_school_detail_name_tv);
        mEnNameTv = (TextView) findViewById(R.id.activity_school_detail_en_name_tv);
        mShortNameTv = (TextView) findViewById(R.id.activity_school_detail_short_name_tv);
        mTypeTv = (TextView) findViewById(R.id.activity_school_detail_type_tv);
        mPropertyTv = (TextView) findViewById(R.id.activity_school_detail_property_tv);
        mAreaTv = (TextView) findViewById(R.id.activity_school_detail_area_tv);
        mAdvantageTv = (TextView) findViewById(R.id.activity_school_detail_advantage_major_tv);
        mAllMajorBtn = findViewById(R.id.activity_school_detail_all_major_btn);
    }

    @Override
    protected void initData() {
        super.initData();

        setTitle(mSchoolTable.getName());
        setFunction("详情");

        mNameTv.setText(mSchoolTable.getName());
        mEnNameTv.setText(mSchoolTable.getEnName());
        mShortNameTv.setText(mSchoolTable.getShortName());
        mTypeTv.setText(mSchoolTable.getType());

        // 学校属性
        String property = "";
        if (mSchoolTable.is211()) {
            property += "211平台";
        }
        if (mSchoolTable.is985()) {
            property += "211平台,985平台";
        }
        mPropertyTv.setText(property);

        //
        mAreaTv.setText(mSchoolTable.getArea());

        // 优势专业
        List<CollegeTable> advantageList = mSchoolTable.getAdvantages();
        StringBuilder advantageSb = new StringBuilder();
        if (advantageList != null) {
            for (CollegeTable collegeTable : advantageList) {
                advantageSb.append(collegeTable.getName()).append(",");
            }
            if (advantageSb.length() > 0) {
                advantageSb.deleteCharAt(advantageSb.length() - 1);
            }
        }
        mAdvantageTv.setText(advantageSb.toString());

    }

    @Override
    protected void addListener() {
        super.addListener();
        mFunctionTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.common_function_tv:
                String url = mSchoolTable.getDetailLink();
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(this, "链接未找到！", Toast.LENGTH_SHORT).show();
                } else {
                    WebActivity.start(this, url);
                }
                break;
        }
    }
}
