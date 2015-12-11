package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

/**
 * Created by Kuanysh on 10/18/2015.
 */
public interface StartActivityPresenter extends Presenter {

    boolean hasAccount();
    void setViewAction(StartActivityPresenterImpl.ViewAction viewAction);

    void startRegistration();
}
