package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classrooms")
public class Classrooms implements Serializable {

    private static final long serialVersionUID = 7551429713491681659L;

    @DatabaseField(generatedId = true)
    private Integer classroomID;

    @DatabaseField
    private String classroomName;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Curriculums curriculums;

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

    public Curriculums getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(Curriculums curriculums) {
        this.curriculums = curriculums;
    }

    public Classrooms() {
        super();
    }

    public Classrooms(String classroomName, Curriculums curriculums) {
        super();
        this.classroomName = classroomName;
        this.curriculums = curriculums;
    }
}
