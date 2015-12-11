package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module;

import dagger.Module;
import dagger.Provides;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.ActivityScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.StartActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.StartActivityPresenterImpl;

/**
 * Created by Kuanysh on 10/15/2015.
 */
@Module
public class StartActivityModule {

    public StartActivityModule() {
    }

    @Provides @ActivityScope
    StartActivityPresenter provideStartActivityPresenter(StartActivityPresenterImpl presenter) {
        return presenter;
    }

//    @Provides @ActivityScope
//    LoginPresenter provideGamePresenter(LoginPresenterImpl presenter) {
//        return presenter;
//    }

}