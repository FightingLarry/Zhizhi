package me.zhizhi.activity;

import me.zhizhi.R;
import me.zhizhi.utils.FragmentUtils;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.WindowManager;

public class ArbitraryFragmentActivity extends FragmentActivity {

    public static final String EXTRAS_BUNDLE = "me.zhizhi.extras_bundle";

    public static final String EXTRAS_FRAGMENT_CLASS_NAME = "me.zhizhi.extras_fragment_class_name";

    public final static String ARGUMENTS_KEY_WINDOW_SOFTINPUTMODE = "arguments_key_window_softinputmode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle activityBundle = getIntent().getBundleExtra(EXTRAS_BUNDLE);
        if (activityBundle != null) {
            boolean isWindowSoftInputMode = activityBundle.getBoolean(
                    ARGUMENTS_KEY_WINDOW_SOFTINPUTMODE, false);
            if (isWindowSoftInputMode) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbitrary);
        initializeStartingFragment();
    }

    private void initializeStartingFragment() {
        String className = null;
        Bundle bundle = null;
        if (getSupportFragmentManager().findFragmentById(R.id.layout_container_main) == null
                && getIntent() != null && getIntent().getExtras() != null) {
            className = getIntent().getExtras().getString(EXTRAS_FRAGMENT_CLASS_NAME);
            bundle = getIntent().getExtras().getBundle(EXTRAS_BUNDLE);
        }

        if (!TextUtils.isEmpty(className)) {
            try {
                Fragment fragment = (Fragment) Class.forName(className).newInstance();
                loadFragment(fragment, bundle);
            } catch (Exception e) {
                e.printStackTrace();
                //                throw new RuntimeException("No fragment by the name of " + className + " found");
            }
        }
    }

    protected void loadFragment(Fragment fragment, Bundle bundle) {
        if (fragment == null) {
            finish();
        }
        FragmentUtils.replaceFragment(R.id.layout_container_main, getSupportFragmentManager(),
                fragment, bundle);

    }
}
