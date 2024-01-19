package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    public final JavaAnnotationArgument firstArgument;
    public final FqName fqName;
    public final boolean isIdeExternalAnnotation;
    public final SourceElement source;
    public final NotNullLazyValue type$delegate;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r4, kotlin.reflect.jvm.internal.impl.name.FqName r5) {
        /*
            r2 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r2.<init>()
            r2.fqName = r5
            r5 = 0
            if (r4 != 0) goto L_0x0014
            r0 = r5
            goto L_0x001c
        L_0x0014:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r3.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r0 = r0.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r0 = r0.source(r4)
        L_0x001c:
            if (r0 != 0) goto L_0x0025
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r1 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x0025:
            r2.source = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r3.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r0 = r0.storageManager
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2 r1 = new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2
            r1.<init>(r3, r2)
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r3 = r0.createLazyValue(r1)
            r2.type$delegate = r3
            if (r4 != 0) goto L_0x0039
            goto L_0x003f
        L_0x0039:
            java.util.Collection r3 = r4.getArguments()
            if (r3 != 0) goto L_0x0041
        L_0x003f:
            r3 = r5
            goto L_0x0047
        L_0x0041:
            java.lang.Object r3 = kotlin.collections.ArraysKt___ArraysJvmKt.firstOrNull(r3)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument r3 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument) r3
        L_0x0047:
            r2.firstArgument = r3
            if (r4 != 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            boolean r3 = r4.isIdeExternalAnnotation()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
        L_0x0054:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r3)
            r2.isIdeExternalAnnotation = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation, kotlin.reflect.jvm.internal.impl.name.FqName):void");
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return ArraysKt___ArraysJvmKt.emptyMap();
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public SourceElement getSource() {
        return this.source;
    }

    public KotlinType getType() {
        return (SimpleType) TweetUtils.getValue(this.type$delegate, $$delegatedProperties[0]);
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }
}
