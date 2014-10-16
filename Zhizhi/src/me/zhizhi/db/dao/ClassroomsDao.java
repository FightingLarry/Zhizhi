package me.zhizhi.db.dao;

import me.zhizhi.db.tables.Classrooms;
import android.content.Context;
import android.database.Cursor;

public class ClassroomsDao extends BaseDao {

    public ClassroomsDao(Context context) {
        super(context);
    }

    @Override
    protected String getTableName() {
        return Classrooms.TABLENAME;
    }

    public Cursor queryAll() {
        String[] columns = new String[] { Classrooms.CLASSROOM_ID + " AS _id",
                Classrooms.CLASSROOM_NAME };
        return query(columns, null, null, null, null, null, null);
    }

}
