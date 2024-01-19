package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaTargetAnnotationDescriptor extends JavaAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaTargetAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    public final NotNullLazyValue allValueArguments$delegate;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaTargetAnnotationDescriptor(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        // Intrinsics.checkNotNullParameter(javaAnnotation, "annotation");
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        super(lazyJavaResolverContext, javaAnnotation, FqNames.target);
        this.allValueArguments$delegate = lazyJavaResolverContext.components.storageManager.createLazyValue(new JavaTargetAnnotationDescriptor$allValueArguments$2(this));
    }

    public Map<Name, ConstantValue<Object>> getAllValueArguments() {
        return (Map) TweetUtils.getValue(this.allValueArguments$delegate, $$delegatedProperties[0]);
    }
}
