package me.zhizhi.adapter;

import java.util.List;

import me.zhizhi.utils.CollectionUtils;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class AbstractAdapter<T> extends BaseAdapter {

    protected Context mContext;

    protected LayoutInflater mInflater;

    protected List<T> mList;

    @Override
    public abstract Object getItem(int position);

    public abstract void clearItem();

    public abstract void addItem(T t);

    public abstract void addItem(List<T> list);

    public Object removeItem(int position) {
        return null;
    }

    public void addItem(int postion, T t) {
    }

    public List<T> getList() {
        return mList;
    }

    public void removeAll(List<T> list) {
        mList.removeAll(list);
    }

    public int getCount() {
        return mList.size();
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(mList);
    }

}
