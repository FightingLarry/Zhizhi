package me.zhizhi.db.dao;

import me.zhizhi.db.tables.Courses;
import android.content.Context;
import android.database.Cursor;

public class CoursesDao extends BaseDao {

    public CoursesDao(Context context) {
        super(context);
    }

    @Override
    protected String getTableName() {
        return Courses.TABLENAME;
    }

    public Cursor queryAll() {
        String[] columns = new String[] { Courses.COURSE_ID + " AS _id", Courses.COURSE_NAME };
        return query(columns, null, null, null, null, null, null);
    }

}
