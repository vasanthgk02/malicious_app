package com.facebook.appevents;

import com.facebook.internal.Utility;
import com.netcore.android.SMTEventParamKeys;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair;", "Ljava/io/Serializable;", "accessToken", "Lcom/facebook/AccessToken;", "(Lcom/facebook/AccessToken;)V", "accessTokenString", "", "applicationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessTokenString", "()Ljava/lang/String;", "getApplicationId", "equals", "", "o", "", "hashCode", "", "writeReplace", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessTokenAppIdPair.kt */
public final class AccessTokenAppIdPair implements Serializable {
    public static final long serialVersionUID = 1;
    public final String accessTokenString;
    public final String applicationId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair$SerializationProxyV1;", "Ljava/io/Serializable;", "accessTokenString", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenAppIdPair.kt */
    public static final class SerializationProxyV1 implements Serializable {
        public static final long serialVersionUID = -2488473066578201069L;
        public final String accessTokenString;
        public final String appId;

        public SerializationProxyV1(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, SMTEventParamKeys.SMT_APP_ID);
            this.accessTokenString = str;
            this.appId = str2;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }
    }

    public AccessTokenAppIdPair(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "applicationId");
        this.applicationId = str2;
        this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof AccessTokenAppIdPair)) {
            return false;
        }
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
        if (Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        String str = this.accessTokenString;
        return (str == null ? 0 : str.hashCode()) ^ this.applicationId.hashCode();
    }
}
