package the.appbuilder.coins;

import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

import the.appbuilder.coins.interfaces.AppAPI;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Date;

import the.appbuilder.coins.utils.DateTypeAdapter;
import the.appbuilder.coins.utils.UserAgentInterceptor;

/**
 * Created by sonique on 12/02/2017.
 */

public class AppService {

    private static AppAPI api;

    public static String getURL() {
        return "http://coincap.io";
    }

    public static AppAPI getService() {

        if(api == null) {
            // TODO: Use a dependancy injector for OkHttpClient
            
            // Custom Date Adapter
            Gson gson = new GsonBuilder()
                    //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .registerTypeAdapter(Date.class, new DateTypeAdapter("yyyy-MM-dd'T'HH:mm:ssZ"))
                    .create();


            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            // add your other interceptors
            // add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!
            httpClient.addInterceptor(new UserAgentInterceptor());


            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            httpClient.cookieJar(new JavaNetCookieJar(cookieManager));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getURL())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();

            api = retrofit.create(AppAPI.class);
        }

        return api;
    }
}