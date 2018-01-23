package the.appbuilder.coins.interfaces;

import the.appbuilder.coins.model.Front;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sonique on 25/08/2016.
 */
public interface AppAPI {

    //@POST("login")
    //Call<LoginResponse> login(@Query("email") String login, @Query("password") String password);


    @GET("/front")
    Call<List<Front>> getFronts();



}