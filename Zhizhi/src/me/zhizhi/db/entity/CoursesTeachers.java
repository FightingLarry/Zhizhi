/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "courses_teachers")
public class CoursesTeachers implements Serializable {

    private static final long serialVersionUID = -5340364036338241779L;

    public static final String FOREIGN_ID = "coursesteachers_id";

    @DatabaseField(generatedId = true, columnName = FOREIGN_ID)
    private int coursTeacherID;

    @DatabaseField(foreign = true, columnName = Courses.FOREIGN_ID)
    private Courses course;

    @DatabaseField(foreign = true, columnName = Teachers.FOREIGN_ID)
    private Teachers teacher;

    public int getCoursTeacherID() {
        return coursTeacherID;
    }

    public void setCoursTeacherID(int coursTeacherID) {
        this.coursTeacherID = coursTeacherID;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public CoursesTeachers() {
        super();
    }

    public CoursesTeachers(Courses course, Teachers teacher) {
        super();
        this.course = course;
        this.teacher = teacher;
    }

}
