package me.zhizhi.utils;

import java.util.concurrent.atomic.AtomicInteger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewUtils {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static float dpToPx(Context context, int dpValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, metrics);
    }

    public static float spToPx(Context context, int spValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, metrics);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getDimenPx(Context context, int ResId) {
        return context.getResources().getDimensionPixelSize(ResId);
    }

    public static int getScreenHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean isHdpi(Context context) {
        if (getScreenDensity(context) == 240) {
            return true;
        }

        return false;
    }

    public static boolean isLdpi(Context context) {
        if (getScreenDensity(context) == 120) {
            return true;
        }

        return false;
    }

    public static boolean isMdpi(Context context) {
        if (getScreenDensity(context) == 160) {
            return true;
        }

        return false;
    }

    public static boolean isXhdpi(Context context) {
        if (getScreenDensity(context) == 320) {
            return true;
        }

        return false;
    }

    public static void setListViewHeightBasedOnChildren(Context context, ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition 
            return;
        }

        int totalHeight = 0;
        int screenHeight = getScreenHeightPixels(context);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight() + screenHeight;
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 判断点是否落在view内
     */
    public static boolean isPointInView(int rawX, int rawY, View view) {
        if (view == null) {
            return false;
        }

        int coordinates[] = { 0, 0 };
        view.getLocationOnScreen(coordinates);
        int left = coordinates[0];
        int right = left + view.getWidth();
        int top = coordinates[1];
        int bottom = top + view.getHeight();
        if (rawX >= left && rawX <= right && rawY >= top && rawY <= bottom) {
            return true;
        } else {
            return false;
        }
    }

    public static Bitmap drawViewToCanvas(View view, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    public static int getTitleBarHeight(Activity activity) {
        if (activity == null) {
            return 0;
        } else {
            int contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
            int titleBarHeight = contentTop - getStatusBarHeight(activity);
            return titleBarHeight;
        }
    }

    public static int getStatusBarHeight(Activity activity) {
        if (activity == null) {
            return 0;
        } else {
            Rect frame = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            int statusBarHeight = frame.top;
            return statusBarHeight;
        }
    }

    // We define the ratio 800/480 as the default aspect ratio
    public static float getDefaultAspectRatio() {
        return 800 / 480;
    }

    /**
     * Copy from ApiLeval 17
     * 
     * Generate a value suitable for use in {@link #setId(int)}. This value
     * will not collide with ID values generated at build time by aapt for
     * R.id.
     * 
     * @return a generated ID value
     */
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

}
