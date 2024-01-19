package com.facebook.appevents.codeless;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewIndexer.kt */
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    public final /* synthetic */ ViewIndexer this$0;

    public ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e1, code lost:
        com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a8 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.Class<com.facebook.appevents.codeless.ViewIndexer> r0 = com.facebook.appevents.codeless.ViewIndexer.class
            com.facebook.appevents.codeless.ViewIndexer r1 = r9.this$0     // Catch:{ Exception -> 0x00e1 }
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ Exception -> 0x00e1 }
            r3 = 0
            if (r2 == 0) goto L_0x000d
        L_0x000b:
            r1 = r3
            goto L_0x0015
        L_0x000d:
            java.lang.ref.WeakReference<android.app.Activity> r1 = r1.activityReference     // Catch:{ all -> 0x0010 }
            goto L_0x0015
        L_0x0010:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x000b
        L_0x0015:
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00e1 }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x00e1 }
            android.view.View r2 = com.facebook.appevents.internal.AppEventUtility.getRootView(r1)     // Catch:{ Exception -> 0x00e1 }
            if (r1 == 0) goto L_0x00e0
            if (r2 != 0) goto L_0x0025
            goto L_0x00e0
        L_0x0025:
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x00e1 }
            com.facebook.appevents.codeless.CodelessManager r4 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch:{ Exception -> 0x00e1 }
            java.lang.Class<com.facebook.appevents.codeless.CodelessManager> r4 = com.facebook.appevents.codeless.CodelessManager.class
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)     // Catch:{ Exception -> 0x00e1 }
            r6 = 0
            if (r5 == 0) goto L_0x0039
            goto L_0x0044
        L_0x0039:
            java.util.concurrent.atomic.AtomicBoolean r5 = com.facebook.appevents.codeless.CodelessManager.isAppIndexingEnabled     // Catch:{ all -> 0x0040 }
            boolean r6 = r5.get()     // Catch:{ all -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)     // Catch:{ Exception -> 0x00e1 }
        L_0x0044:
            if (r6 != 0) goto L_0x0047
            return
        L_0x0047:
            boolean r4 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0057
            java.lang.String r0 = "UnityFacebookSDKPlugin"
            java.lang.String r1 = "CaptureViewHierarchy"
            com.facebook.appevents.codeless.internal.UnityReflection.sendMessage(r0, r1, r5)     // Catch:{ Exception -> 0x00e1 }
            return
        L_0x0057:
            java.util.concurrent.FutureTask r4 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x00e1 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r6 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x00e1 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00e1 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x00e1 }
            com.facebook.appevents.codeless.ViewIndexer r6 = r9.this$0     // Catch:{ Exception -> 0x00e1 }
            boolean r7 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ Exception -> 0x00e1 }
            if (r7 == 0) goto L_0x006b
        L_0x0069:
            r6 = r3
            goto L_0x0073
        L_0x006b:
            android.os.Handler r6 = r6.uiThreadHandler     // Catch:{ all -> 0x006e }
            goto L_0x0073
        L_0x006e:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r0)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x0069
        L_0x0073:
            r6.post(r4)     // Catch:{ Exception -> 0x00e1 }
            r6 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r4 = r4.get(r6, r8)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0082 }
            r5 = r4
            goto L_0x0085
        L_0x0082:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00e1 }
        L_0x0085:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r6 = "screenname"
            r4.put(r6, r1)     // Catch:{ JSONException -> 0x00a8 }
            java.lang.String r1 = "screenshot"
            r4.put(r1, r5)     // Catch:{ JSONException -> 0x00a8 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00a8 }
            r1.<init>()     // Catch:{ JSONException -> 0x00a8 }
            com.facebook.appevents.codeless.internal.ViewHierarchy r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ JSONException -> 0x00a8 }
            org.json.JSONObject r2 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r2)     // Catch:{ JSONException -> 0x00a8 }
            r1.put(r2)     // Catch:{ JSONException -> 0x00a8 }
            java.lang.String r2 = "view"
            r4.put(r2, r1)     // Catch:{ JSONException -> 0x00a8 }
            goto L_0x00ab
        L_0x00a8:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00e1 }
        L_0x00ab:
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = "viewTree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x00e1 }
            com.facebook.appevents.codeless.ViewIndexer r2 = r9.this$0     // Catch:{ Exception -> 0x00e1 }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ Exception -> 0x00e1 }
            if (r4 == 0) goto L_0x00bd
            goto L_0x00e4
        L_0x00bd:
            if (r2 == 0) goto L_0x00da
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)     // Catch:{ all -> 0x00db }
            if (r3 == 0) goto L_0x00c6
            goto L_0x00e4
        L_0x00c6:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00d5 }
            java.util.concurrent.Executor r3 = com.facebook.FacebookSdk.getExecutor()     // Catch:{ all -> 0x00d5 }
            com.facebook.appevents.codeless.-$$Lambda$SNI35ZAcf4eugvBKQmdtKvY0Qc4 r4 = new com.facebook.appevents.codeless.-$$Lambda$SNI35ZAcf4eugvBKQmdtKvY0Qc4     // Catch:{ all -> 0x00d5 }
            r4.<init>(r1, r2)     // Catch:{ all -> 0x00d5 }
            r3.execute(r4)     // Catch:{ all -> 0x00d5 }
            goto L_0x00e4
        L_0x00d5:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r2)     // Catch:{ all -> 0x00db }
            goto L_0x00e4
        L_0x00da:
            throw r3     // Catch:{ all -> 0x00db }
        L_0x00db:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e4
        L_0x00e0:
            return
        L_0x00e1:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}
