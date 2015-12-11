package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api;

import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;

import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.api.ApiService;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.City;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.DataResponse;
import retrofit.Call;

/**
 * Created by Kuanysh on 10/15/2015.
 */
public class ShanyraqApiDataProvider implements DataProvider {

    private final ApiService apiService;

    public ShanyraqApiDataProvider(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Call<ArrayList<City>> callForCities(RequestBody requestBody) {
        return apiService.callForCities(requestBody);
    }

    @Override
    public Call<DataResponse> callSendData(RequestBody fromReq, RequestBody toReq, RequestBody startReq, RequestBody endReq) {
        return apiService.callSendData(fromReq, toReq, startReq, endReq);
    }
}
