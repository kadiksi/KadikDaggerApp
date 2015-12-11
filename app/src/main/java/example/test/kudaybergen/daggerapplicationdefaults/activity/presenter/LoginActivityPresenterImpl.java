package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

import android.view.View;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.Navigator;

/**
 * Created by Kuanysh on 10/18/2015.
 */
public class LoginActivityPresenterImpl implements LoginActivityPresenter {

    private final Navigator navigator;
    private ViewAction viewAction;

    @Inject
    public LoginActivityPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setViewAction(ViewAction viewAction) {
        this.viewAction = viewAction;
    }

    @Override
    public void openRegistration() {
        viewAction.openRegistration();
    }

    @Override
    public void openPassword() {
        viewAction.openPassword();
    }

    @Override
    public void openOTP() {
        viewAction.openOTP();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void provide(View view) {

    }

    public interface ViewAction {
        void openOTP();
        void openRegistration();
        void openPassword();
    }

}
