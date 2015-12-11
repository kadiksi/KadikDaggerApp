package example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module;

import dagger.Module;
import dagger.Provides;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.BaseActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.scope.ActivityScope;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.KeyboardAction;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.Navigator;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.NavigatorImpl;

/**
 * Created by Kuanysh on 10/13/2015.
 */
@Module
public class ActivityModule {

    private final BaseActivity activityContext;

    public ActivityModule(BaseActivity activityContext) {
        this.activityContext = activityContext;
    }

    @Provides @ActivityScope
    BaseActivity getActivityContext() {
        return this.activityContext;
    }

    @Provides @ActivityScope
    Navigator provideNavigator(NavigatorImpl navigator) {
        return navigator;
    }

    @Provides @ActivityScope
    KeyboardAction provideKeyboardAction() {
        return activityContext;
    }

}
