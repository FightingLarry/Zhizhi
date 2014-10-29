package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.CurriculumsAdapter;
import me.zhizhi.adapter.row.ClassesRow;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.db.entity.Curriculums;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class ClassesDetailFragment extends BaseFragment {

    public final static String ARGUMENT_CLASS_ID = "argument_class_id";

    public final static String ARGUMENT_POSITION = "argument_position";

    private CurriculumsAdapter mAdapter;

    private int mClassID;

    private int mPosition;

    private Classes mClass;

    private List<Curriculums> mCurriculumsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mClassID = getArguments().getInt(ARGUMENT_CLASS_ID);
            mPosition = getArguments().getInt(ARGUMENT_POSITION);
        }
        try {
            mClass = getDatabaseHelper().getClassesDao().queryForId(mClassID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView(View mainView) {
        ((FrameLayout) mainView).setBackgroundResource(R.color.white);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected void addHeaderViews(LayoutInflater inflater) {
        super.addHeaderViews(inflater);
        View headView = ClassesRow.newView(getActivity());

        if (mClass != null) {
            try {
                mCurriculumsList = getDatabaseHelper().getCurriculumsList(mClass);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ClassesRow.bindView(getActivity(), headView, mClass, mPosition, true, mCurriculumsList,
                    true);
        }
        mJazzyListView.addHeaderView(headView);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_normal_list;
    }

    @Override
    protected AbstractAdapter<Curriculums> getAdapter() {
        if (mAdapter == null) {
            mAdapter = new CurriculumsAdapter(mActivity);
        }
        return mAdapter;
    }

    @Override
    protected void initActionbar(ActionBar actionBar) {
        super.initActionbar(actionBar);
        if (mClass != null) {
            actionBar.setTitle(mClass.getClassName());
        }
    }
}
