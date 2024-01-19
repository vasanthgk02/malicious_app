package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: TypeIntersectionScope.kt */
public final class TypeIntersectionScope$getContributedFunctions$1 extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedFunctions$1 INSTANCE = new TypeIntersectionScope$getContributedFunctions$1();

    public TypeIntersectionScope$getContributedFunctions$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }
}
