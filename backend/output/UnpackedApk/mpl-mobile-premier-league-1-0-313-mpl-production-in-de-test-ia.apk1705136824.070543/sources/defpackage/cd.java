package defpackage;

import com.amazon.identity.auth.device.api.authorization.Region;

/* renamed from: cd  reason: default package */
public abstract class cd {

    /* renamed from: a  reason: collision with root package name */
    public static Region f2813a = Region.AUTO;

    public static synchronized Region a() {
        Region region;
        synchronized (cd.class) {
            try {
                region = f2813a;
            }
        }
        return region;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static z m276a() {
        return z.PROD;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m277a() {
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m278a() {
        return true;
    }
}
