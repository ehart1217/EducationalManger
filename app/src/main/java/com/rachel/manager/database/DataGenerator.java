package com.rachel.manager.database;

import android.content.Context;
import android.util.Log;

import com.litesuits.orm.LiteOrm;
import com.rachel.manager.utils.MD5Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * 数据生成
 * Created by Rachel on 17/4/3.
 */

public class DataGenerator {

    private static Random random = new Random();
    private static int index = 0;

    public static void createData(Context context) {
        LiteOrm liteOrm = DataBaseManager.getDateBase(context);

        String psw = MD5Utils.encode("111111", MD5Utils.SALT);
        UserTable userTable = new UserTable("111111", psw, 2);
        userTable.setName("ehart2");

        List<SchoolTable> schoolTableList = DataGenerator.generateSchool();
        List<CollegeTable> toSaveCollegeTable = new ArrayList<>();
        List<MajorTable> toSaveMajor = new ArrayList<>();


        for (SchoolTable schoolTable : schoolTableList) {

            ArrayList<CollegeTable> collegeTableList = DataGenerator.generateCollegeTables();
            for (CollegeTable collegeTable : collegeTableList) {
                ArrayList<MajorTable> majorTableList = DataGenerator.generateMajors();
                collegeTable.setMajors(majorTableList);
//                liteOrm.save(majorTableList);
                toSaveMajor.addAll(majorTableList);
            }
            schoolTable.setAdvantages(getRandomAdvantages(collegeTableList));
            schoolTable.setColleges(collegeTableList);
            toSaveCollegeTable.addAll(collegeTableList);
//            liteOrm.save(collegeTableList);


            ArrayList<CollegeTable> advantageCollegeTableList = DataGenerator.generateCollegeTables();
            for (CollegeTable collegeTable : advantageCollegeTableList) {
                ArrayList<MajorTable> majorTableList = DataGenerator.generateMajors();
                collegeTable.setMajors(majorTableList);
//                liteOrm.save(majorTableList);
                toSaveMajor.addAll(majorTableList);
            }
            schoolTable.setColleges(advantageCollegeTableList);
//            liteOrm.save(advantageCollegeTableList);
            toSaveCollegeTable.addAll(advantageCollegeTableList);

            userTable.setSchool(schoolTable);
        }
        liteOrm.save(toSaveMajor);
        liteOrm.save(toSaveCollegeTable);
        liteOrm.save(schoolTableList);
        liteOrm.save(userTable);

    }

    public static String checkData(Context context) {
        LiteOrm liteOrm = DataBaseManager.getDateBase(context);
        List list = liteOrm.query(UserTable.class);
        Log.d(TAG, "checkData user:" + list);

        List listSchool = liteOrm.query(SchoolTable.class);
        Log.d(TAG, "checkData school:" + listSchool);

        List listCollege = liteOrm.query(CollegeTable.class);
        Log.d(TAG, "checkData College:" + listCollege);

        List listMajor = liteOrm.query(MajorTable.class);
        Log.d(TAG, "checkData Major:" + listMajor);

        return String.valueOf(list) + "\n" + listSchool + "\n" + listCollege + "\n" + listMajor;
    }

    public static void cleanData(Context context) {
        LiteOrm liteOrm = DataBaseManager.getDateBase(context);
        liteOrm.delete(UserTable.class);
        liteOrm.delete(SchoolTable.class);
        liteOrm.delete(CollegeTable.class);
        liteOrm.delete(MajorTable.class);
    }

    public static ArrayList<SchoolTable> generateSchool() {
        ArrayList<SchoolTable> schools = new ArrayList<>();
        SchoolTable school1 = new SchoolTable("野鸡大学");
        school1.setArea("北京");
        school1.setIs211(true);
        school1.setIs985(false);
        school1.setDetailLink("http://baike.baidu.com/item/%E9%87%8E%E9%B8%A1%E5%A4%A7%E5%AD%A6");
        school1.setEnName("wild chicken college");
        school1.setType("公立大学");
        school1.setShortName("野大");

        SchoolTable school2 = new SchoolTable("野鸡大学2");
        school2.setArea("沈阳");
        school2.setIs211(false);
        school2.setIs985(true);
        school2.setDetailLink("http://baike.baidu.com/item/%E7%89%9B%E9%AD%94%E7%8E%8B/4468?sefr=cr");
        school1.setEnName("yejidaxue");
        school1.setType("私立大学");
        school1.setShortName("野鸡");

        schools.add(school1);
        schools.add(school2);

        return schools;
    }

    public static ArrayList<MajorTable> generateMajors() {

        String major = "计算机";

        ArrayList<MajorTable> majorTables = new ArrayList<>();

        majorTables.add(generateMajor(major, "2015"));
        majorTables.add(generateMajor(major, "2016"));
        majorTables.add(generateMajor(major, "2017"));
        return majorTables;
    }

    public static ArrayList<CollegeTable> generateCollegeTables() {
        ArrayList<CollegeTable> collegeTables = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String name = "学院" + i;
            CollegeTable collegeTable = new CollegeTable(name.hashCode() + index++, name);
            collegeTables.add(collegeTable);
        }
        return collegeTables;
    }

    private static MajorTable generateMajor(String major, String year) {
        MajorTable majorTable = new MajorTable((major + year).hashCode(), year, major);
        majorTable.setEnrollmentCount(randomInt(100));
        majorTable.setLastAdmissionLine(500 + randomInt(100) + "");
        majorTable.setMajorEnrollmentCount(randomInt(20));

        ArrayList<String> subjects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            subjects.add(year + "年" + major + "专业课程" + i);
        }

        ArrayList<String> resetSubjects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            resetSubjects.add(year + "年" + major + "专业重修课程" + i);
        }

        majorTable.setSubjects(subjects);
        majorTable.setRetestSubjects(resetSubjects);
        return majorTable;
    }

    private static ArrayList<CollegeTable> getRandomAdvantages(List<CollegeTable> collegeTables) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();
        for (CollegeTable collegeTable : collegeTables) {
            if (collegeTableList.size() > 2) {
                return collegeTableList;
            }
            collegeTableList.add(collegeTable);
        }
        return collegeTableList;
    }

    private static int randomInt(int num) {
        return random.nextInt(num);
    }
}