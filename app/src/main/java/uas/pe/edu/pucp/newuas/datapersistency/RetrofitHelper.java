package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;
import uas.pe.edu.pucp.newuas.configuration.Configuration;

/**
 * Created by samoe on 20/10/2016.
 */

public class RetrofitHelper {
    private static RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory
            .createWithScheduler(Schedulers.io());
    public static Retrofit apiConnector = new Retrofit.Builder()
            .baseUrl("http://10.101.40.151/internetUAS/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build();
}
