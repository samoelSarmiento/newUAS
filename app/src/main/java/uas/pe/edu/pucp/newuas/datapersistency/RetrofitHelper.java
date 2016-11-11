package uas.pe.edu.pucp.newuas.datapersistency;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    private static RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory
            .createWithScheduler(Schedulers.io());


    public static String serverURL = Configuration.BASE_URL + "/"; //http://192.168.1.33/internetUAS/public/api/" //"http://52.89.227.55/api/";

    public static Retrofit apiConnector = new Retrofit.Builder()

            //.baseUrl("http://192.168.0.10/internetUAS/public/api/")

            .baseUrl(serverURL)

            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .client(new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(30, TimeUnit.SECONDS).build())
            .build();


}