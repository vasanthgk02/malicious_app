package com.cardinalcommerce.emvco.a.f;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import com.cardinalcommerce.emvco.a.d.a;
import com.cardinalcommerce.emvco.events.ProtocolErrorEvent;
import com.cardinalcommerce.emvco.events.RuntimeErrorEvent;
import com.cardinalcommerce.emvco.events.ThreeDSEvent;
import java.util.Objects;

public class b implements a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static b f2067c;
    public static CountDownTimer h;
    public static com.cardinalcommerce.emvco.a.g.a j;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                com.cardinalcommerce.emvco.a.g.a a2 = com.cardinalcommerce.emvco.a.g.a.a();
                j = a2;
                a2.a("EMVCoTransaction", "getInstance called");
                if (f2067c == null) {
                    f2067c = new b();
                    j.a("EMVCoTransaction", "Instance created");
                }
                bVar = f2067c;
            }
        }
        return bVar;
    }

    public void a(com.cardinalcommerce.shared.cs.e.b bVar) {
        j.a("EMVCoTransaction", "onCReqSuccess called");
        if (bVar.B.equalsIgnoreCase("Y") || bVar.B.equalsIgnoreCase("N") || !bVar.i.equalsIgnoreCase("N")) {
            b();
            j.a("EMVCoTransaction", "Transaction Timer ended");
        }
        throw null;
    }

    public void a(String str, ThreeDSEvent threeDSEvent) {
        j.a("EMVCoTransaction", "onCReqError called");
        j.a("EMVCoTransaction", "Transaction Timer ended");
        if (Objects.equals(str, "ProtocolError")) {
            ProtocolErrorEvent protocolErrorEvent = (ProtocolErrorEvent) threeDSEvent;
            throw null;
        } else if (Objects.equals(str, "RunTimeError")) {
            RuntimeErrorEvent runtimeErrorEvent = (RuntimeErrorEvent) threeDSEvent;
            throw null;
        } else if (!Objects.equals(str, "TimeOutError")) {
            Objects.equals(str, "CancelTimeout");
            throw null;
        } else {
            throw null;
        }
    }

    public void b() {
        CountDownTimer countDownTimer = h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            h = null;
        }
    }
}
