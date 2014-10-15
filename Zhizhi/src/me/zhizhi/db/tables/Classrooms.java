package me.zhizhi.db.tables;

public class Classrooms extends Tables {

    public final static String TABLENAME = "classrooms";

    public final static String CLASSROOM_ID = "classroomID";

    public final static String CLASSROOM_NAME = "classroomName";

    private Integer classroomID;

    private String classroomName;

    public Integer getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(Integer classroomID) {
        this.classroomID = classroomID;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

}
