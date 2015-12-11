package example.test.kudaybergen.daggerapplicationdefaults.activity.utils;

import android.content.Intent;
import android.util.Log;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.BaseActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.LoginActivityMatt;


/**
 * Created by Kuanysh on 10/17/2015.
 */
public class NavigatorImpl implements Navigator {

    private static final String TAG = "NavigatorImpl";

    private BaseActivity activity;

    @Inject
    NavigatorImpl(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void startLoginActivity() {
        Log.d(TAG, "startLogin");
        Intent intent = new Intent(activity, LoginActivityMatt.class);
        activity.startActivity(intent);
    }
}
