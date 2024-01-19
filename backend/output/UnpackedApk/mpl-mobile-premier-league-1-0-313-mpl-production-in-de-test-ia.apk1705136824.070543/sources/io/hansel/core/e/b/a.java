package io.hansel.core.e.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<WeakReference<C0074a>> f5164a;

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f5165b = new ReentrantLock();

    /* renamed from: io.hansel.core.e.b.a$a  reason: collision with other inner class name */
    public interface C0074a {
    }

    public static NetworkInfo a(Context context) {
        if (b(context)) {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return null;
    }

    public static void a(C0074a aVar) {
        if (aVar != null) {
            f5165b.lock();
            if (f5164a == null) {
                f5164a = new ArrayList<>();
            }
            f5164a.add(new WeakReference(aVar));
            f5165b.unlock();
        }
    }

    public static boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public static boolean c(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isConnected();
    }
}
