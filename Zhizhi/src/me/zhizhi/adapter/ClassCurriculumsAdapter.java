package me.zhizhi.adapter;

import java.util.ArrayList;
import java.util.List;

import me.zhizhi.adapter.row.ClassCurriculumsRow;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.db.helper.DatabaseHelper;
import me.zhizhi.utils.CollectionUtils;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class ClassCurriculumsAdapter extends AbstractAdapter<Classes> {

    private Context mContext;

    private View mHead;

    private DatabaseHelper mDatabaseHelper;

    public ClassCurriculumsAdapter(Context context, View head, DatabaseHelper databaseHelper) {
        this.mContext = context;
        this.mHead = head;
        this.mDatabaseHelper = databaseHelper;

        if (mList == null) {
            mList = new ArrayList<Classes>();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ClassCurriculumsRow.newView(mContext, mHead);
        }
        ClassCurriculumsRow.bindView(convertView, mList.get(position), mDatabaseHelper);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public void clearItem() {
        mList.clear();
    }

    @Override
    public void addItem(Classes t) {
        mList.add(t);
    }

    @Override
    public void addItem(List<Classes> list) {
        mList.addAll(list);
    }

    @Override
    public boolean isEmpty() {
        return CollectionUtils.isEmpty(mList);
    }

}
