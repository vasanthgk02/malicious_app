package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;

/* renamed from: u  reason: default package */
public abstract class u<T> implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3340a = u.class.getName();

    /* renamed from: a  reason: collision with other field name */
    public IInterface f163a = null;

    /* renamed from: a  reason: collision with other field name */
    public l f164a;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        cp.c(f3340a, "onServiceConnected called");
        try {
            z = iBinder.getInterfaceDescriptor().equals(k.class.getName());
        } catch (Exception e2) {
            String str = f3340a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
            outline73.append(e2.getMessage());
            cp.a(str, outline73.toString(), (Throwable) e2);
            z = false;
        }
        if (z) {
            k a2 = a.a(iBinder);
            this.f163a = a2;
            AnonymousClass1 r5 = (AnonymousClass1) this.f164a;
            b bVar = bVar;
            bVar.f27a = a2;
            bVar.f2700a = abVar2;
            bVar.f25a = intent2;
            countDownLatch2.countDown();
            return;
        }
        l lVar = this.f164a;
        new AuthError("Returned service's interface doesn't match authorization service", ERROR_TYPE.ERROR_UNKNOWN);
        AnonymousClass1 r4 = (AnonymousClass1) lVar;
        b bVar2 = bVar;
        bVar2.f27a = null;
        bVar2.f2700a = null;
        bVar2.f25a = null;
        cp.c("ac", "Bind - error");
        countDownLatch2.countDown();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        cp.c(f3340a, "onServiceDisconnected called");
        this.f163a = null;
    }
}
