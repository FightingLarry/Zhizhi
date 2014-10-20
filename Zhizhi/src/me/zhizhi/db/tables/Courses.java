package me.zhizhi.db.tables;

import java.io.Serializable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "courses")
public class Courses implements Serializable {

    private static final long serialVersionUID = -2562924436887324487L;

    @DatabaseField(generatedId = true)
    private int courseID;

    @DatabaseField
    private String courseName;

    @ForeignCollectionField
    private ForeignCollection<Teachers> teachers;

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

    public ForeignCollection<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(ForeignCollection<Teachers> teachers) {
        this.teachers = teachers;
    }

}
