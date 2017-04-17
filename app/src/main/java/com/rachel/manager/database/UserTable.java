package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;

/**
 * 用户表
 * Created by Rachel on 17/4/2.
 */
@Table("user_table")
public class UserTable extends BaseTable {

    @Ignore
    public static final String COL_USER_NAME = "userName";
    @Ignore
    public static final String COL_PASSWORD = "password";

    @Ignore
    public static final int ROLE_USER = 0;
    @Ignore
    public static final int ROLE_MANAGER = 1;
    @Ignore
    public static final int ROLE_SUPER_USER = 2;

    @NotNull
    @Unique
    @Column(COL_USER_NAME)
    private String userName; //用户名

    @NotNull
    @Column(COL_PASSWORD)
    private String password; //密码
    private String name = ""; //姓名

    /**
     * 0，普通用户。1，管理员。2，super User。
     */
    @NotNull
    private int role; //角色

    public UserTable(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
