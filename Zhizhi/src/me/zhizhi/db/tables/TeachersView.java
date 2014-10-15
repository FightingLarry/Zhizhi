package me.zhizhi.db.tables;

public class TeachersView extends Tables {

    public final static String TABLENAME = "teachers_view";

    private String titleName;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

}
