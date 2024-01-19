package io.hansel.core;

import java.util.ArrayList;
import java.util.Iterator;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f5079b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<GetDataStatusListener> f5080a = new ArrayList<>();

    public static a a() {
        if (f5079b == null) {
            synchronized (a.class) {
                if (f5079b == null) {
                    f5079b = new a();
                }
            }
        }
        return f5079b;
    }

    public void a(GetDataStatusListener getDataStatusListener) {
        this.f5080a.add(getDataStatusListener);
    }

    public void b() {
        Iterator<GetDataStatusListener> it = this.f5080a.iterator();
        while (it.hasNext()) {
            it.next().onGetDataFinished();
        }
    }

    public void c() {
        Iterator<GetDataStatusListener> it = this.f5080a.iterator();
        while (it.hasNext()) {
            it.next().onGetDataStarted();
        }
    }
}
