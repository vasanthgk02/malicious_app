package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KClassImpl.kt */
public final class KClassImpl$Data$descriptor$2 extends Lambda implements Function0<ClassDescriptor> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KClassImpl$Data$descriptor$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r4 = this;
            kotlin.reflect.jvm.internal.KClassImpl$Data r0 = r4.this$0
            kotlin.reflect.jvm.internal.KClassImpl r0 = kotlin.reflect.jvm.internal.KClassImpl.this
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r0.getClassId()
            kotlin.reflect.jvm.internal.KClassImpl$Data r1 = r4.this$0
            kotlin.reflect.jvm.internal.KClassImpl r1 = kotlin.reflect.jvm.internal.KClassImpl.this
            kotlin.reflect.jvm.internal.ReflectProperties$LazyVal<kotlin.reflect.jvm.internal.KClassImpl$Data<>> r1 = r1.data
            java.lang.Object r1 = r1.invoke()
            kotlin.reflect.jvm.internal.KClassImpl$Data r1 = (kotlin.reflect.jvm.internal.KClassImpl.Data) r1
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r1 = r1.moduleData$delegate
            kotlin.reflect.KProperty[] r2 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data.$$delegatedProperties
            r3 = 0
            r2 = r2[r3]
            java.lang.Object r1 = r1.invoke()
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData) r1
            boolean r2 = r0.local
            if (r2 == 0) goto L_0x002c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r1 = r1.deserialization
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r1.deserializeClass(r0)
            goto L_0x0034
        L_0x002c:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r1 = r1.deserialization
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r1 = r1.moduleDescriptor
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = com.twitter.sdk.android.tweetui.TweetUtils.findClassAcrossModuleDependencies(r1, r0)
        L_0x0034:
            if (r0 == 0) goto L_0x0037
            return r0
        L_0x0037:
            kotlin.reflect.jvm.internal.KClassImpl$Data r0 = r4.this$0
            kotlin.reflect.jvm.internal.KClassImpl r0 = kotlin.reflect.jvm.internal.KClassImpl.this
            java.lang.Class<T> r1 = r0.jClass
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r1 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.create(r1)
            if (r1 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r1 = r1.classHeader
            if (r1 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r1 = r1.kind
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            if (r1 == 0) goto L_0x00b8
            int r2 = r1.ordinal()
            if (r2 == 0) goto L_0x0096
            r1 = 1
            if (r2 == r1) goto L_0x00b8
            r1 = 2
            if (r2 == r1) goto L_0x007f
            r1 = 3
            if (r2 == r1) goto L_0x0068
            r1 = 4
            if (r2 == r1) goto L_0x007f
            r1 = 5
            if (r2 == r1) goto L_0x007f
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0068:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection "
            java.lang.String r3 = "library has no idea what declarations does it have. Please use Java reflection to inspect this class: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r2, r3)
            java.lang.Class<T> r0 = r0.jClass
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x007f:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Packages and file facades are not yet supported in Kotlin reflection. "
            java.lang.String r3 = "Meanwhile please use Java reflection to inspect this class: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r2, r3)
            java.lang.Class<T> r0 = r0.jClass
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0096:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r2 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r3 = "Unknown class: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.Class<T> r0 = r0.jClass
            r3.append(r0)
            java.lang.String r0 = " (kind = "
            r3.append(r0)
            r3.append(r1)
            r0 = 41
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00b8:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r1 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r2 = "Unresolved class: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.Class<T> r0 = r0.jClass
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2.invoke():java.lang.Object");
    }
}
