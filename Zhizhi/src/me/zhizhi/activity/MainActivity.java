package me.zhizhi.activity;

import me.zhizhi.R;
import me.zhizhi.fragment.ClassesFragment;
import me.zhizhi.fragment.NavigationDrawerFragment;
import me.zhizhi.fragment.TeachersFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

public class MainActivity extends BaseFragmentActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of
     * the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, ClassesFragment.newInstance()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, TeachersFragment.newInstance()).commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, TeachersFragment.newInstance()).commit();
                break;
            case 3:
                // fragmentManager.beginTransaction()
                // .replace(R.id.container, CoursesFragment.newInstance())
                // .commit();
                break;
            case 4:
                // fragmentManager.beginTransaction()
                // .replace(R.id.container,
                // ClassroomsFragment.newInstance()).commit();
                break;
        }

    }

}
