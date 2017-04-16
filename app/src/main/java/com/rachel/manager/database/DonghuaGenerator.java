/* *donghua
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
public class DonghuaGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("东华大学");
        school1.setArea("上海");
        school1.setIs211(true);
        school1.setIs985(false);
        school1.setDetailLink("http://baike.baidu.com/link?url=GxTLdsuFQIv4RD5hgSf0K_K3pID52y30oM8XDJUSqK-Y3Ss9E6FlgqQWH3mHarRLome2yMZiTIGD-8nNrkTloRyFW08DXLAMAOjTUBTiC3X_oQzIEdlJ7emISxrMmmwx");
        school1.setEnName("Donghua University");
        school1.setType("公立大学");
        school1.setShortName("东华");
        school1.setDesc("东华大学地处中国上海，是教育部直属、国家“211工程”重点建设的全国重点大学，入选“111计划”、“2011计划”[1]  、“卓越工程师教育培养计划”、“海外高层次人才引进计划”、“国家大学生创新性实验计划”、“中非高校20+20合作计划”、“国家级大学生创新创业训练计划”、“国家建设高水平大学公派研究生项目”，是高水平行业特色大学优质资源共享联盟成员高校，是中国首批具有博士、硕士、学士三级学位授予权的大学之一，设有“研究生院”。");
        school1.setIcon(R.drawable.donghua);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"旭日工商管理学院", "马克思主义学院", "信息科学与技术学院", "理学院"};

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
                    majorTable_1_1_2017.setSubjects("1.思想政治理论\n2.英语一\n3.数学三\n运筹学");
                    majorTable_1_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "项目管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("1.思想政治理论\n2.英语二\n3.数学三\n管理学原理");
                    majorTable_1_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("1.思想政治理论\n2.英语一\n3.数学三\n管理学原理");
                    majorTable_1_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("1.思想政治理论\n2.英语一\n3.数学三\n运筹学");
                    majorTable_1_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "项目管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("1.思想政治理论\n2.英语二\n3.数学三\n管理学原理");
                    majorTable_1_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("1.思想政治理论\n2.英语一\n3.数学三\n管理学原理");
                    majorTable_1_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("1.思想政治理论\n2.英语一\n3.数学三\n运筹学");
                    majorTable_1_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "项目管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("1.思想政治理论\n2.英语二\n3.数学三\n管理学原理");
                    majorTable_1_2_2015.setRetestSubjects(" ");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("1.思想政治理论\n2.英语二\n3.数学二\n管理学原理");
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
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("1.思想政治理论\n2.英语一\3.中国化的马克思理论\n4.马克思主义基本原理");
                    majorTable_2_1_2017.setRetestSubjects(" ");

                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("1.思想政治理论\n2.英语二\3.中国化的马克思理论\n4.马克思主义基本原理");
                    majorTable_2_1_2016.setRetestSubjects("  ");

                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("1.思想政治理论\n2.英语一\3.中国化的马克思理论\n4.马克思主义基本原理");
                    majorTable_2_1_2015.setRetestSubjects(" ");



                    ArrayList<MajorTable> majorTables_2 = new ArrayList<>();
                    majorTables_2.add(majorTable_2_1_2017);
                    majorTables_2.add(majorTable_2_1_2016);
                    majorTables_2.add(majorTable_2_1_2015);
                    collegeTable.setMajors(majorTables_2);
                    break;
                }
                case 2:
                {
                    // 第3个学院的专业
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("自动控制理论");
                    majorTable_3_1_2017.setRetestSubjects("电路原理");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("信号与系统");
                    majorTable_3_2_2017.setRetestSubjects("自动控制理论");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("自动控制理论");
                    majorTable_3_1_2016.setRetestSubjects("电路原理");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("信号与系统");
                    majorTable_3_2_2016.setRetestSubjects("自动控制理论");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("自动控制理论");
                    majorTable_3_1_2015.setRetestSubjects("电路原理");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("信号与系统");
                    majorTable_3_2_2015.setRetestSubjects("自动控制理论");

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
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("1.思想政治理论\n2.英语一\n3.数学分析\n4.高等代数");
                    majorTable_4_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("法理学\n诉讼法学");


                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("1.思想政治理论\n2.英语一\n3.数学分析\n4.高等代数");
                    majorTable_4_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("1.思想政治理论\n2.英语一\n3.数学分析\n4.高等代数");
                    majorTable_4_2_2016.setRetestSubjects(" ");

                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("1.思想政治理论\n2.英语一\n3.数学分析\n4.高等代数");
                    majorTable_4_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("1.思想政治理论\n2.英语一\n3.数学分析\n4.高等代数");
                    majorTable_4_2_2015.setRetestSubjects(" ");

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

            }
        }
    }

}

