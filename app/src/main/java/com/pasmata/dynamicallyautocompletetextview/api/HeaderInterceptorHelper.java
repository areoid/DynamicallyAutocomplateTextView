package com.pasmata.dynamicallyautocompletetextview.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jhon on 29/03/17.
 */

public final class HeaderInterceptorHelper implements Interceptor {
    private final HeaderHelper header;

    public HeaderInterceptorHelper(HeaderHelper headerHlp) {
        this.header = headerHlp;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request original = chain.request();
        Response response;
        if (this.header.getHeaderValue() != null) {
            final Request.Builder request = original.newBuilder();
            request.header(this.header.getHeaderName(), this.header.getHeaderValue());
            response = chain.proceed(request.build());
        } else {
            response = chain.proceed(original);
        }

        return response;
    }

}
