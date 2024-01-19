package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFKeystoreWrapper;
import com.appsflyer.AFLogger;
import com.appsflyer.AFLogger.LogLevel;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.AppsFlyerProperties.EmailsCryptType;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import com.appsflyer.internal.a.C0062a;
import com.appsflyer.internal.an.c;
import com.appsflyer.internal.u.a;
import com.facebook.react.modules.network.NetworkingModule;
import com.mpl.androidapp.utils.Constant;
import com.mpl.payment.braintree.BraintreeConstants;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.security.KeyStoreException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.GenericMessageRequest;

public final class ac extends AppsFlyerLib {
    public static AppsFlyerInAppPurchaseValidatorListener AFInAppEventParameterName = null;
    public static final String AFInAppEventType = "6.5.4".substring(0, "6.5.4".lastIndexOf(values((String) "Ჽ", MeasureSpec.makeMeasureSpec(0, 0) + 28643).intern()));
    public static AppsFlyerConversionListener AFKeystoreWrapper = null;
    public static String AFLogger$LogLevel = "https://%sstats.%s/stats";
    public static long enableLocationCollection = 0;
    public static String onAppOpenAttributionNative = null;
    public static String onAttributionFailureNative = null;
    public static ac onConversionDataFail = new ac();
    public static String onDeepLinkingNative = null;
    public static final String onInstallConversionDataLoadedNative;
    public static String onInstallConversionFailureNative = null;
    public static String onResponseErrorNative = null;
    public static int setCustomerIdAndLogSession = 1;
    public static final String valueOf = "170";
    public static final String values;
    public static int waitForCustomerUserId;
    public long AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public boolean AppsFlyerConversionListener = false;
    public boolean AppsFlyerInAppPurchaseValidatorListener;
    public boolean AppsFlyerLib;
    public boolean getInstance = false;
    public y getLevel;
    public SharedPreferences getSdkVersion;
    public String init;
    public long onAppOpenAttribution = -1;
    @Deprecated
    public ScheduledExecutorService onAttributionFailure = null;
    public long onConversionDataSuccess = TimeUnit.SECONDS.toMillis(5);
    public String onDeepLinking;
    public String onPause;
    public Map<Long, String> onResponse;
    public boolean onResponseError = false;
    public long onResponseNative = -1;
    public boolean onValidateInApp = false;
    public final al onValidateInAppFailure = new al();
    public dc setAndroidIdData;
    public final bf setCustomerUserId;
    public boolean setDebugLog = false;
    public az setImeiData;
    public final Executor setOaidData = Executors.newSingleThreadExecutor();
    public Application stop;
    public Map<String, Object> updateServerUninstallToken;

    /* renamed from: com.appsflyer.internal.ac$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] AFKeystoreWrapper;
        public static final /* synthetic */ int[] values;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        static {
            /*
                com.appsflyer.internal.dd$d[] r0 = com.appsflyer.internal.dd.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFKeystoreWrapper = r0
                r1 = 2
                r2 = 1
                com.appsflyer.internal.dd$d r3 = com.appsflyer.internal.dd.d.FINISHED     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = AFKeystoreWrapper     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.appsflyer.internal.dd$d r3 = com.appsflyer.internal.dd.d.STARTED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                values = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r3 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AnonymousClass9.<clinit>():void");
        }
    }

    public class b implements Runnable {
        public final i values;

        public /* synthetic */ b(ac acVar, i iVar, byte b2) {
            this(iVar);
        }

        public final void run() {
            ac.AFInAppEventParameterName(ac.this, this.values);
        }

        public b(i iVar) {
            this.values = iVar;
        }
    }

    public class d implements Runnable {
        public final i AFInAppEventType;

