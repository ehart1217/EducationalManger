package com.rachel.manager.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.rachel.manager.R;
import com.rachel.manager.base.BaseActivity;
import com.rachel.manager.database.DataBaseManager;
import com.rachel.manager.database.SchoolTable;
import com.rachel.manager.helper.OnTouchEffectedListener;
import com.rachel.manager.ui.adapter.SchoolDescAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.rachel.manager.R.id.filter_985;
import static com.rachel.manager.R.id.filter_area;

public class MainActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView mSchoolLv;
    private View mMeBtn;
    private View mRankBtn;
    private View mFilterBtn;

    private SchoolDescAdapter mSchoolAdapter;
    private PopupWindow mPopupWindow;

    private final static int REQUEST_CODE_AREA = 1;
    private final static int REQUEST_CODE_MAJOR = 2;
    private EditText mSearchEt;

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
        mSearchEt = (EditText) findViewById(R.id.activity_main_search_et);
    }

    @Override
    protected void initData() {
        super.initData();

        mSchoolAdapter = new SchoolDescAdapter(this, DataBaseManager.queryAllSchool());
        mSchoolLv.setAdapter(mSchoolAdapter);
        setTitle("");
    }

    @Override
    protected void addListener() {
        super.addListener();
        mMeBtn.setOnClickListener(this);
        mRankBtn.setOnClickListener(this);
        mFilterBtn.setOnClickListener(this);

        mMeBtn.setOnTouchListener(new OnTouchEffectedListener());
        mRankBtn.setOnTouchListener(new OnTouchEffectedListener());
        mFilterBtn.setOnTouchListener(new OnTouchEffectedListener());

        mSchoolLv.setOnItemClickListener(this);

        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    updateSchool(DataBaseManager.queryAllSchool());
                } else{
                    updateSchool(DataBaseManager.querySchoolBySubject(s.toString()));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.activity_main_me_btn:
                MeActivity.start(this);
                break;
            case R.id.activity_main_rank_btn:
                RankActivity.start(this);
                break;
            case R.id.activity_main_filter_btn:
                // 筛选
                showFilterMenu();
                break;
            case R.id.filter_area:
                mPopupWindow.dismiss();
                ArrayList<String> areaList = DataBaseManager.queryAllSchoolAreas();
                FilterConditionActivity.startForResult(this, "地区", areaList, REQUEST_CODE_AREA);
                break;
            case R.id.filter_major:
                mPopupWindow.dismiss();
                ArrayList<String> majorList = DataBaseManager.queryAllSchoolMajors();
                FilterConditionActivity.startForResult(this, "专业", majorList, REQUEST_CODE_MAJOR);
                break;
            case R.id.filter_985:
                updateSchool(DataBaseManager.query985School());
                mPopupWindow.dismiss();
                afterFilter();
                break;
            case R.id.filter_211:
                updateSchool(DataBaseManager.query211School());
                mPopupWindow.dismiss();
                afterFilter();
                break;
            case R.id.filter_no_condition:
                updateSchool(DataBaseManager.queryAllSchool());
                mPopupWindow.dismiss();
                setTitle("");
                break;
        }
    }

    // 筛选菜单
    private void showFilterMenu() {
        if (mPopupWindow == null) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View contentView = inflater.inflate(R.layout.popup_window_filter, null);
            View areaMenu = contentView.findViewById(filter_area);
            View majorMenu = contentView.findViewById(R.id.filter_major);
            View menu985 = contentView.findViewById(filter_985);
            View menu211 = contentView.findViewById(R.id.filter_211);
            View noFilter = contentView.findViewById(R.id.filter_no_condition);

            areaMenu.setOnClickListener(this);
            majorMenu.setOnClickListener(this);
            menu985.setOnClickListener(this);
            menu211.setOnClickListener(this);
            noFilter.setOnClickListener(this);

            mPopupWindow = new PopupWindow(this);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setContentView(contentView);
        }
        mPopupWindow.showAsDropDown(mFilterBtn);
        mPopupWindow.update(mFilterBtn, 0, 0, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void afterFilter() {
        setTitle("已筛选");
    }

    private void updateSchool(List<SchoolTable> schoolTableList) {
        mSchoolAdapter.update(schoolTableList);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SchoolTable schoolTable = mSchoolAdapter.getItem(position);
        SchoolDetailActivity.start(this, schoolTable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_AREA) {
                String area = data.getStringExtra(FilterConditionActivity.KEY_FILTER_CONTENT);
                updateSchool(DataBaseManager.querySchoolByArea(area));
            } else if (requestCode == REQUEST_CODE_MAJOR) {
                String major = data.getStringExtra(FilterConditionActivity.KEY_FILTER_CONTENT);
                updateSchool(DataBaseManager.querySchoolByMajor(major));
            }
            afterFilter();
        }
    }
}
