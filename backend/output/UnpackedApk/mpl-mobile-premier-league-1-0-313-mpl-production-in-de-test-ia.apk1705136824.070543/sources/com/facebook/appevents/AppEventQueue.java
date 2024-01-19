package com.facebook.appevents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.Companion;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.paynimo.android.payment.util.Constant;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J*\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150(H\u0007J0\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010-\u001a\u00020\u0013H\u0007J\u001a\u0010.\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/appevents/AppEventQueue;", "", "()V", "FLUSH_PERIOD_IN_SECONDS", "", "NO_CONNECTIVITY_ERROR_CODE", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "TAG", "", "kotlin.jvm.PlatformType", "appEventCollection", "Lcom/facebook/appevents/AppEventCollection;", "flushRunnable", "Ljava/lang/Runnable;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "add", "", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvent", "Lcom/facebook/appevents/AppEvent;", "buildRequestForSession", "Lcom/facebook/GraphRequest;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "limitEventUsage", "", "flushState", "Lcom/facebook/appevents/FlushStatistics;", "buildRequests", "", "flushResults", "flush", "reason", "Lcom/facebook/appevents/FlushReason;", "flushAndWait", "getKeySet", "", "handleResponse", "request", "response", "Lcom/facebook/GraphResponse;", "persistToDisk", "sendEventsToServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventQueue.kt */
public final class AppEventQueue {
    public static final AppEventQueue INSTANCE = new AppEventQueue();
    public static volatile AppEventCollection appEventCollection = new AppEventCollection();
    public static final Runnable flushRunnable = $$Lambda$JfKbahcEddW7eTw_HAXhtpIoDNY.INSTANCE;
    public static ScheduledFuture<?> scheduledFuture;
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: add$lambda-3  reason: not valid java name */
    public static final void m139add$lambda3(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(appEvent, "$appEvent");
                AppEventCollection appEventCollection2 = appEventCollection;
                synchronized (appEventCollection2) {
                    Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                    Intrinsics.checkNotNullParameter(appEvent, "appEvent");
                    SessionEventsState sessionEventsState = appEventCollection2.getSessionEventsState(accessTokenAppIdPair);
                    if (sessionEventsState != null) {
                        sessionEventsState.addEvent(appEvent);
                    }
                }
                if (AppEventsLoggerImpl.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && appEventCollection.getEventCount() > 100) {
                    flushAndWait(FlushReason.EVENT_THRESHOLD);
                } else if (scheduledFuture == null) {
                    scheduledFuture = singleThreadExecutor.schedule(flushRunnable, 15, TimeUnit.SECONDS);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState, boolean z, FlushStatistics flushStatistics) {
        String access$getPushNotificationsRegistrationIdField$cp;
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppId");
            Intrinsics.checkNotNullParameter(sessionEventsState, "appEvents");
            Intrinsics.checkNotNullParameter(flushStatistics, "flushState");
            String str = accessTokenAppIdPair.applicationId;
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            boolean z2 = false;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
            Companion companion = GraphRequest.Companion;
            String format = String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(null, format, null, null);
            newPostRequest.forceApplicationRequest = true;
            Bundle bundle = newPostRequest.parameters;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("access_token", accessTokenAppIdPair.accessTokenString);
            AppEventsLoggerImpl.Companion companion2 = AppEventsLoggerImpl.Companion;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                access$getPushNotificationsRegistrationIdField$cp = AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp();
            }
            if (access$getPushNotificationsRegistrationIdField$cp != null) {
                bundle.putString("device_token", access$getPushNotificationsRegistrationIdField$cp);
            }
            String installReferrer = AppEventsLoggerImpl.Companion.getInstallReferrer();
            if (installReferrer != null) {
                bundle.putString(ReferrerDetails.KEY_INSTALL_REFERRER, installReferrer);
            }
            newPostRequest.setParameters(bundle);
            if (queryAppSettings != null) {
                z2 = queryAppSettings.supportsImplicitLogging;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), z2, z);
            if (populateRequest == 0) {
                return null;
            }
            flushStatistics.numEvents += populateRequest;
            newPostRequest.setCallback(new Callback(newPostRequest, sessionEventsState, flushStatistics) {
                public final /* synthetic */ GraphRequest f$1;
                public final /* synthetic */ SessionEventsState f$2;
                public final /* synthetic */ FlushStatistics f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventQueue.m140buildRequestForSession$lambda4(AccessTokenAppIdPair.this, this.f$1, this.f$2, this.f$3, graphResponse);
                }
            });
            return newPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: buildRequestForSession$lambda-4  reason: not valid java name */
    public static final void m140buildRequestForSession$lambda4(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics, GraphResponse graphResponse) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(graphRequest, "$postRequest");
                Intrinsics.checkNotNullParameter(sessionEventsState, "$appEvents");
                Intrinsics.checkNotNullParameter(flushStatistics, "$flushState");
                Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
                handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, flushStatistics);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final List<GraphRequest> buildRequests(AppEventCollection appEventCollection2, FlushStatistics flushStatistics) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            Intrinsics.checkNotNullParameter(flushStatistics, "flushResults");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(applicationContext);
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair next : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(next);
                if (sessionEventsState != null) {
                    GraphRequest buildRequestForSession = buildRequestForSession(next, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                    if (buildRequestForSession != null) {
                        arrayList.add(buildRequestForSession);
                        if (AppEventsCAPIManager.isEnabled) {
                            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                            Intrinsics.checkNotNullParameter(buildRequestForSession, "request");
                            Utility.runOnNonUiThread(new Runnable() {
                                public final void run() {
                                    AppEventsConversionsAPITransformerWebRequests.m158transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest.this);
                                }
                            });
                        }
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void flush(FlushReason flushReason) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(flushReason, "reason");
                singleThreadExecutor.execute(new Runnable() {
                    public final void run() {
                        AppEventQueue.m141flush$lambda2(FlushReason.this);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: flush$lambda-2  reason: not valid java name */
    public static final void m141flush$lambda2(FlushReason flushReason) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(flushReason, "$reason");
                flushAndWait(flushReason);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void flushAndWait(FlushReason flushReason) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(flushReason, "reason");
                appEventCollection.addPersistedEvents(AppEventDiskStore.readAndClearStore());
                try {
                    FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
                    if (sendEventsToServer != null) {
                        Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                        intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", sendEventsToServer.numEvents);
                        intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", sendEventsToServer.result);
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: flushRunnable$lambda-0  reason: not valid java name */
    public static final void m142flushRunnable$lambda0() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                scheduledFuture = null;
                if (AppEventsLoggerImpl.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    flushAndWait(FlushReason.TIMER);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        String str;
        AccessTokenAppIdPair accessTokenAppIdPair2 = accessTokenAppIdPair;
        GraphRequest graphRequest2 = graphRequest;
        GraphResponse graphResponse2 = graphResponse;
        SessionEventsState sessionEventsState2 = sessionEventsState;
        FlushStatistics flushStatistics2 = flushStatistics;
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair2, "accessTokenAppId");
            Intrinsics.checkNotNullParameter(graphRequest2, "request");
            Intrinsics.checkNotNullParameter(graphResponse2, Constant.TAG_RESPONSE);
            Intrinsics.checkNotNullParameter(sessionEventsState2, "appEvents");
            Intrinsics.checkNotNullParameter(flushStatistics2, "flushState");
            FacebookRequestError facebookRequestError = graphResponse2.error;
            String str2 = "Success";
            FlushResult flushResult = FlushResult.SUCCESS;
            boolean z = true;
            if (facebookRequestError != null) {
                if (facebookRequestError.errorCode == -1) {
                    str2 = "Failed: No Connectivity";
                    flushResult = FlushResult.NO_CONNECTIVITY;
                } else {
                    str2 = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{graphResponse.toString(), facebookRequestError.toString()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                    flushResult = FlushResult.SERVER_ERROR;
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                try {
                    str = new JSONArray((String) graphRequest2.tag).toString(2);
                    Intrinsics.checkNotNullExpressionValue(str, "{\n            val jsonArray = JSONArray(eventsJsonString)\n            jsonArray.toString(2)\n          }");
                } catch (JSONException unused) {
                    str = "<Can't encode events for debug logging>";
                }
                try {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    Intrinsics.checkNotNullExpressionValue("com.facebook.appevents.AppEventQueue", UeCustomType.TAG);
                    companion.log(loggingBehavior, (String) "com.facebook.appevents.AppEventQueue", (String) "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(graphRequest2.graphObject), str2, str);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return;
                }
            }
            if (facebookRequestError == null) {
                z = false;
            }
            synchronized (sessionEventsState) {
                if (!CrashShieldHandler.isObjectCrashing(sessionEventsState)) {
                    if (z) {
                        try {
                            sessionEventsState2.accumulatedEvents.addAll(sessionEventsState2.inFlightEvents);
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, sessionEventsState2);
                        }
                    }
                    sessionEventsState2.inFlightEvents.clear();
                    sessionEventsState2.numSkippedEventsDueToFullBuffer = 0;
                }
            }
            if (flushResult == FlushResult.NO_CONNECTIVITY) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(sessionEventsState2) {
                    public final /* synthetic */ SessionEventsState f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AppEventQueue.m143handleResponse$lambda5(AccessTokenAppIdPair.this, this.f$1);
                    }
                });
            }
            if (!(flushResult == FlushResult.SUCCESS || flushStatistics2.result == FlushResult.NO_CONNECTIVITY)) {
                Intrinsics.checkNotNullParameter(flushResult, "<set-?>");
                flushStatistics2.result = flushResult;
            }
            return;
        }
        return;
    }

    /* renamed from: handleResponse$lambda-5  reason: not valid java name */
    public static final void m143handleResponse$lambda5(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(sessionEventsState, "$appEvents");
                AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: persistToDisk$lambda-1  reason: not valid java name */
    public static final void m144persistToDisk$lambda1() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                AppEventStore.persistEvents(appEventCollection);
                appEventCollection = new AppEventCollection();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection2) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(flushReason, "reason");
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            FlushStatistics flushStatistics = new FlushStatistics();
            List<GraphRequest> buildRequests = buildRequests(appEventCollection2, flushStatistics);
            if (!(!buildRequests.isEmpty())) {
                return null;
            }
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            Intrinsics.checkNotNullExpressionValue("com.facebook.appevents.AppEventQueue", UeCustomType.TAG);
            companion.log(loggingBehavior, (String) "com.facebook.appevents.AppEventQueue", (String) "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
            for (GraphRequest executeAndWait : buildRequests) {
                executeAndWait.executeAndWait();
            }
            return flushStatistics;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
