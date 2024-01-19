package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

public class am extends ag {

    /* renamed from: a  reason: collision with root package name */
    public ag f4409a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ak f258a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ag f4410b;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public am(ak akVar, String str, ag agVar) {
        // this.f258a = akVar;
        // this.f4410b = agVar;
        super(str);
        ag agVar2 = this.f4410b;
        this.f4409a = agVar2;
        this.f244b = this.f244b;
        if (agVar2 != null) {
            this.f4401f = agVar2.f4401f;
        }
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f4409a != null) {
            arrayList.addAll(this.f4409a.a(true));
        }
        synchronized (ak.f4405b) {
            ag agVar = ak.f4405b.get(this.f244b);
            if (agVar != null) {
                Iterator<String> it = agVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f244b);
                arrayList.add(this.f244b);
            }
        }
        return arrayList;
    }

    public synchronized void a(String str, af afVar) {
        if (this.f4409a != null) {
            this.f4409a.a(str, afVar);
        }
    }

    public boolean b() {
        return false;
    }
}
