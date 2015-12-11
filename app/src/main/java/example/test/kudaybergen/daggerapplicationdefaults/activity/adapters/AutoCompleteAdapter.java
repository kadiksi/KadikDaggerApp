package example.test.kudaybergen.daggerapplicationdefaults.activity.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Kudaybergen on 05.12.2015.
 */
public class AutoCompleteAdapter extends ArrayAdapter {

    public AutoCompleteAdapter(Context context, int resource) {
        super(context, resource);
    }


    public AutoCompleteAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }
}
