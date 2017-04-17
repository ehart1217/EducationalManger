/* *
   * Copyright (C) 2017 BaoliYota Tech. Co., Ltd, LLC - All Rights Reserved.
   *
   * Confidential and Proprietary.
   * Unauthorized copying of this file, via any medium is strictly prohibited.
   * */

package com.rachel.manager.ui.picker;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.rachel.manager.R;

import java.util.List;

/**
 * 日期选择器
 *
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/12
 */
public class DateEditDialog extends BaseEditDialog implements View.OnClickListener {

    private final TextView mDescTv;
    private Context mContext;
    private final static int BEGIN_YEAR = 1940;
    private final static int SP_TEXT_SIZE_DEFAULT = 18;
    private final static String DEFAULT_SELECT_YEAR = "1990";
    private final WheelView mYearWheelView;

    public DateEditDialog(Context context) {
        super(context);
        mContext = context;
        mDialog.setContentView(R.layout.dialog_edit_date);

        mYearWheelView = (WheelView) mDialog.findViewById(R.id.dialog_edit_date_year);
        mDescTv = (TextView) mDialog.findViewById(R.id.dialog_edit_desc_tv);

        View okBtn = mDialog.findViewById(R.id.dialog_common_bottom_ok_btn);
        View cancelBtn = mDialog.findViewById(R.id.dialog_edit_common_bottom_btn);
        okBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    /**
     * 设置默认的年月
     */
    public void setData(List<String> yearList, String defaultYear) {
        initWheelView(mYearWheelView, yearList, defaultYear);
    }


    public void setDesc(String desc){
        if(TextUtils.isEmpty(desc)){
            mDescTv.setVisibility(View.GONE);
        }else {
            mDescTv.setVisibility(View.VISIBLE);
            mDescTv.setText(desc);
        }
    }

    private void initWheelView(WheelView wheelView, List<String> dataList, String selectData) {

        if (dataList == null || dataList.size() == 0) {
            return;
        }

        int colorSecond = mContext.getResources().getColor(R.color.white_80);
        int colorPrimary = mContext.getResources().getColor(R.color.white);
        wheelView.setTextColor(colorSecond, colorPrimary);
        wheelView.setTextSize(SP_TEXT_SIZE_DEFAULT);

        WheelView.LineConfig lineConfig = new WheelView.LineConfig();
        lineConfig.setColor(Color.WHITE);
        wheelView.setLineConfig(lineConfig);
        wheelView.setCycleDisable(false);

        if (!dataList.contains(selectData)) {
            selectData = dataList.get(0);
        }

        wheelView.setItems(dataList, selectData);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.dialog_common_bottom_ok_btn) {
            // ok
            mDialog.dismiss();
            if (mOnEditResult != null) {
                String year = mYearWheelView.getSelectedItem();
                mOnEditResult.onResult(year);
            }
        } else if (id == R.id.dialog_edit_common_bottom_btn) {
            // cancel
            mDialog.dismiss();
        }
    }
}

