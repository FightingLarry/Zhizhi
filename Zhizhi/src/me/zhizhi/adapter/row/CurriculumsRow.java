package me.zhizhi.adapter.row;

import java.sql.SQLException;
import java.util.List;

import me.zhizhi.db.constants.Lessions;
import me.zhizhi.db.constants.Week;
import me.zhizhi.db.entity.Classes;
import me.zhizhi.db.entity.Courses;
import me.zhizhi.db.entity.Curriculums;
import me.zhizhi.db.helper.DatabaseHelper;
import me.zhizhi.widget.HScrollView;
import me.zhizhi.widget.HScrollView.OnScrollChangedListener;
import me.zhizhi.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CurriculumsRow {

    public static View newView(Context context, View head) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_curr, null);
        ViewHolder holder = new ViewHolder();
        HScrollView listScrollView = (HScrollView) view.findViewById(R.id.h_scrollview);

        HScrollView headScrollView = (HScrollView) head.findViewById(R.id.h_scrollview_head);
        headScrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(listScrollView));

        holder.mItemContainer = view;
        holder.mClassView = (TextView) view.findViewById(R.id.id_class);
        View mon = view.findViewById(R.id.week_mon);
        View tue = view.findViewById(R.id.week_tue);
        View wed = view.findViewById(R.id.week_wed);
        View thu = view.findViewById(R.id.week_thu);
        View fri = view.findViewById(R.id.week_fri);

        holder.mCeil11 = (TextView) mon.findViewById(R.id.cell1);
        holder.mCeil11.setOnClickListener(new OnCeilClick(Week.Monday, Lessions.Morning1));
        holder.mCeil12 = (TextView) mon.findViewById(R.id.cell2);
        holder.mCeil12.setOnClickListener(new OnCeilClick(Week.Monday, Lessions.Morning2));
        holder.mCeil13 = (TextView) mon.findViewById(R.id.cell3);
        holder.mCeil13.setOnClickListener(new OnCeilClick(Week.Monday, Lessions.Afternoon1));
        holder.mCeil14 = (TextView) mon.findViewById(R.id.cell4);
        holder.mCeil14.setOnClickListener(new OnCeilClick(Week.Monday, Lessions.Afternoon2));
        holder.mCeil15 = (TextView) mon.findViewById(R.id.cell5);
        holder.mCeil15.setOnClickListener(new OnCeilClick(Week.Monday, Lessions.Night));

        holder.mCeil21 = (TextView) tue.findViewById(R.id.cell1);
        holder.mCeil21.setOnClickListener(new OnCeilClick(Week.Tuesday, Lessions.Morning1));
        holder.mCeil22 = (TextView) tue.findViewById(R.id.cell2);
        holder.mCeil22.setOnClickListener(new OnCeilClick(Week.Tuesday, Lessions.Morning2));
        holder.mCeil23 = (TextView) tue.findViewById(R.id.cell3);
        holder.mCeil23.setOnClickListener(new OnCeilClick(Week.Tuesday, Lessions.Afternoon1));
        holder.mCeil24 = (TextView) tue.findViewById(R.id.cell4);
        holder.mCeil24.setOnClickListener(new OnCeilClick(Week.Tuesday, Lessions.Afternoon2));
        holder.mCeil25 = (TextView) tue.findViewById(R.id.cell5);
        holder.mCeil25.setOnClickListener(new OnCeilClick(Week.Tuesday, Lessions.Night));

        holder.mCeil31 = (TextView) wed.findViewById(R.id.cell1);
        holder.mCeil31.setOnClickListener(new OnCeilClick(Week.Wednesday, Lessions.Morning1));
        holder.mCeil32 = (TextView) wed.findViewById(R.id.cell2);
        holder.mCeil32.setOnClickListener(new OnCeilClick(Week.Wednesday, Lessions.Morning2));
        holder.mCeil33 = (TextView) wed.findViewById(R.id.cell3);
        holder.mCeil33.setOnClickListener(new OnCeilClick(Week.Wednesday, Lessions.Afternoon1));
        holder.mCeil34 = (TextView) wed.findViewById(R.id.cell4);
        holder.mCeil34.setOnClickListener(new OnCeilClick(Week.Wednesday, Lessions.Afternoon2));
        holder.mCeil35 = (TextView) wed.findViewById(R.id.cell5);
        holder.mCeil35.setOnClickListener(new OnCeilClick(Week.Wednesday, Lessions.Night));

        holder.mCeil41 = (TextView) thu.findViewById(R.id.cell1);
        holder.mCeil41.setOnClickListener(new OnCeilClick(Week.Thursday, Lessions.Morning1));
        holder.mCeil42 = (TextView) thu.findViewById(R.id.cell2);
        holder.mCeil42.setOnClickListener(new OnCeilClick(Week.Thursday, Lessions.Morning2));
        holder.mCeil43 = (TextView) thu.findViewById(R.id.cell3);
        holder.mCeil43.setOnClickListener(new OnCeilClick(Week.Thursday, Lessions.Afternoon1));
        holder.mCeil44 = (TextView) thu.findViewById(R.id.cell4);
        holder.mCeil44.setOnClickListener(new OnCeilClick(Week.Thursday, Lessions.Afternoon2));
        holder.mCeil45 = (TextView) thu.findViewById(R.id.cell5);
        holder.mCeil45.setOnClickListener(new OnCeilClick(Week.Thursday, Lessions.Night));

        holder.mCeil51 = (TextView) fri.findViewById(R.id.cell1);
        holder.mCeil51.setOnClickListener(new OnCeilClick(Week.Friday, Lessions.Morning1));
        holder.mCeil52 = (TextView) fri.findViewById(R.id.cell2);
        holder.mCeil52.setOnClickListener(new OnCeilClick(Week.Friday, Lessions.Morning2));
        holder.mCeil53 = (TextView) fri.findViewById(R.id.cell3);
        holder.mCeil53.setOnClickListener(new OnCeilClick(Week.Friday, Lessions.Afternoon1));
        holder.mCeil54 = (TextView) fri.findViewById(R.id.cell4);
        holder.mCeil54.setOnClickListener(new OnCeilClick(Week.Friday, Lessions.Afternoon2));
        holder.mCeil55 = (TextView) fri.findViewById(R.id.cell5);
        holder.mCeil55.setOnClickListener(new OnCeilClick(Week.Friday, Lessions.Night));
        view.setTag(holder);

        return view;
    }

    private static class OnScrollChangedListenerImp implements OnScrollChangedListener {

        HScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(HScrollView scrollViewar) {
            mScrollViewArg = scrollViewar;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    };

    private static class OnCeilClick implements OnClickListener {

        private Week mWeek;

        private Lessions mLession;

        public OnCeilClick(Week week, Lessions lession) {
            this.mWeek = week;
            this.mLession = lession;
        }

        @Override
        public void onClick(View v) {
            System.out.println(mWeek.getValue() + "," + mLession.getValue());

        }
    };

    public static void bindView(View view, final Classes _class, DatabaseHelper databaseHelper) {
        if (_class == null) {
            return;
        }
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.mClassView.setText(_class.getClassName() + "(" + _class.getStudents() + ")");
        List<Curriculums> curriculumsList = null;
        try {
            curriculumsList = databaseHelper.getCurriculumsList(_class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (curriculumsList == null || curriculumsList.size() == 0) {
            return;
        }

        for (Curriculums c : curriculumsList) {
            Courses course = c.getCourse();
            if (c.getWeek() == Week.Monday.getValue()) {
                if (c.getLession() == Lessions.Morning1.getValue()) {
                    holder.mCeil11.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Morning2.getValue()) {
                    holder.mCeil12.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon1.getValue()) {
                    holder.mCeil13.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon2.getValue()) {
                    holder.mCeil14.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Night.getValue()) {
                    holder.mCeil15.setText(course.getCourseName());
                }
            } else if (c.getWeek() == Week.Tuesday.getValue()) {
                if (c.getLession() == Lessions.Morning1.getValue()) {
                    holder.mCeil21.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Morning2.getValue()) {
                    holder.mCeil22.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon1.getValue()) {
                    holder.mCeil23.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon2.getValue()) {
                    holder.mCeil24.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Night.getValue()) {
                    holder.mCeil25.setText(course.getCourseName());
                }
            } else if (c.getWeek() == Week.Wednesday.getValue()) {
                if (c.getLession() == Lessions.Morning1.getValue()) {
                    holder.mCeil31.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Morning2.getValue()) {
                    holder.mCeil32.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon1.getValue()) {
                    holder.mCeil33.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon2.getValue()) {
                    holder.mCeil34.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Night.getValue()) {
                    holder.mCeil35.setText(course.getCourseName());
                }
            } else if (c.getWeek() == Week.Thursday.getValue()) {
                if (c.getLession() == Lessions.Morning1.getValue()) {
                    holder.mCeil41.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Morning2.getValue()) {
                    holder.mCeil42.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon1.getValue()) {
                    holder.mCeil43.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon2.getValue()) {
                    holder.mCeil44.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Night.getValue()) {
                    holder.mCeil45.setText(course.getCourseName());
                }
            } else if (c.getWeek() == Week.Friday.getValue()) {
                if (c.getLession() == Lessions.Morning1.getValue()) {
                    holder.mCeil51.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Morning2.getValue()) {
                    holder.mCeil52.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon1.getValue()) {
                    holder.mCeil53.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Afternoon2.getValue()) {
                    holder.mCeil54.setText(course.getCourseName());
                } else if (c.getLession() == Lessions.Night.getValue()) {
                    holder.mCeil55.setText(course.getCourseName());
                }
            }

        }

    }

    private static class ViewHolder {

        public View mItemContainer;

        public TextView mClassView;

        public TextView mCeil11;

        public TextView mCeil12;

        public TextView mCeil13;

        public TextView mCeil14;

        public TextView mCeil15;

        public TextView mCeil21;

        public TextView mCeil22;

        public TextView mCeil23;

        public TextView mCeil24;

        public TextView mCeil25;

        public TextView mCeil31;

        public TextView mCeil32;

        public TextView mCeil33;

        public TextView mCeil34;

        public TextView mCeil35;

        public TextView mCeil41;

        public TextView mCeil42;

        public TextView mCeil43;

        public TextView mCeil44;

        public TextView mCeil45;

        public TextView mCeil51;

        public TextView mCeil52;

        public TextView mCeil53;

        public TextView mCeil54;

        public TextView mCeil55;

    }

}
