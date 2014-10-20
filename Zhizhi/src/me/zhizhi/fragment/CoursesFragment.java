//package me.zhizhi.fragment;
//
//import me.zhizhi.R;
//import me.zhizhi.db.dao.CoursesDao;
//import me.zhizhi.db.tables.Courses;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListAdapter;
//import android.widget.SimpleCursorAdapter;
//
//import com.twotoasters.jazzylistview.JazzyHelper;
//import com.twotoasters.jazzylistview.JazzyListView;
//
//public class CoursesFragment extends BaseFragment {
//
//    private CoursesDao mCoursesDao;
//
//    private JazzyListView mJazzyListView;
//
//    public static CoursesFragment newInstance() {
//        CoursesFragment fragment = new CoursesFragment();
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mCoursesDao = new CoursesDao(getActivity());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        mJazzyListView = (JazzyListView) rootView.findViewById(R.id.list);
//        mJazzyListView.setTransitionEffect(JazzyHelper.FAN);
//        ListAdapter adapter = new SimpleCursorAdapter(mActivity,
//                android.R.layout.simple_list_item_1, mCoursesDao.queryAll(),
//                new String[] { Courses.COURSE_NAME }, new int[] { android.R.id.text1 });
//        mJazzyListView.setAdapter(adapter);
//        return rootView;
//    }
//
//}
