package com.paynimo.android.payment.b;

import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.request.i;
import com.paynimo.android.payment.model.request.n;
import com.paynimo.android.payment.model.response.ResponsePayload;
import com.paynimo.android.payment.model.response.e;
import com.paynimo.android.payment.model.response.k.r;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface c {
    @POST("/api/CommonAPI/CONSOLIDATED_BIN_CHECK")
    Call<com.paynimo.android.payment.model.response.c> getBinCheckData(@Body com.paynimo.android.payment.model.request.c cVar);

    @POST("/api/ProxyLogger.jsp")
    Call<Void> getEventLoggingData(@Body n nVar);

    @POST("/api/sendreceivemoney.jsp")
    Call<e> getIFSCPostData(@Body i iVar);

    @POST("/api/paynimoV2.req")
    Call<r> getPMIPostData(@Body RequestPayload requestPayload);

    @POST("/api/paynimoV2.req")
    Call<ResponsePayload> getRequestPostData(@Body RequestPayload requestPayload);

    @POST("/api/paynimoV2.req")
    Call<ResponsePayload> getRequestPostDataCards(@Body RequestPayload requestPayload);

    @POST("/api/paynimoV2.req")
    Call<ResponsePayload> getRequestPostDataUPI(@Body RequestPayload requestPayload);

    @POST("/api/ProxyCommonAPI/cancelAbort/PGCancelAbortIntimationAPI")
    Call<ResponsePayload> getSVAbortRequestPostData(@Body RequestPayload requestPayload);

    @POST("/api/paynimoV2.req")
    Call<ResponsePayload> getSVRequestPostData(@Body RequestPayload requestPayload);
}
