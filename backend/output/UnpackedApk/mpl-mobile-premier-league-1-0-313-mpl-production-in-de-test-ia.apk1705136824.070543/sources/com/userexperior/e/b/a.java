package com.userexperior.e.b;

import com.userexperior.e.j;
import com.userexperior.e.o;
import com.userexperior.e.v;
import com.userexperior.e.w;
import com.userexperior.e.y;
import com.userexperior.e.z;
import java.io.IOException;
import java.io.InputStream;

public final class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3939a = z.f4034b;

    /* renamed from: d  reason: collision with root package name */
    public static int f3940d = 6000;

    /* renamed from: e  reason: collision with root package name */
    public static int f3941e = 4096;

    /* renamed from: b  reason: collision with root package name */
    public final g f3942b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3943c;

    public a(g gVar) {
        this(gVar, new b(f3941e));
    }

    public a(g gVar, b bVar) {
        this.f3942b = gVar;
        this.f3943c = bVar;
    }

    public static void a(String str, o<?> oVar, y yVar) throws y {
        v vVar = oVar.o;
        int h = oVar.h();
        try {
            vVar.a(yVar);
            oVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(h)}));
        } catch (y e2) {
            oVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(h)}));
            throw e2;
        }
    }

    private byte[] a(com.userexperior.e.a.a aVar) throws IOException, w {
        j jVar = new j(this.f3943c, (int) ((long) aVar.f3926c));
        byte[] bArr = null;
        try {
            InputStream inputStream = aVar.f3925b;
            if (inputStream != null) {
                bArr = this.f3943c.a(1024);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    jVar.write(bArr, 0, read);
                }
                return jVar.toByteArray();
            }
            throw new w();
        } finally {
            try {
                aVar.a();
            } catch (Exception unused) {
                z.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f3943c.a(bArr);
            jVar.close();
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r7v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r15v5 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r0v32, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v34, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r7v23 */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r15v7 */
    /* JADX WARNING: type inference failed for: r15v8 */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: type inference failed for: r0v47 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r7v27 */
    /* JADX INFO: used method not loaded: com.userexperior.e.l.<init>(byte):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0168, code lost:
        r6 = new java.lang.Object[r14];
        r6[0] = r2.g;
        r6[1] = "mentioned url";
        com.userexperior.e.z.c("Request at %s has been redirected to %s", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0177, code lost:
        if (r7 != 0) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0179, code lost:
        r5 = new com.userexperior.e.m(r0, r7, r12, false, android.os.SystemClock.elapsedRealtime() - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x018a, code lost:
        if (r0 == 401) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0193, code lost:
        if (r0 == 301) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x019f, code lost:
        throw new com.userexperior.e.w(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01a0, code lost:
        r0 = new com.userexperior.e.a(r5);
        r5 = "redirect";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01a8, code lost:
        r0 = new com.userexperior.e.a(r5);
        r5 = "auth";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b6, code lost:
        throw new com.userexperior.e.l(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01bc, code lost:
        throw new com.userexperior.e.n(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01bd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01d5, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r28.c(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d6, code lost:
        r0 = new com.userexperior.e.x();
        r5 = "socket";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01de, code lost:
        a(r5, r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r13 = null;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d2, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0125, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0126, code lost:
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012f, code lost:
        r0 = e;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0131, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0132, code lost:
        r15 = r10;
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0134, code lost:
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0138, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0139, code lost:
        r13 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x013a, code lost:
        r14 = 2;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x013e, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0143, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0144, code lost:
        r14 = 2;
        r13 = null;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0149, code lost:
        r0 = r13.f3929a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x014f, code lost:
        if (r0 == 301) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0156, code lost:
        r6 = new java.lang.Object[r14];
        r6[0] = java.lang.Integer.valueOf(r0);
        r6[1] = "mentioned url";
        com.userexperior.e.z.c("Unexpected response code %d for %s", r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r15v3
      assigns: []
      uses: []
      mth insns count: 189
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01bd A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01b7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013d A[ExcHandler: OutOfMemoryError (r0v10 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:2:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0149  */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.userexperior.e.m a(com.userexperior.e.o<?> r28) throws com.userexperior.e.y {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r14 = 302(0x12e, float:4.23E-43)
            r10 = 2
            r11 = 301(0x12d, float:4.22E-43)
            r9 = 0
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0143, OutOfMemoryError -> 0x013d }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0143, OutOfMemoryError -> 0x013d }
            com.userexperior.e.c r5 = r2.p     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0143, OutOfMemoryError -> 0x013d }
            if (r5 == 0) goto L_0x0046
            java.lang.String r6 = r5.f3974b     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            if (r6 == 0) goto L_0x0027
            java.lang.String r6 = "If-None-Match"
            java.lang.String r7 = r5.f3974b     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            r0.put(r6, r7)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
        L_0x0027:
            long r6 = r5.f3976d     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            r16 = 0
            int r8 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0046
            java.util.Date r6 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            long r7 = r5.f3976d     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            java.lang.String r5 = "If-Modified-Since"
            java.lang.String r6 = com.userexperior.e.h.a(r6)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            r0.put(r5, r6)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0040, OutOfMemoryError -> 0x013d }
            goto L_0x0046
        L_0x0040:
            r0 = move-exception
            r7 = 0
            r13 = 0
        L_0x0043:
            r14 = 2
            goto L_0x0147
        L_0x0046:
            com.userexperior.e.b.g r5 = r1.f3942b     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0143, OutOfMemoryError -> 0x013d }
            com.userexperior.e.a.b r8 = r5.a(r2, r0)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0143, OutOfMemoryError -> 0x013d }
            java.util.Map<java.lang.String, java.lang.String> r0 = r8.f3931c     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0138, OutOfMemoryError -> 0x013d }
            r12.putAll(r0)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0138, OutOfMemoryError -> 0x013d }
            int r6 = r8.f3929a     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0138, OutOfMemoryError -> 0x013d }
            r0 = 304(0x130, float:4.26E-43)
            if (r6 != r0) goto L_0x009e
            com.userexperior.e.c r0 = r2.p     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x009a, OutOfMemoryError -> 0x013d }
            if (r0 != 0) goto L_0x0076
            com.userexperior.e.m r0 = new com.userexperior.e.m     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x009a, OutOfMemoryError -> 0x013d }
            r6 = 304(0x130, float:4.26E-43)
            r7 = 0
            r16 = 1
            long r17 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x009a, OutOfMemoryError -> 0x013d }
            long r17 = r17 - r3
            r5 = r0
            r13 = r8
            r8 = r12
            r15 = 0
            r9 = r16
            r15 = 301(0x12d, float:4.22E-43)
            r10 = r17
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            return r0
        L_0x0076:
            r13 = r8
            r15 = 301(0x12d, float:4.22E-43)
            java.util.Map<java.lang.String, java.lang.String> r5 = r0.g     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            r5.putAll(r12)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            com.userexperior.e.m r5 = new com.userexperior.e.m     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            r21 = 304(0x130, float:4.26E-43)
            byte[] r6 = r0.f3973a     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.g     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            r24 = 1
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            long r25 = r7 - r3
            r20 = r5
            r22 = r6
            r23 = r0
            r20.<init>(r21, r22, r23, r24, r25)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            return r5
        L_0x0098:
            r0 = move-exception
            goto L_0x009c
        L_0x009a:
            r0 = move-exception
            r13 = r8
        L_0x009c:
            r7 = 0
            goto L_0x0043
        L_0x009e:
            r13 = r8
            r15 = 301(0x12d, float:4.22E-43)
            if (r6 == r15) goto L_0x00a5
            if (r6 != r14) goto L_0x00af
        L_0x00a5:
            java.lang.String r0 = "Location"
            java.lang.Object r0 = r12.get(r0)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0136, OutOfMemoryError -> 0x013d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0136, OutOfMemoryError -> 0x013d }
            r2.h = r0     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0136, OutOfMemoryError -> 0x013d }
        L_0x00af:
            com.userexperior.e.a.a r0 = r13.f3930b     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0136, OutOfMemoryError -> 0x013d }
            if (r0 == 0) goto L_0x00ba
            com.userexperior.e.a.a r0 = r13.f3930b     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            byte[] r0 = r1.a(r0)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0098, OutOfMemoryError -> 0x013d }
            goto L_0x00bd
        L_0x00ba:
            r5 = 0
            byte[] r0 = new byte[r5]     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0136, OutOfMemoryError -> 0x013d }
        L_0x00bd:
            r10 = r0
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            long r7 = r7 - r3
            boolean r0 = f3939a     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            if (r0 != 0) goto L_0x00d5
            int r0 = f3940d     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x00d1, OutOfMemoryError -> 0x013d }
            long r14 = (long) r0
            int r0 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            r14 = 2
            goto L_0x010a
        L_0x00d1:
            r0 = move-exception
            r7 = r10
            goto L_0x0043
        L_0x00d5:
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r5 = 5
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            r9 = 0
            r5[r9] = r2     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            r8 = 1
            r5[r8] = r7     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0131, OutOfMemoryError -> 0x013d }
            if (r10 == 0) goto L_0x00ec
            int r7 = r10.length     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x00d1, OutOfMemoryError -> 0x013d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x00d1, OutOfMemoryError -> 0x013d }
            goto L_0x00ee
        L_0x00ec:
            java.lang.String r7 = "null"
        L_0x00ee:
            r14 = 2
            r5[r14] = r7     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            r7 = 3
            int r8 = r13.f3929a     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            r5[r7] = r8     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            r7 = 4
            com.userexperior.e.v r8 = r2.o     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            int r8 = r8.b()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            r5[r7] = r8     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            com.userexperior.e.z.b(r0, r5)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
        L_0x010a:
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 < r0) goto L_0x0128
            r0 = 299(0x12b, float:4.19E-43)
            if (r6 > r0) goto L_0x0128
            com.userexperior.e.m r0 = new com.userexperior.e.m     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            r9 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x0125, OutOfMemoryError -> 0x013d }
            long r19 = r7 - r3
            r5 = r0
            r7 = r10
            r8 = r12
            r15 = r10
            r10 = r19
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x012f, OutOfMemoryError -> 0x013d }
            return r0
        L_0x0125:
            r0 = move-exception
            r15 = r10
            goto L_0x0134
        L_0x0128:
            r15 = r10
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x012f, OutOfMemoryError -> 0x013d }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x012f, OutOfMemoryError -> 0x013d }
            throw r0     // Catch:{ SocketTimeoutException -> 0x01d6, MalformedURLException -> 0x01bd, IOException -> 0x012f, OutOfMemoryError -> 0x013d }
        L_0x012f:
            r0 = move-exception
            goto L_0x0134
        L_0x0131:
            r0 = move-exception
            r15 = r10
            r14 = 2
        L_0x0134:
            r7 = r15
            goto L_0x0147
        L_0x0136:
            r0 = move-exception
            goto L_0x013a
        L_0x0138:
            r0 = move-exception
            r13 = r8
        L_0x013a:
            r14 = 2
            r7 = 0
            goto L_0x0147
        L_0x013d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0008
        L_0x0143:
            r0 = move-exception
            r14 = 2
            r7 = 0
            r13 = 0
        L_0x0147:
            if (r13 == 0) goto L_0x01b7
            int r0 = r13.f3929a
            java.lang.String r5 = "mentioned url"
            r6 = 301(0x12d, float:4.22E-43)
            if (r0 == r6) goto L_0x0168
            r6 = 302(0x12e, float:4.23E-43)
            if (r0 != r6) goto L_0x0156
            goto L_0x0168
        L_0x0156:
            java.lang.Object[] r6 = new java.lang.Object[r14]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r9 = 0
            r6[r9] = r8
            r8 = 1
            r6[r8] = r5
            java.lang.String r5 = "Unexpected response code %d for %s"
            com.userexperior.e.z.c(r5, r6)
            goto L_0x0177
        L_0x0168:
            r8 = 1
            r9 = 0
            java.lang.Object[] r6 = new java.lang.Object[r14]
            java.lang.String r10 = r2.g
            r6[r9] = r10
            r6[r8] = r5
            java.lang.String r5 = "Request at %s has been redirected to %s"
            com.userexperior.e.z.c(r5, r6)
        L_0x0177:
            if (r7 == 0) goto L_0x01b0
            com.userexperior.e.m r13 = new com.userexperior.e.m
            r9 = 0
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r10 = r5 - r3
            r5 = r13
            r6 = r0
            r8 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r5 = 401(0x191, float:5.62E-43)
            if (r0 == r5) goto L_0x01a8
            r5 = 403(0x193, float:5.65E-43)
            if (r0 != r5) goto L_0x0191
            goto L_0x01a8
        L_0x0191:
            r5 = 301(0x12d, float:4.22E-43)
            if (r0 == r5) goto L_0x01a0
            r5 = 302(0x12e, float:4.23E-43)
            if (r0 != r5) goto L_0x019a
            goto L_0x01a0
        L_0x019a:
            com.userexperior.e.w r0 = new com.userexperior.e.w
            r0.<init>(r13)
            throw r0
        L_0x01a0:
            com.userexperior.e.a r0 = new com.userexperior.e.a
            r0.<init>(r13)
            java.lang.String r5 = "redirect"
            goto L_0x01de
        L_0x01a8:
            com.userexperior.e.a r0 = new com.userexperior.e.a
            r0.<init>(r13)
            java.lang.String r5 = "auth"
            goto L_0x01de
        L_0x01b0:
            com.userexperior.e.l r0 = new com.userexperior.e.l
            r2 = 0
            r0.<init>(r2)
            throw r0
        L_0x01b7:
            com.userexperior.e.n r2 = new com.userexperior.e.n
            r2.<init>(r0)
            throw r2
        L_0x01bd:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Bad URL "
            r4.<init>(r5)
            java.lang.String r2 = r28.c()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2, r0)
            throw r3
        L_0x01d6:
            com.userexperior.e.x r0 = new com.userexperior.e.x
            r0.<init>()
            java.lang.String r5 = "socket"
        L_0x01de:
            a(r5, r2, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.a.a(com.userexperior.e.o):com.userexperior.e.m");
    }
}
