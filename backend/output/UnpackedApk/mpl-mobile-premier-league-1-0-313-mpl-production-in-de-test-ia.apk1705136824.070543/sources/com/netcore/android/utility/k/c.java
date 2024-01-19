package com.netcore.android.utility.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;

/* compiled from: SMTEncryption.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1322a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static final a f1323b = new a(null);

    /* compiled from: SMTEncryption.kt */
    public static final class a {
        public a() {
        }

        public final String a() {
            return c.f1322a;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String bigInteger = new BigInteger(1, instance.digest(bytes)).toString(16);
                Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(1, messageDig…yteArray())).toString(16)");
                return CharsKt__CharKt.padStart(bigInteger, 32, '0');
            } catch (Exception e2) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String a2 = a();
                GeneratedOutlineSupport.outline96(a2, UeCustomType.TAG, e2, sMTLogger, a2);
                return "";
            }
        }
    }
}
