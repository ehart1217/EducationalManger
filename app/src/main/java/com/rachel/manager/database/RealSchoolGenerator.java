/* *
   * Copyright (C) 2017 BaoliYota Tech. Co., Ltd, LLC - All Rights Reserved.
   *
   * Confidential and Proprietary.
   * Unauthorized copying of this file, via any medium is strictly prohibited.
   * */

package com.rachel.manager.database;

import com.rachel.manager.R;

import java.util.ArrayList;

/**
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/15
 */
public class RealSchoolGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("重庆大学");
        school1.setArea("沈阳");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=8SEJfsFFai0d06NAGMNl9PhBle-bIiDhTgvTlZnlxRcAb6rgLVyyju2hxTkytb4IOrN5vjfiv99vA5GPbOQeOFBJlBIwQC4EePZRthvoB7b6mj3_YrjY8cn6zSDbLS8i");
        school1.setEnName("Liaoning University");
        school1.setType("公立大学");
        school1.setShortName("辽大");
        school1.setDesc("辽宁大学（Liaoning University）是辽宁省人民政府主管的一所具备文、史、哲、经、法、理、工、管、艺等九大学科门类的综合性重点大学，是国家“211工程”重点建设院校，是卓越法律人才教育培养计划入选院校，是设有国家经济学基础人才培养基地的十三所高校之一。");
        school1.setIcon(R.drawable.liaoningdaxue);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"计算机", "自动化", "信息工程", "工商管理", "土木工程", "新闻学"};

        for (int i = 0; i < nameArray.length; i++) {
            String name = nameArray[i];
            CollegeTable collegeTable = new CollegeTable(name, schoolName);
            collegeTableList.add(collegeTable);
        }
        generateMajors(collegeTableList);
        return collegeTableList;
    }

    private static void generateMajors(ArrayList<CollegeTable> collegeTableList) {

        for (int i = 0; i < collegeTableList.size(); i++) {
            CollegeTable collegeTable = collegeTableList.get(i);
            switch (i) {
                case 0:
                    // 第1个学院的专业
                    // 专业1
                    // 2017年
                    MajorTable majorTable_1_2017 = new MajorTable("2017", "专业1——2017", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2017.setSubjects("专业课程1\n专业课程2");
                    majorTable_1_2017.setSubjects("复试课程1\n复试课程2");
                    // 2016年
                    MajorTable majorTable_1_2016 = new MajorTable("2017", "专业1——2016", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    // 2015年
                    MajorTable majorTable_1_2015 = new MajorTable("2017", "专业1——2015", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    // 2014年
                    MajorTable majorTable_1_2014 = new MajorTable("2017", "专业1——2014", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    // 2013年
                    MajorTable majorTable_1_2013 = new MajorTable("2017", "专业1——2013", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    // 2012年
                    MajorTable majorTable_1_2012 = new MajorTable("2017", "专业1——2012", collegeTable.getCollegeId(), collegeTable.getSchoolName());

                    ArrayList<MajorTable> majorTables = new ArrayList<>();
                    majorTables.add(majorTable_1_2017);
                    majorTables.add(majorTable_1_2016);
                    majorTables.add(majorTable_1_2015);
                    majorTables.add(majorTable_1_2014);
                    majorTables.add(majorTable_1_2013);
                    majorTables.add(majorTable_1_2012);
                    collegeTable.setMajors(majorTables);
                    break;
                case 1:
                    // 第2个学院的专业
                    //跟第一个学院的专业类似

                    break;
                case 2:
                    // 第3个学院的专业
                    break;
                case 3:
                    // 第4个学院的专业
                    break;
                case 4:
                    // 第5个学院的专业
                    break;
                case 5:
                    // 第6个学院的专业
                    break;
                case 6:
                    // 第7个学院的专业
                    break;
                case 7:
                    // 第8个学院的专业
                    break;
                // 以此类推
            }
        }
    }


}

