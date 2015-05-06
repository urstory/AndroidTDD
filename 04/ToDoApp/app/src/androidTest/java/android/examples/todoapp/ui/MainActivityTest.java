package android.examples.todoapp.ui;

import android.app.Activity;
import android.examples.todoapp.R;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testHelloString(){
        Activity activity = getActivity();
        TextView tv = (TextView) activity.findViewById( R.id.TextView1 );
        assertNotNull( tv );
        assertEquals(activity.getText(R.string.hello_world), tv.getText().toString());
    }




}
