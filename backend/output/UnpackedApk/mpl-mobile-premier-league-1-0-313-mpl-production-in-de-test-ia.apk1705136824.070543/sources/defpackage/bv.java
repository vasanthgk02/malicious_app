package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* renamed from: bv  reason: default package */
public final class bv extends Fragment implements bn {

    /* renamed from: a  reason: collision with root package name */
    public bk f2800a = new bk(this);

    public bm a() {
        return this.f2800a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m275a() {
        return getActivity();
    }

    public Object a(Bundle bundle) {
        return getFragmentManager().getFragment(bundle, "wrappedFragment");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2800a.a(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f2800a.b(bundle);
        super.onSaveInstanceState(bundle);
    }
}
