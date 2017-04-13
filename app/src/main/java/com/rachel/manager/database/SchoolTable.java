package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;
import com.litesuits.orm.db.enums.Relation;

import java.util.ArrayList;

/**
 * 学校表
 * Created by Rachel on 17/4/3.
 */
@Table("school_table")
public class SchoolTable extends BaseTable{

    @Ignore
    public static final String COL_211 = "is211";
    @Ignore
    public static final String COL_985 = "is985";
    @Ignore
    public static final String COL_AREA = "area";
    @Ignore
    public static final String COL_NAME = "name";

    @NotNull
    @Unique
    @Column(COL_NAME)
    private String name;//学校名称
    private String detailLink;//百科
    private String desc;

    @Mapping(Relation.OneToMany)
    private ArrayList<CollegeTable> colleges;//院
    @Column(COL_AREA)
    private String area;//地区
    @Column(COL_985)
    private boolean is985;
    @Column(COL_211)
    private boolean is211;
    private String advantages;//优势专业
    private String enName;
    private String shortName;
    private String type;
    private int icon;

    public SchoolTable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public ArrayList<CollegeTable> getColleges() {
        return colleges;
    }

    public void setColleges(ArrayList<CollegeTable> colleges) {
        this.colleges = colleges;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean is985() {
        return is985;
    }

    public void setIs985(boolean is985) {
        this.is985 = is985;
    }

    public boolean is211() {
        return is211;
    }

    public void setIs211(boolean is211) {
        this.is211 = is211;
    }


    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SchoolTable{" +
                "name='" + name + '\'' +
                ", detailLink='" + detailLink + '\'' +
                ", colleges=" + colleges +
                ", area='" + area + '\'' +
                ", is985=" + is985 +
                ", is211=" + is211 +
                ", advantages=" + advantages +
                ", enName='" + enName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
