package defpackage;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.Set;

/* renamed from: bj  reason: default package */
public final class bj<T extends InteractiveListener<S, U, V>, S, U, V> implements InteractiveListener<S, U, V> {

    /* renamed from: a  reason: collision with root package name */
    public String f2791a;

    /* renamed from: a  reason: collision with other field name */
    public Set<T> f69a;

    public bj(String str, Set<T> set) {
        this.f2791a = str;
        set = set == null ? Collections.emptySet() : set;
        this.f69a = set;
        for (T t : set) {
            if (!str.equals(t.getRequestType())) {
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("AggregateInteractiveListener created for request type \"", str, "\" but received listener with request type \"");
                outline80.append(t.getRequestType());
                outline80.append("\"");
                throw new IllegalStateException(outline80.toString());
            }
        }
    }

    public String getRequestType() {
        return this.f2791a;
    }

    public void onCancel(U u) {
        for (T onCancel : this.f69a) {
            onCancel.onCancel(u);
        }
    }

    public void onError(V v) {
        for (T onError : this.f69a) {
            onError.onError(v);
        }
    }

    public void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, co coVar) {
        for (T onRequestCancel : this.f69a) {
            onRequestCancel.onRequestCancel(context, interactiveRequestRecord, coVar);
        }
    }

    public void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        for (T onRequestCompletion : this.f69a) {
            onRequestCompletion.onRequestCompletion(context, interactiveRequestRecord, uri);
        }
    }

    public void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        for (T onRequestError : this.f69a) {
            onRequestError.onRequestError(context, interactiveRequestRecord, exc);
        }
    }

    public void onSuccess(S s) {
        for (T onSuccess : this.f69a) {
            onSuccess.onSuccess(s);
        }
    }
}
