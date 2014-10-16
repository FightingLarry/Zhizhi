package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.ClassesAdapter;
import me.zhizhi.db.tables.Classes;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j256.ormlite.dao.Dao;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

public class ClassesFragment extends BaseFragment {

    private Dao<Classes, Integer> mClassessDao;

    private JazzyListView mJazzyListView;

    public static ClassesFragment newInstance() {
        ClassesFragment fragment = new ClassesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mJazzyListView = (JazzyListView) rootView.findViewById(R.id.list);
        mJazzyListView.setTransitionEffect(JazzyHelper.FAN);

        try {
            mClassessDao = getDatabaseHelper().getClassesDao();
            ClassesAdapter adapter = new ClassesAdapter(mActivity);
            mJazzyListView.setAdapter(adapter);
            List<Classes> list = mClassessDao.queryForAll();
            adapter.addItem(list);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rootView;
    }

}
