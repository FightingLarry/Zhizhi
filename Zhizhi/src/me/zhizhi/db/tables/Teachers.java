package me.zhizhi.db.tables;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "teachers")
public class Teachers implements Serializable {

	private static final long serialVersionUID = -3550698527564106621L;

	@DatabaseField(generatedId = true)
	private Integer teacherID;

	@DatabaseField
	private String teacherName;

	@DatabaseField
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
