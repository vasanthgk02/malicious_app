package com.userexperior.e.b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f3944a = new Comparator<byte[]>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((byte[]) obj).length - ((byte[]) obj2).length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public List<byte[]> f3945b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<byte[]> f3946c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    public int f3947d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f3948e;

    public b(int i) {
        this.f3948e = i;
    }

    private synchronized void a() {
        while (this.f3947d > this.f3948e) {
            byte[] remove = this.f3945b.remove(0);
            this.f3946c.remove(remove);
            this.f3947d -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f3948e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f3945b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f3946c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f3944a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f3946c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f3947d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f3947d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.b.a(byte[]):void");
    }

    public final synchronized byte[] a(int i) {
        int i2 = 0;
        while (i2 < this.f3946c.size()) {
            try {
                byte[] bArr = this.f3946c.get(i2);
                if (bArr.length >= i) {
                    this.f3947d -= bArr.length;
                    this.f3946c.remove(i2);
                    this.f3945b.remove(bArr);
                    return bArr;
                }
                i2++;
            }
        }
        return new byte[i];
    }
}
