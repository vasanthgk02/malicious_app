package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl implements KTypeBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public final ReflectProperties$LazySoftVal arguments$delegate;
    public final ReflectProperties$LazySoftVal classifier$delegate;
    public final ReflectProperties$LazySoftVal<Type> computeJavaType;
    public final KotlinType type;

    static {
        Class<KTypeImpl> cls = KTypeImpl.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "arguments", "getArguments()Ljava/util/List;"))};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0 = com.twitter.sdk.android.tweetui.TweetUtils.lazySoft(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinType r2, kotlin.jvm.functions.Function0<? extends java.lang.reflect.Type> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.type = r2
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal
            r0 = 0
            if (r2 != 0) goto L_0x0012
            r2 = r0
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r2 = (kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal) r2
            if (r2 == 0) goto L_0x0019
            r0 = r2
            goto L_0x001f
        L_0x0019:
            if (r3 == 0) goto L_0x001f
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r0 = com.twitter.sdk.android.tweetui.TweetUtils.lazySoft(r3)
        L_0x001f:
            r1.computeJavaType = r0
            kotlin.reflect.jvm.internal.KTypeImpl$classifier$2 r2 = new kotlin.reflect.jvm.internal.KTypeImpl$classifier$2
            r2.<init>(r1)
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r2 = com.twitter.sdk.android.tweetui.TweetUtils.lazySoft(r2)
            r1.classifier$delegate = r2
            kotlin.reflect.jvm.internal.KTypeImpl$arguments$2 r2 = new kotlin.reflect.jvm.internal.KTypeImpl$arguments$2
            r2.<init>(r1, r3)
            kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal r2 = com.twitter.sdk.android.tweetui.TweetUtils.lazySoft(r2)
            r1.arguments$delegate = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KTypeImpl.<init>(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.jvm.functions.Function0):void");
    }

    public final KClassifier convert(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                return null;
            }
            if (javaClass.isArray()) {
                TypeProjection typeProjection = (TypeProjection) ArraysKt___ArraysJvmKt.singleOrNull(kotlinType.getArguments());
                if (typeProjection != null) {
                    KotlinType type2 = typeProjection.getType();
                    if (type2 != null) {
                        Intrinsics.checkNotNullExpressionValue(type2, "type.arguments.singleOrN…return KClassImpl(jClass)");
                        KClassifier convert = convert(type2);
                        if (convert != null) {
                            return new KClassImpl(ReflectClassUtilKt.createArrayType(TweetUtils.getJavaClass(TweetUtils.getJvmErasure(convert))));
                        }
                        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                    }
                }
                return new KClassImpl(javaClass);
            } else if (TypeUtils.isNullableType(kotlinType)) {
                return new KClassImpl(javaClass);
            } else {
                Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new KClassImpl(javaClass);
            }
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
        } else {
            if (!(declarationDescriptor instanceof TypeAliasDescriptor)) {
                return null;
            }
            throw new NotImplementedError(GeneratedOutlineSupport.outline50("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof KTypeImpl) && Intrinsics.areEqual(this.type, ((KTypeImpl) obj).type);
    }

    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    public List<KTypeProjection> getArguments() {
        ReflectProperties$LazySoftVal reflectProperties$LazySoftVal = this.arguments$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (List) reflectProperties$LazySoftVal.invoke();
    }

    public KClassifier getClassifier() {
        ReflectProperties$LazySoftVal reflectProperties$LazySoftVal = this.classifier$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (KClassifier) reflectProperties$LazySoftVal.invoke();
    }

    public Type getJavaType() {
        ReflectProperties$LazySoftVal<Type> reflectProperties$LazySoftVal = this.computeJavaType;
        if (reflectProperties$LazySoftVal != null) {
            return (Type) reflectProperties$LazySoftVal.invoke();
        }
        return null;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    public String toString() {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
        return ReflectionObjectRenderer.renderType(this.type);
    }
}
