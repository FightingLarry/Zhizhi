/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.db.entity;

import java.io.Serializable;
import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * <p>
 * <br/>
 * 
 * @className Academys.java<br/>
 * @packageName me.zhizhi.db.entity<br/>
 * @date 2014年10月21日 下午11:38:55<br/>
 *       </p>
 * 
 * @author liuyc
 * @version v1.0.0
 */
@DatabaseTable(tableName = "academys")
public class Academys implements Serializable {
	private static final long serialVersionUID = 1604276097216176297L;

	@DatabaseField(generatedId = true)
	private int academyID;

	@DatabaseField
	private String academyName;
	/**
	 * 学期
	 */
	@DatabaseField
	private Date semester;

	@DatabaseField
	private int halfYear;

	@ForeignCollectionField
	private ForeignCollection<Classes> classes;

	public int getAcademyID() {
		return academyID;
	}

	public void setAcademyID(int academyID) {
		this.academyID = academyID;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	public Date getSemester() {
		return semester;
	}

	public void setSemester(Date semester) {
		this.semester = semester;
	}

	public int getHalfYear() {
		return halfYear;
	}

	public void setHalfYear(int halfYear) {
		this.halfYear = halfYear;
	}

	public ForeignCollection<Classes> getClasses() {
		return classes;
	}

	public void setClasses(ForeignCollection<Classes> classes) {
		this.classes = classes;
	}

	public Academys() {
		super();
	}

}
