package com.userexperior.e;

import java.util.concurrent.BlockingQueue;

public final class d extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3979b = z.f4034b;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3980a = false;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<o<?>> f3981c;

    /* renamed from: d  reason: collision with root package name */
    public final BlockingQueue<o<?>> f3982d;

    /* renamed from: e  reason: collision with root package name */
    public final b f3983e;

    /* renamed from: f  reason: collision with root package name */
    public final u f3984f;

    public d(BlockingQueue<o<?>> blockingQueue, BlockingQueue<o<?>> blockingQueue2, b bVar, u uVar) {
        this.f3981c = blockingQueue;
        this.f3982d = blockingQueue2;
        this.f3983e = bVar;
        this.f3984f = uVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (r10.f3980a != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00a0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            boolean r0 = f3979b     // Catch:{ Exception -> 0x00a5 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "start new dispatcher"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00a5 }
            com.userexperior.e.z.a(r0, r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x000d:
            r0 = 10
            android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x00a5 }
            com.userexperior.e.b r0 = r10.f3983e     // Catch:{ Exception -> 0x00a5 }
            r0.a()     // Catch:{ Exception -> 0x00a5 }
        L_0x0017:
            java.util.concurrent.BlockingQueue<com.userexperior.e.o<?>> r0 = r10.f3981c     // Catch:{ InterruptedException -> 0x00a0 }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.o r0 = (com.userexperior.e.o) r0     // Catch:{ InterruptedException -> 0x00a0 }
            java.lang.String r2 = "cache-queue-take"
            r0.a(r2)     // Catch:{ InterruptedException -> 0x00a0 }
            boolean r2 = r0.m     // Catch:{ InterruptedException -> 0x00a0 }
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = "cache-discard-canceled"
            r0.b(r2)     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x0017
        L_0x002e:
            com.userexperior.e.b r2 = r10.f3983e     // Catch:{ InterruptedException -> 0x00a0 }
            java.lang.String r3 = r0.c()     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.c r2 = r2.a(r3)     // Catch:{ InterruptedException -> 0x00a0 }
            if (r2 != 0) goto L_0x0045
            java.lang.String r2 = "cache-miss"
            r0.a(r2)     // Catch:{ InterruptedException -> 0x00a0 }
            java.util.concurrent.BlockingQueue<com.userexperior.e.o<?>> r2 = r10.f3982d     // Catch:{ InterruptedException -> 0x00a0 }
        L_0x0041:
            r2.put(r0)     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x0017
        L_0x0045:
            long r3 = r2.f3977e     // Catch:{ InterruptedException -> 0x00a0 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x00a0 }
            r7 = 1
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0052
            r3 = 1
            goto L_0x0053
        L_0x0052:
            r3 = 0
        L_0x0053:
            if (r3 == 0) goto L_0x005f
            java.lang.String r3 = "cache-hit-expired"
            r0.a(r3)     // Catch:{ InterruptedException -> 0x00a0 }
            r0.p = r2     // Catch:{ InterruptedException -> 0x00a0 }
            java.util.concurrent.BlockingQueue<com.userexperior.e.o<?>> r2 = r10.f3982d     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x0041
        L_0x005f:
            java.lang.String r3 = "cache-hit"
            r0.a(r3)     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.m r3 = new com.userexperior.e.m     // Catch:{ InterruptedException -> 0x00a0 }
            byte[] r4 = r2.f3973a     // Catch:{ InterruptedException -> 0x00a0 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r2.g     // Catch:{ InterruptedException -> 0x00a0 }
            r3.<init>(r4, r5)     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.r r3 = r0.a(r3)     // Catch:{ InterruptedException -> 0x00a0 }
            java.lang.String r4 = "cache-hit-parsed"
            r0.a(r4)     // Catch:{ InterruptedException -> 0x00a0 }
            long r4 = r2.f3978f     // Catch:{ InterruptedException -> 0x00a0 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x00a0 }
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0082
            r4 = 1
            goto L_0x0083
        L_0x0082:
            r4 = 0
        L_0x0083:
            if (r4 != 0) goto L_0x008b
            com.userexperior.e.u r2 = r10.f3984f     // Catch:{ InterruptedException -> 0x00a0 }
            r2.a(r0, r3)     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x0017
        L_0x008b:
            java.lang.String r4 = "cache-hit-refresh-needed"
            r0.a(r4)     // Catch:{ InterruptedException -> 0x00a0 }
            r0.p = r2     // Catch:{ InterruptedException -> 0x00a0 }
            r3.f4030d = r7     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.u r2 = r10.f3984f     // Catch:{ InterruptedException -> 0x00a0 }
            com.userexperior.e.d$1 r4 = new com.userexperior.e.d$1     // Catch:{ InterruptedException -> 0x00a0 }
            r4.<init>(r0)     // Catch:{ InterruptedException -> 0x00a0 }
            r2.a(r0, r3, r4)     // Catch:{ InterruptedException -> 0x00a0 }
            goto L_0x0017
        L_0x00a0:
            boolean r0 = r10.f3980a     // Catch:{ Exception -> 0x00a5 }
            if (r0 == 0) goto L_0x0017
            return
        L_0x00a5:
            r0 = move-exception
            java.lang.Class<com.userexperior.e.d> r1 = com.userexperior.e.d.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "issue in run: "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.d.run():void");
    }
}
