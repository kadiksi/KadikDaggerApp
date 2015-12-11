package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

import android.view.View;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.Preferences;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.Navigator;


/**
 * Created by Kuanysh on 10/18/2015.
 */
public class StartActivityPresenterImpl implements StartActivityPresenter {

    private final Navigator navigator;
    private ViewAction viewAction;
    private Preferences preferences;

    @Inject
    public StartActivityPresenterImpl(Navigator navigator, Preferences preferences) {
        this.navigator = navigator;
        this.preferences = preferences;
    }

    @Override
    public boolean hasAccount() {
//        return !(preferences.getStringData(User.TOKEN) == null);
        return true;
    }

    public void setViewAction(ViewAction viewAction) {
        this.viewAction = viewAction;
    }

    @Override
    public void startRegistration() {
        navigator.startLoginActivity();
    }

//    @Override
//    public void startLogin() {
//        navigator.startLoginActivity();
//    }
//
//    @Override
//    public void startMainActivity() {
//        navigator.startMainActivity();
//    }

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
    }

}
