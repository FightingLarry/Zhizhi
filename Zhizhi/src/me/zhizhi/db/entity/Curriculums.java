/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * <p>
 * <br/>
 * 
 * 课程安排表
 * 
 * @className Curriculums.java<br/>
 * @packageName me.zhizhi.db.entity<br/>
 * @date 2014年10月21日 下午11:34:19<br/>
 *       </p>
 * 
 * @author liuyc
 * @version v1.0.0
 */
@DatabaseTable(tableName = "curriculums")
public class Curriculums implements Serializable {

    private static final long serialVersionUID = 7511075687816530947L;

    public static final String FOREIGN_ID = "curriculum_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int curriculumID;

    @DatabaseField
    private int week;

    @DatabaseField
    private int lession;

    /**
     * 0为每周都上课，1为单周，2为双周
     */
    @DatabaseField(defaultValue = "0")
    private int cycle;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Courses course;

    // /**
    // * 两个班合上一堂课
    // */
    // @ForeignCollectionField
    // private ForeignCollection<Classes> classes;

    @ForeignCollectionField
    private ForeignCollection<Classrooms> classrooms;

    public int getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getLession() {
        return lession;
    }

    public void setLession(int lession) {
        this.lession = lession;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public ForeignCollection<Classrooms> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(ForeignCollection<Classrooms> classrooms) {
        this.classrooms = classrooms;
    }

    public Curriculums() {
        super();
    }

    public Curriculums(int week, int lession, int cycle, Courses course) {
        super();
        this.week = week;
        this.lession = lession;
        this.cycle = cycle;
        this.course = course;
    }

}
