package com.google.android.gms.common.internal;

import android.content.DialogInterface.OnClickListener;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class zag implements OnClickListener {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = android.os.Build.FINGERPRINT.contains("generic");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r2.dismiss();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r2.dismiss();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.content.DialogInterface r2, int r3) {
        /*
            r1 = this;
            r1.zaa()     // Catch:{ ActivityNotFoundException -> 0x0009 }
            r2.dismiss()
            return
        L_0x0007:
            r3 = move-exception
            goto L_0x0016
        L_0x0009:
            java.lang.String r3 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0007 }
            java.lang.String r0 = "generic"
            boolean r3 = r3.contains(r0)     // Catch:{ all -> 0x0007 }
            r0 = 1
            r2.dismiss()
            return
        L_0x0016:
            r2.dismiss()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zag.onClick(android.content.DialogInterface, int):void");
    }

    public abstract void zaa();
}
