package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

/**
 * 排名表
 * Created by Rachel on 17/4/9.
 */
@Table("rank_table")
public class RankTable extends BaseTable {
    @Unique
    @NotNull
    private String majorName;
    @NotNull
    private String schoolRanks;

    public RankTable(String majorName, String schoolRanks) {
        this.majorName = majorName;
        this.schoolRanks = schoolRanks;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getSchoolRanks() {
        return schoolRanks;
    }

    public void setSchoolRanks(String schoolRanks) {
        this.schoolRanks = schoolRanks;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
