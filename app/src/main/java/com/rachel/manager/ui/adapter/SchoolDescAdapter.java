package com.rachel.manager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rachel.manager.R;
import com.rachel.manager.database.SchoolTable;

import java.util.List;

/**
 * 学校列表的适配器
 * Created by Rachel on 17/4/4.
 */

public class SchoolDescAdapter extends BaseAdapter {

    private List<SchoolTable> mSchoolTableList;
    private LayoutInflater mInflater;

    public SchoolDescAdapter(Context context, List<SchoolTable> schoolTableList) {
        mSchoolTableList = schoolTableList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mSchoolTableList.size();
    }

    @Override
    public SchoolTable getItem(int position) {
        return mSchoolTableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_school_desc, parent, false);
            holder = new Holder();
            holder.iconIv = (ImageView) convertView.findViewById(R.id.item_school_icon);
            holder.nameTv = (TextView) convertView.findViewById(R.id.item_school_name_tv);
            holder.descTv = (TextView) convertView.findViewById(R.id.item_school_desc_tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        SchoolTable schoolTable = getItem(position);
        holder.nameTv.setText(schoolTable.getName());
        holder.descTv.setText(schoolTable.getDesc());
        if (schoolTable.getIcon() != 0) {
            try {
                holder.iconIv.setImageResource(schoolTable.getIcon());
            } catch (Exception e){
                holder.iconIv.setImageResource(R.drawable.yejidaxue);
            }
        } else {
            holder.iconIv.setImageResource(R.drawable.yejidaxue);
        }

        return convertView;
    }

    private static class Holder {
        ImageView iconIv;
        TextView nameTv;
        TextView descTv;
    }
}
