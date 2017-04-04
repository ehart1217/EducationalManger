package com.rachel.manager.database;

/**
 * 用户缓存
 * Created by Rachel on 17/4/3.
 */

public class UserCache {
    private static UserTable userTable;

    public static void init(UserTable userTable) {
        UserCache.userTable = userTable;
    }

    public static UserTable get() {
        if (userTable == null) {
            throw (new RuntimeException("用户不能为空"));
        }
        return userTable;
    }
}
