package com.clevertap.android.sdk.inapp;

public enum CTInAppType {
    CTInAppTypeHTML("html"),
    CTInAppTypeCoverHTML("coverHtml"),
    CTInAppTypeInterstitialHTML("interstitialHtml"),
    CTInAppTypeHeaderHTML("headerHtml"),
    CTInAppTypeFooterHTML("footerHtml"),
    CTInAppTypeHalfInterstitialHTML("halfInterstitialHtml"),
    CTInAppTypeCover("cover"),
    CTInAppTypeInterstitial("interstitial"),
    CTInAppTypeHalfInterstitial("half-interstitial"),
    CTInAppTypeHeader("header-template"),
    CTInAppTypeFooter("footer-template"),
    CTInAppTypeAlert("alert-template"),
    CTInAppTypeCoverImageOnly("cover-image"),
    CTInAppTypeInterstitialImageOnly("interstitial-image"),
    CTInAppTypeHalfInterstitialImageOnly("half-interstitial-image");
    
    public final String inAppType;

    /* access modifiers changed from: public */
    CTInAppType(String str) {
        this.inAppType = str;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.clevertap.android.sdk.inapp.CTInAppType fromString(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1698613420: goto L_0x00a0;
                case -1258935355: goto L_0x0095;
                case -1160074422: goto L_0x008b;
                case -1141304454: goto L_0x0080;
                case -728863497: goto L_0x0076;
                case -334055316: goto L_0x006b;
                case -37253685: goto L_0x0060;
                case 3213227: goto L_0x0056;
                case 94852023: goto L_0x004b;
                case 604727084: goto L_0x0041;
                case 894039686: goto L_0x0036;
                case 1189018554: goto L_0x002a;
                case 1420225510: goto L_0x001f;
                case 1977176024: goto L_0x0014;
                case 1979390978: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00ab
        L_0x0009:
            java.lang.String r0 = "coverHtml"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 1
            goto L_0x00ac
        L_0x0014:
            java.lang.String r0 = "headerHtml"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 3
            goto L_0x00ac
        L_0x001f:
            java.lang.String r0 = "footerHtml"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 4
            goto L_0x00ac
        L_0x002a:
            java.lang.String r0 = "header-template"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 9
            goto L_0x00ac
        L_0x0036:
            java.lang.String r0 = "half-interstitial"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 6
            goto L_0x00ac
        L_0x0041:
            java.lang.String r0 = "interstitial"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 7
            goto L_0x00ac
        L_0x004b:
            java.lang.String r0 = "cover"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 8
            goto L_0x00ac
        L_0x0056:
            java.lang.String r0 = "html"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 0
            goto L_0x00ac
        L_0x0060:
            java.lang.String r0 = "alert-template"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 11
            goto L_0x00ac
        L_0x006b:
            java.lang.String r0 = "footer-template"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 10
            goto L_0x00ac
        L_0x0076:
            java.lang.String r0 = "interstitialHtml"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 2
            goto L_0x00ac
        L_0x0080:
            java.lang.String r0 = "interstitial-image"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 13
            goto L_0x00ac
        L_0x008b:
            java.lang.String r0 = "halfInterstitialHtml"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 5
            goto L_0x00ac
        L_0x0095:
            java.lang.String r0 = "cover-image"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 12
            goto L_0x00ac
        L_0x00a0:
            java.lang.String r0 = "half-interstitial-image"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ab
            r1 = 14
            goto L_0x00ac
        L_0x00ab:
            r1 = -1
        L_0x00ac:
            switch(r1) {
                case 0: goto L_0x00db;
                case 1: goto L_0x00d8;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00cf;
                case 5: goto L_0x00cc;
                case 6: goto L_0x00c9;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00c3;
                case 9: goto L_0x00c0;
                case 10: goto L_0x00bd;
                case 11: goto L_0x00ba;
                case 12: goto L_0x00b7;
                case 13: goto L_0x00b4;
                case 14: goto L_0x00b1;
                default: goto L_0x00af;
            }
        L_0x00af:
            r1 = 0
            return r1
        L_0x00b1:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHalfInterstitialImageOnly
            return r1
        L_0x00b4:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeInterstitialImageOnly
            return r1
        L_0x00b7:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeCoverImageOnly
            return r1
        L_0x00ba:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeAlert
            return r1
        L_0x00bd:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeFooter
            return r1
        L_0x00c0:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHeader
            return r1
        L_0x00c3:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeCover
            return r1
        L_0x00c6:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeInterstitial
            return r1
        L_0x00c9:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHalfInterstitial
            return r1
        L_0x00cc:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHalfInterstitialHTML
            return r1
        L_0x00cf:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeFooterHTML
            return r1
        L_0x00d2:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHeaderHTML
            return r1
        L_0x00d5:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeInterstitialHTML
            return r1
        L_0x00d8:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeCoverHTML
            return r1
        L_0x00db:
            com.clevertap.android.sdk.inapp.CTInAppType r1 = CTInAppTypeHTML
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppType.fromString(java.lang.String):com.clevertap.android.sdk.inapp.CTInAppType");
    }

    public String toString() {
        return this.inAppType;
    }
}
