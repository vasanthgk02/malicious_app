package com.shield.android.e;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.shield.android.ShieldException;
import java.util.HashMap;
import java.util.Map;

public abstract class e {

    public enum a {
        GET,
        POST,
        PUT
    }

    public enum b {
        JSON(DefaultSettingsSpiCall.ACCEPT_JSON_VALUE),
        FORM_URL_ENCODED("application/x-www-form-urlencoded"),
        TEXT("text/plain");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f1582a;

        /* access modifiers changed from: public */
        b(String str) {
            this.f1582a = str;
        }
    }

    public abstract String a();

    public abstract void a(ShieldException shieldException);

    public abstract void a(String str);

    public abstract a b();

    public abstract HashMap<String, String> c();

    public abstract Map<String, Object> d();

    public abstract b e();

    public abstract String f();

    public abstract String g();

    public abstract String h();
}
