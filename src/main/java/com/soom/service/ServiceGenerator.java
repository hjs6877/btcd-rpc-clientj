package com.soom.service;

import com.soom.interceptor.AuthenticationInterceptor;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private String BASE_URL = "http://";
    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public <S> S generateService(Class<S> serviceClass, String host, int port) {
        return generateService(serviceClass, host, port, null, null);
    }

    public <S> S generateService(Class<S> serviceClass, String host, int port, String username, String password) {
        BASE_URL = BASE_URL.concat(host).concat(":").concat(String.valueOf(port));
        if (!StringUtils.isEmpty(username)
                && !StringUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return generateService(serviceClass, authToken);
        }

        return generateService(serviceClass, null);
    }

    public <S> S generateService(Class<S> serviceClass, final String authToken) {
        Retrofit retrofit = null;
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        if (!StringUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(serviceClass);
    }
}
