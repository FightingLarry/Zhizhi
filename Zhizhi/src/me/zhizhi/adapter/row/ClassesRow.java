package me.zhizhi.adapter.row;

import me.zhizhi.R;
import me.zhizhi.db.entity.Classes;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ClassesRow {

    public static View newView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_classes, null);
        ViewHolder holder = new ViewHolder();
        holder.mItemContainer = view;
        holder.mTitle = (TextView) view.findViewById(R.id.item_title);
        holder.mContent = (TextView) view.findViewById(R.id.item_content);
        view.setTag(holder);

        return view;
    }

    public static void bindView(View view, final Classes mClasses) {
        if (mClasses == null) {
            return;
        }
        ViewHolder hodler = (ViewHolder) view.getTag();

        hodler.mTitle.setText(mClasses.getClassName());
        hodler.mContent.setText(mClasses.getStudents() + "人");

    }

    private static class ViewHolder {

        public View mItemContainer;

        public TextView mTitle;

        public TextView mContent;

    }

}
