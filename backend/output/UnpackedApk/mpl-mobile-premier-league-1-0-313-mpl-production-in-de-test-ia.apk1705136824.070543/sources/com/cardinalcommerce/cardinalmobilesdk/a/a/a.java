package com.cardinalcommerce.cardinalmobilesdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.CountDownTimer;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.ThreeDSecure$4;
import com.braintreepayments.api.ThreeDSecureActivity;
import com.cardinalcommerce.cardinalmobilesdk.a.b.b;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver;
import com.cardinalcommerce.shared.cs.utils.CCInitProvider;
import com.cardinalcommerce.shared.cs.utils.g;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;

public class a implements b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static a f1843a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f1844b;

    /* renamed from: d  reason: collision with root package name */
    public static CountDownTimer f1845d;

    /* renamed from: e  reason: collision with root package name */
    public static String f1846e;

    /* renamed from: f  reason: collision with root package name */
    public static d f1847f;
    public static com.cardinalcommerce.cardinalmobilesdk.a.d.b k;
    public static boolean p;
    public static final Object q = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Activity f1848c;
    public CardinalInitService g;
    public CardinalValidateReceiver h;
    public String i;
    public f j;
    public CardinalConfigurationParameters m;
    public Context n;
    public boolean o = true;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1843a == null) {
                synchronized (q) {
                    if (f1843a == null) {
                        f1843a = new a();
                        f1847f = d.New;
                        k = com.cardinalcommerce.cardinalmobilesdk.a.d.b.a();
                    }
                }
            }
            aVar = f1843a;
        }
        return aVar;
    }

    public final String a(Context context) {
        long j2;
        g a2 = g.a(context);
        String b2 = a2.b((String) "SDKAppID", (String) null);
        long b3 = a2.b((String) "LastUpdatedTime", 0);
        try {
            j2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (NameNotFoundException unused) {
            k.a(new c(10220), null);
            j2 = 0;
        }
        if (b2 != null && b3 != 0 && b3 == j2) {
            return b2;
        }
        String uuid = UUID.randomUUID().toString();
        a2.a("SDKAppID", uuid);
        a2.a("LastUpdatedTime", Long.toString(j2));
        return uuid;
    }

    public void b(c cVar) {
        if (this.m.j) {
            this.o = true;
            k.a(cVar, this.j.h);
            CardinalActionCode cardinalActionCode = CardinalActionCode.ERROR;
            k.a(this.m.g.toString());
            com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r4 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) this.g;
            ThreeDSecure$4 threeDSecure$4 = ThreeDSecure$4.this;
            k.access$000(threeDSecure$4.val$fragment, threeDSecure$4.val$request, threeDSecure$4.val$lookupListener);
            ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
        }
    }

    public final void c(c cVar) {
        if (this.g != null) {
            CardinalActionCode cardinalActionCode = CardinalActionCode.ERROR;
            CardinalConfigurationParameters cardinalConfigurationParameters = this.m;
            if (cardinalConfigurationParameters != null) {
                k.a(cardinalConfigurationParameters.g.toString());
            } else {
                k.a("CardinalInit", "ConfigParameters are null", null);
            }
            com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r4 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) this.g;
            ThreeDSecure$4 threeDSecure$4 = ThreeDSecure$4.this;
            k.access$000(threeDSecure$4.val$fragment, threeDSecure$4.val$request, threeDSecure$4.val$lookupListener);
            ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
        }
    }

    public String e() {
        return a(CCInitProvider.f2212a);
    }

    public void a(c cVar) {
        this.o = true;
        CardinalActionCode cardinalActionCode = CardinalActionCode.ERROR;
        k.a(this.m.g.toString());
        com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r4 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) this.g;
        ThreeDSecure$4 threeDSecure$4 = ThreeDSecure$4.this;
        k.access$000(threeDSecure$4.val$fragment, threeDSecure$4.val$request, threeDSecure$4.val$lookupListener);
        ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
    }

    public void a(f fVar) {
        f fVar2 = this.j;
        if (fVar2 == null || !fVar2.h.equals(fVar.h) || !this.o) {
            this.j = fVar;
            if (!this.m.j) {
                b(fVar);
            }
            try {
                new com.cardinalcommerce.cardinalmobilesdk.a.c.b(this, this.j, this.m.f1892a).execute(new Void[0]);
                if (this.m.f1897f) {
                    new com.cardinalcommerce.cardinalmobilesdk.a.c.a(f1844b, fVar.f1860a.deviceFingerprintUrl);
                }
            } catch (JSONException e2) {
                k.b(String.valueOf(10217), Arrays.toString(e2.getStackTrace()), this.j.h);
                b(new c(10215));
            }
        } else {
            b(this.j);
        }
    }

    public final void b(f fVar) {
        k.a("CardinalInit", "Init completed", fVar.h);
        f1847f = d.InitCompleted;
        k.a(this.m.g.toString());
        CardinalInitService cardinalInitService = this.g;
        String str = fVar.h;
        com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r0 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) cardinalInitService;
        if (r0 != null) {
            k.sDFReferenceId = str;
            ThreeDSecure$4 threeDSecure$4 = ThreeDSecure$4.this;
            k.access$000(threeDSecure$4.val$fragment, threeDSecure$4.val$request, threeDSecure$4.val$lookupListener);
            ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-completed");
            return;
        }
        throw null;
    }

    public final void a(CardinalActionCode cardinalActionCode, c cVar, Context context, String str) {
        if (this.h != null) {
            CountDownTimer countDownTimer = f1845d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                f1845d = null;
            }
            ValidateResponse validateResponse = new ValidateResponse(false, cardinalActionCode, cVar);
            k.a(cVar, this.j.h);
            k.a(this.m.g.toString());
            ((ThreeDSecureActivity) this.h).onValidated(context, validateResponse, str);
            f1847f = d.Validated;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Null CardinalValidateReceiver received on cca_continue"));
    }

    public void a(ValidateResponse validateResponse, String str) {
        com.cardinalcommerce.cardinalmobilesdk.a.d.b bVar = k;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Stepup validated with action code: ");
        outline73.append(validateResponse.f1900c);
        bVar.a("CardinalContinue", outline73.toString(), this.j.h);
        CountDownTimer countDownTimer = f1845d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f1845d = null;
        f1847f = d.Validated;
        k.a(this.m.g.toString());
        ((ThreeDSecureActivity) this.h).onValidated(this.n, validateResponse, str);
    }
}
