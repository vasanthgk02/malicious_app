package com.freshchat.consumer.sdk.j.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.x;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

public final class b implements Closeable {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final File nR;
    public final File nS;
    public final File nT;
    public final int nU;
    public final long ol;
    public final int om;
    public long on = 0;
    public Writer oo;
    public final LinkedHashMap<String, C0028b> op = new LinkedHashMap<>(0, 0.75f, true);
    public int qF;
    public long qG = 0;
    public final ExecutorService qH;
    public final Callable<Void> qI;

    public final class a {
        public final C0028b rG;
        public boolean rH;

        /* renamed from: com.freshchat.consumer.sdk.j.a.b$a$a  reason: collision with other inner class name */
        public class C0027a extends FilterOutputStream {
            public C0027a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0027a(a aVar, OutputStream outputStream, c cVar) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.this.rH = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.this.rH = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    a.this.rH = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.rH = true;
                }
            }
        }

        public a(C0028b bVar) {
            this.rG = bVar;
        }

        public /* synthetic */ a(b bVar, C0028b bVar2, c cVar) {
            this(bVar2);
        }

        public void abort() throws IOException {
            b.this.a(this, false);
        }

        public void commit() throws IOException {
            if (this.rH) {
                b.this.a(this, false);
                b.this.remove(this.rG.key);
                return;
            }
            b.this.a(this, true);
        }

        public OutputStream x(int i) throws IOException {
            C0027a aVar;
            synchronized (b.this) {
                try {
                    if (this.rG.rL == this) {
                        aVar = new C0027a(this, new FileOutputStream(this.rG.z(i)), null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            return aVar;
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.j.a.b$b  reason: collision with other inner class name */
    public final class C0028b {
        public final String key;
        public final long[] rJ;
        public boolean rK;
        public a rL;
        public long rM;

        public C0028b(String str) {
            this.key = str;
            this.rJ = new long[b.this.om];
        }

        public /* synthetic */ C0028b(b bVar, String str, c cVar) {
            this(str);
        }

        /* access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length == b.this.om) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.rJ[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        private IOException c(String[] strArr) throws IOException {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unexpected journal line: ");
            outline73.append(Arrays.toString(strArr));
            throw new IOException(outline73.toString());
        }

        public String jW() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.rJ) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public File y(int i) {
            File f2 = b.this.nR;
            return new File(f2, this.key + "." + i);
        }

        public File z(int i) {
            File f2 = b.this.nR;
            return new File(f2, this.key + "." + i + ".tmp");
        }
    }

    public final class c implements Closeable {
        public final String key;
        public final long rM;
        public final InputStream[] rN;

        public c(String str, long j, InputStream[] inputStreamArr) {
            this.key = str;
            this.rM = j;
            this.rN = inputStreamArr;
        }

        public /* synthetic */ c(b bVar, String str, long j, InputStream[] inputStreamArr, c cVar) {
            this(str, j, inputStreamArr);
        }

        public InputStream ad(int i) {
            return this.rN[i];
        }

        public void close() {
            for (InputStream closeQuietly : this.rN) {
                b.closeQuietly(closeQuietly);
            }
        }
    }

    public b(File file, int i, int i2, long j) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.qH = threadPoolExecutor;
        this.qI = new c(this);
        this.nR = file2;
        this.nU = i;
        this.nS = new File(file2, MemoryLruCache.JOURNAL_FILE);
        this.nT = new File(file2, MemoryLruCache.JOURNAL_FILE_TEMP);
        this.om = i2;
        this.ol = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.freshchat.consumer.sdk.j.a.b.a a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.jU()     // Catch:{ all -> 0x0061 }
            r5.bG(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.freshchat.consumer.sdk.j.a.b$b> r0 = r5.op     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            com.freshchat.consumer.sdk.j.a.b$b r0 = (com.freshchat.consumer.sdk.j.a.b.C0028b) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.rM     // Catch:{ all -> 0x0061 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.freshchat.consumer.sdk.j.a.b$b r0 = new com.freshchat.consumer.sdk.j.a.b$b     // Catch:{ all -> 0x0061 }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.freshchat.consumer.sdk.j.a.b$b> r7 = r5.op     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            com.freshchat.consumer.sdk.j.a.b$a r7 = r0.rL     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            com.freshchat.consumer.sdk.j.a.b$a r7 = new com.freshchat.consumer.sdk.j.a.b$a     // Catch:{ all -> 0x0061 }
            r7.<init>(r5, r0, r3)     // Catch:{ all -> 0x0061 }
            r0.rL = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.oo     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.oo     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.b.a(java.lang.String, long):com.freshchat.consumer.sdk.j.a.b$a");
    }

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            b bVar = new b(file, i, i2, j);
            if (bVar.nS.exists()) {
                try {
                    bVar.jQ();
                    bVar.jR();
                    bVar.oo = new BufferedWriter(new FileWriter(bVar.nS, true), 8192);
                    return bVar;
                } catch (IOException unused) {
                    bVar.delete();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i, i2, j);
            bVar2.jS();
            return bVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z) throws IOException {
        C0028b a2 = aVar.rG;
        if (a2.rL == aVar) {
            if (z && !a2.rK) {
                int i = 0;
                while (i < this.om) {
                    if (a2.z(i).exists()) {
                        i++;
                    } else {
                        aVar.abort();
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.om; i2++) {
                File z2 = a2.z(i2);
                if (!z) {
                    b(z2);
                } else if (z2.exists()) {
                    File y = a2.y(i2);
                    z2.renameTo(y);
                    long j = a2.rJ[i2];
                    long length = y.length();
                    a2.rJ[i2] = length;
                    this.on = (this.on - j) + length;
                }
            }
            this.qF++;
            a2.rL = null;
            if (a2.rK || z) {
                a2.rK = true;
                this.oo.write("CLEAN " + a2.key + a2.jW() + 10);
                if (z) {
                    long j2 = this.qG;
                    this.qG = 1 + j2;
                    a2.rM = j2;
                }
            } else {
                this.op.remove(a2.key);
                this.oo.write("REMOVE " + a2.key + 10);
            }
            if (this.on > this.ol || jT()) {
                this.qH.submit(this.qI);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public static void b(File file) throws IOException {
        x.f(file);
    }

    private void bD(String str) throws IOException {
        String[] split = str.split(CMap.SPACE);
        if (split.length >= 2) {
            String str2 = split[1];
            if (!split[0].equals(MemoryLruCache.REMOVE) || split.length != 2) {
                C0028b bVar = this.op.get(str2);
                if (bVar == null) {
                    bVar = new C0028b(this, str2, null);
                    this.op.put(str2, bVar);
                }
                if (split[0].equals(MemoryLruCache.CLEAN) && split.length == this.om + 2) {
                    bVar.rK = true;
                    bVar.rL = null;
                    bVar.b((String[]) copyOfRange(split, 2, split.length));
                } else if (split[0].equals(MemoryLruCache.DIRTY) && split.length == 2) {
                    bVar.rL = new a(this, bVar, null);
                } else if (!split[0].equals(MemoryLruCache.READ) || split.length != 2) {
                    throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
                }
                return;
            }
            this.op.remove(str2);
            return;
        }
        throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
    }

    private void bG(String str) {
        if (str.contains(CMap.SPACE) || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("keys must not contain spaces or newlines: \"", str, "\""));
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i = length - 1;
                    if (sb.charAt(i) == 13) {
                        sb.setLength(i);
                    }
                }
                return sb.toString();
            } else {
                sb.append((char) read);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
            System.arraycopy(tArr, i, tArr2, 0, min);
            return tArr2;
        }
    }

    public static void deleteContents(File file) throws IOException {
        x.e(file);
    }

    private void jQ() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.nS), 8192);
        try {
            String c2 = c((InputStream) bufferedInputStream);
            String c3 = c((InputStream) bufferedInputStream);
            String c4 = c((InputStream) bufferedInputStream);
            String c5 = c((InputStream) bufferedInputStream);
            String c6 = c((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(c2) || !"1".equals(c3) || !Integer.toString(this.nU).equals(c4) || !Integer.toString(this.om).equals(c5) || !"".equals(c6)) {
                throw new IOException("unexpected journal header: [" + c2 + ", " + c3 + ", " + c5 + ", " + c6 + CMapParser.MARK_END_OF_ARRAY);
            }
            while (true) {
                try {
                    bD(c((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            closeQuietly(bufferedInputStream);
        }
    }

    private void jR() throws IOException {
        b(this.nT);
        Iterator<C0028b> it = this.op.values().iterator();
        while (it.hasNext()) {
            C0028b next = it.next();
            int i = 0;
            if (next.rL == null) {
                while (i < this.om) {
                    this.on += next.rJ[i];
                    i++;
                }
            } else {
                next.rL = null;
                while (i < this.om) {
                    b(next.y(i));
                    b(next.z(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void jS() throws IOException {
        String str;
        if (this.oo != null) {
            this.oo.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.nT), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.nU));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.om));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0028b a2 : this.op.values()) {
            if (a2.rL != null) {
                str = "DIRTY " + a2.key + 10;
            } else {
                str = "CLEAN " + a2.key + a2.jW() + 10;
            }
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
        this.nT.renameTo(this.nS);
        this.oo = new BufferedWriter(new FileWriter(this.nS, true), 8192);
    }

    /* access modifiers changed from: private */
    public boolean jT() {
        int i = this.qF;
        return i >= 2000 && i >= this.op.size();
    }

    private void jU() {
        if (this.oo == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.on > this.ol) {
            remove((String) this.op.entrySet().iterator().next().getKey());
        }
    }

    public synchronized c bE(String str) throws IOException {
        jU();
        bG(str);
        C0028b bVar = this.op.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.rK) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.om];
        int i = 0;
        while (i < this.om) {
            try {
                inputStreamArr[i] = new FileInputStream(bVar.y(i));
                i++;
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.qF++;
        this.oo.append("READ " + str + 10);
        if (jT()) {
            this.qH.submit(this.qI);
        }
        c cVar = new c(this, str, bVar.rM, inputStreamArr, null);
        return cVar;
    }

    public a bF(String str) throws IOException {
        return a(str, -1);
    }

    public synchronized void close() throws IOException {
        if (this.oo != null) {
            Iterator it = new ArrayList(this.op.values()).iterator();
            while (it.hasNext()) {
                C0028b bVar = (C0028b) it.next();
                if (bVar.rL != null) {
                    bVar.rL.abort();
                }
            }
            trimToSize();
            this.oo.close();
            this.oo = null;
        }
    }

    public void delete() throws IOException {
        close();
        deleteContents(this.nR);
    }

    public synchronized void flush() throws IOException {
        jU();
        trimToSize();
        this.oo.flush();
    }

    public boolean isClosed() {
        return this.oo == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.jU()     // Catch:{ all -> 0x008b }
            r7.bG(r8)     // Catch:{ all -> 0x008b }
            java.util.LinkedHashMap<java.lang.String, com.freshchat.consumer.sdk.j.a.b$b> r0 = r7.op     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008b }
            com.freshchat.consumer.sdk.j.a.b$b r0 = (com.freshchat.consumer.sdk.j.a.b.C0028b) r0     // Catch:{ all -> 0x008b }
            r1 = 0
            if (r0 == 0) goto L_0x0089
            com.freshchat.consumer.sdk.j.a.b$a r2 = r0.rL     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0019
            goto L_0x0089
        L_0x0019:
            int r2 = r7.om     // Catch:{ all -> 0x008b }
            if (r1 >= r2) goto L_0x0054
            java.io.File r2 = r0.y(r1)     // Catch:{ all -> 0x008b }
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x003d
            long r2 = r7.on     // Catch:{ all -> 0x008b }
            long[] r4 = r0.rJ     // Catch:{ all -> 0x008b }
            r5 = r4[r1]     // Catch:{ all -> 0x008b }
            long r2 = r2 - r5
            r7.on = r2     // Catch:{ all -> 0x008b }
            long[] r2 = r0.rJ     // Catch:{ all -> 0x008b }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008b }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x003d:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r0.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008b }
            r0.append(r2)     // Catch:{ all -> 0x008b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008b }
            r8.<init>(r0)     // Catch:{ all -> 0x008b }
            throw r8     // Catch:{ all -> 0x008b }
        L_0x0054:
            int r0 = r7.qF     // Catch:{ all -> 0x008b }
            r1 = 1
            int r0 = r0 + r1
            r7.qF = r0     // Catch:{ all -> 0x008b }
            java.io.Writer r0 = r7.oo     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x008b }
            r2.append(r8)     // Catch:{ all -> 0x008b }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008b }
            r0.append(r2)     // Catch:{ all -> 0x008b }
            java.util.LinkedHashMap<java.lang.String, com.freshchat.consumer.sdk.j.a.b$b> r0 = r7.op     // Catch:{ all -> 0x008b }
            r0.remove(r8)     // Catch:{ all -> 0x008b }
            boolean r8 = r7.jT()     // Catch:{ all -> 0x008b }
            if (r8 == 0) goto L_0x0087
            java.util.concurrent.ExecutorService r8 = r7.qH     // Catch:{ all -> 0x008b }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.qI     // Catch:{ all -> 0x008b }
            r8.submit(r0)     // Catch:{ all -> 0x008b }
        L_0x0087:
            monitor-exit(r7)
            return r1
        L_0x0089:
            monitor-exit(r7)
            return r1
        L_0x008b:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.b.remove(java.lang.String):boolean");
    }
}
