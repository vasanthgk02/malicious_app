package defpackage;

import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: ca  reason: default package */
public final class ca {

    /* renamed from: a  reason: collision with root package name */
    public static int f2812a;

    /* renamed from: a  reason: collision with other field name */
    public static final Executor f81a = Executors.newCachedThreadPool(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("AmazonAuthorzationLibrary#");
            int i = ca.f2812a + 1;
            ca.f2812a = i;
            outline73.append(i);
            return new Thread(runnable, outline73.toString());
        }
    });

    public static boolean a() {
        return Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper();
    }
}
