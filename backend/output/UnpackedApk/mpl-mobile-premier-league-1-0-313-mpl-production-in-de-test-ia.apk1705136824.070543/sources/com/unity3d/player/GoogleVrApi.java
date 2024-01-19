package com.unity3d.player;

import java.util.concurrent.atomic.AtomicReference;

public class GoogleVrApi {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicReference f3351a = new AtomicReference();

    public static void a() {
        f3351a.set(null);
    }

    public static void a(e eVar) {
        f3351a.compareAndSet(null, new GoogleVrProxy(eVar));
    }

    public static GoogleVrProxy b() {
        return (GoogleVrProxy) f3351a.get();
    }

    public static GoogleVrVideo getGoogleVrVideo() {
        return (GoogleVrVideo) f3351a.get();
    }
}
