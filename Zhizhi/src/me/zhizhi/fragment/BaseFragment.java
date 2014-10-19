package me.zhizhi.fragment;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.db.helper.SQLiteAssetHelper;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

public class BaseFragment extends Fragment {

	protected Activity mActivity;
	protected SQLiteAssetHelper mSQLiteAssetHelper;
	protected JazzyListView mJazzyListView;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mainView = null;
		if (getLayoutResource() != 0) {
			mainView = inflater.inflate(getLayoutResource(), null);
			mJazzyListView = (JazzyListView) mainView.findViewById(R.id.list);
			if (mJazzyListView != null) {
				mJazzyListView.setTransitionEffect(JazzyHelper.FAN);
				if (getAdapter() != null) {
					mJazzyListView.setAdapter(getAdapter());
				}

			}
			super.onCreateView(inflater, container, savedInstanceState);
		}
		if (mainView == null) {
			mainView = super.onCreateView(inflater, container,
					savedInstanceState);
		}
		return mainView;
	}

	protected int getLayoutResource() {
		return 0;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		SQLiteAssetHelper.getInstance(mActivity).close();
	}

	protected AbstractAdapter<?> getAdapter() {
		return null;
	}

}
