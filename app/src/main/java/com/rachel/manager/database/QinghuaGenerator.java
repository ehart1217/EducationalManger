/* *Qinghua
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
public class QinghuaGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("清华大学");
        school1.setArea("北京");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=HohxK7Kf0307uI_pCmx6voZkPFIDpW8zlG5kVNdB5BFvc9b313YvXomyd2-Cr7HxZfMOpOElAKBTm7EX3pmRB_PY1Jxi8nJ9n1sXvR6kF9dAeT3jwICkLwi2CNmyYY2v");
        school1.setEnName("Tsinghua University");
        school1.setType("公立大学");
        school1.setShortName("清华");
        school1.setDesc("清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”，入选”珠峰计划“、”2011计划“、”111计划“、”卓越工程师教育培养计划“、”卓越法律人才教育培养计划“、”卓越医生教育培养计划“，为九校联盟、东亚研究型大学协会、环太平洋大学联盟、亚洲大学联盟[1]  、清华大学—剑桥大学—麻省理工学院低碳能源大学联盟成员。");
        school1.setIcon(R.drawable.tsinghua);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"经济管理学院", "数学科学系", "计算机科学与技术系", "航天航空学院"};

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
                    majorTable_1_1_2017.setRetestSubjects("信息系统\n生产运作");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "理论经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("经济学");
                    majorTable_1_2_2017.setRetestSubjects("计量经济学");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "金融", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("金融学综合");
                    majorTable_1_3_2017.setRetestSubjects("公司金融\n投资学");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("运筹学");
                    majorTable_1_1_2016.setRetestSubjects("信息系统\n生产运作");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "理论经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("经济学");
                    majorTable_1_2_2016.setRetestSubjects("计量经济学");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "金融", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("金融学综合");
                    majorTable_1_3_2016.setRetestSubjects("公司金融\n投资学");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("运筹学");
                    majorTable_1_1_2015.setRetestSubjects("信息系统\n生产运作");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "理论经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("经济学");
                    majorTable_1_2_2015.setRetestSubjects("计量经济学");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "金融", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("金融学综合");
                    majorTable_1_3_2015.setRetestSubjects("公司金融\n投资学");


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
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "运筹学与控制论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("数学分析\n高等代数");
                    majorTable_2_1_2017.setRetestSubjects("计算方法\n最优方法");
                    MajorTable majorTable_2_2_2017 = new MajorTable("2017", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2017.setSubjects("数学分析\n高等代数");
                    majorTable_2_2_2017.setRetestSubjects("抽象代数");
                    MajorTable majorTable_2_3_2017 = new MajorTable("2017", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2017.setSubjects("统计学");
                    majorTable_2_3_2017.setRetestSubjects("概率论与数理统计");
                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "运筹学与控制论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("数学分析\n高等代数");
                    majorTable_2_1_2016.setRetestSubjects("环计算方法\n最优方法");
                    MajorTable majorTable_2_2_2016 = new MajorTable("2016", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2016.setSubjects("数学分析\n高等代数");
                    majorTable_2_2_2016.setRetestSubjects("泛函分析");
                    MajorTable majorTable_2_3_2016 = new MajorTable("2016", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2016.setSubjects("统计学");
                    majorTable_2_3_2016.setRetestSubjects("概率论与数理统计");
                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "运筹学与控制论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("数学分析\n高等代数");
                    majorTable_2_1_2015.setRetestSubjects("环计算方法\n最优方法");
                    MajorTable majorTable_2_2_2015 = new MajorTable("2015", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2015.setSubjects("数学分析\n高等代数");
                    majorTable_2_2_2015.setRetestSubjects("常微积分方程");
                    MajorTable majorTable_2_3_2015 = new MajorTable("2015", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2015.setSubjects("统计学");
                    majorTable_2_3_2015.setRetestSubjects("概率论与数理统计");


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
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "软件工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("计算机专业基础综合");
                    majorTable_3_1_2017.setRetestSubjects("软件工程\n编译原理");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("计算机专业基础综合");
                    majorTable_3_2_2017.setRetestSubjects("软件工程\n编译原理");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "软件工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("计算机专业基础综合");
                    majorTable_3_1_2016.setRetestSubjects("软件工程\n编译原理");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("信计算机专业基础综合");
                    majorTable_3_2_2016.setRetestSubjects("软件工程\n编译原理");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "软件工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("计算机专业基础综合");
                    majorTable_3_1_2015.setRetestSubjects("软件工程\n编译原理");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "计算机技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("计算机专业基础综合");
                    majorTable_3_2_2015.setRetestSubjects("软件工程\n编译原理");

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
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "动力学与控制", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("理论力学及材料力学");
                    majorTable_4_1_2017.setRetestSubjects("机械振动");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "流体力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("理论力学\n材料力学");
                    majorTable_4_2_2017.setRetestSubjects("空气动力");

                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "动力学与控制", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("理论力学及材料力学");
                    majorTable_4_1_2016.setRetestSubjects("机械振动");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "流体力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("理论力学\n材料力学");
                    majorTable_4_2_2016.setRetestSubjects("空气动力");

                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "动力学与控制", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("理论力学及材料力学");
                    majorTable_4_1_2015.setRetestSubjects("机械振动");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "流体力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("理论力学\n材料力学");
                    majorTable_4_2_2015.setRetestSubjects("空气动力");

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

