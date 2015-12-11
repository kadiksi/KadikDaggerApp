package example.test.kudaybergen.daggerapplicationdefaults.activity.presenter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import example.test.kudaybergen.daggerapplicationdefaults.R;
import example.test.kudaybergen.daggerapplicationdefaults.activity.activity.BaseActivity;
import example.test.kudaybergen.daggerapplicationdefaults.activity.adapters.AutoCompleteAdapter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.adapters.DataListAdapter;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.DataProvider;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.City;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.DataResponse;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences.Preferences;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.KeyboardAction;
import example.test.kudaybergen.daggerapplicationdefaults.activity.utils.Navigator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Kuanysh on 10/16/2015.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private static final String TAG = "LoginPresenterImpl";
    private View view;

    private AutoCompleteTextView from;
    private AutoCompleteTextView to;
    public TextView beginDate;
    public TextView endDate;
    public TextView send;
    ListView dataList;
    public boolean isBegin;
    public Long begin;
    public Long end;
    private City cityFrom;
    private City cityTo;

    private ArrayList<String> fromList = new ArrayList<>();
    private ArrayList<String> toList = new ArrayList<>();

    private AutoCompleteAdapter acFromAdapter;
    private AutoCompleteAdapter acToAdapter;

    private ArrayList<City> citiesFrom;
    private ArrayList<City> citiesTo;

    private LoginActivityPresenter presenterActivity;
    private Navigator navigator;
    private DataProvider dataProvider;
    private KeyboardAction keyboardAction;
    private BaseActivity baseActivity;
    private Preferences preferences;

    @Inject
    public LoginPresenterImpl(BaseActivity baseActivity, LoginActivityPresenter presenterActivity, Navigator navigator,
                              DataProvider dataProvider, KeyboardAction keyboardAction, Preferences preferences) {
        this.baseActivity = baseActivity;
        this.presenterActivity = presenterActivity;
        this.dataProvider = dataProvider;
        this.navigator = navigator;
        this.keyboardAction = keyboardAction;
        this.preferences = preferences;

    }

    @Override
    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("The view must not be null!");
        }
        this.view = view;
    }

    @Override
    public void setViews(AutoCompleteTextView from, AutoCompleteTextView to, TextView beginDate, TextView endDate, TextView send, ListView dataList) {
        this.from = from;
        this.to = to;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.send = send;
        this.dataList = dataList;
    }

    @Override
    public void initialize() {
        Log.d(TAG, "initialize");
        setDates(new Date(), new Date());
        setOnDateChooseListener();
        setTextListeners();
        acFromAdapter = new AutoCompleteAdapter(baseActivity, android.R.layout.simple_dropdown_item_1line,fromList);
        from.setAdapter(acFromAdapter);
        acToAdapter = new AutoCompleteAdapter(baseActivity, android.R.layout.simple_dropdown_item_1line,toList);
        to.setAdapter(acToAdapter);
        setOnItemClicks();
    }

    private void setOnItemClicks() {
        from.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Log.d(TAG, "select from city");
                cityFrom = citiesFrom.get(position);
            }
        });
        to.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Log.d(TAG, "select from city");
                cityTo = citiesTo.get(position);
            }
        });
    }

    private void setDates(Date date, Date date1) {
        SimpleDateFormat df2 = new SimpleDateFormat("d/M/yyyy");
        if (date != null) {
            String begin = df2.format(date);
            beginDate.setText(begin);
        }
        if (date1 != null) {
            String end = df2.format(date);
            endDate.setText(end);
        }
    }

    @Override
    public void sendData() {
        if(from.getText().toString().isEmpty() || to.getText().toString().isEmpty()){
            send.setText(baseActivity.getResources().getString(R.id.fill_data));
            send.setTextColor(R.color.red);
            return;
        }
        RequestBody fromReq = RequestBody.create(MediaType.parse("multipart/form-data"), cityFrom != null ? cityFrom.getId()+"":"");
        RequestBody toReq = RequestBody.create(MediaType.parse("multipart/form-data"), cityTo != null ? cityTo.getId()+"":"");
        RequestBody startReq= RequestBody.create(MediaType.parse("multipart/form-data"), begin != null ? new Date(begin)+"":"");
        RequestBody endReq = RequestBody.create(MediaType.parse("multipart/form-data"), end != null ? new Date(end)+"" : "");

        Call<DataResponse> call = dataProvider.callSendData(fromReq, toReq, startReq, endReq);
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Response<DataResponse> response, Retrofit retrofit) {
                Log.d(TAG, response.body().toString());
                setResponseData(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setResponseData(DataResponse body) {
        send.setTextColor(R.color.black);
        if(!body.getSuccess() && body.getResults().size() != 0){
            send.setText(baseActivity.getResources().getString(R.string.no_data));
        } else {
            DataListAdapter dataListAdapter = new DataListAdapter(baseActivity, body.getResults());
            dataList.setVisibility(android.view.View.VISIBLE);
            dataList.setAdapter(dataListAdapter);
        }
    }

    private void setTextListeners(){
        from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getCitiesArray(0, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        to.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getCitiesArray(1, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void getCitiesArray(final int type, String str) {
        RequestBody data = RequestBody.create(MediaType.parse("multipart/form-data"), str);
        Call<ArrayList<City>> call = dataProvider.callForCities(data);
        call.enqueue(new Callback<ArrayList<City>>() {
            @Override
            public void onResponse(Response<ArrayList<City>> response, Retrofit retrofit) {
                Log.d(TAG, response.body().toString());
                if(type == 0)
                    citiesFrom = response.body();
                else
                    citiesTo = response.body();
                addAdapters(type);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void addAdapters(int type) {
        if(type == 0){
            fromList.clear();
            acFromAdapter.clear();
            for (City c : citiesFrom){
                fromList.add(c.getRecordName());
            }
            acFromAdapter.addAll(fromList);
            acFromAdapter.notifyDataSetChanged();
        }
        if(type == 1){
            toList.clear();
            for (City c : citiesTo){
                toList.add(c.getRecordName());
            }
            acToAdapter.addAll(toList);
            acToAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void provide(android.view.View view) {

    }

    public interface View {

    }

    private void setOnDateChooseListener() {
        android.view.View.OnClickListener l = new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if(v.getId() == beginDate.getId())
                    isBegin = true;
                if(v.getId() == endDate.getId())
                    isBegin = false;
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.show(baseActivity.getSupportFragmentManager() , "datePicker");
            }
        };
        beginDate.setOnClickListener(l);
        endDate.setOnClickListener(l);
    }


    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        final Calendar c = Calendar.getInstance();
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            c.set(year, month, day);
            if(isBegin){
                begin = c.getTimeInMillis();
                beginDate.setText(day + "/" + month +"/" + year);
            } else {
                end = c.getTimeInMillis();
                endDate.setText(day + "/" + month + "/" + year);
            }
        }
    }

}
