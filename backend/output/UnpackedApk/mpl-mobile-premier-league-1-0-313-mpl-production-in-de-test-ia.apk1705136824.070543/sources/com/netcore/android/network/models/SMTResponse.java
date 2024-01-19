package com.netcore.android.network.models;

import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R\"\u0010(\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010¨\u00067"}, d2 = {"Lcom/netcore/android/network/models/SMTResponse;", "", "", "isNetworkFailure", "Z", "()Z", "setNetworkFailure", "(Z)V", "isSuccess", "setSuccess", "", "response", "Ljava/lang/String;", "getResponse", "()Ljava/lang/String;", "setResponse", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "", "httpCode", "Ljava/lang/Integer;", "getHttpCode", "()Ljava/lang/Integer;", "setHttpCode", "(Ljava/lang/Integer;)V", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "smtApiTypeID", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "getSmtApiTypeID", "()Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "setSmtApiTypeID", "(Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;)V", "app", "getApp", "setApp", "shouldRetry", "getShouldRetry", "setShouldRetry", "message", "getMessage", "setMessage", "", "requestId", "J", "getRequestId", "()J", "setRequestId", "(J)V", "endpoint", "getEndpoint", "setEndpoint", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTResponse.kt */
public class SMTResponse {
    public String app;
    public String endpoint;
    public String errorMessage;
    public Integer httpCode;
    public boolean isNetworkFailure;
    public boolean isSuccess = true;
    public String message;
    public long requestId;
    public String response;
    public boolean shouldRetry;
    public SMTApiTypeID smtApiTypeID;

    public final String getApp() {
        String str = this.app;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("app");
        throw null;
    }

    public final String getEndpoint() {
        String str = this.endpoint;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(HttpTunnelingServlet.ENDPOINT);
        throw null;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final String getMessage() {
        String str = this.message;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("message");
        throw null;
    }

    public final long getRequestId() {
        return this.requestId;
    }

    public final String getResponse() {
        return this.response;
    }

    public final boolean getShouldRetry() {
        return this.shouldRetry;
    }

    public final SMTApiTypeID getSmtApiTypeID() {
        SMTApiTypeID sMTApiTypeID = this.smtApiTypeID;
        if (sMTApiTypeID != null) {
            return sMTApiTypeID;
        }
        Intrinsics.throwUninitializedPropertyAccessException("smtApiTypeID");
        throw null;
    }

    public final boolean isNetworkFailure() {
        return this.isNetworkFailure;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setApp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.app = str;
    }

    public final void setEndpoint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endpoint = str;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setHttpCode(Integer num) {
        this.httpCode = num;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setNetworkFailure(boolean z) {
        this.isNetworkFailure = z;
    }

    public final void setRequestId(long j) {
        this.requestId = j;
    }

    public final void setResponse(String str) {
        this.response = str;
    }

    public final void setShouldRetry(boolean z) {
        this.shouldRetry = z;
    }

    public final void setSmtApiTypeID(SMTApiTypeID sMTApiTypeID) {
        Intrinsics.checkNotNullParameter(sMTApiTypeID, "<set-?>");
        this.smtApiTypeID = sMTApiTypeID;
    }

    public final void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
