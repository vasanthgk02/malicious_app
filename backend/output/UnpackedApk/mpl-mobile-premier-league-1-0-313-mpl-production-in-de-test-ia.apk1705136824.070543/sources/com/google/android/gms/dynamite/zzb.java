package com.google.android.gms.dynamite;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzb {
    public static volatile ClassLoader zza;
    public static volatile Thread zzb;

    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            try {
                if (zza == null) {
                    zza = zzb();
                }
                classLoader = zza;
            }
        }
        return classLoader;
    }

    public static synchronized ClassLoader zzb() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (zzb == null) {
                zzb = zzc();
                if (zzb == null) {
                    return null;
                }
            }
            synchronized (zzb) {
                try {
                    classLoader = zzb.getContextClassLoader();
                } catch (SecurityException e2) {
                    e2.getMessage();
                }
            }
            return classLoader;
        }
    }

    public static synchronized Thread zzc() {
        Thread thread;
        Thread thread2;
        SecurityException e2;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i2];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i2++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i >= activeCount) {
                            thread = null;
                            break;
                        }
                        thread = threadArr[i];
                        if ("GmsDynamite".equals(thread.getName())) {
                            break;
                        }
                        i++;
                    }
                    if (thread == null) {
                        try {
                            thread2 = new zza(threadGroup);
                            try {
                                thread2.setContextClassLoader(null);
                                thread2.start();
                            } catch (SecurityException e3) {
                                e2 = e3;
                            }
                        } catch (SecurityException e4) {
                            e2 = e4;
                            thread2 = thread;
                            e2.getMessage();
                            thread = thread2;
                            return thread;
                        }
                        thread = thread2;
                    }
                } catch (SecurityException e5) {
                    e2 = e5;
                    thread2 = null;
                    e2.getMessage();
                    thread = thread2;
                    return thread;
                }
            }
            return thread;
        }
    }
}
