/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.db.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "classes_curriculums")
public class ClassesCurriculums implements Serializable {

	private static final long serialVersionUID = -5340364036338241779L;

	@DatabaseField(generatedId = true)
	private int classCurriculumID;

	@DatabaseField(foreign = true, columnName = Classes.FOREIGN_ID)
	private Classes classes;

	@DatabaseField(foreign = true, columnName = Curriculums.FOREIGN_ID)
	private Curriculums curriculum;

	public int getClassCurriculumID() {
		return classCurriculumID;
	}

	public void setClassCurriculumID(int classCurriculumID) {
		this.classCurriculumID = classCurriculumID;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Curriculums getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculums curriculum) {
		this.curriculum = curriculum;
	}

	public ClassesCurriculums() {
		super();
	}

	public ClassesCurriculums(Classes classes, Curriculums curriculum) {
		super();
		this.classes = classes;
		this.curriculum = curriculum;
	}

}
