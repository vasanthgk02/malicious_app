package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    public final String applicationBuild;
    public final String country;
    public final String device;
    public final String fingerprint;
    public final String hardware;
    public final String locale;
    public final String manufacturer;
    public final String mccMnc;
    public final String model;
    public final String osBuild;
    public final String product;
    public final Integer sdkVersion;

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AnonymousClass1 r13) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.sdkVersion;
        if (num != null ? num.equals(((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion) : ((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion == null) {
            String str = this.model;
            if (str != null ? str.equals(((AutoValue_AndroidClientInfo) androidClientInfo).model) : ((AutoValue_AndroidClientInfo) androidClientInfo).model == null) {
                String str2 = this.hardware;
                if (str2 != null ? str2.equals(((AutoValue_AndroidClientInfo) androidClientInfo).hardware) : ((AutoValue_AndroidClientInfo) androidClientInfo).hardware == null) {
                    String str3 = this.device;
                    if (str3 != null ? str3.equals(((AutoValue_AndroidClientInfo) androidClientInfo).device) : ((AutoValue_AndroidClientInfo) androidClientInfo).device == null) {
                        String str4 = this.product;
                        if (str4 != null ? str4.equals(((AutoValue_AndroidClientInfo) androidClientInfo).product) : ((AutoValue_AndroidClientInfo) androidClientInfo).product == null) {
                            String str5 = this.osBuild;
                            if (str5 != null ? str5.equals(((AutoValue_AndroidClientInfo) androidClientInfo).osBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).osBuild == null) {
                                String str6 = this.manufacturer;
                                if (str6 != null ? str6.equals(((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer) : ((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer == null) {
                                    String str7 = this.fingerprint;
                                    if (str7 != null ? str7.equals(((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint) : ((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint == null) {
                                        String str8 = this.locale;
                                        if (str8 != null ? str8.equals(((AutoValue_AndroidClientInfo) androidClientInfo).locale) : ((AutoValue_AndroidClientInfo) androidClientInfo).locale == null) {
                                            String str9 = this.country;
                                            if (str9 != null ? str9.equals(((AutoValue_AndroidClientInfo) androidClientInfo).country) : ((AutoValue_AndroidClientInfo) androidClientInfo).country == null) {
                                                String str10 = this.mccMnc;
                                                if (str10 != null ? str10.equals(((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc) : ((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc == null) {
                                                    String str11 = this.applicationBuild;
                                                    if (str11 != null) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        Integer num = this.sdkVersion;
        int i = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.model;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.hardware;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.device;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.product;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.osBuild;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.manufacturer;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.fingerprint;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.locale;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.country;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.mccMnc;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode11 ^ i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AndroidClientInfo{sdkVersion=");
        outline73.append(this.sdkVersion);
        outline73.append(", model=");
        outline73.append(this.model);
        outline73.append(", hardware=");
        outline73.append(this.hardware);
        outline73.append(", device=");
        outline73.append(this.device);
        outline73.append(", product=");
        outline73.append(this.product);
        outline73.append(", osBuild=");
        outline73.append(this.osBuild);
        outline73.append(", manufacturer=");
        outline73.append(this.manufacturer);
        outline73.append(", fingerprint=");
        outline73.append(this.fingerprint);
        outline73.append(", locale=");
        outline73.append(this.locale);
        outline73.append(", country=");
        outline73.append(this.country);
        outline73.append(", mccMnc=");
        outline73.append(this.mccMnc);
        outline73.append(", applicationBuild=");
        return GeneratedOutlineSupport.outline62(outline73, this.applicationBuild, "}");
    }
}
