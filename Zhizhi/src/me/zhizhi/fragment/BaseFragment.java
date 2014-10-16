package me.zhizhi.fragment;

import me.zhizhi.db.helper.SQLiteAssetHelper;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    protected Activity mActivity;

    protected SQLiteAssetHelper mSQLiteAssetHelper;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSQLiteAssetHelper = SQLiteAssetHelper.getInstance(mActivity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SQLiteAssetHelper.getInstance(mActivity).close();
    }
}
