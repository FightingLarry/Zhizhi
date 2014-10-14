package me.zhizhi.db.helper;

import me.zhizhi.db.sqliteasset.SQLiteAssetHelper;
import android.content.Context;

public class ZhizhiDbHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "zhizhi.db";

    private static final int DATABASE_VERSION = 1;

    public ZhizhiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

}
