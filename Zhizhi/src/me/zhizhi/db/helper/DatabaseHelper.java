package me.zhizhi.db.helper;

import java.sql.SQLException;

import me.zhizhi.db.tables.Teachers;
import me.zhizhi.db.tables.Titles;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private final static String TAG = DatabaseHelper.class.getSimpleName();

	// name of the database file for your application -- change to something
	// appropriate for your app
	public static final String DATABASE_NAME = "zhizhi1.db";

	// any time you make changes to your database objects, you may have to
	// increase the database version
	private static final int DATABASE_VERSION = 1;

	private Dao<Teachers, Integer> mTeachersDao;
	private Dao<Titles, Integer> mTitlesDao;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			TableUtils.createTable(connectionSource, Teachers.class);
			TableUtils.createTable(connectionSource, Titles.class);

			Titles t1 = new Titles("教授");
			getTitlesDao().create(t1);

			Teachers tea1 = new Teachers("高恩勇", t1);
			getTeachersDao().create(tea1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {
			TableUtils.dropTable(arg1, Teachers.class, true);
			TableUtils.dropTable(arg1, Titles.class, true);
			this.onCreate(arg0, arg1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Dao<Teachers, Integer> getTeachersDao() throws SQLException {
		if (mTeachersDao == null) {
			mTeachersDao = getDao(Teachers.class);
		}
		return mTeachersDao;
	}

	public Dao<Titles, Integer> getTitlesDao() throws SQLException {
		if (mTitlesDao == null) {
			mTitlesDao = getDao(Titles.class);
		}
		return mTitlesDao;
	}

}
