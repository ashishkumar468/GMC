package com.android.gmc.communications;

import com.android.gmc.utils.MiscUtils;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient implements INewsFeed, IVideosFeed, IUser {
    private Retrofit retrofit;
    private OkHttpClient.Builder httpClient;
    private static RestClient instance;

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    private RestClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(MiscUtils.isProduction() ? HttpLoggingInterceptor.Level.NONE
            : HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(ApiConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(ApiConstants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.addInterceptor(loggingInterceptor);
        httpClient.addNetworkInterceptor(new AuthInterceptor());
        retrofit = new Retrofit.Builder().baseUrl(ApiConstants.REST_API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build();
    }
}