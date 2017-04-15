package com.rachel.manager.database;

import android.support.annotation.NonNull;

import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;
import com.litesuits.orm.db.enums.Relation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 专业表格
 * Created by Rachel on 17/4/3.
 */
@Table("college_table")
public class CollegeTable extends BaseTable {

    @Ignore
    static final long serialVersionUID = 0L;

    @Ignore
    private Map<String, List<MajorTable>> mMajorMap = new TreeMap<>();

    @Unique
    @NotNull
    private int collegeId;

    @NotNull
    private String name;//院名称

    @NotNull
    private String schoolName;

    @Mapping(Relation.OneToMany)
    private ArrayList<MajorTable> majors;//专业

    public CollegeTable(String name, String schoolName) {
        this.collegeId = (name + schoolName).hashCode();
        this.name = name;
        this.schoolName = schoolName;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @NonNull
    public List<MajorTable> getMajorByYear(String year) {
        if (mMajorMap.isEmpty()) {
            initMap();
        }
        List<MajorTable> majorTableList = mMajorMap.get(year);
        return majorTableList == null ? new ArrayList<MajorTable>() : majorTableList;
    }

    @NonNull
    public List<String> getYearList() {
        if (mMajorMap.isEmpty()) {
            initMap();
        }
        Set<String> yearSet = mMajorMap.keySet();
        List<String> yearList = new ArrayList<>(yearSet);
        Collections.reverse(yearList);
        return yearList;
    }

    private void initMap() {
        if (majors == null || majors.size() == 0) {
            return;
        }

        for (MajorTable majorTable : majors) {
            String year = majorTable.getYear();
            if (mMajorMap.containsKey(year)) {
                List<MajorTable> value = mMajorMap.get(year);
                value.add(majorTable);
            } else {
                List<MajorTable> value = new ArrayList<>();
                value.add(majorTable);
                mMajorMap.put(year, value);
            }
        }
    }

    @Override
    public String toString() {
        return "CollegeTable{" +
                "collegeId=" + collegeId +
                ", name='" + name + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", majors=" + majors +
                '}';
    }
}
