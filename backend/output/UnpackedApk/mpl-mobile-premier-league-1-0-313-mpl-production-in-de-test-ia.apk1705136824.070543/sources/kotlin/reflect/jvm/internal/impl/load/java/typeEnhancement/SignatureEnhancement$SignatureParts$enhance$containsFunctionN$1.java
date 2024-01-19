package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1();

    public SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        boolean z;
        ClassifierDescriptor declarationDescriptor = ((UnwrappedType) obj).getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return Boolean.FALSE;
        }
        Name name = declarationDescriptor.getName();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (Intrinsics.areEqual(name, JavaToKotlinClassMap.FUNCTION_N_FQ_NAME.shortName())) {
            FqName fqNameOrNull = DescriptorUtilsKt.fqNameOrNull(declarationDescriptor);
            JavaToKotlinClassMap javaToKotlinClassMap2 = JavaToKotlinClassMap.INSTANCE;
            if (Intrinsics.areEqual(fqNameOrNull, JavaToKotlinClassMap.FUNCTION_N_FQ_NAME)) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
