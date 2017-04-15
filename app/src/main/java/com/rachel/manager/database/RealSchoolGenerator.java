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
        return collegeTableList;
    }


}

