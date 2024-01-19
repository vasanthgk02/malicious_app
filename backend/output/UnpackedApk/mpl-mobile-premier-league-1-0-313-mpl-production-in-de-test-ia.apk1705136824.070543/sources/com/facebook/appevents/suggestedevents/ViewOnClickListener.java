package com.facebook.appevents.suggestedevents;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.ml.ModelManager.Task;
import com.facebook.appevents.suggestedevents.ViewOnClickListener.Companion;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.netcore.android.notification.SMTNotificationConstants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener;", "Landroid/view/View$OnClickListener;", "hostView", "Landroid/view/View;", "rootView", "activityName", "", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "baseListener", "hostViewWeakReference", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "onClick", "", "view", "predictAndProcess", "pathID", "buttonText", "viewData", "Lorg/json/JSONObject;", "process", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewOnClickListener.kt */
public final class ViewOnClickListener implements OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final Set<Integer> viewsAttachedListener = new HashSet();
    public final String activityName;
    public final OnClickListener baseListener;
    public final WeakReference<View> hostViewWeakReference;
    public final WeakReference<View> rootViewWeakReference;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener$Companion;", "", "()V", "API_ENDPOINT", "", "OTHER_EVENT", "viewsAttachedListener", "", "", "attachListener", "", "hostView", "Landroid/view/View;", "rootView", "activityName", "attachListener$facebook_core_release", "processPredictedResult", "predictedEvent", "buttonText", "dense", "", "queryHistoryAndProcess", "", "pathID", "sendPredictedResult", "eventToPost", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewOnClickListener.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: queryHistoryAndProcess$lambda-0  reason: not valid java name */
        public static final void m187queryHistoryAndProcess$lambda0(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "$queriedEvent");
            Intrinsics.checkNotNullParameter(str2, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(str, str2, new float[0]);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void attachListener$facebook_core_release(android.view.View r6, android.view.View r7, java.lang.String r8) {
            /*
                r5 = this;
                java.lang.String r0 = "hostView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "rootView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "activityName"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                int r0 = r6.hashCode()
                java.util.Set r1 = com.facebook.appevents.suggestedevents.ViewOnClickListener.access$getViewsAttachedListener$cp()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L_0x0084
                com.facebook.appevents.codeless.internal.ViewHierarchy r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                com.facebook.appevents.suggestedevents.ViewOnClickListener r1 = new com.facebook.appevents.suggestedevents.ViewOnClickListener
                r2 = 0
                r1.<init>(r6, r7, r8, r2)
                java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r7 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
                boolean r8 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                if (r8 == 0) goto L_0x0032
                goto L_0x0079
            L_0x0032:
                java.lang.String r8 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)     // Catch:{ all -> 0x0075 }
                java.lang.String r8 = "android.view.View"
                java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0050 }
                java.lang.String r3 = "mListenerInfo"
                java.lang.reflect.Field r8 = r8.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0050 }
                java.lang.String r3 = "android.view.View$ListenerInfo"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0051 }
                java.lang.String r4 = "mOnClickListener"
                java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0051 }
                goto L_0x0052
            L_0x0050:
                r8 = r2
            L_0x0051:
                r3 = r2
            L_0x0052:
                if (r8 == 0) goto L_0x0071
                if (r3 != 0) goto L_0x0057
                goto L_0x0071
            L_0x0057:
                r4 = 1
                r8.setAccessible(r4)     // Catch:{ Exception -> 0x0079 }
                r3.setAccessible(r4)     // Catch:{ Exception -> 0x0079 }
                r8.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x0066 }
                java.lang.Object r2 = r8.get(r6)     // Catch:{ IllegalAccessException -> 0x0066 }
                goto L_0x0067
            L_0x0066:
            L_0x0067:
                if (r2 != 0) goto L_0x006d
                r6.setOnClickListener(r1)     // Catch:{ Exception -> 0x0079 }
                goto L_0x0079
            L_0x006d:
                r3.set(r2, r1)     // Catch:{ Exception -> 0x0079 }
                goto L_0x0079
            L_0x0071:
                r6.setOnClickListener(r1)     // Catch:{ Exception -> 0x0079 }
                goto L_0x0079
            L_0x0075:
                r6 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r7)
            L_0x0079:
                java.util.Set r6 = com.facebook.appevents.suggestedevents.ViewOnClickListener.access$getViewsAttachedListener$cp()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
                r6.add(r7)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.ViewOnClickListener.Companion.attachListener$facebook_core_release(android.view.View, android.view.View, java.lang.String):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void processPredictedResult(java.lang.String r8, java.lang.String r9, float[] r10) {
            /*
                r7 = this;
                java.lang.Class<com.facebook.appevents.suggestedevents.SuggestedEventsManager> r0 = com.facebook.appevents.suggestedevents.SuggestedEventsManager.class
                com.facebook.appevents.suggestedevents.SuggestedEventsManager r1 = com.facebook.appevents.suggestedevents.SuggestedEventsManager.INSTANCE
                boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
                java.lang.String r2 = "event"
                r3 = 0
                if (r1 == 0) goto L_0x000f
            L_0x000d:
                r1 = 0
                goto L_0x001e
            L_0x000f:
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)     // Catch:{ all -> 0x0019 }
                java.util.Set<java.lang.String> r1 = com.facebook.appevents.suggestedevents.SuggestedEventsManager.productionEvents     // Catch:{ all -> 0x0019 }
                boolean r1 = r1.contains(r8)     // Catch:{ all -> 0x0019 }
                goto L_0x001e
            L_0x0019:
                r1 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
                goto L_0x000d
            L_0x001e:
                r4 = 0
                if (r1 == 0) goto L_0x0055
                com.facebook.FacebookSdk r10 = com.facebook.FacebookSdk.INSTANCE
                android.content.Context r10 = com.facebook.FacebookSdk.getApplicationContext()
                com.facebook.appevents.AppEventsLoggerImpl r0 = new com.facebook.appevents.AppEventsLoggerImpl
                r0.<init>(r10, r4, r4)
                java.lang.String r10 = "loggerImpl"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r10)
                boolean r10 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
                if (r10 == 0) goto L_0x0039
                goto L_0x00d4
            L_0x0039:
                android.os.Bundle r10 = new android.os.Bundle     // Catch:{ all -> 0x004f }
                r10.<init>()     // Catch:{ all -> 0x004f }
                java.lang.String r1 = "_is_suggested_event"
                java.lang.String r2 = "1"
                r10.putString(r1, r2)     // Catch:{ all -> 0x004f }
                java.lang.String r1 = "_button_text"
                r10.putString(r1, r9)     // Catch:{ all -> 0x004f }
                r0.logEvent(r8, r10)     // Catch:{ all -> 0x004f }
                goto L_0x00d4
            L_0x004f:
                r8 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r0)
                goto L_0x00d4
            L_0x0055:
                com.facebook.appevents.suggestedevents.SuggestedEventsManager r1 = com.facebook.appevents.suggestedevents.SuggestedEventsManager.INSTANCE
                boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
                if (r1 == 0) goto L_0x005f
            L_0x005d:
                r0 = 0
                goto L_0x006e
            L_0x005f:
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)     // Catch:{ all -> 0x0069 }
                java.util.Set<java.lang.String> r1 = com.facebook.appevents.suggestedevents.SuggestedEventsManager.eligibleEvents     // Catch:{ all -> 0x0069 }
                boolean r0 = r1.contains(r8)     // Catch:{ all -> 0x0069 }
                goto L_0x006e
            L_0x0069:
                r1 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
                goto L_0x005d
            L_0x006e:
                if (r0 == 0) goto L_0x00d4
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                java.lang.String r1 = "event_name"
                r0.putString(r1, r8)     // Catch:{ JSONException -> 0x00d4 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d4 }
                r8.<init>()     // Catch:{ JSONException -> 0x00d4 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00d4 }
                r1.<init>()     // Catch:{ JSONException -> 0x00d4 }
                int r2 = r10.length     // Catch:{ JSONException -> 0x00d4 }
                r5 = 0
            L_0x0086:
                if (r5 >= r2) goto L_0x0095
                r6 = r10[r5]     // Catch:{ JSONException -> 0x00d4 }
                int r5 = r5 + 1
                r1.append(r6)     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r6 = ","
                r1.append(r6)     // Catch:{ JSONException -> 0x00d4 }
                goto L_0x0086
            L_0x0095:
                java.lang.String r10 = "dense"
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x00d4 }
                r8.put(r10, r1)     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r10 = "button_text"
                r8.put(r10, r9)     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r9 = "metadata"
                java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00d4 }
                r0.putString(r9, r8)     // Catch:{ JSONException -> 0x00d4 }
                com.facebook.GraphRequest$Companion r8 = com.facebook.GraphRequest.Companion     // Catch:{ JSONException -> 0x00d4 }
                java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r10 = "%s/suggested_events"
                r1 = 1
                java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x00d4 }
                com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r5 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ JSONException -> 0x00d4 }
                r2[r3] = r5     // Catch:{ JSONException -> 0x00d4 }
                java.lang.Object[] r1 = java.util.Arrays.copyOf(r2, r1)     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r9 = java.lang.String.format(r9, r10, r1)     // Catch:{ JSONException -> 0x00d4 }
                java.lang.String r10 = "java.lang.String.format(locale, format, *args)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ JSONException -> 0x00d4 }
                com.facebook.GraphRequest r8 = r8.newPostRequest(r4, r9, r4, r4)     // Catch:{ JSONException -> 0x00d4 }
                r8.setParameters(r0)     // Catch:{ JSONException -> 0x00d4 }
                r8.executeAndWait()     // Catch:{ JSONException -> 0x00d4 }
            L_0x00d4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.ViewOnClickListener.Companion.processPredictedResult(java.lang.String, java.lang.String, float[]):void");
        }
    }

    public ViewOnClickListener(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.activityName = CharsKt__CharKt.replace$default(lowerCase, (String) "activity", (String) "", false, 4);
    }

    public static final /* synthetic */ Set access$getViewsAttachedListener$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewsAttachedListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return null;
        }
    }

    /* renamed from: predictAndProcess$lambda-0  reason: not valid java name */
    public static final void m186predictAndProcess$lambda0(JSONObject jSONObject, String str, ViewOnClickListener viewOnClickListener, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                Intrinsics.checkNotNullParameter(jSONObject, "$viewData");
                Intrinsics.checkNotNullParameter(str, "$buttonText");
                Intrinsics.checkNotNullParameter(viewOnClickListener, "this$0");
                Intrinsics.checkNotNullParameter(str2, "$pathID");
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
                    if (appName != null) {
                        String lowerCase = appName.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                        String textFeature = FeatureExtractor.getTextFeature(str, viewOnClickListener.activityName, lowerCase);
                        if (denseFeatures != null) {
                            ModelManager modelManager = ModelManager.INSTANCE;
                            String[] predict = ModelManager.predict(Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                            if (predict != null) {
                                String str3 = predict[0];
                                PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                                PredictionHistoryManager.addPrediction(str2, str3);
                                if (!Intrinsics.areEqual(str3, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER)) {
                                    Companion.processPredictedResult(str3, str, denseFeatures);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            }
        }
    }

    public void onClick(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(view, "view");
                OnClickListener onClickListener = this.baseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void process() {
        boolean z;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view = (View) this.rootViewWeakReference.get();
                View view2 = (View) this.hostViewWeakReference.get();
                if (!(view == null || view2 == null)) {
                    try {
                        SuggestedEventViewHierarchy suggestedEventViewHierarchy = SuggestedEventViewHierarchy.INSTANCE;
                        String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                        PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                        String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                        if (pathID != null) {
                            String str = null;
                            PredictionHistoryManager predictionHistoryManager2 = PredictionHistoryManager.INSTANCE;
                            Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
                            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                                try {
                                    Intrinsics.checkNotNullParameter(pathID, "pathID");
                                    if (PredictionHistoryManager.clickedViewPaths.containsKey(pathID)) {
                                        str = PredictionHistoryManager.clickedViewPaths.get(pathID);
                                    }
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, cls);
                                }
                            }
                            if (str == null) {
                                z = false;
                            } else {
                                if (!Intrinsics.areEqual(str, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER)) {
                                    Utility.runOnNonUiThread(new Runnable(str, textOfViewRecursively) {
                                        public final /* synthetic */ String f$0;
                                        public final /* synthetic */ String f$1;

                                        {
                                            this.f$0 = r1;
                                            this.f$1 = r2;
                                        }

                                        public final void run() {
                                            Companion.m187queryHistoryAndProcess$lambda0(this.f$0, this.f$1);
                                        }
                                    });
                                }
                                z = true;
                            }
                            if (!z) {
                                JSONObject jSONObject = new JSONObject();
                                SuggestedEventViewHierarchy suggestedEventViewHierarchy2 = SuggestedEventViewHierarchy.INSTANCE;
                                jSONObject.put("view", SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                                jSONObject.put("screenname", this.activityName);
                                if (!CrashShieldHandler.isObjectCrashing(this)) {
                                    try {
                                        Utility.runOnNonUiThread(new Runnable(jSONObject, textOfViewRecursively, this, pathID) {
                                            public final /* synthetic */ JSONObject f$0;
                                            public final /* synthetic */ String f$1;
                                            public final /* synthetic */ ViewOnClickListener f$2;
                                            public final /* synthetic */ String f$3;

                                            {
                                                this.f$0 = r1;
                                                this.f$1 = r2;
                                                this.f$2 = r3;
                                                this.f$3 = r4;
                                            }

                                            public final void run() {
                                                ViewOnClickListener.m186predictAndProcess$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
                                            }
                                        });
                                    } catch (Throwable th2) {
                                        CrashShieldHandler.handleThrowable(th2, this);
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(th3, this);
            }
        }
    }
}
