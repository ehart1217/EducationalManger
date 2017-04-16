/* *wuhan
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
public class WuhanGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("武汉大学");
        school1.setArea("武汉");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=c6i1h9AxOSX5dJeLHrpy_bhDe6QBaqNrTVULZS3fL3PEJqxIEx6SvmSHC4ExT4I7gRPxCNOzAk0Z5vyh1p1xDPXV3slbyhTjcHBx6SNP0uKIcqtUctMM2gfV38t4x2US");
        school1.setEnName("Wuhan University");
        school1.setType("公立大学");
        school1.setShortName("武大");
        school1.setDesc("武汉大学（Wuhan University），简称“武大”，是一所位于湖北武汉市的综合研究型大学，其办学源头溯源于清朝末期1893年湖广总督张之洞奏请清政府创办的自强学堂，已有一百多年历史，1913年改名国立武昌高等师范学校， 1926年组建国立武昌中山大学，1928年定名国立武汉大学，是民国四大名校之一。1949年新中国成立更名武汉大学沿用至今。");
        school1.setIcon(R.drawable.wuhan);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"经济与管理学院", "信息管理学院", "哲学学院", "法学院", "数学与统计学院"};

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
                    majorTable_1_1_2017.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("宏观经济学");
                    majorTable_1_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("工商管理基本理论");
                    majorTable_1_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("运筹学");
                    majorTable_1_1_2016.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("宏观经济学");
                    majorTable_1_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("工商管理基本理论");
                    majorTable_1_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("运筹学");
                    majorTable_1_1_2015.setRetestSubjects("技术经济学");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("宏观经济学");
                    majorTable_1_2_2015.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("工商管理基本理论");
                    majorTable_1_3_2015.setRetestSubjects(" ");


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
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "电子商务", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("电子商务概论\n数据库原理与应用");
                    majorTable_2_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2017 = new MajorTable("2017", "信息资源管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2017.setSubjects("信息系统原理\n信息系统分析与设计");
                    majorTable_2_2_2017.setRetestSubjects("数据库原理");
                    MajorTable majorTable_2_3_2017 = new MajorTable("2017", "情报学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2017.setSubjects("信息管理学\n数据库原理");
                    majorTable_2_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "电子商务", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("电子商务概论\n数据库原理与应用");
                    majorTable_2_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2016 = new MajorTable("2016", "信息资源管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2016.setSubjects("信息系统原理\n信息系统分析与设计");
                    majorTable_2_2_2016.setRetestSubjects("数据库原理");
                    MajorTable majorTable_2_3_2016 = new MajorTable("2016", "情报学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2016.setSubjects("信息管理学\n数据库原理");
                    majorTable_2_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "电子商务", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("电子商务概论\n数据库原理与应用");
                    majorTable_2_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2015 = new MajorTable("2015", "信息资源管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2015.setSubjects("信息系统原理\n信息系统分析与设计");
                    majorTable_2_2_2015.setRetestSubjects("数据库原理");
                    MajorTable majorTable_2_3_2015 = new MajorTable("2015", "情报学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2015.setSubjects("信息管理学\n数据库原理");
                    majorTable_2_3_2015.setRetestSubjects(" ");


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
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("马克思主义哲学原理\n哲学基础");
                    majorTable_3_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "逻辑学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("符号逻辑\n西方哲学问题");
                    majorTable_3_2_2017.setRetestSubjects(" ");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("马克思主义哲学原理\n哲学基础");
                    majorTable_3_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "逻辑学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("符号逻辑\n西方哲学问题");
                    majorTable_3_2_2016.setRetestSubjects(" ");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("马克思主义哲学原理\n哲学基础");
                    majorTable_3_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "逻辑学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("符号逻辑\n西方哲学问题");
                    majorTable_3_2_2015.setRetestSubjects(" ");

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
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "刑法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_1_2017.setRetestSubjects("刑事法学");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "经济法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_2_2017.setRetestSubjects("经济法学");

                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "刑法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_1_2016.setRetestSubjects("刑事法学");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "经济法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_2_2016.setRetestSubjects("经济法学");

                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "刑法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_1_2015.setRetestSubjects("刑事法学");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "经济法学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("综合知识（法理、宪法、行政法、民法）");
                    majorTable_4_2_2015.setRetestSubjects("经济法学");

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
                    MajorTable majorTable_5_1_2017 = new MajorTable("2017", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2017.setSubjects("数学分析\n线性代数");
                    majorTable_5_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2017 = new MajorTable("2017", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2017.setSubjects("数学分析\n线性代数");
                    majorTable_5_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_3_2017 = new MajorTable("2017", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2017.setSubjects("数学分析\n线性代数");
                    majorTable_5_3_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2017 = new MajorTable("2017", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2017.setSubjects("数学分析\n线性代数");
                    majorTable_5_4_2017.setRetestSubjects(" ");

                    MajorTable majorTable_5_1_2016 = new MajorTable("2016", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2016.setSubjects("数学分析\n线性代数");
                    majorTable_5_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2016 = new MajorTable("2016", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2016.setSubjects("数学分析\n线性代数");
                    majorTable_5_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_3_2016 = new MajorTable("2016", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2016.setSubjects("数学分析\n线性代数");
                    majorTable_5_3_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2016 = new MajorTable("2016", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2016.setSubjects("数学分析\n线性代数");
                    majorTable_5_4_2016.setRetestSubjects(" ");

                    MajorTable majorTable_5_1_2015 = new MajorTable("2015", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2015.setSubjects("数学分析\n线性代数");
                    majorTable_5_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2015 = new MajorTable("2015", "统计学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2015.setSubjects("数学分析\n线性代数");
                    majorTable_5_2_2015.setRetestSubjects("固体物理");
                    MajorTable majorTable_5_3_2015 = new MajorTable("2015", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2015.setSubjects("数学分析\n线性代数");
                    majorTable_5_3_2015.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2015 = new MajorTable("2015", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2015.setSubjects("数学分析\n线性代数");
                    majorTable_5_4_2015.setRetestSubjects(" ");

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

