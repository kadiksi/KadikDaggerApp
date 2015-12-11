package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api;

import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;

import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.City;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.DataResponse;
import retrofit.Call;

/**
 * Created by Kuanysh on 10/14/2015.
 */
public interface DataProvider {

    Call<ArrayList<City>> callForCities(RequestBody requestBody);

    Call<DataResponse> callSendData(RequestBody fromReq, RequestBody toReq, RequestBody startReq, RequestBody endReq);
}
