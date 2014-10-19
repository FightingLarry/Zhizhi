package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.TeachersAdapter;
import me.zhizhi.db.tables.Teachers;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.dao.Dao;

public class TeachersFragment extends BaseFragment {
	private Dao<Teachers, Integer> mTeachersDao;
	private AbstractAdapter<Teachers> mAdapter;

	public static TeachersFragment newInstance() {
		TeachersFragment fragment = new TeachersFragment();
		return fragment;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		try {
			mTeachersDao = mSQLiteAssetHelper.getTeachersDao();
			List<Teachers> list = mTeachersDao.queryForAll();
			getAdapter().addItem(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_main;
	}

	@Override
	protected AbstractAdapter<Teachers> getAdapter() {
		if (mAdapter == null) {
			mAdapter = new TeachersAdapter(mActivity);
		}
		return mAdapter;
	}

}
