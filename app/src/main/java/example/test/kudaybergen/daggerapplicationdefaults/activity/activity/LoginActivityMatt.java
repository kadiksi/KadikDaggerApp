package example.test.kudaybergen.daggerapplicationdefaults.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.R;
import example.test.kudaybergen.daggerapplicationdefaults.activity.BaseApplication;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.DaggerLoginMattActivityComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.LoginMattActivityComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.fragment.LoginFragment;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenterImpl;


/**
 * Created by Kuanysh on 10/14/2015.
 */
public class LoginActivityMatt extends BaseActivity implements LoginActivityPresenterImpl.ViewAction {

    @Inject
    LoginActivityPresenter presenter;

//    protected FragmentManager fragmentManager;

    private LoginMattActivityComponent loginMattActivityComponent;

    public LoginMattActivityComponent component() {
        if (loginMattActivityComponent == null) {
            loginMattActivityComponent = DaggerLoginMattActivityComponent.builder()
                    .applicationComponent(((BaseApplication) getApplication()).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return loginMattActivityComponent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        component().inject(this);
        presenter.setViewAction(this);
        fragmentManager = getSupportFragmentManager();

        if ( savedInstanceState == null ) {
            goToLoginFragment();
        }

    }

    private void goToLoginFragment() {
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoginFragment.newInstance()).addToBackStack(null)
                .commit();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivityMatt.class);
        context.startActivity(intent);
    }

    @Override
    public void openOTP() {
//        goToOTPFragment();
    }

    @Override
    public void openRegistration() {
//        goToPhoneNumberFragment();
    }

    @Override
    public void openPassword() {
//        goToPasswordFragment();
    }

}
