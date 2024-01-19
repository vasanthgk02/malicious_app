package defpackage;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.CancellableListener;
import com.amazon.identity.auth.device.shared.APIListener;

/* renamed from: ae  reason: default package */
public interface ae extends CancellableListener<Bundle, Bundle, AuthError>, APIListener {
    void a(Bundle bundle);

    void onError(AuthError authError);

    void onSuccess(Bundle bundle);
}
