package com.android.gmc.communications;

import com.android.gmc.BuildConfig;
import com.android.gmc.utils.Constants;
import com.android.gmc.utils.Logger;
import com.android.gmc.utils.SharedPreferenceHelper;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class AuthInterceptor implements Interceptor {
    SharedPreferenceHelper sharedPreferenceHelper;

    private final String TAG = "#AuthInterceptor#";

    @Override public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        sharedPreferenceHelper = SharedPreferenceHelper.getInstance();

        String authToken =
            sharedPreferenceHelper.getData(Constants.SHARED_PREFERENCES.AUTH_TOKEN, "");
        String source = sharedPreferenceHelper.getData(Constants.BUNDLE_KEYS.SOURCE,
            BuildConfig.APPLICATION_ID);
        // Add authorization header with updated authorization value to intercepted request
        Request authorisedRequest = originalRequest.newBuilder()
            .header(ApiConstants.REST_API.AUTH_HEADER_KEY, authToken)
            .header(ApiConstants.REST_API.TIMESTAMP, "" + System.currentTimeMillis())
            .header(ApiConstants.REST_API.SOURCE, source)
            .build();

        Logger.logError(TAG, "Sending request..." + authorisedRequest.toString());
        Logger.logError(TAG, "with token, source..." + authToken + ", " + source);
        return chain.proceed(authorisedRequest);
    }
}
