package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Kuanysh on 10/14/2015.
 */
public interface LoginPresenter extends Presenter {

    void setView(LoginPresenterImpl.View view);

    void setViews(AutoCompleteTextView from, AutoCompleteTextView to, TextView beginDate, TextView endDate, TextView send, ListView dataList);

    void sendData();
}
