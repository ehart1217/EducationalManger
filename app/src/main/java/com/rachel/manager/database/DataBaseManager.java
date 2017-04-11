package com.rachel.manager.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库管理
 * Created by Rachel on 17/4/2.
 */
public class DataBaseManager {

    private static final String DATA_BASE_NAME = "educational";

    private static LiteOrm mLiteOrm;

    public static LiteOrm getDateBase(Context context) {
        if (mLiteOrm == null) {
            mLiteOrm = LiteOrm.newCascadeInstance(context, DATA_BASE_NAME);
            mLiteOrm.setDebugged(true);
        }
        return mLiteOrm;
    }

    public static UserTable getCurrentUser() {
        return UserCache.get();
    }

    public static void clearUser() {

    }

    public static ArrayList<RankTable> queryRanks() {
        return mLiteOrm.query(RankTable.class);
    }

    @NonNull
    public static List<SchoolTable> queryAllSchool() {
        ArrayList<SchoolTable> schoolTables = mLiteOrm.query(SchoolTable.class);
        return schoolTables == null ? new ArrayList<SchoolTable>() : schoolTables;
    }

    @NonNull
    public static List<SchoolTable> query211School() {
        ArrayList<SchoolTable> schoolTables = mLiteOrm.query(new QueryBuilder<>(SchoolTable.class)
                .where(SchoolTable.COL_211 + " = ?", "true")
                .whereOr(SchoolTable.COL_985 + " = ?", "true"));
        return schoolTables == null ? new ArrayList<SchoolTable>() : schoolTables;
    }

    @NonNull
    public static List<SchoolTable> query985School() {
        ArrayList<SchoolTable> schoolTables = mLiteOrm.query(new QueryBuilder<>(SchoolTable.class)
                .where(SchoolTable.COL_985 + " = ?", "true"));
        return schoolTables == null ? new ArrayList<SchoolTable>() : schoolTables;
    }

    @NonNull
    public static ArrayList<String> queryAllSchoolAreas() {
        ArrayList<SchoolTable> schoolTableList = mLiteOrm.query(new QueryBuilder<>(SchoolTable.class)
                .columns(new String[]{SchoolTable.COL_AREA}).distinct(true));
        ArrayList<String> areas = new ArrayList<>();
        if (schoolTableList != null) {
            for (SchoolTable schoolTable : schoolTableList) {
                String area = schoolTable.getArea();
                if(!TextUtils.isEmpty(area)){
                    areas.add(area);
                }
            }
        }
        return areas;
    }

    public static void update(Object o) {
        mLiteOrm.update(o);
        updateCache();
    }

    public static <T> T queryById(long id, Class<T> tClass) {
        return mLiteOrm.queryById(id, tClass);
    }

    public static void updateCache() {
        UserTable userTable = getCurrentUser();
        int id = userTable.getId();
        userTable = mLiteOrm.queryById(id, UserTable.class);
        UserCache.init(userTable);
    }
}
