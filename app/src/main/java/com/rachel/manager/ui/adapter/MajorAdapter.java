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
import com.rachel.manager.database.MajorTable;

import java.util.List;

/**
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/5
 */
public class MajorAdapter extends BaseAdapter {

    private List<MajorTable> mMajorTableList;

    private LayoutInflater mInflater;

    public MajorAdapter(Context context, List<MajorTable> majorTables) {
        super();
        mMajorTableList = majorTables;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMajorTableList.size();
    }

    @Override
    public MajorTable getItem(int position) {
        return mMajorTableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nameTv;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_major_layout, parent, false);
            nameTv = (TextView) convertView.findViewById(R.id.item_major_name_tv);
            convertView.setTag(nameTv);
        } else {
            nameTv = (TextView) convertView.getTag();
        }

        String name = getItem(position).getName();
        nameTv.setText(name);
        return convertView;
    }

    public void update(List<MajorTable> majorTables) {
        mMajorTableList.clear();
        mMajorTableList.addAll(majorTables);
        notifyDataSetChanged();
    }

}

