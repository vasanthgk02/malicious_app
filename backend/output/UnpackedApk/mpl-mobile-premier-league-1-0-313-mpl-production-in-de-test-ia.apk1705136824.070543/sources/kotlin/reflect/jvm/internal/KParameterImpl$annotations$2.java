package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KParameterImpl.kt */
public final class KParameterImpl$annotations$2 extends Lambda implements Function0<List<? extends Annotation>> {
    public final /* synthetic */ KParameterImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KParameterImpl$annotations$2(KParameterImpl kParameterImpl) {
        // this.this$0 = kParameterImpl;
        super(0);
    }

    public Object invoke() {
        return UtilKt.computeAnnotations(this.this$0.getDescriptor());
    }
}