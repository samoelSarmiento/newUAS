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
    //http://10.101.2.15/internetUAS/public/api/
    //ip server= http://35.161.73.236/api/
    //.baseUrl("http://35.161.73.236/api/")
    //"http://10.100.185.201/internetUAS/public/api/


    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static Retrofit apiConnector = new Retrofit.Builder()
            .baseUrl("http://52.89.227.55/api/")
            // .baseUrl("http://10.100.184.48/internetUAS/public/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxAdapter)
            .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
            .build();





}