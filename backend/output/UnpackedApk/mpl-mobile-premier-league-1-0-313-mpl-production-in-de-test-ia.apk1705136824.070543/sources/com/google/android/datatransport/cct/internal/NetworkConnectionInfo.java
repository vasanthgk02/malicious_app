package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

public abstract class NetworkConnectionInfo {

    public enum MobileSubtype {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        public static final SparseArray<MobileSubtype> valueMap = null;
        public final int value;

        /* access modifiers changed from: public */
        static {
            SparseArray<MobileSubtype> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, UNKNOWN_MOBILE_SUBTYPE);
            valueMap.put(1, GPRS);
            valueMap.put(2, EDGE);
            valueMap.put(3, UMTS);
            valueMap.put(4, CDMA);
            valueMap.put(5, EVDO_0);
            valueMap.put(6, EVDO_A);
            valueMap.put(7, RTT);
            valueMap.put(8, HSDPA);
            valueMap.put(9, HSUPA);
            valueMap.put(10, HSPA);
            valueMap.put(11, IDEN);
            valueMap.put(12, EVDO_B);
            valueMap.put(13, LTE);
            valueMap.put(14, EHRPD);
            valueMap.put(15, HSPAP);
            valueMap.put(16, GSM);
            valueMap.put(17, TD_SCDMA);
            valueMap.put(18, IWLAN);
            valueMap.put(19, LTE_CA);
        }

        /* access modifiers changed from: public */
        MobileSubtype(int i) {
            this.value = i;
        }

        public static MobileSubtype forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum NetworkType {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);
        
        public static final SparseArray<NetworkType> valueMap = null;
        public final int value;

        /* access modifiers changed from: public */
        static {
            SparseArray<NetworkType> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, MOBILE);
            valueMap.put(1, WIFI);
            valueMap.put(2, MOBILE_MMS);
            valueMap.put(3, MOBILE_SUPL);
            valueMap.put(4, MOBILE_DUN);
            valueMap.put(5, MOBILE_HIPRI);
            valueMap.put(6, WIMAX);
            valueMap.put(7, BLUETOOTH);
            valueMap.put(8, DUMMY);
            valueMap.put(9, ETHERNET);
            valueMap.put(10, MOBILE_FOTA);
            valueMap.put(11, MOBILE_IMS);
            valueMap.put(12, MOBILE_CBS);
            valueMap.put(13, WIFI_P2P);
            valueMap.put(14, MOBILE_IA);
            valueMap.put(15, MOBILE_EMERGENCY);
            valueMap.put(16, PROXY);
            valueMap.put(17, VPN);
            valueMap.put(-1, NONE);
        }

        /* access modifiers changed from: public */
        NetworkType(int i) {
            this.value = i;
        }

        public static NetworkType forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }
}
