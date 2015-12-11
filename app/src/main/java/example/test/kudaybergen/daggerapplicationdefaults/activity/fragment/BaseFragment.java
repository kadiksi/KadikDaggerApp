package example.test.kudaybergen.daggerapplicationdefaults.activity.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Kuanysh on 10/14/2015.
 */
public class BaseFragment extends Fragment {

    protected void log(String message) {
        Log.d(getClass().getSimpleName(), message);
    }

    protected void log(int resId) {
        Log.d(getClass().getSimpleName(), getString(resId));
    }

}
