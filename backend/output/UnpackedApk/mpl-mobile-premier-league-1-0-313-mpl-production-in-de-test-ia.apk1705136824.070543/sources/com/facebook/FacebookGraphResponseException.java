package com.facebook;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.fontbox.cmap.CMap;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookGraphResponseException.kt */
public final class FacebookGraphResponseException extends FacebookException {
    public final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public String toString() {
        FacebookRequestError facebookRequestError;
        GraphResponse graphResponse2 = this.graphResponse;
        if (graphResponse2 == null) {
            facebookRequestError = null;
        } else {
            facebookRequestError = graphResponse2.error;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            outline73.append(message);
            outline73.append(CMap.SPACE);
        }
        if (facebookRequestError != null) {
            outline73.append("httpResponseCode: ");
            outline73.append(facebookRequestError.requestStatusCode);
            outline73.append(", facebookErrorCode: ");
            outline73.append(facebookRequestError.errorCode);
            outline73.append(", facebookErrorType: ");
            outline73.append(facebookRequestError.errorType);
            outline73.append(", message: ");
            outline73.append(facebookRequestError.getErrorMessage());
            outline73.append("}");
        }
        String sb = outline73.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "errorStringBuilder.toString()");
        return sb;
    }
}
