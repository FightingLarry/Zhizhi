package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "courses")
public class Courses implements Serializable {

    private static final long serialVersionUID = -2562924436887324487L;

    public static final String FOREIGN_ID = "cours_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int courseID;

    @DatabaseField
    private String courseName;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Courses() {
        super();
    }

    public Courses(String courseName) {
        super();
        this.courseName = courseName;
    }

}
