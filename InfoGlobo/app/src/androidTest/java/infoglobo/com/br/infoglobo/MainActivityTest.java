package infoglobo.com.br.infoglobo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

/**
 * Created by bruno on 10/04/2017.
 */

public class MainActivityTest extends
        ActivityInstrumentationTestCase2<Activity> {

    final ListView list = (ListView) mActivity.findViewById(R.id.listId);

    assertNotNull("The list was not loaded",list);

    getInstrumentation().

    runOnMainSync(new Runnable() {
        @Override
        public void run () {

            list.performItemClick(list.getAdapter().getView(position, null, null),
                    position, list.getAdapter().getItemId(position));
        }

    });

    getInstrumentation().

    waitForIdleSync();
}