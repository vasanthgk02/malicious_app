package com.cauly.android.ad;

public class AdInfo {
    static String adtype;
    static String age;
    static String allowcall;
    static String appcode;
    static boolean dynamicReloadInterval;
    static String effect;
    static String gender;
    static String gps;
    static int priority = 5;
    static int reloadInterval;

    public void initData(String appcode2, String adtype2, String gender2, String age2, String gps2, String effect2, String allowcall2, int reloadInterval2, Boolean dynamicReloadInterval2) {
        appcode = appcode2;
        adtype = adtype2;
        gender = gender2;
        age = age2;
        gps = gps2;
        effect = effect2;
        allowcall = allowcall2;
        reloadInterval = reloadInterval2;
        dynamicReloadInterval = dynamicReloadInterval2.booleanValue();
    }

    public void setPriority(int priority2) {
        int i = 1;
        if (priority2 >= 1) {
            i = priority2;
        }
        priority = i;
        if (priority2 > 10) {
            priority2 = 10;
        }
        priority = priority2;
    }
}
