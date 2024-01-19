package lib.android.paypal.com.magnessdk.network.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6135a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static d f6136b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f6137c;

    public d() {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(256), new DiscardPolicy());
            this.f6137c = threadPoolExecutor;
        } catch (Exception unused) {
        }
    }
}
