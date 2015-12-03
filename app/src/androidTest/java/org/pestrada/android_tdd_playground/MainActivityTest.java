package org.pestrada.android_tdd_playground;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LAP02 on 03/12/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    Activity mainActivity = null;
    Button button = null;

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

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
