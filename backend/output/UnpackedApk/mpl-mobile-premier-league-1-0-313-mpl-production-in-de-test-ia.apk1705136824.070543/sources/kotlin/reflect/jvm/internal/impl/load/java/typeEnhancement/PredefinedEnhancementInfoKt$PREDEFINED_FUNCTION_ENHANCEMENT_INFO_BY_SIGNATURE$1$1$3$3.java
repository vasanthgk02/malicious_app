package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    public final /* synthetic */ String $JUStream;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(String str) {
        // this.$JUStream = str;
        super(1);
    }

    public Object invoke(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "<this>");
        String str = this.$JUStream;
        JavaTypeQualifiers javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
        functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }
}
