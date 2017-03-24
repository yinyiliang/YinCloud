package yyl.yincloud.http;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yyl.yincloud.converter.JsonConverterFactory;

/**
 * Created by yyl on 16/11/9.
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    private static final String BASE_URL = "https://api-m.mtime.cn/";
    private static final String TICKET_URL = "https://ticket-api-m.mtime.cn/movie/";

    private RetrofitServiceManager(String baseUrl){
        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(setUpOkHttpClient())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                .build();
    }

    private OkHttpClient setUpOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitServiceManager.class) {
                if (mOkHttpClient == null) {

                    mOkHttpClient = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)
                            .addInterceptor(mLoggingInterceptor)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    private static class SingletonHolder{
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager(
                BASE_URL);

        private static final RetrofitServiceManager INSTANCE_TICKET = new RetrofitServiceManager(
                TICKET_URL);
    }

    /**
     * 获取RetrofitServiceManager
     * @return
     */
    public static RetrofitServiceManager getInstance(String type){
        switch (type){
            case "ticket":
                return SingletonHolder.INSTANCE_TICKET;
            default:
                return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }

        // 打印返回的json数据拦截器
    private Interceptor mLoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            final Request request = chain.request();
            final Response response = chain.proceed(request);

            final ResponseBody responseBody = response.body();
            final long contentLength = responseBody.contentLength();

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(charset);
                } catch (UnsupportedCharsetException e) {
                    Logger.e("");
                    Logger.e("Couldn't decode the response body; charset is likely malformed.");
                    return response;
                }
            }

            if (contentLength != 0) {
                Logger.v("--------------------------------------------开始打印返回数据----------------------------------------------------");
                Logger.d(request.url());
                Logger.json(buffer.clone().readString(charset));
                Logger.v("--------------------------------------------结束打印返回数据----------------------------------------------------");
            }

            return response;
        }
    };
}
