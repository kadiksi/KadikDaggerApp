package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kudaybergen on 05.12.2015.
 */
public class City {

    @SerializedName("RecordID")
    Integer id;
    @SerializedName("RecordName")
    String recordName;
    @SerializedName("RecordExt")
    String recordExt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordExt() {
        return recordExt;
    }

    public void setRecordExt(String recordExt) {
        this.recordExt = recordExt;
    }
}
