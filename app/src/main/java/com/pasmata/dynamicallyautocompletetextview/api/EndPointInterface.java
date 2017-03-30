package com.pasmata.dynamicallyautocompletetextview.api;

import com.pasmata.dynamicallyautocompletetextview.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jhon on 29/03/17.
 */

public interface EndPointInterface {

    @GET("/management/user")
    Call<User> getUser(@Query("keyword") String keyword);

}
