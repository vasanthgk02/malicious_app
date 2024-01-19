package com.paynimo.android.payment.b;

import android.content.Context;
import com.paynimo.android.payment.event.a0;
import com.paynimo.android.payment.event.c0;
import com.paynimo.android.payment.event.q;
import com.paynimo.android.payment.event.r;
import com.paynimo.android.payment.event.s;
import com.paynimo.android.payment.event.t;
import com.paynimo.android.payment.event.u;
import com.paynimo.android.payment.event.v;
import com.paynimo.android.payment.event.w;
import com.paynimo.android.payment.event.x;
import com.paynimo.android.payment.event.y;
import com.paynimo.android.payment.event.z;
import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.response.ResponsePayload;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public a f1403a;

    public class a implements Callback<ResponsePayload> {
        public a(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.d(responsePayload));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.c(error));
                    }
                }
            }
        }
    }

    public class b implements Callback<com.paynimo.android.payment.model.response.e> {
        public b(d dVar) {
        }

        public void onFailure(Call<com.paynimo.android.payment.model.response.e> call, Throwable th) {
        }

        public void onResponse(Call<com.paynimo.android.payment.model.response.e> call, Response<com.paynimo.android.payment.model.response.e> response) {
            if (response != null) {
                com.paynimo.android.payment.model.response.e eVar = (com.paynimo.android.payment.model.response.e) response.body;
                if (eVar != null) {
                    String errorCode = eVar.getErrorCode();
                    if (errorCode == null || errorCode.isEmpty() || !errorCode.equalsIgnoreCase("0")) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.e(eVar));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.f(eVar));
                    }
                }
            }
        }
    }

    public class c implements Callback<Void> {
        public c(d dVar) {
        }

        public void onFailure(Call<Void> call, Throwable th) {
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            if (response != null) {
                Void voidR = (Void) response.body;
            }
        }
    }

    /* renamed from: com.paynimo.android.payment.b.d$d  reason: collision with other inner class name */
    public class C0018d implements Callback<com.paynimo.android.payment.model.response.c> {
        public C0018d(d dVar) {
        }

        public void onFailure(Call<com.paynimo.android.payment.model.response.c> call, Throwable th) {
        }

        public void onResponse(Call<com.paynimo.android.payment.model.response.c> call, Response<com.paynimo.android.payment.model.response.c> response) {
            if (response != null) {
                com.paynimo.android.payment.model.response.c cVar = (com.paynimo.android.payment.model.response.c) response.body;
                if (cVar != null) {
                    String allowed = cVar.getAllowed();
                    if (allowed == null || allowed.isEmpty() || allowed.equalsIgnoreCase("no")) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.a(cVar));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.b(cVar));
                    }
                } else {
                    EventBus.getDefault().post(new com.paynimo.android.payment.event.b(cVar));
                }
            }
        }
    }

    public class e implements Callback<com.paynimo.android.payment.model.response.c> {
        public e(d dVar) {
        }

        public void onFailure(Call<com.paynimo.android.payment.model.response.c> call, Throwable th) {
        }

        public void onResponse(Call<com.paynimo.android.payment.model.response.c> call, Response<com.paynimo.android.payment.model.response.c> response) {
            if (response != null) {
                com.paynimo.android.payment.model.response.c cVar = (com.paynimo.android.payment.model.response.c) response.body;
                if (cVar != null) {
                    String allowed = cVar.getAllowed();
                    if (allowed == null || allowed.isEmpty() || allowed.equalsIgnoreCase("no")) {
                        EventBus.getDefault().post(new v(cVar));
                    } else {
                        EventBus.getDefault().post(new w(cVar));
                    }
                } else {
                    EventBus.getDefault().post(new w(cVar));
                }
            }
        }
    }

    public class f implements Callback<ResponsePayload> {
        public f(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new s(responsePayload));
                    } else {
                        EventBus.getDefault().post(new r(error));
                    }
                }
            }
        }
    }

    public class g implements Callback<ResponsePayload> {
        public g(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
            com.paynimo.android.payment.model.response.d dVar = new com.paynimo.android.payment.model.response.d();
            dVar.setCode(Constant.TAG_ERROR_SERVER_DOWN);
            dVar.setDesc(th.getLocalizedMessage());
            EventBus.getDefault().post(new com.paynimo.android.payment.event.l(dVar));
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.m(responsePayload));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.l(error));
                    }
                }
            }
        }
    }

    public class h implements Callback<ResponsePayload> {
        public h(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
            com.paynimo.android.payment.model.response.d dVar = new com.paynimo.android.payment.model.response.d();
            dVar.setCode(Constant.TAG_ERROR_SERVER_DOWN);
            dVar.setDesc(th.getLocalizedMessage());
            EventBus.getDefault().post(new com.paynimo.android.payment.event.j(dVar));
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.k(responsePayload));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.j(error));
                    }
                }
            }
        }
    }

    public class i implements Callback<com.paynimo.android.payment.model.response.k.r> {
        public i(d dVar) {
        }

        public void onFailure(Call<com.paynimo.android.payment.model.response.k.r> call, Throwable th) {
        }

        public void onResponse(Call<com.paynimo.android.payment.model.response.k.r> call, Response<com.paynimo.android.payment.model.response.k.r> response) {
            if (response != null && response.isSuccessful()) {
                T t = response.body;
                if (t != null) {
                    com.paynimo.android.payment.model.response.k.r rVar = (com.paynimo.android.payment.model.response.k.r) t;
                    if (rVar != null) {
                        com.paynimo.android.payment.model.response.k.o error = rVar.getError();
                        if (error == null || error.getErrorCode().isEmpty()) {
                            EventBus.getDefault().post(new com.paynimo.android.payment.event.i(rVar));
                            return;
                        } else {
                            EventBus.getDefault().post(new com.paynimo.android.payment.event.h(error));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            okhttp3.Response response2 = response.rawResponse;
            if (response2 != null && response2.message() != null) {
                com.paynimo.android.payment.model.response.k.o oVar = new com.paynimo.android.payment.model.response.k.o();
                oVar.setErrorCode(response2.code() + "");
                oVar.setErrorDesc(response2.message());
                EventBus.getDefault().post(new com.paynimo.android.payment.event.h(oVar));
            }
        }
    }

    public class j implements Callback<ResponsePayload> {
        public j(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new q(responsePayload));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.p(error));
                    }
                }
            }
        }
    }

    public class k implements Callback<ResponsePayload> {
        public k(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new a0(responsePayload));
                    } else {
                        EventBus.getDefault().post(new z(error));
                    }
                }
            }
        }
    }

    public class l implements Callback<ResponsePayload> {
        public l(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.o(responsePayload));
                    } else {
                        EventBus.getDefault().post(new com.paynimo.android.payment.event.n(error));
                    }
                }
            }
        }
    }

    public class m implements Callback<ResponsePayload> {
        public m(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new y(responsePayload));
                    } else {
                        EventBus.getDefault().post(new x(error));
                    }
                }
            }
        }
    }

    public class n implements Callback<ResponsePayload> {
        public n(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    responsePayload.getPaymentMethod().getError();
                    EventBus.getDefault().post(new s(responsePayload));
                }
            }
        }
    }

    public class o implements Callback<ResponsePayload> {
        public o(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    responsePayload.getPaymentMethod().getError();
                    EventBus.getDefault().post(new c0(responsePayload));
                }
            }
        }
    }

    public class p implements Callback<ResponsePayload> {
        public p(d dVar) {
        }

        public void onFailure(Call<ResponsePayload> call, Throwable th) {
        }

        public void onResponse(Call<ResponsePayload> call, Response<ResponsePayload> response) {
            if (response != null) {
                ResponsePayload responsePayload = (ResponsePayload) response.body;
                if (responsePayload != null && responsePayload.getPaymentMethod() != null) {
                    com.paynimo.android.payment.model.response.d error = responsePayload.getPaymentMethod().getError();
                    if (error == null || error.getCode().isEmpty()) {
                        EventBus.getDefault().post(new u(responsePayload));
                    } else {
                        EventBus.getDefault().post(new t(error));
                    }
                }
            }
        }
    }

    public d(a aVar) {
        this.f1403a = aVar;
    }

    public void callBinCheckAPI(com.paynimo.android.payment.model.request.c cVar, Context context) {
        this.f1403a.getBinCheckData(cVar).enqueue(new C0018d(this));
    }

    public void callCardDeregisterRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTWDForcefullPostData(requestPayload).enqueue(new a(this));
    }

    public void callEventLoggingRequest(com.paynimo.android.payment.model.request.n nVar, Context context) {
        this.f1403a.getEventLoggingData(nVar).enqueue(new c(this));
    }

    public void callIFSCRequest(com.paynimo.android.payment.model.request.i iVar, Context context) {
        this.f1403a.getIFSCPostData(iVar).enqueue(new b(this));
    }

    public void callPMIRequest(RequestPayload requestPayload, Context context) {
        requestPayload.getConsumer().setAadharNo("");
        this.f1403a.getPMIPostData(requestPayload).enqueue(new i(this));
    }

    public void callSVAbortRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getSVAbortPostData(requestPayload).enqueue(new h(this));
    }

    public void callSVRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getSVPostData(requestPayload).enqueue(new g(this));
    }

    public void callTARRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTARPostData(requestPayload).enqueue(new l(this));
    }

    public void callTRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTPostData(requestPayload).enqueue(new j(this));
    }

    public void callTUIRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTUIPostData(requestPayload).enqueue(new f(this));
    }

    public void callTWDRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTWDPostData(requestPayload).enqueue(new n(this));
    }

    public void callTWIRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTWIPostData(requestPayload).enqueue(new p(this));
    }

    public void callUserBinCheckAPI(com.paynimo.android.payment.model.request.c cVar, Context context) {
        this.f1403a.getBinCheckData(cVar).enqueue(new e(this));
    }

    public void callUserTARRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTARPostData(requestPayload).enqueue(new m(this));
    }

    public void callUserTRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTPostData(requestPayload).enqueue(new k(this));
    }

    public void callUserTWDRequest(RequestPayload requestPayload, Context context) {
        this.f1403a.getTWDPostData(requestPayload).enqueue(new o(this));
    }
}
