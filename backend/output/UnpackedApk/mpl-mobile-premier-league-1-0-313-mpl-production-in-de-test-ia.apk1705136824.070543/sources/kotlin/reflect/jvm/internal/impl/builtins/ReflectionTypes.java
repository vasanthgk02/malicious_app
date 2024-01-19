package kotlin.reflect.jvm.internal.impl.builtins;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;

/* compiled from: ReflectionTypes.kt */
public final class ReflectionTypes {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public final ClassLookup kClass$delegate = new ClassLookup(1);
    public final Lazy kotlinReflectScope$delegate;
    public final NotFoundClasses notFoundClasses;

    /* compiled from: ReflectionTypes.kt */
    public static final class ClassLookup {
        public final int numberOfTypeParameters;

        public ClassLookup(int i) {
            this.numberOfTypeParameters = i;
        }
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        Class<ReflectionTypes> cls = ReflectionTypes.class;
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        $$delegatedProperties = kPropertyArr;
    }

    public ReflectionTypes(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        this.notFoundClasses = notFoundClasses2;
        this.kotlinReflectScope$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(moduleDescriptor));
    }
}
