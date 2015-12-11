package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import example.test.kudaybergen.daggerapplicationdefaults.activity.BaseApplication;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.BaseActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.DataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.api.ApiService;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.Preferences;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ApplicationModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    BaseApplication application();
    Context context();
    OkHttpClient okHttpClient();
    ApiService apiService();
    DataProvider dataProvider();
    Preferences preferences();
    SharedPreferences sharedPreferences();
    Picasso picasso();

}
