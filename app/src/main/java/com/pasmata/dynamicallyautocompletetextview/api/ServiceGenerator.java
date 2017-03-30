package com.pasmata.dynamicallyautocompletetextview.api;

/**
 * Created by jhon on 29/03/17.
 */

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jhon on 26/03/17.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://base_url.com";

    private static OkHttpClient.Builder httpClient;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, HeaderHelper header) {

        if(httpClient == null){
            httpClient = new OkHttpClient.Builder();
            if (header != null) {
                httpClient.addInterceptor(
                        new HeaderInterceptorHelper(header)
                );
            }
            httpClient.connectTimeout(50, TimeUnit.SECONDS);
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}