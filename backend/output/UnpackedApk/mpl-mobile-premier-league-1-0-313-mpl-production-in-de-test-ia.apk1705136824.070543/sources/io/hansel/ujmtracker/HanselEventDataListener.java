package io.hansel.ujmtracker;

import java.util.HashMap;

public interface HanselEventDataListener {
    void onEvent(String str, String str2, HashMap<String, Object> hashMap);
}
