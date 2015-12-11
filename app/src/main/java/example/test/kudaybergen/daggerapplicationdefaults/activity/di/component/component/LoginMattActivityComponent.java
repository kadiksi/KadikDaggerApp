package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component;

import dagger.Component;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.LoginActivityMatt;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.LoginActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.ActivityScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenter;

/**
 * Created by Kuanysh on 10/15/2015.
 */

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                LoginActivityModule.class
        }
)
public interface LoginMattActivityComponent extends AbstractActivityComponent {

    void inject(LoginActivityMatt loginActivity);
    LoginActivityPresenter loginActivityPresenter();

}