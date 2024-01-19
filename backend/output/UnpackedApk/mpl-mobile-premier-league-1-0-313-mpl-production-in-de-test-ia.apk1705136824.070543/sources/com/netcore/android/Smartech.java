package com.netcore.android;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import androidx.annotation.Keep;
import com.netcore.android.event.SMTEventId;
import com.netcore.android.event.SMTEventType;
import com.netcore.android.event.a.C0003a;
import com.netcore.android.inapp.InAppCustomHTMLListener;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.module.ModuleChecker;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.network.SMTThreadPoolManager;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.smartechbase.communication.HanselInterface;
import com.netcore.android.smartechbase.communication.SMTAppInboxInterface;
import com.netcore.android.smartechbase.communication.SmartechInterface;
import com.netcore.android.smartechbase.communication.SmartechPushInterface;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.workmgr.SMTWorkerScheduler;
import com.paynimo.android.payment.util.Constant;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0018\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0005\b\u0001\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u001d\u0010\u0007\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0007\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\u0013J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u000e\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0007\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u000e\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010#J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b$\u0010\u0013J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010\u0013J\r\u0010&\u001a\u00020\u0003¢\u0006\u0004\b&\u0010\u0005J\r\u0010'\u001a\u00020\u0003¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b(\u0010\u0016JC\u0010/\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u001f2(\b\u0002\u0010.\u001a\"\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u0001`-H\u0007¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0014¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0003¢\u0006\u0004\b4\u0010\u0005J5\u00105\u001a\u00020\u00032&\u0010.\u001a\"\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u0001`-¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0014¢\u0006\u0004\b7\u00102J\r\u00108\u001a\u00020\u0014¢\u0006\u0004\b8\u00102J\u0017\u0010;\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u001f¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0014¢\u0006\u0004\b@\u0010\u0016J\u0015\u0010A\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0014¢\u0006\u0004\bA\u0010\u0016J\r\u0010B\u001a\u00020\u001f¢\u0006\u0004\bB\u0010>J\u0017\u0010D\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0014¢\u0006\u0004\bG\u0010\u0016J\r\u0010F\u001a\u00020\u0003¢\u0006\u0004\bF\u0010\u0005J\u0017\u0010H\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bH\u0010EJ\u0015\u0010K\u001a\u00020\u00032\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020\u0003¢\u0006\u0004\bM\u0010\u0005J\u001d\u0010O\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u001f¢\u0006\u0004\bO\u0010PJ\u000f\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00032\b\u0010T\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020\u001f¢\u0006\u0004\bW\u0010>J\u000f\u0010X\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bX\u0010>J\u0017\u0010Z\u001a\u00020\u00032\b\u0010Y\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bZ\u0010EJ\u000f\u0010[\u001a\u00020\u001fH\u0016¢\u0006\u0004\b[\u0010>JA\u0010\\\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u001f2&\u0010.\u001a\"\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020,\u0018\u0001`-H\u0016¢\u0006\u0004\b\\\u00100J\u0011\u0010^\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b]\u0010\u001aJ\u0015\u0010b\u001a\b\u0012\u0004\u0012\u00020I0_H\u0000¢\u0006\u0004\b`\u0010aJ\u000f\u0010d\u001a\u00020\u0003H\u0000¢\u0006\u0004\bc\u0010\u0005J\u000f\u0010e\u001a\u00020\u0003H\u0016¢\u0006\u0004\be\u0010\u0005J\u0017\u0010h\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u0014H\u0000¢\u0006\u0004\bg\u0010\u0016J\u000f\u0010j\u001a\u00020\u0014H\u0000¢\u0006\u0004\bi\u00102J\u000f\u0010l\u001a\u0004\u0018\u00010k¢\u0006\u0004\bl\u0010mJ\u0011\u0010q\u001a\u0004\u0018\u00010nH\u0000¢\u0006\u0004\bo\u0010pR\u001e\u0010t\u001a\n r*\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010vR&\u0010{\u001a\u0012\u0012\u0004\u0012\u00020I0xj\b\u0012\u0004\u0012\u00020I`y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010zR\u0018\u0010}\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010|R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\u000e\n\u0004\b~\u0010\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020k8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u000e\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0006\u0010\u0001R'\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020I0xj\b\u0012\u0004\u0012\u00020I`y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010zR\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\t\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u0004\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/netcore/android/Smartech;", "Lcom/netcore/android/network/SMTResponseListener;", "Lcom/netcore/android/smartechbase/communication/SmartechInterface;", "", "c", "()V", "i", "a", "d", "h", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "(Ljava/lang/ref/WeakReference;)V", "b", "f", "j", "Lcom/netcore/android/network/models/SMTResponse;", "response", "(Lcom/netcore/android/network/models/SMTResponse;)V", "", "isAppInFg", "(Z)V", "g", "e", "Lcom/netcore/android/smartechbase/communication/HanselInterface;", "()Lcom/netcore/android/smartechbase/communication/HanselInterface;", "Landroid/app/Application;", "applicationContext", "initializeSdk", "(Landroid/app/Application;)V", "", "smartechAppId", "hanselAppId", "hanselAppKey", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onResponseSuccess", "onResponseFailure", "onAppForeground", "onAppBackground", "onAppForegroundStateChanged$smartech_release", "onAppForegroundStateChanged", "eventName", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "eventPayLoad", "trackEvent", "(Ljava/lang/String;Ljava/util/HashMap;)V", "trackAppInstall", "()Z", "trackAppInstallUpdateBySmartech", "trackAppUpdate", "updateUserProfile", "(Ljava/util/HashMap;)V", "hasOptedTracking", "hasOptedInAppMessage", "Landroid/location/Location;", "location", "setUserLocation", "(Landroid/location/Location;)V", "getDeviceUniqueId", "()Ljava/lang/String;", "isOpted", "optTracking", "optInAppMessage", "getUserIdentity", "userIdentity", "setUserIdentity", "(Ljava/lang/String;)V", "clearUserIdentity", "logoutAndClearUserIdentity", "login", "", "level", "setDebugLevel", "(I)V", "processEventsManually", "url", "getSmartechAttributionURL", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Lcom/netcore/android/inapp/InAppCustomHTMLListener;", "getInAppCustomHTMLListener", "()Lcom/netcore/android/inapp/InAppCustomHTMLListener;", "listener", "setInAppCustomHTMLListener", "(Lcom/netcore/android/inapp/InAppCustomHTMLListener;)V", "getSDKVersion", "getAppID", "id", "setDeviceAdvertiserId", "getUUID", "trackEventFromHansel", "getHanselInstance$smartech_release", "getHanselInstance", "", "getSystemInAppEventList$smartech_release", "()Ljava/util/List;", "getSystemInAppEventList", "clearSystemEventList$smartech_release", "clearSystemEventList", "fetchListAndSegment", "status", "setInAppRuleListStatus$smartech_release", "setInAppRuleListStatus", "getInAppRuleListStatus$smartech_release", "getInAppRuleListStatus", "Lcom/netcore/android/utility/g;", "getSmtInfo", "()Lcom/netcore/android/utility/g;", "Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "getSmartechPNInterface$smartech_release", "()Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "getSmartechPNInterface", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "Lcom/netcore/android/smartechbase/communication/SMTAppInboxInterface;", "Lcom/netcore/android/smartechbase/communication/SMTAppInboxInterface;", "smartechAppInboxInterface", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mInitEventTrackList", "Lcom/netcore/android/inapp/InAppCustomHTMLListener;", "inAppCustomHTMLListener", "k", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "Lcom/netcore/android/utility/g;", "mSmtInfo", "Z", "isInAppListUpdated", "Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "smartechPNInterface", "mSytemEventList", "Lcom/netcore/android/smartechbase/communication/HanselInterface;", "hanselInterface", "Lcom/netcore/android/c;", "Lcom/netcore/android/c;", "mSmartechHelper", "<init>", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: Smartech.kt */
public final class Smartech implements SMTResponseListener, SmartechInterface {
    public static final Companion Companion = new Companion(null);
    public static boolean l;
    public static boolean m;
    public static SMTPreferenceHelper n;
    public static volatile Smartech o;

    /* renamed from: a  reason: collision with root package name */
    public final String f996a;

    /* renamed from: b  reason: collision with root package name */
    public com.netcore.android.utility.g f997b;

