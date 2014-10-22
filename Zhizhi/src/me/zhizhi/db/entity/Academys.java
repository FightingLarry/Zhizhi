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

    @DatabaseField
    private String curriculumTitle;

    /**
     * 学年
     */
    @DatabaseField
    private int startYear;

    @DatabaseField
    private int endYear;

    /**
     * 0上半年，1是下半年
     */
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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Academys(String curriculumTitle, String academyName, int startYear, int endYear,
            int halfYear) {
        super();
        this.academyName = academyName;
        this.curriculumTitle = curriculumTitle;
        this.startYear = startYear;
        this.endYear = endYear;
        this.halfYear = halfYear;
    }

    public String getCurriculumTitle() {
        return curriculumTitle;
    }

    public void setCurriculumTitle(String curriculumTitle) {
        this.curriculumTitle = curriculumTitle;
    }

    public Academys() {
        super();
    }

}
