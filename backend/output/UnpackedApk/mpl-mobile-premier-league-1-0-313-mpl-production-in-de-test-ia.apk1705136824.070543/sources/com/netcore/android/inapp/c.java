package com.netcore.android.inapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.Smartech;
import com.netcore.android.event.SMTEventId;
import com.netcore.android.event.SMTEventType;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTThreadPoolManager;
import com.netcore.android.network.models.SMTSdkInitializeResponse;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.utility.SMTCommonUtility;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SMTInAppHandler.kt */
public final class c implements e {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f1188f;
    public static final a g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1189a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f1190b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1191c;

    /* renamed from: d  reason: collision with root package name */
    public com.netcore.android.inapp.h.b f1192d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f1193e;

    /* compiled from: SMTInAppHandler.kt */
    public static final class a {
        public a() {
        }

        private final c a() {
            return new c(null);
        }

        public final synchronized c b() {
            c a2;
            c a3;
            a2 = c.f1188f;
            if (a2 == null) {
                synchronized (c.class) {
                    a3 = c.f1188f;
                    if (a3 == null) {
                        a3 = c.g.a();
                        c.f1188f = a3;
                    }
                }
                a2 = a3;
            }
            return a2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Runnable.kt */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1195b;

        public b(c cVar, com.netcore.android.inapp.h.b bVar) {
            this.f1194a = cVar;
            this.f1195b = bVar;
        }

        public final void run() {
            this.f1194a.d(this.f1195b);
        }
    }

    /* renamed from: com.netcore.android.inapp.c$c  reason: collision with other inner class name */
    /* compiled from: Runnable.kt */
    public static final class C0010c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1196a;

        public C0010c(c cVar) {
            this.f1196a = cVar;
        }

        public final void run() {
            PopupWindow a2 = this.f1196a.f1190b;
            if (a2 != null) {
                a2.dismiss();
            }
        }
    }

    /* compiled from: SMTInAppHandler.kt */
    public static final class d implements com.netcore.android.utility.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1197a;

        /* compiled from: SMTInAppHandler.kt */
        public static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f1198a;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public a(d dVar, com.netcore.android.inapp.h.b bVar, Bitmap bitmap) {
                // this.f1198a = dVar;
                super(0);
            }

            public final void a() {
                PopupWindow a2 = this.f1198a.f1197a.f1190b;
                if (a2 != null) {
                    a2.dismiss();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public d(c cVar) {
            this.f1197a = cVar;
        }

        public void a(com.netcore.android.inapp.h.b bVar, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bVar, "identifiedRule");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Activity a2 = g.f1213b.a();
            if (a2 != null) {
                this.f1197a.a(bVar, com.netcore.android.utility.f.f1289b.a(a2, bVar, bitmap, (Function0<Unit>) new a<Unit>(this, bVar, bitmap)));
            }
        }
    }

    /* compiled from: Runnable.kt */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1200b;

        public e(c cVar, com.netcore.android.inapp.h.b bVar) {
            this.f1199a = cVar;
            this.f1200b = bVar;
        }

