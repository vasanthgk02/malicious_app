package defpackage;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: f  reason: default package */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f3316a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Uri> f129a = new LinkedHashMap();

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f3316a == null) {
                    f3316a = new f();
                }
                fVar = f3316a;
            }
        }
        return fVar;
    }

    public synchronized Uri a(String str) {
        try {
            cp.a((String) com.netcore.android.utility.f.f1288a, "Dequeuing pending response for request ID " + str);
        }
        return this.f129a.remove(str);
    }

    public synchronized void a(String str, Uri uri) {
        if (str != null) {
            while (this.f129a.size() >= 10) {
                String next = this.f129a.keySet().iterator().next();
                cp.a((String) com.netcore.android.utility.f.f1288a, "Purging pending response for request ID " + next);
                this.f129a.remove(next);
            }
            cp.a((String) com.netcore.android.utility.f.f1288a, "Recording pending response for request ID " + str);
            this.f129a.put(str, uri);
        } else {
            throw new IllegalArgumentException("requestId must be non-null");
        }
    }
}
