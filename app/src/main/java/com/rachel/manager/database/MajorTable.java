package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

/**
 * 专业
 * Created by Rachel on 17/4/3.
 */
@Table("major_table")
public class MajorTable extends BaseTable {
    @Unique
    @NotNull
    private String majorId;
    @NotNull
    private String year;//招生年份
    @NotNull
    private String name;//专业
    @NotNull
    private long code;
    private int enrollmentCount;//院招生人数
    private int majorEnrollmentCount;//专业招生人数
    private String subjects;//考试科目
    private String retestSubjects;//复试科目
    private String lastAdmissionLine;//去年录取线

    public MajorTable(String year, String name, long code) {
        this.majorId = year + code;
        this.year = year;
        this.name = name;
        this.code = code;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
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

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getRetestSubjects() {
        return retestSubjects;
    }

    public void setRetestSubjects(String retestSubjects) {
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
