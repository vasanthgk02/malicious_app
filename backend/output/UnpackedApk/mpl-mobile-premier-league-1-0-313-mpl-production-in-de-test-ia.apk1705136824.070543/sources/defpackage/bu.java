package defpackage;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;

@SuppressLint({"NewApi"})
/* renamed from: bu  reason: default package */
public final class bu extends Fragment implements bn {

    /* renamed from: a  reason: collision with root package name */
    public bk f2799a = new bk(this);

    public bm a() {
        return this.f2799a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m274a() {
        return getActivity();
    }

    public Object a(Bundle bundle) {
        return getFragmentManager().getFragment(bundle, "wrappedFragment");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2799a.a(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f2799a.b(bundle);
        super.onSaveInstanceState(bundle);
    }
}
