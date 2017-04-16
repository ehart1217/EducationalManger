
/* *realschool
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
        SchoolTable school1 = new SchoolTable("东北大学");
        school1.setArea("沈阳");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=TTTOXF99IyDn4gXGqAMjHI9Rri6yUUa2sa8IicSdSs2IvlCQYtAn4H_fMM9zeMQUUjgLb_J0x2BzVIf85GPL83jmVMs5gA7QF4XX26d1GiSUYaGOYmp9ktrytHgEvWtR");
        school1.setEnName("Northeastern University");
        school1.setType("公立大学");
        school1.setShortName("东大");
        school1.setDesc("东北大学（Northeastern University）中华人民共和国教育部直属的理工类研究型大学，坐落于东北中心城市沈阳，是国家首批“211工程”和“985工程”重点建设高校，由教育部、辽宁省、沈阳市三方重点共建，先后入选“2011计划”、“111计划”、“卓越工程师教育培养计划”、“国家大学生创新性实验计划”等");
        school1.setIcon(R.drawable.dongbei);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"工商管理学院", "资源与土木工程学院", "信息科学与工程学院", "文法学院", "理学院"};

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
                {
                    MajorTable majorTable_1_1_2017 = new MajorTable("2017", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2017.setSubjects("运筹学");
                    majorTable_1_1_2017.setRetestSubjects("生产运作管理");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "计算经济及管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("管理学");
                    majorTable_1_2_2017.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("管理学");
                    majorTable_1_3_2017.setRetestSubjects("市场营销");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("运筹学");
                    majorTable_1_1_2016.setRetestSubjects("生产运作管理");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "计算经济及管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("管理学");
                    majorTable_1_2_2016.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("管理学");
                    majorTable_1_3_2016.setRetestSubjects("市场营销");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("运筹学");
                    majorTable_1_1_2015.setRetestSubjects("生产运作管理");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "计算经济及管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("管理学");
                    majorTable_1_2_2015.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("管理学");
                    majorTable_1_3_2015.setRetestSubjects("市场营销");


                    ArrayList<MajorTable> majorTables_1 = new ArrayList<>();
                    majorTables_1.add(majorTable_1_1_2017);
                    majorTables_1.add(majorTable_1_2_2017);
                    majorTables_1.add(majorTable_1_3_2017);

                    majorTables_1.add(majorTable_1_1_2016);
                    majorTables_1.add(majorTable_1_2_2016);
                    majorTables_1.add(majorTable_1_3_2016);

                    majorTables_1.add(majorTable_1_1_2015);
                    majorTables_1.add(majorTable_1_2_2015);
                    majorTables_1.add(majorTable_1_3_2015);

                    collegeTable.setMajors(majorTables_1);
                    break;
                }
                case 1: {
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "环境工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("环境工程原理");
                    majorTable_2_1_2017.setRetestSubjects("环境污染治理工程");
                    MajorTable majorTable_2_2_2017 = new MajorTable("2017", "结构工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2017.setSubjects("结构力学");
                    majorTable_2_2_2017.setRetestSubjects("钢筋混泥土结构");
                    MajorTable majorTable_2_3_2017 = new MajorTable("2017", "安全科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2017.setSubjects("系统安全工程");
                    majorTable_2_3_2017.setRetestSubjects("安全原理");
                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "环境工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("环境工程原理");
                    majorTable_2_1_2016.setRetestSubjects("环境污染治理工程");
                    MajorTable majorTable_2_2_2016 = new MajorTable("2016", "结构工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2016.setSubjects("结构力学");
                    majorTable_2_2_2016.setRetestSubjects("钢筋混泥土结构");
                    MajorTable majorTable_2_3_2016 = new MajorTable("2016", "安全科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2016.setSubjects("系统安全工程");
                    majorTable_2_3_2016.setRetestSubjects("安全原理");
                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "环境工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("环境工程原理");
                    majorTable_2_1_2015.setRetestSubjects("环境污染治理工程");
                    MajorTable majorTable_2_2_2015 = new MajorTable("2015", "结构工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2015.setSubjects("结构力学");
                    majorTable_2_2_2015.setRetestSubjects("钢筋混泥土结构");
                    MajorTable majorTable_2_3_2015 = new MajorTable("2015", "安全科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2015.setSubjects("系统安全工程");
                    majorTable_2_3_2015.setRetestSubjects("安全原理");


                    ArrayList<MajorTable> majorTables_2 = new ArrayList<>();
                    majorTables_2.add(majorTable_2_1_2017);
                    majorTables_2.add(majorTable_2_2_2017);
                    majorTables_2.add(majorTable_2_3_2017);

                    majorTables_2.add(majorTable_2_1_2016);
                    majorTables_2.add(majorTable_2_2_2016);
                    majorTables_2.add(majorTable_2_3_2016);

                    majorTables_2.add(majorTable_2_1_2015);
                    majorTables_2.add(majorTable_2_2_2015);
                    majorTables_2.add(majorTable_2_3_2015);

                    collegeTable.setMajors(majorTables_2);
                    break;
                }
                case 2:
                {
                    // 第3个学院的专业
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("计算机专业基础");
                    majorTable_3_1_2017.setRetestSubjects("数据库\n软件工程\nJAVA\n计算机网络");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("信号与系统");
                    majorTable_3_2_2017.setRetestSubjects("通信原理\n计算机网络\n高频电子线路");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("计算机专业基础");
                    majorTable_3_1_2016.setRetestSubjects("数据库\n软件工程\nJAVA\n计算机网络");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("信号与系统");
                    majorTable_3_2_2016.setRetestSubjects("计算机网络\n高频电子线路");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("计算机专业基础");
                    majorTable_3_1_2015.setRetestSubjects("数据库\n软件工程\nJAVA\n计算机网络");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("信号与系统");
                    majorTable_3_2_2015.setRetestSubjects("通信原理\n高频电子线路");

                    ArrayList<MajorTable> majorTables_3 = new ArrayList<>();
                    majorTables_3.add(majorTable_3_1_2017);
                    majorTables_3.add(majorTable_3_2_2017);

                    majorTables_3.add(majorTable_3_1_2016);
                    majorTables_3.add(majorTable_3_2_2016);

                    majorTables_3.add(majorTable_3_1_2015);
                    majorTables_3.add(majorTable_3_2_2015);

                    collegeTable.setMajors(majorTables_3);

                    break;
                }
                case 3: {
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("管理学基础\n政治学");
                    majorTable_4_1_2017.setRetestSubjects("行政管理学");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "国际法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("法理学\n诉讼法学");
                    majorTable_4_2_2017.setRetestSubjects("国际私法与国际经济学");
                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("管理学基础\n政治学");
                    majorTable_4_1_2016.setRetestSubjects("行政管理学");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "国际法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("法理学\n诉讼法学");
                    majorTable_4_2_2016.setRetestSubjects("国际私法与国际经济学");
                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("管理学基础\n政治学");
                    majorTable_4_1_2015.setRetestSubjects("行政管理学");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "国际法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("法理学\n诉讼法学");
                    majorTable_4_2_2015.setRetestSubjects("国际私法与国际经济学");

                    ArrayList<MajorTable> majorTables_4 = new ArrayList<>();
                    majorTables_4.add(majorTable_4_1_2017);
                    majorTables_4.add(majorTable_4_2_2017);
                    majorTables_4.add(majorTable_4_1_2016);
                    majorTables_4.add(majorTable_4_2_2016);
                    majorTables_4.add(majorTable_4_1_2015);
                    majorTables_4.add(majorTable_4_2_2015);
                    collegeTable.setMajors(majorTables_4);

                    break;
                }

                case 4:
                {
                    // 第5个学院的专业
                    MajorTable majorTable_5_1_2017 = new MajorTable("2017", "化学工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2017.setSubjects("无机化学");
                    majorTable_5_1_2017.setRetestSubjects("有机化学");
                    MajorTable majorTable_5_2_2017 = new MajorTable("2017", "理论物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2017.setSubjects("普通物理\n量子力学");
                    majorTable_5_2_2017.setRetestSubjects("固体物理");
                    MajorTable majorTable_5_3_2017 = new MajorTable("2017", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2017.setSubjects("分析基础\n代数基础");
                    majorTable_5_3_2017.setRetestSubjects("属性综合");
                    MajorTable majorTable_5_4_2017 = new MajorTable("2017", "光学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2017.setSubjects("量子力学\n普通物理");
                    majorTable_5_4_2017.setRetestSubjects("电动力学");

                    MajorTable majorTable_5_1_2016 = new MajorTable("2016", "化学工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2016.setSubjects("无机化学");
                    majorTable_5_1_2016.setRetestSubjects("有机化学");
                    MajorTable majorTable_5_2_2016 = new MajorTable("2016", "理论物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2016.setSubjects("普通物理\n量子力学");
                    majorTable_5_2_2016.setRetestSubjects("固体物理");
                    MajorTable majorTable_5_3_2016 = new MajorTable("2016", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2016.setSubjects("分析基础\n代数基础");
                    majorTable_5_3_2016.setRetestSubjects("属性综合");
                    MajorTable majorTable_5_4_2016 = new MajorTable("2016", "光学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2016.setSubjects("量子力学\n普通物理");
                    majorTable_5_4_2016.setRetestSubjects("电动力学");

                    MajorTable majorTable_5_1_2015 = new MajorTable("2015", "化学工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2015.setSubjects("无机化学");
                    majorTable_5_1_2015.setRetestSubjects("有机化学");
                    MajorTable majorTable_5_2_2015 = new MajorTable("2015", "理论物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2015.setSubjects("普通物理\n量子力学");
                    majorTable_5_2_2015.setRetestSubjects("固体物理");
                    MajorTable majorTable_5_3_2015 = new MajorTable("2015", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2015.setSubjects("分析基础\n代数基础");
                    majorTable_5_3_2015.setRetestSubjects("属性综合");
                    MajorTable majorTable_5_4_2015 = new MajorTable("2015", "光学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2015.setSubjects("量子力学\n普通物理");
                    majorTable_5_4_2015.setRetestSubjects("电动力学");

                    ArrayList<MajorTable> majorTables_5 = new ArrayList<>();
                    majorTables_5.add(majorTable_5_1_2017);
                    majorTables_5.add(majorTable_5_2_2017);
                    majorTables_5.add(majorTable_5_3_2017);
                    majorTables_5.add(majorTable_5_4_2017);

                    majorTables_5.add(majorTable_5_1_2016);
                    majorTables_5.add(majorTable_5_2_2016);
                    majorTables_5.add(majorTable_5_3_2016);
                    majorTables_5.add(majorTable_5_4_2016);

                    majorTables_5.add(majorTable_5_1_2015);
                    majorTables_5.add(majorTable_5_2_2015);
                    majorTables_5.add(majorTable_5_3_2015);
                    majorTables_5.add(majorTable_5_4_2015);

                    collegeTable.setMajors(majorTables_5);

                    break;
                }
            }
        }
    }

}

