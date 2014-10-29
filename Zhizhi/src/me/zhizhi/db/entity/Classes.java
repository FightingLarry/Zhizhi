package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classes")
public class Classes implements Serializable {

    private static final long serialVersionUID = -5860780579455954237L;

    public static final String FOREIGN_ID = "class_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int classID;

    @DatabaseField
    private String className;

    @DatabaseField
    private int students;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Academys academy;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
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

    public Classes(String className, Integer students, Academys academy) {
        super();
        this.className = className;
        this.students = students;
        this.academy = academy;
    }

}
