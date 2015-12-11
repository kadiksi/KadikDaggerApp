package example.test.kudaybergen.daggerapplicationdefaults.activity.activity;

import android.os.Bundle;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.R;
import example.test.kudaybergen.daggerapplicationdefaults.activity.BaseApplication;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.DaggerStartActivityComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.StartActivityComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.StartActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.StartActivityPresenterImpl;


/**
 * Created by Kuanysh on 10/14/2015.
 */
public class StartActivity extends BaseActivity implements StartActivityPresenterImpl.ViewAction {

    @Inject
    StartActivityPresenter presenter;

//    protected FragmentManager fragmentManager;

    private StartActivityComponent startMattActivityComponent;

    public StartActivityComponent component() {
        if (startMattActivityComponent == null) {
            startMattActivityComponent = DaggerStartActivityComponent.builder()
                    .applicationComponent(((BaseApplication) getApplication()).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return startMattActivityComponent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        component().inject(this);
        presenter.setViewAction(this);
        presenter.startRegistration();
        finish();
    }
}
