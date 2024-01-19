package com.appsflyer.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.compat.function.Consumer;
import com.appsflyer.compat.function.Function;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public final class av implements Runnable {
    public final bv AFInAppEventParameterName;
    public final bh AFInAppEventType;
    public bb AFKeystoreWrapper;
    public final bd getLevel;
    public final ExecutorService valueOf;
    public BillingClient values;

    public av(bh bhVar, bb bbVar, bv bvVar, ExecutorService executorService, bd bdVar) {
        this.AFInAppEventType = bhVar;
        this.AFKeystoreWrapper = bbVar;
        this.AFInAppEventParameterName = bvVar;
        this.valueOf = executorService;
        this.getLevel = bdVar;
    }

    public static /* synthetic */ void AFInAppEventType(av avVar, final boolean z, List list) {
        Map map;
        boolean z2;
        final aj AFKeystoreWrapper2 = avVar.AFInAppEventType.AFKeystoreWrapper();
        String str = null;
        if (AFKeystoreWrapper2 != null) {
            z2 = AFKeystoreWrapper2.AFInAppEventType;
            Function<List<Purchase>, Map<String, String>> function = AFKeystoreWrapper2.values;
            map = function != null ? (Map) function.apply(list) : null;
        } else {
            map = null;
            z2 = false;
        }
        as asVar = new as(z2, z, list, map);
        bd bdVar = avVar.getLevel;
        String format = String.format("https://%sars.%s/api/v1/android/validate_subscription", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()});
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", bdVar.valueOf.AFInAppEventParameterName.getPackageName());
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            hashMap.put("cuid", string);
        }
        Context context = bdVar.valueOf.AFInAppEventParameterName;
        hashMap.put("app_version_name", z.AFKeystoreWrapper(context, context.getPackageName()));
        HashMap hashMap2 = new HashMap();
        g AFKeystoreWrapper3 = ab.AFKeystoreWrapper(bdVar.valueOf.AFInAppEventParameterName, new HashMap());
        if (AFKeystoreWrapper3 != null) {
            str = AFKeystoreWrapper3.values;
        }
        if (str != null) {
            hashMap2.put(Constant.ADVERTISIING_ID, str);
        }
        hashMap2.put("appsflyer_id", af.valueOf(new WeakReference(bdVar.valueOf.AFInAppEventParameterName)));
        StringBuilder sb = new StringBuilder();
        sb.append(VERSION.SDK_INT);
        hashMap2.put("os_version", sb.toString());
        hashMap2.put(SMTPreferenceConstants.SMT_SDK_VERSION, ac.AFInAppEventType);
        hashMap.put("device_data", hashMap2);
        hashMap.put("is_cached", Boolean.valueOf(asVar.valueOf()));
        hashMap.put(PaymentConstants.ENV, asVar.AFInAppEventParameterName() ? "SANDBOX" : "PRODUCTION");
        hashMap.put("additional_parameters", asVar.AFInAppEventType);
        ArrayList arrayList = new ArrayList();
        for (Purchase next : asVar.values) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("token", next.getPurchaseToken());
            hashMap3.put("subscription_id", next.getSku());
            arrayList.add(hashMap3);
        }
        hashMap.put("subscriptions", arrayList);
        z zVar = new z(format, new JSONObject(hashMap).toString().getBytes(), RNCWebViewManager.HTTP_METHOD_POST, Collections.emptyMap(), false);
        bj bjVar = new bj();
        zVar.AFInAppEventParameterName = bdVar.AFInAppEventType();
        ab abVar = bdVar.AFInAppEventType;
        bl blVar = new bl(zVar, abVar.AFKeystoreWrapper, abVar.valueOf, bjVar);
        AnonymousClass3 r14 = new bi<String>() {
            public final void values(br<String> brVar) {
                if (brVar.values()) {
                    if (z) {
                        av.this.AFInAppEventParameterName.AFInAppEventType((String) "ars_history_sent", true);
                    }
                    aj ajVar = AFKeystoreWrapper2;
                    if (ajVar != null) {
                        Consumer<String> consumer = ajVar.AFKeystoreWrapper;
                        if (consumer != null) {
                            consumer.accept(brVar.valueOf);
                        }
                    }
                } else {
                    aj ajVar2 = AFKeystoreWrapper2;
                    if (ajVar2 != null) {
                        Consumer<String> consumer2 = ajVar2.AFInAppEventParameterName;
                        if (consumer2 != null) {
                            consumer2.accept(brVar.valueOf);
                        }
                    }
                }
            }

            public final void values(Throwable th) {
                aj ajVar = AFKeystoreWrapper2;
                if (ajVar != null) {
                    Consumer<String> consumer = ajVar.AFInAppEventParameterName;
                    if (consumer != null) {
                        consumer.accept(th.getMessage());
                    }
                }
                AFLogger.values(th);
            }
        };
        if (!blVar.valueOf.getAndSet(true)) {
            blVar.AFKeystoreWrapper.submit(new Runnable(r14) {
                public /* synthetic */ bi AFInAppEventParameterName;

                {
                    this.AFInAppEventParameterName = r2;
                }

                public final void run() {
                    try {
                        br<String> AFInAppEventType2 = bl.this.values.AFInAppEventType(bl.this.AFInAppEventType);
                        if (this.AFInAppEventParameterName != null) {
                            try {
                                br brVar = new br(bl.this.AFInAppEventParameterName.values((String) AFInAppEventType2.valueOf), AFInAppEventType2.values, AFInAppEventType2.AFKeystoreWrapper, AFInAppEventType2.AFInAppEventParameterName, AFInAppEventType2.AFInAppEventType);
                                this.AFInAppEventParameterName.values(brVar);
                            } catch (JSONException e2) {
                                this.AFInAppEventParameterName.values((Throwable) new ParsingException(e2.getMessage(), e2, AFInAppEventType2));
                            }
                        }
                    } catch (IOException e3) {
                        bi biVar = this.AFInAppEventParameterName;
                        if (biVar != null) {
                            biVar.values((Throwable) e3);
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Http call is already executed");
    }

    public final void run() {
        try {
            if (this.values == null) {
                bb bbVar = this.AFKeystoreWrapper;
                BillingClient build = BillingClient.newBuilder(bbVar.AFInAppEventParameterName).setListener(new at(this)).enablePendingPurchases().build();
                this.values = build;
                build.startConnection(new au(this));
            }
        } catch (Throwable th) {
            if ((th instanceof NoSuchMethodError) || (th instanceof NoClassDefFoundError)) {
                AFLogger.AppsFlyer2dXConversionCallback("It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3");
            }
            AFLogger.AFInAppEventParameterName((String) "Failed to setup Play billing", th);
        }
    }
}
