package com.clevertap.android.sdk.validation;

import java.util.ArrayList;

public class ValidationResultStack {
    public static final Object pendingValidationResultsLock = new Object();
    public ArrayList<ValidationResult> pendingValidationResults = new ArrayList<>();

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.clevertap.android.sdk.validation.ValidationResult popValidationResult() {
        /*
            r4 = this;
            java.lang.Object r0 = pendingValidationResultsLock
            monitor-enter(r0)
            r1 = 0
            java.util.ArrayList<com.clevertap.android.sdk.validation.ValidationResult> r2 = r4.pendingValidationResults     // Catch:{ Exception -> 0x0019 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0019 }
            if (r2 != 0) goto L_0x0019
            java.util.ArrayList<com.clevertap.android.sdk.validation.ValidationResult> r2 = r4.pendingValidationResults     // Catch:{ Exception -> 0x0019 }
            r3 = 0
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ Exception -> 0x0019 }
            com.clevertap.android.sdk.validation.ValidationResult r2 = (com.clevertap.android.sdk.validation.ValidationResult) r2     // Catch:{ Exception -> 0x0019 }
            r1 = r2
            goto L_0x0019
        L_0x0017:
            r1 = move-exception
            goto L_0x001b
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.validation.ValidationResultStack.popValidationResult():com.clevertap.android.sdk.validation.ValidationResult");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushValidationResult(com.clevertap.android.sdk.validation.ValidationResult r6) {
        /*
            r5 = this;
            java.lang.Object r0 = pendingValidationResultsLock
            monitor-enter(r0)
            java.util.ArrayList<com.clevertap.android.sdk.validation.ValidationResult> r1 = r5.pendingValidationResults     // Catch:{ Exception -> 0x0032 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0032 }
            r2 = 50
            if (r1 <= r2) goto L_0x002a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0032 }
            r2.<init>()     // Catch:{ Exception -> 0x0032 }
            r3 = 10
        L_0x0014:
            if (r3 >= r1) goto L_0x0024
            java.util.ArrayList<com.clevertap.android.sdk.validation.ValidationResult> r4 = r5.pendingValidationResults     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x0032 }
            com.clevertap.android.sdk.validation.ValidationResult r4 = (com.clevertap.android.sdk.validation.ValidationResult) r4     // Catch:{ Exception -> 0x0032 }
            r2.add(r4)     // Catch:{ Exception -> 0x0032 }
            int r3 = r3 + 1
            goto L_0x0014
        L_0x0024:
            r2.add(r6)     // Catch:{ Exception -> 0x0032 }
            r5.pendingValidationResults = r2     // Catch:{ Exception -> 0x0032 }
            goto L_0x0032
        L_0x002a:
            java.util.ArrayList<com.clevertap.android.sdk.validation.ValidationResult> r1 = r5.pendingValidationResults     // Catch:{ Exception -> 0x0032 }
            r1.add(r6)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0032
        L_0x0030:
            r6 = move-exception
            goto L_0x0034
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.validation.ValidationResultStack.pushValidationResult(com.clevertap.android.sdk.validation.ValidationResult):void");
    }
}
