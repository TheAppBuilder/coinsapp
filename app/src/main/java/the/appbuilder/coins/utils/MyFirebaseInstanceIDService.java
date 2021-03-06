package the.appbuilder.coins.utils;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sonique on 15/03/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    protected static final String TAG = "MyFirebaseInstanceID";


    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    protected void sendRegistrationToServer(String token) {
        // TODO:
    }


}