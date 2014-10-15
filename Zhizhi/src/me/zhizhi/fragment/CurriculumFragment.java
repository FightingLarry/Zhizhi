package me.zhizhi.fragment;

import me.zhizhi.R;
import me.zhizhi.R.layout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CurriculumFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_curriculum, container);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
