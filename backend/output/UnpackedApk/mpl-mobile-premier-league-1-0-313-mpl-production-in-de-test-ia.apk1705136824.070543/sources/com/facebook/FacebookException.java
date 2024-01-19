package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Callback;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import java.util.Random;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB\u0011\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/facebook/FacebookException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "message", "", "(Ljava/lang/String;)V", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookException.kt */
public class FacebookException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public FacebookException() {
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m121_init_$lambda0(String str, boolean z) {
        if (z) {
            try {
                ErrorReportData errorReportData = new ErrorReportData(str);
                if ((errorReportData.errorMessage == null || errorReportData.timestamp == null) ? false : true) {
                    InstrumentUtility.writeFile(errorReportData.filename, errorReportData.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        String message = getMessage();
        return message == null ? "" : message;
    }

    public FacebookException(String str) {
        super(str);
        Random random = new Random();
        if (str != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isInitialized() && random.nextInt(100) > 50) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                FeatureManager.checkFeature(Feature.ErrorReport, new Callback(str) {
                    public final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCompleted(boolean z) {
                        FacebookException.m121_init_$lambda0(this.f$0, z);
                    }
                });
            }
        }
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}
