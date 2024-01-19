package defpackage;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.shared.APIListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: bz  reason: default package */
public class bz implements APIListener, Future<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2804a = bz.class.getName();

    /* renamed from: a  reason: collision with other field name */
    public final ae f76a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f77a;

    /* renamed from: a  reason: collision with other field name */
    public AuthError f78a;

    /* renamed from: a  reason: collision with other field name */
    public final CountDownLatch f79a;

    /* renamed from: bz$a */
    public enum a {
        SUCCESS,
        ERROR,
        CANCEL
    }

    public bz() {
        this(null);
    }

    public bz(ae aeVar) {
        this.f76a = aeVar == null ? new by() : aeVar;
        this.f79a = new CountDownLatch(1);
    }

    public Bundle a() {
        AuthError authError = this.f78a;
        if (authError == null) {
            return this.f77a;
        }
        Bundle errorBundle = AuthError.getErrorBundle(authError);
        errorBundle.putSerializable(ch$b.FUTURE.f89a, a.ERROR);
        return errorBundle;
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException {
        if (!ca.a()) {
            cp.c(f2804a, "Running get on Future");
            this.f79a.await();
            return a();
        }
        cp.b(f2804a, "Cannot call get on the main thread, unless you want ANRs");
        throw new IllegalStateException("Cannot call get on the main thread, unless you want ANRs");
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return this.f79a.getCount() == 0;
    }

    public void onError(AuthError authError) {
        this.f78a = authError;
        this.f79a.countDown();
        this.f76a.onError(authError);
    }

    public void onSuccess(Bundle bundle) {
        this.f77a = bundle;
        if (bundle == null) {
            cp.d(f2804a, "Null Response");
            this.f77a = new Bundle();
        }
        this.f77a.putSerializable(ch$b.FUTURE.f89a, a.SUCCESS);
        this.f79a.countDown();
        this.f76a.onSuccess(bundle);
    }

    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!ca.a()) {
            String str = f2804a;
            StringBuilder outline76 = GeneratedOutlineSupport.outline76("Running get on Future with timeout=", j, "unit=");
            outline76.append(timeUnit.name());
            cp.c(str, outline76.toString());
            this.f79a.await(j, timeUnit);
            return a();
        }
        cp.b(f2804a, "Cannot call get on the main thread, unless you want ANRs");
        throw new IllegalStateException("Cannot call get on the main thread, unless you want ANRs");
    }
}
