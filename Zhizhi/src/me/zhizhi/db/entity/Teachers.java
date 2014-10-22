package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "teachers")
public class Teachers implements Serializable {

    private static final long serialVersionUID = -3550698527564106621L;

    public static final String FOREIGN_ID = "teacher_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int teacherID;

    @DatabaseField
    private String teacherName;

    /**
     * 这个是一个普通的字段@DatabaseField，只是在后面加了个foreign 在数据库中的名称默认为title_id
     * 查询到的Teachers对象中可以直接获取到对应的Titles 删除Teachers，并不会同时删除Titles
     */
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Titles title;

    // @ForeignCollectionField
    // private ForeignCollection<Courses> courses;

    // 必须有一个无参的构造函数
    public Teachers() {
        super();
    }

    public Teachers(String teacherName, Titles title) {
        super();
        this.teacherName = teacherName;
        this.title = title;
    }

    public Teachers(int teacherID, String teacherName) {
        super();
        this.teacherID = teacherID;
        this.teacherName = teacherName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Titles getTitle() {
        return title;
    }

    public void setTitle(Titles title) {
        this.title = title;
    }

}
