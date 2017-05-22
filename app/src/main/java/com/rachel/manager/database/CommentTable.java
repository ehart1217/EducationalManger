package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Rachel on 17/5/23.
 */
@Table("comment_table")
public class CommentTable extends BaseTable{

    @Ignore
    public static final String COLUMN_MAJOR_ID = "majorId";
    @Ignore
    public static final String COLUMN_DATE = "date";

    private String comment = "";

    @Column(COLUMN_DATE)
    private long data;

    @NotNull
    @Column(COLUMN_MAJOR_ID)
    private String majorId;

    private String userName;

    public CommentTable(String comment, long data, String majorId, String userName) {
        this.comment = comment;
        this.data = data;
        this.majorId = majorId;
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
