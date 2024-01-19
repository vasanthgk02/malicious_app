package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler.Companion;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.$$Lambda$RCFR_ep9Az8oVFbyXtDp80vE8wM;
import com.facebook.internal.instrument.errorreport.$$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstrumentManager.kt */
public final class InstrumentManager {
    /* renamed from: start$lambda-0  reason: not valid java name */
    public static final void m213start$lambda0(boolean z) {
        File[] fileArr;
        if (z) {
            Companion companion = CrashHandler.Companion;
            synchronized (companion) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    companion.sendExceptionReports();
                }
                if (CrashHandler.instance != null) {
                    String str = CrashHandler.TAG;
                } else {
                    CrashHandler crashHandler = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), null);
                    CrashHandler.instance = crashHandler;
                    Thread.setDefaultUncaughtExceptionHandler(crashHandler);
                }
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(Feature.CrashShield)) {
                ExceptionAnalyzer.enabled = true;
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled() && !Utility.isDataProcessingRestricted()) {
                    File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
                    if (instrumentReportDir == null) {
                        fileArr = new File[0];
                    } else {
                        fileArr = instrumentReportDir.listFiles($$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94.INSTANCE);
                        if (fileArr == null) {
                            fileArr = new File[0];
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = fileArr.length;
                    int i = 0;
                    while (i < length) {
                        File file = fileArr[i];
                        i++;
                        InstrumentData load = Builder.load(file);
                        if (load.isValid()) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("crash_shield", load.toString());
                                GraphRequest.Companion companion2 = GraphRequest.Companion;
                                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                                String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                                arrayList.add(companion2.newPostRequest(null, format, jSONObject, new Callback() {
                                    public final void onCompleted(GraphResponse graphResponse) {
                                        ExceptionAnalyzer.m212sendExceptionAnalysisReports$lambda1(InstrumentData.this, graphResponse);
                                    }
                                }));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
                    }
                }
                CrashShieldHandler crashShieldHandler = CrashShieldHandler.INSTANCE;
                CrashShieldHandler.enabled = true;
            }
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            FeatureManager.isEnabled(Feature.ThreadCheck);
        }
    }

    /* renamed from: start$lambda-1  reason: not valid java name */
    public static final void m214start$lambda1(boolean z) {
        File[] fileArr;
        if (z) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled() && !Utility.isDataProcessingRestricted()) {
                File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
                int i = 0;
                if (instrumentReportDir == null) {
                    fileArr = new File[0];
                } else {
                    fileArr = instrumentReportDir.listFiles($$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE.INSTANCE);
                    Intrinsics.checkNotNullExpressionValue(fileArr, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
                }
                ArrayList arrayList = new ArrayList();
                int length = fileArr.length;
                int i2 = 0;
                while (i2 < length) {
                    File file = fileArr[i2];
                    i2++;
                    ErrorReportData errorReportData = new ErrorReportData(file);
                    if ((errorReportData.errorMessage == null || errorReportData.timestamp == null) ? false : true) {
                        arrayList.add(errorReportData);
                    }
                }
                TweetUtils.sortWith(arrayList, $$Lambda$RCFR_ep9Az8oVFbyXtDp80vE8wM.INSTANCE);
                JSONArray jSONArray = new JSONArray();
                while (i < arrayList.size() && i < 1000) {
                    jSONArray.put(arrayList.get(i));
                    i++;
                }
                InstrumentUtility.sendReports("error_reports", jSONArray, new Callback(arrayList) {
                    public final /* synthetic */ ArrayList f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCompleted(GraphResponse graphResponse) {
                        ErrorReportHandler.m226sendErrorReports$lambda2(this.f$0, graphResponse);
                    }
                });
            }
        }
    }

    /* renamed from: start$lambda-2  reason: not valid java name */
    public static final void m215start$lambda2(boolean z) {
        Class<ANRDetector> cls;
        if (z) {
            ANRHandler aNRHandler = ANRHandler.INSTANCE;
            Class<ANRHandler> cls2 = ANRHandler.class;
            synchronized (cls2) {
                if (!CrashShieldHandler.isObjectCrashing(cls2)) {
                    try {
                        if (!ANRHandler.enabled.getAndSet(true)) {
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                                ANRHandler.sendANRReports();
                            }
                            ANRDetector aNRDetector = ANRDetector.INSTANCE;
                            cls = ANRDetector.class;
                            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                                ANRDetector.scheduledExecutorService.scheduleAtFixedRate(ANRDetector.anrDetectorRunnable, 0, (long) 500, TimeUnit.MILLISECONDS);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls2);
                    }
                } else {
                    return;
                }
            }
        } else {
            return;
        }
        return;
    }
}
