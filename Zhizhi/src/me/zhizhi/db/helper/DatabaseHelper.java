package me.zhizhi.db.helper;

import java.sql.SQLException;

import me.zhizhi.db.tables.Classes;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private final static String TAG = DatabaseHelper.class.getSimpleName();

    // name of the database file for your application -- change to something appropriate for your app
    public static final String DATABASE_NAME = "zhizhi.db";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        try {
            Log.i(TAG, "onCreate");
            TableUtils.createTable(connectionSource, Classes.class);

        } catch (SQLException e) {
            Log.e(TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub

    }

}
