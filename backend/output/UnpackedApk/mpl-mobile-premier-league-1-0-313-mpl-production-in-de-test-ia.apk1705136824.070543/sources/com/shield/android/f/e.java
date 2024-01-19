package com.shield.android.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.preference.PreferenceManager;
import com.shield.android.ShieldCallback;
import com.shield.android.ShieldException;
import com.shield.android.e.f;
import com.shield.android.e.g;
import com.shield.android.e.g.C0020g;
import com.shield.android.e.j;
import com.shield.android.internal.b;
import in.juspay.hypersdk.core.PaymentConstants;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f1654a;

    /* renamed from: b  reason: collision with root package name */
    public j f1655b;

    /* renamed from: c  reason: collision with root package name */
    public f f1656c;

    /* renamed from: d  reason: collision with root package name */
    public g f1657d;

    /* renamed from: e  reason: collision with root package name */
    public String f1658e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1659f;
    public String g = HttpTunnelingServlet.ENDPOINT;

    public e(Context context, String str, g gVar, String str2, String str3, boolean z, b bVar) {
        try {
            this.f1654a = PreferenceManager.getDefaultSharedPreferences(context);
            this.f1658e = str;
            j jVar = new j(str2, str3, str, z, bVar);
            this.f1655b = jVar;
            this.f1657d = gVar;
            this.f1659f = z;
            this.g = z ? "fallback_endpoint" : r0;
        } catch (Exception unused) {
        }
    }

    public void a(ShieldCallback<Pair<String, String>> shieldCallback) {
        SharedPreferences sharedPreferences;
        try {
            if (this.f1659f) {
                c cVar = new c(this.f1655b, this.f1657d, this.f1654a, true);
                this.f1656c = cVar;
                cVar.f1621b.a(cVar.f1620a, new f(shieldCallback) {
                    public final /* synthetic */ ShieldCallback f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void a(C0020g gVar) {
                        c.this.a(this.f$1, gVar);
                    }
                });
                return;
            }
            SharedPreferences sharedPreferences2 = this.f1654a;
            if (sharedPreferences2 != null) {
                if (sharedPreferences2.contains(PaymentConstants.ENV) && !this.f1654a.getString(PaymentConstants.ENV, "").equalsIgnoreCase(this.f1658e)) {
                    this.f1654a.edit().putString(PaymentConstants.ENV, this.f1658e).apply();
                    this.f1654a.edit().remove(this.g).apply();
                    this.f1656c = new c(this.f1655b, this.f1657d, this.f1654a, this.f1659f);
                    this.f1656c.a(shieldCallback);
                    sharedPreferences = this.f1654a;
                    if (sharedPreferences != null && !sharedPreferences.contains(PaymentConstants.ENV)) {
                        this.f1654a.edit().putString(PaymentConstants.ENV, this.f1658e).apply();
                        return;
                    }
                }
            }
            SharedPreferences sharedPreferences3 = this.f1654a;
            if (sharedPreferences3 == null || !sharedPreferences3.contains(this.g) || this.f1654a.getString(this.g, "").length() <= 0) {
                this.f1656c = new c(this.f1655b, this.f1657d, this.f1654a, this.f1659f);
            } else {
                this.f1656c = new a(this.f1654a, this.f1659f);
            }
            this.f1656c.a(shieldCallback);
            sharedPreferences = this.f1654a;
            if (sharedPreferences != null) {
            }
        } catch (Exception e2) {
            shieldCallback.onFailure(ShieldException.unexpectedError(e2));
        }
    }
}
