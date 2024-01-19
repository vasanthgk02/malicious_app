package com.mpl.androidapp.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Locale;

public class LocaleHelper {
    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static final String TAG = "LocaleHelper";
    public static HashMap<String, String> sLanguageMapForHeader = null;
    public static String sSelectedLanguage = "en_IN";

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        sLanguageMapForHeader = hashMap;
        hashMap.put(HyperVergeKycCapture.EN, "en_IN");
        sLanguageMapForHeader.put(HyperVergeKycCapture.HI, "hi_IN");
        sLanguageMapForHeader.put(HyperVergeKycCapture.HN, "hn_IN");
        sLanguageMapForHeader.put("bn", "bn_IN");
        sLanguageMapForHeader.put(HyperVergeKycCapture.TA, "ta_IN");
        sLanguageMapForHeader.put("te", "te_IN");
        sLanguageMapForHeader.put(HyperVergeKycCapture.GU, "gu_IN");
        sLanguageMapForHeader.put(HyperVergeKycCapture.MR, "mr_IN");
        sLanguageMapForHeader.put("in", "in");
    }

    public static String changeLanguageCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return (split == null || split.length <= 1) ? str : split[0];
    }

    public static String getLanguage(Context context) {
        String persistedData = getPersistedData(context, Locale.getDefault().getLanguage());
        HashMap<String, String> hashMap = sLanguageMapForHeader;
        sSelectedLanguage = (hashMap == null || !hashMap.containsKey(persistedData)) ? sSelectedLanguage : sLanguageMapForHeader.get(persistedData);
        MLogger.d(TAG, "getLanguage: ", persistedData);
        return persistedData;
    }

    public static String getPersistedData(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SELECTED_LANGUAGE, str);
    }

    public static String getSelectedLanguage() {
        return sSelectedLanguage;
    }

    public static Context onAttach(Context context) {
        return setLocale(context, getPersistedData(context, Locale.getDefault().getLanguage()));
    }

    public static void persist(Context context, String str) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(SELECTED_LANGUAGE, str);
        edit.apply();
    }

    public static Context setLocale(Context context, String str) {
        String changeLanguageCode = changeLanguageCode(str);
        MLogger.d(TAG, "setLocale:2 ", "language", changeLanguageCode);
        HashMap<String, String> hashMap = sLanguageMapForHeader;
        sSelectedLanguage = (hashMap == null || !hashMap.containsKey(changeLanguageCode)) ? sSelectedLanguage : sLanguageMapForHeader.get(changeLanguageCode);
        persist(context, changeLanguageCode);
        if (VERSION.SDK_INT >= 24) {
            return updateResources(context, changeLanguageCode);
        }
        return updateResourcesLegacy(context, changeLanguageCode);
    }

    @TargetApi(24)
    public static Context updateResources(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public static Context updateResourcesLegacy(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    public static Context onAttach(Context context, String str) {
        String persistedData = getPersistedData(context, str);
        MLogger.d(TAG, "onAttach:defaultLanguage ", str);
        return setLocale(context, persistedData);
    }
}
