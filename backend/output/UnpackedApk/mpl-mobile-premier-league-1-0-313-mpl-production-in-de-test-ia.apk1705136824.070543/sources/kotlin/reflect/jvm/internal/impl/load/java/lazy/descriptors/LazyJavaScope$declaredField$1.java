package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$declaredField$1 extends Lambda implements Function1<Name, PropertyDescriptor> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$declaredField$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a9, code lost:
        if (r14.getHasConstantNotNullInitializer() != false) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.reflect.jvm.internal.impl.name.Name r14 = (kotlin.reflect.jvm.internal.impl.name.Name) r14
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope r0 = r13.this$0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope r1 = r0.mainScope
            if (r1 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> r0 = r1.declaredField
            java.lang.Object r14 = r0.invoke(r14)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r14
            goto L_0x00ec
        L_0x0017:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex> r0 = r0.declaredMemberIndex
            java.lang.Object r0 = r0.invoke()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex) r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField r14 = r0.findFieldByName(r14)
            r0 = 0
            if (r14 == 0) goto L_0x00eb
            boolean r1 = r14.isEnumEntry()
            if (r1 != 0) goto L_0x00eb
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope r1 = r13.this$0
            if (r1 == 0) goto L_0x00ea
            boolean r2 = r14.isFinal()
            r3 = 1
            r8 = r2 ^ 1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = com.twitter.sdk.android.tweetui.TweetUtils.resolveAnnotations(r2, r14)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r1.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r6 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r2 = r14.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r7 = com.twitter.sdk.android.tweetui.TweetUtils.toDescriptorVisibility(r2)
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r14.getName()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r2 = r2.components
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r2 = r2.sourceElementFactory
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r10 = r2.source(r14)
            boolean r2 = r14.isFinal()
            r12 = 0
            if (r2 == 0) goto L_0x0068
            boolean r2 = r14.isStatic()
            if (r2 == 0) goto L_0x0068
            r11 = 1
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r2 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.create(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.String r4 = "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r2.initialize(r0, r0, r0, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r4 = r4.typeResolver
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r5 = r14.getType()
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r6 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r7 = 3
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r6, r12, r0, r7)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.transformJavaType(r5, r6)
            boolean r5 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r4)
            if (r5 != 0) goto L_0x0094
            boolean r5 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4)
            if (r5 == 0) goto L_0x00ac
        L_0x0094:
            boolean r5 = r14.isFinal()
            if (r5 == 0) goto L_0x00a2
            boolean r5 = r14.isStatic()
            if (r5 == 0) goto L_0x00a2
            r5 = 1
            goto L_0x00a3
        L_0x00a2:
            r5 = 0
        L_0x00a3:
            if (r5 == 0) goto L_0x00ac
            boolean r5 = r14.getHasConstantNotNullInitializer()
            if (r5 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r3 = 0
        L_0x00ad:
            if (r3 == 0) goto L_0x00b8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(r4)
            java.lang.String r3 = "makeNotNullable(propertyType)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
        L_0x00b8:
            kotlin.collections.EmptyList r3 = kotlin.collections.EmptyList.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5 = r1.getDispatchReceiverParameter()
            r2.setType(r4, r3, r5, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r2.getType()
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.shouldRecordInitializerForProperty(r2, r3)
            if (r3 == 0) goto L_0x00dd
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r3 = r3.components
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r3 = r3.storageManager
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1
            r4.<init>(r1, r14, r2)
            kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue r14 = r3.createNullableLazyValue(r4)
            r2.setCompileTimeInitializer(r14)
        L_0x00dd:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r14 = r1.f5943c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r14 = r14.components
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r14 = r14.javaResolverCache
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache$1 r14 = (kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1) r14
            if (r14 == 0) goto L_0x00e9
            r14 = r2
            goto L_0x00ec
        L_0x00e9:
            throw r0
        L_0x00ea:
            throw r0
        L_0x00eb:
            r14 = r0
        L_0x00ec:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$declaredField$1.invoke(java.lang.Object):java.lang.Object");
    }
}
