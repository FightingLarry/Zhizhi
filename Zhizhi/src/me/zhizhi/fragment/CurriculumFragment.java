package me.zhizhi.fragment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.zhizhi.R;
import me.zhizhi.adapter.AbstractAdapter;
import me.zhizhi.adapter.ClassCurriculumsAdapter;
import me.zhizhi.db.entity.Academys;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.widget.HScrollView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.j256.ormlite.dao.ForeignCollection;

public class CurriculumFragment extends BaseFragment {

    private ClassCurriculumsAdapter mAdapter;

    private List<Classes> mClassList;

    private View mHead;

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
    protected void initView(View mMainView) {
        super.initView(mMainView);

        mHead = mMainView.findViewById(R.id.head);
        mHead.setFocusable(true);
        mHead.setClickable(true);
        mHead.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        mJazzyListView.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        View tue = mHead.findViewById(R.id.week_tue);
        View wed = mHead.findViewById(R.id.week_wed);
        View thu = mHead.findViewById(R.id.week_thu);
        View fri = mHead.findViewById(R.id.week_fri);
        ((TextView) tue.findViewById(R.id.cell5)).setText(R.string.tuesday);
        ((TextView) wed.findViewById(R.id.cell5)).setText(R.string.wednesday);
        ((TextView) thu.findViewById(R.id.cell5)).setText(R.string.thursday);
        ((TextView) fri.findViewById(R.id.cell5)).setText(R.string.friday);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAdapter().addItem(mClassList);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_curriculum;
    }

    @Override
    protected AbstractAdapter<Classes> getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ClassCurriculumsAdapter(mActivity, mHead, getDatabaseHelper());
        }
        return mAdapter;
    }

    class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            //当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView
            HScrollView hScrollView = (HScrollView) mHead.findViewById(R.id.h_scrollview_head);
            hScrollView.onTouchEvent(arg1);
            return false;
        }
    }

    public static Fragment newInstance() {
        return new CurriculumFragment();
    }
}
