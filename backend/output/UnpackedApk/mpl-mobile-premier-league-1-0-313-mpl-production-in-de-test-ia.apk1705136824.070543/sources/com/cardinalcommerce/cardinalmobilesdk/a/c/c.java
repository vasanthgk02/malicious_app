package com.cardinalcommerce.cardinalmobilesdk.a.c;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.ThreeDSecure$4;
import com.cardinalcommerce.cardinalmobilesdk.a.a.f;
import com.cardinalcommerce.cardinalmobilesdk.a.d.b;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.shared.cs.d.a;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final b f1874c = b.a();

    /* renamed from: a  reason: collision with root package name */
    public final String f1875a;

    /* renamed from: b  reason: collision with root package name */
    public final com.cardinalcommerce.cardinalmobilesdk.a.b.b f1876b;

    /* renamed from: com.cardinalcommerce.cardinalmobilesdk.a.c.c$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1877a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001e */
        static {
            /*
                com.cardinalcommerce.shared.cs.b.a[] r0 = com.cardinalcommerce.shared.cs.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1877a = r0
                r1 = 1
                r2 = 4
                com.cardinalcommerce.shared.cs.b.a r3 = com.cardinalcommerce.shared.cs.b.a.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 3
                int[] r4 = f1877a     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = f1877a     // Catch:{ NoSuchFieldError -> 0x001e }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001e }
                r5 = 0
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r3 = f1877a     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.cardinalcommerce.shared.cs.b.a r4 = com.cardinalcommerce.shared.cs.b.a.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0024 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = f1877a     // Catch:{ NoSuchFieldError -> 0x002b }
                com.cardinalcommerce.shared.cs.b.a r2 = com.cardinalcommerce.shared.cs.b.a.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.cardinalmobilesdk.a.c.c.AnonymousClass1.<clinit>():void");
        }
    }

    public c(com.cardinalcommerce.cardinalmobilesdk.a.b.b bVar, String str, String str2) {
        this.f1876b = bVar;
        this.f1875a = str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Order", new JSONObject());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Agent", "CardinalMobileSdk_Android");
        jSONObject2.put("Version", ThreeDSStrings.SDKVersion);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("cca", true);
        jSONObject.put("SupportsAlternativePayments", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("BrowserPayload", jSONObject);
        jSONObject4.put("ConsumerSessionId", null);
        jSONObject4.put("Client", jSONObject2);
        jSONObject4.put("ServerJWT", str);
        super.a(GeneratedOutlineSupport.outline62(new StringBuilder(), this.f1875a, "Order/JWT/Init"), jSONObject4.toString(), 10000);
    }

    public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        com.cardinalcommerce.cardinalmobilesdk.a.a.c cVar;
        com.cardinalcommerce.cardinalmobilesdk.a.b.b bVar;
        int i = AnonymousClass1.f1877a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            f1874c.b(String.valueOf(10212), Arrays.toString(exc.getStackTrace()), null);
            bVar = this.f1876b;
            cVar = new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10212);
        } else if (i == 3) {
            f1874c.b(String.valueOf(10213), Arrays.toString(exc.getStackTrace()), null);
            bVar = this.f1876b;
            cVar = new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10213);
        } else if (i == 4) {
            f1874c.b(String.valueOf(10211), Arrays.toString(exc.getStackTrace()), null);
            bVar = this.f1876b;
            cVar = new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10211);
        } else if (i == 5) {
            f1874c.b(String.valueOf(10216), Arrays.toString(exc.getStackTrace()), null);
            bVar = this.f1876b;
            cVar = new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10216);
        } else {
            return;
        }
        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) bVar).a(cVar);
    }

    public void a(String str) {
        ThreeDSecure$4 threeDSecure$4;
        try {
            if (str.isEmpty()) {
                ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1876b).a(new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10219));
                return;
            }
            boolean z = ThreeDSStrings.IS_EXTERNAL_BUILD;
            f a2 = k.a(str);
            if (a2.f1861b != 0) {
                int i = a2.f1861b;
                String str2 = a2.f1862c;
                f1874c.b(String.valueOf(i), str2, a2.h);
                com.cardinalcommerce.cardinalmobilesdk.a.a.a aVar = (com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1876b;
                aVar.o = true;
                CardinalActionCode cardinalActionCode = CardinalActionCode.ERROR;
                com.cardinalcommerce.cardinalmobilesdk.a.a.a.k.a(aVar.m.g.toString());
                com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r7 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) aVar.g;
                ThreeDSecure$4 threeDSecure$42 = ThreeDSecure$4.this;
                k.access$000(threeDSecure$42.val$fragment, threeDSecure$42.val$request, threeDSecure$42.val$lookupListener);
                threeDSecure$4 = ThreeDSecure$4.this;
            } else if (a2.f1860a.f1898c != 0) {
                int i2 = a2.f1860a.f1898c;
                String str3 = a2.f1860a.f1899d;
                f1874c.b(String.valueOf(i2), str3, a2.h);
                com.cardinalcommerce.cardinalmobilesdk.a.a.a aVar2 = (com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1876b;
                aVar2.o = true;
                CardinalActionCode cardinalActionCode2 = CardinalActionCode.ERROR;
                com.cardinalcommerce.cardinalmobilesdk.a.a.a.k.a(aVar2.m.g.toString());
                com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r72 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) aVar2.g;
                ThreeDSecure$4 threeDSecure$43 = ThreeDSecure$4.this;
                k.access$000(threeDSecure$43.val$fragment, threeDSecure$43.val$request, threeDSecure$43.val$lookupListener);
                threeDSecure$4 = ThreeDSecure$4.this;
            } else {
                f1874c.a("CardinalInit", "Init Successful", null);
                ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1876b).a(a2);
                return;
            }
            threeDSecure$4.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
        } catch (JSONException e2) {
            f1874c.b(String.valueOf(10206), Arrays.toString(e2.getStackTrace()), null);
            com.cardinalcommerce.cardinalmobilesdk.a.b.b bVar = this.f1876b;
            e2.getLocalizedMessage();
            com.cardinalcommerce.cardinalmobilesdk.a.a.a aVar3 = (com.cardinalcommerce.cardinalmobilesdk.a.a.a) bVar;
            aVar3.o = true;
            CardinalActionCode cardinalActionCode3 = CardinalActionCode.ERROR;
            com.cardinalcommerce.cardinalmobilesdk.a.a.a.k.a(aVar3.m.g.toString());
            com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r73 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) aVar3.g;
            ThreeDSecure$4 threeDSecure$44 = ThreeDSecure$4.this;
            k.access$000(threeDSecure$44.val$fragment, threeDSecure$44.val$request, threeDSecure$44.val$lookupListener);
            ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
        }
    }

    public void a(String str, int i) {
        f1874c.b(String.valueOf(i), str, null);
        com.cardinalcommerce.cardinalmobilesdk.a.a.a aVar = (com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1876b;
        aVar.o = true;
        CardinalActionCode cardinalActionCode = CardinalActionCode.ERROR;
        com.cardinalcommerce.cardinalmobilesdk.a.a.a.k.a(aVar.m.g.toString());
        com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1 r3 = (com.braintreepayments.api.ThreeDSecure$4.AnonymousClass1) aVar.g;
        ThreeDSecure$4 threeDSecure$4 = ThreeDSecure$4.this;
        k.access$000(threeDSecure$4.val$fragment, threeDSecure$4.val$request, threeDSecure$4.val$lookupListener);
        ThreeDSecure$4.this.val$fragment.sendAnalyticsEvent("three-d-secure.cardinal-sdk.init.setup-failed");
    }
}
