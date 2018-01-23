package the.appbuilder.coins;


import  the.appbuilder.coins.BuildConfig;
import org.apache.tools.ant.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


import static org.junit.Assert.*;

import the.appbuilder.coins.activities.FrontRecycleListActivity;

/**
 *  Created by cedric on 9/03/2017.
 **/
    @RunWith(RobolectricTestRunner.class)
    @Config(constants = BuildConfig.class, sdk = 24)
    public class FrontRecycleListActivityTest {

        @Test
        public void FrontRecycleListActivityCanStart() {
            FrontRecycleListActivity frontRecycleListActivity = Robolectric.setupActivity(FrontRecycleListActivity.class);
            assertNotNull(frontRecycleListActivity );
        }

    }