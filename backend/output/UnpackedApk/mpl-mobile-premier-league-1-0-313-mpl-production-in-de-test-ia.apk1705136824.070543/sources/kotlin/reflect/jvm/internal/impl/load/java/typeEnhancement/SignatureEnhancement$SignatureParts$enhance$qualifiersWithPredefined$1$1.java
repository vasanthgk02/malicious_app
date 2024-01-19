package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    public final /* synthetic */ TypeEnhancementInfo $predefined;
    public final /* synthetic */ Function1<Integer, JavaTypeQualifiers> $qualifiers;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(TypeEnhancementInfo typeEnhancementInfo, Function1<? super Integer, JavaTypeQualifiers> function1) {
        // this.$predefined = typeEnhancementInfo;
        // this.$qualifiers = function1;
        super(1);
    }

    public Object invoke(Object obj) {
        int intValue = ((Number) obj).intValue();
        JavaTypeQualifiers javaTypeQualifiers = this.$predefined.map.get(Integer.valueOf(intValue));
        return javaTypeQualifiers == null ? (JavaTypeQualifiers) this.$qualifiers.invoke(Integer.valueOf(intValue)) : javaTypeQualifiers;
    }
}
