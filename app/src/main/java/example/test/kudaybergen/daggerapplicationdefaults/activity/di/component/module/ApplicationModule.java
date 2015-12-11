package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.test.kudaybergen.daggerapplicationdefaults.activity.BaseApplication;
import example.test.kudaybergen.daggerapplicationdefaults.activity.Settings;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.DataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.ShanyraqApiDataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.api.ApiService;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.Preferences;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.ShanyraqPreferences;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Kuanysh on 10/13/2015.
 */
@Module
public class ApplicationModule {

    private BaseApplication application;

    public ApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton BaseApplication provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application.getApplicationContext();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);
        return client;
    }

    @Provides
    @Singleton
    ApiService provideApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Settings.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    DataProvider provideDataProvider(ApiService apiService) {
        return new ShanyraqApiDataProvider(apiService);
    }

    @Provides
    @Singleton
    Preferences providePreferences(SharedPreferences sharedPreferences) {
        return new ShanyraqPreferences(sharedPreferences);
//        baseApplication.getAppContext().getSharedPreferences(Settings.PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(BaseApplication baseApplication){
        return baseApplication.getSharedPreferences(Settings.PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Picasso providePicasso(BaseApplication baseApplication) {
        Picasso mPicasso = Picasso.with(baseApplication);
        mPicasso.setIndicatorsEnabled(true);
        return mPicasso;
    }

}
