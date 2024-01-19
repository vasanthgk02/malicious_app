package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;

/* renamed from: bq  reason: default package */
public final class bq implements bp {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Activity> f2795a;

    public bq(Activity activity) {
        if (activity != null) {
            this.f2795a = new WeakReference<>(activity);
            return;
        }
        throw new IllegalArgumentException("activity must be non-null");
    }

    public Context a() {
        return (Context) this.f2795a.get();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public bm m264a() {
        Activity activity = (Activity) this.f2795a.get();
        if (activity != null) {
            try {
                Class.forName("android.app.Fragment", false, getClass().getClassLoader());
                FragmentManager fragmentManager = activity.getFragmentManager();
                try {
                    bn bnVar = (bn) fragmentManager.findFragmentByTag(bn.f2794a);
                    if (bnVar == 0) {
                        bu buVar = new bu();
                        fragmentManager.beginTransaction().add(buVar, bn.f2794a).commit();
                        bnVar = buVar;
                    }
                    return bnVar.a();
                } catch (ClassCastException e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Found an invalid fragment looking for fragment with tag ");
                    outline73.append(bn.f2794a);
                    outline73.append(". Please use a different fragment tag.");
                    cp.a((String) "bq", outline73.toString(), (Throwable) e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new h("android.app.Fragment not found. To make a request from an activity, use minSdkVersion of at least 11, or use FragmentActivity from Android Support Library v4", e3);
            }
        } else {
            cp.b("bq", "Failed to get InteractiveState on a garbage-collected Activity");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m265a() {
        return this.f2795a.get();
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
        if (obj == null || bq.class != obj.getClass()) {
            return false;
        }
        bq bqVar = (bq) obj;
        WeakReference<Activity> weakReference = this.f2795a;
        if (weakReference == null) {
            if (bqVar.f2795a != null) {
                return false;
            }
        } else if (bqVar.f2795a == null) {
            return false;
        } else {
            if (weakReference.get() == null) {
                if (bqVar.f2795a.get() != null) {
                    return false;
                }
            } else if (!((Activity) this.f2795a.get()).equals(bqVar.f2795a.get())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WeakReference<Activity> weakReference = this.f2795a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Activity) this.f2795a.get()).hashCode());
    }
}
