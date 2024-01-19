package defpackage;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.shared.APIListener;

/* renamed from: bx  reason: default package */
public class bx extends bz implements ae {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2801a = bx.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f2802b;

    public bx() {
        super(null);
    }

    public bx(final APIListener aPIListener) {
        super(new ae() {
            /* renamed from: a */
            public void onCancel(Bundle bundle) {
                cp.d(bx.f2801a, "onCancel called in for APIListener");
            }

            public void onError(AuthError authError) {
                APIListener aPIListener = APIListener.this;
                if (aPIListener != null) {
                    aPIListener.onError(authError);
                }
            }

            public void onSuccess(Bundle bundle) {
                APIListener aPIListener = APIListener.this;
                if (aPIListener != null) {
                    aPIListener.onSuccess(bundle);
                }
            }
        });
    }

    public Bundle a() {
        Bundle bundle = this.f2802b;
        return bundle != null ? bundle : super.a();
    }

    /* renamed from: a */
    public void onCancel(Bundle bundle) {
        this.f2802b = bundle;
        bundle.putSerializable(ch$b.FUTURE.f89a, a.CANCEL);
        this.f79a.countDown();
        this.f76a.a(this.f2802b);
    }
}
