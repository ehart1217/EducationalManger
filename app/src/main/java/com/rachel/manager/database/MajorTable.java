package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

import java.util.ArrayList;
import java.util.List;

/**
 * 专业
 * Created by Rachel on 17/4/3.
 */
@Table("major_table")
public class MajorTable extends BaseTable {
    @Unique
    @NotNull
    private long majorId;
    @Unique
    @NotNull
    private String year;//招生年份
    @NotNull
    private String name;//专业
    private int enrollmentCount;//院招生人数
    private int majorEnrollmentCount;//专业招生人数
    private ArrayList<String> subjects;//考试科目
    private ArrayList<String> retestSubjects;//复试科目
    private String lastAdmissionLine;//去年录取线

    public MajorTable(long majorId, String year,String name) {
        this.majorId = majorId;
        this.year = year;
        this.name = name;
    }

    public long getMajorId() {
        return majorId;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public int getMajorEnrollmentCount() {
        return majorEnrollmentCount;
    }

    public void setMajorEnrollmentCount(int majorEnrollmentCount) {
        this.majorEnrollmentCount = majorEnrollmentCount;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getRetestSubjects() {
        return retestSubjects;
    }

    public void setRetestSubjects(ArrayList<String> retestSubjects) {
        this.retestSubjects = retestSubjects;
    }

    public String getLastAdmissionLine() {
        return lastAdmissionLine;
    }

    public void setLastAdmissionLine(String lastAdmissionLine) {
        this.lastAdmissionLine = lastAdmissionLine;
    }

    @Override
    public String toString() {
        return "MajorTable{" +
                "majorId=" + majorId +
                ", year='" + year + '\'' +
                ", name=" + name +
                ", enrollmentCount='" + enrollmentCount + '\'' +
                ", majorEnrollmentCount='" + majorEnrollmentCount + '\'' +
                ", subject='" + subjects + '\'' +
                ", retestSubject='" + retestSubjects + '\'' +
                ", lastAdmissionLine='" + lastAdmissionLine + '\'' +
                '}';
    }
}
