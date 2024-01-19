package defpackage;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;

/* renamed from: bt  reason: default package */
public final class bt implements bp {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Fragment> f2798a;

    public bt(Fragment fragment) {
        if (fragment != null) {
            this.f2798a = new WeakReference<>(fragment);
            return;
        }
        throw new IllegalArgumentException("fragment must be non-null");
    }

    public Context a() {
        return ((Fragment) this.f2798a.get()).getActivity();
    }

    /* renamed from: a  reason: collision with other method in class */
    public bm m271a() {
        return a((InteractiveRequestRecord) null);
    }

    public final bm a(InteractiveRequestRecord interactiveRequestRecord) {
        Fragment fragment = (Fragment) this.f2798a.get();
        if (fragment != null) {
            FragmentManager fragmentManager = fragment.getFragmentManager();
            try {
                bn bnVar = (bn) fragmentManager.findFragmentByTag(bn.f2794a);
                if (bnVar == 0) {
                    bv bvVar = new bv();
                    fragmentManager.beginTransaction().add((Fragment) bvVar, bn.f2794a).commit();
                    bnVar = bvVar;
                }
                if (interactiveRequestRecord != null) {
                    Bundle bundle = new Bundle();
                    fragmentManager.putFragment(bundle, "wrappedFragment", fragment);
                    interactiveRequestRecord.a(bundle);
                    bnVar.a().a(interactiveRequestRecord);
                }
                return bnVar.a();
            } catch (ClassCastException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Found an invalid fragment looking for fragment with tag ");
                outline73.append(bn.f2794a);
                outline73.append(". Please use a different fragment tag.");
                cp.a((String) "bt", outline73.toString(), (Throwable) e2);
            }
        } else {
            cp.b("bt", "Failed to get InteractiveState on a garbage-collected Fragment");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m272a() {
        return this.f2798a.get();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m273a(InteractiveRequestRecord interactiveRequestRecord) {
        a(interactiveRequestRecord);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bt.class != obj.getClass()) {
            return false;
        }
        bt btVar = (bt) obj;
        WeakReference<Fragment> weakReference = this.f2798a;
        if (weakReference == null) {
            if (btVar.f2798a != null) {
                return false;
            }
        } else if (btVar.f2798a == null) {
            return false;
        } else {
            if (weakReference.get() == null) {
                if (btVar.f2798a.get() != null) {
                    return false;
                }
            } else if (!((Fragment) this.f2798a.get()).equals(btVar.f2798a.get())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WeakReference<Fragment> weakReference = this.f2798a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Fragment) this.f2798a.get()).hashCode());
    }
}
