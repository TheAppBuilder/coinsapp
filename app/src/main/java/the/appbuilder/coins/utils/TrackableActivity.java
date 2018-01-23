package the.appbuilder.coins.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import the.appbuilder.coins.AppApplication;

/**
 * Created by sonique on 3/4/17.
 */

public class TrackableActivity extends AppCompatActivity {

    protected FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Tracker mTracker = AppApplication.getInstance().getDefaultTracker();
        mTracker.setScreenName(this.getClass().getSimpleName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        Bundle bundle = new Bundle();
        //bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        //bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(this.getClass().getSimpleName(), bundle);
    }
}
