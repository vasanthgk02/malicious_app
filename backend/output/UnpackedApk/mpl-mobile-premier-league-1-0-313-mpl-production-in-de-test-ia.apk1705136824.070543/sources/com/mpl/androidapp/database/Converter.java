package com.mpl.androidapp.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class Converter {
    public static String listToString(List<String> list) {
        return new Gson().toJson((Object) list);
    }

    public static List<String> stringToList(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<String>>() {
        }.getType());
    }
}
