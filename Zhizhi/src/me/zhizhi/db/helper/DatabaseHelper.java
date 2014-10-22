package me.zhizhi.db.helper;

import java.sql.SQLException;

import me.zhizhi.db.entity.Academys;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.db.entity.ClassesCurriculums;
import me.zhizhi.db.entity.Classrooms;
import me.zhizhi.db.entity.Courses;
import me.zhizhi.db.entity.CoursesTeachers;
import me.zhizhi.db.entity.Curriculums;
import me.zhizhi.db.entity.Teachers;
import me.zhizhi.db.entity.Titles;
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
    public static final String DATABASE_NAME = "zhizhi_.db";

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
            TableUtils.createTable(connectionSource, Academys.class);
            TableUtils.createTable(connectionSource, Classes.class);
            TableUtils.createTable(connectionSource, Classrooms.class);
            TableUtils.createTable(connectionSource, Curriculums.class);
            TableUtils.createTable(connectionSource, Courses.class);
            TableUtils.createTable(connectionSource, Teachers.class);
            TableUtils.createTable(connectionSource, Titles.class);
            TableUtils.createTable(connectionSource, ClassesCurriculums.class);
            TableUtils.createTable(connectionSource, CoursesTeachers.class);

            Courses c44 = new Courses("点集拓扑");
            Curriculums cur44 = new Curriculums(4, 4, 0, c44);
            //            Classes cla

            Titles t1 = new Titles("教授");
            getTitlesDao().create(t1);

            Teachers tea1 = new Teachers("高恩勇", t1);
            getTeachersDao().create(tea1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2, int arg3) {
        try {
            TableUtils.dropTable(arg1, Academys.class, true);
            TableUtils.dropTable(arg1, Classes.class, true);
            TableUtils.dropTable(arg1, Classrooms.class, true);
            TableUtils.dropTable(arg1, Curriculums.class, true);
            TableUtils.dropTable(arg1, Courses.class, true);
            TableUtils.dropTable(arg1, Teachers.class, true);
            TableUtils.dropTable(arg1, Titles.class, true);
            TableUtils.dropTable(arg1, ClassesCurriculums.class, true);
            TableUtils.dropTable(arg1, CoursesTeachers.class, true);
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
