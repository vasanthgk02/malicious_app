package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SignatureBuildingComponents.kt */
public final class SignatureBuildingComponents$jvmDescriptor$1 extends Lambda implements Function1<String, CharSequence> {
    public final /* synthetic */ SignatureBuildingComponents this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SignatureBuildingComponents$jvmDescriptor$1(SignatureBuildingComponents signatureBuildingComponents) {
        // this.this$0 = signatureBuildingComponents;
        super(1);
    }

    public Object invoke(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "it");
        return this.this$0.escapeClassName(str);
    }
}
