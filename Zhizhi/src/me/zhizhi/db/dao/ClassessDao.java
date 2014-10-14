package me.zhizhi.db.dao;

import me.zhizhi.db.tables.Classes;
import android.content.Context;
import android.database.Cursor;

public class ClassessDao extends BaseDao {

	public ClassessDao(Context context) {
		super(context);
	}

	@Override
	protected String getTableName() {
		return Classes.TABLENAME;
	}

	public Cursor queryAll() {
		String[] columns = new String[] { Classes.CLASS_ID + " AS _id",
				Classes.CLASS_NAME };
		return query(columns, null, null, null, null, null, null);
	}

}
