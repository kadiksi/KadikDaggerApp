package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

/**
 * Created by Kuanysh on 10/18/2015.
 */
public interface LoginActivityPresenter extends Presenter {

    void openOTP();
    void openRegistration();
    void openPassword();
    void setViewAction(LoginActivityPresenterImpl.ViewAction viewAction);
}
