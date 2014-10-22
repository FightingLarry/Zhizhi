package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "courses")
public class Courses implements Serializable {

    private static final long serialVersionUID = -2562924436887324487L;

    public static final String FOREIGN_ID = "cours_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int courseID;

    @DatabaseField
    private String courseName;

    // @ForeignCollectionField
    // private ForeignCollection<Teachers> teachers;

    @ForeignCollectionField
    private ForeignCollection<Curriculums> curriculums;

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

    public ForeignCollection<Curriculums> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(ForeignCollection<Curriculums> curriculums) {
        this.curriculums = curriculums;
    }

    public Courses() {
        super();
    }

    public Courses(String courseName) {
        super();
        this.courseName = courseName;
    }

}
