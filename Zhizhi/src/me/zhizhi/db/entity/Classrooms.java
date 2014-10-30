package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classrooms")
public class Classrooms implements Serializable {

    private static final long serialVersionUID = 7551429713491681659L;

    public static final String FOREIGN_ID = "classroom_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private Integer classroomID;

    @DatabaseField
    private String classroomName;

    @ForeignCollectionField
    private ForeignCollection<Curriculums> curriculums;

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

    public ForeignCollection<Curriculums> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(ForeignCollection<Curriculums> curriculums) {
        this.curriculums = curriculums;
    }

    public Classrooms() {
        super();
    }

}
