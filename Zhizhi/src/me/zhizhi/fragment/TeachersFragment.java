package me.zhizhi.fragment;

import me.zhizhi.R;
import me.zhizhi.db.dao.TeachersDao;
import me.zhizhi.db.tables.Teachers;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

public class TeachersFragment extends BaseFragment {

    private TeachersDao mTeachersDao;

    private JazzyListView mJazzyListView;

    public static TeachersFragment newInstance() {
        TeachersFragment fragment = new TeachersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeachersDao = new TeachersDao(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mJazzyListView = (JazzyListView) rootView.findViewById(R.id.list);
        mJazzyListView.setTransitionEffect(JazzyHelper.FAN);
        ListAdapter adapter = new SimpleCursorAdapter(mActivity,
                android.R.layout.simple_list_item_1, mTeachersDao.queryAll(),
                new String[] { Teachers.TEACHER_NAME }, new int[] { android.R.id.text1 });
        mJazzyListView.setAdapter(adapter);
        return rootView;
    }

}
