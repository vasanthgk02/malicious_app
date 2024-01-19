package com.netcore.android.utility.encoding;

import androidx.annotation.Keep;
import com.facebook.react.modules.network.NetworkingModule;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/utility/encoding/SMTEncoding;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTEncoding.kt */
public final class SMTEncoding {
    public static final Companion Companion = new Companion(null);

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/netcore/android/utility/encoding/SMTEncoding$Companion;", "", "", "string", "encodeStringToUTF8", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTEncoding.kt */
    public static final class Companion {
        public Companion() {
        }

        public final String encodeStringToUTF8(String str) {
            Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            try {
                String encode = URLEncoder.encode(str, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(string, \"UTF-8\")");
                return encode;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
