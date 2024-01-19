package com.cardinalcommerce.shared.cs.f;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.cardinalmobilesdk.a.a.f;
import com.cardinalcommerce.cardinalmobilesdk.a.b.b;
import com.cardinalcommerce.cardinalmobilesdk.a.c.d;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.emvco.a.d.a;
import com.cardinalcommerce.emvco.events.ProtocolErrorEvent;
import com.cardinalcommerce.emvco.events.RuntimeErrorEvent;
import com.cardinalcommerce.emvco.events.ThreeDSEvent;
import com.cardinalcommerce.shared.cs.c.c;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONException;

public class m implements a, com.cardinalcommerce.shared.cs.c.a {

    /* renamed from: a  reason: collision with root package name */
    public static m f2164a;

    /* renamed from: b  reason: collision with root package name */
    public static com.cardinalcommerce.shared.cs.a.a f2165b;

    /* renamed from: c  reason: collision with root package name */
    public c f2166c;

    /* renamed from: d  reason: collision with root package name */
    public String f2167d;

    /* renamed from: e  reason: collision with root package name */
    public UiCustomization f2168e;

    /* renamed from: f  reason: collision with root package name */
    public com.cardinalcommerce.shared.cs.utils.a f2169f;
    public f g;
    public String h;
    public String i;
    public String j;
    public b k;
    public Context l;
    public com.cardinalcommerce.emvco.a.e.c m;
    public d n;
    public String o = "";

    public m(Context context) {
        this.l = context.getApplicationContext();
        this.f2169f = com.cardinalcommerce.shared.cs.utils.a.e();
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (f2164a == null) {
                if (context != null) {
                    f2164a = new m(context.getApplicationContext());
                } else {
                    throw new InvalidInputException("InvalidInputException", new Throwable("Caught in UIInteractionFactory getInstance(), null Context passed"));
                }
            }
            mVar = f2164a;
        }
        return mVar;
    }

    public final void a(ValidateResponse validateResponse, Context context) {
        if (context != null) {
            ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.k).a(validateResponse, "");
        }
    }

    public void a(ValidateResponse validateResponse, String str) {
        c cVar = this.f2166c;
        if (cVar != null) {
            cVar.a();
        }
        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.k).a(validateResponse, str);
    }

    public void a(com.cardinalcommerce.shared.cs.a.a aVar, UiCustomization uiCustomization, b bVar, f fVar, String str, String str2, String str3, String str4) {
        f2165b = aVar;
        this.f2168e = uiCustomization;
        this.g = fVar;
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = bVar;
        this.o = str4;
        this.f2169f.a("CardinalContinue", "UI Interaction Factory Configured", fVar.h);
    }

    public void a(String str, ThreeDSEvent threeDSEvent) {
        com.cardinalcommerce.emvco.a.f.b.a().b();
        if (Objects.equals(str, "ProtocolError")) {
            ProtocolErrorEvent protocolErrorEvent = (ProtocolErrorEvent) threeDSEvent;
            throw null;
        } else if (Objects.equals(str, "RunTimeError")) {
            RuntimeErrorEvent runtimeErrorEvent = (RuntimeErrorEvent) threeDSEvent;
            throw null;
        } else if (Objects.equals(str, "TimeOutError")) {
            throw null;
        } else if (!Objects.equals(str, "CancelTimeout")) {
            this.f2166c.a();
        } else {
            com.cardinalcommerce.shared.cs.a.a aVar = com.cardinalcommerce.shared.cs.a.a.EMVCO;
            throw null;
        }
    }

    public void a(com.cardinalcommerce.shared.cs.e.a aVar, c cVar, String str) {
        ValidateResponse validateResponse;
        this.f2166c = cVar;
        this.f2167d = str;
        if (f2165b != com.cardinalcommerce.shared.cs.a.a.EMVCO) {
            this.f2169f.a("CardinalContinue", "UI Interaction Factory sendUserResponse", this.g.h);
            if (this.l != null) {
                if (aVar == null) {
                    validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10713));
                } else {
                    f fVar = this.g;
                    if (fVar != null) {
                        String str2 = fVar.h;
                        if (str2 != null) {
                            com.cardinalcommerce.shared.cs.utils.a aVar2 = this.f2169f;
                            aVar2.a("CardinalContinue", "In Stepup user Input. SessionId : " + str2, str2);
                            if (aVar.f2079b.f2109a) {
                                aVar.u = h.a(this.h);
                                aVar.t = h.a(str2);
                                aVar.s = h.a(this.i);
                                if (!this.o.equals("")) {
                                    aVar.q = h.a(this.o);
                                }
                                d dVar = new d(aVar, this, this.j);
                                this.n = dVar;
                                dVar.execute(new Void[0]);
                            } else {
                                validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10703));
                            }
                        } else {
                            this.f2169f.b(String.valueOf(10711), "Internal Error", null);
                            validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10711));
                        }
                    } else {
                        validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.a.a.c(10711));
                    }
                }
                a(validateResponse, this.l);
            }
            if (h.a(aVar.f2082e)) {
                return;
            }
            if (Arrays.equals(aVar.f2082e, ThreeDSStrings.CHALLENGE_CANCEL_CHAR) || Arrays.equals(aVar.f2082e, ThreeDSStrings.CHALLENGE_CANCEL_ERROR)) {
                cVar.a();
                return;
            }
            return;
        }
        this.f2169f.a("EMVCoDoChallenge", "UI Interaction Factory sendUserResponse EMVCo", null);
        try {
            new com.cardinalcommerce.emvco.a.e.c(this, aVar);
            throw null;
        } catch (JSONException e2) {
            com.cardinalcommerce.shared.cs.utils.a aVar3 = this.f2169f;
            String valueOf = String.valueOf(11417);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while creating new ChallengeTask \n");
            outline73.append(e2.getLocalizedMessage());
            aVar3.b(valueOf, outline73.toString(), null);
            a((String) "", new ThreeDSEvent());
            com.cardinalcommerce.emvco.a.e.c cVar2 = this.m;
            if (cVar2 != null) {
                cVar2.execute(new Void[0]);
                this.f2169f.a("EMVCoDoChallenge", "Challenge Task started 02", null);
            }
        }
    }

    public void a(com.cardinalcommerce.shared.cs.e.b bVar) {
        if (!bVar.g.equalsIgnoreCase(this.f2167d) || !bVar.i.equalsIgnoreCase("N")) {
            k.a(bVar, this.l, this.f2168e);
        } else {
            this.f2166c.a(bVar);
        }
    }
}
