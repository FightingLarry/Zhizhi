package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.ClassesAdapter;
import me.zhizhi.db.entity.Academys;
import me.zhizhi.db.entity.Classes;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.dao.ForeignCollection;

public class ClassesFragment extends BaseFragment {

    private ClassesAdapter mAdapter;

    private List<Classes> mClassList;

    public static ClassesFragment newInstance() {
        ClassesFragment fragment = new ClassesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            List<Academys> list = getDatabaseHelper().getAcademysDao().queryForAll();
            Academys academy = list.get(0);
            if (academy != null) {
                ForeignCollection<Classes> classes = academy.getClasses();
                mClassList = new ArrayList<Classes>();
                for (Classes c : classes) {
                    mClassList.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAdapter().addItem(mClassList);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_normal_list;
    }

    @Override
    protected AbstractAdapter<Classes> getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ClassesAdapter(mActivity, getDatabaseHelper());
        }
        return mAdapter;
    }

}
