package org.pestrada.android_tdd_playground;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
  
  public void changeText(View view) {
    TextView textView = (TextView) findViewById(R.id.textView1);
    textView.setText("new text");
  }

}
