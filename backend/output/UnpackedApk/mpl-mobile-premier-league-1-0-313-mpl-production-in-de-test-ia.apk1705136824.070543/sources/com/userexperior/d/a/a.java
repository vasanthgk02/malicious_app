package com.userexperior.d.a;

import android.os.Looper;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class a extends Error {

    /* renamed from: a  reason: collision with root package name */
    public final long f3897a;

    public a(c cVar, long j) {
        super("detected an ANR in your app:", cVar);
        this.f3897a = j;
    }

    public static a a(long j) {
        Thread thread = Looper.getMainLooper().getThread();
        return new a(new c(new b(a(thread), thread.getStackTrace(), 0), null, 0), j);
    }

    public static a a(long j, String str, boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                Thread thread = (Thread) obj;
                Thread thread2 = (Thread) obj2;
                if (thread == thread2) {
                    return 0;
                }
                Thread thread3 = thread;
                if (thread == thread3) {
                    return 1;
                }
                if (thread2 == thread3) {
                    return -1;
                }
                return thread2.getName().compareTo(thread.getName());
            }
        });
        for (Entry next : Thread.getAllStackTraces().entrySet()) {
            if (next.getKey() == thread || (((Thread) next.getKey()).getName().startsWith(str) && (z || ((StackTraceElement[]) next.getValue()).length > 0))) {
                treeMap.put((Thread) next.getKey(), (StackTraceElement[]) next.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        c cVar = null;
        for (Entry entry : treeMap.entrySet()) {
            cVar = new c(new b(a((Thread) entry.getKey()), (StackTraceElement[]) entry.getValue(), 0), cVar, 0);
        }
        return new a(cVar, j);
    }

    public static String a(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
