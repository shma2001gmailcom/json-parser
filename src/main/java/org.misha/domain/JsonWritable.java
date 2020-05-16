package org.misha.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonWritable {
    public static final Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    @Override
    public String toString() {
        return GSON.toJson(this).trim();
    }

}
