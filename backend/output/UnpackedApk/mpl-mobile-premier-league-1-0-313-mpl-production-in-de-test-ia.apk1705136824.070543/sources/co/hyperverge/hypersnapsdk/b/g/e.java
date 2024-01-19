package co.hyperverge.hypersnapsdk.b.g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.b.b;
import co.hyperverge.hypersnapsdk.b.b.a;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.d.a.a.d.C0058d;
import co.hyperverge.hypersnapsdk.listeners.APICompletionCallback;
import co.hyperverge.hypersnapsdk.model.LivenessResponse;
import co.hyperverge.hypersnapsdk.objects.HVError;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.objects.HVResponse;
import com.google.gson.Gson;
import com.mpl.androidapp.login.LoginReactModule;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: RemoteDataSource */
public class e extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f3047b;

    /* compiled from: RemoteDataSource */
    public class c implements Callback<ResponseBody> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HVFaceConfig f3049b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3050c;

        public c(String str, HVFaceConfig hVFaceConfig, a aVar) {
            this.f3048a = str;
            this.f3049b = hVFaceConfig;
            this.f3050c = aVar;
        }

        public void onFailure(Call<ResponseBody> call, Throwable th) {
            HVError hVError;
            a aVar = this.f3050c;
            String localizedMessage = th.getLocalizedMessage();
            C0058d dVar = (C0058d) aVar;
            if (dVar != null) {
                if (localizedMessage != null) {
                    try {
                        if (localizedMessage.contains("Certificate pinning")) {
                            hVError = new HVError(15, ((co.hyperverge.hypersnapsdk.d.a.a.c) co.hyperverge.hypersnapsdk.d.a.a.d.this.k).a(R$string.ssl_error));
                            if (n.m().o && n.m().j != null) {
                                n.m().j.a((LivenessResponse) null, hVError);
                            }
                            co.hyperverge.hypersnapsdk.d.a.a.d.this.a(hVError, (LivenessResponse) null);
                            return;
                        }
                    } catch (Exception e2) {
                        String str = co.hyperverge.hypersnapsdk.d.a.a.d.this.g;
                        co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                        if (n.m().i != null) {
                            n.m().i.a(e2);
                            return;
                        }
                        return;
                    }
                }
                if (co.hyperverge.hypersnapsdk.d.a.a.d.this != null) {
                    hVError = new HVError(12, localizedMessage);
                    n.m().j.a((LivenessResponse) null, hVError);
                    co.hyperverge.hypersnapsdk.d.a.a.d.this.a(hVError, (LivenessResponse) null);
                    return;
                }
                throw null;
            }
            throw null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[Catch:{ JSONException -> 0x0094, IOException -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[Catch:{ JSONException -> 0x0094, IOException -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[Catch:{ JSONException -> 0x0094, IOException -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[Catch:{ JSONException -> 0x0094, IOException -> 0x007e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(retrofit2.Call<okhttp3.ResponseBody> r9, retrofit2.Response<okhttp3.ResponseBody> r10) {
            /*
                r8 = this;
                co.hyperverge.hypersnapsdk.model.LivenessResponse r9 = new co.hyperverge.hypersnapsdk.model.LivenessResponse
                r9.<init>()
                okhttp3.Headers r0 = r10.headers()
                co.hyperverge.hypersnapsdk.b.g.e r1 = co.hyperverge.hypersnapsdk.b.g.e.this
                java.lang.String r2 = r8.f3048a
                org.json.JSONObject r1 = r1.a(r0, r2)
                r9.headers = r1
                int r2 = r10.code()
                r9.statusCode = r2
                boolean r2 = r10.isSuccessful()
                r3 = 0
                java.lang.String r4 = "X-HV-Raw-Response"
                r5 = 0
                if (r2 == 0) goto L_0x00a9
                T r2 = r10.body     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                okhttp3.ResponseBody r2 = (okhttp3.ResponseBody) r2     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                java.lang.String r2 = r2.string()     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                if (r6 == 0) goto L_0x007d
                co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                boolean r6 = r6.isShouldReturnRawResponse()     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                if (r6 == 0) goto L_0x003c
                r1.put(r4, r2)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
            L_0x003c:
                co.hyperverge.hypersnapsdk.b.g.e r6 = co.hyperverge.hypersnapsdk.b.g.e.this     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                co.hyperverge.hypersnapsdk.objects.HVFaceConfig r7 = r8.f3049b     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                java.lang.String r7 = r7.getLivenessEndpoint()     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                if (r6 == 0) goto L_0x007c
                java.lang.String r6 = "apac"
                boolean r6 = r7.contains(r6)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                if (r6 != 0) goto L_0x0059
                java.lang.String r6 = "zaf"
                boolean r6 = r7.contains(r6)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                if (r6 == 0) goto L_0x0057
                goto L_0x0059
            L_0x0057:
                r6 = 0
                goto L_0x005a
            L_0x0059:
                r6 = 1
            L_0x005a:
                if (r6 == 0) goto L_0x0063
                java.lang.String r6 = r8.f3048a     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                boolean r6 = co.hyperverge.hypersnapsdk.b.g.f.b(r2, r0, r6)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                goto L_0x0069
            L_0x0063:
                java.lang.String r6 = r8.f3048a     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                boolean r6 = co.hyperverge.hypersnapsdk.b.g.f.a(r2, r0, r6)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
            L_0x0069:
                if (r6 == 0) goto L_0x0073
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                r6.<init>(r2)     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                r9.response = r6     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                goto L_0x00a9
            L_0x0073:
                java.lang.String r2 = "Network tampering detected"
                r9.livenessError = r2     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                r2 = 18
                r9.statusCode = r2     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
                goto L_0x00a9
            L_0x007c:
                throw r5     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
            L_0x007d:
                throw r5     // Catch:{ JSONException -> 0x0094, IOException -> 0x007e }
            L_0x007e:
                r2 = move-exception
                co.hyperverge.hypersnapsdk.f.i.a(r2)
                co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
                if (r6 == 0) goto L_0x00a9
                co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
                r6.a(r2)
                goto L_0x00a9
            L_0x0094:
                r2 = move-exception
                co.hyperverge.hypersnapsdk.f.i.a(r2)
                co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
                if (r6 == 0) goto L_0x00a9
                co.hyperverge.hypersnapsdk.c.n r6 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r6 = r6.i
                r6.a(r2)
            L_0x00a9:
                okhttp3.ResponseBody r10 = r10.errorBody
                if (r10 == 0) goto L_0x00f8
                java.lang.String r10 = r10.string()     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                r2.<init>(r10)     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                co.hyperverge.hypersnapsdk.HyperSnapSDK r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.getInstance()     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                if (r6 == 0) goto L_0x00da
                co.hyperverge.hypersnapsdk.objects.HyperSnapSDKConfig r6 = co.hyperverge.hypersnapsdk.HyperSnapSDK.f2946b     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                boolean r6 = r6.isShouldReturnRawResponse()     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                if (r6 == 0) goto L_0x00c7
                r1.put(r4, r10)     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
            L_0x00c7:
                co.hyperverge.hypersnapsdk.b.g.e r1 = co.hyperverge.hypersnapsdk.b.g.e.this     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                r4.<init>(r10)     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                co.hyperverge.hypersnapsdk.b.g.e.a(r1, r9, r4)     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                java.lang.String r10 = "error"
                java.lang.String r10 = r2.getString(r10)     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                r9.livenessError = r10     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
                goto L_0x00f8
            L_0x00da:
                throw r5     // Catch:{ JSONException -> 0x00dd, IOException -> 0x00db }
            L_0x00db:
                r10 = move-exception
                goto L_0x00de
            L_0x00dd:
                r10 = move-exception
            L_0x00de:
                co.hyperverge.hypersnapsdk.f.i.a(r10)
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
                if (r1 == 0) goto L_0x00f2
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r1 = r1.i
                r1.a(r10)
            L_0x00f2:
                java.lang.String r10 = r10.getLocalizedMessage()
                r9.livenessError = r10
            L_0x00f8:
                co.hyperverge.hypersnapsdk.b.g.e r10 = co.hyperverge.hypersnapsdk.b.g.e.this     // Catch:{ Exception -> 0x0101 }
                java.lang.String r10 = r10.a(r0)     // Catch:{ Exception -> 0x0101 }
                r9.requestID = r10     // Catch:{ Exception -> 0x0101 }
                goto L_0x0116
            L_0x0101:
                r10 = move-exception
                co.hyperverge.hypersnapsdk.f.i.a(r10)
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
                if (r0 == 0) goto L_0x0116
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
                r0.a(r10)
            L_0x0116:
                co.hyperverge.hypersnapsdk.b.b$a r10 = r8.f3050c
                co.hyperverge.hypersnapsdk.d.a.a.d$d r10 = (co.hyperverge.hypersnapsdk.d.a.a.d.C0058d) r10
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                co.hyperverge.hypersnapsdk.c.q r1 = r10.f3172a
                java.lang.Long r1 = r1.c()
                long r1 = r1.longValue()
                r0.A = r1
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                r0.a(r3)
                r0 = 14
                int r1 = r9.statusCode
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 == r2) goto L_0x0174
                r2 = 422(0x1a6, float:5.91E-43)
                if (r1 == r2) goto L_0x0174
                java.lang.String r2 = r9.livenessError
                if (r2 == 0) goto L_0x0148
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                if (r0 == 0) goto L_0x0147
                co.hyperverge.hypersnapsdk.objects.HVError r0 = new co.hyperverge.hypersnapsdk.objects.HVError
                r0.<init>(r1, r2)
                goto L_0x0154
            L_0x0147:
                throw r5
            L_0x0148:
                co.hyperverge.hypersnapsdk.d.a.a.d r1 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                if (r1 == 0) goto L_0x0173
                co.hyperverge.hypersnapsdk.objects.HVError r1 = new co.hyperverge.hypersnapsdk.objects.HVError
                java.lang.String r2 = "Internal server error has occurred."
                r1.<init>(r0, r2)
                r0 = r1
            L_0x0154:
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                boolean r1 = r1.o
                if (r1 == 0) goto L_0x016d
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.a.b r1 = r1.j
                if (r1 == 0) goto L_0x016d
                co.hyperverge.hypersnapsdk.c.n r1 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.a.b r1 = r1.j
                r1.a(r5, r0)
            L_0x016d:
                co.hyperverge.hypersnapsdk.d.a.a.d r10 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                r10.a(r0, r9)
                goto L_0x01b8
            L_0x0173:
                throw r5
            L_0x0174:
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                boolean r0 = r0.o
                if (r0 == 0) goto L_0x0199
                co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.a.b r0 = r0.j
                if (r0 == 0) goto L_0x0199
                co.hyperverge.hypersnapsdk.c.q r0 = r10.f3172a
                java.lang.Long r0 = r0.c()
                long r0 = r0.longValue()
                co.hyperverge.hypersnapsdk.c.n r2 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.a.b r2 = r2.j
                java.lang.String r3 = r10.f3173b
                r2.a(r9, r3, r0)
            L_0x0199:
                co.hyperverge.hypersnapsdk.d.a.a.d r0 = co.hyperverge.hypersnapsdk.d.a.a.d.this
                java.lang.String r10 = r10.f3173b
                if (r0 == 0) goto L_0x01b9
                r0.a(r9, r10)     // Catch:{ Exception -> 0x01a3 }
                goto L_0x01b8
            L_0x01a3:
                r9 = move-exception
                co.hyperverge.hypersnapsdk.f.i.a(r9)
                co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
                if (r10 == 0) goto L_0x01b8
                co.hyperverge.hypersnapsdk.c.n r10 = co.hyperverge.hypersnapsdk.c.n.m()
                co.hyperverge.hypersnapsdk.service.a.b r10 = r10.i
                r10.a(r9)
            L_0x01b8:
                return
            L_0x01b9:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.b.g.e.c.onResponse(retrofit2.Call, retrofit2.Response):void");
        }
    }

    /* compiled from: RemoteDataSource */
    public class d implements Callback<ResponseBody> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3052a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3053b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f3054c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3055d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f3056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ APICompletionCallback f3057f;

        public d(String str, String str2, Context context, String str3, q qVar, APICompletionCallback aPICompletionCallback) {
            this.f3052a = str;
            this.f3053b = str2;
            this.f3054c = context;
            this.f3055d = str3;
            this.f3056e = qVar;
            this.f3057f = aPICompletionCallback;
        }

        public void onFailure(Call<ResponseBody> call, Throwable th) {
            HVError hVError;
            co.hyperverge.hypersnapsdk.f.i.a(th);
            if (th.getLocalizedMessage().contains("Certificate pinning")) {
                hVError = new HVError(15, "Secure connection could not be established.");
            } else {
                hVError = new HVError(12, th.getLocalizedMessage());
            }
            if (n.m().o) {
                n.m().a(this.f3054c).a((HVResponse) null, hVError);
            }
            this.f3057f.onResult(hVError, null);
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            boolean z;
            Headers headers = response.headers();
            JSONObject a2 = e.this.a(headers, this.f3052a);
            HVResponse hVResponse = new HVResponse();
            hVResponse.setApiHeaders(a2);
            if (response.isSuccessful()) {
                try {
                    String string = ((ResponseBody) response.body).string();
                    if (HyperSnapSDK.getInstance() != null) {
                        if (HyperSnapSDK.f2946b.isShouldReturnRawResponse()) {
                            a2.put("X-HV-Raw-Response", string);
                            hVResponse.setApiHeaders(a2);
                        }
                        if (this.f3053b.contains("apac")) {
                            z = f.b(string, headers, this.f3052a);
                        } else {
                            z = f.a(string, headers, this.f3052a);
                        }
                        if (z) {
                            JSONObject jSONObject = new JSONObject(string);
                            hVResponse.setApiResult(jSONObject);
                            e.a(e.this, hVResponse, jSONObject);
                            if (n.m().o) {
                                n.m().a(this.f3054c).a(hVResponse, this.f3055d, this.f3056e.c().longValue());
                            }
                            this.f3057f.onResult(null, hVResponse);
                        } else if (e.this != null) {
                            HVError hVError = new HVError(18, "Network tampering detected");
                            if (n.m().o) {
                                n.m().a(this.f3054c).a((HVResponse) null, hVError);
                            }
                            this.f3057f.onResult(hVError, hVResponse);
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } catch (Exception e2) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                    n.m().b(this.f3054c).a(e2);
                    HVError a3 = e.this.a(e2);
                    if (n.m().o) {
                        n.m().a(this.f3054c).a(hVResponse, a3);
                    }
                    this.f3057f.onResult(a3, hVResponse);
                }
            } else {
                try {
                    String string2 = response.errorBody.string();
                    JSONObject jSONObject2 = new JSONObject(string2);
                    e.a(e.this, hVResponse, jSONObject2);
                    if (HyperSnapSDK.getInstance() != null) {
                        if (HyperSnapSDK.f2946b.isShouldReturnRawResponse()) {
                            a2.put("X-HV-Raw-Response", string2);
                            hVResponse.setApiHeaders(a2);
                        }
                        HVError c2 = e.this.c(jSONObject2);
                        if (n.m().o) {
                            n.m().a(this.f3054c).a((HVResponse) null, c2);
                        }
                        this.f3057f.onResult(c2, hVResponse);
                    } else {
                        throw null;
                    }
                } catch (Exception e3) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                    n.m().b(this.f3054c).a(e3);
                    HVError a4 = e.this.a(e3);
                    if (n.m().o) {
                        n.m().a(this.f3054c).a((HVResponse) null, a4);
                    }
                    this.f3057f.onResult(a4, hVResponse);
                }
            }
        }
    }

    /* compiled from: RemoteDataSource */
    public class i implements Callback<ResponseBody> {
        public i(e eVar) {
        }

        public void onFailure(Call<ResponseBody> call, Throwable th) {
            co.hyperverge.hypersnapsdk.f.i.a(th);
            if (n.m().j != null) {
                n.m().j.c(new HVError(2, co.hyperverge.hypersnapsdk.f.i.a(th)));
            }
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                if (n.m().j != null) {
                    n.m().j.e();
                }
            } else if (n.m().j != null) {
                n.m().j.c(new HVError(2, "response.isSuccessful() is false"));
            }
        }
    }

    /* compiled from: RemoteDataSource */
    public class j implements Callback<ResponseBody> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ APICompletionCallback f3058a;

        public j(APICompletionCallback aPICompletionCallback) {
            this.f3058a = aPICompletionCallback;
        }

        public void onFailure(Call<ResponseBody> call, Throwable th) {
            co.hyperverge.hypersnapsdk.f.i.a(th);
            n.m().i.a(th);
            this.f3058a.onResult(new HVError(12, th.getLocalizedMessage()), null);
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            JSONObject a2 = e.this.a(response.headers(), null);
            HVResponse hVResponse = new HVResponse();
            hVResponse.setApiHeaders(a2);
            if (response.isSuccessful()) {
                try {
                    hVResponse.setApiResult(new JSONObject(((ResponseBody) response.body).string()));
                    this.f3058a.onResult(null, hVResponse);
                } catch (Exception e2) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e2);
                    this.f3058a.onResult(e.this.a(e2), hVResponse);
                }
            } else {
                try {
                    this.f3058a.onResult(e.this.c(new JSONObject(response.errorBody.string())), hVResponse);
                } catch (Exception e3) {
                    co.hyperverge.hypersnapsdk.f.i.a((Throwable) e3);
                    n.m().i.a(e3);
                    this.f3058a.onResult(e.this.a(e3), hVResponse);
                }
            }
        }
    }

    public HVError a(Exception exc) {
        exc.printStackTrace();
        return new HVError(2, exc.getLocalizedMessage());
    }

    public final void b(Exception exc) {
        try {
            if (!TextUtils.isEmpty(co.hyperverge.hypersnapsdk.f.i.a((Throwable) exc))) {
                co.hyperverge.hypersnapsdk.f.i.a((Throwable) exc);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[Catch:{ JSONException -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public co.hyperverge.hypersnapsdk.objects.HVError c(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "statusCode"
            java.lang.String r1 = "message"
            java.lang.String r2 = "result"
            java.lang.String r3 = "error"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            co.hyperverge.hypersnapsdk.objects.HVError r4 = new co.hyperverge.hypersnapsdk.objects.HVError
            r4.<init>()
            boolean r5 = r8.has(r3)     // Catch:{ JSONException -> 0x0052 }
            if (r5 == 0) goto L_0x001d
            java.lang.String r5 = r8.getString(r3)     // Catch:{ JSONException -> 0x0052 }
            goto L_0x001f
        L_0x001d:
            java.lang.String r5 = " "
        L_0x001f:
            boolean r6 = r8.has(r2)     // Catch:{ JSONException -> 0x0052 }
            if (r6 == 0) goto L_0x0034
            org.json.JSONObject r1 = r8.getJSONObject(r2)     // Catch:{ JSONException -> 0x0052 }
            boolean r2 = r1.has(r3)     // Catch:{ JSONException -> 0x0052 }
            if (r2 == 0) goto L_0x003f
            java.lang.String r1 = r1.getString(r3)     // Catch:{ JSONException -> 0x0052 }
            goto L_0x003e
        L_0x0034:
            boolean r2 = r8.has(r1)     // Catch:{ JSONException -> 0x0052 }
            if (r2 == 0) goto L_0x003f
            java.lang.String r1 = r8.getString(r1)     // Catch:{ JSONException -> 0x0052 }
        L_0x003e:
            r5 = r1
        L_0x003f:
            r1 = 14
            boolean r2 = r8.has(r0)     // Catch:{ JSONException -> 0x0052 }
            if (r2 == 0) goto L_0x004b
            int r1 = r8.getInt(r0)     // Catch:{ JSONException -> 0x0052 }
        L_0x004b:
            co.hyperverge.hypersnapsdk.objects.HVError r8 = new co.hyperverge.hypersnapsdk.objects.HVError     // Catch:{ JSONException -> 0x0052 }
            r8.<init>(r1, r5)     // Catch:{ JSONException -> 0x0052 }
            r4 = r8
            goto L_0x0067
        L_0x0052:
            r8 = move-exception
            r7.b(r8)
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
            if (r0 == 0) goto L_0x0067
            co.hyperverge.hypersnapsdk.c.n r0 = co.hyperverge.hypersnapsdk.c.n.m()
            co.hyperverge.hypersnapsdk.service.a.b r0 = r0.i
            r0.a(r8)
        L_0x0067:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.hypersnapsdk.b.g.e.c(org.json.JSONObject):co.hyperverge.hypersnapsdk.objects.HVError");
    }

    public Map<String, RequestBody> e(JSONObject jSONObject) {
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Map map = (Map) gson.fromJson(jSONObject.toString(), hashMap2.getClass());
        for (String str : map.keySet()) {
            hashMap.put(str, RequestBody.create(MediaType.parse("text/plain"), (String) map.get(str)));
        }
        return hashMap;
    }

    public JSONObject a(Headers headers, String str) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        while (i2 < headers.size()) {
            try {
                String name = headers.name(i2);
                String value = headers.value(i2);
                if (name.toLowerCase().startsWith("x-hv-")) {
                    jSONObject.put(name, value);
                }
                if (name.equalsIgnoreCase("x-request-id")) {
                    jSONObject.put("X-HV-Request-Id", value);
                }
                if (name.equalsIgnoreCase("x-response-signature")) {
                    jSONObject.put("X-HV-Response-Signature", value);
                }
                i2++;
            } catch (Exception e2) {
                b(e2);
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
                return null;
            }
        }
        if (HyperSnapSDK.getInstance() != null) {
            if (HyperSnapSDK.f2946b.isShouldUseSignature() && str != null) {
                jSONObject.put("X-HV-Request-Signature", str);
            }
            return jSONObject;
        }
        throw null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("transactionId") && jSONObject.getString("transactionId").equalsIgnoreCase("transactionId")) {
                jSONObject.remove("transactionId");
            }
        } catch (Exception e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        try {
            jSONObject.put("sdk-version", "3.6.38");
            jSONObject.put("os", "android");
            jSONObject.put("app-version", n.m().f3128b);
            jSONObject.put("device", Build.MODEL);
        } catch (Exception e3) {
            b(e3);
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
        }
        return jSONObject;
    }

    public String a(Headers headers) {
        String str;
        try {
            str = headers.get("X-Request-Id");
        } catch (Exception e2) {
            b(e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            str = CMap.SPACE;
        }
        if (str != null && !str.trim().isEmpty()) {
            return str;
        }
        try {
            return headers.get("X-HV-Request-Id");
        } catch (Exception e3) {
            b(e3);
            if (n.m().i == null) {
                return CMap.SPACE;
            }
            n.m().i.a(e3);
            return CMap.SPACE;
        }
    }

    public static void a(e eVar, LivenessResponse livenessResponse, JSONObject jSONObject) {
        if (eVar != null) {
            try {
                if (jSONObject.has(LoginReactModule.RESULT) && jSONObject.getJSONObject(LoginReactModule.RESULT).has("summary")) {
                    livenessResponse.response = jSONObject;
                }
            } catch (JSONException e2) {
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
        } else {
            throw null;
        }
    }

    public static HVResponse a(e eVar, HVResponse hVResponse, JSONObject jSONObject) {
        if (eVar != null) {
            try {
                if (jSONObject.has(LoginReactModule.RESULT)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(LoginReactModule.RESULT);
                    if (jSONObject2.has("summary")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("summary");
                        String string = jSONObject3.getString("action");
                        String string2 = jSONObject3.has("retakeMessage") ? jSONObject3.getString("retakeMessage") : "Some issue with the image capture. Please try again.";
                        hVResponse.setAction(string);
                        hVResponse.setRetakeMessage(string2);
                        hVResponse.setApiResult(jSONObject);
                    }
                }
            } catch (Exception e2) {
                if (n.m().i != null) {
                    n.m().i.a(e2);
                }
            }
            return hVResponse;
        }
        throw null;
    }
}
