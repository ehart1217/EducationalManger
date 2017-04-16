package com.rachel.manager.database;

import com.rachel.manager.R;

import java.util.ArrayList;

/**
 * Created by Rachel on 17/4/17.
 */

/**
 * @author wanchi@coolpad.com
 * @version 1.0, 2017/4/15
 */
public class DalianligongGenerator {

    public static void createSchool() {
        SchoolTable school1 = new SchoolTable("大连理工大学");
        school1.setArea("大连");
        school1.setIs211(false);
        school1.setIs985(true);
        school1.setDetailLink("http://baike.baidu.com/link?url=2KHFgs2Zl2ek__gVn4T8XVuAUESScwUW-mG4GVkr0nI_oQOwaFYivKriYBMon2D38uV1_AWqXUgqEqFSXDEs1DpmOcpEu_7ro40qF7JAHYqVlil1gppj1j4yxr6ZHYCo3uYIBtwvh3U3rldIJZy2cAWMdNaMN7dFAXWm6RJ0oSZZenw3dUAMWEbnDTijwmPkDSx3fBewnRZYfZ5QZNKrVGPpskMAFs9kH6wfnKVD9IO");
        school1.setEnName("Dalian University Of Technology");
        school1.setType("公立大学");
        school1.setShortName("大工");
        school1.setDesc("大连理工大学（Dalian University of Technology），简称大工，坐落于滨城大连，是中央直管、教育部直属的副部级全国重点大学，中国著名的“四大工学院”之一，国家“211工程”、“985工程”、“卓越工程师教育培养计划”、“国家大学生创新性实验计划”和“111计划”重点建设的大学，“卓越大学联盟”、“中俄工科大学联盟”、“中俄交通大学联盟”、“中欧工程教育平台”主要成员。");
        school1.setIcon(R.drawable.dalianligong);
        school1.setColleges(generateCollegeTables(school1.getName()));

        DataGenerator.saveSchoolDeep(school1);
    }

