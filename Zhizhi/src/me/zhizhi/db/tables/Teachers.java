package me.zhizhi.db.tables;

public class Teachers {

    public final static String TABLENAME = "teachers_titles";

    public final static String TEACHER_ID = "teacherID";

    public final static String TEACHER_NAME = "teacherName";

    public final static String TITLE_ID = Titles.TITLE_ID;

    private Integer teacherID;

    private String teacherName;

    private Integer titleID;

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }

}
