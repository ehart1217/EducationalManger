package com.rachel.manager.database;

import android.content.Context;
import android.util.Log;

import com.litesuits.orm.LiteOrm;
import com.rachel.manager.R;
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
        UserTable userTable = new UserTable("111111", psw, 0);
        userTable.setName("ehart");

        String psw2 = MD5Utils.encode("222222", MD5Utils.SALT);
        UserTable userTable2 = new UserTable("222222", psw2, 1);
        userTable2.setName("Rachel");

        List<SchoolTable> schoolTableList = DataGenerator.generateSchool();
        List<CollegeTable> toSaveCollegeTable = new ArrayList<>();
        List<MajorTable> toSaveMajor = new ArrayList<>();


        for (SchoolTable schoolTable : schoolTableList) {

            ArrayList<CollegeTable> collegeTableList = DataGenerator.generateCollegeTables(schoolTable.getName().hashCode());
            for (CollegeTable collegeTable : collegeTableList) {
                ArrayList<MajorTable> majorTableList = DataGenerator.generateMajors(collegeTable.getName() + "的软件工程", collegeTable.getCollegeId());
                majorTableList.addAll(DataGenerator.generateMajors(collegeTable.getName() + "的建筑设计", collegeTable.getCollegeId()));
                collegeTable.setMajors(majorTableList);
//                liteOrm.save(majorTableList);
                toSaveMajor.addAll(majorTableList);
            }
            schoolTable.setAdvantages(getRandomAdvantages(collegeTableList));
            schoolTable.setColleges(collegeTableList);
            toSaveCollegeTable.addAll(collegeTableList);

            if("辽宁大学".equals(schoolTable.getName())){
                userTable2.setSchool(schoolTable);
            }
        }
        liteOrm.save(toSaveMajor);
        liteOrm.save(toSaveCollegeTable);
        liteOrm.save(schoolTableList);

        liteOrm.save(userTable2);
        liteOrm.save(userTable);

        liteOrm.save(generateRankTable());
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
        SchoolTable school1 = new SchoolTable("辽宁大学");
        school1.setArea("沈阳");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=8SEJfsFFai0d06NAGMNl9PhBle-bIiDhTgvTlZnlxRcAb6rgLVyyju2hxTkytb4IOrN5vjfiv99vA5GPbOQeOFBJlBIwQC4EePZRthvoB7b6mj3_YrjY8cn6zSDbLS8i");
        school1.setEnName("Liaoning University");
        school1.setType("公立大学");
        school1.setShortName("辽大");
        school1.setDesc("辽宁大学（Liaoning University）是辽宁省人民政府主管的一所具备文、史、哲、经、法、理、工、管、艺等九大学科门类的综合性重点大学，是国家“211工程”重点建设院校，是卓越法律人才教育培养计划入选院校，是设有国家经济学基础人才培养基地的十三所高校之一。");
        school1.setIcon(R.drawable.liaoningdaxue);

        SchoolTable school2 = new SchoolTable("野鸡大学2");
        school2.setArea("沈阳");
        school2.setIs211(false);
        school2.setIs985(true);
        school2.setDetailLink("http://baike.baidu.com/item/%E7%89%9B%E9%AD%94%E7%8E%8B/4468?sefr=cr");
        school2.setEnName("wild chicken college");
        school2.setType("公立大学");
        school2.setShortName("野大");
        school2.setDesc("野鸡大学也称“学历工厂”、“虚假大学”、“学店”，其办学以营利为目的，通常采用与知名大学院校容易混淆的名称，以混淆视听的方式招收学生，以各种手段钻相关国家法律漏洞，滥发文凭。");
        school2.setIcon(R.drawable.yejidaxue);

        schools.add(school1);
        schools.add(school2);

        return schools;
    }

    public static ArrayList<MajorTable> generateMajors(String majorName, long collegeId) {

        ArrayList<MajorTable> majorTables = new ArrayList<>();

        majorTables.add(generateMajor(majorName, "2015", collegeId));
        majorTables.add(generateMajor(majorName, "2016", collegeId));
        majorTables.add(generateMajor(majorName, "2017", collegeId));
        return majorTables;
    }

    public static ArrayList<CollegeTable> generateCollegeTables(int schoolId) {
        ArrayList<CollegeTable> collegeTables = new ArrayList<>();
        String[] nameArray = new String[]{"计算机","自动化","信息工程","工商管理","土木工程","新闻学"};
        for (int i = 0; i < nameArray.length; i++) {
            String name = nameArray[i];
            CollegeTable collegeTable = new CollegeTable(name.hashCode() + schoolId, name);
            collegeTables.add(collegeTable);
        }
        return collegeTables;
    }

    private static MajorTable generateMajor(String major, String year, long schoolId) {
        MajorTable majorTable = new MajorTable(year, major, (year + major + schoolId).hashCode() % 10000);
        majorTable.setEnrollmentCount(randomInt(100));
        majorTable.setLastAdmissionLine(500 + randomInt(100) + "");
        majorTable.setMajorEnrollmentCount(randomInt(20));

        StringBuilder subjectsSb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            subjectsSb.append(year).append("年").append(major).append("专业课程").append(i).append("\n");
        }
        subjectsSb.deleteCharAt(subjectsSb.length() - 1);

        StringBuilder resetSubjectsSb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            resetSubjectsSb.append(year).append("年").append(major).append("专业重修课程").append(i).append("\n");
        }
        resetSubjectsSb.deleteCharAt(resetSubjectsSb.length() - 1);

        majorTable.setSubjects(subjectsSb.toString());
        majorTable.setRetestSubjects(resetSubjectsSb.toString());
        return majorTable;
    }

    private static String getRandomAdvantages(List<CollegeTable> collegeTables) {
        String advantage = "";
        for (CollegeTable collegeTable : collegeTables) {
            advantage = collegeTable.getName();
        }
        return advantage;
    }

    private static int randomInt(int num) {
        return random.nextInt(num);
    }

    private static ArrayList<RankTable> generateRankTable(){
        RankTable rankTable1 = new RankTable("生物专业","1.辽宁大学\n2.清华大学\n3.北京大学\n4.负担大学\n5.野鸡大学\n");
        RankTable rankTable2 = new RankTable("化学专业","1.辽宁大学\n2.清华大学\n3.北京大学\n4.野鸡大学\n5.负担大学\n6.华中科技大学");
        RankTable rankTable3 = new RankTable("计算机专业","1.辽宁大学\n2.华中科技大学\n3.北京大学\n4.负担大学\n5.野鸡大学\n6.清华大学");
        RankTable rankTable4 = new RankTable("物理专业","1.辽宁大学\n2.野鸡大学\n3.北京大学\n4.负担大学\n5.清華大学\n6.华中科技大学");
        RankTable rankTable5 = new RankTable("会计专业","1.辽宁大学\n2.清华大学\n3.厦门大学\n4.负担大学\n5.野鸡大学\n6.华中科技大学");

        ArrayList<RankTable> tables = new ArrayList<>();
        tables.add(rankTable1);
        tables.add(rankTable2);
        tables.add(rankTable3);
        tables.add(rankTable4);
        tables.add(rankTable5);
        return tables;
    }
}