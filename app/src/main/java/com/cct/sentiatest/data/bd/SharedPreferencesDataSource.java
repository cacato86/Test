package com.cct.sentiatest.data.bd;

import android.content.SharedPreferences;

import com.cct.sentiatest.domain.models.Property;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import io.reactivex.Single;

public class SharedPreferencesDataSource {

    private final String PROPERTIES = "PROPERTIES";

    private SharedPreferences preferences;
    private Gson gson;

    public SharedPreferencesDataSource(SharedPreferences preferences, Gson gson) {
        this.preferences = preferences;
        this.gson = gson;
    }

    public void savePropertiesList(List<Property> properties) {
        preferences.edit().putString(PROPERTIES, gson.toJson(properties)).apply();
    }

    public Single<List<Property>> getPropertiesList() {
        String propertiesListString = preferences.getString(PROPERTIES, "");
        return Single.just((List<Property>) gson.fromJson(propertiesListString, new TypeToken<List<Property>>() {
        }.getType()));
    }
}
