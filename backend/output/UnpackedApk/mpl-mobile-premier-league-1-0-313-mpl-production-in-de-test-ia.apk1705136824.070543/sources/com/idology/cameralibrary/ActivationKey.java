package com.idology.cameralibrary;

import java.util.HashMap;
import java.util.Map;

public class ActivationKey {
    public static ActivationKey DEFAULT;
    public Map<Feature, Boolean> featureStates = new HashMap();

    public enum Feature {
        Logo,
        CanEnableSelfie,
        SelfieAndLivelinessEnabled
    }

    static {
        ActivationKey activationKey = new ActivationKey(false);
        DEFAULT = activationKey;
        activationKey.featureStates.put(Feature.Logo, Boolean.TRUE);
        DEFAULT.featureStates.put(Feature.CanEnableSelfie, Boolean.FALSE);
        DEFAULT.featureStates.put(Feature.SelfieAndLivelinessEnabled, Boolean.FALSE);
    }

    public ActivationKey(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseFeatureValue(com.idology.cameralibrary.ActivationKey r3, com.idology.cameralibrary.ActivationKey.Feature r4, java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 2529(0x9e1, float:3.544E-42)
            if (r0 == r2) goto L_0x0019
            r2 = 88775(0x15ac7, float:1.244E-40)
            if (r0 == r2) goto L_0x000f
            goto L_0x0023
        L_0x000f:
            java.lang.String r0 = "Yes"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0023
            r0 = 0
            goto L_0x0024
        L_0x0019:
            java.lang.String r0 = "No"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = -1
        L_0x0024:
            if (r0 == 0) goto L_0x004f
            if (r0 != r1) goto L_0x0030
            java.util.Map<com.idology.cameralibrary.ActivationKey$Feature, java.lang.Boolean> r3 = r3.featureStates
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r3.put(r4, r5)
            goto L_0x0056
        L_0x0030:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid value: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = " for feature: "
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x004f:
            java.util.Map<com.idology.cameralibrary.ActivationKey$Feature, java.lang.Boolean> r3 = r3.featureStates
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r3.put(r4, r5)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idology.cameralibrary.ActivationKey.parseFeatureValue(com.idology.cameralibrary.ActivationKey, com.idology.cameralibrary.ActivationKey$Feature, java.lang.String):void");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.idology.cameralibrary.ActivationKey validateActivationKey(com.idology.cameralibrary.IActivationKeyProvider r11, com.idology.cameralibrary.IPublicKeyProvider r12) throws java.io.IOException, org.spongycastle.openpgp.PGPException, java.text.ParseException {
        /*
            java.lang.String r0 = "UTF-8"
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0139 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0139 }
            java.io.InputStream r11 = r11.getActivationKeyInputStream()     // Catch:{ Exception -> 0x0139 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0139 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0139 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r11.<init>()     // Catch:{ Exception -> 0x0139 }
        L_0x0015:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = "\n"
            if (r2 == 0) goto L_0x0024
            r11.append(r2)     // Catch:{ Exception -> 0x0139 }
            r11.append(r3)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0015
        L_0x0024:
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r1 = "Enterprise:"
            int r1 = r11.indexOf(r1)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = "-----BEGIN PGP SIGNATURE-----"
            int r4 = r11.indexOf(r4)     // Catch:{ Exception -> 0x0139 }
            int r5 = r4 + -1
            java.lang.String r1 = r11.substring(r1, r5)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r11 = r11.substring(r4)     // Catch:{ Exception -> 0x0139 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0139 }
            byte[] r5 = r1.getBytes(r0)     // Catch:{ Exception -> 0x0139 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0139 }
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0139 }
            byte[] r11 = r11.getBytes(r0)     // Catch:{ Exception -> 0x0139 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x0139 }
            com.idology2.crypto.GPGCryptor r11 = new com.idology2.crypto.GPGCryptor     // Catch:{ Exception -> 0x0139 }
            r11.<init>()     // Catch:{ Exception -> 0x0139 }
            java.io.InputStream r12 = r12.getPublicKeyInputStream()     // Catch:{ Exception -> 0x0139 }
            com.idology2.crypto.GPGCryptor r0 = new com.idology2.crypto.GPGCryptor     // Catch:{ all -> 0x012d }
            r0.<init>()     // Catch:{ all -> 0x012d }
            org.spongycastle.openpgp.PGPPublicKey r0 = r0.getPublicKey(r12)     // Catch:{ all -> 0x012d }
            if (r12 == 0) goto L_0x006c
            r12.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r12 = move-exception
            r12.getMessage()     // Catch:{ Exception -> 0x0139 }
        L_0x006c:
            boolean r11 = r11.verify(r4, r5, r0)     // Catch:{ Exception -> 0x0139 }
            if (r11 != 0) goto L_0x0075
            com.idology.cameralibrary.ActivationKey r11 = DEFAULT     // Catch:{ Exception -> 0x0139 }
            return r11
        L_0x0075:
            com.idology.cameralibrary.ActivationKey r11 = new com.idology.cameralibrary.ActivationKey     // Catch:{ Exception -> 0x0139 }
            r12 = 1
            r11.<init>(r12)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0139 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0139 }
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ Exception -> 0x0139 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0139 }
            r3 = 0
            r4 = 0
        L_0x0087:
            if (r4 >= r1) goto L_0x012c
            r5 = r0[r4]     // Catch:{ Exception -> 0x0139 }
            java.lang.String r6 = ":"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ Exception -> 0x0139 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0139 }
            r7 = 2
            if (r6 != r7) goto L_0x0115
            r6 = r5[r3]     // Catch:{ Exception -> 0x0139 }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x0139 }
            r5 = r5[r12]     // Catch:{ Exception -> 0x0139 }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0139 }
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x0139 }
            r9 = 3
            r10 = 4
            switch(r8) {
                case -1408829899: goto L_0x00d3;
                case 2374091: goto L_0x00c9;
                case 16616944: goto L_0x00bf;
                case 1190727553: goto L_0x00b5;
                case 2016261304: goto L_0x00ab;
                default: goto L_0x00aa;
            }     // Catch:{ Exception -> 0x0139 }
        L_0x00aa:
            goto L_0x00dd
        L_0x00ab:
            java.lang.String r8 = "Version"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00dd
            r8 = 4
            goto L_0x00de
        L_0x00b5:
            java.lang.String r8 = "Enterprise"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00dd
            r8 = 3
            goto L_0x00de
        L_0x00bf:
            java.lang.String r8 = "SelfieandLiveliness Enabled"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00dd
            r8 = 2
            goto L_0x00de
        L_0x00c9:
            java.lang.String r8 = "Logo"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00dd
            r8 = 0
            goto L_0x00de
        L_0x00d3:
            java.lang.String r8 = "Can Enable Selfie"
            boolean r8 = r6.equals(r8)     // Catch:{ Exception -> 0x0139 }
            if (r8 == 0) goto L_0x00dd
            r8 = 1
            goto L_0x00de
        L_0x00dd:
            r8 = -1
        L_0x00de:
            if (r8 == 0) goto L_0x010c
            if (r8 == r12) goto L_0x0106
            if (r8 == r7) goto L_0x0100
            if (r8 == r9) goto L_0x0111
            if (r8 != r10) goto L_0x00e9
            goto L_0x0111
        L_0x00e9:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0139 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r12.<init>()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = "Invalid activation key property name: "
            r12.append(r0)     // Catch:{ Exception -> 0x0139 }
            r12.append(r6)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0139 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0139 }
            throw r11     // Catch:{ Exception -> 0x0139 }
        L_0x0100:
            com.idology.cameralibrary.ActivationKey$Feature r6 = com.idology.cameralibrary.ActivationKey.Feature.SelfieAndLivelinessEnabled     // Catch:{ Exception -> 0x0139 }
            parseFeatureValue(r11, r6, r5)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0111
        L_0x0106:
            com.idology.cameralibrary.ActivationKey$Feature r6 = com.idology.cameralibrary.ActivationKey.Feature.CanEnableSelfie     // Catch:{ Exception -> 0x0139 }
            parseFeatureValue(r11, r6, r5)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0111
        L_0x010c:
            com.idology.cameralibrary.ActivationKey$Feature r6 = com.idology.cameralibrary.ActivationKey.Feature.Logo     // Catch:{ Exception -> 0x0139 }
            parseFeatureValue(r11, r6, r5)     // Catch:{ Exception -> 0x0139 }
        L_0x0111:
            int r4 = r4 + 1
            goto L_0x0087
        L_0x0115:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0139 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r12.<init>()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = "Invalid number of fields in activation key at line: "
            r12.append(r0)     // Catch:{ Exception -> 0x0139 }
            r12.append(r2)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0139 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0139 }
            throw r11     // Catch:{ Exception -> 0x0139 }
        L_0x012c:
            return r11
        L_0x012d:
            r11 = move-exception
            if (r12 == 0) goto L_0x0138
            r12.close()     // Catch:{ IOException -> 0x0134 }
            goto L_0x0138
        L_0x0134:
            r12 = move-exception
            r12.getMessage()     // Catch:{ Exception -> 0x0139 }
        L_0x0138:
            throw r11     // Catch:{ Exception -> 0x0139 }
        L_0x0139:
            com.idology.cameralibrary.ActivationKey r11 = DEFAULT
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idology.cameralibrary.ActivationKey.validateActivationKey(com.idology.cameralibrary.IActivationKeyProvider, com.idology.cameralibrary.IPublicKeyProvider):com.idology.cameralibrary.ActivationKey");
    }

    public boolean isEnabled(Feature feature) {
        return this.featureStates.containsKey(feature) && this.featureStates.get(feature).booleanValue();
    }
}
