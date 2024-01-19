package kotlin.reflect.jvm.internal.calls;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ Class $annotationClass;
    public final /* synthetic */ Map $values;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class cls, Map map) {
        // this.$annotationClass = cls;
        // this.$values = map;
        super(0);
    }

    public Object invoke() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('@');
        outline72.append(this.$annotationClass.getCanonicalName());
        ArraysKt___ArraysJvmKt.joinTo$default(this.$values.entrySet(), outline72, ", ", "(", ")", 0, null, AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.INSTANCE, 48);
        String sb = outline72.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
