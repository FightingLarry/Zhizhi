package me.zhizhi.fragment;

import me.zhizhi.db.helper.DatabaseHelper;
import android.app.Activity;
import android.support.v4.app.Fragment;

import com.j256.ormlite.android.apptools.OpenHelperManager;

public class BaseFragment extends Fragment {

    protected Activity mActivity;

    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    protected DatabaseHelper getDatabaseHelper() {
        if (mDatabaseHelper == null) {
            mDatabaseHelper = OpenHelperManager.getHelper(mActivity, DatabaseHelper.class);
        }
        return mDatabaseHelper;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // You'll need this in your class to release the helper when done.
        if (mDatabaseHelper != null) {
            OpenHelperManager.releaseHelper();
            mDatabaseHelper = null;
        }
    }
}
