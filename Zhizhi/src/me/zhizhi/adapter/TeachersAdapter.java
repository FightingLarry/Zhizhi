/*
 * $id$
 * Copyright (C) 2014 yc.
 */
package me.zhizhi.adapter;

import java.util.ArrayList;
import java.util.List;

import me.zhizhi.adapter.row.TeachersRow;
import me.zhizhi.db.tables.Teachers;
import me.zhizhi.utils.CollectionUtils;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p>
 * <br/>
 * 
 * @className TeachersAdapter.java<br/>
 * @date 2014年10月19日 下午2:28:59<br/>
 *       </p>
 * 
 * @author liuyc
 * @version v1.0.0
 */
public class TeachersAdapter extends AbstractAdapter<Teachers> {
	protected Context mContext;

	public TeachersAdapter(Context context) {
		this.mContext = context;
		if (mList == null) {
			mList = new ArrayList<Teachers>();
		}
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = TeachersRow.newView(mContext);
		}
		TeachersRow.bindView(convertView, mList.get(position));

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
	public void addItem(Teachers t) {
		mList.add(t);
	}

	@Override
	public void addItem(List<Teachers> list) {
		mList.addAll(list);
	}

	@Override
	public boolean isEmpty() {
		return CollectionUtils.isEmpty(mList);
	}

}
