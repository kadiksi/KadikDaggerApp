package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Kudaybergen on 11.12.2015.
 */
public class DataResponse {

    @SerializedName("Message")
    String message;
    @SerializedName("Success")
    Boolean success;
    @SerializedName("page")
    Integer page;
    @SerializedName("pages")
    Integer pages;
    @SerializedName("Results")
    ArrayList<Result> results;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}

