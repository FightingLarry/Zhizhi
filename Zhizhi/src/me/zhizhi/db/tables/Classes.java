package me.zhizhi.db.tables;

public class Classes extends Tables {

    public final static String TABLENAME = "classes";

    public final static String CLASS_ID = "classID";

    public final static String CLASS_NAME = "className";

    public final static String STUDENTS = "students";

    private Integer classID;

    private String className;

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
