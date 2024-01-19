package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: TypeIntersectionScope.kt */
public final class TypeIntersectionScope$getContributedVariables$1 extends Lambda implements Function1<PropertyDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedVariables$1 INSTANCE = new TypeIntersectionScope$getContributedVariables$1();

    public TypeIntersectionScope$getContributedVariables$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
        Intrinsics.checkNotNullParameter(propertyDescriptor, "<this>");
        return propertyDescriptor;
    }
}
