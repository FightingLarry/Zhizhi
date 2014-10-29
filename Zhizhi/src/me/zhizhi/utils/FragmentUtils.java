package me.zhizhi.utils;

import me.zhizhi.R;
import me.zhizhi.activity.ArbitraryFragmentActivity;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class FragmentUtils {

    public static final String ARGUMENTS_KEY_NO_BACK_STACK = "noBackStack";

    public static final String ARGUMENTS_KEY_SHOW_ANIMATION = "showAnimation";

    public static void detachAndAdd(FragmentManager fragmentManager, Fragment fragmentDetach,
            Fragment fragmentAdd, Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentAdd.setArguments(bundle);
        fragmentTransaction.detach(fragmentDetach);
        fragmentTransaction.add(R.id.layout_container_main, fragmentAdd);
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    public static void navigateTo(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        boolean noBackStack = Boolean.FALSE;
        if (bundle != null) {

            if (bundle.getBoolean(ARGUMENTS_KEY_NO_BACK_STACK)) {
                bundle.remove(ARGUMENTS_KEY_NO_BACK_STACK);
                noBackStack = Boolean.TRUE;
            }

            fragment.setArguments(bundle);
        }

        fragmentTransaction.replace(R.id.layout_container_main, fragment);

        if (!noBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    public static void navigateToWithAnimations(FragmentManager fragmentManager, Fragment fragment,
            Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        boolean noBackStack = Boolean.FALSE;
        if (bundle != null) {

            if (bundle.getBoolean(ARGUMENTS_KEY_NO_BACK_STACK)) {
                bundle.remove(ARGUMENTS_KEY_NO_BACK_STACK);
                noBackStack = Boolean.TRUE;
            }

            fragment.setArguments(bundle);
        }

        fragmentTransaction.replace(R.id.layout_container_main, fragment);

        if (!noBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

    }

    public static void navigateToInNewActivity(Context context, String fragmentName, Bundle bundle) {
        Intent intent = new Intent(context, ArbitraryFragmentActivity.class);

        if (bundle != null && bundle.getBoolean(ARGUMENTS_KEY_NO_BACK_STACK)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        }
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_FRAGMENT_CLASS_NAME, fragmentName);
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_BUNDLE, bundle);

        context.startActivity(intent);
    }

    @SuppressLint("NewApi")
    public static void navigateToInNewActivity(Context context, Class<?> fragmentName,
            Bundle bundle, View v) {
        Intent intent = new Intent(context, ArbitraryFragmentActivity.class);

        if (bundle != null && bundle.getBoolean(ARGUMENTS_KEY_NO_BACK_STACK)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        }
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_FRAGMENT_CLASS_NAME,
                fragmentName.getName());
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_BUNDLE, bundle);

        if (v != null && Utils.hasJellyBean()) {
            int location[] = new int[2];
            v.getLocationOnScreen(location);
            ActivityOptions activityOptions = ActivityOptions.makeScaleUpAnimation(v, location[0],
                    location[1], v.getWidth(), v.getHeight());
            if (bundle == null) {
                bundle = new Bundle();
            }
            context.startActivity(intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static void navigateToInNewActivityForResult(Fragment fragmentContext,
            Class<?> fragmentName, Bundle bundle, int requestCode) {

        Intent intent = new Intent(fragmentContext.getActivity(), ArbitraryFragmentActivity.class);
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_FRAGMENT_CLASS_NAME,
                fragmentName.getName());
        intent.putExtra(ArbitraryFragmentActivity.EXTRAS_BUNDLE, bundle);
        fragmentContext.startActivityForResult(intent, requestCode);
    }

    public static void removeAndAdd(FragmentManager fragmentManager, Fragment fragmentRemove,
            Fragment fragmentAdd, Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentAdd.setArguments(bundle);
        fragmentTransaction.remove(fragmentRemove);
        fragmentTransaction.add(R.id.layout_container_main, fragmentAdd);
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    public static void replaceFragment(int fragmentId, FragmentManager fragmentManager,
            Fragment fragment, Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentTransaction.replace(fragmentId, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    public static void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

}
