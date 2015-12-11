package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kuanysh on 10/24/2015.
 */
public class RegistrationRequest {

    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("device_id")
    private String deviceId;
    @SerializedName("os_type")
    private final int OS_TYPE = 2;
    @SerializedName("otp")
    private String otp;
    @SerializedName("push_id")
    private String pushId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getOS_TYPE() {
        return OS_TYPE;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
