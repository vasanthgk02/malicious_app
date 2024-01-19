package com.userexperior.e;

import java.util.concurrent.BlockingQueue;

public final class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f4002a = false;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<o<?>> f4003b;

    /* renamed from: c  reason: collision with root package name */
    public final j f4004c;

    /* renamed from: d  reason: collision with root package name */
    public final b f4005d;

    /* renamed from: e  reason: collision with root package name */
    public final u f4006e;

    public k(BlockingQueue<o<?>> blockingQueue, j jVar, b bVar, u uVar) {
        this.f4003b = blockingQueue;
        this.f4004c = jVar;
        this.f4005d = bVar;
        this.f4006e = uVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        r2 = com.userexperior.e.k.class;
        r2 = new java.lang.StringBuilder("issue in run: ");
        r0 = r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        r2.append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b2, code lost:
        r2 = com.userexperior.e.k.class;
        r2 = new java.lang.StringBuilder("issue in run: ");
        r0 = r1.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1 A[ExcHandler: OutOfMemoryError (r1v2 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            java.lang.String r0 = "issue in run: "
            r1 = 10
            android.os.Process.setThreadPriority(r1)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
        L_0x0007:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            java.util.concurrent.BlockingQueue<com.userexperior.e.o<?>> r3 = r9.f4003b     // Catch:{ InterruptedException -> 0x009c }
            java.lang.Object r3 = r3.take()     // Catch:{ InterruptedException -> 0x009c }
            com.userexperior.e.o r3 = (com.userexperior.e.o) r3     // Catch:{ InterruptedException -> 0x009c }
            r4 = 1
            java.lang.String r5 = "network-queue-take"
            r3.a(r5)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            boolean r5 = r3.m     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            if (r5 == 0) goto L_0x0023
            java.lang.String r5 = "network-discard-cancelled"
        L_0x001f:
            r3.b(r5)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            goto L_0x0007
        L_0x0023:
            int r5 = r3.i     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            android.net.TrafficStats.setThreadStatsTag(r5)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.j r5 = r9.f4004c     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.m r5 = r5.a(r3)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            java.lang.String r6 = "network-http-complete"
            r3.a(r6)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            boolean r6 = r5.f4010d     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            if (r6 == 0) goto L_0x003e
            boolean r6 = r3.n     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            if (r6 == 0) goto L_0x003e
            java.lang.String r5 = "not-modified"
            goto L_0x001f
        L_0x003e:
            com.userexperior.e.r r5 = r3.a(r5)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            java.lang.String r6 = "network-parse-complete"
            r3.a(r6)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            boolean r6 = r3.l     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            if (r6 == 0) goto L_0x005f
            com.userexperior.e.c r6 = r5.f4028b     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            if (r6 == 0) goto L_0x005f
            com.userexperior.e.b r6 = r9.f4005d     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            java.lang.String r7 = r3.c()     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.c r8 = r5.f4028b     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            r6.a(r7, r8)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            java.lang.String r6 = "network-cache-written"
            r3.a(r6)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
        L_0x005f:
            r3.n = r4     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.u r6 = r9.f4006e     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            r6.a(r3, r5)     // Catch:{ y -> 0x0089, Exception -> 0x0067, OutOfMemoryError -> 0x00a1 }
            goto L_0x0007
        L_0x0067:
            r5 = move-exception
            java.lang.String r6 = "Unhandled exception %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            r7 = 0
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            r4[r7] = r8     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.z.a(r5, r6, r4)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.y r4 = new com.userexperior.e.y     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            long r5 = r5 - r1
            r4.f4032b = r5     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.u r1 = r9.f4006e     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            r1.a(r3, r4)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            goto L_0x0007
        L_0x0089:
            r4 = move-exception
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            long r5 = r5 - r1
            r4.f4032b = r5     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.y r1 = com.userexperior.e.o.a(r4)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            com.userexperior.e.u r2 = r9.f4006e     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            r2.a(r3, r1)     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            goto L_0x0007
        L_0x009c:
            boolean r1 = r9.f4002a     // Catch:{ Exception -> 0x00b1, OutOfMemoryError -> 0x00a1 }
            if (r1 == 0) goto L_0x0007
            return
        L_0x00a1:
            r1 = move-exception
            java.lang.Class<com.userexperior.e.k> r2 = com.userexperior.e.k.class
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = r1.getMessage()
        L_0x00ad:
            r2.append(r0)
            return
        L_0x00b1:
            r1 = move-exception
            java.lang.Class<com.userexperior.e.k> r2 = com.userexperior.e.k.class
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.k.run():void");
    }
}
