package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.mpl.androidapp.login.LoginReactModule;
import com.razorpay.AnalyticsConstants;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: LazyJavaStaticScope.kt */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaStaticScope(LazyJavaResolverContext lazyJavaResolverContext) {
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        super(lazyJavaResolverContext, null);
    }

    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, AnalyticsConstants.METHOD);
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        MethodSignatureData methodSignatureData = new MethodSignatureData(kotlinType, null, list2, list, false, EmptyList.INSTANCE);
        return methodSignatureData;
    }
}
