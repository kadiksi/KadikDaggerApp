package example.test.kudaybergen.daggerapplicationdefaults.activity;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.DataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.ApplicationComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.DaggerApplicationComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ApplicationModule;

public class BaseApplication extends Application {

    private ApplicationComponent applicationComponent;
    private static Context context;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        BaseApplication.context = getApplicationContext();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public DataProvider getDataProvider(){
        return applicationComponent.dataProvider();
    }
}
