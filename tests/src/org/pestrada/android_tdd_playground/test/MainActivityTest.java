package org.pestrada.android_tdd_playground.test;

import org.pestrada.android_tdd_playground.MainActivity;
import org.pestrada.android_tdd_playground.R;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends
    ActivityInstrumentationTestCase2<MainActivity> {
  
  Activity mainActivity = null;
  Button button = null;

  public MainActivityTest() {
    super(MainActivity.class);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    mainActivity = getActivity();
  }
  
  public void testChangeText() {
    button = (Button) mainActivity.findViewById(R.id.button_test);
    TouchUtils.clickView(this, button);
    TextView view = (TextView) mainActivity.findViewById(R.id.textView1);
    assertEquals("new text", view.getText().toString());
  }

}
