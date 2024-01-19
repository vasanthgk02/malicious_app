package com.firebase.jobdispatcher;

public final class GooglePlayCallbackExtractor {
    public static Boolean shouldReadKeysAsStringsCached;

    public static void checkCondition(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        shouldReadKeysAsStringsCached = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r2.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readKey(android.os.Parcel r6) {
        /*
            java.lang.Class<com.firebase.jobdispatcher.GooglePlayCallbackExtractor> r0 = com.firebase.jobdispatcher.GooglePlayCallbackExtractor.class
            monitor-enter(r0)
            java.lang.Boolean r1 = shouldReadKeysAsStringsCached     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0063
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x007e }
            r1.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "key"
            java.lang.String r3 = "value"
            r1.putString(r2, r3)     // Catch:{ all -> 0x007e }
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ all -> 0x007e }
            r3 = 0
            r1.writeToParcel(r2, r3)     // Catch:{ all -> 0x007e }
            r2.setDataPosition(r3)     // Catch:{ all -> 0x007e }
            int r1 = r2.readInt()     // Catch:{ RuntimeException -> 0x0057 }
            r4 = 1
            if (r1 <= 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            checkCondition(r1)     // Catch:{ RuntimeException -> 0x0057 }
            int r1 = r2.readInt()     // Catch:{ RuntimeException -> 0x0057 }
            r5 = 1279544898(0x4c444e42, float:5.146036E7)
            if (r1 != r5) goto L_0x0036
            r1 = 1
            goto L_0x0037
        L_0x0036:
            r1 = 0
        L_0x0037:
            checkCondition(r1)     // Catch:{ RuntimeException -> 0x0057 }
            int r1 = r2.readInt()     // Catch:{ RuntimeException -> 0x0057 }
            if (r1 != r4) goto L_0x0041
            r3 = 1
        L_0x0041:
            checkCondition(r3)     // Catch:{ RuntimeException -> 0x0057 }
            java.lang.String r1 = "key"
            java.lang.String r3 = r2.readString()     // Catch:{ RuntimeException -> 0x0057 }
            boolean r1 = r1.equals(r3)     // Catch:{ RuntimeException -> 0x0057 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ RuntimeException -> 0x0057 }
            shouldReadKeysAsStringsCached = r1     // Catch:{ RuntimeException -> 0x0057 }
            goto L_0x005b
        L_0x0055:
            r6 = move-exception
            goto L_0x005f
        L_0x0057:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0055 }
            shouldReadKeysAsStringsCached = r1     // Catch:{ all -> 0x0055 }
        L_0x005b:
            r2.recycle()     // Catch:{ all -> 0x007e }
            goto L_0x0063
        L_0x005f:
            r2.recycle()     // Catch:{ all -> 0x007e }
            throw r6     // Catch:{ all -> 0x007e }
        L_0x0063:
            java.lang.Boolean r1 = shouldReadKeysAsStringsCached     // Catch:{ all -> 0x007e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x007e }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0071
            java.lang.String r6 = r6.readString()
            return r6
        L_0x0071:
            r0 = 0
            java.lang.Object r6 = r6.readValue(r0)
            boolean r1 = r6 instanceof java.lang.String
            if (r1 != 0) goto L_0x007b
            return r0
        L_0x007b:
            java.lang.String r6 = (java.lang.String) r6
            return r6
        L_0x007e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayCallbackExtractor.readKey(android.os.Parcel):java.lang.String");
    }
}
