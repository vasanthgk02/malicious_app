package defpackage;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;

@SuppressLint({"NewApi"})
/* renamed from: bs  reason: default package */
public final class bs implements bp {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Fragment> f2797a;

    public bs(Fragment fragment) {
        if (fragment != null) {
            this.f2797a = new WeakReference<>(fragment);
            return;
        }
        throw new IllegalArgumentException("fragment must be non-null");
    }

    public Context a() {
        return ((Fragment) this.f2797a.get()).getActivity();
    }

    /* renamed from: a  reason: collision with other method in class */
    public bm m268a() {
        return a((InteractiveRequestRecord) null);
    }

    public final bm a(InteractiveRequestRecord interactiveRequestRecord) {
        Fragment fragment = (Fragment) this.f2797a.get();
        if (fragment != null) {
            FragmentManager fragmentManager = fragment.getFragmentManager();
            try {
                bn bnVar = (bn) fragmentManager.findFragmentByTag(bn.f2794a);
                if (bnVar == 0) {
                    bu buVar = new bu();
                    fragmentManager.beginTransaction().add(buVar, bn.f2794a).commit();
                    bnVar = buVar;
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
                cp.a((String) "bs", outline73.toString(), (Throwable) e2);
            }
        } else {
            cp.b("bs", "Failed to get InteractiveState for a garbage-collected Fragment");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m269a() {
        return this.f2797a.get();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m270a(InteractiveRequestRecord interactiveRequestRecord) {
        a(interactiveRequestRecord);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bs.class != obj.getClass()) {
            return false;
        }
        bs bsVar = (bs) obj;
        WeakReference<Fragment> weakReference = this.f2797a;
        if (weakReference == null) {
            if (bsVar.f2797a != null) {
                return false;
            }
        } else if (bsVar.f2797a == null) {
            return false;
        } else {
            if (weakReference.get() == null) {
                if (bsVar.f2797a.get() != null) {
                    return false;
                }
            } else if (!((Fragment) this.f2797a.get()).equals(bsVar.f2797a.get())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WeakReference<Fragment> weakReference = this.f2797a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Fragment) this.f2797a.get()).hashCode());
    }
}
