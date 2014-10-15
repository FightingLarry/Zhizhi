package me.zhizhi.db.tables;

public class Courses extends Tables {

    public final static String TABLENAME = "courses";

    public final static String COURSE_ID = "courseID";

    public final static String COURSE_NAME = "courseName";

    private Integer courseID;

    private String courseName;

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
