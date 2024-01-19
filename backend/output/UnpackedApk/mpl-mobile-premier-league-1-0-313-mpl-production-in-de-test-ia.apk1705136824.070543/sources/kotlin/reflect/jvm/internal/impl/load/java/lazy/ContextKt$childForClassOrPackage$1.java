package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;

/* compiled from: context.kt */
public final class ContextKt$childForClassOrPackage$1 extends Lambda implements Function0<JavaTypeQualifiersByElementType> {
    public final /* synthetic */ ClassOrPackageFragmentDescriptor $containingDeclaration;
    public final /* synthetic */ LazyJavaResolverContext $this_childForClassOrPackage;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ContextKt$childForClassOrPackage$1(LazyJavaResolverContext lazyJavaResolverContext, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        // this.$this_childForClassOrPackage = lazyJavaResolverContext;
        // this.$containingDeclaration = classOrPackageFragmentDescriptor;
        super(0);
    }

    public Object invoke() {
        return TweetUtils.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
    }
}
