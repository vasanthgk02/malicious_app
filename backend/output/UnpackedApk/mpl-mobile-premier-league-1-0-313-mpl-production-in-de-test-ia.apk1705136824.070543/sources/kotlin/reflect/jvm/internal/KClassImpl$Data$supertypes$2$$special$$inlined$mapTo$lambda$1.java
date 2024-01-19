package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"}, k = 3, mv = {1, 4, 1})
/* compiled from: KClassImpl.kt */
public final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1 extends Lambda implements Function0<Type> {
    public final /* synthetic */ KotlinType $kotlinType;
    public final /* synthetic */ KClassImpl$Data$supertypes$2 this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(KotlinType kotlinType, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        // this.$kotlinType = kotlinType;
        // this.this$0 = kClassImpl$Data$supertypes$2;
        super(0);
    }

    public Object invoke() {
        ClassifierDescriptor declarationDescriptor = this.$kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported superclass of ");
                outline73.append(this.this$0.this$0);
                outline73.append(": ");
                outline73.append(declarationDescriptor);
                throw new KotlinReflectionInternalError(outline73.toString());
            } else if (Intrinsics.areEqual(KClassImpl.this.jClass.getSuperclass(), javaClass)) {
                Type genericSuperclass = KClassImpl.this.jClass.getGenericSuperclass();
                Intrinsics.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
                return genericSuperclass;
            } else {
                Class[] interfaces = KClassImpl.this.jClass.getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                int indexOf = TweetUtils.indexOf((T[]) interfaces, javaClass);
                if (indexOf >= 0) {
                    Type type = KClassImpl.this.jClass.getGenericInterfaces()[indexOf];
                    Intrinsics.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
                    return type;
                }
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("No superclass of ");
                outline732.append(this.this$0.this$0);
                outline732.append(" in Java reflection for ");
                outline732.append(declarationDescriptor);
                throw new KotlinReflectionInternalError(outline732.toString());
            }
        } else {
            throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
        }
    }
}
