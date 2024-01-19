package co.hyperverge.hypersnapsdk.f.j;

import android.os.Handler;
import android.os.Looper;

/* compiled from: MainUIThread */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f3184a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f3185b = new Handler(Looper.getMainLooper());

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f3184a == null) {
                    f3184a = new a();
                }
                aVar = f3184a;
            }
        }
        return aVar;
    }
}
