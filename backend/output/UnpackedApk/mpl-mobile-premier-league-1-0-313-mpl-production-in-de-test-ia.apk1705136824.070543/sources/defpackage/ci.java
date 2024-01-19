package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;

/* renamed from: ci  reason: default package */
public abstract class ci<Result> {
    public final Result a(Context context, ac acVar) throws AuthError {
        Throwable e2 = null;
        int i = 0;
        while (i <= 3) {
            try {
                k a2 = acVar.a(context, i == 3);
                if (a2 != null) {
                    Result a3 = a(context, a2);
                    ac.a(context);
                    return a3;
                }
                i++;
            } catch (RemoteException e3) {
                e2 = e3;
                ac.a(context);
            }
        }
        if (0 != 0 || e2 == null) {
            return null;
        }
        throw new AuthError("Service Failure", e2, ERROR_TYPE.ERROR_THREAD);
    }

    public abstract Result a(Context context, k kVar) throws AuthError, RemoteException;
}
