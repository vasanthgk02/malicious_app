package com.mpl.androidapp.miniprofile.kotlin.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/ResponseWrapper;", "T", "", "response", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Object;Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "getResponse", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Exception;)Lcom/mpl/androidapp/miniprofile/kotlin/model/ResponseWrapper;", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResponseWrapper.kt */
public final class ResponseWrapper<T> {
    public final Exception error;
    public final T response;

    public ResponseWrapper(T t, Exception exc) {
        this.response = t;
        this.error = exc;
    }

    public static /* synthetic */ ResponseWrapper copy$default(ResponseWrapper responseWrapper, T t, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            t = responseWrapper.response;
        }
        if ((i & 2) != 0) {
            exc = responseWrapper.error;
        }
        return responseWrapper.copy(t, exc);
    }

    public final T component1() {
        return this.response;
    }

    public final Exception component2() {
        return this.error;
    }

    public final ResponseWrapper<T> copy(T t, Exception exc) {
        return new ResponseWrapper<>(t, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseWrapper)) {
            return false;
        }
        ResponseWrapper responseWrapper = (ResponseWrapper) obj;
        return Intrinsics.areEqual(this.response, responseWrapper.response) && Intrinsics.areEqual(this.error, responseWrapper.error);
    }

    public final Exception getError() {
        return this.error;
    }

    public final T getResponse() {
        return this.response;
    }

    public int hashCode() {
        T t = this.response;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Exception exc = this.error;
        if (exc != null) {
            i = exc.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ResponseWrapper(response=");
        outline73.append(this.response);
        outline73.append(", error=");
        outline73.append(this.error);
        outline73.append(')');
        return outline73.toString();
    }
}
