package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.ClassesAdapter;
import me.zhizhi.db.entity.Academys;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.db.entity.Curriculums;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.dao.ForeignCollection;

public class AcademysFragment extends BaseFragment {

    private ClassesAdapter mAdapter;

    public static AcademysFragment newInstance() {
        AcademysFragment fragment = new AcademysFragment();
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

            List<Academys> list = getDatabaseHelper().getAcademysDao().queryForAll();

            ForeignCollection<Classes> classes = list.get(0).getClasses();
            List<Curriculums> cs;
            for (Classes c : classes) {
                cs = getDatabaseHelper().getCurriculumsList(c);
                //                Courses course = cs.get(0).getCours();
            }
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
