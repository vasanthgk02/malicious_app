package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;

/* compiled from: context.kt */
public final class ContextKt$copyWithNewDefaultTypeQualifiers$1 extends Lambda implements Function0<JavaTypeQualifiersByElementType> {
    public final /* synthetic */ Annotations $additionalAnnotations;
    public final /* synthetic */ LazyJavaResolverContext $this_copyWithNewDefaultTypeQualifiers;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ContextKt$copyWithNewDefaultTypeQualifiers$1(LazyJavaResolverContext lazyJavaResolverContext, Annotations annotations) {
        // this.$this_copyWithNewDefaultTypeQualifiers = lazyJavaResolverContext;
        // this.$additionalAnnotations = annotations;
        super(0);
    }

    public Object invoke() {
        return TweetUtils.computeNewDefaultTypeQualifiers(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
    }
}
