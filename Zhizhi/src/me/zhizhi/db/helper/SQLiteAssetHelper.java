package me.zhizhi.db.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import me.zhizhi.db.tables.Classes;
import me.zhizhi.db.tables.Teachers;
import me.zhizhi.utils.Utils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class SQLiteAssetHelper {

	private static final String ASSET_DB_PATH = "databases";

	public static final String DATABASE_NAME = "zhizhi.db";

	private AndroidConnectionSource connectionSource;

	private Dao<Classes, Integer> mClassesDao;

	private Dao<Teachers, Integer> mTeachersDao;

	private static SQLiteAssetHelper instance;

	public synchronized static SQLiteAssetHelper getInstance(Context context) {
		if (instance == null) {
			instance = new SQLiteAssetHelper(context);
		}
		return instance;
	}

	private SQLiteAssetHelper(Context context) {

		String mAssetPath = ASSET_DB_PATH + "/" + DATABASE_NAME;
		String mDatabasePath = context.getApplicationInfo().dataDir;
		File file = new File(mDatabasePath, DATABASE_NAME);
		if (!file.exists()) {
			InputStream is = null;
			try {
				// try uncompressed
				is = context.getAssets().open(mAssetPath);
				Utils.writeExtractedFileToDisk(is, new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		SQLiteDatabase db = SQLiteDatabase.openDatabase(file.getPath(), null,
				SQLiteDatabase.OPEN_READWRITE);
		connectionSource = new AndroidConnectionSource(db);
	}

	public <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws Exception {
		if (connectionSource != null) {
			return DaoManager.createDao(connectionSource, clazz);
		}
		return null;
	}

	public Dao<Classes, Integer> getClassesDao() throws SQLException {
		if (mClassesDao == null) {
			try {
				mClassesDao = getDao(Classes.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mClassesDao;
	}

	public Dao<Teachers, Integer> getTeachersDao() throws SQLException {

		if (mTeachersDao == null) {
			try {
				mTeachersDao = getDao(Teachers.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mTeachersDao;
	}

	public void close() {
		mClassesDao = null;
	}
}
