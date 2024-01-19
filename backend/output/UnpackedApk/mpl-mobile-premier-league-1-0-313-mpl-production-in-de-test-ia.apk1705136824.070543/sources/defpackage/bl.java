package defpackage;

import com.amazon.identity.auth.device.api.workflow.RequestContext;
import java.util.WeakHashMap;

/* renamed from: bl  reason: default package */
public final class bl {

    /* renamed from: a  reason: collision with root package name */
    public static bl f2793a;

    /* renamed from: a  reason: collision with other field name */
    public final WeakHashMap<Object, RequestContext> f75a = new WeakHashMap<>();

    public static synchronized bl a() {
        bl blVar;
        synchronized (bl.class) {
            if (f2793a == null) {
                f2793a = new bl();
            }
            blVar = f2793a;
        }
        return blVar;
    }
}
