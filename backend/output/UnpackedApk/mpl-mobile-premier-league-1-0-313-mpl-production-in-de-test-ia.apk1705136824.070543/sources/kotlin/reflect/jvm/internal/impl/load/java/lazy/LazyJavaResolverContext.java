package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;

/* compiled from: context.kt */
public final class LazyJavaResolverContext {
    public final JavaResolverComponents components;
    public final Lazy defaultTypeQualifiers$delegate;
    public final Lazy<JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers;
    public final TypeParameterResolver typeParameterResolver;
    public final JavaTypeResolver typeResolver;

    public LazyJavaResolverContext(JavaResolverComponents javaResolverComponents, TypeParameterResolver typeParameterResolver2, Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        Intrinsics.checkNotNullParameter(typeParameterResolver2, "typeParameterResolver");
        Intrinsics.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.components = javaResolverComponents;
        this.typeParameterResolver = typeParameterResolver2;
        this.delegateForDefaultTypeQualifiers = lazy;
        this.defaultTypeQualifiers$delegate = lazy;
        this.typeResolver = new JavaTypeResolver(this, typeParameterResolver2);
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.defaultTypeQualifiers$delegate.getValue();
    }
}
