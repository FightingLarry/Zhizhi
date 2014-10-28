package me.zhizhi.activity;

import me.zhizhi.fragment.ActionbarFragment;
import android.content.Context;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class BaseFragmentActivity extends ActionBarActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!ActionbarFragment.sOnBackkeyAction) {
                hideKeyboard();
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    protected void hideKeyboard() {
        InputMethodManager localInputMethodManager = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        View currentFocus = this.getCurrentFocus();

        if (currentFocus != null) {
            IBinder localIBinder = this.getCurrentFocus().getWindowToken();
            localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
        }
    }

}
