package com.netcore.android.utility.xiaomi;

import android.util.Pair;
import androidx.annotation.Keep;
import com.xiaomi.mipush.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/netcore/android/utility/xiaomi/SMTXiaomiUtility;", "", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
@Keep
/* compiled from: SMTXiaomiUtility.kt */
public final class SMTXiaomiUtility {
    public static final Companion Companion = new Companion(null);

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/netcore/android/utility/xiaomi/SMTXiaomiUtility$Companion;", "", "", "trid", "convertToXiaomiTopicTrid", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/util/Pair;", "", "parseTrid", "(Ljava/lang/String;)Landroid/util/Pair;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTXiaomiUtility.kt */
    public static final class Companion {
        public Companion() {
        }

        public final String convertToXiaomiTopicTrid(String str) {
            Intrinsics.checkNotNullParameter(str, "trid");
            int lastIndexOf$default = CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6);
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("-XR");
            return sb.toString();
        }

        public final Pair<Boolean, String> parseTrid(String str) {
            Intrinsics.checkNotNullParameter(str, "trid");
            if (!CharsKt__CharKt.endsWith$default(str, (String) "XR", false, 2)) {
                return new Pair<>(Boolean.FALSE, str);
            }
            int lastIndexOf$default = CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6);
            Boolean bool = Boolean.TRUE;
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return new Pair<>(bool, substring);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
