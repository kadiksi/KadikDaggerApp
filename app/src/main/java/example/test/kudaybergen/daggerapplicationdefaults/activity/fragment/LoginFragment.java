package example.test.kudaybergen.daggerapplicationdefaults.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.test.kudaybergen.daggerapplicationdefaults.R;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.LoginActivityMatt;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.DaggerLoginFragmentComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.component.LoginFragmentComponent;
import example.test.kudaybergen.daggerapplicationdefaults.activity.di.component.module.LoginFragmentModule;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginActivityPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.presenter.LoginPresenterImpl;

/**
 * Created by Kuanysh on 10/14/2015.
 */
public class LoginFragment extends BaseFragment implements LoginPresenterImpl.View {

    private static final String TAG = "LoginFragment";
    @Inject
    LoginPresenter presenter;
    @Inject
    LoginActivityPresenter presenterActivity;

    @Bind(R.id.from)
    AutoCompleteTextView from;

    @Bind(R.id.to)
    AutoCompleteTextView to;

    @Bind(R.id.begin_date)
    TextView beginDate;

    @Bind(R.id.end_date)
    TextView endDate;

    @Bind(R.id.text)
    TextView text;

    @Bind(R.id.send)
    Button send;

    @Bind(R.id.data_list)
    ListView dataList;
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    private LoginFragmentComponent component;

    public LoginFragmentComponent component() {
        if (component == null) {
            component = DaggerLoginFragmentComponent.builder()
                    .loginMattActivityComponent(((LoginActivityMatt) getActivity()).component())
                    .loginFragmentModule(new LoginFragmentModule(this))
                    .build();
        }
        return component;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        component().inject(this);
        presenter.setView(this);
        presenter.setViews(from, to, beginDate, endDate, text, dataList);
        presenter.initialize();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.send) void onSendClicked() {
        presenter.sendData();
    }

}
