package io.hansel.visualizer.e.a.k;

public class d extends g implements b {

    /* renamed from: c  reason: collision with root package name */
    public String f5900c = "*";

    public String a() {
        return this.f5900c;
    }

    public void b(String str) {
        if (str != null) {
            this.f5900c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
