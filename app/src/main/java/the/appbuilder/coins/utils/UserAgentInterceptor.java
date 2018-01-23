package the.appbuilder.coins.utils;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import java.io.IOException;

public class UserAgentInterceptor implements Interceptor {

    private final String userAgent;

    public UserAgentInterceptor() {
        this.userAgent = System.getProperty("http.agent");
    }

    public UserAgentInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
            .header("User-Agent", userAgent)
            .build();
        return chain.proceed(requestWithUserAgent);
    }
}