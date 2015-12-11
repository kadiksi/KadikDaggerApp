package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component;

import dagger.Component;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.StartActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.ActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.StartActivityModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.ActivityScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.StartActivityPresenter;

/**
 * Created by Kuanysh on 10/15/2015.
 */

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                StartActivityModule.class
        }
)
public interface StartActivityComponent extends AbstractActivityComponent {

    void inject(StartActivity startActivity);
    StartActivityPresenter startActivityPresenter();
}