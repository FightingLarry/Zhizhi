package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.ClassesAdapter;
import me.zhizhi.db.tables.Classes;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.dao.Dao;

public class ClassesFragment extends BaseFragment {

	private Dao<Classes, Integer> mClassessDao;

	private ClassesAdapter mAdapter;

	public static ClassesFragment newInstance() {
		ClassesFragment fragment = new ClassesFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		try {
			mClassessDao = mSQLiteAssetHelper.getClassesDao();
			List<Classes> list = mClassessDao.queryForAll();
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
	protected AbstractAdapter<Classes> getAdapter() {
		if (mAdapter == null) {
			mAdapter = new ClassesAdapter(mActivity);
		}
		return mAdapter;
	}

}
