package me.zhizhi.db.dao;

import me.zhizhi.db.helper.ZhizhiDbHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDao implements DbOpreate {

    protected ZhizhiDbHelper mZhizhiDbHelper;

    protected abstract String getTableName();

    public BaseDao(Context context) {
        mZhizhiDbHelper = new ZhizhiDbHelper(context);
    }

    @Override
    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        SQLiteDatabase db = mZhizhiDbHelper.getReadableDatabase();
        //        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //        qb.setTables(getTableName());
        Cursor c = db.query(getTableName(), columns, selection, selectionArgs, groupBy, having,
                orderBy);
        c.moveToFirst();
        return c;
    }

    @Override
    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = mZhizhiDbHelper.getWritableDatabase();
        int affectedRows = db.update(getTableName(), values, whereClause, whereArgs);
        db.close();
        return affectedRows;
    }

    @Override
    public int delete(String whereClause, String[] whereArgs) {
        SQLiteDatabase db = mZhizhiDbHelper.getWritableDatabase();
        int affectedRows = db.delete(getTableName(), whereClause, whereArgs);
        db.close();
        return affectedRows;
    }

    @Override
    public long insert(String nullColumnHack, ContentValues values) {
        SQLiteDatabase db = mZhizhiDbHelper.getWritableDatabase();
        long rowID = db.insert(getTableName(), nullColumnHack, values);
        db.close();
        return rowID;
    }

}