    /* renamed from: c  reason: collision with root package name */
    public c f998c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<Integer> f999d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<Integer> f1000e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1001f;
    public InAppCustomHTMLListener g;
    public HanselInterface h;
    public SmartechPushInterface i;
    public SMTAppInboxInterface j;
    public final WeakReference<Context> k;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/netcore/android/Smartech$Companion;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "Lcom/netcore/android/Smartech;", "buildInstance", "(Ljava/lang/ref/WeakReference;)Lcom/netcore/android/Smartech;", "getInstance", "INSTANCE", "Lcom/netcore/android/Smartech;", "", "isAppInitialized", "Z", "isInitializeInProgress", "Lcom/netcore/android/preference/SMTPreferenceHelper;", "mPreferences", "Lcom/netcore/android/preference/SMTPreferenceHelper;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Smartech.kt */
    public static final class Companion {
        public Companion() {
        }

        private final Smartech buildInstance(WeakReference<Context> weakReference) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                com.netcore.android.preference.SMTPreferenceHelper.Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                Smartech.n = companion.getAppPreferenceInstance(context, null);
            }
            return new Smartech(weakReference, null);
        }

        public final Smartech getInstance(WeakReference<Context> weakReference) {
            Smartech smartech;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            Smartech access$getINSTANCE$cp = Smartech.o;
            if (access$getINSTANCE$cp != null) {
                return access$getINSTANCE$cp;
            }
            synchronized (Smartech.class) {
                Smartech access$getINSTANCE$cp2 = Smartech.o;
                if (access$getINSTANCE$cp2 != null) {
                    smartech = access$getINSTANCE$cp2;
                } else {
                    smartech = Smartech.Companion.buildInstance(weakReference);
                    Smartech.o = smartech;
                }
            }
            return smartech;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Smartech.kt */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1002a;

        public a(Smartech smartech) {
            this.f1002a = smartech;
        }

        public final void run() {
            com.netcore.android.inapp.a.f1175d.b(this.f1002a.getContext()).e();
        }
    }

    /* compiled from: Smartech.kt */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1003a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f1004b;

        public b(Smartech smartech, boolean z) {
            this.f1003a = smartech;
            this.f1004b = z;
        }

        public final void run() {
            Context context = (Context) this.f1003a.getContext().get();
            if (context != null) {
                C0003a aVar = com.netcore.android.event.a.g;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                aVar.b(context).a(this.f1004b);
            }
        }
    }

    /* compiled from: Smartech.kt */
    public static final class c extends Lambda implements Function2<JSONObject, Uri, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f1006b;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public c(Smartech smartech, Ref$ObjectRef ref$ObjectRef) {
            // this.f1005a = smartech;
            // this.f1006b = ref$ObjectRef;
            super(2);
        }

        public final void a(JSONObject jSONObject, Uri uri) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(uri, "uri");
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    String optString = jSONObject.optString(next);
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(key)");
                    ((HashMap) this.f1006b.element).put(next, optString);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                for (String str : queryParameterNames) {
                    if (str != null && !((HashMap) this.f1006b.element).containsKey(str)) {
                        String queryParameter = uri.getQueryParameter(str);
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(key)");
                        ((HashMap) this.f1006b.element).put(str, queryParameter);
                    }
                }
            } catch (Throwable th) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String access$getTAG$p = this.f1005a.f996a;
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p, UeCustomType.TAG);
                sMTLogger.e(access$getTAG$p, String.valueOf(th.getMessage()));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((JSONObject) obj, (Uri) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: Smartech.kt */
    public static final class d extends Lambda implements Function0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1007a;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public d(Smartech smartech) {
            // this.f1007a = smartech;
            super(0);
        }

        public final boolean a() {
            try {
                SMTPreferenceHelper access$getMPreferences$cp = Smartech.n;
                if (access$getMPreferences$cp != null) {
                    JSONArray jSONArray = new JSONArray(access$getMPreferences$cp.getString(SMTPreferenceConstants.GUIDS));
                    String deviceUniqueId = this.f1007a.getDeviceUniqueId();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (Intrinsics.areEqual(jSONArray.get(i), deviceUniqueId)) {
                            return true;
                        }
                    }
                    return false;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            } catch (Throwable th) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String access$getTAG$p = this.f1007a.f996a;
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p, UeCustomType.TAG);
                sMTLogger.e(access$getTAG$p, String.valueOf(th.getMessage()));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(a());
        }
    }

    /* compiled from: Smartech.kt */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f1008a;

        public e(Context context) {
            this.f1008a = context;
        }

        public final void run() {
            C0003a aVar = com.netcore.android.event.a.g;
            Context context = this.f1008a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aVar.b(context).d();
        }
    }

    /* compiled from: Smartech.kt */
    public static final class f extends Lambda implements Function0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f1009a = new f();

        public f() {
            super(0);
        }

        public final boolean a() {
            return !Smartech.l && !Smartech.m;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(a());
        }
    }

    /* compiled from: Smartech.kt */
    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1010a;

        public g(Smartech smartech) {
            this.f1010a = smartech;
        }

        public final void run() {
            String a2 = Smartech.access$getMSmartechHelper$p(this.f1010a).a(this.f1010a.getContext());
            if (!(a2 == null || a2.length() == 0)) {
                Context context = (Context) this.f1010a.getContext().get();
                if (context != null) {
                    C0003a aVar = com.netcore.android.event.a.g;
                    Intrinsics.checkNotNullExpressionValue(context, "it");
                    aVar.b(context).a(true);
                }
            }
        }
    }

    /* compiled from: Smartech.kt */
    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1011a;

        public h(Smartech smartech) {
            this.f1011a = smartech;
        }

        public final void run() {
            this.f1011a.j();
            com.netcore.android.utility.g.f1302f.a();
            Smartech.access$getMSmartechHelper$p(this.f1011a).a(SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH);
        }
    }

    /* compiled from: Smartech.kt */
    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Smartech f1012a;

        public i(Smartech smartech) {
            this.f1012a = smartech;
        }

        public final void run() {
            Smartech.l = true;
            Thread.sleep(2000);
            if (SMTActivityLifecycleCallback.Companion.getInstance().isAppInForeground()) {
                this.f1012a.d();
                this.f1012a.j();
                Smartech.access$getMSmartechHelper$p(this.f1012a).a(SMTApiTypeID.SDK_INITIALIZE);
                return;
            }
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String access$getTAG$p = this.f1012a.f996a;
            Intrinsics.checkNotNullExpressionValue(access$getTAG$p, UeCustomType.TAG);
            sMTLogger.i(access$getTAG$p, "Initialization is skipped because application is in background. ");
            Smartech.l = false;
        }
    }

    public Smartech(WeakReference<Context> weakReference) {
        this.k = weakReference;
        this.f996a = Smartech.class.getSimpleName();
        this.f999d = new ArrayList<>();
        this.f1000e = new ArrayList<>();
    }

    private final void a() {
        try {
            SMTThreadPoolManager.INSTANCE.getIntance().execute(new a(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static final /* synthetic */ c access$getMSmartechHelper$p(Smartech smartech) {
        c cVar = smartech.f998c;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
        throw null;
    }

    public static final /* synthetic */ com.netcore.android.utility.g access$getMSmtInfo$p(Smartech smartech) {
        com.netcore.android.utility.g gVar = smartech.f997b;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
        throw null;
    }

    private final void b(WeakReference<Context> weakReference) {
        Context context = (Context) weakReference.get();
        if (context != null) {
            SMTWorkerScheduler instance = SMTWorkerScheduler.Companion.getInstance();
            Intrinsics.checkNotNullExpressionValue(context, "it");
            instance.scheduleInProgressEventWorker(context);
        }
    }

    private final void c() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f996a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "Init block is called");
        try {
            com.netcore.android.utility.g b2 = com.netcore.android.utility.g.f1302f.b(this.k);
            this.f997b = b2;
            WeakReference<Context> weakReference = this.k;
            if (b2 != null) {
                SMTPreferenceHelper sMTPreferenceHelper = n;
                if (sMTPreferenceHelper != null) {
                    this.f998c = new c(weakReference, b2, sMTPreferenceHelper, this);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
                throw null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        d dVar = new d(this);
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                int i2 = sMTPreferenceHelper.getInt(SMTPreferenceConstants.SMT_DEBUG_LEVEL, -1);
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    if (sMTPreferenceHelper2.getBoolean(SMTPreferenceConstants.IS_LOG_ENABLED) && dVar.a()) {
                        SMTPreferenceHelper sMTPreferenceHelper3 = n;
                        if (sMTPreferenceHelper3 != null) {
                            i2 = sMTPreferenceHelper3.getInt(SMTPreferenceConstants.LOG_LEVEL);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                            throw null;
                        }
                    } else if (i2 < 0) {
                        i2 = 7;
                    }
                    SMTPreferenceHelper sMTPreferenceHelper4 = n;
                    if (sMTPreferenceHelper4 != null) {
                        sMTPreferenceHelper4.setInt(SMTPreferenceConstants.SMT_DEBUG_LEVEL, i2);
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        sMTLogger.setDebugLevel(i2);
                        String str = this.f996a;
                        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                        sMTLogger.i(str, "SDK debug level: " + i2);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final void e() {
        try {
            SMTThreadPoolManager.INSTANCE.getIntance().execute(new h(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final void f() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                if (sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH, true)) {
                    this.f999d.add(Integer.valueOf(83));
                    SMTPreferenceHelper sMTPreferenceHelper2 = n;
                    if (sMTPreferenceHelper2 != null) {
                        sMTPreferenceHelper2.setBoolean(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH, false);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                        throw null;
                    }
                } else {
                    this.f999d.add(Integer.valueOf(21));
                    this.f999d.add(Integer.valueOf(26));
                }
                this.f999d.add(Integer.valueOf(89));
                c cVar = this.f998c;
                if (cVar != null) {
                    cVar.a(this.f999d);
                    this.f999d.clear();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final void g() {
        SMTPreferenceHelper sMTPreferenceHelper = n;
        if (sMTPreferenceHelper != null) {
            sMTPreferenceHelper.setLong(SMTPreferenceConstants.LAST_APP_ACTIVE_TIME_STAMP, System.currentTimeMillis());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        }
    }

    public static final Smartech getInstance(WeakReference<Context> weakReference) {
        return Companion.getInstance(weakReference);
    }

    private final void h() {
        try {
            a(this.k);
            b(this.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final void i() {
        try {
            SMTThreadPoolManager.INSTANCE.getIntance().execute(new i(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                sMTPreferenceHelper.setLong(SMTPreferenceConstants.CURRENT_SESSION_ID, System.currentTimeMillis());
                Context context = (Context) this.k.get();
                if (context != null) {
                    com.netcore.android.inapp.c b2 = com.netcore.android.inapp.c.g.b();
                    Intrinsics.checkNotNullExpressionValue(context, "it");
                    b2.b(context);
                }
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    if (!sMTPreferenceHelper2.getBoolean(SMTPreferenceConstants.IS_LAUNCHED_FROM_NOTIFICATION, false)) {
                        SMTPreferenceHelper sMTPreferenceHelper3 = n;
                        if (sMTPreferenceHelper3 != null) {
                            sMTPreferenceHelper3.setString(SMTPreferenceConstants.SMT_ATTRIBUTION_PARAMS, "");
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                            throw null;
                        }
                    }
                    SMTPreferenceHelper sMTPreferenceHelper4 = n;
                    if (sMTPreferenceHelper4 != null) {
                        sMTPreferenceHelper4.setBoolean(SMTPreferenceConstants.IS_LAUNCHED_FROM_NOTIFICATION, false);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void trackEvent$default(Smartech smartech, String str, HashMap hashMap, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hashMap = null;
        }
        smartech.trackEvent(str, hashMap);
    }

    public final void clearSystemEventList$smartech_release() {
        try {
            this.f1000e.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clearUserIdentity() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    sMTPreferenceHelper.setString(SMTPreferenceConstants.SMT_USER_OLD_IDENTITY, sMTPreferenceHelper2.getString(SMTPreferenceConstants.SMT_USER_IDENTITY, ""));
                    SMTPreferenceHelper sMTPreferenceHelper3 = n;
                    if (sMTPreferenceHelper3 != null) {
                        sMTPreferenceHelper3.setString(SMTPreferenceConstants.SMT_USER_IDENTITY, "");
                        a();
                        HanselInterface hanselInstance$smartech_release = getHanselInstance$smartech_release();
                        if (hanselInstance$smartech_release != null) {
                            hanselInstance$smartech_release.clearUserIdentity();
                            return;
                        }
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void fetchListAndSegment() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final String getAppID() {
        try {
            c cVar = this.f998c;
            if (cVar != null) {
                return cVar.a(this.k);
            }
            Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
            throw null;
        } catch (Throwable unused) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f996a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, "Error while reading App id.");
            return "";
        }
    }

    public final WeakReference<Context> getContext() {
        return this.k;
    }

    public final String getDeviceUniqueId() {
        try {
            com.netcore.android.utility.g gVar = this.f997b;
            if (gVar != null) {
                com.netcore.android.utility.d c2 = gVar.c();
                if (c2 == null) {
                    return "";
                }
                String h2 = c2.h();
                return h2 != null ? h2 : "";
            }
            Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final HanselInterface getHanselInstance$smartech_release() {
        return this.h;
    }

    public final InAppCustomHTMLListener getInAppCustomHTMLListener() {
        return this.g;
    }

    public final boolean getInAppRuleListStatus$smartech_release() {
        try {
            return this.f1001f;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final String getSDKVersion() {
        try {
            com.netcore.android.utility.g gVar = this.f997b;
            if (gVar != null) {
                com.netcore.android.utility.a b2 = gVar.b();
                if (b2 == null) {
                    return "";
                }
                String f2 = b2.f();
                return f2 != null ? f2 : "";
            }
            Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
            throw null;
        } catch (Throwable unused) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f996a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.e(str, "Error while reading SDK version.");
            return "";
        }
    }

    public final String getSmartechAttributionURL(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new HashMap();
        c cVar = new c(this, ref$ObjectRef);
        try {
            String string = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_ATTRIBUTION_PARAMS);
            try {
                Builder clearQuery = Uri.parse(str).buildUpon().clearQuery();
                Uri parse = Uri.parse(str);
                if (!(string.length() > 0)) {
                    return str;
                }
                Intrinsics.checkNotNullExpressionValue(parse, "deepLinkUri");
                if (parse.getScheme() == null || parse.getHost() == null) {
                    return str;
                }
                cVar.a(new JSONObject(string), parse);
                for (Entry entry : ((HashMap) ref$ObjectRef.element).entrySet()) {
                    clearQuery.appendQueryParameter((String) entry.getKey(), URLDecoder.decode((String) entry.getValue(), "UTF-8"));
                }
                clearQuery.build();
                String url = new URL(clearQuery.toString()).toString();
                Intrinsics.checkNotNullExpressionValue(url, "URL(updatedURLBuilder.toString()).toString()");
                return url;
            } catch (Throwable th) {
                th = th;
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str2 = this.f996a;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger.e(str2, String.valueOf(th.getMessage()));
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str22 = this.f996a;
            Intrinsics.checkNotNullExpressionValue(str22, UeCustomType.TAG);
            sMTLogger2.e(str22, String.valueOf(th.getMessage()));
            return str;
        }
    }

    public final SmartechPushInterface getSmartechPNInterface$smartech_release() {
        SmartechPushInterface smartechPushInterface = this.i;
        return smartechPushInterface != null ? smartechPushInterface : ModuleChecker.INSTANCE.getSmartechPush();
    }

    public final com.netcore.android.utility.g getSmtInfo() {
        com.netcore.android.utility.g gVar = this.f997b;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
        throw null;
    }

    public final List<Integer> getSystemInAppEventList$smartech_release() {
        return this.f1000e;
    }

    public String getUUID() {
        try {
            return getDeviceUniqueId();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final String getUserIdentity() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                return sMTPreferenceHelper.getString(SMTPreferenceConstants.SMT_USER_IDENTITY);
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final boolean hasOptedInAppMessage() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                return sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.OPT_IN_OUT_IN_APP_MESSAGES);
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean hasOptedTracking() {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                return sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.OPT_IN_OUT_TRACKING);
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void initializeSdk(Application application) {
        initializeSdk(application, null, null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0010 A[Catch:{ all -> 0x000b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[SYNTHETIC, Splitter:B:26:0x0063] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void login(java.lang.String r12) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x000d
            int r0 = r12.length()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0009
            goto L_0x000d
        L_0x0009:
            r0 = 0
            goto L_0x000e
        L_0x000b:
            r12 = move-exception
            goto L_0x007f
        L_0x000d:
            r0 = 1
        L_0x000e:
            if (r0 != 0) goto L_0x0063
            com.netcore.android.c r0 = r11.f998c     // Catch:{ all -> 0x000b }
            r1 = 0
            if (r0 == 0) goto L_0x005d
            r0.a(r12)     // Catch:{ all -> 0x000b }
            com.netcore.android.preference.SMTPreferenceHelper r0 = n     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0057
            java.lang.String r1 = "smt_user_identity"
            r0.setString(r1, r12)     // Catch:{ all -> 0x000b }
            java.lang.ref.WeakReference<android.content.Context> r0 = r11.k     // Catch:{ all -> 0x000b }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000b }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x004a
            com.netcore.android.event.e$a r1 = com.netcore.android.event.e.f1081f     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x000b }
            com.netcore.android.event.e r3 = r1.b(r0)     // Catch:{ all -> 0x000b }
            r4 = 22
            com.netcore.android.event.SMTEventId$Companion r0 = com.netcore.android.event.SMTEventId.Companion     // Catch:{ all -> 0x000b }
            r1 = 22
            java.lang.String r5 = r0.getEventName(r1)     // Catch:{ all -> 0x000b }
            r6 = 0
            java.lang.String r7 = "system"
            r8 = 0
            r9 = 16
            r10 = 0
            com.netcore.android.event.e.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x000b }
        L_0x004a:
            r11.a()     // Catch:{ all -> 0x000b }
            com.netcore.android.smartechbase.communication.HanselInterface r0 = r11.getHanselInstance$smartech_release()     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0082
            r0.login(r12)     // Catch:{ all -> 0x000b }
            goto L_0x0082
        L_0x0057:
            java.lang.String r12 = "mPreferences"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)     // Catch:{ all -> 0x000b }
            throw r1
        L_0x005d:
            java.lang.String r12 = "mSmartechHelper"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)     // Catch:{ all -> 0x000b }
            throw r1
        L_0x0063:
            com.netcore.android.logger.SMTLogger r12 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x000b }
            java.lang.String r0 = r11.f996a     // Catch:{ all -> 0x000b }
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x000b }
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()     // Catch:{ all -> 0x000b }
            int r2 = com.netcore.android.R.string.identity_unavailable     // Catch:{ all -> 0x000b }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "Resources.getSystem().ge…ing.identity_unavailable)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x000b }
            r12.w(r0, r1)     // Catch:{ all -> 0x000b }
            goto L_0x0082
        L_0x007f:
            r12.printStackTrace()
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.login(java.lang.String):void");
    }

    public final void logoutAndClearUserIdentity(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SMTEventParamKeys.SMT_CLEAR_IDENTITY, Boolean.valueOf(z));
            Context context = (Context) this.k.get();
            if (context != null) {
                com.netcore.android.event.e.a aVar = com.netcore.android.event.e.f1081f;
                Intrinsics.checkNotNullExpressionValue(context, "ctx");
                com.netcore.android.event.e.a(aVar.b(context), 23, SMTEventId.Companion.getEventName(23), hashMap, "system", false, 16, null);
            }
            if (z) {
                clearUserIdentity();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onAppBackground() {
        try {
            Context context = (Context) this.k.get();
            if (context != null) {
                C0003a aVar = com.netcore.android.event.a.g;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                aVar.b(context).a(false);
            }
            g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[Catch:{ Exception -> 0x001f, all -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5 A[SYNTHETIC, Splitter:B:43:0x00b5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAppForeground() {
        /*
            r9 = this;
            r0 = 1
            r9.a(r0)     // Catch:{ all -> 0x00df }
            java.lang.ref.WeakReference<android.content.Context> r1 = r9.k     // Catch:{ all -> 0x00df }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00df }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "TAG"
            if (r1 == 0) goto L_0x0032
            com.netcore.android.Smartech$e r3 = new com.netcore.android.Smartech$e     // Catch:{ Exception -> 0x001f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x001f }
            com.netcore.android.network.SMTThreadPoolManager r1 = com.netcore.android.network.SMTThreadPoolManager.INSTANCE     // Catch:{ Exception -> 0x001f }
            java.util.concurrent.ScheduledExecutorService r1 = r1.getIntance()     // Catch:{ Exception -> 0x001f }
            r1.execute(r3)     // Catch:{ Exception -> 0x001f }
            goto L_0x0032
        L_0x001f:
            r1 = move-exception
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x00df }
            java.lang.String r4 = r9.f996a     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch:{ all -> 0x00df }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00df }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00df }
            r3.e(r4, r1)     // Catch:{ all -> 0x00df }
        L_0x0032:
            com.netcore.android.Smartech$f r1 = com.netcore.android.Smartech.f.f1009a     // Catch:{ all -> 0x00df }
            boolean r1 = r1.a()     // Catch:{ all -> 0x00df }
            java.lang.String r3 = "mSmartechHelper"
            r4 = 0
            if (r1 == 0) goto L_0x00bd
            com.netcore.android.logger.SMTLogger r1 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r9.f996a     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r6.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r7 = "Smartech SDK - v3.2.15, app id: "
            r6.append(r7)     // Catch:{ all -> 0x00df }
            com.netcore.android.utility.g r7 = r9.f997b     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "mSmtInfo"
            if (r7 == 0) goto L_0x00b9
            com.netcore.android.utility.a r7 = r7.b()     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x0065
            com.netcore.android.utility.h r7 = r7.d()     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x0065
            java.lang.String r7 = r7.b()     // Catch:{ all -> 0x00df }
            goto L_0x0066
        L_0x0065:
            r7 = r4
        L_0x0066:
            r6.append(r7)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = ", guid: "
            r6.append(r7)     // Catch:{ all -> 0x00df }
            com.netcore.android.utility.g r7 = r9.f997b     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x00b5
            com.netcore.android.utility.d r7 = r7.c()     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x007d
            java.lang.String r7 = r7.h()     // Catch:{ all -> 0x00df }
            goto L_0x007e
        L_0x007d:
            r7 = r4
        L_0x007e:
            r6.append(r7)     // Catch:{ all -> 0x00df }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00df }
            r1.i(r5, r6)     // Catch:{ all -> 0x00df }
            com.netcore.android.c r5 = r9.f998c     // Catch:{ all -> 0x00df }
            if (r5 == 0) goto L_0x00b1
            java.lang.ref.WeakReference<android.content.Context> r6 = r9.k     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r5.a(r6)     // Catch:{ all -> 0x00df }
            r6 = 0
            if (r5 == 0) goto L_0x009d
            int r5 = r5.length()     // Catch:{ all -> 0x00df }
            if (r5 != 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r0 = 0
        L_0x009d:
            if (r0 != 0) goto L_0x00a3
            r9.i()     // Catch:{ all -> 0x00df }
            goto L_0x00bd
        L_0x00a3:
            r9.a(r6)     // Catch:{ all -> 0x00df }
            java.lang.String r0 = r9.f996a     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x00df }
            java.lang.String r5 = "App Id is either null or empty."
            r1.w(r0, r5)     // Catch:{ all -> 0x00df }
            goto L_0x00bd
        L_0x00b1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ all -> 0x00df }
            throw r4
        L_0x00b5:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch:{ all -> 0x00df }
            throw r4
        L_0x00b9:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch:{ all -> 0x00df }
            throw r4
        L_0x00bd:
            boolean r0 = m     // Catch:{ all -> 0x00df }
            if (r0 == 0) goto L_0x00e3
            com.netcore.android.c r0 = r9.f998c     // Catch:{ all -> 0x00df }
            if (r0 == 0) goto L_0x00db
            boolean r0 = r0.d()     // Catch:{ all -> 0x00df }
            if (r0 == 0) goto L_0x00e3
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x00df }
            java.lang.String r1 = r9.f996a     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "Session expired"
            r0.i(r1, r2)     // Catch:{ all -> 0x00df }
            r9.e()     // Catch:{ all -> 0x00df }
            goto L_0x00e3
        L_0x00db:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ all -> 0x00df }
            throw r4
        L_0x00df:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.onAppForeground():void");
    }

    public final void onAppForegroundStateChanged$smartech_release(boolean z) {
        try {
            if (!l && m && z) {
                SMTThreadPoolManager.INSTANCE.getIntance().execute(new g(this));
                c cVar = this.f998c;
                if (cVar != null) {
                    cVar.i();
                    SMTPreferenceHelper sMTPreferenceHelper = n;
                    if (sMTPreferenceHelper != null) {
                        sMTPreferenceHelper.setBoolean(SMTPreferenceConstants.IS_LAUNCHED_FROM_NOTIFICATION, false);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                    throw null;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResponseFailure(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        try {
            int i2 = a.f1014b[sMTResponse.getSmtApiTypeID().ordinal()];
            if (i2 == 1 || i2 == 2) {
                a(sMTResponse);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResponseSuccess(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, Constant.TAG_RESPONSE);
        try {
            int i2 = a.f1013a[sMTResponse.getSmtApiTypeID().ordinal()];
            if (i2 == 1 || i2 == 2) {
                b(sMTResponse);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void optInAppMessage(boolean z) {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper != null) {
                boolean z2 = sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.OPT_IN_OUT_IN_APP_MESSAGES);
                Context context = (Context) this.k.get();
                if (context != null && z2 != z) {
                    SMTPreferenceHelper sMTPreferenceHelper2 = n;
                    if (sMTPreferenceHelper2 != null) {
                        sMTPreferenceHelper2.setBoolean(SMTPreferenceConstants.OPT_IN_OUT_IN_APP_MESSAGES, z);
                        if (z) {
                            com.netcore.android.event.e.a aVar = com.netcore.android.event.e.f1081f;
                            Intrinsics.checkNotNullExpressionValue(context, "ctx");
                            com.netcore.android.event.e.a(aVar.b(context), 74, SMTEventId.Companion.getEventName(74), null, SMTEventType.EVENT_TYPE_SYSTEM_IN_APP, false, 16, null);
                            return;
                        }
                        com.netcore.android.event.e.a aVar2 = com.netcore.android.event.e.f1081f;
                        Intrinsics.checkNotNullExpressionValue(context, "ctx");
                        com.netcore.android.event.e.a(aVar2.b(context), 75, SMTEventId.Companion.getEventName(75), null, SMTEventType.EVENT_TYPE_SYSTEM_IN_APP, false, 16, null);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void optTracking(boolean z) {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            } else if (sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.OPT_IN_OUT_TRACKING) != z) {
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    sMTPreferenceHelper2.setBoolean(SMTPreferenceConstants.OPT_IN_OUT_TRACKING, z);
                    Context context = (Context) this.k.get();
                    if (context == null) {
                        return;
                    }
                    if (z) {
                        com.netcore.android.event.e.a aVar = com.netcore.android.event.e.f1081f;
                        Intrinsics.checkNotNullExpressionValue(context, "ctx");
                        com.netcore.android.event.e.a(aVar.b(context), 70, SMTEventId.Companion.getEventName(70), null, "system", false, 16, null);
                        return;
                    }
                    com.netcore.android.event.e.a aVar2 = com.netcore.android.event.e.f1081f;
                    Intrinsics.checkNotNullExpressionValue(context, "ctx");
                    com.netcore.android.event.e.a(aVar2.b(context), 71, SMTEventId.Companion.getEventName(71), null, "system", false, 16, null);
                    Context context2 = (Context) this.k.get();
                    if (context2 != null) {
                        SMTWorkerScheduler instance = SMTWorkerScheduler.Companion.getInstance();
                        Intrinsics.checkNotNullExpressionValue(context2, "it");
                        instance.checkStatusAndScheduleEventWorker(context2);
                        return;
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void processEventsManually() {
        try {
            Context context = (Context) this.k.get();
            if (context != null) {
                C0003a aVar = com.netcore.android.event.a.g;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                aVar.b(context).d();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDebugLevel(int i2) {
        try {
            SMTPreferenceHelper sMTPreferenceHelper = n;
            if (sMTPreferenceHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            } else if (sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.IS_LOG_ENABLED)) {
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    int i3 = sMTPreferenceHelper2.getInt(SMTPreferenceConstants.LOG_LEVEL, 7);
                    SMTPreferenceHelper sMTPreferenceHelper3 = n;
                    if (sMTPreferenceHelper3 != null) {
                        sMTPreferenceHelper3.setInt(SMTPreferenceConstants.SMT_DEBUG_LEVEL, i3);
                        SMTLogger.INSTANCE.setDebugLevel(i3);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            } else {
                SMTPreferenceHelper sMTPreferenceHelper4 = n;
                if (sMTPreferenceHelper4 != null) {
                    sMTPreferenceHelper4.setInt(SMTPreferenceConstants.SMT_DEBUG_LEVEL, i2);
                    SMTLogger.INSTANCE.setDebugLevel(i2);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                throw null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setDeviceAdvertiserId(String str) {
        try {
            c cVar = this.f998c;
            if (cVar != null) {
                cVar.b(str);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                throw null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInAppCustomHTMLListener(InAppCustomHTMLListener inAppCustomHTMLListener) {
        try {
            this.g = inAppCustomHTMLListener;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInAppRuleListStatus$smartech_release(boolean z) {
        try {
            this.f1001f = z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0010 A[Catch:{ all -> 0x000b }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A[SYNTHETIC, Splitter:B:21:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setUserIdentity(java.lang.String r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x000d
            int r0 = r4.length()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0009
            goto L_0x000d
        L_0x0009:
            r0 = 0
            goto L_0x000e
        L_0x000b:
            r4 = move-exception
            goto L_0x004d
        L_0x000d:
            r0 = 1
        L_0x000e:
            if (r0 != 0) goto L_0x002e
            com.netcore.android.c r0 = r3.f998c     // Catch:{ all -> 0x000b }
            r1 = 0
            if (r0 == 0) goto L_0x0028
            r0.a(r4)     // Catch:{ all -> 0x000b }
            com.netcore.android.preference.SMTPreferenceHelper r0 = n     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0022
            java.lang.String r1 = "smt_user_identity"
            r0.setString(r1, r4)     // Catch:{ all -> 0x000b }
            goto L_0x0049
        L_0x0022:
            java.lang.String r4 = "mPreferences"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x000b }
            throw r1
        L_0x0028:
            java.lang.String r4 = "mSmartechHelper"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x000b }
            throw r1
        L_0x002e:
            com.netcore.android.logger.SMTLogger r4 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x000b }
            java.lang.String r0 = r3.f996a     // Catch:{ all -> 0x000b }
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x000b }
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()     // Catch:{ all -> 0x000b }
            int r2 = com.netcore.android.R.string.identity_unavailable     // Catch:{ all -> 0x000b }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "Resources.getSystem()\n  …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x000b }
            r4.w(r0, r1)     // Catch:{ all -> 0x000b }
        L_0x0049:
            r3.a()     // Catch:{ all -> 0x000b }
            goto L_0x0050
        L_0x004d:
            r4.printStackTrace()
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.setUserIdentity(java.lang.String):void");
    }

    public final void setUserLocation(Location location) {
        if (location != null) {
            try {
                com.netcore.android.utility.g gVar = this.f997b;
                if (gVar != null) {
                    com.netcore.android.utility.d c2 = gVar.c();
                    if (c2 != null) {
                        c2.a(String.valueOf(location.getLatitude()));
                    }
                    com.netcore.android.utility.g gVar2 = this.f997b;
                    if (gVar2 != null) {
                        com.netcore.android.utility.d c3 = gVar2.c();
                        if (c3 != null) {
                            c3.b(String.valueOf(location.getLongitude()));
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mSmtInfo");
                        throw null;
                    }
                }
                SMTPreferenceHelper sMTPreferenceHelper = n;
                if (sMTPreferenceHelper != null) {
                    sMTPreferenceHelper.setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LATITUDE, String.valueOf(location.getLatitude()));
                    SMTPreferenceHelper sMTPreferenceHelper2 = n;
                    if (sMTPreferenceHelper2 != null) {
                        sMTPreferenceHelper2.setString(SMTPreferenceConstants.SMT_LAST_KNOWN_LONGITUDE, String.valueOf(location.getLongitude()));
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f996a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.v(str, "Location is null.");
        }
    }

    public final boolean trackAppInstall() {
        try {
            this.f999d.add(Integer.valueOf(20));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    public final void trackAppInstallUpdateBySmartech() {
        try {
            this.f999d.add(Integer.valueOf(999));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void trackAppUpdate() {
        try {
            this.f999d.add(Integer.valueOf(81));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void trackEvent(String str) {
        trackEvent$default(this, str, null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0010 A[Catch:{ all -> 0x000b }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[Catch:{ all -> 0x000b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackEvent(java.lang.String r12, java.util.HashMap<java.lang.String, java.lang.Object> r13) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x000d
            int r0 = r12.length()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0009
            goto L_0x000d
        L_0x0009:
            r0 = 0
            goto L_0x000e
        L_0x000b:
            r12 = move-exception
            goto L_0x0041
        L_0x000d:
            r0 = 1
        L_0x000e:
            if (r0 != 0) goto L_0x0032
            java.lang.ref.WeakReference<android.content.Context> r0 = r11.k     // Catch:{ all -> 0x000b }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000b }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0044
            com.netcore.android.event.e$a r1 = com.netcore.android.event.e.f1081f     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x000b }
            com.netcore.android.event.e r3 = r1.b(r0)     // Catch:{ all -> 0x000b }
            r4 = 0
            java.lang.String r7 = "custom"
            r8 = 0
            r9 = 16
            r10 = 0
            r5 = r12
            r6 = r13
            com.netcore.android.event.e.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x000b }
            goto L_0x0044
        L_0x0032:
            com.netcore.android.logger.SMTLogger r12 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x000b }
            java.lang.String r13 = r11.f996a     // Catch:{ all -> 0x000b }
            java.lang.String r0 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x000b }
            java.lang.String r0 = "Event name or HashMap is either null or empty."
            r12.v(r13, r0)     // Catch:{ all -> 0x000b }
            goto L_0x0044
        L_0x0041:
            r12.printStackTrace()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.trackEvent(java.lang.String, java.util.HashMap):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ all -> 0x000d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[Catch:{ all -> 0x000d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackEventFromHansel(java.lang.String r11, java.util.HashMap<java.lang.String, java.lang.Object> r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x000f
            int r2 = r11.length()     // Catch:{ all -> 0x000d }
            if (r2 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            r2 = 0
            goto L_0x0010
        L_0x000d:
            r11 = move-exception
            goto L_0x005f
        L_0x000f:
            r2 = 1
        L_0x0010:
            if (r2 != 0) goto L_0x0050
            java.lang.ref.WeakReference<android.content.Context> r2 = r10.k     // Catch:{ all -> 0x000d }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x000d }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x000d }
            if (r2 == 0) goto L_0x0062
            com.netcore.android.event.SMTEventId$Companion r3 = com.netcore.android.event.SMTEventId.Companion     // Catch:{ all -> 0x000d }
            int r5 = r3.getEventId(r11)     // Catch:{ all -> 0x000d }
            java.lang.String r3 = r10.getUserIdentity()     // Catch:{ all -> 0x000d }
            int r4 = r3.length()     // Catch:{ all -> 0x000d }
            if (r4 <= 0) goto L_0x002d
            r0 = 1
        L_0x002d:
            if (r0 == 0) goto L_0x0036
            if (r12 == 0) goto L_0x0036
            java.lang.String r0 = "identity"
            r12.put(r0, r3)     // Catch:{ all -> 0x000d }
        L_0x0036:
            com.netcore.android.event.e$a r0 = com.netcore.android.event.e.f1081f     // Catch:{ all -> 0x000d }
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ all -> 0x000d }
            com.netcore.android.event.e r4 = r0.b(r2)     // Catch:{ all -> 0x000d }
            if (r5 != 0) goto L_0x0046
            java.lang.String r0 = "custom"
            goto L_0x0048
        L_0x0046:
            java.lang.String r0 = "system"
        L_0x0048:
            r8 = r0
            r9 = 1
            r6 = r11
            r7 = r12
            r4.a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x000d }
            goto L_0x0062
        L_0x0050:
            com.netcore.android.logger.SMTLogger r11 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x000d }
            java.lang.String r12 = r10.f996a     // Catch:{ all -> 0x000d }
            java.lang.String r0 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch:{ all -> 0x000d }
            java.lang.String r0 = "Event name or HashMap is either null or empty."
            r11.v(r12, r0)     // Catch:{ all -> 0x000d }
            goto L_0x0062
        L_0x005f:
            r11.printStackTrace()
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.trackEventFromHansel(java.lang.String, java.util.HashMap):void");
    }

    public final void updateUserProfile(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            try {
                if (com.netcore.android.g.a.a.f1093c.b(this.k).a(hashMap)) {
                    Context context = (Context) this.k.get();
                    if (context != null) {
                        com.netcore.android.event.e.a aVar = com.netcore.android.event.e.f1081f;
                        Intrinsics.checkNotNullExpressionValue(context, "ctx");
                        com.netcore.android.event.e.a(aVar.b(context), 40, SMTEventId.Companion.getEventName(40), hashMap, "system", false, 16, null);
                    }
                    HanselInterface hanselInstance$smartech_release = getHanselInstance$smartech_release();
                    if (hanselInstance$smartech_release != null) {
                        hanselInstance$smartech_release.setUserAttributes(hashMap);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void initializeSdk(Application application, String str, String str2, String str3) {
        if (application != null) {
            try {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str4 = this.f996a;
                Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                sMTLogger.i(str4, "SDK initialization started.");
                if (str != null) {
                    SMTPreferenceHelper sMTPreferenceHelper = n;
                    if (sMTPreferenceHelper != null) {
                        sMTPreferenceHelper.setString("app_id", str);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                        throw null;
                    }
                }
                c();
                SMTActivityLifecycleCallback.Companion.getInstance().register$smartech_release(application);
                c cVar = this.f998c;
                if (cVar != null) {
                    boolean b2 = cVar.b(this.k);
                    String str5 = this.f996a;
                    Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
                    sMTLogger.d(str5, "Encryption mode enabled " + b2);
                    SMTPreferenceHelper sMTPreferenceHelper2 = n;
                    if (sMTPreferenceHelper2 != null) {
                        sMTPreferenceHelper2.setBoolean(SMTPreferenceConstants.SMT_ENCRYPT_DB, b2);
                        if (b2) {
                            com.netcore.android.utility.k.d a2 = com.netcore.android.utility.k.d.a("AES/GCM/NoPadding");
                            Intrinsics.checkNotNullExpressionValue(a2, "SMTEncryptionHelper.getI…nts.AES_CIPHER_ALGORITHM)");
                            a2.a().a();
                            SMTPreferenceHelper sMTPreferenceHelper3 = n;
                            if (sMTPreferenceHelper3 != null) {
                                sMTPreferenceHelper3.setString(SMTPreferenceConstants.SMT_ENCRYPTION_ENABLED_DATE, SMTCommonUtility.INSTANCE.getUTCDateTime$smartech_release());
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                                throw null;
                            }
                        } else {
                            SMTPreferenceHelper sMTPreferenceHelper4 = n;
                            if (sMTPreferenceHelper4 != null) {
                                sMTPreferenceHelper4.setString(SMTPreferenceConstants.SMT_ENCRYPTION_DISABLED_DATE, SMTCommonUtility.INSTANCE.getUTCDateTime$smartech_release());
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                                throw null;
                            }
                        }
                        HanselInterface b3 = b();
                        this.h = b3;
                        if (b3 != null) {
                            b3.init(application, this, str2, str3, getDeviceUniqueId());
                        }
                        ModuleChecker moduleChecker = ModuleChecker.INSTANCE;
                        SmartechPushInterface smartechPush = moduleChecker.getSmartechPush();
                        this.i = smartechPush;
                        if (smartechPush != null) {
                            smartechPush.init(application);
                        }
                        d.f1022f.b(application).h();
                        this.j = moduleChecker.getSmartechAppInbox();
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                throw null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str6 = this.f996a;
            Intrinsics.checkNotNullExpressionValue(str6, UeCustomType.TAG);
            sMTLogger2.w(str6, "Application instance is null.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0126 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012b A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0158 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x0160=Splitter:B:72:0x0160, B:28:0x00c2=Splitter:B:28:0x00c2, B:97:0x01e9=Splitter:B:97:0x01e9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(com.netcore.android.network.models.SMTResponse r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "TAG"
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x023f }
            java.lang.String r3 = r1.f996a     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ all -> 0x023f }
            java.lang.String r4 = "Smartech SDK initialized successfully."
            r2.i(r3, r4)     // Catch:{ all -> 0x023f }
            r3 = 0
            l = r3     // Catch:{ all -> 0x023f }
            r4 = 1
            m = r4     // Catch:{ all -> 0x023f }
            if (r18 == 0) goto L_0x0237
            r5 = r18
            com.netcore.android.network.models.SMTSdkInitializeResponse r5 = (com.netcore.android.network.models.SMTSdkInitializeResponse) r5     // Catch:{ all -> 0x023f }
            com.netcore.android.network.models.SMTRequest$SMTApiTypeID r6 = r18.getSmtApiTypeID()     // Catch:{ all -> 0x023f }
            int r6 = r6.getValue()     // Catch:{ all -> 0x023f }
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings r7 = r5.getSmartechSettings()     // Catch:{ all -> 0x023f }
            java.lang.String r8 = "it"
            r9 = 0
            if (r7 == 0) goto L_0x020a
            com.netcore.android.c r10 = r1.f998c     // Catch:{ all -> 0x023f }
            java.lang.String r11 = "mSmartechHelper"
            if (r10 == 0) goto L_0x0206
            r10.a(r7)     // Catch:{ all -> 0x023f }
            java.lang.String r10 = r1.f996a     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x023f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x023f }
            r12.<init>()     // Catch:{ all -> 0x023f }
            java.lang.String r13 = "Smartech SDK status Panel: "
            r12.append(r13)     // Catch:{ all -> 0x023f }
            boolean r13 = r7.getPanelActive()     // Catch:{ all -> 0x023f }
            r12.append(r13)     // Catch:{ all -> 0x023f }
            java.lang.String r13 = ", SDK: "
            r12.append(r13)     // Catch:{ all -> 0x023f }
            boolean r13 = r7.getSdkActive()     // Catch:{ all -> 0x023f }
            r12.append(r13)     // Catch:{ all -> 0x023f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x023f }
            r2.i(r10, r12)     // Catch:{ all -> 0x023f }
            java.lang.String r10 = r1.f996a     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x023f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x023f }
            r12.<init>()     // Catch:{ all -> 0x023f }
            java.lang.String r13 = "SDK initialized from Smartech panel with settings : "
            r12.append(r13)     // Catch:{ all -> 0x023f }
            java.lang.String r13 = r7.toLimitString()     // Catch:{ all -> 0x023f }
            r12.append(r13)     // Catch:{ all -> 0x023f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x023f }
            r2.i(r10, r12)     // Catch:{ all -> 0x023f }
            boolean r10 = r7.getPanelActive()     // Catch:{ all -> 0x023f }
            if (r10 == 0) goto L_0x01e9
            boolean r10 = r7.getSdkActive()     // Catch:{ all -> 0x023f }
            if (r10 == 0) goto L_0x01e9
            java.lang.ref.WeakReference<android.content.Context> r10 = r1.k     // Catch:{ all -> 0x023f }
            java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x023f }
            android.content.Context r10 = (android.content.Context) r10     // Catch:{ all -> 0x023f }
            java.lang.String r12 = "ctx"
            if (r10 == 0) goto L_0x00ab
            com.netcore.android.preference.SMTPreferenceHelper$Companion r13 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ all -> 0x023f }
            com.netcore.android.preference.SMTPreferenceHelper r13 = r13.getAppPreferenceInstance(r10, r9)     // Catch:{ all -> 0x023f }
            java.lang.String r14 = "isINITApiCallSuccessful"
            r13.setBoolean(r14, r4)     // Catch:{ all -> 0x023f }
            com.netcore.android.d$a r13 = com.netcore.android.d.f1022f     // Catch:{ all -> 0x023f }
            com.netcore.android.d r10 = r13.b(r10)     // Catch:{ all -> 0x023f }
            r10.d()     // Catch:{ all -> 0x023f }
        L_0x00ab:
            r17.h()     // Catch:{ all -> 0x023f }
            com.netcore.android.network.models.SMTRequest$SMTApiTypeID r10 = com.netcore.android.network.models.SMTRequest.SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH     // Catch:{ all -> 0x023f }
            int r10 = r10.getValue()     // Catch:{ all -> 0x023f }
            if (r6 == r10) goto L_0x00c2
            com.netcore.android.c r10 = r1.f998c     // Catch:{ all -> 0x023f }
            if (r10 == 0) goto L_0x00be
            r10.g()     // Catch:{ all -> 0x023f }
            goto L_0x00c2
        L_0x00be:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x00c2:
            java.lang.ref.WeakReference<android.content.Context> r10 = r1.k     // Catch:{ all -> 0x023f }
            java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x023f }
            android.content.Context r10 = (android.content.Context) r10     // Catch:{ all -> 0x023f }
            java.lang.String r13 = "mSmtInfo"
            if (r10 == 0) goto L_0x0160
            com.netcore.android.inbox.SMTAppInboxData r14 = new com.netcore.android.inbox.SMTAppInboxData     // Catch:{ all -> 0x023f }
            r14.<init>()     // Catch:{ all -> 0x023f }
            com.netcore.android.utility.g r15 = r1.f997b     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x015c
            com.netcore.android.utility.a r15 = r15.b()     // Catch:{ all -> 0x023f }
            java.lang.String r16 = ""
            if (r15 == 0) goto L_0x00ec
            com.netcore.android.utility.h r15 = r15.d()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x00ec
            java.lang.String r15 = r15.b()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r15 = r16
        L_0x00ee:
            r14.setAppId(r15)     // Catch:{ all -> 0x023f }
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartTechBaseURL r15 = r7.getSmartechURL()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x00fe
            java.lang.String r15 = r15.getInboxUrl()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x00fe
            goto L_0x0100
        L_0x00fe:
            r15 = r16
        L_0x0100:
            r14.setBase_url(r15)     // Catch:{ all -> 0x023f }
            com.netcore.android.utility.g r15 = r1.f997b     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x0158
            com.netcore.android.utility.d r15 = r15.c()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x0114
            java.lang.String r15 = r15.h()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x0114
            goto L_0x0116
        L_0x0114:
            r15 = r16
        L_0x0116:
            r14.setGuid(r15)     // Catch:{ all -> 0x023f }
            boolean r15 = r7.isAppInboxEnabled()     // Catch:{ all -> 0x023f }
            r14.setSMTAppInboxEnabled(r15)     // Catch:{ all -> 0x023f }
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechEventSettings r15 = r7.getSmartechEventSettings()     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x012b
            boolean r15 = r15.getAppinbox()     // Catch:{ all -> 0x023f }
            goto L_0x012c
        L_0x012b:
            r15 = 1
        L_0x012c:
            r14.setSMTAppInboxEventEnabled(r15)     // Catch:{ all -> 0x023f }
            r14.setBaseSDKInitialized(r4)     // Catch:{ all -> 0x023f }
            com.netcore.android.smartechbase.communication.SMTAppInboxInterface r15 = r1.j     // Catch:{ all -> 0x023f }
            if (r15 == 0) goto L_0x013c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ all -> 0x023f }
            r15.init(r10, r14)     // Catch:{ all -> 0x023f }
        L_0x013c:
            java.lang.String r10 = r1.f996a     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x023f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x023f }
            r14.<init>()     // Catch:{ all -> 0x023f }
            java.lang.String r15 = "SmartechAppInbox: "
            r14.append(r15)     // Catch:{ all -> 0x023f }
            com.netcore.android.smartechbase.communication.SMTAppInboxInterface r15 = r1.j     // Catch:{ all -> 0x023f }
            r14.append(r15)     // Catch:{ all -> 0x023f }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x023f }
            r2.i(r10, r14)     // Catch:{ all -> 0x023f }
            goto L_0x0160
        L_0x0158:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x015c:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x0160:
            com.netcore.android.c r10 = r1.f998c     // Catch:{ all -> 0x023f }
            if (r10 == 0) goto L_0x01e5
            r10.i()     // Catch:{ all -> 0x023f }
            java.lang.ref.WeakReference<android.content.Context> r10 = r1.k     // Catch:{ all -> 0x023f }
            java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x023f }
            android.content.Context r10 = (android.content.Context) r10     // Catch:{ all -> 0x023f }
            if (r10 == 0) goto L_0x020a
            boolean r11 = r5.isListAndSegmentPresent()     // Catch:{ all -> 0x023f }
            if (r11 == 0) goto L_0x017e
            r1.setInAppRuleListStatus$smartech_release(r3)     // Catch:{ all -> 0x023f }
            r17.a()     // Catch:{ all -> 0x023f }
            goto L_0x0181
        L_0x017e:
            r1.setInAppRuleListStatus$smartech_release(r4)     // Catch:{ all -> 0x023f }
        L_0x0181:
            com.netcore.android.network.models.SMTSdkInitializeResponse$SmartTechSettings$SmartechGeoFenceSettings r3 = r7.getSmartechGeoFenceSettings()     // Catch:{ all -> 0x023f }
            if (r3 == 0) goto L_0x01c2
            boolean r4 = r3.getGeoFenceEnabled()     // Catch:{ all -> 0x023f }
            if (r4 == 0) goto L_0x01a5
            com.netcore.android.geofence.f$a r0 = com.netcore.android.geofence.f.f1141f     // Catch:{ all -> 0x023f }
            java.lang.ref.WeakReference<android.content.Context> r2 = r1.k     // Catch:{ all -> 0x023f }
            com.netcore.android.geofence.f r0 = r0.b(r2)     // Catch:{ all -> 0x023f }
            boolean r2 = r3.getGeoFenceEnabled()     // Catch:{ all -> 0x023f }
            com.netcore.android.utility.g r3 = r1.f997b     // Catch:{ all -> 0x023f }
            if (r3 == 0) goto L_0x01a1
            r0.a(r2, r3)     // Catch:{ all -> 0x023f }
            goto L_0x01c2
        L_0x01a1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x01a5:
            java.lang.String r4 = r1.f996a     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ all -> 0x023f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x023f }
            r0.<init>()     // Catch:{ all -> 0x023f }
            java.lang.String r11 = "Geofence value: "
            r0.append(r11)     // Catch:{ all -> 0x023f }
            boolean r3 = r3.getGeoFenceEnabled()     // Catch:{ all -> 0x023f }
            r0.append(r3)     // Catch:{ all -> 0x023f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x023f }
            r2.i(r4, r0)     // Catch:{ all -> 0x023f }
        L_0x01c2:
            com.netcore.android.inapp.c$a r0 = com.netcore.android.inapp.c.g     // Catch:{ all -> 0x023f }
            com.netcore.android.inapp.c r0 = r0.b()     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ all -> 0x023f }
            r0.a(r5, r10)     // Catch:{ all -> 0x023f }
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.k     // Catch:{ all -> 0x023f }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x023f }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x023f }
            if (r0 == 0) goto L_0x020a
            com.netcore.android.d$a r2 = com.netcore.android.d.f1022f     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)     // Catch:{ all -> 0x023f }
            com.netcore.android.d r0 = r2.b(r0)     // Catch:{ all -> 0x023f }
            r0.g()     // Catch:{ all -> 0x023f }
            goto L_0x020a
        L_0x01e5:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x01e9:
            com.netcore.android.c r0 = r1.f998c     // Catch:{ all -> 0x023f }
            if (r0 == 0) goto L_0x0202
            r0.j()     // Catch:{ all -> 0x023f }
            com.netcore.android.e.b$a r0 = com.netcore.android.e.b.f1030c     // Catch:{ all -> 0x023f }
            java.lang.ref.WeakReference<android.content.Context> r2 = r1.k     // Catch:{ all -> 0x023f }
            com.netcore.android.e.b r0 = r0.b(r2)     // Catch:{ all -> 0x023f }
            com.netcore.android.e.h$a r2 = com.netcore.android.e.h.q     // Catch:{ all -> 0x023f }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x023f }
            r0.f(r2)     // Catch:{ all -> 0x023f }
            goto L_0x020a
        L_0x0202:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x0206:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch:{ all -> 0x023f }
            throw r9
        L_0x020a:
            if (r7 != 0) goto L_0x020f
            r17.a(r18)     // Catch:{ all -> 0x023f }
        L_0x020f:
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.k     // Catch:{ all -> 0x023f }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x023f }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x023f }
            if (r0 == 0) goto L_0x022b
            com.netcore.android.preference.SMTPreferenceHelper$Companion r2 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ all -> 0x023f }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)     // Catch:{ all -> 0x023f }
            com.netcore.android.preference.SMTPreferenceHelper r0 = r2.getAppPreferenceInstance(r0, r9)     // Catch:{ all -> 0x023f }
            java.lang.String r2 = "smt_sdk_init_timestamp"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x023f }
            r0.setLong(r2, r3)     // Catch:{ all -> 0x023f }
        L_0x022b:
            com.netcore.android.network.models.SMTRequest$SMTApiTypeID r0 = com.netcore.android.network.models.SMTRequest.SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH     // Catch:{ all -> 0x023f }
            int r0 = r0.getValue()     // Catch:{ all -> 0x023f }
            if (r6 == r0) goto L_0x0243
            r17.f()     // Catch:{ all -> 0x023f }
            goto L_0x0243
        L_0x0237:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x023f }
            java.lang.String r2 = "null cannot be cast to non-null type com.netcore.android.network.models.SMTSdkInitializeResponse"
            r0.<init>(r2)     // Catch:{ all -> 0x023f }
            throw r0     // Catch:{ all -> 0x023f }
        L_0x023f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0243:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.Smartech.b(com.netcore.android.network.models.SMTResponse):void");
    }

    private final void a(WeakReference<Context> weakReference) {
        Context context = (Context) weakReference.get();
        if (context != null) {
            SMTWorkerScheduler instance = SMTWorkerScheduler.Companion.getInstance();
            Intrinsics.checkNotNullExpressionValue(context, "it");
            instance.scheduleBackgroundSyncWorker(context);
        }
    }

    public /* synthetic */ Smartech(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    private final void a(SMTResponse sMTResponse) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f996a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "Smartech SDK not initialized successfully.");
        boolean z = false;
        l = false;
        m = false;
        int value = sMTResponse.getSmtApiTypeID().getValue();
        SMTPreferenceHelper sMTPreferenceHelper = n;
        if (sMTPreferenceHelper != null) {
            if (!sMTPreferenceHelper.getBoolean(SMTPreferenceConstants.IS_SMRATECH_SETTINGS_STORED)) {
                c cVar = this.f998c;
                if (cVar != null) {
                    cVar.a(new SmartTechSettings());
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                    throw null;
                }
            }
            try {
                SMTPreferenceHelper sMTPreferenceHelper2 = n;
                if (sMTPreferenceHelper2 != null) {
                    if (sMTPreferenceHelper2.getBoolean(SMTPreferenceConstants.IS_SDK_ACTIVE)) {
                        SMTPreferenceHelper sMTPreferenceHelper3 = n;
                        if (sMTPreferenceHelper3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                            throw null;
                        } else if (sMTPreferenceHelper3.getBoolean(SMTPreferenceConstants.IS_PANEL_ACTIVE)) {
                            z = true;
                        }
                    }
                    if (z) {
                        if (value != SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH.getValue()) {
                            c cVar2 = this.f998c;
                            if (cVar2 != null) {
                                cVar2.g();
                                f();
                                h();
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                                throw null;
                            }
                        }
                        Context context = (Context) this.k.get();
                        if (context != null) {
                            C0003a aVar = com.netcore.android.event.a.g;
                            Intrinsics.checkNotNullExpressionValue(context, "it");
                            aVar.b(context).d();
                        }
                    } else if (!z) {
                        c cVar3 = this.f998c;
                        if (cVar3 != null) {
                            cVar3.j();
                            com.netcore.android.e.b.f1030c.b(this.k).f(com.netcore.android.e.h.q.a());
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("mSmartechHelper");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPreferences");
            throw null;
        }
    }

    private final void a(boolean z) {
        try {
            SMTThreadPoolManager.INSTANCE.getIntance().execute(new b(this, z));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final HanselInterface b() {
        try {
            Object newInstance = Class.forName("io.hansel.smartech.HanselNetcoreAdapter").newInstance();
            if (newInstance != null) {
                HanselInterface hanselInterface = (HanselInterface) newInstance;
                this.h = hanselInterface;
                return hanselInterface;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.smartechbase.communication.HanselInterface");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
