package me.zhizhi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseListFragment extends Fragment {

    protected abstract BaseAdapter getAdapter();

    protected abstract int getLayoutResource();

    protected abstract void readCacheOrExcuteRequest();

    protected void addHeaderViews(LayoutInflater inflater) {
    }

    protected void addFooterViews(LayoutInflater inflater) {
    }

    public void loadMore() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
