package co.hyperverge.hvcamera;

import org.apache.fontbox.cmap.CMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f2844a;

    /* renamed from: b  reason: collision with root package name */
    public String f2845b;

    /* renamed from: c  reason: collision with root package name */
    public long f2846c;

    public b() {
        this.f2844a = 1;
        this.f2845b = "ms";
        this.f2846c = 0;
        this.f2846c = a();
    }

    public void a(String str, String str2) {
        (a() - this.f2846c) + CMap.SPACE + this.f2845b;
        this.f2846c = a();
    }

    public long a() {
        int i = this.f2844a;
        if (i == 1) {
            return System.currentTimeMillis();
        }
        if (i == 2) {
            return System.nanoTime() / 1000;
        }
        if (i != 3) {
            return System.currentTimeMillis();
        }
        return System.nanoTime();
    }
}
