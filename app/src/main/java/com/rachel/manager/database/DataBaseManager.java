package com.rachel.manager.database;

import android.content.Context;

import com.litesuits.orm.LiteOrm;

import java.util.List;

/**
 * 数据库管理
 * Created by Rachel on 17/4/2.
 */

public class DataBaseManager {

    private static final String DATA_BASE_NAME = "educational";

    private static LiteOrm mLiteOrm;

    public static LiteOrm getDateBase(Context context){
        if (mLiteOrm == null) {
            mLiteOrm = LiteOrm.newCascadeInstance(context,DATA_BASE_NAME);
        }
        return mLiteOrm;
    }

    public static UserTable getCurrentUser(){
        return UserCache.get();
    }

    public static List<SchoolTable> queryAllSchool(){
        return mLiteOrm.query(SchoolTable.class);
    }
}