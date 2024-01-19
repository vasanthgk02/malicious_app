package com.cardinalcommerce.cardinalmobilesdk.a.c;

import com.cardinalcommerce.cardinalmobilesdk.a.a.c;
import com.cardinalcommerce.cardinalmobilesdk.a.d.b;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.shared.cs.d.a;
import com.cardinalcommerce.shared.cs.f.m;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final b f1878e = b.a();

    /* renamed from: a  reason: collision with root package name */
    public final String f1879a;

    /* renamed from: b  reason: collision with root package name */
    public final m f1880b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cardinalcommerce.shared.cs.e.a f1881c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f1882d;

    /* renamed from: com.cardinalcommerce.cardinalmobilesdk.a.c.d$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1883a;

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
                f1883a = r0
                r1 = 1
                r2 = 4
                com.cardinalcommerce.shared.cs.b.a r3 = com.cardinalcommerce.shared.cs.b.a.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 3
                int[] r4 = f1883a     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = f1883a     // Catch:{ NoSuchFieldError -> 0x001e }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001e }
                r5 = 0
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r3 = f1883a     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.cardinalcommerce.shared.cs.b.a r4 = com.cardinalcommerce.shared.cs.b.a.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0024 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = f1883a     // Catch:{ NoSuchFieldError -> 0x002b }
                com.cardinalcommerce.shared.cs.b.a r2 = com.cardinalcommerce.shared.cs.b.a.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.cardinalmobilesdk.a.c.d.AnonymousClass1.<clinit>():void");
        }
    }

    public d(com.cardinalcommerce.shared.cs.e.a aVar, m mVar, String str) {
        this.f1880b = mVar;
        this.f1882d = aVar.f2082e;
        this.f1881c = aVar;
        this.f1879a = str;
        f1878e.a("CardinalContinue", "Challenge task initialized", String.valueOf(aVar.t));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1879a);
            sb.append("Order/JWT/StepUp");
            super.a(sb.toString(), String.valueOf(a(aVar)), 10000);
        } catch (JSONException e2) {
            f1878e.b(String.valueOf(10611), Arrays.toString(e2.getStackTrace()), String.valueOf(aVar.t));
            a(new c(10611));
        }
    }

    public final String a(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public final JSONObject a(com.cardinalcommerce.shared.cs.e.a aVar) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("ChallengeCancel", a(aVar.f2082e));
        jSONObject2.putOpt("ChallengeDataEntry", a(aVar.f2083f));
        jSONObject2.putOpt("ChallengeHTMLDataEntry", a(aVar.g));
        jSONObject2.putOpt("OobContinue", Boolean.valueOf(aVar.l));
        jSONObject2.putOpt("ResendChallenge", a(aVar.m));
        jSONObject2.putOpt("TransactionId", a(aVar.s));
        jSONObject2.putOpt("ChallengeNoEntry", a(aVar.r));
        jSONObject2.putOpt("RequestorAppUrl", a(aVar.q));
        jSONObject2.putOpt("WhiteListDataEntry", a(aVar.p));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("PaymentType", "cca");
        jSONObject3.putOpt("StepUp", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.putOpt("Agent", "CardinalMobileSdk_Android");
        jSONObject4.putOpt("Version", ThreeDSStrings.SDKVersion);
        jSONObject.putOpt("BrowserPayload", jSONObject3);
        jSONObject.putOpt("Client", jSONObject4);
        char[] cArr = aVar.t;
        if (cArr.length != 0) {
            jSONObject.putOpt("ConsumerSessionId", a(cArr));
        }
        char[] cArr2 = aVar.u;
        if (cArr2.length != 0) {
            jSONObject.putOpt("ServerJWT", a(cArr2));
        }
        return jSONObject;
    }

    public void onPreExecute() {
        super.onPreExecute();
        if (h.a(this.f1882d)) {
            return;
        }
        if (Arrays.equals(this.f1882d, ThreeDSStrings.CHALLENGE_CANCEL_CHAR) || Arrays.equals(this.f1882d, ThreeDSStrings.CHALLENGE_CANCEL_ERROR)) {
            ValidateResponse validateResponse = new ValidateResponse(false, CardinalActionCode.CANCEL, new c(0, ""));
            m mVar = this.f1880b;
            com.cardinalcommerce.shared.cs.c.c cVar = mVar.f2166c;
            if (cVar != null) {
                cVar.a();
            }
            ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) mVar.k).a(validateResponse, null);
        }
    }

    public final void a(c cVar) {
        ValidateResponse validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, cVar);
        m mVar = this.f1880b;
        com.cardinalcommerce.shared.cs.c.c cVar2 = mVar.f2166c;
        if (cVar2 != null) {
            cVar2.a();
        }
        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) mVar.k).a(validateResponse, "");
    }

    public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        c cVar;
        int i = AnonymousClass1.f1883a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            f1878e.b(String.valueOf(10612), Arrays.toString(exc.getStackTrace()), String.valueOf(this.f1881c.t));
            cVar = new c(10612);
        } else if (i == 3) {
            f1878e.b(String.valueOf(10615), Arrays.toString(exc.getStackTrace()), String.valueOf(this.f1881c.t));
            cVar = new c(10615);
        } else if (i == 4) {
            f1878e.b(String.valueOf(10613), Arrays.toString(exc.getStackTrace()), String.valueOf(this.f1881c.t));
            cVar = new c(10613);
        } else if (i == 5) {
            f1878e.b(String.valueOf(10614), Arrays.toString(exc.getStackTrace()), String.valueOf(this.f1881c.t));
            cVar = new c(10614);
        } else {
            return;
        }
        a(cVar);
    }

    public void a(String str) {
        f fVar;
        if ((!Arrays.equals(this.f1882d, ThreeDSStrings.CHALLENGE_CANCEL_CHAR) || !Arrays.equals(this.f1882d, ThreeDSStrings.CHALLENGE_CANCEL_ERROR)) && h.a(this.f1882d)) {
            try {
                fVar = new f(str);
            } catch (UnsupportedOperationException | JSONException e2) {
                f1878e.b(String.valueOf(10611), Arrays.toString(e2.getStackTrace()), String.valueOf(this.f1881c.t));
                a(new c(10611));
                fVar = null;
            }
            if (fVar != null) {
                int i = fVar.f1889f;
                if (i == 0) {
                    com.cardinalcommerce.shared.cs.e.b bVar = fVar.f1888e;
                    if (bVar != null) {
                        this.f1880b.a(bVar);
                    } else if (fVar.g) {
                        this.f1880b.a(fVar.f1887d, fVar.f1886c);
                    } else {
                        ValidateResponse validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, new c(10702));
                        m mVar = this.f1880b;
                        com.cardinalcommerce.shared.cs.c.c cVar = mVar.f2166c;
                        if (cVar != null) {
                            cVar.a();
                        }
                        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) mVar.k).a(validateResponse, null);
                    }
                } else {
                    ValidateResponse validateResponse2 = new ValidateResponse(false, CardinalActionCode.ERROR, new c(i, fVar.f1884a));
                    m mVar2 = this.f1880b;
                    com.cardinalcommerce.shared.cs.c.c cVar2 = mVar2.f2166c;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                    ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) mVar2.k).a(validateResponse2, null);
                }
            }
        }
    }

    public void a(String str, int i) {
        f1878e.b(String.valueOf(i), str, String.valueOf(this.f1881c.t));
        a(new c(10612));
    }
}
