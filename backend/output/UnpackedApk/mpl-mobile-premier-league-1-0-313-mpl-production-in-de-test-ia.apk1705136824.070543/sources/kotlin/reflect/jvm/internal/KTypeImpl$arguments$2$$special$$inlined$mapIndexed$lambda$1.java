package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"}, k = 3, mv = {1, 4, 1})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<Type> {
    public final /* synthetic */ int $i;
    public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
    public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
    public final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i, KTypeImpl$arguments$2 kTypeImpl$arguments$2, Lazy lazy, KProperty kProperty) {
        // this.$i = i;
        // this.this$0 = kTypeImpl$arguments$2;
        // this.$parameterizedTypeArguments$inlined = lazy;
        super(0);
    }

    public Object invoke() {
        Type javaType = this.this$0.this$0.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Object componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.$i == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                return genericComponentType;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Array type has been queried for a non-0th argument: ");
            outline73.append(this.this$0.this$0);
            throw new KotlinReflectionInternalError(outline73.toString());
        } else if (javaType instanceof ParameterizedType) {
            Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) TweetUtils.firstOrNull(lowerBounds);
                if (type2 != null) {
                    type = type2;
                } else {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    type = (Type) TweetUtils.first(upperBounds);
                }
            }
            Intrinsics.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
            return type;
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Non-generic type has been queried for arguments: ");
            outline732.append(this.this$0.this$0);
            throw new KotlinReflectionInternalError(outline732.toString());
        }
    }
}
