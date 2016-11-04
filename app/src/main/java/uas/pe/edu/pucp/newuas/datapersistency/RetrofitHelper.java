package uas.pe.edu.pucp.newuas.datapersistency;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
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
            .baseUrl("http://10.101.0.209/internetUAS/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
            .build();


}