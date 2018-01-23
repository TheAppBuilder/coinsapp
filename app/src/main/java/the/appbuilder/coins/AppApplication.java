package the.appbuilder.coins;

import android.app.Application;


import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
import com.crashlytics.android.Crashlytics;

public class AppApplication extends Application {

    private static AppApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        AppApplication.instance = this;

        if( !Fabric.isInitialized()) {
            Fabric.with(this, new Crashlytics());
        }
    }


    public static AppApplication getInstance() {
        return instance;
    }

    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(/* R.xml.global_tracker*/ "SET_GA") ;
        }
        return mTracker;
    }
}
