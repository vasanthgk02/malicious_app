package io.hansel.visualizer.e.a.k;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f5902a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f5903b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void a(String str, String str2) {
        this.f5903b.put(str, str2);
    }

    public boolean a(String str) {
        return this.f5903b.containsKey(str);
    }

    public String c(String str) {
        String str2 = this.f5903b.get(str);
        return str2 == null ? "" : str2;
    }

    public Iterator<String> c() {
        return Collections.unmodifiableSet(this.f5903b.keySet()).iterator();
    }

    public byte[] d() {
        return this.f5902a;
    }
}
