package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences;

/**
 * Created by Kudaybergen on 28.10.2015.
 */
public interface Preferences {

    boolean saveData(String key, String value);
    boolean saveData(String key, int value);
    String getStringData(String key);
    int getIntegerData(String key);


    void removeAllData();
}
