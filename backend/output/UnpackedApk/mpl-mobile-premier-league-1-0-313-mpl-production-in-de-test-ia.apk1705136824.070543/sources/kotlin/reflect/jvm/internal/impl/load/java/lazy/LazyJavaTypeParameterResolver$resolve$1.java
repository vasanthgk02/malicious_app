package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: resolvers.kt */
public final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {
    public final /* synthetic */ LazyJavaTypeParameterResolver this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        // this.this$0 = lazyJavaTypeParameterResolver;
        super(1);
    }

    public Object invoke(Object obj) {
        JavaTypeParameter javaTypeParameter = (JavaTypeParameter) obj;
        Intrinsics.checkNotNullParameter(javaTypeParameter, "typeParameter");
        Integer num = this.this$0.typeParameters.get(javaTypeParameter);
        if (num == null) {
            return null;
        }
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.this$0;
        int intValue = num.intValue();
        LazyJavaResolverContext lazyJavaResolverContext = lazyJavaTypeParameterResolver.f5938c;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        Intrinsics.checkNotNullParameter(lazyJavaTypeParameterResolver, "typeParameterResolver");
        return new LazyJavaTypeParameterDescriptor(TweetUtils.copyWithNewDefaultTypeQualifiers(new LazyJavaResolverContext(lazyJavaResolverContext.components, lazyJavaTypeParameterResolver, lazyJavaResolverContext.delegateForDefaultTypeQualifiers), lazyJavaTypeParameterResolver.containingDeclaration.getAnnotations()), javaTypeParameter, lazyJavaTypeParameterResolver.typeParametersIndexOffset + intValue, lazyJavaTypeParameterResolver.containingDeclaration);
    }
}
