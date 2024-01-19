package com.mpl.analytics.profile;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public interface IMPLProfileEvent {
    void addMultiValueForKey(String str, String str2);

    void addMultiValueForKeyV2(String str, String str2);

    void addMultiValuesForKey(String str, ArrayList<String> arrayList);

    void addMultiValuesForKeyV2(String str, ArrayList<String> arrayList);

    Object getProperty(String str);

    Object getPropertyV2(String str);

    void push(HashMap<String, Object> hashMap);

    void pushFacebookUser(JSONObject jSONObject);

    void pushGooglePlusPerson(HashMap<String, Object> hashMap);

    void pushGooglePlusPersonV2(HashMap<String, Object> hashMap);

    void pushOnUserLoginEvent(HashMap<String, Object> hashMap);

    void pushProfileEvent(HashMap<String, Object> hashMap);

    void pushProfileEventV2(HashMap<String, Object> hashMap);

    void pushV2(HashMap<String, Object> hashMap);

    void removeMultiValueForKey(String str, String str2);

    void removeMultiValueForKeyV2(String str, String str2);

    void removeMultiValuesForKey(String str, ArrayList<String> arrayList);

    void removeMultiValuesForKeyV2(String str, ArrayList<String> arrayList);

    void removeValueForKey(String str);

    void removeValueForKeyV2(String str);
}
