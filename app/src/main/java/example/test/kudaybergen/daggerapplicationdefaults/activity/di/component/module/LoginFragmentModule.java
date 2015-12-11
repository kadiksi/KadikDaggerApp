package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module;

import dagger.Module;
import dagger.Provides;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.BaseActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.DataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.Preferences;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.FragmentScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.fragment.LoginFragment;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenterImpl;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.KeyboardAction;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.Navigator;

/**
 * Created by Kuanysh on 10/25/2015.
 */
@Module
public class LoginFragmentModule {

    private final LoginFragment fragment;

    public LoginFragmentModule(LoginFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    LoginFragment provideFragment() {
        return this.fragment;
    }

    @Provides
    @FragmentScope
    LoginPresenter provideOTPPresenter(BaseActivity baseActivity, LoginActivityPresenter presenterActivity, Navigator navigator,
                                       DataProvider dataProvider, KeyboardAction keyboardAction,
                                       Preferences preferences) {
        return new LoginPresenterImpl(baseActivity, presenterActivity, navigator, dataProvider,
                keyboardAction, preferences);
    }

}
