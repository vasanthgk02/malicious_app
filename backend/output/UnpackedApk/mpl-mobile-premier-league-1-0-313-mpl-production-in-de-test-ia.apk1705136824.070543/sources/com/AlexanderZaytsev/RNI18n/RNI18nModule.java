package com.AlexanderZaytsev.RNI18n;

import android.os.Build.VERSION;
import android.os.LocaleList;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RNI18nModule extends ReactContextBaseJavaModule {
    public RNI18nModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private WritableArray getLocaleList() {
        WritableArray createArray = Arguments.createArray();
        if (VERSION.SDK_INT >= 24) {
            LocaleList locales = getReactApplicationContext().getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                createArray.pushString(toLanguageTag(locales.get(i)));
            }
        } else {
            createArray.pushString(toLanguageTag(getReactApplicationContext().getResources().getConfiguration().locale));
        }
        return createArray;
    }

    private String toLanguageTag(Locale locale) {
        String languageTag = locale.toLanguageTag();
        return languageTag.matches("^(iw|in|ji).*") ? languageTag.replace("iw", "he").replace("in", "id").replace("ji", "yi") : languageTag;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("languages", getLocaleList());
        return hashMap;
    }

    @ReactMethod
    public void getLanguages(Promise promise) {
        try {
            promise.resolve(getLocaleList());
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    public String getName() {
        return "RNI18n";
    }
}
