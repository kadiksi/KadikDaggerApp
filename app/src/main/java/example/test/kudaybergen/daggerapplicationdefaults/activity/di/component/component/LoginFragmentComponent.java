package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component;

import dagger.Component;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.LoginFragmentModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.FragmentScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.fragment.LoginFragment;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenter;

/**
 * Created by Kuanysh on 10/25/2015.
 */
@FragmentScope
@Component(
        dependencies = LoginMattActivityComponent.class,
        modules = {
                LoginFragmentModule.class
        }
)
public interface LoginFragmentComponent {
    void inject(LoginFragment loginFragment);
    LoginPresenter loginPresenter();
}
