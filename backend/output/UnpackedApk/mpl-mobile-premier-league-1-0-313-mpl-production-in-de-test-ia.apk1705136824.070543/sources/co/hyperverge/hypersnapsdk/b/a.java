package co.hyperverge.hypersnapsdk.b;

import co.hyperverge.hypersnapsdk.b.g.e;

/* compiled from: DataRepository */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f3016a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3017b;

    public a() {
        if (e.f3047b == null) {
            e.f3047b = new e();
        }
        this.f3017b = e.f3047b;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f3016a == null) {
                    f3016a = new a();
                }
                aVar = f3016a;
            }
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b1 A[SYNTHETIC, Splitter:B:87:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, co.hyperverge.hypersnapsdk.objects.HVDocConfig r21, org.json.JSONObject r22, org.json.JSONObject r23, co.hyperverge.hypersnapsdk.listeners.APICompletionCallback r24) {
        /*
            r16 = this;
            r9 = r17
            r10 = r18
            r11 = r19
            r1 = r22
            r12 = r16
            r8 = r24
            co.hyperverge.hypersnapsdk.b.b r0 = r12.f3017b
            r7 = r0
            co.hyperverge.hypersnapsdk.b.g.e r7 = (co.hyperverge.hypersnapsdk.b.g.e) r7
            r2 = 0
            if (r7 == 0) goto L_0x020f
            java.lang.String r0 = "uuid"
            if (r8 != 0) goto L_0x001a
            goto L_0x020e
        L_0x001a:
            r3 = 6
            if (r9 != 0) goto L_0x0029
            co.hyperverge.hypersnapsdk.objects.HVError r0 = new co.hyperverge.hypersnapsdk.objects.HVError
            java.lang.String r1 = "Context object is null"
            r0.<init>(r3, r1)
            r8.onResult(r0, r2)
            goto L_0x020e
        L_0x0029:
            if (r11 == 0) goto L_0x0204
            java.lang.String r4 = r19.trim()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0204
            java.io.File r4 = new java.io.File
            r4.<init>(r11)
            boolean r4 = r4.exists()
            if (r4 != 0) goto L_0x0042
            goto L_0x0204
        L_0x0042:
            java.io.File r3 = new java.io.File
            r3.<init>(r11)
            java.lang.String r4 = ".pdf"
            boolean r4 = r11.contains(r4)
            java.lang.String r5 = "image/jpeg"
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = "application/pdf"
            java.lang.String r6 = "pdf"
            goto L_0x0059
        L_0x0056:
            java.lang.String r6 = "image"
            r4 = r5
        L_0x0059:
            okhttp3.MediaType r4 = okhttp3.MediaType.parse(r4)
            okhttp3.RequestBody r4 = okhttp3.RequestBody.create(r4, r3)
            java.lang.String r3 = r3.getName()
            okhttp3.MultipartBody$Part r4 = okhttp3.MultipartBody.Part.createFormData(r6, r3, r4)
            if (r21 == 0) goto L_0x0092
            boolean r3 = r21.isShouldReadQR()
            if (r3 == 0) goto L_0x0092
            boolean r3 = co.hyperverge.hypersnapsdk.c.k.a(r20)
            if (r3 != 0) goto L_0x0092
            java.io.File r3 = new java.io.File
            r6 = r20
            r3.<init>(r6)
            okhttp3.MediaType r5 = okhttp3.MediaType.parse(r5)
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create(r5, r3)
            java.lang.String r3 = r3.getName()
            java.lang.String r6 = "qrCroppedImage"
            okhttp3.MultipartBody$Part r3 = okhttp3.MultipartBody.Part.createFormData(r6, r3, r5)
            r5 = r3
            goto L_0x0093
        L_0x0092:
            r5 = r2
        L_0x0093:
            if (r23 != 0) goto L_0x009c
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r13 = r3
            goto L_0x009e
        L_0x009c:
            r13 = r23
        L_0x009e:
            r7.a(r13)
            java.lang.String r14 = co.hyperverge.hypersnapsdk.b.g.f.a(r11, r13)
            co.hyperverge.hypersnapsdk.HyperSnapSDK r3 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x00c0 }
            if (r3 == 0) goto L_0x00bf
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r3 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x00c0 }
            boolean r3 = r3.isShouldUseSignature()     // Catch:{ JSONException -> 0x00c0 }
            if (r3 == 0) goto L_0x00d8
            if (r14 == 0) goto L_0x00d8
            boolean r3 = r13.has(r0)     // Catch:{ JSONException -> 0x00c0 }
            if (r3 != 0) goto L_0x00d8
            r13.put(r0, r14)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x00d8
        L_0x00bf:
            throw r2     // Catch:{ JSONException -> 0x00c0 }
        L_0x00c0:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.f.i.a(r0)
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r6 = r3.i
            if (r6 != 0) goto L_0x00d3
            co.hyperverge.hypersnapsdk.service.a.a r6 = new co.hyperverge.hypersnapsdk.service.a.a
            r6.<init>(r9)
            r3.i = r6
        L_0x00d3:
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i
            r3.a(r0)
        L_0x00d8:
            if (r1 != 0) goto L_0x00db
            goto L_0x00ff
        L_0x00db:
            java.lang.String r0 = "dataLogging"
            boolean r3 = r1.has(r0)
            if (r3 == 0) goto L_0x00ff
            java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x00ed }
            java.lang.String r3 = "yes"
            r0.equals(r3)     // Catch:{ JSONException -> 0x00ed }
            goto L_0x00ff
        L_0x00ed:
            r0 = move-exception
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i
            if (r3 == 0) goto L_0x00ff
            co.hyperverge.hypersnapsdk.c.n r3 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r3 = r3.i
            r3.a(r0)
        L_0x00ff:
            java.util.Map r6 = r7.e(r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r1 = r13.toString()
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            java.lang.Object r0 = r0.fromJson(r1, r3)
            r3 = r0
            java.util.Map r3 = (java.util.Map) r3
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r0 == 0) goto L_0x0203
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r0 = r0.getAccessToken()
            if (r0 == 0) goto L_0x014e
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r0 == 0) goto L_0x014d
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r0 = r0.getAccessToken()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x014e
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r0 == 0) goto L_0x014c
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r0 = r0.getAccessToken()
            java.lang.String r1 = "Authorization"
            r3.put(r1, r0)
            goto L_0x0170
        L_0x014c:
            throw r2
        L_0x014d:
            throw r2
        L_0x014e:
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r0 == 0) goto L_0x0202
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r0 = r0.getAppId()
            java.lang.String r1 = "appId"
            r3.put(r1, r0)
            co.hyperverge.hypersnapsdk.HyperSnapSDK r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()
            if (r0 == 0) goto L_0x0201
            co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r0 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b
            java.lang.String r0 = r0.getAppKey()
            java.lang.String r1 = "appKey"
            r3.put(r1, r0)
        L_0x0170:
            if (r21 == 0) goto L_0x01a0
            boolean r0 = r21.isShouldReadQR()
            if (r0 == 0) goto L_0x01a0
            boolean r0 = co.hyperverge.hypersnapsdk.c.k.a(r18)
            if (r0 != 0) goto L_0x0190
            java.lang.String r0 = "/v1.1/readNID"
            boolean r0 = r10.contains(r0)
            if (r0 != 0) goto L_0x018e
            java.lang.String r0 = "/v2/nationalID"
            boolean r0 = r10.contains(r0)
            if (r0 == 0) goto L_0x0190
        L_0x018e:
            r0 = 1
            goto L_0x0191
        L_0x0190:
            r0 = 0
        L_0x0191:
            if (r0 == 0) goto L_0x01a0
            if (r5 == 0) goto L_0x01a0
            co.hyperverge.hypersnapsdk.b.g.b r1 = co.hyperverge.hypersnapsdk.b.g.a.b()
            r2 = r18
            retrofit2.Call r0 = r1.b(r2, r3, r4, r5, r6)
            goto L_0x01a8
        L_0x01a0:
            co.hyperverge.hypersnapsdk.b.g.b r0 = co.hyperverge.hypersnapsdk.b.g.a.b()
            retrofit2.Call r0 = r0.b(r10, r3, r4, r6)
        L_0x01a8:
            r15 = r0
            java.lang.String r0 = "referenceId"
            boolean r1 = r13.has(r0)
            if (r1 == 0) goto L_0x01cb
            r13.getString(r0)     // Catch:{ JSONException -> 0x01b5 }
            goto L_0x01cb
        L_0x01b5:
            r0 = move-exception
            r1 = r0
            r7.b(r1)
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
            if (r0 == 0) goto L_0x01cb
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
            r0.a(r1)
        L_0x01cb:
            co.hyperverge.hypersnapsdk.c.q r0 = new co.hyperverge.hypersnapsdk.c.q
            r0.<init>()
            co.hyperverge.hypersnapsdk.b.g.e$d r13 = new co.hyperverge.hypersnapsdk.b.g.e$d
            r1 = r13
            r2 = r7
            r3 = r14
            r4 = r18
            r5 = r17
            r6 = r19
            r7 = r0
            r8 = r24
            r1.<init>(r3, r4, r5, r6, r7, r8)
            r15.enqueue(r13)
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            boolean r0 = r0.o
            if (r0 == 0) goto L_0x020e
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.a.b r1 = r0.j
            if (r1 != 0) goto L_0x01fb
            co.hyperverge.hypersnapsdk.a.a r1 = new co.hyperverge.hypersnapsdk.a.a
            r1.<init>(r9)
            r0.j = r1
        L_0x01fb:
            co.hyperverge.hypersnapsdk.a.b r0 = r0.j
            r0.b(r10, r11)
            goto L_0x020e
        L_0x0201:
            throw r2
        L_0x0202:
            throw r2
        L_0x0203:
            throw r2
        L_0x0204:
            co.hyperverge.hypersnapsdk.objects.HVError r0 = new co.hyperverge.hypersnapsdk.objects.HVError
            java.lang.String r1 = "Document file path is null"
            r0.<init>(r3, r1)
            r8.onResult(r0, r2)
        L_0x020e:
            return
        L_0x020f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.b.a.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, co.hyperverge.hypersnapsdk.objects.HVDocConfig, org.json.JSONObject, org.json.JSONObject, co.hyperverge.hypersnapsdk.listeners.APICompletionCallback):void");
    }
}