        public final void run() {
            this.f1199a.d(this.f1200b);
        }
    }

    /* compiled from: SMTInAppHandler.kt */
    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f1202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1203c;

        public f(c cVar, Context context, com.netcore.android.inapp.h.b bVar) {
            this.f1201a = cVar;
            this.f1202b = context;
            this.f1203c = bVar;
        }

        public final void run() {
            this.f1201a.a(this.f1202b, this.f1203c);
        }
    }

    /* compiled from: SMTInAppHandler.kt */
    public static final class g implements OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1205b;

        public g(c cVar, com.netcore.android.inapp.h.b bVar) {
            this.f1204a = cVar;
            this.f1205b = bVar;
        }

        public final void onDismiss() {
            this.f1204a.f1193e = null;
            this.f1204a.f1192d = null;
            if (this.f1204a.f1191c) {
                com.netcore.android.inapp.e.a.a(this.f1204a, 43, this.f1205b, null, 4, null);
            }
        }
    }

    public c() {
        this.f1189a = c.class.getSimpleName();
        this.f1191c = true;
    }

    private final void e() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1189a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "In-app messages frequency capping limit has been exhausted.");
    }

    public final boolean d() {
        Activity a2 = g.f1213b.a();
        if (a2 == null) {
            return false;
        }
        Companion companion = SMTPreferenceHelper.Companion;
        Context applicationContext = a2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
        return companion.getAppPreferenceInstance(applicationContext, null).getBoolean(SMTPreferenceConstants.OPT_IN_OUT_IN_APP_MESSAGES, true);
    }

    private final boolean c(com.netcore.android.inapp.h.b bVar) {
        boolean z = false;
        if (!(bVar.e().length() > 0) || Integer.parseInt(bVar.e()) == 0) {
            return true;
        }
        if (bVar.a() < Integer.parseInt(bVar.e())) {
            z = true;
        }
        return z;
    }

    private final void e(com.netcore.android.inapp.h.b bVar) {
        com.netcore.android.inapp.g.a aVar = g.f1213b;
        if (aVar.a() != null) {
            com.netcore.android.e.b.a aVar2 = com.netcore.android.e.b.f1030c;
            Activity a2 = aVar.a();
            Intrinsics.checkNotNull(a2);
            aVar2.b(new WeakReference(a2.getApplicationContext())).a(bVar, aVar.b());
        }
    }

    private final void b(Context context, com.netcore.android.inapp.h.b bVar) {
        try {
            long j = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getLong(SMTPreferenceConstants.SMT_INAPP_WAIT_TIME);
            if (j > 0) {
                SMTThreadPoolManager.INSTANCE.getIntance().schedule(new f(this, context, bVar), j, TimeUnit.MILLISECONDS);
                return;
            }
            Activity a2 = g.f1213b.a();
            if (a2 != null) {
                a2.runOnUiThread(new e(this, bVar));
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1189a;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
    }

    /* access modifiers changed from: private */
    public final void d(com.netcore.android.inapp.h.b bVar) {
        if (c()) {
            e();
            return;
        }
        PopupWindow popupWindow = this.f1190b;
        if (popupWindow != null && popupWindow.isShowing()) {
            PopupWindow popupWindow2 = this.f1190b;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
        }
        if (bVar.n().d()) {
            com.netcore.android.utility.f.f1289b.a(bVar, this.f1190b, (com.netcore.android.utility.f.a) new d(this));
        } else {
            WebView b2 = b(bVar);
            if (b2 != null) {
                Activity a2 = g.f1213b.a();
                if (a2 != null) {
                    if (SMTCommonUtility.INSTANCE.isNetworkAvailable(a2)) {
                        a(bVar, (View) b2);
                    } else {
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str = this.f1189a;
                        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                        sMTLogger.i(str, "Network connection is not available.");
                    }
                }
            }
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final boolean c() {
        boolean z;
        int i;
        String str;
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            Companion companion = SMTPreferenceHelper.Companion;
            SMTPreferenceHelper appPreferenceInstance = companion.getAppPreferenceInstance(a2, null);
            SMTPreferenceConstants sMTPreferenceConstants = SMTPreferenceConstants.INSTANCE;
            int i2 = appPreferenceInstance.getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_ENABLE(), 0);
            int i3 = appPreferenceInstance.getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_DAY_LIMIT(), 0);
            int i4 = appPreferenceInstance.getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_WEEK_LIMIT(), 0);
            int i5 = appPreferenceInstance.getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_MONTH_LIMIT(), 0);
            if (i2 > 0) {
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "lastFreqCalendar");
                instance.setTimeInMillis(companion.getAppPreferenceInstance(a2, null).getLong(sMTPreferenceConstants.getSMT_FC_IN_APP_LAST_MILLIS(), 0));
                Intrinsics.checkNotNullExpressionValue(instance2, "todayCalendar");
                instance2.setFirstDayOfWeek(1);
                instance.setFirstDayOfWeek(1);
                int i6 = companion.getAppPreferenceInstance(a2, null).getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_DAY_COUNT(), 0);
                int i7 = companion.getAppPreferenceInstance(a2, null).getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_WEEK_COUNT(), 0);
                int i8 = companion.getAppPreferenceInstance(a2, null).getInt(sMTPreferenceConstants.getSMT_FC_IN_APP_MONTH_COUNT(), 0);
                if (instance2.get(6) > instance.get(6)) {
                    i6 = 0;
                    z = true;
                } else {
                    z = false;
                }
                if (instance2.get(2) == instance.get(2) && instance2.get(4) > instance.get(4)) {
                    i7 = 0;
                    z = true;
                }
                if (instance2.get(2) > instance.get(2)) {
                    i7 = 0;
                    i8 = 0;
                    z = true;
                }
                if (z) {
                    instance = instance2;
                }
                if ((i8 >= i5 && i5 != 0) || ((i7 >= i4 && i4 != 0) || (i6 >= i3 && i3 != 0))) {
                    return true;
                }
                int i9 = i5 == 0 ? 0 : i8 + 1;
                int i10 = i4 == 0 ? 0 : i7 + 1;
                if (i3 == 0) {
                    str = null;
                    i = 0;
                } else {
                    i = i6 + 1;
                    str = null;
                }
                companion.getAppPreferenceInstance(a2, str).setInt(sMTPreferenceConstants.getSMT_FC_IN_APP_DAY_COUNT(), i);
                companion.getAppPreferenceInstance(a2, str).setInt(sMTPreferenceConstants.getSMT_FC_IN_APP_WEEK_COUNT(), i10);
                companion.getAppPreferenceInstance(a2, str).setInt(sMTPreferenceConstants.getSMT_FC_IN_APP_MONTH_COUNT(), i9);
                companion.getAppPreferenceInstance(a2, str).setLong(sMTPreferenceConstants.getSMT_FC_IN_APP_LAST_MILLIS(), instance.getTimeInMillis());
            }
        }
        return false;
    }

    public final void a(HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "payloadMap");
        if (d()) {
            com.netcore.android.inapp.g.a aVar = g.f1213b;
            if (aVar.c()) {
                Activity a2 = aVar.a();
                if (a2 != null) {
                    Intrinsics.checkNotNull(a2);
                    com.netcore.android.inapp.h.b a3 = a((Context) a2, a(hashMap, a2), hashMap);
                    if (a3 != null) {
                        b((Context) a2, a3);
                    }
                }
            } else {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1189a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.e(str, "Application isn't in foreground so rejecting the InAPP request");
            }
        }
    }

    public final void b() {
        PopupWindow popupWindow = this.f1190b;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.f1190b = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final WebView b(com.netcore.android.inapp.h.b bVar) {
        Activity a2 = g.f1213b.a();
        if (a2 == null) {
            return null;
        }
        WebView webView = new WebView(a2);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "wv.settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings2, "wv.settings");
        settings2.setDomStorageEnabled(true);
        WebSettings settings3 = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings3, "wv.settings");
        settings3.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setBackgroundColor(0);
        a(webView, bVar);
        webView.loadUrl(a(bVar, a2));
        return webView;
    }

    public final List<com.netcore.android.inapp.h.b> a(HashMap<String, Object> hashMap, Activity activity) {
        Intrinsics.checkNotNullParameter(hashMap, "eventPayLoad");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return com.netcore.android.e.b.f1030c.b(new WeakReference(activity.getApplicationContext())).a(hashMap);
    }

    private final com.netcore.android.inapp.h.b a(Context context, List<com.netcore.android.inapp.h.b> list, HashMap<String, Object> hashMap) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ListIterator<com.netcore.android.inapp.h.b> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            com.netcore.android.inapp.h.b next = listIterator.next();
            com.netcore.android.inapp.g.a aVar = g.f1213b;
            if (aVar.a(next)) {
                boolean z = true;
                if (!(aVar.a(next.p().b().d(), next.p().b().c(), hashMap) && a(next))) {
                    continue;
                } else {
                    if (!aVar.a(next, a(context, (String) "listIds"), a(context, (String) "segIds")) || !aVar.a(context, next)) {
                        z = false;
                    }
                    if (z) {
                        if (next.b() > 0) {
                            Companion companion = SMTPreferenceHelper.Companion;
                            companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_MID, next.i());
                            companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RANDOM, String.valueOf(next.l()));
                            companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RULE, String.valueOf(next.b()));
                            if (aVar.b(next)) {
                                companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG, "1");
                                e(next);
                                com.netcore.android.inapp.e.a.a(this, 41, next, null, 4, null);
                                return null;
                            }
                            companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG, "0");
                        } else if (next.b() == 0) {
                            Companion companion2 = SMTPreferenceHelper.Companion;
                            companion2.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_MID, next.i());
                            companion2.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RANDOM, String.valueOf(next.l()));
                            companion2.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RULE, String.valueOf(next.b()));
                            companion2.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG, "0");
                        } else {
                            a(context);
                        }
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.netcore.android.e.b.f1030c.b(new WeakReference(context.getApplicationContext())).b();
        a(context);
    }

    private final boolean a(com.netcore.android.inapp.h.b bVar) {
        String f2 = bVar.f();
        int hashCode = f2.hashCode();
        boolean z = true;
        if (hashCode != -139919088) {
            if (hashCode != 99228) {
                if (hashCode == 1984987798 && f2.equals("session")) {
                    if (g.f1213b.b(bVar, new Date())) {
                        z = c(bVar);
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str = this.f1189a;
                        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                        sMTLogger.i(str, "InApp 2: " + z);
                        return z;
                    }
                    z = false;
                    SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                    String str2 = this.f1189a;
                    Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                    sMTLogger2.i(str2, "InApp 2: " + z);
                    return z;
                }
            } else if (f2.equals("day")) {
                com.netcore.android.inapp.g.a aVar = g.f1213b;
                if (aVar.a(bVar, new Date())) {
                    if (bVar.g() == aVar.b()) {
                        z = c(bVar);
                    }
                    SMTLogger sMTLogger22 = SMTLogger.INSTANCE;
                    String str22 = this.f1189a;
                    Intrinsics.checkNotNullExpressionValue(str22, UeCustomType.TAG);
                    sMTLogger22.i(str22, "InApp 2: " + z);
                    return z;
                }
                z = false;
                SMTLogger sMTLogger222 = SMTLogger.INSTANCE;
                String str222 = this.f1189a;
                Intrinsics.checkNotNullExpressionValue(str222, UeCustomType.TAG);
                sMTLogger222.i(str222, "InApp 2: " + z);
                return z;
            }
        } else if (f2.equals("campaign")) {
            if (g.f1213b.b(bVar, new Date())) {
                z = c(bVar);
                SMTLogger sMTLogger2222 = SMTLogger.INSTANCE;
                String str2222 = this.f1189a;
                Intrinsics.checkNotNullExpressionValue(str2222, UeCustomType.TAG);
                sMTLogger2222.i(str2222, "InApp 2: " + z);
                return z;
            }
            z = false;
            SMTLogger sMTLogger22222 = SMTLogger.INSTANCE;
            String str22222 = this.f1189a;
            Intrinsics.checkNotNullExpressionValue(str22222, UeCustomType.TAG);
            sMTLogger22222.i(str22222, "InApp 2: " + z);
            return z;
        }
        com.netcore.android.inapp.g.a aVar2 = g.f1213b;
        if (aVar2.a(bVar, new Date())) {
            boolean b2 = aVar2.b(bVar, new Date());
            if (b2) {
                z = c(bVar);
                SMTLogger sMTLogger222222 = SMTLogger.INSTANCE;
                String str222222 = this.f1189a;
                Intrinsics.checkNotNullExpressionValue(str222222, UeCustomType.TAG);
                sMTLogger222222.i(str222222, "InApp 2: " + z);
                return z;
            } else if (b2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        z = false;
        SMTLogger sMTLogger2222222 = SMTLogger.INSTANCE;
        String str2222222 = this.f1189a;
        Intrinsics.checkNotNullExpressionValue(str2222222, UeCustomType.TAG);
        sMTLogger2222222.i(str2222222, "InApp 2: " + z);
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        if (r4.isEmpty() == false) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082 A[Catch:{ Exception -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e A[Catch:{ Exception -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10, com.netcore.android.inapp.h.b r11) {
        /*
            r9 = this;
            java.lang.String r0 = "smt_inapp_me_pos"
            com.netcore.android.preference.SMTPreferenceHelper$Companion r1 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ Exception -> 0x00af }
            r2 = 0
            com.netcore.android.preference.SMTPreferenceHelper r3 = r1.getAppPreferenceInstance(r10, r2)     // Catch:{ Exception -> 0x00af }
            int r3 = r3.getInt(r0)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.inapp.h.b$h r4 = r11.q()     // Catch:{ Exception -> 0x00af }
            com.netcore.android.inapp.h.b$a r4 = r4.a()     // Catch:{ Exception -> 0x00af }
            java.util.ArrayList r4 = r4.a()     // Catch:{ Exception -> 0x00af }
            r5 = 0
            if (r3 < 0) goto L_0x0088
            int r6 = r4.size()     // Catch:{ Exception -> 0x00af }
            if (r6 <= 0) goto L_0x0088
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "multiEventsRules[pos]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.inapp.h.b$c r3 = (com.netcore.android.inapp.h.b.c) r3     // Catch:{ Exception -> 0x00af }
            com.netcore.android.event.c r4 = com.netcore.android.event.c.f1074a     // Catch:{ Exception -> 0x00af }
            java.util.HashMap r4 = r4.a(r3)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.e.b$a r6 = com.netcore.android.e.b.f1030c     // Catch:{ Exception -> 0x00af }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00af }
            android.content.Context r8 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00af }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.e.b r6 = r6.b(r7)     // Catch:{ Exception -> 0x00af }
            java.util.List r4 = r6.b(r4)     // Catch:{ Exception -> 0x00af }
            java.util.ArrayList r6 = r3.d()     // Catch:{ Exception -> 0x00af }
            if (r4 == 0) goto L_0x0055
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x00af }
            if (r7 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r7 = 0
            goto L_0x0056
        L_0x0055:
            r7 = 1
        L_0x0056:
            if (r7 != 0) goto L_0x0080
            int r7 = r6.size()     // Catch:{ Exception -> 0x00af }
            if (r7 <= 0) goto L_0x0080
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.inapp.h.a r4 = (com.netcore.android.inapp.h.a) r4     // Catch:{ Exception -> 0x00af }
            com.netcore.android.inapp.g$a r5 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x00af }
            java.lang.String r3 = r3.c()     // Catch:{ Exception -> 0x00af }
            com.netcore.android.utility.SMTCommonUtility r7 = com.netcore.android.utility.SMTCommonUtility.INSTANCE     // Catch:{ Exception -> 0x00af }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x00af }
            r8.<init>(r4)     // Catch:{ Exception -> 0x00af }
            java.util.HashMap r4 = r7.jsonToHashMap(r8)     // Catch:{ Exception -> 0x00af }
            boolean r3 = r5.a(r6, r3, r4)     // Catch:{ Exception -> 0x00af }
            r5 = r3 ^ 1
            goto L_0x0089
        L_0x0080:
            if (r4 == 0) goto L_0x0088
            boolean r3 = r4.isEmpty()     // Catch:{ Exception -> 0x00af }
            if (r3 == 0) goto L_0x0089
        L_0x0088:
            r5 = 1
        L_0x0089:
            com.netcore.android.preference.SMTPreferenceHelper r3 = r1.getAppPreferenceInstance(r10, r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "smt_inapp_wait_time"
            r6 = 0
            r3.setLong(r4, r6)     // Catch:{ Exception -> 0x00af }
            com.netcore.android.preference.SMTPreferenceHelper r10 = r1.getAppPreferenceInstance(r10, r2)     // Catch:{ Exception -> 0x00af }
            r1 = -1
            r10.setInt(r0, r1)     // Catch:{ Exception -> 0x00af }
            if (r5 == 0) goto L_0x00b9
            com.netcore.android.inapp.g$a r10 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x00af }
            android.app.Activity r10 = r10.a()     // Catch:{ Exception -> 0x00af }
            if (r10 == 0) goto L_0x00b9
            com.netcore.android.inapp.c$b r0 = new com.netcore.android.inapp.c$b     // Catch:{ Exception -> 0x00af }
            r0.<init>(r9, r11)     // Catch:{ Exception -> 0x00af }
            r10.runOnUiThread(r0)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b9
        L_0x00af:
            r10 = move-exception
            com.netcore.android.logger.SMTLogger r11 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r0 = r9.f1189a
            java.lang.String r1 = "TAG"
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r0, r1, r10, r11, r0)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.inapp.c.a(android.content.Context, com.netcore.android.inapp.h.b):void");
    }

    /* access modifiers changed from: private */
    public final void a(com.netcore.android.inapp.h.b bVar, View view) {
        PopupWindow popupWindow = this.f1190b;
        if (popupWindow != null && popupWindow.isShowing()) {
            PopupWindow popupWindow2 = this.f1190b;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
        }
        com.netcore.android.inapp.g.a aVar = g.f1213b;
        if (aVar.a() != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Activity a2 = aVar.a();
            WindowManager windowManager = a2 != null ? a2.getWindowManager() : null;
            Intrinsics.checkNotNull(windowManager);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            View rootView = view instanceof WebView ? view : view.getRootView();
            try {
                int parseInt = Integer.parseInt(bVar.p().a());
                int i3 = -1;
                if (parseInt == com.netcore.android.inapp.b.c.FULL_SCREEN.getValue()) {
                    PopupWindow popupWindow3 = new PopupWindow(view, -1, -1, true);
                    this.f1190b = popupWindow3;
                    Intrinsics.checkNotNull(popupWindow3);
                    popupWindow3.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow4 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow4);
                    popupWindow4.showAtLocation(rootView, 17, 0, 0);
                } else if (parseInt == com.netcore.android.inapp.b.c.INTERSTITIAL.getValue()) {
                    PopupWindow popupWindow5 = new PopupWindow(view, i2 - (i2 / 10), i - (i / 10), true);
                    this.f1190b = popupWindow5;
                    Intrinsics.checkNotNull(popupWindow5);
                    popupWindow5.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow6 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow6);
                    popupWindow6.showAtLocation(rootView, 17, 0, 0);
                } else if (parseInt == com.netcore.android.inapp.b.c.HALF_INTERSTIAL.getValue()) {
                    if (i >= i2) {
                        i = i2;
                    }
                    PopupWindow popupWindow7 = new PopupWindow(view, i - (i / 10), i - (i / 10), true);
                    this.f1190b = popupWindow7;
                    Intrinsics.checkNotNull(popupWindow7);
                    popupWindow7.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow8 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow8);
                    popupWindow8.showAtLocation(rootView, 17, 0, 0);
                } else if (parseInt == com.netcore.android.inapp.b.c.STICKY_HEADER.getValue()) {
                    if (i < i2) {
                        int i4 = i * 2;
                        if (i4 < i2) {
                            i3 = i4;
                            PopupWindow popupWindow9 = new PopupWindow(view, i3, i, true);
                            this.f1190b = popupWindow9;
                            Intrinsics.checkNotNull(popupWindow9);
                            popupWindow9.setBackgroundDrawable(new ColorDrawable(0));
                            PopupWindow popupWindow10 = this.f1190b;
                            Intrinsics.checkNotNull(popupWindow10);
                            popupWindow10.showAtLocation(rootView, 48, 0, 0);
                        }
                    }
                    i = i2 / 2;
                    PopupWindow popupWindow92 = new PopupWindow(view, i3, i, true);
                    this.f1190b = popupWindow92;
                    Intrinsics.checkNotNull(popupWindow92);
                    popupWindow92.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow102 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow102);
                    popupWindow102.showAtLocation(rootView, 48, 0, 0);
                } else if (parseInt == com.netcore.android.inapp.b.c.STICKY_FOOTER.getValue()) {
                    if (i < i2) {
                        int i5 = i * 2;
                        if (i5 < i2) {
                            i3 = i5;
                            PopupWindow popupWindow11 = new PopupWindow(view, i3, i, true);
                            this.f1190b = popupWindow11;
                            Intrinsics.checkNotNull(popupWindow11);
                            popupWindow11.setBackgroundDrawable(new ColorDrawable(0));
                            PopupWindow popupWindow12 = this.f1190b;
                            Intrinsics.checkNotNull(popupWindow12);
                            popupWindow12.showAtLocation(rootView, 80, 0, 0);
                        }
                    }
                    i = i2 / 2;
                    PopupWindow popupWindow112 = new PopupWindow(view, i3, i, true);
                    this.f1190b = popupWindow112;
                    Intrinsics.checkNotNull(popupWindow112);
                    popupWindow112.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow122 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow122);
                    popupWindow122.showAtLocation(rootView, 80, 0, 0);
                } else {
                    PopupWindow popupWindow13 = new PopupWindow(view, -1, i / 5, true);
                    this.f1190b = popupWindow13;
                    Intrinsics.checkNotNull(popupWindow13);
                    popupWindow13.setBackgroundDrawable(new ColorDrawable(0));
                    PopupWindow popupWindow14 = this.f1190b;
                    Intrinsics.checkNotNull(popupWindow14);
                    popupWindow14.showAtLocation(rootView, 80, 0, 0);
                }
                PopupWindow popupWindow15 = this.f1190b;
                Intrinsics.checkNotNull(popupWindow15);
                popupWindow15.setOnDismissListener(new g(this, bVar));
                PopupWindow popupWindow16 = this.f1190b;
                Intrinsics.checkNotNull(popupWindow16);
                a(popupWindow16, 0.2f);
                e(bVar);
                com.netcore.android.inapp.e.a.a(this, 41, bVar, null, 4, null);
            } catch (Exception unused) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1189a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.e(str, "InApp display issue.");
            }
        }
    }

    public void a(int i, com.netcore.android.inapp.h.b bVar, String str) {
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SMTEventParamKeys.SMT_MID, bVar.i());
            if (i != 41) {
                if (i == 42) {
                    Intrinsics.checkNotNull(str);
                    hashMap.put(SMTEventParamKeys.SMT_IN_APP_CLICK_LINK, str);
                }
            } else if (bVar.b() >= 0) {
                String string = SMTPreferenceHelper.Companion.getAppPreferenceInstance(a2, null).getString(SMTPreferenceConstants.SMT_CG, "");
                int i2 = 1;
                if (string.length() > 0) {
                    hashMap.put(SMTEventParamKeys.SMT_CG, string);
                }
                if (bVar.a() <= 0) {
                    i2 = 0;
                }
                hashMap.put(SMTEventParamKeys.SMT_CG_REPEAT, Integer.valueOf(i2));
                hashMap.put(SMTEventParamKeys.SMT_CG_CONTROL_GROUP, Integer.valueOf(bVar.b()));
                hashMap.put(SMTEventParamKeys.SMT_CG_RANDOM_NO, Integer.valueOf(bVar.l()));
            }
            com.netcore.android.event.e.a aVar = com.netcore.android.event.e.f1081f;
            Context applicationContext = a2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            com.netcore.android.event.e.a(aVar.b(applicationContext), i, SMTEventId.Companion.getEventName(i), hashMap, SMTEventType.EVENT_TYPE_SYSTEM_IN_APP, false, 16, null);
        }
    }

    private final void a(WebView webView, com.netcore.android.inapp.h.b bVar) {
        com.netcore.android.inapp.g.a aVar = g.f1213b;
        if (aVar.a() != null) {
            Activity a2 = aVar.a();
            if (a2 != null) {
                Smartech.Companion companion = Smartech.Companion;
                Activity a3 = aVar.a();
                Intrinsics.checkNotNull(a3);
                webView.addJavascriptInterface(new d(a2, bVar, this, companion.getInstance(new WeakReference(a3.getApplicationContext())).getInAppCustomHTMLListener()), "jse");
            }
        }
    }

    public void a(boolean z) {
        this.f1191c = z;
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            a2.runOnUiThread(new C0010c(this));
        }
    }

    private final String a(com.netcore.android.inapp.h.b bVar, Activity activity) {
        boolean a2 = a(bVar.n().c());
        if (a2) {
            return bVar.n().c();
        }
        if (!a2) {
            StringBuilder sb = new StringBuilder();
            Companion companion = SMTPreferenceHelper.Companion;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            sb.append(companion.getAppPreferenceInstance(applicationContext, null).getString(SMTPreferenceConstants.SMT_BASE_URL_INAPP));
            sb.append("inapp?");
            sb.append(bVar.n().c());
            return sb.toString();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean a(String str) {
        try {
            new URL(str).toURI();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(SMTSdkInitializeResponse sMTSdkInitializeResponse, Context context) {
        Intrinsics.checkNotNullParameter(sMTSdkInitializeResponse, "initSdkResponse");
        Intrinsics.checkNotNullParameter(context, "context");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1189a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.d(str, "Processing inapp rules");
        if (sMTSdkInitializeResponse.getInAppRules() != null) {
            ArrayList<com.netcore.android.inapp.h.b> inAppRules = sMTSdkInitializeResponse.getInAppRules();
            Intrinsics.checkNotNull(inAppRules);
            if (inAppRules.size() > 0) {
                ArrayList<com.netcore.android.inapp.h.b> inAppRules2 = sMTSdkInitializeResponse.getInAppRules();
                Intrinsics.checkNotNull(inAppRules2);
                String a2 = a(inAppRules2);
                com.netcore.android.e.b.a aVar = com.netcore.android.e.b.f1030c;
                aVar.b(new WeakReference(context.getApplicationContext())).c(a2);
                com.netcore.android.e.b b2 = aVar.b(new WeakReference(context.getApplicationContext()));
                ArrayList<com.netcore.android.inapp.h.b> inAppRules3 = sMTSdkInitializeResponse.getInAppRules();
                Intrinsics.checkNotNull(inAppRules3);
                b2.a(inAppRules3);
                a(sMTSdkInitializeResponse.getInAppRules(), context);
                com.netcore.android.utility.f.f1289b.a(sMTSdkInitializeResponse.getInAppRules());
            }
        }
        com.netcore.android.e.b.f1030c.b(new WeakReference(context.getApplicationContext())).c((String) null);
        com.netcore.android.utility.f.f1289b.a(sMTSdkInitializeResponse.getInAppRules());
    }

    private final void a(ArrayList<com.netcore.android.inapp.h.b> arrayList, Context context) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            for (com.netcore.android.inapp.h.b bVar : arrayList) {
                if (!hashMap.containsKey(bVar.i())) {
                    String i = bVar.i();
                    String j = bVar.j();
                    Intrinsics.checkNotNull(j);
                    hashMap.put(i, j);
                }
            }
        }
        Set<String> keySet = hashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "distinctInAppRules.keys");
        for (String str : keySet) {
            com.netcore.android.e.b.f1030c.b(new WeakReference(context.getApplicationContext())).a(str, (String) hashMap.get(str));
        }
    }

    public final String a(ArrayList<com.netcore.android.inapp.h.b> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "inAppRules");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator<com.netcore.android.inapp.h.b> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            com.netcore.android.inapp.h.b next = it.next();
            if (z) {
                z = false;
                sb.append("'");
                sb.append(next.i());
                sb.append("'");
            } else {
                sb.append(", '");
                sb.append(next.i());
                sb.append("'");
            }
        }
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "inQuery.toString()");
        return sb2;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = SMTPreferenceHelper.Companion;
        companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_MID, "");
        companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG, "");
        companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RANDOM, "");
        companion.getAppPreferenceInstance(context, null).setString(SMTPreferenceConstants.SMT_CG_RULE, "");
    }

    private final void a(PopupWindow popupWindow, float f2) {
        View view;
        if (popupWindow.getBackground() == null) {
            if (VERSION.SDK_INT >= 23) {
                View contentView = popupWindow.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "popupWindow.contentView");
                ViewParent parent = contentView.getParent();
                if (parent != null) {
                    view = (View) parent;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
            } else {
                view = popupWindow.getContentView();
            }
            Intrinsics.checkNotNullExpressionValue(view, "if (Build.VERSION.SDK_IN…contentView\n            }");
        } else if (VERSION.SDK_INT >= 23) {
            View contentView2 = popupWindow.getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView2, "popupWindow.contentView");
            ViewParent parent2 = contentView2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent2, "popupWindow.contentView.parent");
            ViewParent parent3 = parent2.getParent();
            if (parent3 != null) {
                view = (View) parent3;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        } else {
            View contentView3 = popupWindow.getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView3, "popupWindow.contentView");
            ViewParent parent4 = contentView3.getParent();
            if (parent4 != null) {
                view = (View) parent4;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        View contentView4 = popupWindow.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView4, "popupWindow.contentView");
        Object systemService = contentView4.getContext().getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                layoutParams2.flags |= 2;
                layoutParams2.dimAmount = f2;
                windowManager.updateViewLayout(view, layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final List<String> a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "key");
        String string = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_LIST_SEGMENT_DATA, "");
        ArrayList arrayList = new ArrayList();
        if (string == null) {
            return arrayList;
        }
        try {
            if (!(!Intrinsics.areEqual(string, ""))) {
                return arrayList;
            }
            return SMTCommonUtility.INSTANCE.jsonArrayToStringList(new JSONObject(string).optJSONObject("data").optJSONArray(str));
        } catch (JSONException e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.f1189a;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.e(str2, String.valueOf(e2.getMessage()));
            return arrayList;
        }
    }
}
