package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<Name, ? extends ConstantValue<?>>> {
    public final /* synthetic */ JavaRetentionAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        // this.this$0 = javaRetentionAnnotationDescriptor;
        super(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor r0 = r5.this$0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument r0 = r0.firstArgument
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
            r2 = 0
            if (r1 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 != 0) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention> r1 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.retentionNameList
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getEntryName()
            if (r0 != 0) goto L_0x001c
            r0 = r2
            goto L_0x0020
        L_0x001c:
            java.lang.String r0 = r0.asString()
        L_0x0020:
            java.lang.Object r0 = r1.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention) r0
            if (r0 != 0) goto L_0x002a
        L_0x0028:
            r1 = r2
            goto L_0x0048
        L_0x002a:
            kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue r1 = new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.annotationRetention
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(r3)
            java.lang.String r4 = "topLevel(StandardNames.FqNames.annotationRetention)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r0 = r0.name()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r0)
            java.lang.String r4 = "identifier(retention.name)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r1.<init>(r3, r0)
        L_0x0048:
            if (r1 != 0) goto L_0x004b
            goto L_0x0058
        L_0x004b:
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.RETENTION_ANNOTATION_VALUE
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r0, r1)
            java.util.Map r2 = com.twitter.sdk.android.tweetui.TweetUtils.mapOf(r2)
        L_0x0058:
            if (r2 == 0) goto L_0x005b
            goto L_0x005f
        L_0x005b:
            java.util.Map r2 = kotlin.collections.ArraysKt___ArraysJvmKt.emptyMap()
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor$allValueArguments$2.invoke():java.lang.Object");
    }
}
