package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

import java.util.ArrayList;

/**
 * 专业表格
 * Created by Rachel on 17/4/3.
 */
@Table("college_table")
public class CollegeTable extends BaseTable {

    static final long serialVersionUID =0L;

    @Unique
    @NotNull
    private long collegeId;

    @NotNull
    private String name;//院名称

    private ArrayList<MajorTable> majors;//专业

    public CollegeTable(long collegeId, String name) {
        this.collegeId = collegeId;
        this.name = name;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MajorTable> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<MajorTable> majors) {
        this.majors = majors;
    }

    @Override
    public String toString() {
        return "CollegeTable{" +
                "collegeId=" + collegeId +
                ", name='" + name + '\'' +
                ", majors=" + majors +
                '}';
    }
}
