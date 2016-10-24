package uas.pe.edu.pucp.newuas.datapersistency;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;
import uas.pe.edu.pucp.newuas.configuration.Configuration;

/**
 * Created by samoe on 20/10/2016.
 */


public class RetrofitHelper {

    public static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    private static RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory
            .createWithScheduler(Schedulers.io());

    public static Retrofit apiConnector = new Retrofit.Builder()
            .baseUrl("http://192.168.43.229/internetUAS/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
            .build();
}