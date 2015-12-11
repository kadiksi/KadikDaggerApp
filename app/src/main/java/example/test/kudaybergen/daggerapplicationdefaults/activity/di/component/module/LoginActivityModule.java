package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module;

import dagger.Module;
import dagger.Provides;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.ActivityScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenterImpl;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenterImpl;

/**
 * Created by Kuanysh on 10/15/2015.
 */
@Module
public class LoginActivityModule {

    public LoginActivityModule() {
    }

    @Provides @ActivityScope
    LoginActivityPresenter provideLoginActivityPresenter(LoginActivityPresenterImpl presenter) {
        return presenter;
    }

    @Provides @ActivityScope
    LoginPresenter provideGamePresenter(LoginPresenterImpl presenter) {
        return presenter;
    }


}