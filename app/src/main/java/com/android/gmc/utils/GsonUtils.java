package com.android.gmc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import java.util.Date;

public class GsonUtils {
    public static Gson getDateCompatibleGson() {
        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class,
            (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(
                json.getAsJsonPrimitive().getAsLong()));

        builder.registerTypeAdapter(Date.class,
            (JsonSerializer<Date>) (src, typeOfSrc, context) -> new JsonPrimitive(src.getTime()));

        Gson gson = builder.create();
        return gson;
    }

    public static <T extends Object> T getObjectFromJson(String responseBody, Class<T> classType) {
        return getDateCompatibleGson().fromJson(responseBody, classType);
    }

    public static String getJsonString(Object object) {
        return getDateCompatibleGson().toJson(object).toString();
    }
}
