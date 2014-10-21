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

	@DatabaseField(generatedId = true)
	private int coursTeacherID;

	@DatabaseField(foreign = true, columnName = Courses.FOREIGN_ID)
	private Courses courses;

	@DatabaseField(foreign = true, columnName = Teachers.FOREIGN_ID)
	private Teachers teacher;

	public int getCoursTeacherID() {
		return coursTeacherID;
	}

	public void setCoursTeacherID(int coursTeacherID) {
		this.coursTeacherID = coursTeacherID;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
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

	public CoursesTeachers(Courses courses, Teachers teacher) {
		super();
		this.courses = courses;
		this.teacher = teacher;
	}

}
