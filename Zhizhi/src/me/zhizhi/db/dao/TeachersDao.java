package me.zhizhi.db.dao;

import me.zhizhi.db.tables.Teachers;
import android.content.Context;
import android.database.Cursor;

public class TeachersDao extends BaseDao {

    public TeachersDao(Context context) {
        super(context);
    }

    @Override
    protected String getTableName() {
        return Teachers.TABLENAME;
    }

    public Cursor queryAll() {
        String[] columns = new String[] { Teachers.TEACHER_ID + " AS _id", Teachers.TEACHER_NAME };
        return query(columns, null, null, null, null, null, null);
    }

}
