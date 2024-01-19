package com.netcore.android.mediadownloader;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTFileDownloader;", "", "", "download", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "url", "Ljava/lang/String;", "getUrl", "kotlin.jvm.PlatformType", "TAG", "", "isForInbox", "Z", "()Z", "type", "getType", "setType", "(Ljava/lang/String;)V", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTFileDownloader.kt */
public final class SMTFileDownloader {
    public final String TAG;
    public final Context context;
    public final boolean isForInbox;
    public String type;
    public final String url;

    public SMTFileDownloader(Context context2, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.context = context2;
        this.url = str;
        this.type = str2;
        this.isForInbox = z;
        this.TAG = SMTFileDownloader.class.getSimpleName();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.String]
      uses: [java.lang.String, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection]
      mth insns count: 78
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[SYNTHETIC, Splitter:B:31:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076 A[Catch:{ Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088 A[SYNTHETIC, Splitter:B:41:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A[Catch:{ Exception -> 0x008c }] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String download() {
        /*
            r10 = this;
            java.lang.String r0 = "TAG"
            java.lang.String r1 = r10.url
            r2 = 0
            if (r1 == 0) goto L_0x009c
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.lang.String r3 = r10.url     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            if (r1 == 0) goto L_0x0049
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ Exception -> 0x0046, all -> 0x0040 }
            com.netcore.android.mediadownloader.SMTDownloaderUtility r4 = com.netcore.android.mediadownloader.SMTDownloaderUtility.INSTANCE     // Catch:{ Exception -> 0x003e }
            android.content.Context r5 = r10.context     // Catch:{ Exception -> 0x003e }
            java.lang.String r6 = r10.url     // Catch:{ Exception -> 0x003e }
            java.lang.String r7 = r10.type     // Catch:{ Exception -> 0x003e }
            boolean r8 = r10.isForInbox     // Catch:{ Exception -> 0x003e }
            java.io.File r5 = r4.getDownloadFile(r5, r6, r7, r8)     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0034
            java.lang.String r2 = r4.saveFileToInternalStorage(r3, r5)     // Catch:{ Exception -> 0x003e }
        L_0x0034:
            r1.disconnect()     // Catch:{ Exception -> 0x0072 }
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x009c
        L_0x003e:
            r4 = move-exception
            goto L_0x005a
        L_0x0040:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r3
            r3 = r9
            goto L_0x0086
        L_0x0046:
            r4 = move-exception
            r3 = r2
            goto L_0x005a
        L_0x0049:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            java.lang.String r3 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
            throw r1     // Catch:{ Exception -> 0x0056, all -> 0x0051 }
        L_0x0051:
            r1 = move-exception
            r3 = r1
            r1 = r3
            r3 = r2
            goto L_0x0086
        L_0x0056:
            r1 = move-exception
            r4 = r1
            r1 = r2
            r3 = r1
        L_0x005a:
            com.netcore.android.logger.SMTLogger r5 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = r10.TAG     // Catch:{ all -> 0x0082 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0082 }
            r5.e(r6, r4)     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0074
            r1.disconnect()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0074
        L_0x0072:
            r1 = move-exception
            goto L_0x007a
        L_0x0074:
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x009c
        L_0x007a:
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r4 = r10.TAG
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r4, r0, r1, r3, r4)
            goto L_0x009c
        L_0x0082:
            r2 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x0086:
            if (r2 == 0) goto L_0x008e
            r2.disconnect()     // Catch:{ Exception -> 0x008c }
            goto L_0x008e
        L_0x008c:
            r2 = move-exception
            goto L_0x0094
        L_0x008e:
            if (r3 == 0) goto L_0x009b
            r3.close()     // Catch:{ Exception -> 0x008c }
            goto L_0x009b
        L_0x0094:
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r4 = r10.TAG
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r4, r0, r2, r3, r4)
        L_0x009b:
            throw r1
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.mediadownloader.SMTFileDownloader.download():java.lang.String");
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isForInbox() {
        return this.isForInbox;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public /* synthetic */ SMTFileDownloader(Context context2, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, str, str2, (i & 8) != 0 ? false : z);
    }
}
