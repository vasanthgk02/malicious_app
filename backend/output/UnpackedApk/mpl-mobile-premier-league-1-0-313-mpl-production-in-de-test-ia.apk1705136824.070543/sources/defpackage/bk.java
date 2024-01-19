package defpackage;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/* renamed from: bk  reason: default package */
public final class bk implements bm {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2792a = GeneratedOutlineSupport.outline36(bm.class, new StringBuilder(), ".instanceState");

    /* renamed from: a  reason: collision with other field name */
    public final bl f70a;

    /* renamed from: a  reason: collision with other field name */
    public final f f71a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<bn> f72a;

    /* renamed from: a  reason: collision with other field name */
    public final Set<InteractiveRequestRecord> f73a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public UUID f74a = UUID.randomUUID();

    public bk(bn bnVar) {
        f a2 = f.a();
        bl a3 = bl.a();
        this.f72a = new WeakReference<>(bnVar);
        this.f71a = a2;
        this.f70a = a3;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(f2792a);
            if (bundle2 != null) {
                cp.a((String) "bk", (String) "Restoring interactive state from saved instance state");
                String string = bundle2.getString("interactiveStateId");
                if (string != null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Reassigning interactive state ");
                    outline73.append(this.f74a);
                    outline73.append(" to ");
                    outline73.append(string);
                    outline73.toString();
                    this.f74a = UUID.fromString(string);
                }
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList("requestRecords");
                if (parcelableArrayList != null) {
                    this.f73a.addAll(parcelableArrayList);
                }
            }
        }
    }

    public synchronized void a(RequestContext requestContext) {
        boolean z = true;
        boolean z2 = this.f73a.size() > 0;
        boolean z3 = this.f71a.f129a.size() > 0;
        if (!z2 || !z3) {
            z = false;
        }
        if (z) {
            b(requestContext);
        } else {
            cp.a((String) "bk", "InteractiveState " + this.f74a + ": No responses to process");
        }
    }

    public synchronized void a(InteractiveRequestRecord interactiveRequestRecord) {
        String str = interactiveRequestRecord.a() == null ? "activity" : "fragment";
        cp.a((String) "bk", "InteractiveState " + this.f74a + ": Recording " + str + " request " + interactiveRequestRecord.getRequestId());
        this.f73a.add(interactiveRequestRecord);
    }

    public void b(Bundle bundle) {
        if (this.f73a.size() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("interactiveStateId", this.f74a.toString());
            bundle2.putParcelableArrayList("requestRecords", new ArrayList(this.f73a));
            bundle.putBundle(f2792a, bundle2);
            cp.a((String) "bk", "InteractiveState " + this.f74a + ": writing to save instance state");
        }
    }

    public void b(RequestContext requestContext) {
        boolean containsKey;
        LinkedList linkedList = new LinkedList();
        for (InteractiveRequestRecord next : this.f73a) {
            String requestId = next.getRequestId();
            f fVar = this.f71a;
            synchronized (fVar) {
                containsKey = fVar.f129a.containsKey(requestId);
            }
            if (containsKey) {
                Bundle a2 = next.a();
                Object a3 = a2 != null ? ((bn) this.f72a.get()).a(a2) : null;
                if (a3 == null) {
                    a3 = ((bn) this.f72a.get()).a();
                }
                RequestContext requestContext2 = this.f70a.f75a.get(a3);
                if (requestContext2 == requestContext) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("InteractiveState ");
                    outline73.append(this.f74a);
                    outline73.append(": Processing request ");
                    outline73.append(requestId);
                    cp.a((String) "bk", outline73.toString());
                    requestContext2.processResponse(next, this.f71a.a(requestId));
                    linkedList.add(next);
                }
            }
        }
        this.f73a.removeAll(linkedList);
    }
}
