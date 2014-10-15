package me.zhizhi.db.tables;

public class Titles extends Tables {

    public final static String TABLENAME = "titles";

    public final static String TITLE_ID = "titleID";

    public final static String TITLE_NAME = "titleName";

    private Integer titleID;

    private String titleName;

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

}
