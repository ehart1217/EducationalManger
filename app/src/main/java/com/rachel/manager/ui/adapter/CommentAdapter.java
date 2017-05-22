package com.rachel.manager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rachel.manager.R;
import com.rachel.manager.database.CommentTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Rachel on 17/5/23.
 */

public class CommentAdapter extends BaseAdapter {


    private final Context mContext;
    private final List<CommentTable> mCommentTableList;
    private LayoutInflater mInflater;

    public CommentAdapter(Context context, List<CommentTable> commentTableList) {
        mContext = context;
        mCommentTableList = commentTableList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mCommentTableList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCommentTableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_comment, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.contentTv = (TextView) convertView.findViewById(R.id.item_comment_content_tv);
            viewHolder.userNameTv = (TextView) convertView.findViewById(R.id.item_comment_user_tv);
            viewHolder.dateTv = (TextView) convertView.findViewById(R.id.item_comment_date_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CommentTable commentTable = (CommentTable) getItem(position);
        viewHolder.contentTv.setText(commentTable.getComment());
        viewHolder.userNameTv.setText(commentTable.getUserName());

        String date = getDate(commentTable.getData());
        viewHolder.dateTv.setText(date);

        return convertView;
    }

    private String getDate(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Date d1 = new Date(time);
        return format.format(d1);
    }

    private static class ViewHolder {
        TextView userNameTv;
        TextView dateTv;
        TextView contentTv;
    }
}
