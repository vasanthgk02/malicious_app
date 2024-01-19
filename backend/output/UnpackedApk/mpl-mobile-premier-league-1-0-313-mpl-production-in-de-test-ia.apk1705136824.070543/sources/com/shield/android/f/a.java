package com.shield.android.f;

import android.content.SharedPreferences;
import android.util.Pair;
import com.shield.android.ShieldCallback;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f1618a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1619b = false;

    public a(SharedPreferences sharedPreferences, boolean z) {
        this.f1618a = sharedPreferences;
        this.f1619b = z;
    }

    public void a(ShieldCallback<Pair<String, String>> shieldCallback) {
        boolean z = this.f1619b;
        try {
            shieldCallback.onSuccess(new Pair(this.f1618a.getString(z ? "fallback_endpoint" : HttpTunnelingServlet.ENDPOINT, ""), this.f1618a.getString(z ? "fallback_version" : "version", "")));
        } catch (Exception unused) {
        }
    }
}
