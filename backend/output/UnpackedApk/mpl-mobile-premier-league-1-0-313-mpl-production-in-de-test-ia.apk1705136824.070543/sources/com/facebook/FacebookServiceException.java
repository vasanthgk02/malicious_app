package com.facebook;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/facebook/FacebookServiceException;", "Lcom/facebook/FacebookException;", "requestError", "Lcom/facebook/FacebookRequestError;", "errorMessage", "", "(Lcom/facebook/FacebookRequestError;Ljava/lang/String;)V", "getRequestError", "()Lcom/facebook/FacebookRequestError;", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookServiceException.kt */
public final class FacebookServiceException extends FacebookException {
    public static final long serialVersionUID = 1;
    public final FacebookRequestError requestError;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        // Intrinsics.checkNotNullParameter(facebookRequestError, "requestError");
        super(str);
        this.requestError = facebookRequestError;
    }

    public String toString() {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("{FacebookServiceException: ", "httpResponseCode: ");
        outline78.append(this.requestError.requestStatusCode);
        outline78.append(", facebookErrorCode: ");
        outline78.append(this.requestError.errorCode);
        outline78.append(", facebookErrorType: ");
        outline78.append(this.requestError.errorType);
        outline78.append(", message: ");
        outline78.append(this.requestError.getErrorMessage());
        outline78.append("}");
        String sb = outline78.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{FacebookServiceException: \")\n        .append(\"httpResponseCode: \")\n        .append(requestError.requestStatusCode)\n        .append(\", facebookErrorCode: \")\n        .append(requestError.errorCode)\n        .append(\", facebookErrorType: \")\n        .append(requestError.errorType)\n        .append(\", message: \")\n        .append(requestError.errorMessage)\n        .append(\"}\")\n        .toString()");
        return sb;
    }
}
