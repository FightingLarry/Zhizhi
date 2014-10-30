/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 课程安排表,两个班合上一堂课
 * 
 * @date 2014年10月21日 下午11:34:19<br/>
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

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = CoursesTeachers.FOREIGN_ID)
    private CoursesTeachers coursesTeacher;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = Classrooms.FOREIGN_ID)
    private Classrooms classroom;

    public int getCurriculumID() {
        return curriculumID;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
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

    public CoursesTeachers getCoursesTeacher() {
        return coursesTeacher;
    }

    public void setCoursesTeacher(CoursesTeachers coursesTeacher) {
        this.coursesTeacher = coursesTeacher;
    }

    public Classrooms getClassroom() {
        return classroom;
    }

    public void setClassroom(Classrooms classroom) {
        this.classroom = classroom;
    }

    public Curriculums() {
        super();
    }

    public Curriculums(int week, int lession, int cycle, CoursesTeachers coursesTeacher) {
        super();
        this.week = week;
        this.lession = lession;
        this.cycle = cycle;
        this.coursesTeacher = coursesTeacher;
    }

}
