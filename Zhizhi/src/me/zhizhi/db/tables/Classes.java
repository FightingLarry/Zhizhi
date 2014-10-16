package me.zhizhi.db.tables;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classes")
public class Classes implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5860780579455954237L;

    @DatabaseField(generatedId = true)
    private Integer classID;

    @DatabaseField
    private String className;

    @DatabaseField
    private Integer students;

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

}
