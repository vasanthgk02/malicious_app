package defpackage;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;

/* renamed from: br  reason: default package */
public final class br implements bp {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<FragmentActivity> f2796a;

    public br(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            this.f2796a = new WeakReference<>(fragmentActivity);
            return;
        }
        throw new IllegalArgumentException("activity must be non-null");
    }

    public Context a() {
        return (Context) this.f2796a.get();
    }

    /* renamed from: a  reason: collision with other method in class */
    public bm m266a() {
        FragmentActivity fragmentActivity = (FragmentActivity) this.f2796a.get();
        if (fragmentActivity != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            try {
                bn bnVar = (bn) supportFragmentManager.findFragmentByTag(bn.f2794a);
                if (bnVar == 0) {
                    bv bvVar = new bv();
                    supportFragmentManager.beginTransaction().add((Fragment) bvVar, bn.f2794a).commit();
                    bnVar = bvVar;
                }
                return bnVar.a();
            } catch (ClassCastException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Found an invalid fragment looking for fragment with tag ");
                outline73.append(bn.f2794a);
                outline73.append(". Please use a different fragment tag.");
                cp.a((String) "br", outline73.toString(), (Throwable) e2);
            }
        } else {
            cp.b("br", "Failed to get InteractiveState on a garbage-collected FragmentActivity");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m267a() {
        return this.f2796a.get();
    }

    public void a(InteractiveRequestRecord interactiveRequestRecord) {
        bm a2 = a();
        if (a2 != null) {
            a2.a(interactiveRequestRecord);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || br.class != obj.getClass()) {
            return false;
        }
        br brVar = (br) obj;
        WeakReference<FragmentActivity> weakReference = this.f2796a;
        if (weakReference == null) {
            if (brVar.f2796a != null) {
                return false;
            }
        } else if (brVar.f2796a == null) {
            return false;
        } else {
            if (weakReference.get() == null) {
                if (brVar.f2796a.get() != null) {
                    return false;
                }
            } else if (!((FragmentActivity) this.f2796a.get()).equals(brVar.f2796a.get())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WeakReference<FragmentActivity> weakReference = this.f2796a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((FragmentActivity) this.f2796a.get()).hashCode());
    }
}
