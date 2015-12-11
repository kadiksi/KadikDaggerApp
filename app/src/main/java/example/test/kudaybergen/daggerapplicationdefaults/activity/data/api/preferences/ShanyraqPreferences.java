package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.preferences;

import android.content.SharedPreferences;

/**
 * Created by Kudaybergen on 28.10.2015.
 */
public class ShanyraqPreferences implements Preferences {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public ShanyraqPreferences(SharedPreferences sharedPreferences) {
        preferences = sharedPreferences;
        editor = preferences.edit();
    }

    @Override
    public boolean saveData(String key, String value) {
        editor.putString(key, value);
        return editor.commit();
    }

    @Override
    public boolean saveData(String key, int value) {
        editor.putInt(key, value);
        return editor.commit();
    }

    @Override
    public String getStringData(String key) {
        return preferences.getString(key, null);
    }

    @Override
    public int getIntegerData(String key) {
        return preferences.getInt(key, 0);
    }

    @Override
    public void removeAllData() {
        editor.clear();
        editor.commit();
    }
}
