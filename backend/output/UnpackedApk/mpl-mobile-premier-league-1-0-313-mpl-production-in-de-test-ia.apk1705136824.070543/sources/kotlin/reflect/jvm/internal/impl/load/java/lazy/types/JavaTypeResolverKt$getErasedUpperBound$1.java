package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolverKt$getErasedUpperBound$1 extends Lambda implements Function0<SimpleType> {
    public final /* synthetic */ TypeParameterDescriptor $this_getErasedUpperBound;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaTypeResolverKt$getErasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor) {
        // this.$this_getErasedUpperBound = typeParameterDescriptor;
        super(0);
    }

    public Object invoke() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't compute erased upper bound of type parameter `");
        outline73.append(this.$this_getErasedUpperBound);
        outline73.append('`');
        SimpleType createErrorType = ErrorUtils.createErrorType(outline73.toString());
        Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
        return createErrorType;
    }
}
