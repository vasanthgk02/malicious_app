package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KFunctionImpl.kt */
public final class KFunctionImpl$descriptor$2 extends Lambda implements Function0<FunctionDescriptor> {
    public final /* synthetic */ String $name;
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        // this.this$0 = kFunctionImpl;
        // this.$name = str;
        super(0);
    }

    public Object invoke() {
        Iterable iterable;
        String str;
        KFunctionImpl kFunctionImpl = this.this$0;
        KDeclarationContainerImpl kDeclarationContainerImpl = kFunctionImpl.container;
        String str2 = this.$name;
        String str3 = kFunctionImpl.signature;
        if (kDeclarationContainerImpl != null) {
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "signature");
            if (Intrinsics.areEqual(str2, "<init>")) {
                iterable = ArraysKt___ArraysJvmKt.toList(kDeclarationContainerImpl.getConstructorDescriptors());
            } else {
                Name identifier = Name.identifier(str2);
                Intrinsics.checkNotNullExpressionValue(identifier, "Name.identifier(name)");
                iterable = kDeclarationContainerImpl.getFunctions(identifier);
            }
            Iterable iterable2 = iterable;
            ArrayList arrayList = new ArrayList();
            for (Object next : iterable2) {
                RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.INSTANCE;
                if (Intrinsics.areEqual(RuntimeTypeMapper.mapSignature((FunctionDescriptor) next).asString(), str3)) {
                    arrayList.add(next);
                }
            }
            boolean z = true;
            if (arrayList.size() == 1) {
                return (FunctionDescriptor) ArraysKt___ArraysJvmKt.single((List<? extends T>) arrayList);
            }
            String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default(iterable2, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30);
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("Function '", str2, "' (JVM signature: ", str3, ") not resolved in ");
            outline82.append(kDeclarationContainerImpl);
            outline82.append(':');
            if (joinToString$default.length() != 0) {
                z = false;
            }
            if (z) {
                str = " no members found";
            } else {
                str = 10 + joinToString$default;
            }
            outline82.append(str);
            throw new KotlinReflectionInternalError(outline82.toString());
        }
        throw null;
    }
}
