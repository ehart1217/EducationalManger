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

    public static LiteOrm init(Context context) {
        if (mLiteOrm == null) {
            mLiteOrm = LiteOrm.newCascadeInstance(context, DATA_BASE_NAME);
            mLiteOrm.setDebugged(true);
        }
        return mLiteOrm;
    }

    public static LiteOrm getLiteOrm() {
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
    public static List<SchoolTable> querySchoolByArea(String area) {
        ArrayList<SchoolTable> schoolTables = mLiteOrm.query(new QueryBuilder<>(SchoolTable.class)
                .where(SchoolTable.COL_AREA + " = ?", area));
        return schoolTables == null ? new ArrayList<SchoolTable>() : schoolTables;
    }

    public static List<SchoolTable> querySchoolBySubject(String subject) {
        ArrayList<MajorTable> majorTables = mLiteOrm.query(new QueryBuilder<>(MajorTable.class)
                .where(MajorTable.COL_SUBJECTS + " like  '%" + subject + "%'"));
        if (majorTables == null) {
            return new ArrayList<>();
        }
        return querySchoolByMajorList(majorTables);
    }

    public static List<SchoolTable> querySchoolByMajor(String major) {
        ArrayList<MajorTable> majorTables = mLiteOrm.query(new QueryBuilder<>(MajorTable.class)
                .where(MajorTable.COL_MAJOR_NAME + " = ?", major));
        if (majorTables == null) {
            return new ArrayList<>();
        }
        return querySchoolByMajorList(majorTables);
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
                if (!TextUtils.isEmpty(area)) {
                    areas.add(area);
                }
            }
        }
        return areas;
    }

    public static ArrayList<String> queryAllSchoolMajors() {
        ArrayList<MajorTable> majorTables = mLiteOrm.query(new QueryBuilder<>(MajorTable.class)
                .columns(new String[]{MajorTable.COL_MAJOR_NAME}).distinct(true));
        ArrayList<String> majors = new ArrayList<>();
        if (majorTables != null) {
            for (MajorTable majorTable : majorTables) {
                String name = majorTable.getName();
                if (!TextUtils.isEmpty(name)) {
                    majors.add(name);
                }
            }
        }
        return majors;
    }

    public static void update(Object o) {
        mLiteOrm.update(o);
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

    public static boolean checkUserDuplicate(String userName) {
        UserTable result = queryUserByUserName(userName);
        return result != null;
    }

    public static UserTable queryUserByUserName(String userName) {
        List<UserTable> userTables = mLiteOrm.query(new QueryBuilder<>(UserTable.class)
                .where(UserTable.COL_USER_NAME + "=" + userName));
        if(userTables != null && userTables.size() > 0){
            return userTables.get(0);
        }
        return null;
    }

    private static List<SchoolTable> querySchoolByMajorList(ArrayList<MajorTable> majorTables) {
        if (majorTables == null || majorTables.size() == 0) {
            return new ArrayList<>();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (MajorTable majorTable : majorTables) {
            stringBuilder.append('\'').append(majorTable.getSchoolName()).append('\'').append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(')');

        ArrayList<SchoolTable> schoolTables = mLiteOrm.query(new QueryBuilder<>(SchoolTable.class)
                .where(SchoolTable.COL_NAME + " IN " + stringBuilder.toString()));
        return schoolTables == null ? new ArrayList<SchoolTable>() : schoolTables;
    }

    public static void newUser(UserTable userTable) {
        mLiteOrm.save(userTable);
    }
}