    public static ArrayList<CollegeTable> generateCollegeTables(String schoolName) {
        ArrayList<CollegeTable> collegeTableList = new ArrayList<>();

        // 学院的名称
        String[] nameArray = new String[]{"管理与经济学院", "电子信息与电气工程学院", "能源与动力学院", "盘锦校区商学院学院", "马克思主义学院"};

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
                case 0: {
                    MajorTable majorTable_1_1_2017 = new MajorTable("2017", "金融学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2017.setSubjects("经济学原理");
                    majorTable_1_1_2017.setRetestSubjects("管理学");
                    MajorTable majorTable_1_2_2017 = new MajorTable("2017", "物流工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2017.setSubjects("管理学");
                    majorTable_1_2_2017.setRetestSubjects("现代物流管理");
                    MajorTable majorTable_1_3_2017 = new MajorTable("2017", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2017.setSubjects("信息管理与信息系统");
                    majorTable_1_3_2017.setRetestSubjects(" ");
                    // 2016年
                    MajorTable majorTable_1_1_2016 = new MajorTable("2016", "金融学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2016.setSubjects("经济学原理");
                    majorTable_1_1_2016.setRetestSubjects("管理学");
                    MajorTable majorTable_1_2_2016 = new MajorTable("2016", "物流工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2016.setSubjects("管理学");
                    majorTable_1_2_2016.setRetestSubjects("现代物流管理");
                    MajorTable majorTable_1_3_2016 = new MajorTable("2016", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2016.setSubjects("信息管理与信息系统");
                    majorTable_1_3_2016.setRetestSubjects(" ");
                    // 2015年
                    MajorTable majorTable_1_1_2015 = new MajorTable("2015", "金融学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_1_2015.setSubjects("经济学原理");
                    majorTable_1_1_2015.setRetestSubjects("管理学");
                    MajorTable majorTable_1_2_2015 = new MajorTable("2015", "物流工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_2_2015.setSubjects("管理学");
                    majorTable_1_2_2015.setRetestSubjects("现代物流管理");
                    MajorTable majorTable_1_3_2015 = new MajorTable("2015", "管理科学与工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_1_3_2015.setSubjects("信息管理与信息系统");
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
                    MajorTable majorTable_2_1_2017 = new MajorTable("2017", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2017.setSubjects("电路理论");
                    majorTable_2_1_2017.setRetestSubjects("自动控制原理");
                    MajorTable majorTable_2_2_2017 = new MajorTable("2017", "计算机科学与技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2017.setSubjects("数据结构");
                    majorTable_2_2_2017.setRetestSubjects("计算机组成原理");
                    MajorTable majorTable_2_3_2017 = new MajorTable("2017", "信息与通信工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2017.setSubjects("信号系统与通信原理");
                    majorTable_2_3_2017.setRetestSubjects("通信原理");
                    // 2016年
                    MajorTable majorTable_2_1_2016 = new MajorTable("2016", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2016.setSubjects("电路理论");
                    majorTable_2_1_2016.setRetestSubjects("自动控制原理");
                    MajorTable majorTable_2_2_2016 = new MajorTable("2016", "计算机科学与技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2016.setSubjects("数据结构");
                    majorTable_2_2_2016.setRetestSubjects("计算机组成原理");
                    MajorTable majorTable_2_3_2016 = new MajorTable("2016", "信息与通信工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2016.setSubjects("信号系统与通信原理");
                    majorTable_2_3_2016.setRetestSubjects("通信原理");
                    // 2015年
                    MajorTable majorTable_2_1_2015 = new MajorTable("2015", "电气工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_1_2015.setSubjects("电路理论");
                    majorTable_2_1_2015.setRetestSubjects("自动控制原理");
                    MajorTable majorTable_2_2_2015 = new MajorTable("2015", "计算机科学与技术", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_2_2015.setSubjects("数据结构");
                    majorTable_2_2_2015.setRetestSubjects("计算机组成原理");
                    MajorTable majorTable_2_3_2015 = new MajorTable("2015", "信息与通信工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_2_3_2015.setSubjects("信号系统与通信原理");
                    majorTable_2_3_2015.setRetestSubjects("通信原理");


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
                case 2: {
                    // 第3个学院的专业
                    MajorTable majorTable_3_1_2017 = new MajorTable("2017", "工程热物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2017.setSubjects("传热学");
                    majorTable_3_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2017 = new MajorTable("2017", "动力工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2017.setSubjects("传热学");
                    majorTable_3_2_2017.setRetestSubjects("热能工程");

                    MajorTable majorTable_3_1_2016 = new MajorTable("2016", "工程热物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2016.setSubjects("传热学");
                    majorTable_3_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2016 = new MajorTable("2016", "动力工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2016.setSubjects("传热学");
                    majorTable_3_2_2016.setRetestSubjects("热能工程");

                    MajorTable majorTable_3_1_2015 = new MajorTable("2015", "工程热物理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_1_2015.setSubjects("传热学");
                    majorTable_3_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_3_2_2015 = new MajorTable("2015", "动力工程", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_3_2_2015.setSubjects("传热学");
                    majorTable_3_2_2015.setRetestSubjects("热能工程");

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
                    MajorTable majorTable_4_1_2017 = new MajorTable("2017", "产业经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2017.setSubjects("经济学原理");
                    majorTable_4_1_2017.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2017 = new MajorTable("2017", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2017.setSubjects("管理学");
                    majorTable_4_2_2017.setRetestSubjects(" ");

                    MajorTable majorTable_4_1_2016 = new MajorTable("2016", "产业经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2016.setSubjects("经济学原理");
                    majorTable_4_1_2016.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2016 = new MajorTable("2016", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2016.setSubjects("管理学");
                    majorTable_4_2_2016.setRetestSubjects(" ");

                    MajorTable majorTable_4_1_2015 = new MajorTable("2015", "产业经济学", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_1_2015.setSubjects("经济学原理");
                    majorTable_4_1_2015.setRetestSubjects(" ");
                    MajorTable majorTable_4_2_2015 = new MajorTable("2015", "企业管理", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_4_2_2015.setSubjects("管理学");
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

                case 4: {
                    // 第5个学院的专业
                    MajorTable majorTable_5_1_2017 = new MajorTable("2017", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2017.setSubjects("马克思主义基本原理\n中国化的马克思主义");
                    majorTable_5_1_2017.setRetestSubjects(" ");

                    MajorTable majorTable_5_1_2016 = new MajorTable("2016", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2016.setSubjects("马克思主义基本原理\n中国化的马克思主义");
                    majorTable_5_1_2016.setRetestSubjects(" ");


                    MajorTable majorTable_5_1_2015 = new MajorTable("2015", "马克思主义理论", collegeTable.getCollegeId(), collegeTable.getSchoolName());
                    majorTable_5_1_2015.setSubjects("马克思主义基本原理\n中国化的马克思主义");
                    majorTable_5_1_2015.setRetestSubjects(" ");

                    ArrayList<MajorTable> majorTables_5 = new ArrayList<>();
                    majorTables_5.add(majorTable_5_1_2017);
                    majorTables_5.add(majorTable_5_1_2016);
                    majorTables_5.add(majorTable_5_1_2015);
                    collegeTable.setMajors(majorTables_5);

                    break;
                }
            }
        }
    }

}

