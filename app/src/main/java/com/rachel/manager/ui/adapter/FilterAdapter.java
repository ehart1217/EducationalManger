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
public class FilterAdapter extends BaseAdapter {

    private List<String> mContentList;

    private LayoutInflater mInflater;

    public FilterAdapter(Context context, List<String> contentList) {
        super();
        mContentList = contentList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mContentList.size();
    }

    @Override
    public String getItem(int position) {
        return mContentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nameTv;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_filter_layout, parent, false);
            nameTv = (TextView) convertView.findViewById(R.id.item_filter_tv);
            convertView.setTag(nameTv);
        } else {
            nameTv = (TextView) convertView.getTag();
        }

        String name = getItem(position);
        nameTv.setText(name);
        return convertView;
    }
}

