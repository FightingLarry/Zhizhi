package me.zhizhi.fragment;

import me.zhizhi.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class ActionbarFragment extends Fragment {

    /**
     * fragment需要响应back键事件时，{@link ActionbarFragment#isBackkeyAction()}
     * =true
     */
    public static boolean sOnBackkeyAction = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        initActionbar();
    }

    private void initActionbar() {
        initActionbar(((ActionBarActivity) getActivity()).getSupportActionBar());

    }

    protected void initActionbar(ActionBar actionBar) {
        if (isHideActionbar()) {
            actionBar.hide();
        } else {
            actionBar.show();
        }
        actionBar.setTitle(getActionbarTitle());
        if (isShowBackKey()) {
            actionBar.setHomeButtonEnabled(true);
            actionBar
                    .setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_HOME_AS_UP);
        } else {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
        }
        sOnBackkeyAction = isBackkeyAction();
    }

    protected int getActionbarTitle() {
        return R.string.app_name;
    }

    protected boolean isShowBackKey() {
        return false;
    }

    protected boolean isHideActionbar() {
        return false;
    }

    protected boolean isBackkeyAction() {
        return false;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (sOnBackkeyAction) {
            sOnBackkeyAction = false;
        }
    }

}
