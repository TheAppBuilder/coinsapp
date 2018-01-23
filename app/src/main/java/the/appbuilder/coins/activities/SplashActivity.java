package the.appbuilder.coins.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import the.appbuilder.coins.R;

import the.appbuilder.coins.utils.PreferenceManager;

import the.appbuilder.coins.utils.TrackableActivity;
import the.appbuilder.coins.activities.MainActivity;

/**
 * Created by sonique on 26/02/2017.
 */

public class SplashActivity extends TrackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = null;
        if(false && PreferenceManager.getInstance().get("FirstLaunch", null) == null) {
            intent = new Intent(this, OnBoardingActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}