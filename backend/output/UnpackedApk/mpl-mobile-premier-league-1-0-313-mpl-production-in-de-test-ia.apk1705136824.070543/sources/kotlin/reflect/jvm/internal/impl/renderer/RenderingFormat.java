package kotlin.reflect.jvm.internal.impl.renderer;

import com.facebook.react.modules.network.NetworkingModule;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: DescriptorRenderer.kt */
public enum RenderingFormat {
    ;

    /* compiled from: DescriptorRenderer.kt */
    public static final class HTML extends RenderingFormat {
        public HTML(String str, int i) {
            super(str, i, null);
        }

        public String escape(String str) {
            Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            return CharsKt__CharKt.replace$default(CharsKt__CharKt.replace$default(str, (String) "<", (String) "&lt;", false, 4), (String) ">", (String) "&gt;", false, 4);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    public static final class PLAIN extends RenderingFormat {
        public PLAIN(String str, int i) {
            super(str, i, null);
        }

        public String escape(String str) {
            Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
            return str;
        }
    }

    public abstract String escape(String str);
}