        public /* synthetic */ d(ac acVar, i iVar, byte b2) {
            this(iVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0193, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0194, code lost:
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0.getMessage(), r0);
            r2 = r1.AFInAppEventType.AFInAppEventParameterName;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x019f, code lost:
            if (r2 != null) goto L_0x01a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a1, code lost:
            r2.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01aa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ab, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ac, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x01df, code lost:
            r0.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r12.getMessage());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0193 A[ExcHandler: all (r0v14 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:40:0x0118] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r16 = this;
                r1 = r16
                com.appsflyer.internal.i r0 = r1.AFInAppEventType
                boolean r0 = r0.valueOf()
                com.appsflyer.internal.ac r2 = com.appsflyer.internal.ac.this
                boolean r2 = r2.isStopped()
                if (r2 == 0) goto L_0x001e
                com.appsflyer.internal.i r0 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.AFInAppEventParameterName
                if (r0 == 0) goto L_0x001d
                int r2 = com.appsflyer.attribution.RequestError.STOP_TRACKING
                java.lang.String r3 = com.appsflyer.internal.ba.values
                r0.onError(r2, r3)
            L_0x001d:
                return
            L_0x001e:
                com.appsflyer.internal.i r2 = r1.AFInAppEventType
                java.util.Map r2 = r2.values()
                com.appsflyer.internal.i r3 = r1.AFInAppEventType
                java.lang.String r4 = r3.onDeepLinkingNative
                int r5 = r3.onInstallConversionFailureNative
                android.app.Application r9 = r3.AFKeystoreWrapper
                r3 = 0
                byte[] r6 = new byte[r3]
                r7 = 1
                r8 = 2
                if (r0 == 0) goto L_0x00f5
                if (r5 > r8) goto L_0x00f5
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.appsflyer.internal.ac r10 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.dd[] r10 = r10.valueOf()
                int r11 = r10.length
                r12 = 0
            L_0x0042:
                if (r12 >= r11) goto L_0x00a0
                r13 = r10[r12]
                boolean r14 = r13 instanceof com.appsflyer.internal.cx
                int[] r15 = com.appsflyer.internal.ac.AnonymousClass9.AFKeystoreWrapper
                com.appsflyer.internal.dd$d r3 = r13.AFInAppEventParameterName
                int r3 = r3.ordinal()
                r3 = r15[r3]
                if (r3 == r7) goto L_0x007a
                if (r3 == r8) goto L_0x0057
                goto L_0x009c
            L_0x0057:
                if (r5 != r8) goto L_0x009c
                if (r14 != 0) goto L_0x009c
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r14 = "source"
                java.lang.String r13 = r13.AFKeystoreWrapper
                r3.put(r14, r13)
                java.lang.String r13 = "response"
                java.lang.String r14 = "TIMEOUT"
                r3.put(r13, r14)
                com.appsflyer.internal.da r13 = new com.appsflyer.internal.da
                r13.<init>()
                r3.putAll(r13)
                r0.add(r3)
                goto L_0x009c
            L_0x007a:
                if (r14 == 0) goto L_0x0097
                java.lang.String r3 = "rfr"
                r14 = r13
                com.appsflyer.internal.cx r14 = (com.appsflyer.internal.cx) r14
                java.util.Map<java.lang.String, java.lang.Object> r14 = r14.valueOf
                r2.put(r3, r14)
                android.content.SharedPreferences r3 = com.appsflyer.internal.ac.AFInAppEventType(r9)
                android.content.SharedPreferences$Editor r3 = r3.edit()
                java.lang.String r14 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r3 = r3.putBoolean(r14, r7)
                r3.apply()
            L_0x0097:
                java.util.Map<java.lang.String, java.lang.Object> r3 = r13.AFInAppEventType
                r0.add(r3)
            L_0x009c:
                int r12 = r12 + 1
                r3 = 0
                goto L_0x0042
            L_0x00a0:
                boolean r3 = r0.isEmpty()
                if (r3 != 0) goto L_0x00ab
                java.lang.String r3 = "referrers"
                r2.put(r3, r0)
            L_0x00ab:
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                java.util.Map r0 = com.appsflyer.internal.ac.AFKeystoreWrapper(r0)
                if (r0 == 0) goto L_0x00be
                java.lang.String r0 = "fb_ddl"
                com.appsflyer.internal.ac r3 = com.appsflyer.internal.ac.this
                java.util.Map r3 = com.appsflyer.internal.ac.AFKeystoreWrapper(r3)
                r2.put(r0, r3)
            L_0x00be:
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.dc r0 = com.appsflyer.internal.ac.valueOf(r0)
                if (r0 == 0) goto L_0x00f5
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.dc r0 = com.appsflyer.internal.ac.valueOf(r0)
                boolean r0 = r0.AFKeystoreWrapper()
                if (r0 == 0) goto L_0x00ea
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.dc r0 = com.appsflyer.internal.ac.valueOf(r0)
                java.util.List r0 = r0.values()
                if (r0 == 0) goto L_0x00f5
                boolean r3 = r0.isEmpty()
                if (r3 != 0) goto L_0x00f5
                java.lang.String r3 = "preload_id"
                r2.put(r3, r0)
                goto L_0x00f5
            L_0x00ea:
                java.lang.String r0 = "preload_id"
                java.lang.String r3 = "timeout"
                java.util.List r3 = java.util.Collections.singletonList(r3)
                r2.put(r0, r3)
            L_0x00f5:
                com.appsflyer.internal.i r0 = r1.AFInAppEventType
                boolean r0 = r0 instanceof com.appsflyer.internal.ck
                if (r0 != 0) goto L_0x0118
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.bf r0 = com.appsflyer.internal.ac.values(r0)
                com.appsflyer.internal.ca r0 = r0.init()
                com.appsflyer.internal.d$d r3 = new com.appsflyer.internal.d$d
                com.appsflyer.internal.be r5 = r0.AFInAppEventType
                android.content.Context r5 = r5.values
                r3.<init>(r2, r5)
                r2.putAll(r3)
                java.util.Map r0 = r0.AFInAppEventParameterName()
                r2.putAll(r0)
            L_0x0118:
                com.appsflyer.internal.i r0 = r1.AFInAppEventType     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                boolean r0 = r0 instanceof com.appsflyer.internal.ck     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                if (r0 == 0) goto L_0x0127
                java.lang.String r0 = "af_key"
                java.lang.Object r0 = r2.get(r0)     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                goto L_0x012f
            L_0x0127:
                java.lang.String r0 = "appsflyerKey"
                java.lang.Object r0 = r2.get(r0)     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
            L_0x012f:
                com.appsflyer.internal.i r3 = r1.AFInAppEventType     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                r3.AFVersionDeclaration = r0     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                monitor-enter(r2)     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                com.appsflyer.internal.i r3 = r1.AFInAppEventType     // Catch:{ all -> 0x0190 }
                java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0187 }
                r5[r7] = r0     // Catch:{ all -> 0x0187 }
                r0 = 0
                r5[r0] = r3     // Catch:{ all -> 0x0187 }
                int r3 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch:{ all -> 0x0187 }
                int r3 = r3 >> 16
                int r3 = r3 + 24
                int r10 = android.view.KeyEvent.getDeadChar(r0, r0)     // Catch:{ all -> 0x0187 }
                int r10 = r10 + 48
                long r11 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0187 }
                r13 = 0
                int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                int r0 = r0 + 14196
                char r0 = (char) r0     // Catch:{ all -> 0x0187 }
                java.lang.Object r0 = com.appsflyer.internal.e.AFInAppEventParameterName(r3, r10, r0)     // Catch:{ all -> 0x0187 }
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0187 }
                java.lang.String r3 = "AFInAppEventType"
                java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch:{ all -> 0x0187 }
                java.lang.Class<com.appsflyer.internal.i> r10 = com.appsflyer.internal.i.class
                r11 = 0
                r8[r11] = r10     // Catch:{ all -> 0x0187 }
                java.lang.Class<java.lang.String> r10 = java.lang.String.class
                r8[r7] = r10     // Catch:{ all -> 0x0187 }
                java.lang.reflect.Method r0 = r0.getMethod(r3, r8)     // Catch:{ all -> 0x0187 }
                r3 = 0
                java.lang.Object r0 = r0.invoke(r3, r5)     // Catch:{ all -> 0x0187 }
                r3 = r0
                byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0187 }
                monitor-exit(r2)     // Catch:{ all -> 0x0184 }
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this     // Catch:{ IOException -> 0x0180, all -> 0x0193 }
                com.appsflyer.internal.i r2 = r1.AFInAppEventType     // Catch:{ IOException -> 0x0180, all -> 0x0193 }
                r2.AFLogger$LogLevel = r3     // Catch:{ IOException -> 0x0180, all -> 0x0193 }
                com.appsflyer.internal.ac.AFInAppEventType(r0, r2)     // Catch:{ IOException -> 0x0180, all -> 0x0193 }
                return
            L_0x0180:
                r0 = move-exception
                r12 = r0
                r6 = r3
                goto L_0x01ad
            L_0x0184:
                r0 = move-exception
                r6 = r3
                goto L_0x0191
            L_0x0187:
                r0 = move-exception
                java.lang.Throwable r3 = r0.getCause()     // Catch:{ all -> 0x0190 }
                if (r3 == 0) goto L_0x018f
                throw r3     // Catch:{ all -> 0x0190 }
            L_0x018f:
                throw r0     // Catch:{ all -> 0x0190 }
            L_0x0190:
                r0 = move-exception
            L_0x0191:
                monitor-exit(r2)     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
                throw r0     // Catch:{ IOException -> 0x01ab, all -> 0x0193 }
            L_0x0193:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                com.appsflyer.AFLogger.AFInAppEventParameterName(r2, r0)
                com.appsflyer.internal.i r2 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r2 = r2.AFInAppEventParameterName
                if (r2 == 0) goto L_0x01aa
                int r3 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r0 = r0.getMessage()
                r2.onError(r3, r0)
            L_0x01aa:
                return
            L_0x01ab:
                r0 = move-exception
                r12 = r0
            L_0x01ad:
                java.lang.String r0 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.valueOf(r0, r12)
                if (r6 == 0) goto L_0x01d9
                if (r9 == 0) goto L_0x01d9
                java.lang.String r0 = "&isCachedRequest=true&timeincache="
                boolean r0 = r4.contains(r0)
                if (r0 != 0) goto L_0x01d9
                com.appsflyer.internal.ac r0 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.bg r0 = r0.values()
                com.appsflyer.internal.l r0 = r0.AFVersionDeclaration()
                com.appsflyer.internal.n r2 = new com.appsflyer.internal.n
                java.lang.String r3 = "6.5.4"
                r2.<init>(r4, r6, r3)
                r0.AFInAppEventParameterName(r2)
                java.lang.String r0 = r12.getMessage()
                com.appsflyer.AFLogger.valueOf(r0, r12)
            L_0x01d9:
                com.appsflyer.internal.i r0 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.AFInAppEventParameterName
                if (r0 == 0) goto L_0x01e8
                int r2 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r3 = r12.getMessage()
                r0.onError(r2, r3)
            L_0x01e8:
                com.appsflyer.internal.ac r6 = com.appsflyer.internal.ac.this
                com.appsflyer.internal.i r7 = r1.AFInAppEventType
                java.lang.String r8 = r7.AFVersionDeclaration
                android.content.SharedPreferences r10 = com.appsflyer.internal.ac.AFInAppEventType(r9)
                r11 = 0
                com.appsflyer.internal.cg.AFInAppEventType(r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.d.run():void");
        }

        public d(i iVar) {
            this.AFInAppEventType = iVar;
        }
    }

    public class e implements Runnable {
        public final Application AFKeystoreWrapper;

        public e(Context context) {
            this.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }

        public final void run() {
            if (!ac.AFInAppEventType(ac.this)) {
                ac.this.AFVersionDeclaration = System.currentTimeMillis();
                ac.values(ac.this, true);
                try {
                    String devKey = AppsFlyerProperties.getInstance().getDevKey();
                    for (n next : ac.this.values().AFVersionDeclaration().AFInAppEventType()) {
                        StringBuilder sb = new StringBuilder("resending request: ");
                        sb.append(next.valueOf);
                        AFLogger.values(sb.toString());
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            long parseLong = Long.parseLong(next.AFInAppEventParameterName, 10);
                            ac acVar = ac.this;
                            cn cnVar = new cn();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(next.valueOf);
                            sb2.append("&isCachedRequest=true&timeincache=");
                            sb2.append((currentTimeMillis - parseLong) / 1000);
                            i AFInAppEventType2 = cnVar.AFInAppEventType(sb2.toString());
                            AFInAppEventType2.AFLogger$LogLevel = next.AFInAppEventParameterName();
                            AFInAppEventType2.AFVersionDeclaration = devKey;
                            Application application = this.AFKeystoreWrapper;
                            if (application != null) {
                                AFInAppEventType2.AFKeystoreWrapper = (Application) application.getApplicationContext();
                            }
                            AFInAppEventType2.init = next.AFInAppEventParameterName;
                            ac.AFInAppEventType(acVar, AFInAppEventType2);
                        } catch (Exception e2) {
                            AFLogger.valueOf("Failed to resend cached request", e2);
                        }
                    }
                } catch (Exception e3) {
                    AFLogger.valueOf("failed to check cache. ", e3);
                } catch (Throwable th) {
                    ac.values(ac.this, false);
                    throw th;
                }
                ac.values(ac.this, false);
                ac.getLevel(ac.this).shutdown();
                ac.AFInAppEventParameterName(ac.this, (ScheduledExecutorService) null);
            }
        }
    }

    static {
        AFVersionDeclaration();
        StringBuilder sb = new StringBuilder();
        sb.append(AFInAppEventType);
        sb.append("/androidevent?buildnumber=6.5.4&app_id=");
        values = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb2.append(AFInAppEventType);
        sb2.append("/android?buildnumber=6.5.4&app_id=");
        onInstallConversionFailureNative = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(AFInAppEventType);
        sb3.append("/androidevent?app_id=");
        onInstallConversionDataLoadedNative = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%sconversions.%s/api/v");
        sb4.append(onInstallConversionDataLoadedNative);
        onDeepLinkingNative = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%slaunches.%s/api/v");
        sb5.append(onInstallConversionDataLoadedNative);
        onAppOpenAttributionNative = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%sinapps.%s/api/v");
        sb6.append(onInstallConversionDataLoadedNative);
        onAttributionFailureNative = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sattr.%s/api/v");
        sb7.append(onInstallConversionDataLoadedNative);
        onResponseErrorNative = sb7.toString();
        int i = setCustomerIdAndLogSession + 29;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
    }

    public ac() {
        AFVersionDeclaration.init();
        this.setCustomerUserId = new bf();
    }

    public static /* synthetic */ Application AFInAppEventParameterName(ac acVar) {
        int i = setCustomerIdAndLogSession + 39;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        Application application = acVar.stop;
        int i3 = waitForCustomerUserId + 27;
        setCustomerIdAndLogSession = i3 % 128;
        if (i3 % 2 != 0) {
            return application;
        }
        int i4 = 86 / 0;
        return application;
    }

    public static /* synthetic */ void AFInAppEventType(ac acVar, i iVar) throws IOException {
        int i = setCustomerIdAndLogSession + 35;
        waitForCustomerUserId = i % 128;
        boolean z = i % 2 != 0;
        acVar.AFInAppEventParameterName(iVar);
        if (z) {
            throw null;
        }
    }

    public static /* synthetic */ Map AFKeystoreWrapper(ac acVar) {
        int i = waitForCustomerUserId + 113;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        Map<String, Object> map = acVar.updateServerUninstallToken;
        int i3 = setCustomerIdAndLogSession + 87;
        waitForCustomerUserId = i3 % 128;
        if (i3 % 2 == 0) {
            return map;
        }
        throw null;
    }

    private boolean AFLogger$LogLevel() {
        int i = setCustomerIdAndLogSession + 25;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if ((this.updateServerUninstallToken != null ? '9' : 'X') != 'X') {
            if (!(this.updateServerUninstallToken.isEmpty())) {
                int i3 = setCustomerIdAndLogSession + 1;
                waitForCustomerUserId = i3 % 128;
                int i4 = i3 % 2;
                return true;
            }
        }
        int i5 = waitForCustomerUserId + 85;
        setCustomerIdAndLogSession = i5 % 128;
        int i6 = i5 % 2;
        return false;
    }

    public static void AFVersionDeclaration() {
        enableLocationCollection = -8666534478441341805L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean AFVersionDeclaration(android.content.Context r4) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            r1 = 60
            if (r0 != 0) goto L_0x0012
            r0 = 81
            goto L_0x0014
        L_0x0012:
            r0 = 60
        L_0x0014:
            r3 = 1
            if (r0 == r1) goto L_0x003d
            int r0 = waitForCustomerUserId
            int r0 = r0 + 41
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            java.lang.String r1 = "collectIMEIForceByUser"
            if (r0 != 0) goto L_0x0030
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x0030:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r0 = 0
            goto L_0x0048
        L_0x003d:
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 5
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r0 = 1
        L_0x0048:
            r1 = 31
            if (r0 != 0) goto L_0x004f
            r0 = 9
            goto L_0x0051
        L_0x004f:
            r0 = 31
        L_0x0051:
            if (r0 == r1) goto L_0x005b
            boolean r4 = init(r4)
            if (r4 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            return r2
        L_0x005b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFVersionDeclaration(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if ((r5.getPackageManager().getPackageInfo(r5.getPackageName(), 0).applicationInfo.flags & 32768) != 0) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void AppsFlyer2dXConversionCallback(android.content.Context r5) {
        /*
            int r0 = waitForCustomerUserId
            int r0 = r0 + 79
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            r3 = 32768(0x8000, float:4.5918E-41)
            if (r0 == 0) goto L_0x0033
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0077 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r2)     // Catch:{ Exception -> 0x0077 }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ Exception -> 0x0077 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x0077 }
            r0 = r0 & r3
            r3 = 98
            if (r0 == 0) goto L_0x002e
            r0 = 75
            goto L_0x0030
        L_0x002e:
            r0 = 98
        L_0x0030:
            if (r0 == r3) goto L_0x0063
            goto L_0x0046
        L_0x0033:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0077 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r2)     // Catch:{ Exception -> 0x0077 }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ Exception -> 0x0077 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x0077 }
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0063
        L_0x0046:
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = "appsflyer_backup_rules"
            java.lang.String r4 = "xml"
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x0077 }
            int r5 = r0.getIdentifier(r3, r4, r5)     // Catch:{ Exception -> 0x0077 }
            if (r5 == 0) goto L_0x005e
            java.lang.String r5 = "appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data"
            com.appsflyer.AFLogger.values(r5, r1)     // Catch:{ Exception -> 0x0077 }
            return
        L_0x005e:
            java.lang.String r5 = "'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules"
            com.appsflyer.AFLogger.valueOf(r5)     // Catch:{ Exception -> 0x0077 }
        L_0x0063:
            int r5 = waitForCustomerUserId
            int r5 = r5 + 13
            int r0 = r5 % 128
            setCustomerIdAndLogSession = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0070
            r1 = 0
        L_0x0070:
            if (r1 == 0) goto L_0x0073
            return
        L_0x0073:
            r5 = 0
            throw r5     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r5 = move-exception
            throw r5
        L_0x0077:
            r5 = move-exception
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "checkBackupRules Exception: "
            java.lang.String r5 = r0.concat(r5)
            com.appsflyer.AFLogger.AFKeystoreWrapper(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AppsFlyer2dXConversionCallback(android.content.Context):void");
    }

    public static /* synthetic */ ScheduledExecutorService getLevel(ac acVar) {
        int i = waitForCustomerUserId + 47;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        ScheduledExecutorService scheduledExecutorService = acVar.onAttributionFailure;
        int i3 = waitForCustomerUserId + 69;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return scheduledExecutorService;
    }

    private long onAppOpenAttribution(Context context) {
        int i = setCustomerIdAndLogSession + 51;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        long j = AFInAppEventType(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0);
        long currentTimeMillis = System.currentTimeMillis();
        AFInAppEventType(context, (String) "AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
        if ((j > 0 ? (char) 24 : 0) == 0) {
            return -1;
        }
        long j2 = currentTimeMillis - j;
        int i3 = waitForCustomerUserId + 33;
        setCustomerIdAndLogSession = i3 % 128;
        return (i3 % 2 == 0 ? '%' : 31) != '%' ? j2 / 1000 : j2 - 1000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if ((!r7.onResponseError) != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r7.onResponseError == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onAppOpenAttributionNative(android.content.Context r8) {
        /*
            r7 = this;
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 81
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 87
            if (r0 == 0) goto L_0x0011
            r0 = 87
            goto L_0x0013
        L_0x0011:
            r0 = 13
        L_0x0013:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x001c
            boolean r0 = r7.onResponseError
            if (r0 != 0) goto L_0x0070
            goto L_0x0028
        L_0x001c:
            boolean r0 = r7.onResponseError
            r1 = 67
            int r1 = r1 / r3
            if (r0 != 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x0070
        L_0x0028:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r7.AFVersionDeclaration
            long r0 = r0 - r4
            r4 = 15000(0x3a98, double:7.411E-320)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0036
            goto L_0x0070
        L_0x0036:
            java.util.concurrent.ScheduledExecutorService r0 = r7.onAttributionFailure
            if (r0 == 0) goto L_0x004e
            int r8 = setCustomerIdAndLogSession
            int r8 = r8 + 61
            int r0 = r8 % 128
            waitForCustomerUserId = r0
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0047
            r2 = 0
        L_0x0047:
            if (r2 == 0) goto L_0x004a
            return
        L_0x004a:
            r8 = 0
            throw r8     // Catch:{ all -> 0x004c }
        L_0x004c:
            r8 = move-exception
            throw r8
        L_0x004e:
            com.appsflyer.internal.k r0 = com.appsflyer.internal.k.values
            if (r0 != 0) goto L_0x0059
            com.appsflyer.internal.k r0 = new com.appsflyer.internal.k
            r0.<init>()
            com.appsflyer.internal.k.values = r0
        L_0x0059:
            com.appsflyer.internal.k r0 = com.appsflyer.internal.k.values
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.AFKeystoreWrapper()
            r7.onAttributionFailure = r0
            com.appsflyer.internal.ac$e r0 = new com.appsflyer.internal.ac$e
            r0.<init>(r8)
            java.util.concurrent.ScheduledExecutorService r8 = r7.onAttributionFailure
            r1 = 1
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            valueOf(r8, r0, r1, r3)
            return
        L_0x0070:
            int r8 = waitForCustomerUserId
            int r8 = r8 + 55
            int r0 = r8 % 128
            setCustomerIdAndLogSession = r0
            int r8 = r8 % 2
            if (r8 != 0) goto L_0x007e
            r8 = 0
            goto L_0x007f
        L_0x007e:
            r8 = 1
        L_0x007f:
            if (r8 == r2) goto L_0x0087
            r8 = 94
            int r8 = r8 / r3
            return
        L_0x0085:
            r8 = move-exception
            throw r8
        L_0x0087:
            return
        L_0x0088:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.onAppOpenAttributionNative(android.content.Context):void");
    }

    private String onAttributionFailureNative(Context context) {
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        String AFInAppEventParameterName2 = AFInAppEventParameterName((String) "preInstallName");
        if (AFInAppEventParameterName2 != null) {
            int i = setCustomerIdAndLogSession + 65;
            waitForCustomerUserId = i % 128;
            int i2 = i % 2;
            return AFInAppEventParameterName2;
        }
        if ((AFInAppEventType2.contains("preInstallName") ? 20 : 'B') != 20) {
            if (AFKeystoreWrapper(context)) {
                AFInAppEventParameterName2 = onInstallConversionFailureNative(context);
                if ((AFInAppEventParameterName2 != null ? 7 : 'Z') != 7) {
                    AFInAppEventParameterName2 = AFKeystoreWrapper(context, (String) "AF_PRE_INSTALL_NAME");
                    int i3 = waitForCustomerUserId + 57;
                    setCustomerIdAndLogSession = i3 % 128;
                    int i4 = i3 % 2;
                }
            }
            if (AFInAppEventParameterName2 != null) {
                int i5 = waitForCustomerUserId + 3;
                setCustomerIdAndLogSession = i5 % 128;
                char c2 = i5 % 2 == 0 ? '7' : '.';
                valueOf(context, (String) "preInstallName", AFInAppEventParameterName2);
                if (c2 == '7') {
                    throw null;
                }
            }
        } else {
            AFInAppEventParameterName2 = AFInAppEventType2.getString("preInstallName", null);
        }
        if (AFInAppEventParameterName2 != null) {
            values((String) "preInstallName", AFInAppEventParameterName2);
        }
        return AFInAppEventParameterName2;
    }

    public static boolean onConversionDataSuccess(Context context) {
        if (context != null) {
            if (VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            int i2 = waitForCustomerUserId + 59;
                            setCustomerIdAndLogSession = i2 % 128;
                            int i3 = i2 % 2;
                            return false;
                        }
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i]);
                        if ((networkCapabilities.hasTransport(4) ? 10 : 'Q') != 'Q') {
                            int i4 = waitForCustomerUserId + 19;
                            setCustomerIdAndLogSession = i4 % 128;
                            int i5 = i4 % 2;
                            if ((!networkCapabilities.hasCapability(15) ? 14 : ':') != ':') {
                                int i6 = waitForCustomerUserId + 87;
                                setCustomerIdAndLogSession = i6 % 128;
                                if (i6 % 2 != 0) {
                                    return true;
                                }
                                throw null;
                            }
                        }
                        i++;
                    }
                } catch (Exception e2) {
                    AFLogger.valueOf("Failed collecting ivc data", e2);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e3) {
                    AFLogger.valueOf("Failed collecting ivc data", e3);
                }
            }
        }
        return false;
    }

    private String onDeepLinkingNative(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            int i = waitForCustomerUserId + 35;
            setCustomerIdAndLogSession = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = setCustomerIdAndLogSession + 91;
                waitForCustomerUserId = i2 % 128;
                if ((i2 % 2 != 0 ? '>' : 25) != '>') {
                    return string;
                }
                throw null;
            }
            throw null;
        }
        String AFKeystoreWrapper2 = AFKeystoreWrapper(context, (String) "AF_STORE");
        int i3 = waitForCustomerUserId + 121;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return AFKeystoreWrapper2;
    }

    private String onInstallConversionDataLoadedNative(Context context) {
        int i = setCustomerIdAndLogSession + 85;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        String str = null;
        if ((AFInAppEventType2.contains("INSTALL_STORE") ? '_' : 22) != '_') {
            if (AFKeystoreWrapper(context)) {
                str = onDeepLinkingNative(context);
            } else {
                int i3 = waitForCustomerUserId + 93;
                setCustomerIdAndLogSession = i3 % 128;
                int i4 = i3 % 2;
            }
            valueOf(context, (String) "INSTALL_STORE", str);
            return str;
        }
        String string = AFInAppEventType2.getString("INSTALL_STORE", null);
        int i5 = waitForCustomerUserId + 5;
        setCustomerIdAndLogSession = i5 % 128;
        int i6 = i5 % 2;
        return string;
    }

    private String onInstallConversionFailureNative(Context context) {
        int i = waitForCustomerUserId + 17;
        setCustomerIdAndLogSession = i % 128;
        if (i % 2 != 0) {
            File AFLogger$LogLevel2 = AFLogger$LogLevel(values((String) "ro.appsflyer.preinstall.path"));
            if (AFInAppEventType(AFLogger$LogLevel2)) {
                AFLogger$LogLevel2 = AFLogger$LogLevel(AFKeystoreWrapper(context, (String) "AF_PRE_INSTALL_PATH"));
            }
            if (!(!AFInAppEventType(AFLogger$LogLevel2))) {
                int i2 = setCustomerIdAndLogSession + 51;
                waitForCustomerUserId = i2 % 128;
                if ((i2 % 2 != 0 ? 'D' : '1') == '1') {
                    AFLogger$LogLevel2 = AFLogger$LogLevel((String) "/data/local/tmp/pre_install.appsflyer");
                } else {
                    AFLogger$LogLevel((String) "/data/local/tmp/pre_install.appsflyer");
                    throw null;
                }
            }
            if (AFInAppEventType(AFLogger$LogLevel2)) {
                AFLogger$LogLevel2 = AFLogger$LogLevel((String) "/etc/pre_install.appsflyer");
            }
            if ((AFInAppEventType(AFLogger$LogLevel2) ? 24 : 'Q') == 'Q') {
                return values(AFLogger$LogLevel2, context.getPackageName());
            }
            int i3 = waitForCustomerUserId + 47;
            setCustomerIdAndLogSession = i3 % 128;
            if (i3 % 2 != 0) {
                return null;
            }
            throw null;
        }
        AFInAppEventType(AFLogger$LogLevel(values((String) "ro.appsflyer.preinstall.path")));
        throw null;
    }

    public static float onResponseNative(Context context) {
        float f2 = 1.0f;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            boolean z = false;
            if (!(intExtra == -1)) {
                int i = waitForCustomerUserId + 83;
                setCustomerIdAndLogSession = i % 128;
                int i2 = i % 2;
                if (intExtra2 != -1) {
                    z = true;
                }
                if (z) {
                    f2 = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
                    int i3 = setCustomerIdAndLogSession + 93;
                    waitForCustomerUserId = i3 % 128;
                    int i4 = i3 % 2;
                    int i5 = setCustomerIdAndLogSession + 117;
                    waitForCustomerUserId = i5 % 128;
                    int i6 = i5 % 2;
                    return f2;
                }
            }
            return 50.0f;
        } catch (Throwable th) {
            AFLogger.valueOf(th.getMessage(), th);
        }
    }

    public static /* synthetic */ dc valueOf(ac acVar) {
        int i = setCustomerIdAndLogSession + 13;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        dc dcVar = acVar.setAndroidIdData;
        int i3 = waitForCustomerUserId + 121;
        setCustomerIdAndLogSession = i3 % 128;
        if ((i3 % 2 == 0 ? '(' : 31) != '(') {
            return dcVar;
        }
        int i4 = 28 / 0;
        return dcVar;
    }

    public static /* synthetic */ bf values(ac acVar) {
        int i = setCustomerIdAndLogSession + 103;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        bf bfVar = acVar.setCustomerUserId;
        int i3 = setCustomerIdAndLogSession + 45;
        waitForCustomerUserId = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return bfVar;
        }
        throw null;
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        int i = waitForCustomerUserId + 57;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        List asList = Arrays.asList(strArr);
        List<List<String>> list = f.valueOf().init;
        if ((!list.contains(asList) ? (char) 20 : 28) == 20) {
            list.add(asList);
        }
        int i3 = waitForCustomerUserId + 111;
        setCustomerIdAndLogSession = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 53 / 0;
        }
    }

    public final void anonymizeUser(boolean z) {
        int i = setCustomerIdAndLogSession + 117;
        waitForCustomerUserId = i % 128;
        boolean z2 = false;
        if (i % 2 != 0) {
            ak AFInAppEventType2 = ak.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z);
            AFInAppEventType2.AFKeystoreWrapper("anonymizeUser", strArr);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("anonymizeUser", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set((String) AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
        int i2 = waitForCustomerUserId + 75;
        setCustomerIdAndLogSession = i2 % 128;
        if (i2 % 2 != 0) {
            z2 = true;
        }
        if (!z2) {
            throw null;
        }
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i = waitForCustomerUserId + 75;
        setCustomerIdAndLogSession = i % 128;
        if (i % 2 == 0) {
            f valueOf2 = f.valueOf();
            valueOf2.AFVersionDeclaration = str;
            valueOf2.getLevel = map;
            int i2 = 9 / 0;
            return;
        }
        f valueOf3 = f.valueOf();
        valueOf3.AFVersionDeclaration = str;
        valueOf3.getLevel = map;
    }

    public final void enableFacebookDeferredApplinks(boolean z) {
        int i = setCustomerIdAndLogSession + 85;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        this.setDebugLog = z;
        int i3 = setCustomerIdAndLogSession + 111;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 6 : '@') == 6) {
            int i4 = 73 / 0;
        }
    }

    public final AppsFlyerLib enableLocationCollection(boolean z) {
        int i = waitForCustomerUserId + 19;
        setCustomerIdAndLogSession = i % 128;
        if (!(i % 2 != 0)) {
            this.AppsFlyerConversionListener = z;
            int i2 = 73 / 0;
        } else {
            this.AppsFlyerConversionListener = z;
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r6 == null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        return com.appsflyer.internal.af.valueOf(new java.lang.ref.WeakReference(new com.appsflyer.internal.aa(r6).AFInAppEventParameterName));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r1 != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAppsFlyerUID(android.content.Context r6) {
        /*
            r5 = this;
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 25
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            java.lang.String r3 = "getAppsFlyerUID"
            if (r0 == 0) goto L_0x0025
            com.appsflyer.internal.ak r0 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r4 = new java.lang.String[r2]
            r0.AFKeystoreWrapper(r3, r4)
            if (r6 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r1 == 0) goto L_0x0041
            goto L_0x0030
        L_0x0025:
            com.appsflyer.internal.ak r0 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r1 = new java.lang.String[r2]
            r0.AFKeystoreWrapper(r3, r1)
            if (r6 != 0) goto L_0x0041
        L_0x0030:
            int r6 = waitForCustomerUserId
            int r6 = r6 + 3
            int r0 = r6 % 128
            setCustomerIdAndLogSession = r0
            int r6 = r6 % 2
            r0 = 0
            if (r6 == 0) goto L_0x003e
            return r0
        L_0x003e:
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r6 = move-exception
            throw r6
        L_0x0041:
            com.appsflyer.internal.aa r0 = new com.appsflyer.internal.aa
            r0.<init>(r6)
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            android.content.Context r0 = r0.AFInAppEventParameterName
            r6.<init>(r0)
            java.lang.String r6 = com.appsflyer.internal.af.valueOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.getAppsFlyerUID(android.content.Context):java.lang.String");
    }

    public final String getAttributionId(Context context) {
        try {
            String AFInAppEventParameterName2 = new ae(context).AFInAppEventParameterName();
            int i = waitForCustomerUserId + 19;
            setCustomerIdAndLogSession = i % 128;
            int i2 = i % 2;
            return AFInAppEventParameterName2;
        } catch (Throwable th) {
            AFLogger.valueOf("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public final String getHostName() {
        int i = waitForCustomerUserId + 93;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        String AFInAppEventParameterName2 = AFInAppEventParameterName((String) "custom_host");
        if (!(AFInAppEventParameterName2 != null)) {
            return "appsflyer.com";
        }
        int i3 = waitForCustomerUserId + 3;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        int i5 = setCustomerIdAndLogSession + 41;
        waitForCustomerUserId = i5 % 128;
        if ((i5 % 2 != 0 ? 'Y' : '4') != 'Y') {
            return AFInAppEventParameterName2;
        }
        try {
            int i6 = 76 / 0;
            return AFInAppEventParameterName2;
        }
    }

    public final String getHostPrefix() {
        int i = waitForCustomerUserId + 95;
        setCustomerIdAndLogSession = i % 128;
        if (i % 2 != 0) {
            String AFInAppEventParameterName2 = AFInAppEventParameterName((String) "custom_host_prefix");
            if ((AFInAppEventParameterName2 != null ? (char) 1 : 26) != 1) {
                return "";
            }
            int i2 = setCustomerIdAndLogSession + 119;
            waitForCustomerUserId = i2 % 128;
            int i3 = i2 % 2;
            return AFInAppEventParameterName2;
        }
        AFInAppEventParameterName((String) "custom_host_prefix");
        throw null;
    }

    public final String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        boolean z = false;
        if (string != null) {
            int i = setCustomerIdAndLogSession + 49;
            waitForCustomerUserId = i % 128;
            if ((i % 2 != 0 ? '-' : '5') == '5') {
                return string;
            }
            int i2 = 46 / 0;
            return string;
        }
        String AFKeystoreWrapper2 = AFKeystoreWrapper(context, (String) "AF_STORE");
        if (AFKeystoreWrapper2 != null) {
            z = true;
        }
        if (!z) {
            AFLogger.values((String) "No out-of-store value set");
            return null;
        }
        int i3 = setCustomerIdAndLogSession + 121;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
        int i5 = waitForCustomerUserId + 27;
        setCustomerIdAndLogSession = i5 % 128;
        int i6 = i5 % 2;
        return AFKeystoreWrapper2;
    }

    public final String getSdkVersion() {
        ak.AFInAppEventType().AFKeystoreWrapper("getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 6.5.4 (build ");
        sb.append(valueOf);
        sb.append(")");
        String obj = sb.toString();
        int i = waitForCustomerUserId + 9;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        return obj;
    }

    public final AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        int i = setCustomerIdAndLogSession + 13;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if ((this.AppsFlyerInAppPurchaseValidatorListener ? '.' : 'a') != 'a') {
            return this;
        }
        this.AppsFlyerInAppPurchaseValidatorListener = true;
        AppsFlyerProperties.getInstance().setDevKey(str);
        ai.AFInAppEventType(str);
        if (context != null) {
            int i3 = waitForCustomerUserId + 113;
            setCustomerIdAndLogSession = i3 % 128;
            int i4 = i3 % 2;
            this.stop = (Application) context.getApplicationContext();
            this.setCustomerUserId.AFKeystoreWrapper.values = context.getApplicationContext();
            int i5 = setCustomerIdAndLogSession + 87;
            waitForCustomerUserId = i5 % 128;
            int i6 = i5 % 2;
            values().getLevel().AFInAppEventType = System.currentTimeMillis();
            values().values().values(null);
            de AFLogger$LogLevel2 = values().AFLogger$LogLevel();
            final cx cxVar = new cx(new Runnable() {
                public final void run() {
                    if (k.values == null) {
                        k.values = new k();
                    }
                    ac.valueOf(k.values.AFKeystoreWrapper(), new Runnable() {
                        public final void run() {
                            try {
                                ci ciVar = new ci();
                                Application AFInAppEventParameterName = ac.AFInAppEventParameterName(ac.this);
                                if (AFInAppEventParameterName != null) {
                                    ciVar.AFKeystoreWrapper = (Application) AFInAppEventParameterName.getApplicationContext();
                                }
                                if (ac.AFInAppEventParameterName(ac.this, (i) ciVar, ac.AFInAppEventType((Context) ac.AFInAppEventParameterName(ac.this)))) {
                                    ac.AFInAppEventParameterName(ac.this, (i) ciVar);
                                }
                            } catch (Throwable th) {
                                AFLogger.valueOf(th.getMessage(), th);
                            }
                        }
                    }, 0, TimeUnit.MILLISECONDS);
                }
            });
            AnonymousClass2 r7 = new Runnable() {
                public final void run() {
                    SharedPreferences AFInAppEventType2 = ac.AFInAppEventType((Context) ac.AFInAppEventParameterName(ac.this));
                    boolean z = false;
                    int valueOf2 = ac.this.valueOf(AFInAppEventType2, false);
                    boolean z2 = AFInAppEventType2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
                    if (cxVar.AFInAppEventParameterName == com.appsflyer.internal.dd.d.NOT_STARTED) {
                        z = true;
                    }
                    if (valueOf2 != 1) {
                        return;
                    }
                    if (z || z2) {
                        ac acVar = ac.this;
                        ci ciVar = new ci();
                        Application AFInAppEventParameterName = ac.AFInAppEventParameterName(ac.this);
                        if (AFInAppEventParameterName != null) {
                            ciVar.AFKeystoreWrapper = (Application) AFInAppEventParameterName.getApplicationContext();
                        }
                        ac.AFInAppEventParameterName(acVar, (i) ciVar);
                    }
                }
            };
            AFLogger$LogLevel2.AFKeystoreWrapper(cxVar);
            AFLogger$LogLevel2.AFKeystoreWrapper(new cy(r7));
            AFLogger$LogLevel2.AFKeystoreWrapper(new df(r7));
            dd[] AFInAppEventType2 = AFLogger$LogLevel2.AFInAppEventType();
            int length = AFInAppEventType2.length;
            int i7 = 0;
            while (true) {
                if ((i7 < length ? '9' : 'a') != '9') {
                    break;
                }
                int i8 = setCustomerIdAndLogSession + 19;
                waitForCustomerUserId = i8 % 128;
                if (!(i8 % 2 == 0)) {
                    AFInAppEventType2[i7].AFInAppEventParameterName(this.stop);
                    i7 += 46;
                } else {
                    AFInAppEventType2[i7].AFInAppEventParameterName(this.stop);
                    i7++;
                }
            }
            this.setCustomerUserId.init().values();
            ay.AFInAppEventParameterName = this.stop;
            if ((valueOf(AFInAppEventType(context), false) == 0 ? (char) 14 : 9) != 9 && VERSION.SDK_INT >= 29) {
                dc dcVar = new dc(context);
                this.setAndroidIdData = dcVar;
                new Thread(dcVar.AFInAppEventParameterName).start();
            }
        } else {
            AFLogger.AppsFlyer2dXConversionCallback("context is null, Google Install Referrer will be not initialized");
        }
        ak AFInAppEventType3 = ak.AFInAppEventType();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = !(appsFlyerConversionListener != null) ? "null" : "conversionDataListener";
        AFInAppEventType3.AFKeystoreWrapper(AnalyticsConstants.INIT, strArr);
        AFLogger.AFInAppEventType(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.5.4", valueOf}));
        AFKeystoreWrapper = appsFlyerConversionListener;
        int i9 = waitForCustomerUserId + 7;
        setCustomerIdAndLogSession = i9 % 128;
        if (i9 % 2 != 0) {
            return this;
        }
        throw null;
    }

    public final boolean isPreInstalledApp(Context context) {
        try {
            if (((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0 ? '[' : '\\') == '[') {
                int i = setCustomerIdAndLogSession + 97;
                waitForCustomerUserId = i % 128;
                if ((i % 2 != 0 ? 'P' : '1') != 'P') {
                    return true;
                }
                return false;
            }
        } catch (NameNotFoundException e2) {
            AFLogger.valueOf("Could not check if app is pre installed", e2);
        }
        int i2 = waitForCustomerUserId + 109;
        setCustomerIdAndLogSession = i2 % 128;
        int i3 = i2 % 2;
        return false;
    }

    public final boolean isStopped() {
        int i = waitForCustomerUserId + 59;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        boolean z = this.getInstance;
        int i3 = setCustomerIdAndLogSession + 123;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : '0') == '0') {
            return z;
        }
        throw null;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i = setCustomerIdAndLogSession + 69;
        waitForCustomerUserId = i % 128;
        boolean z = i % 2 != 0;
        logEvent(context, str, map, null);
        if (z) {
            int i2 = 16 / 0;
        }
        int i3 = setCustomerIdAndLogSession + 61;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 'U' : 26) == 'U') {
            throw null;
        }
    }

    public final void logLocation(Context context, double d2, double d3) {
        boolean z = false;
        ak.AFInAppEventType().AFKeystoreWrapper("logLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        AFInAppEventParameterName(context, (String) AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
        int i = setCustomerIdAndLogSession + 65;
        waitForCustomerUserId = i % 128;
        if (i % 2 == 0) {
            z = true;
        }
        if (!z) {
            throw null;
        }
    }

    public final void logSession(Context context) {
        int i = waitForCustomerUserId + 51;
        setCustomerIdAndLogSession = i % 128;
        if (!(i % 2 != 0)) {
            ak.AFInAppEventType().AFKeystoreWrapper("logSession", new String[1]);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("logSession", new String[0]);
        }
        ak.AFInAppEventType().getLevel();
        AFInAppEventParameterName(context, ch.logSession);
        AFInAppEventParameterName(context, (String) null, (Map<String, Object>) null);
    }

    public final void onPause(Context context) {
        int i = setCustomerIdAndLogSession + 65;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if ((ah.AFInAppEventParameterName != null ? '?' : '2') == '?') {
            int i3 = setCustomerIdAndLogSession + 109;
            waitForCustomerUserId = i3 % 128;
            if (!(i3 % 2 == 0)) {
                ah.AFInAppEventParameterName.valueOf(context);
                int i4 = 13 / 0;
                return;
            }
            ah.AFInAppEventParameterName.valueOf(context);
        }
    }

    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        if ((uri != null ? '?' : '-') == '?') {
            int i = setCustomerIdAndLogSession + 49;
            waitForCustomerUserId = i % 128;
            if (i % 2 != 0) {
                uri.toString().isEmpty();
                throw null;
            } else if (!uri.toString().isEmpty()) {
                if (context == null) {
                    StringBuilder sb = new StringBuilder("Context is \"");
                    sb.append(context);
                    sb.append("\"");
                    ao.AFInAppEventType(sb.toString(), Error.NETWORK);
                    return;
                }
                f.valueOf().AFInAppEventType(context, new HashMap(), Uri.parse(uri.toString()));
                int i2 = waitForCustomerUserId + 121;
                setCustomerIdAndLogSession = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder("Link is \"");
        sb2.append(uri);
        sb2.append("\"");
        ao.AFInAppEventType(sb2.toString(), Error.NETWORK);
    }

    public final void performOnDeepLinking(final Intent intent, Context context) {
        int i = setCustomerIdAndLogSession + 33;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if (intent == null) {
            int i3 = setCustomerIdAndLogSession + 65;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
            ao.AFInAppEventType("performOnDeepLinking was called with null intent", Error.DEVELOPER_ERROR);
        } else if (context == null) {
            int i5 = setCustomerIdAndLogSession + 95;
            waitForCustomerUserId = i5 % 128;
            int i6 = i5 % 2;
            ao.AFInAppEventType("performOnDeepLinking was called with null context", Error.DEVELOPER_ERROR);
        } else {
            final Context applicationContext = context.getApplicationContext();
            bf bfVar = this.setCustomerUserId;
            if ((applicationContext != null ? 3 : 'J') != 'J') {
                int i7 = waitForCustomerUserId + 113;
                setCustomerIdAndLogSession = i7 % 128;
                int i8 = i7 % 2;
                be beVar = bfVar.AFKeystoreWrapper;
                if (!(applicationContext == null)) {
                    int i9 = setCustomerIdAndLogSession + 67;
                    waitForCustomerUserId = i9 % 128;
                    if (i9 % 2 != 0) {
                        beVar.values = applicationContext.getApplicationContext();
                        int i10 = 59 / 0;
                    } else {
                        beVar.values = applicationContext.getApplicationContext();
                    }
                    int i11 = waitForCustomerUserId + 5;
                    setCustomerIdAndLogSession = i11 % 128;
                    int i12 = i11 % 2;
                }
            }
            final cl level = values().getLevel();
            this.setOaidData.execute(new Runnable() {
                public final void run() {
                    f.valueOf();
                    Intent intent = intent;
                    Context context = applicationContext;
                    cl clVar = level;
                    Context context2 = ac.values(ac.this).AFKeystoreWrapper.values;
                    if (context2 != null) {
                        bc bcVar = new bc(ac.AFInAppEventType(context2));
                        Uri AFKeystoreWrapper2 = f.AFKeystoreWrapper(intent);
                        boolean z = AFKeystoreWrapper2 != null && !AFKeystoreWrapper2.toString().isEmpty();
                        if (!ac.AFInAppEventType(context).getBoolean("ddl_sent", false) || z) {
                            f.valueOf().valueOf(new HashMap(), clVar, intent, bcVar, context);
                        } else {
                            ao.AFInAppEventType("No direct deep link", null);
                        }
                    } else {
                        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                    }
                }
            });
            int i13 = waitForCustomerUserId + 1;
            setCustomerIdAndLogSession = i13 % 128;
            int i14 = i13 % 2;
        }
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = setCustomerIdAndLogSession + 39;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? (char) 26 : 17) != 26) {
            ak.AFInAppEventType().AFKeystoreWrapper("registerConversionListener", new String[0]);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("registerConversionListener", new String[0]);
        }
        values(appsFlyerConversionListener);
        int i2 = waitForCustomerUserId + 73;
        setCustomerIdAndLogSession = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        int i = waitForCustomerUserId + 97;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("registerValidatorListener", new String[0]);
        AFLogger.AFInAppEventParameterName("registerValidatorListener called");
        if ((appsFlyerInAppPurchaseValidatorListener == null ? (char) 7 : 10) != 7) {
            AFInAppEventParameterName = appsFlyerInAppPurchaseValidatorListener;
            return;
        }
        int i3 = waitForCustomerUserId + 67;
        setCustomerIdAndLogSession = i3 % 128;
        char c2 = i3 % 2 == 0 ? 'O' : 'D';
        AFLogger.AFInAppEventParameterName("registerValidatorListener null listener");
        if (c2 == 'O') {
            int i4 = 69 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r5 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if ((r5 != null ? '`' : 'R') != '`') goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendAdRevenue(android.content.Context r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            int r0 = waitForCustomerUserId
            int r0 = r0 + 35
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L_0x0020
            com.appsflyer.internal.bf r0 = r4.setCustomerUserId
            r2 = 18
            int r2 = r2 / r1
            r2 = 96
            if (r5 == 0) goto L_0x0019
            r3 = 96
            goto L_0x001b
        L_0x0019:
            r3 = 82
        L_0x001b:
            if (r3 == r2) goto L_0x0024
            goto L_0x004e
        L_0x001e:
            r5 = move-exception
            throw r5
        L_0x0020:
            com.appsflyer.internal.bf r0 = r4.setCustomerUserId
            if (r5 == 0) goto L_0x004e
        L_0x0024:
            int r2 = setCustomerIdAndLogSession
            int r2 = r2 + 65
            int r3 = r2 % 128
            waitForCustomerUserId = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0031
            r1 = 1
        L_0x0031:
            if (r1 != 0) goto L_0x0048
            com.appsflyer.internal.be r0 = r0.AFKeystoreWrapper
            r1 = 43
            if (r5 == 0) goto L_0x003c
            r2 = 43
            goto L_0x003e
        L_0x003c:
            r2 = 22
        L_0x003e:
            if (r2 == r1) goto L_0x0041
            goto L_0x004e
        L_0x0041:
            android.content.Context r1 = r5.getApplicationContext()
            r0.values = r1
            goto L_0x004e
        L_0x0048:
            com.appsflyer.internal.be r5 = r0.AFKeystoreWrapper
            r5 = 0
            throw r5     // Catch:{ all -> 0x004c }
        L_0x004c:
            r5 = move-exception
            throw r5
        L_0x004e:
            com.appsflyer.internal.ck r0 = new com.appsflyer.internal.ck
            r0.<init>()
            if (r5 == 0) goto L_0x0067
            int r1 = setCustomerIdAndLogSession
            int r1 = r1 + 29
            int r2 = r1 % 128
            waitForCustomerUserId = r2
            int r1 = r1 % 2
            android.content.Context r5 = r5.getApplicationContext()
            android.app.Application r5 = (android.app.Application) r5
            r0.AFKeystoreWrapper = r5
        L_0x0067:
            r0.values = r6
            r4.AFKeystoreWrapper(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.sendAdRevenue(android.content.Context, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r17.getIntent() != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r17.getIntent() != null) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            int r3 = setCustomerIdAndLogSession
            int r3 = r3 + 81
            int r4 = r3 % 128
            waitForCustomerUserId = r4
            r4 = 2
            int r3 = r3 % r4
            r3 = 1
            java.lang.String r5 = "sendPushNotificationData"
            r6 = 0
            if (r17 == 0) goto L_0x0065
            int r7 = waitForCustomerUserId
            int r7 = r7 + 43
            int r8 = r7 % 128
            setCustomerIdAndLogSession = r8
            int r7 = r7 % r4
            if (r7 != 0) goto L_0x002e
            android.content.Intent r7 = r17.getIntent()
            r8 = 41
            int r8 = r8 / r6
            if (r7 == 0) goto L_0x0065
            goto L_0x0034
        L_0x002b:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x002e:
            android.content.Intent r7 = r17.getIntent()
            if (r7 == 0) goto L_0x0065
        L_0x0034:
            com.appsflyer.internal.ak r7 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r8 = new java.lang.String[r4]
            java.lang.String r9 = r17.getLocalClassName()
            r8[r6] = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "activity_intent_"
            r9.<init>(r10)
            android.content.Intent r10 = r17.getIntent()
            java.lang.String r10 = r10.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8[r3] = r9
            r7.AFKeystoreWrapper(r5, r8)
            int r3 = waitForCustomerUserId
            int r3 = r3 + 39
            int r5 = r3 % 128
            setCustomerIdAndLogSession = r5
            int r3 = r3 % r4
            goto L_0x00a5
        L_0x0065:
            if (r17 == 0) goto L_0x0098
            int r7 = setCustomerIdAndLogSession
            int r7 = r7 + 7
            int r8 = r7 % 128
            waitForCustomerUserId = r8
            int r7 = r7 % r4
            java.lang.String r8 = "activity_intent_null"
            if (r7 == 0) goto L_0x0086
            com.appsflyer.internal.ak r7 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r9 = new java.lang.String[r4]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r3] = r10
            r9[r6] = r8
            r7.AFKeystoreWrapper(r5, r9)
            goto L_0x00a5
        L_0x0086:
            com.appsflyer.internal.ak r7 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r9 = new java.lang.String[r4]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r6] = r10
            r9[r3] = r8
            r7.AFKeystoreWrapper(r5, r9)
            goto L_0x00a5
        L_0x0098:
            com.appsflyer.internal.ak r3 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String r7 = "activity_null"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            r3.AFKeystoreWrapper(r5, r7)
        L_0x00a5:
            java.lang.String r3 = AFInAppEventParameterName(r17)
            r1.onDeepLinking = r3
            if (r3 == 0) goto L_0x01f4
            long r7 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r3 = r1.onResponse
            java.lang.String r5 = ")"
            if (r3 != 0) goto L_0x00c6
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.values(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.onResponse = r0
            r11 = r7
            goto L_0x01b6
        L_0x00c6:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x019b }
            java.lang.String r9 = "pushPayloadMaxAging"
            r10 = 1800000(0x1b7740, double:8.89318E-318)
            long r9 = r3.getLong(r9, r10)     // Catch:{ all -> 0x019b }
            java.util.Map<java.lang.Long, java.lang.String> r3 = r1.onResponse     // Catch:{ all -> 0x019b }
            java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x019b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x019b }
            r11 = r7
        L_0x00de:
            boolean r13 = r3.hasNext()     // Catch:{ all -> 0x0199 }
            if (r13 == 0) goto L_0x01b6
            java.lang.Object r13 = r3.next()     // Catch:{ all -> 0x0199 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x0199 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0199 }
            java.lang.String r15 = r1.onDeepLinking     // Catch:{ all -> 0x0199 }
            r14.<init>(r15)     // Catch:{ all -> 0x0199 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ all -> 0x0199 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.onResponse     // Catch:{ all -> 0x0199 }
            java.lang.Object r6 = r6.get(r13)     // Catch:{ all -> 0x0199 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0199 }
            r15.<init>(r6)     // Catch:{ all -> 0x0199 }
            java.lang.Object r6 = r14.opt(r2)     // Catch:{ all -> 0x0199 }
            java.lang.Object r4 = r15.opt(r2)     // Catch:{ all -> 0x0199 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x013a
            java.lang.Object r4 = r14.opt(r0)     // Catch:{ all -> 0x0199 }
            java.lang.Object r6 = r15.opt(r0)     // Catch:{ all -> 0x0199 }
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x013a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0199 }
            r0.append(r15)     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0199 }
            r0.append(r14)     // Catch:{ all -> 0x0199 }
            r0.append(r5)     // Catch:{ all -> 0x0199 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0199 }
            com.appsflyer.AFLogger.values(r0)     // Catch:{ all -> 0x0199 }
            r0 = 0
            r1.onDeepLinking = r0     // Catch:{ all -> 0x0199 }
            return
        L_0x013a:
            long r14 = r13.longValue()     // Catch:{ all -> 0x0199 }
            long r14 = r7 - r14
            int r4 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x016a
            int r4 = setCustomerIdAndLogSession
            int r4 = r4 + 41
            int r6 = r4 % 128
            waitForCustomerUserId = r6
            r6 = 2
            int r4 = r4 % r6
            r6 = 35
            if (r4 == 0) goto L_0x0155
            r4 = 34
            goto L_0x0157
        L_0x0155:
            r4 = 35
        L_0x0157:
            if (r4 == r6) goto L_0x0163
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.onResponse     // Catch:{ all -> 0x0199 }
            r4.remove(r13)     // Catch:{ all -> 0x0199 }
            r4 = 19
            r6 = 0
            int r4 = r4 / r6
            goto L_0x016b
        L_0x0163:
            r6 = 0
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.onResponse     // Catch:{ all -> 0x0199 }
            r4.remove(r13)     // Catch:{ all -> 0x0199 }
            goto L_0x016b
        L_0x016a:
            r6 = 0
        L_0x016b:
            long r14 = r13.longValue()     // Catch:{ all -> 0x0199 }
            int r4 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x0196
            int r4 = waitForCustomerUserId
            int r4 = r4 + 121
            int r14 = r4 % 128
            setCustomerIdAndLogSession = r14
            r14 = 2
            int r4 = r4 % r14
            r14 = 55
            if (r4 != 0) goto L_0x0184
            r4 = 11
            goto L_0x0186
        L_0x0184:
            r4 = 55
        L_0x0186:
            if (r4 != r14) goto L_0x018d
            long r11 = r13.longValue()     // Catch:{ all -> 0x0199 }
            goto L_0x0196
        L_0x018d:
            long r2 = r13.longValue()     // Catch:{ all -> 0x0199 }
            r0 = 0
            throw r0     // Catch:{ all -> 0x0193 }
        L_0x0193:
            r0 = move-exception
            r11 = r2
            goto L_0x019d
        L_0x0196:
            r4 = 2
            goto L_0x00de
        L_0x0199:
            r0 = move-exception
            goto L_0x019d
        L_0x019b:
            r0 = move-exception
            r11 = r7
        L_0x019d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while handling push notification measurement: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.valueOf(r2, r0)
        L_0x01b6:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r3 = 2
            int r0 = r0.getInt(r2, r3)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.onResponse
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01e6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r11)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.values(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onResponse
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            r0.remove(r2)
        L_0x01e6:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onResponse
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = r1.onDeepLinking
            r0.put(r2, r3)
            r16.start(r17)
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        int i = setCustomerIdAndLogSession + 31;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if (map != null) {
            ak.AFInAppEventType().AFKeystoreWrapper("setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
            int i3 = setCustomerIdAndLogSession + 3;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    public final void setAndroidIdData(String str) {
        int i = setCustomerIdAndLogSession + 107;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? '[' : ':') != ':') {
            ak AFInAppEventType2 = ak.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = str;
            AFInAppEventType2.AFKeystoreWrapper("setAndroidIdData", strArr);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setAndroidIdData", str);
        }
        this.init = str;
    }

    public final void setAppId(String str) {
        int i = waitForCustomerUserId + 49;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? 29 : 'A') != 'A') {
            ak.AFInAppEventType().AFKeystoreWrapper("setAppId", str);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setAppId", str);
        }
        values((String) "appid", str);
        int i2 = setCustomerIdAndLogSession + 31;
        waitForCustomerUserId = i2 % 128;
        if ((i2 % 2 != 0 ? '`' : '@') != '@') {
            int i3 = 82 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        if ((r8 != null ? 'A' : ']') != ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        if (r8 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        if ((!r8.equals(com.appsflyer.AppsFlyerProperties.getInstance().getString(com.appsflyer.AppsFlyerProperties.ONELINK_ID)) ? '7' : '?') != '7') goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_DOMAIN);
        com.appsflyer.AppsFlyerProperties.getInstance().remove("onelinkVersion");
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_SCHEME);
        r0 = setCustomerIdAndLogSession + 79;
        waitForCustomerUserId = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0094, code lost:
        values((java.lang.String) com.appsflyer.AppsFlyerProperties.ONELINK_ID, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0097, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInviteOneLink(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 45
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 62
            if (r0 == 0) goto L_0x0011
            r0 = 62
            goto L_0x0013
        L_0x0011:
            r0 = 75
        L_0x0013:
            java.lang.String r2 = "oneLinkSlug"
            java.lang.String r3 = "setAppInviteOneLink = "
            r4 = 0
            r5 = 1
            java.lang.String r6 = "setAppInviteOneLink"
            if (r0 == r1) goto L_0x003f
            com.appsflyer.internal.ak r0 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r1 = new java.lang.String[r5]
            r1[r4] = r8
            r0.AFKeystoreWrapper(r6, r1)
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.values(r0)
            r0 = 93
            if (r8 == 0) goto L_0x003a
            r1 = 65
            goto L_0x003c
        L_0x003a:
            r1 = 93
        L_0x003c:
            if (r1 == r0) goto L_0x006f
            goto L_0x0057
        L_0x003f:
            com.appsflyer.internal.ak r0 = com.appsflyer.internal.ak.AFInAppEventType()
            java.lang.String[] r1 = new java.lang.String[r5]
            r1[r4] = r8
            r0.AFKeystoreWrapper(r6, r1)
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.values(r0)
            if (r8 == 0) goto L_0x006f
        L_0x0057:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r2)
            boolean r0 = r8.equals(r0)
            r1 = 55
            if (r0 != 0) goto L_0x006a
            r0 = 55
            goto L_0x006c
        L_0x006a:
            r0 = 63
        L_0x006c:
            if (r0 == r1) goto L_0x006f
            goto L_0x0094
        L_0x006f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkDomain"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkVersion"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkScheme"
            r0.remove(r1)
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 79
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
        L_0x0094:
            values(r2, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.setAppInviteOneLink(java.lang.String):void");
    }

    public final void setCollectAndroidID(boolean z) {
        int i = waitForCustomerUserId + 67;
        setCustomerIdAndLogSession = i % 128;
        boolean z2 = false;
        if (i % 2 != 0) {
            ak.AFInAppEventType().AFKeystoreWrapper("setCollectAndroidID", String.valueOf(z));
        } else {
            ak AFInAppEventType2 = ak.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z);
            AFInAppEventType2.AFKeystoreWrapper("setCollectAndroidID", strArr);
        }
        values((String) AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        values((String) AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
        int i2 = setCustomerIdAndLogSession + 11;
        waitForCustomerUserId = i2 % 128;
        if (i2 % 2 == 0) {
            z2 = true;
        }
        if (!z2) {
            throw null;
        }
    }

    public final void setCollectIMEI(boolean z) {
        int i = setCustomerIdAndLogSession + 109;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("setCollectIMEI", String.valueOf(z));
        values((String) AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        values((String) AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
        int i3 = setCustomerIdAndLogSession + 91;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    @Deprecated
    public final void setCollectOaid(boolean z) {
        int i = waitForCustomerUserId + 65;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? '$' : '9') != '9') {
            ak.AFInAppEventType().AFKeystoreWrapper("setCollectOaid", String.valueOf(z));
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setCollectOaid", String.valueOf(z));
        }
        values((String) AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
        int i2 = setCustomerIdAndLogSession + 21;
        waitForCustomerUserId = i2 % 128;
        if ((i2 % 2 != 0 ? '=' : 'I') != 'I') {
            int i3 = 91 / 0;
        }
    }

    public final void setCurrencyCode(String str) {
        int i = setCustomerIdAndLogSession + 29;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set((String) "currencyCode", str);
        int i3 = setCustomerIdAndLogSession + 35;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 'S' : 17) != 17) {
            throw null;
        }
    }

    public final void setCustomerIdAndLogSession(String str, Context context) {
        if (context != null) {
            int i = waitForCustomerUserId + 95;
            setCustomerIdAndLogSession = i % 128;
            if (!(i % 2 != 0)) {
                AFKeystoreWrapper();
                throw null;
            } else if (AFKeystoreWrapper()) {
                setCustomerUserId(str);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.values(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                AFInAppEventParameterName(context, ch.setCustomerIdAndLogSession);
                String devKey = AppsFlyerProperties.getInstance().getDevKey();
                if (referrer == null) {
                    int i2 = waitForCustomerUserId + 23;
                    setCustomerIdAndLogSession = i2 % 128;
                    int i3 = i2 % 2;
                    referrer = "";
                } else {
                    int i4 = waitForCustomerUserId + 79;
                    setCustomerIdAndLogSession = i4 % 128;
                    int i5 = i4 % 2;
                }
                String str2 = referrer;
                if ((context instanceof Activity ? ')' : 5) != 5) {
                    int i6 = waitForCustomerUserId + 5;
                    setCustomerIdAndLogSession = i6 % 128;
                    int i7 = i6 % 2;
                    ((Activity) context).getIntent();
                }
                AFInAppEventParameterName(context, devKey, null, null, str2, null);
            } else {
                setCustomerUserId(str);
                AFLogger.values("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
            }
        }
    }

    public final void setCustomerUserId(String str) {
        int i = waitForCustomerUserId + 51;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("setCustomerUserId", str);
        AFLogger.values("setCustomerUserId = ".concat(String.valueOf(str)));
        values((String) AppsFlyerProperties.APP_USER_ID, str);
        values((String) AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        int i3 = setCustomerIdAndLogSession + 77;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setDebugLog(boolean z) {
        int i = waitForCustomerUserId + 105;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? '?' : '<') != '?') {
            setLogLevel(z ? LogLevel.DEBUG : LogLevel.NONE);
            int i2 = waitForCustomerUserId + 31;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    public final void setDisableAdvertisingIdentifiers(boolean z) {
        boolean z2;
        AFLogger.AFInAppEventParameterName("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z)));
        if ((!z ? 'Q' : 6) != 'Q') {
            z2 = false;
            int i = setCustomerIdAndLogSession + 101;
            waitForCustomerUserId = i % 128;
            int i2 = i % 2;
        } else {
            int i3 = setCustomerIdAndLogSession + 103;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
            z2 = true;
        }
        ab.AFInAppEventType = Boolean.valueOf(z2);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove(SMTEventParamKeys.SMT_AD_ID);
    }

    public final void setExtension(String str) {
        int i = waitForCustomerUserId + 87;
        setCustomerIdAndLogSession = i % 128;
        if (!(i % 2 != 0)) {
            ak.AFInAppEventType().AFKeystoreWrapper("setExtension", str);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setExtension", str);
        }
        AppsFlyerProperties.getInstance().set((String) AppsFlyerProperties.EXTENSION, str);
    }

    public final void setHost(String str, String str2) {
        int i = setCustomerIdAndLogSession + 43;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        if ((str != null ? 'W' : '0') == 'W') {
            values((String) "custom_host_prefix", str);
        }
        if (!(str2 == null)) {
            int i3 = setCustomerIdAndLogSession + 3;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
            if (!str2.isEmpty()) {
                values((String) "custom_host", str2);
                return;
            }
        }
        AFLogger.AppsFlyer2dXConversionCallback("hostName cannot be null or empty");
    }

    public final void setImeiData(String str) {
        int i = setCustomerIdAndLogSession + 107;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        boolean z = true;
        ak.AFInAppEventType().AFKeystoreWrapper("setImeiData", str);
        this.AppsFlyer2dXConversionCallback = str;
        int i3 = setCustomerIdAndLogSession + 39;
        waitForCustomerUserId = i3 % 128;
        if (i3 % 2 != 0) {
            z = false;
        }
        if (!z) {
            throw null;
        }
    }

    public final void setIsUpdate(boolean z) {
        int i = setCustomerIdAndLogSession + 77;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set((String) AppsFlyerProperties.IS_UPDATE, z);
        int i3 = setCustomerIdAndLogSession + 3;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 23 : 11) == 23) {
            int i4 = 85 / 0;
        }
    }

    public final void setLogLevel(LogLevel logLevel) {
        boolean z;
        int i = waitForCustomerUserId + 23;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? '#' : '=') == '=') {
            if ((logLevel.getLevel() > LogLevel.NONE.getLevel() ? DefaultObjectDumpFormatter.TOKEN_DIVIDER : '_') != '_') {
                int i2 = setCustomerIdAndLogSession + 29;
                waitForCustomerUserId = i2 % 128;
                int i3 = i2 % 2;
                z = true;
            } else {
                z = false;
            }
            ak.AFInAppEventType().AFKeystoreWrapper(AnalyticsConstants.LOG, String.valueOf(z));
            AppsFlyerProperties.getInstance().set((String) "logLevel", logLevel.getLevel());
            return;
        }
        logLevel.getLevel();
        LogLevel.NONE.getLevel();
        throw null;
    }

    public final void setMinTimeBetweenSessions(int i) {
        int i2 = setCustomerIdAndLogSession + 19;
        waitForCustomerUserId = i2 % 128;
        boolean z = false;
        if (!(i2 % 2 == 0)) {
            this.onConversionDataSuccess = TimeUnit.SECONDS.toMillis((long) i);
            int i3 = 88 / 0;
        } else {
            this.onConversionDataSuccess = TimeUnit.SECONDS.toMillis((long) i);
        }
        int i4 = setCustomerIdAndLogSession + 83;
        waitForCustomerUserId = i4 % 128;
        if (i4 % 2 != 0) {
            z = true;
        }
        if (z) {
            throw null;
        }
    }

    public final void setOaidData(String str) {
        int i = waitForCustomerUserId + 11;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? 'Q' : ']') != ']') {
            ak AFInAppEventType2 = ak.AFInAppEventType();
            String[] strArr = new String[1];
            strArr[1] = str;
            AFInAppEventType2.AFKeystoreWrapper("setOaidData", strArr);
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setOaidData", str);
        }
        ab.AFInAppEventParameterName = str;
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        int i = waitForCustomerUserId + 5;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        AFLogger.AFInAppEventParameterName(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        f.AFLogger$LogLevel = strArr;
        int i3 = setCustomerIdAndLogSession + 89;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setOutOfStore(String str) {
        if (str != null) {
            int i = waitForCustomerUserId + 71;
            setCustomerIdAndLogSession = i % 128;
            if (i % 2 == 0) {
            }
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set((String) "api_store_value", lowerCase);
            AFLogger.values("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            int i2 = setCustomerIdAndLogSession + 103;
            waitForCustomerUserId = i2 % 128;
            if ((i2 % 2 != 0 ? '.' : 'L') != 'L') {
                int i3 = 60 / 0;
                return;
            }
            return;
        }
        AFLogger.valueOf((String) "Cannot set setOutOfStore with null");
    }

    public final void setPartnerData(String str, Map<String, Object> map) {
        String str2;
        if (this.setImeiData == null) {
            this.setImeiData = new az();
        }
        az azVar = this.setImeiData;
        if (str != null) {
            char c2 = 0;
            if (!str.isEmpty()) {
                if ((map != null ? 'I' : 'J') == 'J' || map.isEmpty()) {
                    if (azVar.values.remove(str) == null) {
                        c2 = Tokenizer.FF;
                    }
                    if (c2 != 12) {
                        str2 = "Cleared partner data for ".concat(str);
                        int i = setCustomerIdAndLogSession + 35;
                        waitForCustomerUserId = i % 128;
                        int i2 = i % 2;
                    } else {
                        int i3 = setCustomerIdAndLogSession + 5;
                        waitForCustomerUserId = i3 % 128;
                        int i4 = i3 % 2;
                        str2 = "Partner data is missing or `null`";
                    }
                    AFLogger.AppsFlyer2dXConversionCallback(str2);
                    return;
                }
                StringBuilder sb = new StringBuilder("Setting partner data for ");
                sb.append(str);
                sb.append(": ");
                sb.append(map);
                AFLogger.AFInAppEventParameterName(sb.toString());
                int length = new JSONObject(map).toString().length();
                if (length > 1000) {
                    AFLogger.AppsFlyer2dXConversionCallback("Partner data 1000 characters limit exceeded");
                    HashMap hashMap = new HashMap();
                    hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                    azVar.valueOf.put(str, hashMap);
                    return;
                }
                azVar.values.put(str, map);
                azVar.valueOf.remove(str);
                return;
            }
        }
        AFLogger.AppsFlyer2dXConversionCallback("Partner ID is missing or `null`");
    }

    public final void setPhoneNumber(String str) {
        int i = waitForCustomerUserId + 107;
        setCustomerIdAndLogSession = i % 128;
        boolean z = i % 2 == 0;
        this.onPause = ag.AFInAppEventParameterName(str);
        if (!z) {
            int i2 = waitForCustomerUserId + 107;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.AFInAppEventParameterName("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if ((str != null ? 3 : 'B') != 'B') {
            int i = setCustomerIdAndLogSession + 23;
            waitForCustomerUserId = i % 128;
            if ((i % 2 != 0 ? 7 : 'E') != 7) {
                try {
                    jSONObject.put("pid", str);
                } catch (JSONException e2) {
                    AFLogger.valueOf(e2.getMessage(), e2);
                }
            } else {
                jSONObject.put("pid", str);
                throw null;
            }
        }
        if (str2 != null) {
            int i2 = waitForCustomerUserId + 73;
            setCustomerIdAndLogSession = i2 % 128;
            if (i2 % 2 != 0) {
                jSONObject.put("c", str2);
            } else {
                jSONObject.put("c", str2);
                throw null;
            }
        }
        if (str3 != null) {
            int i3 = setCustomerIdAndLogSession + 71;
            waitForCustomerUserId = i3 % 128;
            if (i3 % 2 == 0) {
                jSONObject.put("af_siteid", str3);
            } else {
                jSONObject.put("af_siteid", str3);
                throw null;
            }
        }
        if (!(jSONObject.has("pid"))) {
            AFLogger.AppsFlyer2dXConversionCallback("Cannot set preinstall attribution data without a media source");
            return;
        }
        int i4 = setCustomerIdAndLogSession + 25;
        waitForCustomerUserId = i4 % 128;
        int i5 = i4 % 2;
        values((String) "preInstallName", jSONObject.toString());
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        int i = waitForCustomerUserId + 55;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        AFLogger.AFInAppEventParameterName(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        f.AFKeystoreWrapper = strArr;
        int i3 = waitForCustomerUserId + 33;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
    }

    @Deprecated
    public final void setSharingFilter(String... strArr) {
        int i = waitForCustomerUserId + 1;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        setSharingFilterForPartners(strArr);
        int i3 = waitForCustomerUserId + 47;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i = setCustomerIdAndLogSession + 107;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? '9' : ' ') != '9') {
            setSharingFilterForPartners(ChannelPipelineCoverage.ALL);
        } else {
            String[] strArr = new String[0];
            strArr[0] = ChannelPipelineCoverage.ALL;
            setSharingFilterForPartners(strArr);
        }
        int i2 = waitForCustomerUserId + 5;
        setCustomerIdAndLogSession = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 32 / 0;
        }
    }

    public final void setSharingFilterForPartners(String... strArr) {
        this.getLevel = new y(strArr);
        int i = setCustomerIdAndLogSession + 3;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
    }

    public final void setUserEmails(String... strArr) {
        int i = setCustomerIdAndLogSession + 35;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? 'B' : '[') != '[') {
            ak.AFInAppEventType().AFKeystoreWrapper("setUserEmails", strArr);
            setUserEmails(EmailsCryptType.NONE, strArr);
            int i2 = 55 / 0;
        } else {
            ak.AFInAppEventType().AFKeystoreWrapper("setUserEmails", strArr);
            setUserEmails(EmailsCryptType.NONE, strArr);
        }
        int i3 = setCustomerIdAndLogSession + 77;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 1 : '2') == 1) {
            throw null;
        }
    }

    public final void start(Context context) {
        int i = waitForCustomerUserId + 117;
        setCustomerIdAndLogSession = i % 128;
        char c2 = i % 2 == 0 ? 'P' : 4;
        start(context, null);
        if (c2 != 'P') {
            int i2 = setCustomerIdAndLogSession + 35;
            waitForCustomerUserId = i2 % 128;
            if ((i2 % 2 != 0 ? 'N' : 23) != 23) {
                throw null;
            }
            return;
        }
        throw null;
    }

    public final void stop(boolean z, Context context) {
        this.getInstance = z;
        try {
            File file = new File(values().AFVersionDeclaration().AFKeystoreWrapper.values.getFilesDir(), "AFRequestCache");
            int i = 0;
            if (!(file.exists())) {
                int i2 = waitForCustomerUserId + 7;
                setCustomerIdAndLogSession = i2 % 128;
                if ((i2 % 2 == 0 ? '!' : 'N') != 'N') {
                    file.mkdir();
                    int i3 = 36 / 0;
                } else {
                    file.mkdir();
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    while (i < length) {
                        File file2 = listFiles[i];
                        StringBuilder sb = new StringBuilder("CACHE: Found cached request");
                        sb.append(file2.getName());
                        AFLogger.values(sb.toString());
                        StringBuilder sb2 = new StringBuilder("CACHE: Deleting ");
                        sb2.append(file2.getName());
                        sb2.append(" from cache");
                        AFLogger.values(sb2.toString());
                        file2.delete();
                        i++;
                        int i4 = waitForCustomerUserId + 23;
                        setCustomerIdAndLogSession = i4 % 128;
                        int i5 = i4 % 2;
                    }
                }
            }
        } catch (Exception e2) {
            AFLogger.valueOf("CACHE: Could not cache request", e2);
        }
        if (this.getInstance) {
            int i6 = waitForCustomerUserId + 21;
            setCustomerIdAndLogSession = i6 % 128;
            int i7 = i6 % 2;
            values(context, (String) "is_stop_tracking_used");
            int i8 = waitForCustomerUserId + 69;
            setCustomerIdAndLogSession = i8 % 128;
            int i9 = i8 % 2;
        }
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        int i = waitForCustomerUserId + 61;
        setCustomerIdAndLogSession = i % 128;
        if (!(i % 2 != 0)) {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
            int i2 = 88 / 0;
        } else {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
        }
        int i3 = waitForCustomerUserId + 91;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void unregisterConversionListener() {
        int i = setCustomerIdAndLogSession + 105;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        ak.AFInAppEventType().AFKeystoreWrapper("unregisterConversionListener", new String[0]);
        AFKeystoreWrapper = null;
        int i3 = waitForCustomerUserId + 111;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void updateServerUninstallToken(Context context, String str) {
        new cd(context).AFInAppEventParameterName(str);
        int i = setCustomerIdAndLogSession + 27;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? ')' : 8) != 8) {
            throw null;
        }
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        ak AFInAppEventType2 = ak.AFInAppEventType();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        AFInAppEventType2.AFKeystoreWrapper("validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str3);
            sb.append(CMap.SPACE);
            sb.append(str7);
            sb.append(CMap.SPACE);
            sb.append(str8);
            AFLogger.values(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFInAppEventParameterName;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        if (context2 instanceof Activity) {
            ((Activity) context2).getIntent();
        }
        ad adVar = new ad(applicationContext, devKey, str, str2, str3, str4, str5, map);
        new Thread(adVar).start();
    }

    public final void waitForCustomerUserId(boolean z) {
        int i = setCustomerIdAndLogSession + 1;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        AFLogger.values("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        values((String) AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
        int i3 = setCustomerIdAndLogSession + 119;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ ScheduledExecutorService AFInAppEventParameterName(ac acVar, ScheduledExecutorService scheduledExecutorService) {
        int i = setCustomerIdAndLogSession + 117;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        acVar.onAttributionFailure = scheduledExecutorService;
        int i3 = waitForCustomerUserId + 77;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return scheduledExecutorService;
    }

    public static /* synthetic */ boolean AFInAppEventType(ac acVar) {
        int i = waitForCustomerUserId + 65;
        setCustomerIdAndLogSession = i % 128;
        boolean z = i % 2 != 0;
        boolean z2 = acVar.onResponseError;
        if (z) {
            return z2;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if ((r4 != null) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File AFLogger$LogLevel(java.lang.String r4) {
        /*
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 115
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001f
            r0 = 93
            int r0 = r0 / r2
            r0 = 79
            if (r4 == 0) goto L_0x0018
            r3 = 47
            goto L_0x001a
        L_0x0018:
            r3 = 79
        L_0x001a:
            if (r3 == r0) goto L_0x0059
            goto L_0x0026
        L_0x001d:
            r4 = move-exception
            goto L_0x0051
        L_0x001f:
            if (r4 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 == 0) goto L_0x0059
        L_0x0026:
            java.lang.String r0 = r4.trim()     // Catch:{ all -> 0x001d }
            int r0 = r0.length()     // Catch:{ all -> 0x001d }
            if (r0 <= 0) goto L_0x0059
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x001d }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x001d }
            r0.<init>(r4)     // Catch:{ all -> 0x001d }
            int r4 = setCustomerIdAndLogSession
            int r4 = r4 + 37
            int r3 = r4 % 128
            waitForCustomerUserId = r3
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0047
            r4 = 1
            goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            if (r4 == r1) goto L_0x004b
            return r0
        L_0x004b:
            r4 = 40
            int r4 = r4 / r2
            return r0
        L_0x004f:
            r4 = move-exception
            throw r4
        L_0x0051:
            java.lang.String r0 = r4.getMessage()
            com.appsflyer.AFLogger.valueOf(r0, r4)
            goto L_0x0063
        L_0x0059:
            int r4 = setCustomerIdAndLogSession
            int r4 = r4 + 5
            int r0 = r4 % 128
            waitForCustomerUserId = r0
            int r4 = r4 % 2
        L_0x0063:
            r4 = 0
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 105
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFLogger$LogLevel(java.lang.String):java.io.File");
    }

    public static void getLevel(Context context) {
        int i;
        if (z.valueOf()) {
            i = 23;
            AFLogger.AFKeystoreWrapper("OPPO device found");
        } else {
            i = 18;
        }
        if (VERSION.SDK_INT < i || AFKeystoreWrapper((String) AppsFlyerProperties.DISABLE_KEYSTORE, true)) {
            StringBuilder sb = new StringBuilder("OS SDK is=");
            sb.append(VERSION.SDK_INT);
            sb.append("; no KeyStore usage");
            AFLogger.AFKeystoreWrapper(sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder("OS SDK is=");
        sb2.append(VERSION.SDK_INT);
        sb2.append("; use KeyStore");
        AFLogger.AFKeystoreWrapper(sb2.toString());
        AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context);
        if (!aFKeystoreWrapper.AFKeystoreWrapper()) {
            aFKeystoreWrapper.values = af.valueOf(new WeakReference(context));
            aFKeystoreWrapper.AFInAppEventType = 0;
            aFKeystoreWrapper.AFKeystoreWrapper(aFKeystoreWrapper.valueOf());
        } else {
            String valueOf2 = aFKeystoreWrapper.valueOf();
            synchronized (aFKeystoreWrapper.AFInAppEventParameterName) {
                aFKeystoreWrapper.AFInAppEventType++;
                AFLogger.values("Deleting key with alias: ".concat(String.valueOf(valueOf2)));
                try {
                    synchronized (aFKeystoreWrapper.AFInAppEventParameterName) {
                        aFKeystoreWrapper.valueOf.deleteEntry(valueOf2);
                    }
                } catch (KeyStoreException e2) {
                    StringBuilder sb3 = new StringBuilder("Exception ");
                    sb3.append(e2.getMessage());
                    sb3.append(" occurred");
                    AFLogger.valueOf(sb3.toString(), e2);
                }
            }
            aFKeystoreWrapper.AFKeystoreWrapper(aFKeystoreWrapper.valueOf());
        }
        values((String) "KSAppsFlyerId", aFKeystoreWrapper.values());
        values((String) "KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.AFInAppEventType()));
    }

    public static void valueOf(JSONObject jSONObject) {
        int i;
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            i = 0;
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                while (i < jSONArray.length()) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                    i++;
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        int i2 = setCustomerIdAndLogSession + 117;
        waitForCustomerUserId = i2 % 128;
        int i3 = i2 % 2;
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i4 = 0;
                    while (i4 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i4) != ((Long) arrayList.get(0)).longValue()) {
                            int i5 = setCustomerIdAndLogSession + 39;
                            waitForCustomerUserId = i5 % 128;
                            if (!(i5 % 2 != 0)) {
                                if (!(jSONArray2.getLong(i4) != ((Long) arrayList.get(1)).longValue())) {
                                }
                            } else {
                                if ((jSONArray2.getLong(i4) != ((Long) arrayList.get(1)).longValue() ? (char) 14 : 30) == 30) {
                                }
                            }
                            if ((jSONArray2.getLong(i4) == ((Long) arrayList.get(arrayList.size() - 1)).longValue() ? 15 : '(') == '(') {
                                i4++;
                                str = next;
                            }
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            i = 1;
        }
        if (i == 1) {
            jSONObject.remove(str);
        }
    }

    public static /* synthetic */ boolean values(ac acVar, boolean z) {
        int i = setCustomerIdAndLogSession + 29;
        waitForCustomerUserId = i % 128;
        boolean z2 = i % 2 != 0;
        acVar.onResponseError = z;
        if (!z2) {
            return z;
        }
        throw null;
    }

    public final void AFKeystoreWrapper(Context context, Intent intent) {
        if ((intent.getStringExtra("appsflyer_preinstall") != null ? '5' : 'D') != 'D') {
            AFInAppEventType(intent.getStringExtra("appsflyer_preinstall"));
        }
        AFLogger.values((String) "****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra = intent.getStringExtra("referrer");
        AFLogger.values("Play store referrer: ".concat(String.valueOf(stringExtra)));
        if (stringExtra != null) {
            valueOf(context, (String) "referrer", stringExtra);
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            instance.set((String) "AF_REFERRER", stringExtra);
            instance.valueOf = stringExtra;
            if (AppsFlyerProperties.getInstance().values()) {
                int i = waitForCustomerUserId + 79;
                setCustomerIdAndLogSession = i % 128;
                if (i % 2 != 0) {
                    AFLogger.values((String) "onReceive: isLaunchCalled");
                    AFInAppEventParameterName(context, ch.onReceive);
                    AFInAppEventType(context, stringExtra);
                } else {
                    AFLogger.values((String) "onReceive: isLaunchCalled");
                    AFInAppEventParameterName(context, ch.onReceive);
                    AFInAppEventType(context, stringExtra);
                    throw null;
                }
            }
        }
        int i2 = setCustomerIdAndLogSession + 9;
        waitForCustomerUserId = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        Activity activity = null;
        Map<String, Object> hashMap = map == null ? null : new HashMap<>(map);
        bf bfVar = this.setCustomerUserId;
        if (context != null) {
            bfVar.AFKeystoreWrapper.values = context.getApplicationContext();
        }
        co coVar = new co();
        if (context != null) {
            coVar.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        coVar.getLevel = str;
        coVar.AFInAppEventParameterName = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.valueOf((String) "Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            coVar.AFInAppEventParameterName(singletonMap);
        }
        coVar.values = hashMap;
        ak AppsFlyer2dXConversionCallback2 = values().AppsFlyer2dXConversionCallback();
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = coVar.values;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new JSONObject(map2).toString();
        AppsFlyer2dXConversionCallback2.AFKeystoreWrapper("logEvent", strArr);
        if (str != null) {
            w.AFKeystoreWrapper(context).AFInAppEventType();
        } else {
            AFInAppEventParameterName(context, ch.logEvent);
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        AFKeystoreWrapper((i) coVar, activity);
    }

    public final void start(Context context, String str) {
        int i = waitForCustomerUserId + 75;
        setCustomerIdAndLogSession = i % 128;
        boolean z = i % 2 != 0;
        start(context, str, null);
        if (!z) {
            int i2 = 95 / 0;
        }
        int i3 = setCustomerIdAndLogSession + 79;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j) {
        int i = setCustomerIdAndLogSession + 17;
        waitForCustomerUserId = i % 128;
        boolean z = false;
        if (!(i % 2 != 0)) {
            f.valueOf().values = deepLinkListener;
            ar.onInstallConversionDataLoadedNative = j;
            int i2 = setCustomerIdAndLogSession + 21;
            waitForCustomerUserId = i2 % 128;
            if (i2 % 2 != 0) {
                z = true;
            }
            if (z) {
                throw null;
            }
            return;
        }
        f.valueOf().values = deepLinkListener;
        ar.onInstallConversionDataLoadedNative = j;
        throw null;
    }

    public static /* synthetic */ void AFInAppEventParameterName(ac acVar, i iVar) {
        int i = waitForCustomerUserId + 93;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        acVar.valueOf(iVar);
        int i3 = setCustomerIdAndLogSession + 99;
        waitForCustomerUserId = i3 % 128;
        if (!(i3 % 2 == 0)) {
            throw null;
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void AFInAppEventType(Editor editor) {
        int i = setCustomerIdAndLogSession + 123;
        waitForCustomerUserId = i % 128;
        char c2 = i % 2 != 0 ? '*' : 'C';
        editor.apply();
        if (c2 == 'C') {
            int i2 = setCustomerIdAndLogSession + 31;
            waitForCustomerUserId = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 17 / 0;
                return;
            }
            return;
        }
        throw null;
    }

    public final void start(Context context, final String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        if (ah.AFInAppEventParameterName == null) {
            boolean z = false;
            if (!this.AppsFlyerInAppPurchaseValidatorListener) {
                AFLogger.AppsFlyer2dXConversionCallback("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str == null) {
                    if (appsFlyerRequestListener != null) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, ba.AFInAppEventParameterName);
                    }
                    return;
                }
            }
            bf bfVar = this.setCustomerUserId;
            if (context != null) {
                be beVar = bfVar.AFKeystoreWrapper;
                int i = waitForCustomerUserId + 125;
                setCustomerIdAndLogSession = i % 128;
                int i2 = i % 2;
                beVar.values = context.getApplicationContext();
            }
            final cl level = values().getLevel();
            level.valueOf(n.AFInAppEventParameterName(context));
            this.stop = (Application) context.getApplicationContext();
            ak.AFInAppEventType().AFKeystoreWrapper(AnalyticsConstants.START, str);
            AFLogger.values(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.5.4", valueOf}));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(valueOf);
            AFLogger.values(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.stop.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AppsFlyerProperties.getInstance().setDevKey(str);
                ai.AFInAppEventType(str);
            } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getDevKey())) {
                int i3 = setCustomerIdAndLogSession + 33;
                waitForCustomerUserId = i3 % 128;
                int i4 = i3 % 2;
                AFLogger.AppsFlyer2dXConversionCallback("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener != null) {
                    z = true;
                }
                if (z) {
                    int i5 = waitForCustomerUserId + 35;
                    setCustomerIdAndLogSession = i5 % 128;
                    if (i5 % 2 != 0) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, ba.AFInAppEventParameterName);
                    } else {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, ba.AFInAppEventParameterName);
                        throw null;
                    }
                }
                return;
            }
            values().values().values(null);
            AppsFlyer2dXConversionCallback(this.stop.getBaseContext());
            if (this.setDebugLog) {
                valueOf(this.stop.getApplicationContext());
            }
            ah.AFKeystoreWrapper(context, new com.appsflyer.internal.ah.e() {
                public final void valueOf(Activity activity) {
                    level.AFKeystoreWrapper();
                    ac.this.values().values().values(null);
                    int valueOf2 = ac.this.valueOf(ac.AFInAppEventType((Context) activity), false);
                    AFLogger.values((String) "onBecameForeground");
                    if (valueOf2 < 2) {
                        w AFKeystoreWrapper = w.AFKeystoreWrapper((Context) activity);
                        AFKeystoreWrapper.AFKeystoreWrapper.post(AFKeystoreWrapper.getLevel);
                        AFKeystoreWrapper.AFKeystoreWrapper.post(AFKeystoreWrapper.AFInAppEventParameterName);
                    }
                    cp cpVar = new cp();
                    f.valueOf().valueOf(cpVar.values(), level, activity.getIntent(), ac.this.values().AFInAppEventParameterName(), activity.getApplication());
                    ac acVar = ac.this;
                    cpVar.AFKeystoreWrapper = (Application) activity.getApplicationContext();
                    cpVar.AFVersionDeclaration = str;
                    cpVar.AFInAppEventParameterName = appsFlyerRequestListener;
                    acVar.AFKeystoreWrapper((i) cpVar, activity);
                }

                public final void valueOf(Context context) {
                    AFLogger.values((String) "onBecameBackground");
                    cl clVar = level;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = clVar.AppsFlyer2dXConversionCallback;
                    if (j != 0) {
                        long j2 = currentTimeMillis - j;
                        if (j2 > 0 && j2 < 1000) {
                            j2 = 1000;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(j2);
                        clVar.onDeepLinkingNative = seconds;
                        clVar.valueOf.AFKeystoreWrapper("prev_session_dur", seconds);
                    } else {
                        AFLogger.values((String) "Metrics: fg ts is missing");
                    }
                    AFLogger.values((String) "callStatsBackground background call");
                    ac.this.AFInAppEventParameterName(new WeakReference<>(context));
                    ak AFInAppEventType2 = ak.AFInAppEventType();
                    if (AFInAppEventType2.AFVersionDeclaration()) {
                        AFInAppEventType2.AFInAppEventParameterName();
                        if (context != null && !AppsFlyerLib.getInstance().isStopped()) {
                            AFInAppEventType2.AFInAppEventType(context.getPackageName(), context.getPackageManager());
                        }
                        AFInAppEventType2.values();
                    } else {
                        AFLogger.AFInAppEventParameterName("RD status is OFF");
                    }
                    if (k.values == null) {
                        k.values = new k();
                    }
                    k kVar = k.values;
                    try {
                        k.valueOf(kVar.AFKeystoreWrapper);
                        if (kVar.AFInAppEventParameterName instanceof ThreadPoolExecutor) {
                            k.valueOf((ThreadPoolExecutor) kVar.AFInAppEventParameterName);
                        }
                    } catch (Throwable th) {
                        AFLogger.valueOf("failed to stop Executors", th);
                    }
                    w AFKeystoreWrapper = w.AFKeystoreWrapper(context);
                    AFKeystoreWrapper.AFKeystoreWrapper.post(AFKeystoreWrapper.getLevel);
                }
            }, this.setOaidData);
            int i6 = waitForCustomerUserId + 115;
            setCustomerIdAndLogSession = i6 % 128;
            if ((i6 % 2 == 0 ? 'F' : 22) == 'F') {
                int i7 = 6 / 0;
            }
        }
    }

    public final bg values() {
        int i = setCustomerIdAndLogSession + 11;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        bf bfVar = this.setCustomerUserId;
        int i3 = setCustomerIdAndLogSession + 15;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
        return bfVar;
    }

    public static /* synthetic */ boolean AFInAppEventParameterName(ac acVar, i iVar, SharedPreferences sharedPreferences) {
        int i = waitForCustomerUserId + 67;
        setCustomerIdAndLogSession = i % 128;
        if (!(i % 2 == 0)) {
            return acVar.valueOf(iVar, sharedPreferences);
        }
        acVar.valueOf(iVar, sharedPreferences);
        throw null;
    }

    public static void values(Context context, String str) {
        Editor edit;
        int i = setCustomerIdAndLogSession + 7;
        waitForCustomerUserId = i % 128;
        if (!(i % 2 == 0)) {
            edit = AFInAppEventType(context).edit();
            edit.putBoolean(str, false);
        } else {
            edit = AFInAppEventType(context).edit();
            edit.putBoolean(str, true);
        }
        AFInAppEventType(edit);
        int i2 = setCustomerIdAndLogSession + 93;
        waitForCustomerUserId = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void AFInAppEventType(Context context, String str, long j) {
        int i = setCustomerIdAndLogSession + 97;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        AFInAppEventParameterName(AFInAppEventType(context), str, j);
        int i3 = setCustomerIdAndLogSession + 75;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    public static ac AFInAppEventParameterName() {
        int i = setCustomerIdAndLogSession + 103;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        ac acVar = onConversionDataFail;
        int i3 = waitForCustomerUserId + 47;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return acVar;
    }

    public static String AFInAppEventType() {
        int i = waitForCustomerUserId + 15;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? 21 : '6') == '6') {
            return AFInAppEventParameterName((String) AppsFlyerProperties.APP_USER_ID);
        }
        try {
            int i2 = 55 / 0;
            return AFInAppEventParameterName((String) AppsFlyerProperties.APP_USER_ID);
        }
    }

    public static void AFInAppEventParameterName(SharedPreferences sharedPreferences, String str, long j) {
        int i = setCustomerIdAndLogSession + 121;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        AFInAppEventType(edit);
        int i3 = setCustomerIdAndLogSession + 45;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
    }

    private void AFInAppEventType(Context context, String str) {
        cq cqVar = new cq();
        if (context != null) {
            int i = waitForCustomerUserId + 109;
            setCustomerIdAndLogSession = i % 128;
            int i2 = i % 2;
            cqVar.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        cqVar.AppsFlyer2dXConversionCallback = str;
        if ((str != null) && str.length() > 5) {
            int i3 = waitForCustomerUserId + 23;
            setCustomerIdAndLogSession = i3 % 128;
            int i4 = i3 % 2;
            if (valueOf((i) cqVar, AFInAppEventType(context))) {
                if (k.values == null) {
                    k.values = new k();
                }
                valueOf(k.values.AFKeystoreWrapper(), new b(this, cqVar, 0), 5, TimeUnit.MILLISECONDS);
                int i5 = waitForCustomerUserId + 63;
                setCustomerIdAndLogSession = i5 % 128;
                int i6 = i5 % 2;
            }
        }
    }

    public final void setUserEmails(EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        ak.AFInAppEventType().AFKeystoreWrapper("setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set((String) AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                hashMap.put(str, arrayList2);
                AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
                return;
            }
            int i2 = setCustomerIdAndLogSession + 57;
            waitForCustomerUserId = i2 % 128;
            int i3 = i2 % 2;
            String str2 = strArr[i];
            if (AnonymousClass9.values[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(ag.AFInAppEventParameterName(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
            i++;
            int i4 = waitForCustomerUserId + 85;
            setCustomerIdAndLogSession = i4 % 128;
            int i5 = i4 % 2;
        }
    }

    public static Map<String, Object> AFLogger$LogLevel(Context context) {
        Location valueOf2 = com.appsflyer.internal.v.b.AFKeystoreWrapper.valueOf(context);
        HashMap hashMap = new HashMap(3);
        if ((valueOf2 != null ? 'b' : '?') == 'b') {
            int i = waitForCustomerUserId + 83;
            setCustomerIdAndLogSession = i % 128;
            int i2 = i % 2;
            hashMap.put(SMTEventParamKeys.SMT_LATITUDE, String.valueOf(valueOf2.getLatitude()));
            hashMap.put("lon", String.valueOf(valueOf2.getLongitude()));
            hashMap.put("ts", String.valueOf(valueOf2.getTime()));
            int i3 = setCustomerIdAndLogSession + 9;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
        }
        return hashMap;
    }

    public static String AFInAppEventParameterName(String str) {
        String str2;
        int i = waitForCustomerUserId + 61;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? DefaultObjectDumpFormatter.TOKEN_DIVIDER : '`') != ';') {
            str2 = AppsFlyerProperties.getInstance().getString(str);
        } else {
            str2 = AppsFlyerProperties.getInstance().getString(str);
            int i2 = 31 / 0;
        }
        int i3 = setCustomerIdAndLogSession + 43;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
        return str2;
    }

    public final void AFInAppEventParameterName(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.values((String) "app went to background");
            SharedPreferences AFInAppEventType2 = AFInAppEventType(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(AFInAppEventType2);
            long j = values().getLevel().onDeepLinkingNative;
            HashMap hashMap = new HashMap();
            String devKey = AppsFlyerProperties.getInstance().getDevKey();
            if (devKey == null) {
                AFLogger.AppsFlyer2dXConversionCallback("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String AFInAppEventParameterName2 = AFInAppEventParameterName((String) "KSAppsFlyerId");
            if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false) ? 'Y' : '2') == 'Y') {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, BaseParser.TRUE);
            }
            g AFInAppEventType3 = ab.AFInAppEventType(weakReference.get().getContentResolver());
            if ((AFInAppEventType3 != null ? '_' : '-') == '_') {
                int i = setCustomerIdAndLogSession + 5;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
                hashMap.put("amazon_aid", AFInAppEventType3.values);
                hashMap.put("amazon_aid_limit", String.valueOf(AFInAppEventType3.AFKeystoreWrapper));
                int i3 = setCustomerIdAndLogSession + 51;
                waitForCustomerUserId = i3 % 128;
                int i4 = i3 % 2;
            }
            String string = AppsFlyerProperties.getInstance().getString(SMTEventParamKeys.SMT_AD_ID);
            if (!(string == null)) {
                int i5 = waitForCustomerUserId + 41;
                setCustomerIdAndLogSession = i5 % 128;
                if (i5 % 2 != 0) {
                    hashMap.put(SMTEventParamKeys.SMT_AD_ID, string);
                    int i6 = setCustomerIdAndLogSession + 1;
                    waitForCustomerUserId = i6 % 128;
                    int i7 = i6 % 2;
                } else {
                    hashMap.put(SMTEventParamKeys.SMT_AD_ID, string);
                    throw null;
                }
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", devKey);
            hashMap.put("uid", af.valueOf(weakReference));
            hashMap.put("time_in_app", String.valueOf(j));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(valueOf(AFInAppEventType2, false)));
            hashMap.put("channel", AFInAppEventParameterName(weakReference.get()));
            if ((AFInAppEventParameterName2 != null ? 'A' : 31) == 31) {
                AFInAppEventParameterName2 = "";
            }
            hashMap.put("originalAppsflyerId", AFInAppEventParameterName2);
            if (this.onValidateInApp) {
                try {
                    AFLogger.AFInAppEventParameterName("Running callStats task");
                    cv cvVar = new cv();
                    cvVar.onConversionDataSuccess = isStopped();
                    new Thread(new c((cm) cvVar.AFInAppEventParameterName(hashMap).AFInAppEventType(String.format(AFLogger$LogLevel, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventParameterName().getHostName()})))).start();
                } catch (Throwable th) {
                    AFLogger.valueOf("Could not send callStats request", th);
                }
            } else {
                AFLogger.AFInAppEventParameterName("Stats call is disabled, ignore ...");
            }
        }
    }

    public static void values(String str, String str2) {
        int i = waitForCustomerUserId + 35;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        AppsFlyerProperties.getInstance().set(str, str2);
        int i3 = waitForCustomerUserId + 15;
        setCustomerIdAndLogSession = i3 % 128;
        if (!(i3 % 2 != 0)) {
            throw null;
        }
    }

    public static void values(String str, boolean z) {
        int i = setCustomerIdAndLogSession + 3;
        waitForCustomerUserId = i % 128;
        if (i % 2 == 0) {
            AppsFlyerProperties.getInstance().set(str, z);
        } else {
            AppsFlyerProperties.getInstance().set(str, z);
            throw null;
        }
    }

    public static void values(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = setCustomerIdAndLogSession + 61;
        waitForCustomerUserId = i % 128;
        if (!(i % 2 == 0)) {
            throw null;
        } else if (appsFlyerConversionListener == null) {
            int i2 = setCustomerIdAndLogSession + 91;
            waitForCustomerUserId = i2 % 128;
            if ((i2 % 2 != 0 ? '1' : '-') != '-') {
                throw null;
            }
        } else {
            AFKeystoreWrapper = appsFlyerConversionListener;
        }
    }

    public static Map<String, Object> AFInAppEventType(Map<String, Object> map) {
        int i = waitForCustomerUserId + 23;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? 'H' : '+') == '+') {
            if ((map.containsKey("meta") ? 25 : ']') != 25) {
                HashMap hashMap = new HashMap();
                map.put("meta", hashMap);
                return hashMap;
            }
            Map<String, Object> map2 = (Map) map.get("meta");
            int i2 = waitForCustomerUserId + 29;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
            return map2;
        }
        map.containsKey("meta");
        throw null;
    }

    public static boolean AFKeystoreWrapper(String str, boolean z) {
        int i = setCustomerIdAndLogSession + 11;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        boolean z2 = AppsFlyerProperties.getInstance().getBoolean(str, z);
        int i3 = waitForCustomerUserId + 39;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return z2;
    }

    public static void values(Context context, Map<String, Object> map) {
        int i = waitForCustomerUserId + 71;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (!(windowManager == null)) {
            int i3 = waitForCustomerUserId + 63;
            setCustomerIdAndLogSession = i3 % 128;
            int i4 = i3 % 2;
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : "p");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (AFKeystoreWrapper((java.lang.String) com.appsflyer.AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, true) != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if ((AFKeystoreWrapper((java.lang.String) com.appsflyer.AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) ? 'H' : '-') != '-') goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFKeystoreWrapper() {
        /*
            r5 = this;
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 101
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = "waitForCustomerId"
            r4 = 45
            if (r0 == 0) goto L_0x0019
            boolean r0 = AFKeystoreWrapper(r3, r1)
            if (r0 == 0) goto L_0x004d
            goto L_0x0026
        L_0x0019:
            boolean r0 = AFKeystoreWrapper(r3, r2)
            if (r0 == 0) goto L_0x0022
            r0 = 72
            goto L_0x0024
        L_0x0022:
            r0 = 45
        L_0x0024:
            if (r0 == r4) goto L_0x004d
        L_0x0026:
            java.lang.String r0 = AFInAppEventType()
            if (r0 != 0) goto L_0x004d
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 11
            int r2 = r0 % 128
            waitForCustomerUserId = r2
            int r0 = r0 % 2
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 63
            int r2 = r0 % 128
            waitForCustomerUserId = r2
            int r0 = r0 % 2
            r2 = 30
            if (r0 == 0) goto L_0x0046
            r4 = 30
        L_0x0046:
            if (r4 == r2) goto L_0x0049
            return r1
        L_0x0049:
            r0 = 0
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception
            throw r0
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFKeystoreWrapper():boolean");
    }

    public final void valueOf(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.AFInAppEventParameterName("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = AFInAppEventType(context).getString("extraReferrers", null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (!(((long) jSONObject.length()) < 4)) {
                int i = waitForCustomerUserId + 61;
                setCustomerIdAndLogSession = i % 128;
                if ((i % 2 == 0 ? 'U' : '`') != 'U') {
                    valueOf(jSONObject);
                } else {
                    valueOf(jSONObject);
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
                        sb.append(str);
                        sb.append(": ");
                        AFLogger.valueOf(sb.toString(), th);
                    }
                }
            }
            jSONObject.put(str, jSONArray.toString());
            valueOf(context, (String) "extraReferrers", jSONObject.toString());
            int i2 = waitForCustomerUserId + 105;
            setCustomerIdAndLogSession = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 24 : 10) != 10) {
                int i3 = 47 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if ((r0 == -1 ? 25 : 'L') != 25) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        if ((r0 == -1) != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r3 = r3.substring(r0);
        r0 = waitForCustomerUserId + 59;
        setCustomerIdAndLogSession = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r3) {
        /*
            int r0 = waitForCustomerUserId
            int r0 = r0 + 101
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            r1 = 39
            if (r0 != 0) goto L_0x0010
            r0 = 4
            goto L_0x0012
        L_0x0010:
            r0 = 39
        L_0x0012:
            r2 = -1
            if (r0 == r1) goto L_0x0027
            r0 = 31
            int r0 = r3.indexOf(r0)
            r1 = 25
            if (r0 != r2) goto L_0x0022
            r2 = 25
            goto L_0x0024
        L_0x0022:
            r2 = 76
        L_0x0024:
            if (r2 == r1) goto L_0x0034
            goto L_0x0047
        L_0x0027:
            r0 = 63
            int r0 = r3.indexOf(r0)
            if (r0 != r2) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r1 == 0) goto L_0x0047
        L_0x0034:
            int r3 = waitForCustomerUserId
            int r3 = r3 + 19
            int r0 = r3 % 128
            setCustomerIdAndLogSession = r0
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0043
            java.lang.String r3 = ""
            return r3
        L_0x0043:
            r3 = 0
            throw r3     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r3 = move-exception
            throw r3
        L_0x0047:
            java.lang.String r3 = r3.substring(r0)
            int r0 = waitForCustomerUserId
            int r0 = r0 + 59
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFKeystoreWrapper(java.lang.String):java.lang.String");
    }

    public static boolean AFInAppEventType(SharedPreferences sharedPreferences) {
        int i = waitForCustomerUserId + 89;
        setCustomerIdAndLogSession = i % 128;
        boolean z = i % 2 != 0;
        String string = sharedPreferences.getString("sentSuccessfully", null);
        if (z) {
            boolean parseBoolean = Boolean.parseBoolean(string);
            int i2 = waitForCustomerUserId + 3;
            setCustomerIdAndLogSession = i2 % 128;
            if (i2 % 2 != 0) {
                return parseBoolean;
            }
            int i3 = 42 / 0;
            return parseBoolean;
        }
        Boolean.parseBoolean(string);
        throw null;
    }

    public static void AFInAppEventType(Context context, Map<String, ? super String> map) {
        int i = waitForCustomerUserId + 15;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        u uVar = com.appsflyer.internal.u.d.valueOf;
        a AFInAppEventType2 = u.AFInAppEventType(context);
        map.put("network", AFInAppEventType2.AFKeystoreWrapper);
        boolean z = false;
        if (AFInAppEventType2.values != null) {
            int i3 = waitForCustomerUserId + 103;
            setCustomerIdAndLogSession = i3 % 128;
            if ((i3 % 2 == 0 ? '*' : 24) != 24) {
                map.put(HSLCriteriaBuilder.OPERATOR, AFInAppEventType2.values);
                int i4 = 66 / 0;
            } else {
                map.put(HSLCriteriaBuilder.OPERATOR, AFInAppEventType2.values);
            }
        }
        if ((AFInAppEventType2.AFInAppEventType != null ? (char) 14 : 20) == 14) {
            int i5 = setCustomerIdAndLogSession + 1;
            waitForCustomerUserId = i5 % 128;
            if (i5 % 2 == 0) {
                z = true;
            }
            if (z) {
                map.put("carrier", AFInAppEventType2.AFInAppEventType);
                int i6 = waitForCustomerUserId + 43;
                setCustomerIdAndLogSession = i6 % 128;
                int i7 = i6 % 2;
                return;
            }
            map.put("carrier", AFInAppEventType2.AFInAppEventType);
            throw null;
        }
    }

    private boolean getLevel() {
        String str;
        if (this.onAppOpenAttribution > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.onAppOpenAttribution;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            String valueOf2 = valueOf(simpleDateFormat, this.onAppOpenAttribution);
            String valueOf3 = valueOf(simpleDateFormat, this.onResponseNative);
            if (currentTimeMillis < this.onConversionDataSuccess) {
                int i = setCustomerIdAndLogSession + 115;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
                if (!(isStopped())) {
                    AFLogger.values(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{valueOf2, valueOf3, Long.valueOf(currentTimeMillis), Long.valueOf(this.onConversionDataSuccess)}));
                    return true;
                }
            }
            if (!isStopped()) {
                int i3 = setCustomerIdAndLogSession + 21;
                waitForCustomerUserId = i3 % 128;
                if ((i3 % 2 != 0 ? 'U' : 'S') != 'S') {
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[2];
                    objArr[1] = valueOf2;
                    objArr[0] = valueOf3;
                    objArr[5] = Long.valueOf(currentTimeMillis);
                    str = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", objArr);
                } else {
                    str = String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{valueOf2, valueOf3, Long.valueOf(currentTimeMillis)});
                }
                AFLogger.values(str);
            }
        } else {
            if ((!isStopped() ? 24 : '.') != '.') {
                int i4 = waitForCustomerUserId + 125;
                setCustomerIdAndLogSession = i4 % 128;
                if (i4 % 2 != 0) {
                    AFLogger.values((String) "Sending first launch for this session!");
                } else {
                    AFLogger.values((String) "Sending first launch for this session!");
                    throw null;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r1 != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void values(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 121
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = "onelinkVersion"
            java.lang.String r3 = "oneLinkSlug"
            if (r0 == 0) goto L_0x0029
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r3)
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r3.getString(r2)
            r3 = 68
            int r3 = r3 / r1
            if (r0 == 0) goto L_0x0043
            goto L_0x003e
        L_0x0027:
            r4 = move-exception
            throw r4
        L_0x0029:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r3)
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r3.getString(r2)
            if (r0 == 0) goto L_0x003c
            r1 = 1
        L_0x003c:
            if (r1 == 0) goto L_0x0043
        L_0x003e:
            java.lang.String r1 = "onelink_id"
            r4.put(r1, r0)
        L_0x0043:
            r0 = 15
            if (r2 == 0) goto L_0x004a
            r1 = 15
            goto L_0x004c
        L_0x004a:
            r1 = 69
        L_0x004c:
            if (r1 == r0) goto L_0x004f
            goto L_0x005e
        L_0x004f:
            int r0 = waitForCustomerUserId
            int r0 = r0 + 53
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            java.lang.String r0 = "onelink_ver"
            r4.put(r0, r2)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.values(java.util.Map):void");
    }

    private aq.a AFKeystoreWrapper(final Map<String, String> map) {
        AnonymousClass6 r0 = new aq.a() {
            public final void AFKeystoreWrapper(String str) {
                ao.AFInAppEventType(str, Error.NETWORK);
            }

            public final void valueOf(Map<String, String> map) {
                for (String next : map.keySet()) {
                    map.put(next, map.get(next));
                }
                ao.AFInAppEventType(map);
            }
        };
        int i = setCustomerIdAndLogSession + 31;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? 'C' : 31) == 31) {
            return r0;
        }
        throw null;
    }

    public static boolean AFKeystoreWrapper(Context context) {
        if ((!AFInAppEventType(context).contains("appsFlyerCount") ? '>' : '/') != '>') {
            int i = setCustomerIdAndLogSession + 73;
            waitForCustomerUserId = i % 128;
            int i2 = i % 2;
            return false;
        }
        int i3 = setCustomerIdAndLogSession + 13;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
        return true;
    }

    private String AFKeystoreWrapper(Context context, String str) {
        int i = waitForCustomerUserId + 115;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        if (!(context != null)) {
            int i3 = setCustomerIdAndLogSession + 91;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
            int i5 = waitForCustomerUserId + 7;
            setCustomerIdAndLogSession = i5 % 128;
            if ((i5 % 2 == 0 ? (char) 4 : 27) == 27) {
                return null;
            }
            throw null;
        }
        bf bfVar = this.setCustomerUserId;
        if (context != null) {
            int i6 = waitForCustomerUserId + 29;
            setCustomerIdAndLogSession = i6 % 128;
            int i7 = i6 % 2;
            be beVar = bfVar.AFKeystoreWrapper;
            if (1 == 1) {
                beVar.values = context.getApplicationContext();
            }
        }
        return values().AFInAppEventType().AFInAppEventParameterName(str);
    }

    public static String values(String str) {
        Object obj;
        Class<String> cls = String.class;
        int i = waitForCustomerUserId + 93;
        setCustomerIdAndLogSession = i % 128;
        String str2 = null;
        if (i % 2 == 0) {
            try {
                Class<?> cls2 = Class.forName("android.os.SystemProperties");
                Class[] clsArr = new Class[1];
                clsArr[1] = cls;
                Method method = cls2.getMethod(Constant.GET, clsArr);
                Object[] objArr = new Object[0];
                objArr[1] = str;
                obj = method.invoke(null, objArr);
            } catch (Throwable th) {
                AFLogger.valueOf(th.getMessage(), th);
            }
        } else {
            obj = Class.forName("android.os.SystemProperties").getMethod(Constant.GET, new Class[]{cls}).invoke(null, new Object[]{str});
        }
        str2 = (String) obj;
        int i2 = waitForCustomerUserId + 35;
        setCustomerIdAndLogSession = i2 % 128;
        int i3 = i2 % 2;
        return str2;
    }

    private int AFKeystoreWrapper(SharedPreferences sharedPreferences, boolean z) {
        int i = setCustomerIdAndLogSession + 117;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        int valueOf2 = valueOf(sharedPreferences, (String) "appsFlyerInAppEventCount", z);
        int i3 = setCustomerIdAndLogSession + 5;
        waitForCustomerUserId = i3 % 128;
        int i4 = i3 % 2;
        return valueOf2;
    }

    private void AFKeystoreWrapper(i iVar) {
        i iVar2 = iVar;
        Application application = iVar2.AFKeystoreWrapper;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(String.format(onInstallConversionFailureNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventParameterName().getHostName()}));
        outline73.append(application.getPackageName());
        String obj = outline73.toString();
        SharedPreferences AFInAppEventType2 = AFInAppEventType((Context) application);
        int valueOf2 = valueOf(AFInAppEventType2, false);
        int valueOf3 = valueOf(AFInAppEventType2);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", iVar2.values);
        hashMap.put("adrevenue_counter", Integer.valueOf(valueOf3));
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        hashMap.put("af_key", devKey);
        hashMap.put("launch_counter", Integer.valueOf(valueOf2));
        String str = devKey;
        int i = valueOf2;
        hashMap.put(values((String) "ᳲ洀Ｆ䤸?┷띈œ鍏ᵯ潬磻", 29172 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1))).intern(), Long.toString(new Date().getTime()));
        hashMap.put("uid", af.valueOf(new WeakReference(application)));
        String string = AppsFlyerProperties.getInstance().getString(SMTEventParamKeys.SMT_AD_ID);
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserIdEnabled");
        if (!(string2 == null)) {
            int i2 = waitForCustomerUserId + 115;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
            hashMap.put("advertiserIdEnabled", string2);
        }
        if (string != null) {
            hashMap.put(SMTEventParamKeys.SMT_AD_ID, string);
        }
        valueOf((Context) application, (Map<String, Object>) hashMap);
        hashMap.put("device", Build.DEVICE);
        values((Context) application, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            hashMap.put("install_date", valueOf(simpleDateFormat, packageInfo.firstInstallTime));
            String string3 = AFInAppEventType2.getString("appsFlyerFirstInstall", null);
            if (!(string3 != null)) {
                int i4 = setCustomerIdAndLogSession + 119;
                waitForCustomerUserId = i4 % 128;
                int i5 = i4 % 2;
                string3 = AFInAppEventType(simpleDateFormat, (Context) application);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.valueOf("AdRevenue - Exception while collecting app version data ", th);
        }
        i valueOf4 = iVar.AFInAppEventType(obj).AFInAppEventParameterName(hashMap).valueOf(i);
        valueOf4.AFVersionDeclaration = str;
        d dVar = new d(this, valueOf4, 0);
        if (k.values == null) {
            k.values = new k();
        }
        valueOf(k.values.AFKeystoreWrapper(), dVar, 1, TimeUnit.MILLISECONDS);
    }

    public static String init() {
        int i = waitForCustomerUserId + 71;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        String AFInAppEventParameterName2 = AFInAppEventParameterName((String) "appid");
        int i3 = setCustomerIdAndLogSession + 107;
        waitForCustomerUserId = i3 % 128;
        if ((i3 % 2 != 0 ? 'A' : 'W') == 'W') {
            return AFInAppEventParameterName2;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (com.google.android.gms.common.GoogleApiAvailability.zab.isGooglePlayServicesAvailable(r4, com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean init(android.content.Context r4) {
        /*
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 53
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            r1 = 87
            if (r0 == 0) goto L_0x0011
            r0 = 77
            goto L_0x0013
        L_0x0011:
            r0 = 87
        L_0x0013:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x002c
            com.google.android.gms.common.GoogleApiAvailability r0 = com.google.android.gms.common.GoogleApiAvailability.zab     // Catch:{ all -> 0x002a }
            int r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ all -> 0x002a }
            int r0 = r0.isGooglePlayServicesAvailable(r4, r1)     // Catch:{ all -> 0x002a }
            r1 = 16
            int r1 = r1 / r3
            if (r0 != 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 == r2) goto L_0x0036
            goto L_0x004c
        L_0x002a:
            r0 = move-exception
            goto L_0x0047
        L_0x002c:
            com.google.android.gms.common.GoogleApiAvailability r0 = com.google.android.gms.common.GoogleApiAvailability.zab     // Catch:{ all -> 0x002a }
            int r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ all -> 0x002a }
            int r0 = r0.isGooglePlayServicesAvailable(r4, r1)     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x004c
        L_0x0036:
            int r4 = waitForCustomerUserId
            int r4 = r4 + 39
            int r0 = r4 % 128
            setCustomerIdAndLogSession = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0043
            return r2
        L_0x0043:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r4 = move-exception
            throw r4
        L_0x0047:
            java.lang.String r1 = "WARNING:  Google play services is unavailable. "
            com.appsflyer.AFLogger.valueOf(r1, r0)
        L_0x004c:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0056 }
            java.lang.String r0 = "com.google.android.gms"
            r4.getPackageInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x0056 }
            return r2
        L_0x0056:
            r4 = move-exception
            java.lang.String r0 = "WARNING:  Google Play Services is unavailable. "
            com.appsflyer.AFLogger.valueOf(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.init(android.content.Context):boolean");
    }

    public static void valueOf(Context context, String str, String str2) {
        int i = waitForCustomerUserId + 65;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        Editor edit = AFInAppEventType(context).edit();
        edit.putString(str, str2);
        AFInAppEventType(edit);
        int i3 = waitForCustomerUserId + 125;
        setCustomerIdAndLogSession = i3 % 128;
        if (!(i3 % 2 != 0)) {
            throw null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC, Splitter:B:25:0x004e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0045=Splitter:B:22:0x0045, B:31:0x005c=Splitter:B:31:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String values(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x005b, all -> 0x0043 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x005b, all -> 0x0043 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x005b, all -> 0x0043 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x005b, all -> 0x0043 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0041 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.values(r3)     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0041 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0041 }
            r2.close()     // Catch:{ all -> 0x0025 }
            int r5 = waitForCustomerUserId
            int r5 = r5 + 95
            int r0 = r5 % 128
            setCustomerIdAndLogSession = r0
            int r5 = r5 % 2
            goto L_0x002d
        L_0x0025:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.valueOf(r0, r5)
        L_0x002d:
            int r5 = setCustomerIdAndLogSession
            int r5 = r5 + 61
            int r0 = r5 % 128
            waitForCustomerUserId = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0040
            r5 = 89
            int r5 = r5 / 0
            return r4
        L_0x003e:
            r4 = move-exception
            throw r4
        L_0x0040:
            return r4
        L_0x0041:
            r4 = move-exception
            goto L_0x0045
        L_0x0043:
            r4 = move-exception
            r2 = r0
        L_0x0045:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x0081 }
            com.appsflyer.AFLogger.valueOf(r5, r4)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0080
        L_0x0052:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.valueOf(r5, r4)
            goto L_0x0080
        L_0x005b:
            r2 = r0
        L_0x005c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0081 }
            r5.append(r4)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0081 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ all -> 0x0052 }
            int r4 = waitForCustomerUserId
            int r4 = r4 + 113
            int r5 = r4 % 128
            setCustomerIdAndLogSession = r5
            int r4 = r4 % 2
        L_0x0080:
            return r0
        L_0x0081:
            r4 = move-exception
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ all -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.valueOf(r0, r5)
        L_0x0090:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.values(java.io.File, java.lang.String):java.lang.String");
    }

    public final void AFInAppEventType(Context context, Map<String, Object> map, Uri uri) {
        if (!map.containsKey("af_deeplink")) {
            String valueOf2 = valueOf(uri.toString());
            f valueOf3 = f.valueOf();
            if (!(valueOf3.AFVersionDeclaration == null || valueOf3.getLevel == null)) {
                int i = setCustomerIdAndLogSession + 25;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
                if (valueOf2.contains(valueOf3.AFVersionDeclaration)) {
                    Builder buildUpon = Uri.parse(valueOf2).buildUpon();
                    Builder buildUpon2 = Uri.EMPTY.buildUpon();
                    Iterator<Entry<String, String>> it = valueOf3.getLevel.entrySet().iterator();
                    while (true) {
                        if (!(it.hasNext())) {
                            break;
                        }
                        int i3 = setCustomerIdAndLogSession + 3;
                        waitForCustomerUserId = i3 % 128;
                        int i4 = i3 % 2;
                        Entry next = it.next();
                        buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                        buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    }
                    valueOf2 = buildUpon.build().toString();
                    map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
                }
            }
            map.put("af_deeplink", valueOf2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        aq aqVar = new aq(uri, this, context);
        if ((aqVar.values ? 14 : 'S') != 'S') {
            int i5 = waitForCustomerUserId + 21;
            setCustomerIdAndLogSession = i5 % 128;
            if (!(i5 % 2 != 0)) {
                map.put("isBrandedDomain", Boolean.TRUE);
                int i6 = 4 / 0;
            } else {
                map.put("isBrandedDomain", Boolean.TRUE);
            }
        }
        z.AFInAppEventType(context, hashMap, uri);
        if (aqVar.AFInAppEventType()) {
            int i7 = setCustomerIdAndLogSession + 1;
            waitForCustomerUserId = i7 % 128;
            if (i7 % 2 == 0) {
                aqVar.AFKeystoreWrapper = AFKeystoreWrapper((Map<String, String>) hashMap);
                if (k.values == null) {
                    k.values = new k();
                }
                k.values.AFInAppEventType().execute(aqVar);
                int i8 = waitForCustomerUserId + 97;
                setCustomerIdAndLogSession = i8 % 128;
                int i9 = i8 % 2;
                return;
            }
            aqVar.AFKeystoreWrapper = AFKeystoreWrapper((Map<String, String>) hashMap);
            throw null;
        }
        ao.AFInAppEventType((Map<String, String>) hashMap);
    }

    public static void valueOf(Context context, String str, int i) {
        int i2 = setCustomerIdAndLogSession + 45;
        waitForCustomerUserId = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 25 : 5) != 25) {
            Editor edit = AFInAppEventType(context).edit();
            edit.putInt(str, i);
            AFInAppEventType(edit);
            return;
        }
        Editor edit2 = AFInAppEventType(context).edit();
        edit2.putInt(str, i);
        AFInAppEventType(edit2);
        int i3 = 41 / 0;
    }

    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r10v7, types: [java.io.OutputStream, java.io.DataOutputStream] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016e A[Catch:{ all -> 0x0168, all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0178  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(com.appsflyer.internal.i r15) throws java.io.IOException {
        /*
            r14 = this;
            java.net.URL r0 = new java.net.URL
            java.lang.String r1 = r15.onDeepLinkingNative
            r0.<init>(r1)
            byte[] r1 = r15.AFInAppEventParameterName()
            java.lang.String r4 = r15.AFVersionDeclaration
            java.lang.String r2 = r15.init
            boolean r3 = r15.valueOf()
            android.app.Application r5 = r15.AFKeystoreWrapper
            com.appsflyer.attribution.AppsFlyerRequestListener r6 = r15.AFInAppEventParameterName
            com.appsflyer.internal.bg r7 = r14.values()
            com.appsflyer.internal.cl r7 = r7.getLevel()
            r8 = 66
            if (r3 == 0) goto L_0x0025
            r9 = 3
            goto L_0x0027
        L_0x0025:
            r9 = 66
        L_0x0027:
            if (r9 == r8) goto L_0x002e
            int r8 = r15.onInstallConversionFailureNative
            r7.valueOf(r8)
        L_0x002e:
            r8 = 0
            java.net.URLConnection r9 = r0.openConnection()     // Catch:{ all -> 0x0175 }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ all -> 0x0175 }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ all -> 0x0175 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ all -> 0x0175 }
            java.lang.String r10 = "POST"
            r9.setRequestMethod(r10)     // Catch:{ all -> 0x0172 }
            int r10 = r1.length     // Catch:{ all -> 0x0172 }
            java.lang.String r11 = "Content-Length"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0172 }
            r9.setRequestProperty(r11, r10)     // Catch:{ all -> 0x0172 }
            java.lang.String r10 = "Content-Type"
            boolean r11 = r15.AFInAppEventType()     // Catch:{ all -> 0x0172 }
            r12 = 0
            r13 = 1
            if (r11 == 0) goto L_0x0056
            r11 = 0
            goto L_0x0057
        L_0x0056:
            r11 = 1
        L_0x0057:
            if (r11 == 0) goto L_0x005c
            java.lang.String r11 = "application/json"
            goto L_0x005e
        L_0x005c:
            java.lang.String r11 = "application/octet-stream"
        L_0x005e:
            r9.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0172 }
            r10 = 10000(0x2710, float:1.4013E-41)
            r9.setConnectTimeout(r10)     // Catch:{ all -> 0x0172 }
            r9.setDoOutput(r13)     // Catch:{ all -> 0x0172 }
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0172 }
            java.lang.String r11 = "http_cache"
            boolean r10 = r10.getBoolean(r11, r13)     // Catch:{ all -> 0x0172 }
            if (r10 != 0) goto L_0x0078
            r9.setUseCaches(r12)     // Catch:{ all -> 0x0172 }
        L_0x0078:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x016b }
            java.io.OutputStream r11 = r9.getOutputStream()     // Catch:{ all -> 0x016b }
            r10.<init>(r11)     // Catch:{ all -> 0x016b }
            r10.write(r1)     // Catch:{ all -> 0x0168 }
            r10.close()     // Catch:{ all -> 0x0172 }
            int r1 = setCustomerIdAndLogSession
            int r1 = r1 + 97
            int r10 = r1 % 128
            waitForCustomerUserId = r10
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0164
            int r1 = r9.getResponseCode()     // Catch:{ all -> 0x0172 }
            if (r3 == 0) goto L_0x009e
            int r8 = r15.onInstallConversionFailureNative     // Catch:{ all -> 0x0172 }
            r7.AFInAppEventType(r8)     // Catch:{ all -> 0x0172 }
        L_0x009e:
            java.lang.String r7 = AFInAppEventParameterName(r9)     // Catch:{ all -> 0x0172 }
            com.appsflyer.internal.ak r8 = com.appsflyer.internal.ak.AFInAppEventType()     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0172 }
            r8.values(r0, r1, r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = "response code: "
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.concat(r8)     // Catch:{ all -> 0x0172 }
            com.appsflyer.AFLogger.values(r0)     // Catch:{ all -> 0x0172 }
            android.content.SharedPreferences r0 = AFInAppEventType(r5)     // Catch:{ all -> 0x0172 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r1 != r8) goto L_0x00c4
            r8 = 0
            goto L_0x00c5
        L_0x00c4:
            r8 = 1
        L_0x00c5:
            if (r8 == 0) goto L_0x00ef
            if (r6 == 0) goto L_0x0153
            int r2 = com.appsflyer.attribution.RequestError.RESPONSE_CODE_FAILURE     // Catch:{ all -> 0x0172 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0172 }
            r3.<init>()     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = com.appsflyer.internal.ba.AFInAppEventType     // Catch:{ all -> 0x0172 }
            r3.append(r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = " "
            r3.append(r7)     // Catch:{ all -> 0x0172 }
            r3.append(r1)     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0172 }
            r6.onError(r2, r3)     // Catch:{ all -> 0x0172 }
            int r2 = waitForCustomerUserId
            int r2 = r2 + 53
            int r3 = r2 % 128
            setCustomerIdAndLogSession = r3
            int r2 = r2 % 2
            goto L_0x0153
        L_0x00ef:
            if (r5 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0172 }
            r14.onResponseNative = r10     // Catch:{ all -> 0x0172 }
            com.appsflyer.internal.bg r3 = r14.values()     // Catch:{ all -> 0x0172 }
            r3.AFKeystoreWrapper()     // Catch:{ all -> 0x0172 }
            int r3 = setCustomerIdAndLogSession
            int r3 = r3 + 17
            int r8 = r3 % 128
            waitForCustomerUserId = r8
            int r3 = r3 % 2
        L_0x010a:
            if (r6 == 0) goto L_0x010e
            r3 = 1
            goto L_0x010f
        L_0x010e:
            r3 = 0
        L_0x010f:
            if (r3 == 0) goto L_0x0127
            int r3 = waitForCustomerUserId
            int r3 = r3 + r13
            int r8 = r3 % 128
            setCustomerIdAndLogSession = r8
            int r3 = r3 % 2
            r6.onSuccess()     // Catch:{ all -> 0x0172 }
            int r3 = setCustomerIdAndLogSession
            int r3 = r3 + 37
            int r6 = r3 % 128
            waitForCustomerUserId = r6
            int r3 = r3 % 2
        L_0x0127:
            if (r2 == 0) goto L_0x0135
            com.appsflyer.internal.bg r3 = r14.values()     // Catch:{ all -> 0x0172 }
            com.appsflyer.internal.l r3 = r3.AFVersionDeclaration()     // Catch:{ all -> 0x0172 }
            r3.valueOf(r2)     // Catch:{ all -> 0x0172 }
            goto L_0x013f
        L_0x0135:
            java.lang.String r2 = "sentSuccessfully"
            java.lang.String r3 = "true"
            valueOf(r5, r2, r3)     // Catch:{ all -> 0x0172 }
            r14.onAppOpenAttributionNative(r5)     // Catch:{ all -> 0x0172 }
        L_0x013f:
            com.appsflyer.internal.cd r2 = new com.appsflyer.internal.cd     // Catch:{ all -> 0x0172 }
            r2.<init>(r5)     // Catch:{ all -> 0x0172 }
            r2.AFKeystoreWrapper()     // Catch:{ all -> 0x0172 }
            org.json.JSONObject r2 = com.appsflyer.internal.as.AFInAppEventParameterName(r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = "send_background"
            boolean r2 = r2.optBoolean(r3, r12)     // Catch:{ all -> 0x0172 }
            r14.onValidateInApp = r2     // Catch:{ all -> 0x0172 }
        L_0x0153:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0172 }
            r8 = 0
            r2 = r14
            r3 = r15
            r6 = r0
            com.appsflyer.internal.cg.AFInAppEventType(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0172 }
            if (r12 == r13) goto L_0x0163
            r9.disconnect()
        L_0x0163:
            return
        L_0x0164:
            r9.getResponseCode()     // Catch:{ all -> 0x0172 }
            throw r8     // Catch:{ all -> 0x0172 }
        L_0x0168:
            r15 = move-exception
            r8 = r10
            goto L_0x016c
        L_0x016b:
            r15 = move-exception
        L_0x016c:
            if (r8 == 0) goto L_0x0171
            r8.close()     // Catch:{ all -> 0x0172 }
        L_0x0171:
            throw r15     // Catch:{ all -> 0x0172 }
        L_0x0172:
            r15 = move-exception
            r8 = r9
            goto L_0x0176
        L_0x0175:
            r15 = move-exception
        L_0x0176:
            if (r8 == 0) goto L_0x017b
            r8.disconnect()
        L_0x017b:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.init(com.appsflyer.internal.i):void");
    }

    private void valueOf(Context context) {
        this.updateServerUninstallToken = new HashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass3 r2 = new com.appsflyer.internal.l.d() {
            public final void valueOf(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.values("Facebook Deferred AppLink data received: ".concat(str));
                    ac.AFKeystoreWrapper(ac.this).put("link", str);
                    if (str2 != null) {
                        ac.AFKeystoreWrapper(ac.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("promo_code", str3);
                        hashMap.put("deeplink_context", hashMap2);
                        ac.AFKeystoreWrapper(ac.this).put("extras", hashMap);
                    }
                } else {
                    ac.AFKeystoreWrapper(ac.this).put("link", "");
                }
                ac.AFKeystoreWrapper(ac.this).put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }

            public final void values(String str) {
                ac.AFKeystoreWrapper(ac.this).put("error", str);
            }
        };
        try {
            Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke(null, new Object[]{context});
            Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler(cls, r2) {
                public /* synthetic */ Class valueOf;
                public /* synthetic */ d values;

                {
                    this.valueOf = r1;
                    this.values = r2;
                }

                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    String str;
                    String str2;
                    String str3;
                    if (method.getName().equals("onDeferredAppLinkDataFetched")) {
                        if (objArr[0] != null) {
                            Bundle cast = Bundle.class.cast(this.valueOf.getMethod("getArgumentBundle", new Class[0]).invoke(this.valueOf.cast(objArr[0]), new Object[0]));
                            if (cast != null) {
                                str = cast.getString("com.facebook.platform.APPLINK_NATIVE_URL");
                                str3 = cast.getString("target_url");
                                Bundle bundle = cast.getBundle("extras");
                                if (bundle != null) {
                                    Bundle bundle2 = bundle.getBundle("deeplink_context");
                                    if (bundle2 != null) {
                                        str2 = bundle2.getString("promo_code");
                                    }
                                }
                                str2 = null;
                            } else {
                                str2 = null;
                                str = null;
                                str3 = null;
                            }
                            d dVar = this.values;
                            if (dVar != null) {
                                dVar.valueOf(str, str3, str2);
                            }
                        } else {
                            d dVar2 = this.values;
                            if (dVar2 != null) {
                                dVar2.valueOf(null, null, null);
                            }
                        }
                        return null;
                    }
                    d dVar3 = this.values;
                    if (dVar3 != null) {
                        dVar3.values("onDeferredAppLinkDataFetched invocation failed");
                    }
                    return null;
                }
            });
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()));
            if ((TextUtils.isEmpty(string) ? (char) 11 : 6) != 11) {
                method.invoke(null, new Object[]{context, string, newProxyInstance});
                return;
            }
            int i = setCustomerIdAndLogSession + 119;
            waitForCustomerUserId = i % 128;
            int i2 = i % 2;
            r2.values("Facebook app id not defined in resources");
            int i3 = setCustomerIdAndLogSession + 87;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
        } catch (NoSuchMethodException e2) {
            r2.values(e2.toString());
        } catch (InvocationTargetException e3) {
            r2.values(e3.toString());
        } catch (ClassNotFoundException e4) {
            r2.values(e4.toString());
        } catch (IllegalAccessException e5) {
            r2.values(e5.toString());
        }
    }

    private void AFInAppEventParameterName(Context context, ch chVar) {
        int i = setCustomerIdAndLogSession + 95;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        bf bfVar = this.setCustomerUserId;
        if (context != null) {
            int i3 = waitForCustomerUserId + 19;
            setCustomerIdAndLogSession = i3 % 128;
            int i4 = i3 % 2;
            be beVar = bfVar.AFKeystoreWrapper;
            if (context != null) {
                beVar.values = context.getApplicationContext();
            }
        }
        cl level = values().getLevel();
        cj AFInAppEventParameterName2 = n.AFInAppEventParameterName(context);
        if ((level.AFInAppEventType() ? '8' : 'A') != 'A') {
            level.AFInAppEventParameterName.put("api_name", chVar.toString());
            level.valueOf(AFInAppEventParameterName2);
            int i5 = waitForCustomerUserId + 123;
            setCustomerIdAndLogSession = i5 % 128;
            int i6 = i5 % 2;
        }
        level.AFKeystoreWrapper();
    }

    public final bv values(Context context) {
        bf bfVar = this.setCustomerUserId;
        if (context != null) {
            bfVar.AFKeystoreWrapper.values = context.getApplicationContext();
        }
        Context context2 = this.setCustomerUserId.AFKeystoreWrapper.values;
        if (context2 != null) {
            return new bc(AFInAppEventType(context2));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    private void AFInAppEventParameterName(Context context, String str, Map<String, Object> map) {
        co coVar = new co();
        Activity activity = null;
        if (context != null) {
            int i = waitForCustomerUserId + 119;
            setCustomerIdAndLogSession = i % 128;
            if (i % 2 != 0) {
                coVar.AFKeystoreWrapper = (Application) context.getApplicationContext();
            } else {
                coVar.AFKeystoreWrapper = (Application) context.getApplicationContext();
                throw null;
            }
        }
        coVar.getLevel = str;
        coVar.values = map;
        if (!(context instanceof Activity)) {
            int i2 = waitForCustomerUserId + 35;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
        } else {
            int i4 = setCustomerIdAndLogSession + 73;
            waitForCustomerUserId = i4 % 128;
            if (i4 % 2 == 0) {
                activity = (Activity) context;
            } else {
                Activity activity2 = (Activity) context;
                throw null;
            }
        }
        AFKeystoreWrapper((i) coVar, activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r2 != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        com.appsflyer.AFLogger.values((java.lang.String) "Allowing multiple launches within a 5 second time window.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void values(com.appsflyer.internal.i r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getLevel
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            boolean r3 = r5.AFKeystoreWrapper()
            if (r3 == 0) goto L_0x0011
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            if (r3 == 0) goto L_0x001a
            java.lang.String r6 = "CustomerUserId not set, reporting is disabled"
            com.appsflyer.AFLogger.values(r6, r2)
            return
        L_0x001a:
            if (r0 == 0) goto L_0x0083
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 43
            int r3 = r0 % 128
            waitForCustomerUserId = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x002a
            r0 = 0
            goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            java.lang.String r3 = "launchProtectEnabled"
            if (r0 == r2) goto L_0x003a
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r2)
            if (r0 == 0) goto L_0x006e
            goto L_0x0048
        L_0x003a:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r2)
            if (r0 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            if (r2 == 0) goto L_0x006e
        L_0x0048:
            boolean r0 = r5.getLevel()
            if (r0 == 0) goto L_0x0073
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 79
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            com.appsflyer.attribution.AppsFlyerRequestListener r6 = r6.AFInAppEventParameterName
            r0 = 41
            if (r6 == 0) goto L_0x0061
            r1 = 41
            goto L_0x0063
        L_0x0061:
            r1 = 22
        L_0x0063:
            if (r1 == r0) goto L_0x0066
            goto L_0x006d
        L_0x0066:
            int r0 = com.appsflyer.attribution.RequestError.EVENT_TIMEOUT
            java.lang.String r1 = com.appsflyer.internal.ba.valueOf
            r6.onError(r0, r1)
        L_0x006d:
            return
        L_0x006e:
            java.lang.String r0 = "Allowing multiple launches within a 5 second time window."
            com.appsflyer.AFLogger.values(r0)
        L_0x0073:
            long r2 = java.lang.System.currentTimeMillis()
            r5.onAppOpenAttribution = r2
            int r0 = waitForCustomerUserId
            int r0 = r0 + 101
            int r2 = r0 % 128
            setCustomerIdAndLogSession = r2
            int r0 = r0 % 2
        L_0x0083:
            com.appsflyer.internal.k r0 = com.appsflyer.internal.k.values
            if (r0 != 0) goto L_0x008e
            com.appsflyer.internal.k r0 = new com.appsflyer.internal.k
            r0.<init>()
            com.appsflyer.internal.k.values = r0
        L_0x008e:
            com.appsflyer.internal.k r0 = com.appsflyer.internal.k.values
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.AFKeystoreWrapper()
            com.appsflyer.internal.ac$b r2 = new com.appsflyer.internal.ac$b
            r2.<init>(r5, r6, r1)
            r3 = 0
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            valueOf(r0, r2, r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.values(com.appsflyer.internal.i):void");
    }

    public static String valueOf(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        int i = setCustomerIdAndLogSession + 19;
        waitForCustomerUserId = i % 128;
        int i2 = i % 2;
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.Object> r7, java.lang.String r8, java.lang.String r9) {
        /*
            r3 = this;
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 105
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            if (r6 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x002c
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 57
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            java.lang.String r0 = r6.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0026
            goto L_0x002c
        L_0x0026:
            com.appsflyer.internal.co r0 = new com.appsflyer.internal.co
            r0.<init>()
            goto L_0x0031
        L_0x002c:
            com.appsflyer.internal.cp r0 = new com.appsflyer.internal.cp
            r0.<init>()
        L_0x0031:
            r1 = 95
            if (r4 == 0) goto L_0x0038
            r2 = 9
            goto L_0x003a
        L_0x0038:
            r2 = 95
        L_0x003a:
            if (r2 == r1) goto L_0x0044
            android.content.Context r4 = r4.getApplicationContext()
            android.app.Application r4 = (android.app.Application) r4
            r0.AFKeystoreWrapper = r4
        L_0x0044:
            r0.getLevel = r6
            r0.AFVersionDeclaration = r5
            r0.values = r7
            r0.AppsFlyer2dXConversionCallback = r8
            r0.valueOf = r9
            r3.values(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFInAppEventParameterName(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean valueOf(com.appsflyer.internal.i r5, android.content.SharedPreferences r6) {
        /*
            r4 = this;
            r0 = 0
            int r1 = r4.valueOf(r6, r0)
            r2 = 1
            if (r1 != r2) goto L_0x000a
            r3 = 1
            goto L_0x000b
        L_0x000a:
            r3 = 0
        L_0x000b:
            if (r3 == 0) goto L_0x001d
            boolean r5 = r5 instanceof com.appsflyer.internal.ci
            if (r5 != 0) goto L_0x001d
            int r5 = setCustomerIdAndLogSession
            int r5 = r5 + 17
            int r3 = r5 % 128
            waitForCustomerUserId = r3
            int r5 = r5 % 2
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r6 = r6.getBoolean(r3, r0)
            if (r6 != 0) goto L_0x003d
            r6 = 42
            if (r1 != r2) goto L_0x002d
            r1 = 96
            goto L_0x002f
        L_0x002d:
            r1 = 42
        L_0x002f:
            if (r1 == r6) goto L_0x003d
            int r6 = setCustomerIdAndLogSession
            int r6 = r6 + 115
            int r1 = r6 % 128
            waitForCustomerUserId = r1
            int r6 = r6 % 2
            r6 = 1
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            if (r6 != 0) goto L_0x0042
            r6 = 0
            goto L_0x0043
        L_0x0042:
            r6 = 1
        L_0x0043:
            r1 = 0
            if (r6 == 0) goto L_0x0047
            goto L_0x005e
        L_0x0047:
            int r6 = waitForCustomerUserId
            int r6 = r6 + 15
            int r3 = r6 % 128
            setCustomerIdAndLogSession = r3
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x006f
            r6 = 87
            if (r5 == 0) goto L_0x005a
            r5 = 82
            goto L_0x005c
        L_0x005a:
            r5 = 87
        L_0x005c:
            if (r5 == r6) goto L_0x006e
        L_0x005e:
            int r5 = waitForCustomerUserId
            int r5 = r5 + 45
            int r6 = r5 % 128
            setCustomerIdAndLogSession = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x006b
            return r2
        L_0x006b:
            throw r1     // Catch:{ all -> 0x006c }
        L_0x006c:
            r5 = move-exception
            throw r5
        L_0x006e:
            return r0
        L_0x006f:
            throw r1     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.valueOf(com.appsflyer.internal.i, android.content.SharedPreferences):boolean");
    }

    private void valueOf(Map<String, Object> map) {
        int i = setCustomerIdAndLogSession + 85;
        waitForCustomerUserId = i % 128;
        if (i % 2 == 0) {
            ap AFKeystoreWrapper2 = values().values().AFKeystoreWrapper();
            if ((AFKeystoreWrapper2 != null ? 'F' : 16) == 'F') {
                map.put(GenericMessageRequest.KEY_RECIPIENT, AFKeystoreWrapper2.AFKeystoreWrapper());
            }
            int i2 = waitForCustomerUserId + 79;
            setCustomerIdAndLogSession = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            return;
        }
        values().values().AFKeystoreWrapper();
        throw null;
    }

    public static void AFInAppEventType(String str) {
        try {
            if ((new JSONObject(str).has("pid") ? 'I' : 'A') != 'I') {
                AFLogger.AppsFlyer2dXConversionCallback("Cannot set preinstall attribution data without a media source");
                int i = setCustomerIdAndLogSession + 87;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
                return;
            }
            int i3 = waitForCustomerUserId + 103;
            setCustomerIdAndLogSession = i3 % 128;
            if ((i3 % 2 == 0 ? 'X' : '&') != 'X') {
                values((String) "preInstallName", str);
                int i4 = waitForCustomerUserId + 55;
                setCustomerIdAndLogSession = i4 % 128;
                int i5 = i4 % 2;
                return;
            }
            values((String) "preInstallName", str);
            throw null;
        } catch (JSONException e2) {
            AFLogger.valueOf("Error parsing JSON for preinstall", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AFKeystoreWrapper(com.appsflyer.internal.i r7, android.app.Activity r8) {
        /*
            r6 = this;
            android.app.Application r0 = r7.AFKeystoreWrapper
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r8 == 0) goto L_0x0033
            int r4 = waitForCustomerUserId
            int r4 = r4 + 35
            int r5 = r4 % 128
            setCustomerIdAndLogSession = r5
            int r4 = r4 % 2
            android.content.Intent r4 = r8.getIntent()
            if (r4 == 0) goto L_0x001a
            r4 = 0
            goto L_0x001b
        L_0x001a:
            r4 = 1
        L_0x001b:
            if (r4 == 0) goto L_0x001e
            goto L_0x0033
        L_0x001e:
            android.net.Uri r8 = com.appsflyer.internal.ap.AFKeystoreWrapper(r8)
            if (r8 == 0) goto L_0x0033
            int r4 = setCustomerIdAndLogSession
            int r4 = r4 + 117
            int r5 = r4 % 128
            waitForCustomerUserId = r5
            int r4 = r4 % 2
            java.lang.String r8 = r8.toString()
            goto L_0x0034
        L_0x0033:
            r8 = r2
        L_0x0034:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = r4.getDevKey()
            if (r4 != 0) goto L_0x003f
            r1 = 1
        L_0x003f:
            if (r1 == r3) goto L_0x0067
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r1.getReferrer(r0)
            r1 = 46
            if (r0 != 0) goto L_0x0050
            r3 = 46
            goto L_0x0052
        L_0x0050:
            r3 = 58
        L_0x0052:
            if (r3 == r1) goto L_0x005f
            int r1 = waitForCustomerUserId
            int r1 = r1 + 97
            int r2 = r1 % 128
            setCustomerIdAndLogSession = r2
            int r1 = r1 % 2
            r2 = r0
        L_0x005f:
            r7.AppsFlyer2dXConversionCallback = r2
            r7.valueOf = r8
            r6.values(r7)
            return
        L_0x0067:
            java.lang.String r8 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r8)
            com.appsflyer.attribution.AppsFlyerRequestListener r7 = r7.AFInAppEventParameterName
            if (r7 == 0) goto L_0x0077
            int r8 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.ba.AFInAppEventParameterName
            r7.onError(r8, r0)
        L_0x0077:
            int r7 = setCustomerIdAndLogSession
            int r7 = r7 + 97
            int r8 = r7 % 128
            waitForCustomerUserId = r8
            int r7 = r7 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFKeystoreWrapper(com.appsflyer.internal.i, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if ((r10.contains("access_token") ? (char) 22 : 18) != 22) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r10.contains("access_token") != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String valueOf(java.lang.String r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0017
            int r10 = setCustomerIdAndLogSession
            int r10 = r10 + 9
            int r1 = r10 % 128
            waitForCustomerUserId = r1
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x0016
            r10 = 76
            int r10 = r10 / 0
            return r0
        L_0x0014:
            r10 = move-exception
            throw r10
        L_0x0016:
            return r0
        L_0x0017:
            java.lang.String r1 = "fb\\d*?://authorize.*"
            boolean r1 = r10.matches(r1)
            if (r1 == 0) goto L_0x00e8
            int r1 = waitForCustomerUserId
            int r1 = r1 + 51
            int r2 = r1 % 128
            setCustomerIdAndLogSession = r2
            int r1 = r1 % 2
            java.lang.String r2 = "access_token"
            if (r1 != 0) goto L_0x0043
            boolean r1 = r10.contains(r2)
            r3 = 1
            int r3 = r3 / 0
            r3 = 22
            if (r1 == 0) goto L_0x003b
            r1 = 22
            goto L_0x003d
        L_0x003b:
            r1 = 18
        L_0x003d:
            if (r1 == r3) goto L_0x0049
            goto L_0x00e8
        L_0x0041:
            r10 = move-exception
            throw r10
        L_0x0043:
            boolean r1 = r10.contains(r2)
            if (r1 == 0) goto L_0x00e8
        L_0x0049:
            java.lang.String r1 = AFKeystoreWrapper(r10)
            int r3 = r1.length()
            if (r3 != 0) goto L_0x005e
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 95
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            return r10
        L_0x005e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "&"
            boolean r5 = r1.contains(r4)
            if (r5 == 0) goto L_0x0079
            java.util.ArrayList r3 = new java.util.ArrayList
            java.lang.String[] r5 = r1.split(r4)
            java.util.List r5 = java.util.Arrays.asList(r5)
            r3.<init>(r5)
            goto L_0x007c
        L_0x0079:
            r3.add(r1)
        L_0x007c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0085:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00df
            int r6 = setCustomerIdAndLogSession
            int r6 = r6 + 3
            int r7 = r6 % 128
            waitForCustomerUserId = r7
            int r6 = r6 % 2
            r7 = 35
            if (r6 == 0) goto L_0x009c
            r6 = 47
            goto L_0x009e
        L_0x009c:
            r6 = 35
        L_0x009e:
            if (r6 != r7) goto L_0x00d3
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r6.contains(r2)
            if (r7 == 0) goto L_0x00b0
            r3.remove()
            goto L_0x0085
        L_0x00b0:
            int r7 = r5.length()
            if (r7 == 0) goto L_0x00ba
            r5.append(r4)
            goto L_0x00cf
        L_0x00ba:
            java.lang.String r7 = "?"
            boolean r8 = r6.startsWith(r7)
            r9 = 97
            if (r8 != 0) goto L_0x00c7
            r8 = 97
            goto L_0x00c9
        L_0x00c7:
            r8 = 58
        L_0x00c9:
            if (r8 == r9) goto L_0x00cc
            goto L_0x00cf
        L_0x00cc:
            r5.append(r7)
        L_0x00cf:
            r5.append(r6)
            goto L_0x0085
        L_0x00d3:
            java.lang.Object r10 = r3.next()
            java.lang.String r10 = (java.lang.String) r10
            r10.contains(r2)
            throw r0     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r10 = move-exception
            throw r10
        L_0x00df:
            java.lang.String r0 = r5.toString()
            java.lang.String r10 = r10.replace(r1, r0)
            return r10
        L_0x00e8:
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 111
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x00fb
            r0 = 28
            int r0 = r0 / 0
            return r10
        L_0x00f9:
            r10 = move-exception
            throw r10
        L_0x00fb:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.valueOf(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        if ((com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) != true) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
            int r0 = waitForCustomerUserId
            r1 = 79
            int r0 = r0 + r1
            int r2 = r0 % 128
            setCustomerIdAndLogSession = r2
            int r0 = r0 % 2
            java.lang.String r2 = "collectAndroidIdForceByUser"
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x001c
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r2, r4)
            if (r0 != 0) goto L_0x003a
            goto L_0x002b
        L_0x001c:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r2, r4)
            if (r0 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            if (r0 == r3) goto L_0x003a
        L_0x002b:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r2, r4)
            if (r0 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r0 = 0
            goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            if (r0 != 0) goto L_0x00b1
            int r0 = waitForCustomerUserId
            int r0 = r0 + 85
            int r2 = r0 % 128
            setCustomerIdAndLogSession = r2
            int r0 = r0 % 2
            java.lang.String r0 = "advertiserId"
            java.lang.Object r0 = r6.get(r0)
            if (r0 == 0) goto L_0x00b1
            java.lang.String r0 = r5.init     // Catch:{ Exception -> 0x00ab }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ab }
            r2 = 21
            if (r0 == 0) goto L_0x005c
            r0 = 21
            goto L_0x005e
        L_0x005c:
            r0 = 38
        L_0x005e:
            if (r0 == r2) goto L_0x0061
            goto L_0x0077
        L_0x0061:
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + r2
            int r2 = r0 % 128
            waitForCustomerUserId = r2
            int r0 = r0 % 2
            java.lang.String r0 = "android_id"
            java.lang.Object r0 = r6.remove(r0)     // Catch:{ Exception -> 0x00ab }
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = "validateGaidAndIMEI :: removing: android_id"
            com.appsflyer.AFLogger.values(r0)     // Catch:{ Exception -> 0x00ab }
        L_0x0077:
            java.lang.String r0 = r5.AppsFlyer2dXConversionCallback     // Catch:{ Exception -> 0x00ab }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ab }
            if (r0 == 0) goto L_0x00aa
            int r0 = waitForCustomerUserId
            int r0 = r0 + 29
            int r2 = r0 % 128
            setCustomerIdAndLogSession = r2
            int r0 = r0 % 2
            r2 = 66
            if (r0 != 0) goto L_0x008f
            r1 = 66
        L_0x008f:
            java.lang.String r0 = "imei"
            if (r1 == r2) goto L_0x00a3
            java.lang.Object r6 = r6.remove(r0)     // Catch:{ Exception -> 0x00ab }
            if (r6 == 0) goto L_0x009a
            r3 = 0
        L_0x009a:
            if (r3 == 0) goto L_0x009d
            goto L_0x00aa
        L_0x009d:
            java.lang.String r6 = "validateGaidAndIMEI :: removing: imei"
            com.appsflyer.AFLogger.values(r6)     // Catch:{ Exception -> 0x00ab }
            goto L_0x00aa
        L_0x00a3:
            r6.remove(r0)     // Catch:{ Exception -> 0x00ab }
            r6 = 0
            throw r6     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r6 = move-exception
            throw r6
        L_0x00aa:
            return
        L_0x00ab:
            r6 = move-exception
            java.lang.String r0 = "failed to remove IMEI or AndroidID key from params; "
            com.appsflyer.AFLogger.valueOf(r0, r6)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFInAppEventParameterName(java.util.Map):void");
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String values(java.lang.String r6, int r7) {
        /*
            if (r6 == 0) goto L_0x0006
            char[] r6 = r6.toCharArray()
        L_0x0006:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.dn.valueOf
            monitor-enter(r0)
            com.appsflyer.internal.dn.AFInAppEventType = r7     // Catch:{ all -> 0x003b }
            int r7 = r6.length     // Catch:{ all -> 0x003b }
            char[] r7 = new char[r7]     // Catch:{ all -> 0x003b }
            r1 = 0
            com.appsflyer.internal.dn.values = r1     // Catch:{ all -> 0x003b }
        L_0x0013:
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r2 = r6.length     // Catch:{ all -> 0x003b }
            if (r1 >= r2) goto L_0x0034
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r2 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            char r2 = r6[r2]     // Catch:{ all -> 0x003b }
            int r3 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r4 = com.appsflyer.internal.dn.AFInAppEventType     // Catch:{ all -> 0x003b }
            int r3 = r3 * r4
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch:{ all -> 0x003b }
            long r4 = enableLocationCollection     // Catch:{ all -> 0x003b }
            long r2 = r2 ^ r4
            int r3 = (int) r2     // Catch:{ all -> 0x003b }
            char r2 = (char) r3     // Catch:{ all -> 0x003b }
            r7[r1] = r2     // Catch:{ all -> 0x003b }
            int r1 = com.appsflyer.internal.dn.values     // Catch:{ all -> 0x003b }
            int r1 = r1 + 1
            com.appsflyer.internal.dn.values = r1     // Catch:{ all -> 0x003b }
            goto L_0x0013
        L_0x0034:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x003b }
            r6.<init>(r7)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r6
        L_0x003b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.values(java.lang.String, int):java.lang.String");
    }

    public static boolean AFInAppEventType(File file) {
        int i = waitForCustomerUserId + 73;
        setCustomerIdAndLogSession = i % 128;
        if (i % 2 != 0) {
            boolean z = true;
            if (file == null || !file.exists()) {
                return true;
            }
            int i2 = setCustomerIdAndLogSession + 53;
            waitForCustomerUserId = i2 % 128;
            if (i2 % 2 == 0) {
                z = false;
            }
            if (!z) {
                return false;
            }
            int i3 = 49 / 0;
            return false;
        }
        throw null;
    }

    private String AFInAppEventType(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = AFInAppEventType(context).getString("appsFlyerFirstInstall", null);
        if ((string == null ? ')' : 18) != 18) {
            if (AFKeystoreWrapper(context)) {
                AFLogger.AFInAppEventParameterName("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
                int i = setCustomerIdAndLogSession + 25;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
            } else {
                str = "";
            }
            string = str;
            valueOf(context, (String) "appsFlyerFirstInstall", string);
            int i3 = waitForCustomerUserId + 113;
            setCustomerIdAndLogSession = i3 % 128;
            int i4 = i3 % 2;
        }
        AFLogger.values("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public static void AFKeystoreWrapper(Context context, Map<String, Object> map) {
        com.appsflyer.internal.a.d values2 = C0062a.valueOf.values(context);
        map.put("btl", Float.toString(values2.AFInAppEventType));
        if (!(values2.AFKeystoreWrapper == null)) {
            int i = setCustomerIdAndLogSession + 9;
            waitForCustomerUserId = i % 128;
            if ((i % 2 != 0 ? 'Y' : '+') == '+') {
                map.put("btch", values2.AFKeystoreWrapper);
            } else {
                map.put("btch", values2.AFKeystoreWrapper);
                throw null;
            }
        }
        int i2 = waitForCustomerUserId + 109;
        setCustomerIdAndLogSession = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public static synchronized SharedPreferences AFInAppEventType(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (ac.class) {
            try {
                int i = setCustomerIdAndLogSession + 79;
                waitForCustomerUserId = i % 128;
                int i2 = i % 2;
                if (AFInAppEventParameterName().getSdkVersion == null) {
                    int i3 = waitForCustomerUserId + 25;
                    setCustomerIdAndLogSession = i3 % 128;
                    int i4 = i3 % 2;
                    AFInAppEventParameterName().getSdkVersion = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                    int i5 = setCustomerIdAndLogSession + 7;
                    waitForCustomerUserId = i5 % 128;
                    int i6 = i5 % 2;
                }
                sharedPreferences = AFInAppEventParameterName().getSdkVersion;
            }
        }
        return sharedPreferences;
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x0368 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0375 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x037b A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x038e A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03a0 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03b1 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03db A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03f6 A[SYNTHETIC, Splitter:B:172:0x03f6] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0415 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0428 A[Catch:{ Exception -> 0x042e }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04d2 A[Catch:{ all -> 0x0549 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0573 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x057c A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x05af A[SYNTHETIC, Splitter:B:257:0x05af] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x05f7 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0616 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0646 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0648 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0656 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x06cc A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x06d5 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x06d6 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0712 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x07c1 A[Catch:{ Exception -> 0x00f2, all -> 0x07d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType(com.appsflyer.internal.i r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = "is_stop_tracking_used"
            java.lang.String r4 = "ddl"
            java.lang.String r5 = "af_deeplink"
            java.lang.String r6 = "advertiserId"
            java.lang.String r7 = "versionCode"
            java.lang.String r8 = "Exception while collecting facebook's attribution ID. "
            java.lang.String r9 = "appid"
            java.lang.String r10 = "sdkExtension"
            java.lang.String r11 = "extraReferrers"
            java.lang.String r12 = "AFRequestCache"
            java.lang.String r13 = "yyyy-MM-dd_HHmmssZ"
            android.app.Application r14 = r2.AFKeystoreWrapper
            java.lang.String r15 = r2.AFVersionDeclaration
            r16 = r3
            java.lang.String r3 = r2.getLevel
            r17 = r4
            org.json.JSONObject r4 = new org.json.JSONObject
            r18 = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r2.values
            if (r6 != 0) goto L_0x0031
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L_0x0031:
            r4.<init>(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = r2.AppsFlyer2dXConversionCallback
            r19 = r5
            android.content.SharedPreferences r5 = AFInAppEventType(r14)
            r20 = r7
            boolean r7 = r29.valueOf()
            r21 = r13
            java.lang.String r13 = r2.valueOf
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
            com.appsflyer.internal.ab.AFKeystoreWrapper(r14, r2)
            java.lang.Boolean r22 = com.appsflyer.internal.ab.AFInAppEventType
            if (r22 == 0) goto L_0x0073
            boolean r23 = r22.booleanValue()
            if (r23 != 0) goto L_0x0073
            r23 = r13
            java.util.Map r13 = AFInAppEventType(r2)
            boolean r22 = r22.booleanValue()
            r22 = r22 ^ 1
            r24 = r8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r22)
            r22 = r9
            java.lang.String r9 = "ad_ids_disabled"
            r13.put(r9, r8)
            goto L_0x0079
        L_0x0073:
            r24 = r8
            r22 = r9
            r23 = r13
        L_0x0079:
            long r8 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
            int r13 = android.view.ViewConfiguration.getDoubleTapTimeout()
            int r13 = r13 >> 16
            int r13 = 29173 - r13
            r25 = r4
            java.lang.String r4 = "ᳲ洀Ｆ䤸?┷띈œ鍏ᵯ潬磻"
            java.lang.String r4 = values(r4, r13)
            java.lang.String r4 = r4.intern()
            java.lang.String r13 = java.lang.Long.toString(r8)
            r2.put(r4, r13)
            java.lang.String r4 = com.appsflyer.internal.d.AFKeystoreWrapper(r14, r8)
            if (r4 == 0) goto L_0x00a3
            java.lang.String r8 = "cksm_v1"
            r2.put(r8, r4)
        L_0x00a3:
            boolean r4 = r28.isStopped()     // Catch:{ all -> 0x07d9 }
            if (r4 != 0) goto L_0x00c1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = "******* sendTrackingWithEvent: "
            r4.<init>(r8)     // Catch:{ all -> 0x07d9 }
            if (r7 == 0) goto L_0x00b5
            java.lang.String r8 = "Launch"
            goto L_0x00b6
        L_0x00b5:
            r8 = r3
        L_0x00b6:
            r4.append(r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AFLogger.values(r4)     // Catch:{ all -> 0x07d9 }
            goto L_0x00c6
        L_0x00c1:
            java.lang.String r4 = "Reporting has been stopped"
            com.appsflyer.AFLogger.values(r4)     // Catch:{ all -> 0x07d9 }
        L_0x00c6:
            com.appsflyer.internal.bg r4 = r28.values()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.l r4 = r4.AFVersionDeclaration()     // Catch:{ all -> 0x07d9 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00f2 }
            com.appsflyer.internal.be r9 = r4.AFKeystoreWrapper     // Catch:{ Exception -> 0x00f2 }
            android.content.Context r9 = r9.values     // Catch:{ Exception -> 0x00f2 }
            java.io.File r9 = r9.getFilesDir()     // Catch:{ Exception -> 0x00f2 }
            r8.<init>(r9, r12)     // Catch:{ Exception -> 0x00f2 }
            boolean r8 = r8.exists()     // Catch:{ Exception -> 0x00f2 }
            if (r8 != 0) goto L_0x00f9
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00f2 }
            com.appsflyer.internal.be r4 = r4.AFKeystoreWrapper     // Catch:{ Exception -> 0x00f2 }
            android.content.Context r4 = r4.values     // Catch:{ Exception -> 0x00f2 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x00f2 }
            r8.<init>(r4, r12)     // Catch:{ Exception -> 0x00f2 }
            r8.mkdir()     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00f9
        L_0x00f2:
            r0 = move-exception
            r4 = r0
            java.lang.String r8 = "CACHE: Could not create cache directory"
            com.appsflyer.AFLogger.valueOf(r8, r4)     // Catch:{ all -> 0x07d9 }
        L_0x00f9:
            android.content.pm.PackageManager r4 = r14.getPackageManager()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r8 = r14.getPackageName()     // Catch:{ Exception -> 0x0135 }
            r9 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r8, r9)     // Catch:{ Exception -> 0x0135 }
            java.lang.String[] r4 = r4.requestedPermissions     // Catch:{ Exception -> 0x0135 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r8 = "android.permission.INTERNET"
            boolean r8 = r4.contains(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x011a
            java.lang.String r8 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r8)     // Catch:{ Exception -> 0x0135 }
        L_0x011a:
            java.lang.String r8 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r8 = r4.contains(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0127
            java.lang.String r8 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r8)     // Catch:{ Exception -> 0x0135 }
        L_0x0127:
            java.lang.String r8 = "android.permission.ACCESS_WIFI_STATE"
            boolean r4 = r4.contains(r8)     // Catch:{ Exception -> 0x0135 }
            if (r4 != 0) goto L_0x013c
            java.lang.String r4 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r4)     // Catch:{ Exception -> 0x0135 }
            goto L_0x013c
        L_0x0135:
            r0 = move-exception
            r4 = r0
            java.lang.String r8 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.valueOf(r8, r4)     // Catch:{ all -> 0x07d9 }
        L_0x013c:
            java.lang.String r4 = "af_events_api"
            java.lang.String r8 = "Ტ"
            r9 = 41800(0xa348, float:5.8574E-41)
            r12 = 0
            int r12 = android.graphics.ImageFormat.getBitsPerPixel(r12)     // Catch:{ all -> 0x07d9 }
            int r9 = r9 - r12
            java.lang.String r8 = values(r8, r9)     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = r8.intern()     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "ᳱ쪼끈鿪䖃"
            r8 = 54878(0xd65e, float:7.69E-41)
            long r12 = android.view.ViewConfiguration.getZoomControlsTimeout()     // Catch:{ all -> 0x07d9 }
            r26 = 0
            int r9 = (r12 > r26 ? 1 : (r12 == r26 ? 0 : -1))
            int r8 = r8 - r9
            java.lang.String r4 = values(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r4.intern()     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = android.os.Build.BRAND     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "device"
            java.lang.String r8 = android.os.Build.DEVICE     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "product"
            java.lang.String r8 = android.os.Build.PRODUCT     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "sdk"
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "model"
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "deviceType"
            java.lang.String r8 = android.os.Build.TYPE     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r8)     // Catch:{ all -> 0x07d9 }
            values(r14, r2)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.ax r8 = new com.appsflyer.internal.ax     // Catch:{ all -> 0x07d9 }
            r8.<init>(r14)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.bg r9 = r28.values()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.cl r9 = r9.getLevel()     // Catch:{ all -> 0x07d9 }
            if (r7 == 0) goto L_0x029d
            boolean r12 = AFKeystoreWrapper(r14)     // Catch:{ all -> 0x07d9 }
            if (r12 == 0) goto L_0x01fc
            boolean r12 = r4.isOtherSdkStringDisabled()     // Catch:{ all -> 0x07d9 }
            if (r12 != 0) goto L_0x01c5
            float r12 = onResponseNative(r14)     // Catch:{ all -> 0x07d9 }
            java.lang.String r13 = "batteryLevel"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x07d9 }
            r2.put(r13, r12)     // Catch:{ all -> 0x07d9 }
        L_0x01c5:
            getLevel(r14)     // Catch:{ all -> 0x07d9 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x07d9 }
            r13 = 23
            if (r12 < r13) goto L_0x01d7
            java.lang.Class<android.app.UiModeManager> r12 = android.app.UiModeManager.class
            java.lang.Object r12 = r14.getSystemService(r12)     // Catch:{ all -> 0x07d9 }
            android.app.UiModeManager r12 = (android.app.UiModeManager) r12     // Catch:{ all -> 0x07d9 }
            goto L_0x01df
        L_0x01d7:
            java.lang.String r12 = "uimode"
            java.lang.Object r12 = r14.getSystemService(r12)     // Catch:{ all -> 0x07d9 }
            android.app.UiModeManager r12 = (android.app.UiModeManager) r12     // Catch:{ all -> 0x07d9 }
        L_0x01df:
            if (r12 == 0) goto L_0x01ef
            int r12 = r12.getCurrentModeType()     // Catch:{ all -> 0x07d9 }
            r13 = 4
            if (r12 != r13) goto L_0x01ef
            java.lang.String r12 = "tv"
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x07d9 }
            r2.put(r12, r13)     // Catch:{ all -> 0x07d9 }
        L_0x01ef:
            boolean r12 = com.appsflyer.internal.cf.values(r14)     // Catch:{ all -> 0x07d9 }
            if (r12 == 0) goto L_0x01fc
            java.lang.String r12 = "inst_app"
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x07d9 }
            r2.put(r12, r13)     // Catch:{ all -> 0x07d9 }
        L_0x01fc:
            java.lang.String r12 = "timepassedsincelastlaunch"
            long r26 = r1.onAppOpenAttribution(r14)     // Catch:{ all -> 0x07d9 }
            java.lang.String r13 = java.lang.Long.toString(r26)     // Catch:{ all -> 0x07d9 }
            r2.put(r12, r13)     // Catch:{ all -> 0x07d9 }
            values(r2)     // Catch:{ all -> 0x07d9 }
            AFInAppEventType(r2, r9)     // Catch:{ all -> 0x07d9 }
            java.lang.String r12 = r1.onPause     // Catch:{ all -> 0x07d9 }
            if (r12 == 0) goto L_0x021a
            java.lang.String r12 = "phone"
            java.lang.String r13 = r1.onPause     // Catch:{ all -> 0x07d9 }
            r2.put(r12, r13)     // Catch:{ all -> 0x07d9 }
        L_0x021a:
            boolean r12 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r13 = "referrer"
            if (r12 != 0) goto L_0x0225
            r2.put(r13, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0225:
            r6 = 0
            java.lang.String r6 = r5.getString(r11, r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x022f
            r2.put(r11, r6)     // Catch:{ all -> 0x07d9 }
        L_0x022f:
            java.lang.String r6 = r4.getReferrer(r14)     // Catch:{ all -> 0x07d9 }
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x07d9 }
            if (r11 != 0) goto L_0x0242
            java.lang.Object r11 = r2.get(r13)     // Catch:{ all -> 0x07d9 }
            if (r11 != 0) goto L_0x0242
            r2.put(r13, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0242:
            long r11 = r9.onDeepLinkingNative     // Catch:{ all -> 0x07d9 }
            r26 = 0
            int r6 = (r11 > r26 ? 1 : (r11 == r26 ? 0 : -1))
            if (r6 == 0) goto L_0x0253
            java.lang.String r6 = "prev_session_dur"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r11)     // Catch:{ all -> 0x07d9 }
        L_0x0253:
            android.app.Application r6 = com.appsflyer.internal.ay.AFInAppEventParameterName     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "exception_number"
            if (r6 != 0) goto L_0x025c
            r12 = -1
            goto L_0x0268
        L_0x025c:
            android.app.Application r6 = com.appsflyer.internal.ay.AFInAppEventParameterName     // Catch:{ all -> 0x07d9 }
            android.content.SharedPreferences r6 = AFInAppEventType(r6)     // Catch:{ all -> 0x07d9 }
            r12 = 0
            long r12 = r6.getLong(r11, r12)     // Catch:{ all -> 0x07d9 }
        L_0x0268:
            java.lang.Long r6 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x07d9 }
            r2.put(r11, r6)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.az r6 = r1.setImeiData     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x02a0
            com.appsflyer.internal.az r6 = r1.setImeiData     // Catch:{ all -> 0x07d9 }
            java.util.Map<java.lang.String, java.lang.Object> r11 = r6.values     // Catch:{ all -> 0x07d9 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x07d9 }
            java.lang.String r12 = "partner_data"
            if (r11 != 0) goto L_0x0284
            java.util.Map<java.lang.String, java.lang.Object> r11 = r6.values     // Catch:{ all -> 0x07d9 }
            r2.put(r12, r11)     // Catch:{ all -> 0x07d9 }
        L_0x0284:
            java.util.Map<java.lang.String, java.lang.Object> r11 = r6.valueOf     // Catch:{ all -> 0x07d9 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x07d9 }
            if (r11 != 0) goto L_0x02a0
            java.util.Map r11 = AFInAppEventType(r2)     // Catch:{ all -> 0x07d9 }
            java.util.Map<java.lang.String, java.lang.Object> r13 = r6.valueOf     // Catch:{ all -> 0x07d9 }
            r11.put(r12, r13)     // Catch:{ all -> 0x07d9 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x07d9 }
            r11.<init>()     // Catch:{ all -> 0x07d9 }
            r6.valueOf = r11     // Catch:{ all -> 0x07d9 }
            goto L_0x02a0
        L_0x029d:
            valueOf(r14, r2, r3)     // Catch:{ all -> 0x07d9 }
        L_0x02a0:
            java.lang.String r6 = "KSAppsFlyerId"
            java.lang.String r6 = AFInAppEventParameterName(r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "KSAppsFlyerRICounter"
            java.lang.String r11 = AFInAppEventParameterName(r11)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x02c4
            if (r11 == 0) goto L_0x02c4
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x07d9 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x07d9 }
            if (r12 <= 0) goto L_0x02c4
            java.lang.String r12 = "reinstallCounter"
            r2.put(r12, r11)     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "originalAppsflyerId"
            r2.put(r11, r6)     // Catch:{ all -> 0x07d9 }
        L_0x02c4:
            java.lang.String r6 = "additionalCustomData"
            java.lang.String r6 = AFInAppEventParameterName(r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x02d1
            java.lang.String r11 = "customData"
            r2.put(r11, r6)     // Catch:{ all -> 0x07d9 }
        L_0x02d1:
            android.content.pm.PackageManager r6 = r14.getPackageManager()     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r11 = r14.getPackageName()     // Catch:{ Exception -> 0x02e5 }
            java.lang.String r6 = r6.getInstallerPackageName(r11)     // Catch:{ Exception -> 0x02e5 }
            if (r6 == 0) goto L_0x02ec
            java.lang.String r11 = "installer_package"
            r2.put(r11, r6)     // Catch:{ Exception -> 0x02e5 }
            goto L_0x02ec
        L_0x02e5:
            r0 = move-exception
            r6 = r0
            java.lang.String r11 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.valueOf(r11, r6)     // Catch:{ all -> 0x07d9 }
        L_0x02ec:
            java.lang.String r6 = r4.getString(r10)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x02fb
            int r11 = r6.length()     // Catch:{ all -> 0x07d9 }
            if (r11 <= 0) goto L_0x02fb
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x02fb:
            java.lang.String r6 = r1.AFInAppEventParameterName(r14)     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = r1.AFInAppEventParameterName(r14, r6)     // Catch:{ all -> 0x07d9 }
            if (r10 == 0) goto L_0x030b
            boolean r11 = r10.equals(r6)     // Catch:{ all -> 0x07d9 }
            if (r11 == 0) goto L_0x030f
        L_0x030b:
            if (r10 != 0) goto L_0x0314
            if (r6 == 0) goto L_0x0314
        L_0x030f:
            java.lang.String r10 = "af_latestchannel"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0314:
            java.lang.String r6 = r1.onInstallConversionDataLoadedNative(r14)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x0323
            java.lang.String r10 = "af_installstore"
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0323:
            java.lang.String r6 = r1.onAttributionFailureNative(r14)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x0332
            java.lang.String r10 = "af_preinstall_name"
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0332:
            java.lang.String r6 = r1.onDeepLinkingNative(r14)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x0341
            java.lang.String r10 = "af_currentstore"
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0341:
            java.lang.String r6 = "appsflyerKey"
            if (r15 == 0) goto L_0x034f
            int r10 = r15.length()     // Catch:{ all -> 0x07d9 }
            if (r10 <= 0) goto L_0x034f
            r2.put(r6, r15)     // Catch:{ all -> 0x07d9 }
            goto L_0x0362
        L_0x034f:
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = r10.getDevKey()     // Catch:{ all -> 0x07d9 }
            if (r10 == 0) goto L_0x07cd
            int r11 = r10.length()     // Catch:{ all -> 0x07d9 }
            if (r11 <= 0) goto L_0x07cd
            r2.put(r6, r10)     // Catch:{ all -> 0x07d9 }
        L_0x0362:
            java.lang.String r6 = AFInAppEventType()     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x036d
            java.lang.String r10 = "appUserId"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x036d:
            java.lang.String r6 = "userEmails"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x037b
            java.lang.String r10 = "user_emails"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
            goto L_0x038c
        L_0x037b:
            java.lang.String r6 = "userEmail"
            java.lang.String r6 = AFInAppEventParameterName(r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x038c
            java.lang.String r10 = "sha1_el"
            java.lang.String r6 = com.appsflyer.internal.ag.valueOf(r6)     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x038c:
            if (r3 == 0) goto L_0x039a
            java.lang.String r6 = "eventName"
            r2.put(r6, r3)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "eventValue"
            r10 = r25
            r2.put(r6, r10)     // Catch:{ all -> 0x07d9 }
        L_0x039a:
            java.lang.String r6 = init()     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x03a9
            java.lang.String r6 = AFInAppEventParameterName(r22)     // Catch:{ all -> 0x07d9 }
            r10 = r22
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x03a9:
            java.lang.String r6 = "currencyCode"
            java.lang.String r6 = AFInAppEventParameterName(r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x03d3
            int r10 = r6.length()     // Catch:{ all -> 0x07d9 }
            r11 = 3
            if (r10 == r11) goto L_0x03ce
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "WARNING: currency code should be 3 characters!!! '"
            r10.<init>(r11)     // Catch:{ all -> 0x07d9 }
            r10.append(r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "' is not a legal value."
            r10.append(r11)     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r10)     // Catch:{ all -> 0x07d9 }
        L_0x03ce:
            java.lang.String r10 = "currency"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x03d3:
            java.lang.String r6 = "IS_UPDATE"
            java.lang.String r6 = AFInAppEventParameterName(r6)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x03e0
            java.lang.String r10 = "isUpdate"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x03e0:
            boolean r6 = r1.isPreInstalledApp(r14)     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = "af_preinstalled"
            java.lang.String r6 = java.lang.Boolean.toString(r6)     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "collectFacebookAttrId"
            r10 = 1
            boolean r6 = r4.getBoolean(r6, r10)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x041a
            android.content.pm.PackageManager r6 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x040d, all -> 0x0405 }
            java.lang.String r10 = "com.facebook.katana"
            r11 = 0
            r6.getApplicationInfo(r10, r11)     // Catch:{ NameNotFoundException -> 0x040d, all -> 0x0405 }
            java.lang.String r6 = r1.getAttributionId(r14)     // Catch:{ NameNotFoundException -> 0x040d, all -> 0x0405 }
            goto L_0x0413
        L_0x0405:
            r0 = move-exception
            r6 = r0
            r10 = r24
            com.appsflyer.AFLogger.valueOf(r10, r6)     // Catch:{ all -> 0x07d9 }
            goto L_0x0412
        L_0x040d:
            r10 = r24
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r10)     // Catch:{ all -> 0x07d9 }
        L_0x0412:
            r6 = 0
        L_0x0413:
            if (r6 == 0) goto L_0x041a
            java.lang.String r10 = "fb"
            r2.put(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x041a:
            r1.valueOf(r14, r2)     // Catch:{ all -> 0x07d9 }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x042e }
            r6.<init>(r14)     // Catch:{ Exception -> 0x042e }
            java.lang.String r6 = com.appsflyer.internal.af.valueOf(r6)     // Catch:{ Exception -> 0x042e }
            if (r6 == 0) goto L_0x0445
            java.lang.String r10 = "uid"
            r2.put(r10, r6)     // Catch:{ Exception -> 0x042e }
            goto L_0x0445
        L_0x042e:
            r0 = move-exception
            r6 = r0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = "ERROR: could not get uid "
            r10.<init>(r11)     // Catch:{ all -> 0x07d9 }
            java.lang.String r11 = r6.getMessage()     // Catch:{ all -> 0x07d9 }
            r10.append(r11)     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AFLogger.valueOf(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0445:
            java.lang.String r6 = "lang"
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0453 }
            java.lang.String r10 = r10.getDisplayLanguage()     // Catch:{ Exception -> 0x0453 }
            r2.put(r6, r10)     // Catch:{ Exception -> 0x0453 }
            goto L_0x045a
        L_0x0453:
            r0 = move-exception
            r6 = r0
            java.lang.String r10 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.valueOf(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x045a:
            java.lang.String r6 = "lang_code"
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0468 }
            java.lang.String r10 = r10.getLanguage()     // Catch:{ Exception -> 0x0468 }
            r2.put(r6, r10)     // Catch:{ Exception -> 0x0468 }
            goto L_0x046f
        L_0x0468:
            r0 = move-exception
            r6 = r0
            java.lang.String r10 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.valueOf(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x046f:
            java.lang.String r6 = "country"
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x047d }
            java.lang.String r10 = r10.getCountry()     // Catch:{ Exception -> 0x047d }
            r2.put(r6, r10)     // Catch:{ Exception -> 0x047d }
            goto L_0x0484
        L_0x047d:
            r0 = move-exception
            r6 = r0
            java.lang.String r10 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.valueOf(r10, r6)     // Catch:{ all -> 0x07d9 }
        L_0x0484:
            java.lang.String r6 = "platformextension"
            com.appsflyer.internal.al r10 = r1.onValidateInAppFailure     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = r10.AFInAppEventType()     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r10)     // Catch:{ all -> 0x07d9 }
            AFInAppEventType(r14, r2)     // Catch:{ all -> 0x07d9 }
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x07d9 }
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x07d9 }
            r11 = r21
            r6.<init>(r11, r10)     // Catch:{ all -> 0x07d9 }
            android.content.pm.PackageManager r10 = r14.getPackageManager()     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r12 = r14.getPackageName()     // Catch:{ Exception -> 0x04b4 }
            r13 = 0
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r12, r13)     // Catch:{ Exception -> 0x04b4 }
            long r12 = r10.firstInstallTime     // Catch:{ Exception -> 0x04b4 }
            java.lang.String r10 = "installDate"
            java.lang.String r12 = valueOf(r6, r12)     // Catch:{ Exception -> 0x04b4 }
            r2.put(r10, r12)     // Catch:{ Exception -> 0x04b4 }
            goto L_0x04bb
        L_0x04b4:
            r0 = move-exception
            r10 = r0
            java.lang.String r12 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.valueOf(r12, r10)     // Catch:{ all -> 0x07d9 }
        L_0x04bb:
            android.content.pm.PackageManager r10 = r14.getPackageManager()     // Catch:{ all -> 0x0549 }
            java.lang.String r12 = r14.getPackageName()     // Catch:{ all -> 0x0549 }
            r13 = 0
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r12, r13)     // Catch:{ all -> 0x0549 }
            r12 = r20
            int r13 = r5.getInt(r12, r13)     // Catch:{ all -> 0x0549 }
            int r15 = r10.versionCode     // Catch:{ all -> 0x0549 }
            if (r15 <= r13) goto L_0x04d7
            int r13 = r10.versionCode     // Catch:{ all -> 0x0549 }
            valueOf(r14, r12, r13)     // Catch:{ all -> 0x0549 }
        L_0x04d7:
            java.lang.String r12 = "app_version_code"
            int r13 = r10.versionCode     // Catch:{ all -> 0x0549 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x0549 }
            r2.put(r12, r13)     // Catch:{ all -> 0x0549 }
            java.lang.String r12 = "app_version_name"
            java.lang.String r13 = r10.versionName     // Catch:{ all -> 0x0549 }
            r2.put(r12, r13)     // Catch:{ all -> 0x0549 }
            long r12 = r10.firstInstallTime     // Catch:{ all -> 0x0549 }
            r29 = r8
            r15 = r9
            long r8 = r10.lastUpdateTime     // Catch:{ all -> 0x0543 }
            java.lang.String r10 = "date1"
            r20 = r15
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x053f }
            r21 = r4
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x053c }
            r15.<init>(r11, r4)     // Catch:{ all -> 0x053c }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x053c }
            r4.<init>(r12)     // Catch:{ all -> 0x053c }
            java.lang.String r4 = r15.format(r4)     // Catch:{ all -> 0x053c }
            r2.put(r10, r4)     // Catch:{ all -> 0x053c }
            java.lang.String r4 = "date2"
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x053c }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ all -> 0x053c }
            r10.<init>(r11, r12)     // Catch:{ all -> 0x053c }
            java.util.Date r11 = new java.util.Date     // Catch:{ all -> 0x053c }
            r11.<init>(r8)     // Catch:{ all -> 0x053c }
            java.lang.String r8 = r10.format(r11)     // Catch:{ all -> 0x053c }
            r2.put(r4, r8)     // Catch:{ all -> 0x053c }
            java.lang.String r4 = r1.AFInAppEventType(r6, r14)     // Catch:{ all -> 0x053c }
            java.lang.String r6 = "ᳵ넹䝧ᖩ꯫砐๠?狥ܫ핥殶㧖츀鱜"
            r8 = 44482(0xadc2, float:6.2333E-41)
            long r9 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x053c }
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            int r13 = r13 + r8
            java.lang.String r6 = values(r6, r13)     // Catch:{ all -> 0x053c }
            java.lang.String r6 = r6.intern()     // Catch:{ all -> 0x053c }
            r2.put(r6, r4)     // Catch:{ all -> 0x053c }
            goto L_0x0556
        L_0x053c:
            r0 = move-exception
        L_0x053d:
            r4 = r0
            goto L_0x0551
        L_0x053f:
            r0 = move-exception
            r21 = r4
            goto L_0x053d
        L_0x0543:
            r0 = move-exception
            r21 = r4
            r20 = r15
            goto L_0x053d
        L_0x0549:
            r0 = move-exception
            r21 = r4
            r29 = r8
            r20 = r9
            goto L_0x053d
        L_0x0551:
            java.lang.String r6 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.valueOf(r6, r4)     // Catch:{ all -> 0x07d9 }
        L_0x0556:
            boolean r4 = com.appsflyer.internal.cd.AFKeystoreWrapper(r14)     // Catch:{ all -> 0x07d9 }
            r1.AppsFlyerLib = r4     // Catch:{ all -> 0x07d9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "didConfigureTokenRefreshService="
            r4.<init>(r6)     // Catch:{ all -> 0x07d9 }
            boolean r6 = r1.AppsFlyerLib     // Catch:{ all -> 0x07d9 }
            r4.append(r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x07d9 }
            boolean r4 = r1.AppsFlyerLib     // Catch:{ all -> 0x07d9 }
            if (r4 != 0) goto L_0x057a
            java.lang.String r4 = "tokenRefreshConfigured"
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r6)     // Catch:{ all -> 0x07d9 }
        L_0x057a:
            if (r7 == 0) goto L_0x05ad
            java.lang.String r4 = r1.onDeepLinking     // Catch:{ all -> 0x07d9 }
            if (r4 == 0) goto L_0x05a3
            r4 = r19
            java.lang.Object r6 = r2.get(r4)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x058e
            java.lang.String r4 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x07d9 }
            goto L_0x05a3
        L_0x058e:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = r1.onDeepLinking     // Catch:{ all -> 0x07d9 }
            r6.<init>(r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = "isPush"
            java.lang.String r9 = "true"
            r6.put(r8, r9)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r6)     // Catch:{ all -> 0x07d9 }
        L_0x05a3:
            r4 = 0
            r1.onDeepLinking = r4     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "open_referrer"
            r6 = r23
            r2.put(r4, r6)     // Catch:{ all -> 0x07d9 }
        L_0x05ad:
            if (r7 != 0) goto L_0x05f1
            com.appsflyer.internal.w r4 = com.appsflyer.internal.w.AFKeystoreWrapper(r14)     // Catch:{ Exception -> 0x05da }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x05da }
            r6.<init>()     // Catch:{ Exception -> 0x05da }
            java.util.List r4 = r4.AFInAppEventParameterName()     // Catch:{ Exception -> 0x05da }
            boolean r8 = r4.isEmpty()     // Catch:{ Exception -> 0x05da }
            java.lang.String r9 = "sensors"
            if (r8 != 0) goto L_0x05d1
            com.appsflyer.internal.h r8 = new com.appsflyer.internal.h     // Catch:{ Exception -> 0x05da }
            r8.<init>()     // Catch:{ Exception -> 0x05da }
            java.util.Map r4 = r8.values(r4)     // Catch:{ Exception -> 0x05da }
            r6.put(r9, r4)     // Catch:{ Exception -> 0x05da }
            goto L_0x05d6
        L_0x05d1:
            java.lang.String r4 = "na"
            r6.put(r9, r4)     // Catch:{ Exception -> 0x05da }
        L_0x05d6:
            r2.putAll(r6)     // Catch:{ Exception -> 0x05da }
            goto L_0x05f1
        L_0x05da:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            java.lang.String r8 = "Unexpected exception from AFSensorManager: "
            r6.<init>(r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x07d9 }
            r6.append(r4)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x07d9 }
        L_0x05f1:
            java.lang.String r4 = AFInAppEventParameterName(r18)     // Catch:{ all -> 0x07d9 }
            if (r4 != 0) goto L_0x060c
            com.appsflyer.internal.ab.AFKeystoreWrapper(r14, r2)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "GAID_retry"
            java.lang.String r6 = AFInAppEventParameterName(r18)     // Catch:{ all -> 0x07d9 }
            if (r6 == 0) goto L_0x0604
            r6 = 1
            goto L_0x0605
        L_0x0604:
            r6 = 0
        L_0x0605:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r6)     // Catch:{ all -> 0x07d9 }
        L_0x060c:
            android.content.ContentResolver r4 = r14.getContentResolver()     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.g r4 = com.appsflyer.internal.ab.AFInAppEventType(r4)     // Catch:{ all -> 0x07d9 }
            if (r4 == 0) goto L_0x0628
            java.lang.String r6 = "amazon_aid"
            java.lang.String r8 = r4.values     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "amazon_aid_limit"
            java.lang.Boolean r4 = r4.AFKeystoreWrapper     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r4)     // Catch:{ all -> 0x07d9 }
        L_0x0628:
            boolean r4 = com.appsflyer.internal.cd.AFInAppEventType(r5)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "registeredUninstall"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r4)     // Catch:{ all -> 0x07d9 }
            int r4 = r1.valueOf(r5, r7)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "counter"
            java.lang.String r8 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r8)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "iaecounter"
            if (r3 == 0) goto L_0x0648
            r3 = 1
            goto L_0x0649
        L_0x0648:
            r3 = 0
        L_0x0649:
            int r3 = r1.AFKeystoreWrapper(r5, r3)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x07d9 }
            r2.put(r6, r3)     // Catch:{ all -> 0x07d9 }
            if (r7 == 0) goto L_0x06cc
            java.util.Map r3 = AFInAppEventType(r2)     // Catch:{ all -> 0x07d9 }
            r1.valueOf(r3)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "first_launch"
            r8 = 1
            if (r4 == r8) goto L_0x067f
            r8 = 2
            if (r4 == r8) goto L_0x0666
            goto L_0x067d
        L_0x0666:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x07d9 }
            r9 = r20
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFInAppEventParameterName     // Catch:{ all -> 0x07d9 }
            r8.<init>(r10)     // Catch:{ all -> 0x07d9 }
            boolean r10 = r8.isEmpty()     // Catch:{ all -> 0x07d9 }
            if (r10 != 0) goto L_0x0678
            r3.put(r6, r8)     // Catch:{ all -> 0x07d9 }
        L_0x0678:
            com.appsflyer.internal.bv r8 = r9.valueOf     // Catch:{ all -> 0x07d9 }
            r8.AFInAppEventType(r6)     // Catch:{ all -> 0x07d9 }
        L_0x067d:
            r6 = 1
            goto L_0x06c0
        L_0x067f:
            r9 = r20
            r8 = 1
            r10 = r21
            r10.AFInAppEventParameterName = r8     // Catch:{ all -> 0x07d9 }
            java.lang.String r10 = "waitForCustomerId"
            r11 = 0
            boolean r10 = AFKeystoreWrapper(r10, r11)     // Catch:{ all -> 0x07d9 }
            if (r10 == 0) goto L_0x0698
            java.lang.String r10 = "wait_cid"
            java.lang.String r11 = java.lang.Boolean.toString(r8)     // Catch:{ all -> 0x07d9 }
            r2.put(r10, r11)     // Catch:{ all -> 0x07d9 }
        L_0x0698:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x07d9 }
            java.util.Map<java.lang.String, java.lang.Object> r11 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x07d9 }
            r10.<init>(r11)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.bv r11 = r9.valueOf     // Catch:{ all -> 0x07d9 }
            r12 = r17
            r11.AFInAppEventType(r12)     // Catch:{ all -> 0x07d9 }
            boolean r11 = r10.isEmpty()     // Catch:{ all -> 0x07d9 }
            if (r11 != 0) goto L_0x06af
            r3.put(r12, r10)     // Catch:{ all -> 0x07d9 }
        L_0x06af:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x07d9 }
            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFInAppEventParameterName     // Catch:{ all -> 0x07d9 }
            r10.<init>(r9)     // Catch:{ all -> 0x07d9 }
            boolean r9 = r10.isEmpty()     // Catch:{ all -> 0x07d9 }
            if (r9 != 0) goto L_0x067d
            r3.put(r6, r10)     // Catch:{ all -> 0x07d9 }
            goto L_0x067d
        L_0x06c0:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x07d9 }
            if (r3 == 0) goto L_0x06cd
            java.lang.String r3 = "meta"
            r2.remove(r3)     // Catch:{ all -> 0x07d9 }
            goto L_0x06cd
        L_0x06cc:
            r6 = 1
        L_0x06cd:
            java.lang.String r3 = "isFirstCall"
            boolean r8 = AFInAppEventType(r5)     // Catch:{ all -> 0x07d9 }
            if (r8 != 0) goto L_0x06d6
            goto L_0x06d7
        L_0x06d6:
            r6 = 0
        L_0x06d7:
            java.lang.String r6 = java.lang.Boolean.toString(r6)     // Catch:{ all -> 0x07d9 }
            r2.put(r3, r6)     // Catch:{ all -> 0x07d9 }
            r1.AFInAppEventParameterName(r14, r7, r2, r4)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.ag r3 = new com.appsflyer.internal.ag     // Catch:{ all -> 0x07d9 }
            r3.<init>()     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = com.appsflyer.internal.ag.values(r2)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "af_v"
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.ag r3 = new com.appsflyer.internal.ag     // Catch:{ all -> 0x07d9 }
            r3.<init>()     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = com.appsflyer.internal.ag.AFInAppEventParameterName(r2)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "af_v2"
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
            boolean r3 = onConversionDataSuccess(r14)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
            r3 = r16
            boolean r4 = r5.contains(r3)     // Catch:{ all -> 0x07d9 }
            if (r4 == 0) goto L_0x0720
            java.lang.String r4 = "istu"
            r6 = 0
            boolean r3 = r5.getBoolean(r3, r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x07d9 }
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
        L_0x0720:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x07d9 }
            r3.<init>()     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r14.getResources()     // Catch:{ all -> 0x07d9 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x07d9 }
            int r5 = r5.mcc     // Catch:{ all -> 0x07d9 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x07d9 }
            r3.put(r4, r5)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r14.getResources()     // Catch:{ all -> 0x07d9 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x07d9 }
            int r5 = r5.mnc     // Catch:{ all -> 0x07d9 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x07d9 }
            r3.put(r4, r5)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = "cell"
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = "sig"
            r4 = r29
            android.app.Application r5 = r4.valueOf     // Catch:{ all -> 0x07d9 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x07d9 }
            android.app.Application r4 = r4.valueOf     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = com.appsflyer.internal.z.AFInAppEventParameterName(r5, r4)     // Catch:{ all -> 0x07d9 }
            r2.put(r3, r4)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = "last_boot_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x07d9 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x07d9 }
            long r4 = r4 - r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x07d9 }
            r2.put(r3, r4)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = "disk"
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ all -> 0x07d9 }
            java.io.File r5 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x07d9 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x07d9 }
            r4.<init>(r5)     // Catch:{ all -> 0x07d9 }
            long r5 = r4.getBlockSizeLong()     // Catch:{ all -> 0x07d9 }
            long r7 = r4.getAvailableBlocksLong()     // Catch:{ all -> 0x07d9 }
            long r7 = r7 * r5
            long r9 = r4.getBlockCountLong()     // Catch:{ all -> 0x07d9 }
            long r9 = r9 * r5
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r4 = java.lang.Math.pow(r4, r11)     // Catch:{ all -> 0x07d9 }
            double r6 = (double) r7     // Catch:{ all -> 0x07d9 }
            double r6 = r6 / r4
            long r6 = (long) r6     // Catch:{ all -> 0x07d9 }
            double r8 = (double) r9     // Catch:{ all -> 0x07d9 }
            double r8 = r8 / r4
            long r4 = (long) r8     // Catch:{ all -> 0x07d9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d9 }
            r8.<init>()     // Catch:{ all -> 0x07d9 }
            r8.append(r6)     // Catch:{ all -> 0x07d9 }
            java.lang.String r6 = "/"
            r8.append(r6)     // Catch:{ all -> 0x07d9 }
            r8.append(r4)     // Catch:{ all -> 0x07d9 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x07d9 }
            r2.put(r3, r4)     // Catch:{ all -> 0x07d9 }
            com.appsflyer.internal.y r3 = r1.getLevel     // Catch:{ all -> 0x07d9 }
            if (r3 == 0) goto L_0x07e2
            com.appsflyer.internal.y r3 = r1.getLevel     // Catch:{ all -> 0x07d9 }
            java.lang.String[] r3 = r3.AFInAppEventParameterName     // Catch:{ all -> 0x07d9 }
            if (r3 == 0) goto L_0x07e2
            java.lang.String r4 = "sharing_filter"
            r2.put(r4, r3)     // Catch:{ all -> 0x07d9 }
            goto L_0x07e2
        L_0x07cd:
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.values(r3)     // Catch:{ all -> 0x07d9 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.values(r3)     // Catch:{ all -> 0x07d9 }
            r2 = 0
            return r2
        L_0x07d9:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4, r3)
        L_0x07e2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFInAppEventType(com.appsflyer.internal.i):java.util.Map");
    }

    private void AFInAppEventParameterName(Context context, boolean z, Map<String, Object> map, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", values((String) "ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", values((String) "ro.product.cpu.abi2"));
        hashMap.put("arch", values((String) "os.arch"));
        hashMap.put("build_display_id", values((String) "ro.build.display.id"));
        if (!(!z)) {
            int i2 = waitForCustomerUserId + 79;
            setCustomerIdAndLogSession = i2 % 128;
            if ((i2 % 2 == 0 ? '4' : '7') != '4') {
                if (this.AppsFlyerConversionListener) {
                    Map<String, Object> AFLogger$LogLevel2 = AFLogger$LogLevel(context);
                    if ((!AFLogger$LogLevel2.isEmpty() ? '2' : '&') == '2') {
                        int i3 = setCustomerIdAndLogSession + 45;
                        waitForCustomerUserId = i3 % 128;
                        if (i3 % 2 == 0) {
                            hashMap.put("loc", AFLogger$LogLevel2);
                        } else {
                            hashMap.put("loc", AFLogger$LogLevel2);
                            throw null;
                        }
                    }
                }
                AFKeystoreWrapper(context, (Map<String, Object>) hashMap);
                if (i <= 2) {
                    hashMap.putAll(w.AFKeystoreWrapper(context).AFKeystoreWrapper());
                }
            } else {
                throw null;
            }
        }
        hashMap.put("dim", y.AFInAppEventType(context));
        map.put(BraintreeConstants.NS_DEVICE_DATA, hashMap);
    }

    public static void valueOf(Context context, Map<String, Object> map, String str) {
        int i = waitForCustomerUserId + 61;
        setCustomerIdAndLogSession = i % 128;
        if ((i % 2 == 0 ? '0' : 19) == 19) {
            SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
            Editor edit = AFInAppEventType2.edit();
            try {
                String string = AFInAppEventType2.getString("prev_event_name", null);
                if (string != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("prev_event_timestamp", AFInAppEventType2.getLong("prev_event_timestamp", -1));
                    jSONObject.put("prev_event_name", string);
                    map.put("prev_event", jSONObject);
                }
                edit.putString("prev_event_name", str);
                edit.putLong("prev_event_timestamp", System.currentTimeMillis());
                AFInAppEventType(edit);
                int i2 = setCustomerIdAndLogSession + 113;
                waitForCustomerUserId = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    int i3 = 88 / 0;
                }
            } catch (Exception e2) {
                AFLogger.valueOf("Error while processing previous event.", e2);
            }
        } else {
            SharedPreferences AFInAppEventType3 = AFInAppEventType(context);
            AFInAppEventType3.edit();
            AFInAppEventType3.getString("prev_event_name", null);
            throw null;
        }
    }

    public static String AFInAppEventParameterName(Activity activity) {
        String str = null;
        if (activity != null) {
            int i = setCustomerIdAndLogSession + 119;
            waitForCustomerUserId = i % 128;
            int i2 = i % 2;
            Intent intent = activity.getIntent();
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    if ((extras != null ? 24 : '`') != '`') {
                        str = extras.getString("af");
                        if ((str != null ? 28 : '@') == 28) {
                            int i3 = setCustomerIdAndLogSession + 119;
                            waitForCustomerUserId = i3 % 128;
                            int i4 = i3 % 2;
                            AFLogger.values("Push Notification received af payload = ".concat(String.valueOf(str)));
                            extras.remove("af");
                            activity.setIntent(intent.putExtras(extras));
                        }
                    }
                } catch (Throwable th) {
                    AFLogger.valueOf(th.getMessage(), th);
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void valueOf(android.content.Context r14, java.util.Map<java.lang.String, java.lang.Object> r15) {
        /*
            r13 = this;
            java.lang.String r0 = "use cached AndroidId: "
            java.lang.String r1 = "use cached IMEI: "
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r3 = "deviceTrackingDisabled"
            r4 = 0
            boolean r5 = r2.getBoolean(r3, r4)
            if (r5 == 0) goto L_0x0017
            java.lang.String r14 = "true"
            r15.put(r3, r14)
            return
        L_0x0017:
            android.content.SharedPreferences r3 = AFInAppEventType(r14)
            java.lang.String r5 = "collectIMEI"
            boolean r5 = r2.getBoolean(r5, r4)
            java.lang.String r6 = "imeiCached"
            r7 = 0
            java.lang.String r8 = r3.getString(r6, r7)
            r9 = 1
            if (r5 == 0) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            if (r5 == r9) goto L_0x0031
            goto L_0x003e
        L_0x0031:
            java.lang.String r5 = r13.AppsFlyer2dXConversionCallback
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x003b
            r5 = 1
            goto L_0x003c
        L_0x003b:
            r5 = 0
        L_0x003c:
            if (r5 == r9) goto L_0x0055
        L_0x003e:
            java.lang.String r1 = r13.AppsFlyer2dXConversionCallback
            if (r1 == 0) goto L_0x00fb
            int r5 = setCustomerIdAndLogSession
            int r5 = r5 + 87
            int r8 = r5 % 128
            waitForCustomerUserId = r8
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x00fc
            r5 = 81
            int r5 = r5 / r4
            goto L_0x00fc
        L_0x0053:
            r14 = move-exception
            throw r14
        L_0x0055:
            int r5 = setCustomerIdAndLogSession
            int r5 = r5 + 55
            int r10 = r5 % 128
            waitForCustomerUserId = r10
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 != 0) goto L_0x01d1
            boolean r5 = AFVersionDeclaration(r14)
            if (r5 == 0) goto L_0x00fb
            java.lang.String r5 = "phone"
            java.lang.Object r5 = r14.getSystemService(r5)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.Class r10 = r5.getClass()     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.String r11 = "getDeviceId"
            java.lang.Class[] r12 = new java.lang.Class[r4]     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r12)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.Object r5 = r10.invoke(r5, r11)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            if (r5 == 0) goto L_0x0097
            int r1 = setCustomerIdAndLogSession
            int r1 = r1 + 53
            int r8 = r1 % 128
            waitForCustomerUserId = r8
            int r1 = r1 % 2
            r1 = r5
            goto L_0x00fc
        L_0x0097:
            if (r8 == 0) goto L_0x009b
            r5 = 1
            goto L_0x009c
        L_0x009b:
            r5 = 0
        L_0x009c:
            if (r5 == r9) goto L_0x00a0
            r8 = r7
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            java.lang.String r5 = r1.concat(r5)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r5)     // Catch:{ InvocationTargetException -> 0x00d8, Exception -> 0x00b6 }
        L_0x00ab:
            int r1 = waitForCustomerUserId
            int r1 = r1 + 79
            int r5 = r1 % 128
            setCustomerIdAndLogSession = r5
            int r1 = r1 % 2
            goto L_0x00f9
        L_0x00b6:
            r5 = move-exception
            if (r8 == 0) goto L_0x00c1
            java.lang.String r1 = r1.concat(r8)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)
            goto L_0x00c2
        L_0x00c1:
            r8 = r7
        L_0x00c2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r10 = "WARNING: Can't collect IMEI: other reason: "
            r1.<init>(r10)
            java.lang.String r10 = r5.getMessage()
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.valueOf(r1, r5)
            goto L_0x00f9
        L_0x00d8:
            r5 = move-exception
            if (r8 == 0) goto L_0x00e3
            java.lang.String r1 = r1.concat(r8)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)
            goto L_0x00e4
        L_0x00e3:
            r8 = r7
        L_0x00e4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r10 = "WARNING: Can't collect IMEI because of missing permissions: "
            r1.<init>(r10)
            java.lang.String r10 = r5.getMessage()
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.valueOf(r1, r5)
        L_0x00f9:
            r1 = r8
            goto L_0x00fc
        L_0x00fb:
            r1 = r7
        L_0x00fc:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0104
            r5 = 1
            goto L_0x0105
        L_0x0104:
            r5 = 0
        L_0x0105:
            if (r5 == 0) goto L_0x012d
            int r5 = setCustomerIdAndLogSession
            int r5 = r5 + 15
            int r8 = r5 % 128
            waitForCustomerUserId = r8
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0115
            r5 = 0
            goto L_0x0116
        L_0x0115:
            r5 = 1
        L_0x0116:
            java.lang.String r8 = "imei"
            if (r5 == 0) goto L_0x0121
            valueOf(r14, r6, r1)
            r15.put(r8, r1)
            goto L_0x0132
        L_0x0121:
            valueOf(r14, r6, r1)
            r15.put(r8, r1)
            r1 = 65
            int r1 = r1 / r4
            goto L_0x0132
        L_0x012b:
            r14 = move-exception
            throw r14
        L_0x012d:
            java.lang.String r1 = "IMEI was not collected."
            com.appsflyer.AFLogger.values(r1)
        L_0x0132:
            java.lang.String r1 = "collectAndroidId"
            boolean r1 = r2.getBoolean(r1, r4)
            java.lang.String r2 = "androidIdCached"
            java.lang.String r3 = r3.getString(r2, r7)
            java.lang.String r5 = "android_id"
            if (r1 == 0) goto L_0x0189
            java.lang.String r1 = r13.init
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0189
            boolean r1 = AFVersionDeclaration(r14)
            if (r1 == 0) goto L_0x0198
            android.content.ContentResolver r1 = r14.getContentResolver()     // Catch:{ Exception -> 0x0176 }
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r5)     // Catch:{ Exception -> 0x0176 }
            if (r1 == 0) goto L_0x015c
            r6 = 0
            goto L_0x015d
        L_0x015c:
            r6 = 1
        L_0x015d:
            if (r6 == 0) goto L_0x016a
            if (r3 == 0) goto L_0x0198
            java.lang.String r1 = r0.concat(r3)     // Catch:{ Exception -> 0x0176 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)     // Catch:{ Exception -> 0x0176 }
            r7 = r3
            goto L_0x0198
        L_0x016a:
            int r0 = waitForCustomerUserId
            int r0 = r0 + 49
            int r3 = r0 % 128
            setCustomerIdAndLogSession = r3
            int r0 = r0 % 2
            r7 = r1
            goto L_0x0198
        L_0x0176:
            r1 = move-exception
            if (r3 == 0) goto L_0x0181
            java.lang.String r0 = r0.concat(r3)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            r7 = r3
        L_0x0181:
            java.lang.String r0 = r1.getMessage()
            com.appsflyer.AFLogger.valueOf(r0, r1)
            goto L_0x0198
        L_0x0189:
            java.lang.String r0 = r13.init
            r1 = 59
            if (r0 == 0) goto L_0x0192
            r0 = 89
            goto L_0x0194
        L_0x0192:
            r0 = 59
        L_0x0194:
            if (r0 == r1) goto L_0x0198
            java.lang.String r7 = r13.init
        L_0x0198:
            if (r7 == 0) goto L_0x019b
            r4 = 1
        L_0x019b:
            if (r4 == r9) goto L_0x01a3
            java.lang.String r0 = "Android ID was not collected."
            com.appsflyer.AFLogger.values(r0)
            goto L_0x01a9
        L_0x01a3:
            valueOf(r14, r2, r7)
            r15.put(r5, r7)
        L_0x01a9:
            com.appsflyer.internal.g r14 = com.appsflyer.internal.ab.AFInAppEventType(r14)
            if (r14 == 0) goto L_0x01d0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Boolean r1 = r14.AFInAppEventParameterName
            java.lang.String r2 = "isManual"
            r0.put(r2, r1)
            java.lang.String r1 = r14.values
            java.lang.String r2 = "val"
            r0.put(r2, r1)
            java.lang.Boolean r14 = r14.AFKeystoreWrapper
            if (r14 == 0) goto L_0x01cb
            java.lang.String r1 = "isLat"
            r0.put(r1, r14)
        L_0x01cb:
            java.lang.String r14 = "oaid"
            r15.put(r14, r0)
        L_0x01d0:
            return
        L_0x01d1:
            AFVersionDeclaration(r14)
            throw r7     // Catch:{ all -> 0x01d5 }
        L_0x01d5:
            r14 = move-exception
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.valueOf(android.content.Context, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r0.equals("") != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if ((r0.equals("") ? 'M' : 5) != 'M') goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFInAppEventParameterName(android.content.Context r4) {
        /*
            r3 = this;
            int r0 = waitForCustomerUserId
            int r0 = r0 + 83
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "channel"
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = "CHANNEL"
            java.lang.String r0 = r3.AFKeystoreWrapper(r4, r0)
        L_0x001c:
            r4 = 86
            if (r0 == 0) goto L_0x0023
            r1 = 86
            goto L_0x0025
        L_0x0023:
            r1 = 41
        L_0x0025:
            if (r1 == r4) goto L_0x0028
            goto L_0x0058
        L_0x0028:
            int r4 = waitForCustomerUserId
            int r4 = r4 + 107
            int r1 = r4 % 128
            setCustomerIdAndLogSession = r1
            int r4 = r4 % 2
            r1 = 47
            if (r4 != 0) goto L_0x0039
            r4 = 47
            goto L_0x003b
        L_0x0039:
            r4 = 56
        L_0x003b:
            java.lang.String r2 = ""
            if (r4 == r1) goto L_0x0046
            boolean r4 = r0.equals(r2)
            if (r4 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0046:
            boolean r4 = r0.equals(r2)
            r1 = 26
            int r1 = r1 / 0
            r1 = 77
            if (r4 == 0) goto L_0x0055
            r4 = 77
            goto L_0x0056
        L_0x0055:
            r4 = 5
        L_0x0056:
            if (r4 == r1) goto L_0x0059
        L_0x0058:
            return r0
        L_0x0059:
            r4 = 0
            int r0 = waitForCustomerUserId
            int r0 = r0 + 113
            int r1 = r0 % 128
            setCustomerIdAndLogSession = r1
            int r0 = r0 % 2
            return r4
        L_0x0065:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFInAppEventParameterName(android.content.Context):java.lang.String");
    }

    public final String AFInAppEventParameterName(Context context, String str) {
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        if (!(AFInAppEventType2.contains("CACHED_CHANNEL"))) {
            valueOf(context, (String) "CACHED_CHANNEL", str);
            return str;
        }
        int i = waitForCustomerUserId + 101;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        String string = AFInAppEventType2.getString("CACHED_CHANNEL", null);
        int i3 = waitForCustomerUserId + 15;
        setCustomerIdAndLogSession = i3 % 128;
        int i4 = i3 % 2;
        return string;
    }

    private void AFInAppEventParameterName(i iVar) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(iVar.onDeepLinkingNative);
        AFLogger.values(sb.toString());
        boolean z = true;
        if (!(iVar.init != null)) {
            str = new JSONObject(iVar.values()).toString();
            String replaceAll = str.replaceAll("\\p{C}", "*Non-printing character*");
            if (replaceAll.equals(str)) {
                z = false;
            }
            if (z) {
                int i = waitForCustomerUserId + 65;
                setCustomerIdAndLogSession = i % 128;
                int i2 = i % 2;
                AFLogger.AppsFlyer2dXConversionCallback("Payload contains non-printing characters");
                str = replaceAll;
            }
            ai.AFKeystoreWrapper("data: ".concat(str));
            int i3 = setCustomerIdAndLogSession + 47;
            waitForCustomerUserId = i3 % 128;
            int i4 = i3 % 2;
        } else {
            str = Base64.encodeToString(iVar.AFInAppEventParameterName(), 2);
            AFLogger.values("cached data: ".concat(String.valueOf(str)));
        }
        ak.AFInAppEventType().AFInAppEventType(iVar.onDeepLinkingNative, str);
        try {
            init(iVar);
        } catch (IOException e2) {
            AFLogger.valueOf("Exception in sendRequestToServer. ", e2);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                init(iVar.AFInAppEventType(iVar.onDeepLinkingNative.replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send request to server. ");
            sb2.append(e2.getLocalizedMessage());
            AFLogger.values(sb2.toString());
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f A[SYNTHETIC, Splitter:B:35:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088 A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventParameterName(java.net.HttpURLConnection r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 1
            r3 = 0
            java.io.InputStream r4 = r10.getErrorStream()     // Catch:{ all -> 0x0062 }
            if (r4 != 0) goto L_0x0012
            java.io.InputStream r4 = r10.getInputStream()     // Catch:{ all -> 0x0062 }
        L_0x0012:
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x0062 }
            r5.<init>(r4)     // Catch:{ all -> 0x0062 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0060 }
            r4.<init>(r5)     // Catch:{ all -> 0x0060 }
            r1 = 0
        L_0x001d:
            java.lang.String r6 = r4.readLine()     // Catch:{ all -> 0x005b }
            if (r6 == 0) goto L_0x004f
            int r7 = waitForCustomerUserId
            int r7 = r7 + 27
            int r8 = r7 % 128
            setCustomerIdAndLogSession = r8
            int r7 = r7 % 2
            if (r1 == 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r1 == 0) goto L_0x0045
            int r1 = waitForCustomerUserId
            int r1 = r1 + 115
            int r7 = r1 % 128
            setCustomerIdAndLogSession = r7
            int r1 = r1 % 2
            r1 = 10
            java.lang.Character r1 = java.lang.Character.valueOf(r1)     // Catch:{ all -> 0x005b }
            goto L_0x0047
        L_0x0045:
            java.lang.String r1 = ""
        L_0x0047:
            r0.append(r1)     // Catch:{ all -> 0x005b }
            r0.append(r6)     // Catch:{ all -> 0x005b }
            r1 = 1
            goto L_0x001d
        L_0x004f:
            r4.close()     // Catch:{ all -> 0x0056 }
            r5.close()     // Catch:{ all -> 0x0056 }
            goto L_0x0095
        L_0x0056:
            r10 = move-exception
            com.appsflyer.AFLogger.values(r10)
            goto L_0x0095
        L_0x005b:
            r1 = move-exception
            r9 = r4
            r4 = r1
            r1 = r9
            goto L_0x0064
        L_0x0060:
            r4 = move-exception
            goto L_0x0064
        L_0x0062:
            r4 = move-exception
            r5 = r1
        L_0x0064:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = "Could not read connection response from: "
            r6.<init>(r7)     // Catch:{ all -> 0x00b8 }
            java.net.URL r10 = r10.getURL()     // Catch:{ all -> 0x00b8 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00b8 }
            r6.append(r10)     // Catch:{ all -> 0x00b8 }
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x00b8 }
            com.appsflyer.AFLogger.valueOf(r10, r4)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ all -> 0x0056 }
        L_0x0082:
            if (r5 == 0) goto L_0x0085
            r2 = 0
        L_0x0085:
            if (r2 == 0) goto L_0x0088
            goto L_0x0095
        L_0x0088:
            r5.close()     // Catch:{ all -> 0x0056 }
            int r10 = setCustomerIdAndLogSession
            int r10 = r10 + 23
            int r1 = r10 % 128
            waitForCustomerUserId = r1
            int r10 = r10 % 2
        L_0x0095:
            java.lang.String r10 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009f }
            r0.<init>(r10)     // Catch:{ JSONException -> 0x009f }
            return r10
        L_0x009f:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r10)     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r10 = r0.toString()     // Catch:{ JSONException -> 0x00ae }
            return r10
        L_0x00ae:
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r10 = r10.toString()
            return r10
        L_0x00b8:
            r10 = move-exception
            if (r1 == 0) goto L_0x00c1
            r1.close()     // Catch:{ all -> 0x00bf }
            goto L_0x00c1
        L_0x00bf:
            r0 = move-exception
            goto L_0x00cb
        L_0x00c1:
            if (r5 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r2 = 0
        L_0x00c5:
            if (r2 == 0) goto L_0x00cf
            r5.close()     // Catch:{ all -> 0x00bf }
            goto L_0x00cf
        L_0x00cb:
            com.appsflyer.AFLogger.values(r0)
            goto L_0x00d9
        L_0x00cf:
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 111
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % 2
        L_0x00d9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.AFInAppEventParameterName(java.net.HttpURLConnection):java.lang.String");
    }

    public final int valueOf(SharedPreferences sharedPreferences, boolean z) {
        int i = waitForCustomerUserId + 3;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        int valueOf2 = valueOf(sharedPreferences, (String) "appsFlyerCount", z);
        int i3 = waitForCustomerUserId + 119;
        setCustomerIdAndLogSession = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : '2') == '2') {
            return valueOf2;
        }
        int i4 = 84 / 0;
        return valueOf2;
    }

    private int valueOf(SharedPreferences sharedPreferences) {
        int i = setCustomerIdAndLogSession + 3;
        waitForCustomerUserId = i % 128;
        boolean z = true;
        int valueOf2 = (i % 2 != 0 ? '6' : 11) != 11 ? valueOf(sharedPreferences, (String) "appsFlyerAdRevenueCount", false) : valueOf(sharedPreferences, (String) "appsFlyerAdRevenueCount", true);
        int i2 = setCustomerIdAndLogSession + 117;
        waitForCustomerUserId = i2 % 128;
        if (i2 % 2 != 0) {
            z = false;
        }
        if (z) {
            return valueOf2;
        }
        int i3 = 85 / 0;
        return valueOf2;
    }

    public static int valueOf(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = waitForCustomerUserId + 87;
        setCustomerIdAndLogSession = i % 128;
        int i2 = i % 2;
        boolean z2 = false;
        int i3 = sharedPreferences.getInt(str, 0);
        if (z) {
            z2 = true;
        }
        if (z2) {
            i3++;
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i3);
            AFInAppEventType(edit);
            int i4 = setCustomerIdAndLogSession + 43;
            waitForCustomerUserId = i4 % 128;
            int i5 = i4 % 2;
        }
        if (ak.AFInAppEventType().AFVersionDeclaration()) {
            ak.AFInAppEventType().values(String.valueOf(i3));
        }
        return i3;
    }

    public static void valueOf(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        boolean z = false;
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown()) {
                    int i = setCustomerIdAndLogSession + 87;
                    waitForCustomerUserId = i % 128;
                    int i2 = i % 2;
                    if (scheduledExecutorService.isTerminated()) {
                        z = true;
                    }
                    if (!z) {
                        int i3 = setCustomerIdAndLogSession + 25;
                        waitForCustomerUserId = i3 % 128;
                        int i4 = i3 % 2;
                        scheduledExecutorService.schedule(runnable, j, timeUnit);
                        return;
                    }
                }
            } catch (RejectedExecutionException e2) {
                AFLogger.valueOf("scheduleJob failed with RejectedExecutionException Exception", e2);
                return;
            } catch (Throwable th) {
                AFLogger.valueOf("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.AppsFlyer2dXConversionCallback("scheduler is null, shut downed or terminated");
        int i5 = setCustomerIdAndLogSession + 45;
        waitForCustomerUserId = i5 % 128;
        int i6 = i5 % 2;
    }

    public final dd[] valueOf() {
        int i = setCustomerIdAndLogSession + 45;
        waitForCustomerUserId = i % 128;
        if ((i % 2 != 0 ? 26 : '2') != 26) {
            dd[] AFInAppEventType2 = values().AFLogger$LogLevel().AFInAppEventType();
            int i2 = waitForCustomerUserId + 27;
            setCustomerIdAndLogSession = i2 % 128;
            int i3 = i2 % 2;
            return AFInAppEventType2;
        }
        values().AFLogger$LogLevel().AFInAppEventType();
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void valueOf(com.appsflyer.internal.i r11) {
        /*
            r10 = this;
            android.app.Application r0 = r11.AFKeystoreWrapper
            if (r0 != 0) goto L_0x000a
            java.lang.String r11 = "sendWithEvent - got null context. skipping event/launch."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r11)
            return
        L_0x000a:
            android.content.SharedPreferences r1 = AFInAppEventType(r0)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.saveProperties(r1)
            boolean r2 = r10.isStopped()
            if (r2 != 0) goto L_0x0034
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "sendWithEvent from activity: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.values(r2)
        L_0x0034:
            boolean r2 = r11.valueOf()
            boolean r3 = r11 instanceof com.appsflyer.internal.cq
            boolean r4 = r11 instanceof com.appsflyer.internal.ci
            java.util.Map r5 = r10.AFInAppEventType(r11)
            java.lang.String r6 = "appsflyerKey"
            java.lang.Object r6 = r5.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            r7 = 2
            if (r6 == 0) goto L_0x0204
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0053
            goto L_0x0204
        L_0x0053:
            boolean r6 = r10.isStopped()
            if (r6 != 0) goto L_0x005e
            java.lang.String r6 = "AppsFlyerLib.sendWithEvent"
            com.appsflyer.AFLogger.values(r6)
        L_0x005e:
            r6 = 0
            int r1 = r10.valueOf(r1, r6)
            r8 = 1
            if (r4 != 0) goto L_0x0068
            r4 = 1
            goto L_0x0069
        L_0x0068:
            r4 = 0
        L_0x0069:
            if (r4 == r8) goto L_0x006c
            goto L_0x0082
        L_0x006c:
            int r4 = waitForCustomerUserId
            int r4 = r4 + 123
            int r9 = r4 % 128
            setCustomerIdAndLogSession = r9
            int r4 = r4 % r7
            r9 = 45
            if (r4 != 0) goto L_0x007c
            r4 = 94
            goto L_0x007e
        L_0x007c:
            r4 = 45
        L_0x007e:
            if (r4 != r9) goto L_0x0200
            if (r3 == 0) goto L_0x009f
        L_0x0082:
            java.lang.String r3 = onResponseErrorNative
            java.lang.Object[] r4 = new java.lang.Object[r7]
            com.appsflyer.AppsFlyerLib r9 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r9 = r9.getHostPrefix()
            r4[r6] = r9
            com.appsflyer.internal.ac r9 = AFInAppEventParameterName()
            java.lang.String r9 = r9.getHostName()
            r4[r8] = r9
            java.lang.String r3 = java.lang.String.format(r3, r4)
            goto L_0x00f9
        L_0x009f:
            if (r2 == 0) goto L_0x00dd
            if (r1 >= r7) goto L_0x00c0
            java.lang.String r3 = onDeepLinkingNative
            java.lang.Object[] r4 = new java.lang.Object[r7]
            com.appsflyer.AppsFlyerLib r9 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r9 = r9.getHostPrefix()
            r4[r6] = r9
            com.appsflyer.internal.ac r9 = AFInAppEventParameterName()
            java.lang.String r9 = r9.getHostName()
            r4[r8] = r9
            java.lang.String r3 = java.lang.String.format(r3, r4)
            goto L_0x00f9
        L_0x00c0:
            java.lang.String r3 = onAppOpenAttributionNative
            java.lang.Object[] r4 = new java.lang.Object[r7]
            com.appsflyer.AppsFlyerLib r9 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r9 = r9.getHostPrefix()
            r4[r6] = r9
            com.appsflyer.internal.ac r9 = AFInAppEventParameterName()
            java.lang.String r9 = r9.getHostName()
            r4[r8] = r9
            java.lang.String r3 = java.lang.String.format(r3, r4)
            goto L_0x00f9
        L_0x00dd:
            java.lang.String r3 = onAttributionFailureNative
            java.lang.Object[] r4 = new java.lang.Object[r7]
            com.appsflyer.AppsFlyerLib r9 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r9 = r9.getHostPrefix()
            r4[r6] = r9
            com.appsflyer.internal.ac r9 = AFInAppEventParameterName()
            java.lang.String r9 = r9.getHostName()
            r4[r8] = r9
            java.lang.String r3 = java.lang.String.format(r3, r4)
        L_0x00f9:
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r0.getPackageName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "&buildnumber=6.5.4"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r0 = r10.AFInAppEventParameterName(r0)
            if (r0 == 0) goto L_0x0133
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "&channel="
            r4.append(r3)
            r4.append(r0)
            java.lang.String r3 = r4.toString()
        L_0x0133:
            r10.AFInAppEventParameterName(r5)
            com.appsflyer.internal.ac$d r0 = new com.appsflyer.internal.ac$d
            com.appsflyer.internal.i r11 = r11.AFInAppEventType(r3)
            com.appsflyer.internal.i r11 = r11.AFInAppEventParameterName(r5)
            com.appsflyer.internal.i r11 = r11.valueOf(r1)
            r0.<init>(r10, r11, r6)
            if (r2 == 0) goto L_0x019d
            com.appsflyer.internal.dd[] r11 = r10.valueOf()
            int r1 = r11.length
            r2 = 0
            r3 = 0
        L_0x0150:
            if (r2 >= r1) goto L_0x0176
            r4 = r11[r2]
            com.appsflyer.internal.dd$d r5 = r4.AFInAppEventParameterName
            com.appsflyer.internal.dd$d r8 = com.appsflyer.internal.dd.d.STARTED
            if (r5 != r8) goto L_0x0173
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Failed to get "
            r3.<init>(r5)
            java.lang.String r4 = r4.AFKeystoreWrapper
            r3.append(r4)
            java.lang.String r4 = " referrer, wait ..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r3)
            r3 = 1
        L_0x0173:
            int r2 = r2 + 1
            goto L_0x0150
        L_0x0176:
            boolean r11 = r10.setDebugLog
            if (r11 == 0) goto L_0x0186
            boolean r11 = r10.AFLogger$LogLevel()
            if (r11 != 0) goto L_0x0186
            java.lang.String r11 = "fetching Facebook deferred AppLink data, wait ..."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r11)
            r3 = 1
        L_0x0186:
            com.appsflyer.internal.bf r11 = r10.setCustomerUserId
            com.appsflyer.internal.ca r11 = r11.init()
            boolean r11 = r11.AFInAppEventType()
            if (r11 == 0) goto L_0x019e
            int r11 = setCustomerIdAndLogSession
            int r11 = r11 + 21
            int r1 = r11 % 128
            waitForCustomerUserId = r1
            int r11 = r11 % r7
            r3 = 1
            goto L_0x019e
        L_0x019d:
            r3 = 0
        L_0x019e:
            boolean r11 = com.appsflyer.internal.f.AFInAppEventParameterName
            if (r11 == 0) goto L_0x01a3
            goto L_0x01a4
        L_0x01a3:
            r6 = 1
        L_0x01a4:
            if (r6 == 0) goto L_0x01b8
            com.appsflyer.internal.k r11 = com.appsflyer.internal.k.values
            if (r11 != 0) goto L_0x01b1
            com.appsflyer.internal.k r11 = new com.appsflyer.internal.k
            r11.<init>()
            com.appsflyer.internal.k.values = r11
        L_0x01b1:
            com.appsflyer.internal.k r11 = com.appsflyer.internal.k.values
            java.util.concurrent.ScheduledThreadPoolExecutor r11 = r11.AFKeystoreWrapper()
            goto L_0x01ea
        L_0x01b8:
            java.lang.String r11 = "ESP deeplink: execute launch on SerialExecutor"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r11)
            com.appsflyer.internal.k r11 = com.appsflyer.internal.k.values
            if (r11 != 0) goto L_0x01d1
            com.appsflyer.internal.k r11 = new com.appsflyer.internal.k
            r11.<init>()
            com.appsflyer.internal.k.values = r11
            int r11 = setCustomerIdAndLogSession
            int r11 = r11 + 77
            int r1 = r11 % 128
            waitForCustomerUserId = r1
            int r11 = r11 % r7
        L_0x01d1:
            com.appsflyer.internal.k r11 = com.appsflyer.internal.k.values
            java.util.concurrent.ScheduledExecutorService r1 = r11.valueOf
            if (r1 != 0) goto L_0x01e8
            int r1 = waitForCustomerUserId
            int r1 = r1 + 75
            int r2 = r1 % 128
            setCustomerIdAndLogSession = r2
            int r1 = r1 % r7
            java.util.concurrent.ThreadFactory r1 = r11.AFInAppEventType
            java.util.concurrent.ScheduledExecutorService r1 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(r1)
            r11.valueOf = r1
        L_0x01e8:
            java.util.concurrent.ScheduledExecutorService r11 = r11.valueOf
        L_0x01ea:
            if (r3 == 0) goto L_0x01f8
            int r1 = setCustomerIdAndLogSession
            int r1 = r1 + 99
            int r2 = r1 % 128
            waitForCustomerUserId = r2
            int r1 = r1 % r7
            r1 = 500(0x1f4, double:2.47E-321)
            goto L_0x01fa
        L_0x01f8:
            r1 = 0
        L_0x01fa:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            valueOf(r11, r0, r1, r3)
            return
        L_0x0200:
            r11 = 0
            throw r11     // Catch:{ all -> 0x0202 }
        L_0x0202:
            r11 = move-exception
            throw r11
        L_0x0204:
            java.lang.String r0 = "Not sending data yet, waiting for dev key"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            com.appsflyer.attribution.AppsFlyerRequestListener r11 = r11.AFInAppEventParameterName
            if (r11 == 0) goto L_0x021d
            int r0 = setCustomerIdAndLogSession
            int r0 = r0 + 81
            int r1 = r0 % 128
            waitForCustomerUserId = r1
            int r0 = r0 % r7
            int r0 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r1 = com.appsflyer.internal.ba.AFInAppEventParameterName
            r11.onError(r0, r1)
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.valueOf(com.appsflyer.internal.i):void");
    }

    public static void AFInAppEventType(Map<String, Object> map, cl clVar) {
        HashMap hashMap = new HashMap(clVar.values);
        clVar.values.clear();
        clVar.valueOf.AFInAppEventType("gcd");
        boolean z = false;
        if (!hashMap.isEmpty()) {
            int i = setCustomerIdAndLogSession + 43;
            waitForCustomerUserId = i % 128;
            if (i % 2 == 0) {
                z = true;
            }
            if (z) {
                AFInAppEventType(map).put("gcd", hashMap);
            } else {
                AFInAppEventType(map).put("gcd", hashMap);
                throw null;
            }
        }
        int i2 = waitForCustomerUserId + 9;
        setCustomerIdAndLogSession = i2 % 128;
        int i3 = i2 % 2;
    }
}
