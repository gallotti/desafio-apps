package infoglobo.com.br.infoglobo;

import android.support.test.annotation.UiThreadTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

/**
 * Created by bruno on 10/04/2017.
 */

public class MainActivityTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private ListView listView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        listView = (ListView)mainActivity.findViewById(R.id.list_content);
    }

    public void testPreconditions() {
        assertNotNull("button is null",listView);
    }

    @UiThreadTest
    public void testListClick() {

        getInstrumentation().runOnMainSync(new Runnable() {
        @Override
        public void run () {

            listView.performItemClick(listView.getAdapter().getView(1, null, null),
                    1, listView.getAdapter().getItemId(1));
        }

    });

        getInstrumentation().waitForIdleSync();

    }

}