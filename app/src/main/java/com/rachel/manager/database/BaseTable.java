package com.rachel.manager.database;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

/**
 * 基础表格
 * Created by Rachel on 17/4/3.
 */

public class BaseTable implements Serializable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    protected int id = 0; //编号
}
