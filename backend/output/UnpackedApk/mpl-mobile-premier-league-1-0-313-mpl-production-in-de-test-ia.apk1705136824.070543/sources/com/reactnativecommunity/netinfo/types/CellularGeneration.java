package com.reactnativecommunity.netinfo.types;

import android.net.NetworkInfo;

public enum CellularGeneration {
    CG_2G("2g"),
    CG_3G("3g"),
    CG_4G("4g");
    
    public final String label;

    /* access modifiers changed from: public */
    CellularGeneration(String str) {
        this.label = str;
    }

    public static CellularGeneration fromNetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return CG_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
                return CG_3G;
            case 13:
            case 15:
                return CG_4G;
            default:
                return null;
        }
    }
}
