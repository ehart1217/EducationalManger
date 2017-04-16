/* *Peking
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
public class PekingGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("北京大学");
        school1.setArea("北京");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=f7QETAqRaSZWyEcSLllyHcx8RwwCNmXITHSXOOUNuvgYLUk8QJpfxZw-4USl73mAC3DTiFpTaSXqjF28dtrCg2Jk5sRdNno2pGqFvcTnIKPS7ZfEGicwJaFPBHlVzySq");
        school1.setEnName("Peking University");
        school1.setType("公立大学");
        school1.setShortName("北大");
        school1.setDesc("北京大学（Peking University）简称“北大”，诞生于1898年，初名京师大学堂，是中国近代第一所国立大学，也是第一个以“大学”之名创办的学校，其成立标志着中国近代高等教育的开端。北大是中国近代以来唯一以国家最高学府身份创立的学校，最初也是国家最高教育行政机关，行使教育部职能，统管全国教育。北大催生了中国最早的现代学制，开创了中国最早的文科、理科、社科、农科、医科等大学学科，是近代以来中国高等教育的奠基者。");
        school1.setIcon(R.drawable.peking);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"工学院", "政府管理学院", "信息科学技术学院", "哲学系", "数学科学学院"};

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
                    MajorTable majorTable_1_1_2017 = new MajorTable("2017", "工程管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2017.setSubjects("管理类联考综合能力");
                    majorTable_1_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "先进材料与力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("材料学基础");
                    majorTable_1_2_2017.setRetestSubjects("材料学综合");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "控制理论与控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("自动控制理论");
                    majorTable_1_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "工程管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("管理类联考综合能力");
                    majorTable_1_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "先进材料与力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("材料学基础");
                    majorTable_1_2_2016.setRetestSubjects("材料学综合");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "控制理论与控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("自动控制理论");
                    majorTable_1_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "工程管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("管理类联考综合能力");
                    majorTable_1_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "先进材料与力学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("材料学基础");
                    majorTable_1_2_2015.setRetestSubjects("材料学综合");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "控制理论与控制工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("自动控制理论");
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
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2017 = new MajorTable("2017", "发展管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2017.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_2_3_2017 = new MajorTable("2017", "公共管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2017.setSubjects("管理类联考综合能力");
                    majorTable_2_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2016 = new MajorTable("2016", "发展管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2016.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_2_3_2016 = new MajorTable("2016", "安全科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2016.setSubjects("管理类联考综合能力");
                    majorTable_2_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "行政管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_2_2_2015 = new MajorTable("2015", "发展管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2015.setSubjects("行政学原理\n综合（二）");
                    majorTable_2_2_2015.setRetestSubjects(" ");
                    MajorTable majorTable_2_3_2015 = new MajorTable("2015", "安全科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2015.setSubjects("管理类联考综合能力");
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
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "计算机系统结构", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("计算机专业基础");
                    majorTable_3_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("电子线路");
                    majorTable_3_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_3_3_2017 = new MajorTable("2017", "计算机软件与理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_3_2017.setSubjects("计算机专业基础");
                    majorTable_3_3_2017.setRetestSubjects(" ");
                    MajorTable majorTable_3_4_2017 = new MajorTable("2017", "生物电子学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_4_2017.setSubjects("普通物理");
                    majorTable_3_4_2017.setRetestSubjects("电磁学");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "计算机系统结构", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("计算机专业基础");
                    majorTable_3_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("电子线路");
                    majorTable_3_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_3_3_2016 = new MajorTable("2016", "计算机软件与理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_3_2016.setSubjects("计算机专业基础");
                    majorTable_3_3_2016.setRetestSubjects(" ");
                    MajorTable majorTable_3_4_2016 = new MajorTable("2016", "生物电子学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_4_2016.setSubjects("普通物理");
                    majorTable_3_4_2016.setRetestSubjects("电磁学");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "计算机系统结构", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("计算机专业基础");
                    majorTable_3_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "通信与信息系统", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("电子线路");
                    majorTable_3_2_2015.setRetestSubjects(" ");
                    MajorTable majorTable_3_3_2015 = new MajorTable("2015", "计算机软件与理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_3_2015.setSubjects("计算机专业基础");
                    majorTable_3_3_2015.setRetestSubjects(" ");
                    MajorTable majorTable_3_4_2015 = new MajorTable("2015", "生物电子学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_4_2015.setSubjects("普通物理");
                    majorTable_3_4_2015.setRetestSubjects("电磁学");

                    ArrayList<MajorTable> majorTables_3 = new ArrayList<>();
                    majorTables_3.add(majorTable_3_1_2017);
                    majorTables_3.add(majorTable_3_2_2017);
                    majorTables_3.add(majorTable_3_3_2017);
                    majorTables_3.add(majorTable_3_4_2017);

                    majorTables_3.add(majorTable_3_1_2016);
                    majorTables_3.add(majorTable_3_2_2016);
                    majorTables_3.add(majorTable_3_3_2016);
                    majorTables_3.add(majorTable_3_4_2016);

                    majorTables_3.add(majorTable_3_1_2015);
                    majorTables_3.add(majorTable_3_2_2015);
                    majorTables_3.add(majorTable_3_3_2015);
                    majorTables_3.add(majorTable_3_4_2015);

                    collegeTable.setMajors(majorTables_3);

                    break;
                }
                case 3: {
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("马克思主义哲学\n西方哲学史一");
                    majorTable_4_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "中国哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("中国哲学史\n西方哲学史一");
                    majorTable_4_2_2017.setRetestSubjects(" ");

                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("马克思主义哲学\n西方哲学史一");
                    majorTable_4_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "中国哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("中国哲学史\n西方哲学史一");
                    majorTable_4_2_2016.setRetestSubjects(" ");

                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "马克思主义哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("马克思主义哲学\n西方哲学史一");
                    majorTable_4_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "中国哲学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("中国哲学史\n西方哲学史一");
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

                case 4:
                {
                    // 第5个学院的专业
                    MajorTable majorTable_5_1_2017 = new MajorTable("2017", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2017.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2017 = new MajorTable("2017", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2017.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_2_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_3_2017 = new MajorTable("2017", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2017.setSubjects("统计学");
                    majorTable_5_3_2017.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2017 = new MajorTable("2017", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2017.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_4_2017.setRetestSubjects(" ");

                    MajorTable majorTable_5_1_2016 = new MajorTable("2016", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2016.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2016 = new MajorTable("2016", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2016.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_2_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_3_2016 = new MajorTable("2016", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2016.setSubjects("统计学");
                    majorTable_5_3_2016.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2016 = new MajorTable("2016", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2016.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_4_2016.setRetestSubjects(" ");

                    MajorTable majorTable_5_1_2015 = new MajorTable("2015", "基础数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2015.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_5_2_2015 = new MajorTable("2015", "概率论与数理统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_2_2015.setSubjects("数学分析\n高等代数\n解析几何");
                    majorTable_5_2_2015.setRetestSubjects(" ");
                    MajorTable majorTable_5_3_2015 = new MajorTable("2015", "应用统计", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_3_2015.setSubjects("统计学");
                    majorTable_5_3_2015.setRetestSubjects(" ");
                    MajorTable majorTable_5_4_2015 = new MajorTable("2015", "应用数学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_4_2015.setSubjects("数学分析\n高等代数\n解析几何");
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

