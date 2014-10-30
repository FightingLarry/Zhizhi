package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "titles")
public class Titles implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FOREIGN_ID = "title_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int id;

    @DatabaseField
    private String titleName;

    /**
     * 在数据库中不会生成对应的字段 获取到Titles的时候同时会获取Titles下面的Teachers
     * 要注意的是：删除Titles的时候，并不会自动删除对应的Teachers
     */
    @ForeignCollectionField
    private ForeignCollection<Teachers> teacher;

    public Titles() {
        super();
    }

    public Titles(String titleName) {
        super();
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public ForeignCollection<Teachers> getTeacher() {
        return teacher;
    }

    public void setTeacher(ForeignCollection<Teachers> teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
