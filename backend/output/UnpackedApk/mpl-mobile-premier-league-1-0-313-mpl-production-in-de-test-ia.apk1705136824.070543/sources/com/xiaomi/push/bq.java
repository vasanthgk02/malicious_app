package com.xiaomi.push;

public class bq extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bp f4504a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public bq(bp bpVar, String str) {
        // this.f4504a = bpVar;
        super(str);
    }

    public void run() {
        try {
            this.f4504a.f4503a.a();
        } catch (Exception e2) {
            this.f4504a.c(9, e2);
        }
    }
}
