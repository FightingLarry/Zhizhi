package me.zhizhi.fragment;

import me.zhizhi.R;
import me.zhizhi.db.dao.ClassessDao;
import me.zhizhi.db.tables.Classes;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

public class ClassesFragment extends BaseFragment {

    private ClassessDao mClassessDao;

    private JazzyListView mJazzyListView;

    public static ClassesFragment newInstance() {
        ClassesFragment fragment = new ClassesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassessDao = new ClassessDao(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mJazzyListView = (JazzyListView) rootView.findViewById(R.id.list);
        mJazzyListView.setTransitionEffect(JazzyHelper.FAN);
        ListAdapter adapter = new SimpleCursorAdapter(mActivity,
                android.R.layout.simple_list_item_1, mClassessDao.queryAll(),
                new String[] { Classes.CLASS_NAME }, new int[] { android.R.id.text1 });
        mJazzyListView.setAdapter(adapter);
        return rootView;
    }

}
