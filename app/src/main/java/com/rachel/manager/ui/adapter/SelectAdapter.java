/* *
   * Copyright (C) 2017 BaoliYota Tech. Co., Ltd, LLC - All Rights Reserved.
   *
   * Confidential and Proprietary.
   * Unauthorized copying of this file, via any medium is strictly prohibited.
   * */

package com.rachel.manager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rachel.manager.R;

import java.util.List;

/**
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/5
 */
public class SelectAdapter extends BaseAdapter {

    private List<String> mCollegeTableList;

    private LayoutInflater mInflater;

    private int mCurrentSelectedIndex = 0;

    public SelectAdapter(Context context, List<String> majorTables) {
        super();
        mCollegeTableList = majorTables;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mCollegeTableList.size();
    }

    @Override
    public String getItem(int position) {
        return mCollegeTableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nameTv;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_college_layout, parent, false);
            nameTv = (TextView) convertView.findViewById(R.id.item_college_tv);
            convertView.setTag(nameTv);
        } else {
            nameTv = (TextView) convertView.getTag();
        }

        if (position == mCurrentSelectedIndex) {
            nameTv.setBackgroundResource(R.color.white);
        } else {
            nameTv.setBackgroundResource(R.color.gray);
        }

        String name = getItem(position);
        nameTv.setText(name);
        return convertView;
    }

    public void setSelectedIndex(int index) {
        if (index < 0) {
            index = 0;
        }
        if (index > getCount() - 1) {
            index = getCount() - 1;
        }

        mCurrentSelectedIndex = index;
        notifyDataSetChanged();
    }
}

