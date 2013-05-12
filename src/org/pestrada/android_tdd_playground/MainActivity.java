package org.pestrada.android_tdd_playground;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity implements
    ActionBar.OnNavigationListener {

  private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ActionBar actionBar = getActionBar();
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    actionBar.setListNavigationCallbacks(
        new ArrayAdapter<String>(actionBar.getThemedContext(),
            android.R.layout.simple_list_item_1, android.R.id.text1,
            new String[] { getString(R.string.title_section1),
                getString(R.string.title_section2),
                getString(R.string.title_section3), }), this);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
      getActionBar().setSelectedNavigationItem(
          savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
    }
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
        .getSelectedNavigationIndex());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onNavigationItemSelected(int position, long id) {
    Fragment fragment = new DummySectionFragment();
    Bundle args = new Bundle();
    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
    fragment.setArguments(args);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, fragment).commit();
    return true;
  }

}
