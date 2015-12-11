package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.api;

import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;

import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.City;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.DataResponse;
import retrofit.Call;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;


/**
 * Created by Kuanysh on 10/15/2015.
 */
public interface ApiService {

    @Multipart
    @POST("/App/GetLocalities")
    Call<ArrayList<City>> callForCities(@Part("str") RequestBody requestBody);

    @Multipart
    @POST("/AppTaxiBus/GetSearchResults")
    Call<DataResponse> callSendData(@Part("loc_from")RequestBody fromReq, @Part("loc_to")RequestBody toReq, @Part("dateStart")RequestBody startReq, @Part("dateEnd")RequestBody endReq);
}
