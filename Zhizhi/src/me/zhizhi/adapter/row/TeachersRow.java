package me.zhizhi.adapter.row;

import me.zhizhi.R;
import me.zhizhi.db.tables.Teachers;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class TeachersRow {

	public static View newView(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_classes,
				null);
		ViewHolder holder = new ViewHolder();
		holder.mItemContainer = view;
		holder.mTitle = (TextView) view.findViewById(R.id.item_title);
		holder.mContent = (TextView) view.findViewById(R.id.item_content);
		view.setTag(holder);

		return view;
	}

	public static void bindView(View view, final Teachers mTeachers) {
		if (mTeachers == null) {
			return;
		}
		ViewHolder hodler = (ViewHolder) view.getTag();

		hodler.mTitle.setText(mTeachers.getTeacherName());
		hodler.mContent.setText(String.valueOf(mTeachers.getTitleID()));

	}

	private static class ViewHolder {

		public View mItemContainer;

		public TextView mTitle;

		public TextView mContent;

	}

}
