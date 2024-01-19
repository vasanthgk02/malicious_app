package com.cardinalcommerce.cardinalmobilesdk;

import com.cardinalcommerce.cardinalmobilesdk.a.a.a;

public class Cardinal {

    /* renamed from: a  reason: collision with root package name */
    public static Cardinal f1839a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f1840b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static a f1841c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1842d;

    public static synchronized Cardinal getInstance() {
        Cardinal cardinal;
        synchronized (Cardinal.class) {
            if (f1839a == null) {
                synchronized (f1840b) {
                    if (f1839a == null) {
                        f1839a = new Cardinal();
                        f1841c = a.a();
                    }
                }
            }
            cardinal = f1839a;
        }
        return cardinal;
    }
}
