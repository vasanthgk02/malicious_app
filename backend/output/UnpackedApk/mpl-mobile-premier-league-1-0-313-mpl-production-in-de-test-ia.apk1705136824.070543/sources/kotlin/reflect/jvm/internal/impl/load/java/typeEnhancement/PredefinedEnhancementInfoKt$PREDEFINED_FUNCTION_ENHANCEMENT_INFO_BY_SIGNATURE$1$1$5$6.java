package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6 extends Lambda implements Function1<FunctionEnhancementBuilder, Unit> {
    public final /* synthetic */ String $JFBiFunction;
    public final /* synthetic */ String $JLObject;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(String str, String str2) {
        // this.$JLObject = str;
        // this.$JFBiFunction = str2;
        super(1);
    }

    public Object invoke(Object obj) {
        FunctionEnhancementBuilder functionEnhancementBuilder = (FunctionEnhancementBuilder) obj;
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "<this>");
        functionEnhancementBuilder.parameter(this.$JLObject, PredefinedEnhancementInfoKt.NOT_PLATFORM);
        String str = this.$JFBiFunction;
        JavaTypeQualifiers javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
        JavaTypeQualifiers javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NULLABLE;
        functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2);
        functionEnhancementBuilder.returns(this.$JLObject, PredefinedEnhancementInfoKt.NULLABLE);
        return Unit.INSTANCE;
    }
}