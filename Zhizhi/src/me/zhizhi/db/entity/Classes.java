package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classes")
public class Classes implements Serializable {

    private static final long serialVersionUID = -5860780579455954237L;

    public static final String FOREIGN_ID = "class_id";

    @DatabaseField(generatedId = true)
    private Integer classID;

    @DatabaseField
    private String className;

    @DatabaseField
    private Integer students;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Academys academy;

    // @ForeignCollectionField
    // private ForeignCollection<Curriculums> curriculums;

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    public Academys getAcademy() {
        return academy;
    }

    public void setAcademy(Academys academy) {
        this.academy = academy;
    }

    public Classes() {
        super();
    }

}
