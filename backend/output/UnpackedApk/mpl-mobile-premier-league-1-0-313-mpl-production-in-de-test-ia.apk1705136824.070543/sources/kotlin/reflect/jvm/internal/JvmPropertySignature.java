package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: RuntimeTypeMapper.kt */
public abstract class JvmPropertySignature {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaField extends JvmPropertySignature {
        public final Field field;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public JavaField(Field field2) {
            // Intrinsics.checkNotNullParameter(field2, HSLCriteriaBuilder.FIELD);
            super(null);
            this.field = field2;
        }

        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "field.name");
            sb.append(JvmAbi.getterName(name));
            sb.append("()");
            Class<?> type = this.field.getType();
            Intrinsics.checkNotNullExpressionValue(type, "field.type");
            sb.append(ReflectClassUtilKt.getDesc(type));
            return sb.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaMethodProperty extends JvmPropertySignature {
        public final Method getterMethod;
        public final Method setterMethod;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public JavaMethodProperty(Method method, Method method2) {
            // Intrinsics.checkNotNullParameter(method, "getterMethod");
            super(null);
            this.getterMethod = method;
            this.setterMethod = method2;
        }

        public String asString() {
            return TweetUtils.access$getSignature$p(this.getterMethod);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class KotlinProperty extends JvmPropertySignature {
        public final PropertyDescriptor descriptor;
        public final NameResolver nameResolver;
        public final ProtoBuf$Property proto;
        public final kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature signature;
        public final String string;
        public final TypeTable typeTable;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x00b2, code lost:
            r3 = r1.nameResolver.getString(r3.intValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x00bc, code lost:
            if (r3 != null) goto L_0x00c1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public KotlinProperty(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r2, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature r4, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r6) {
            /*
                r1 = this;
                java.lang.String r0 = "descriptor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "proto"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "signature"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "nameResolver"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "typeTable"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                r0 = 0
                r1.<init>(r0)
                r1.descriptor = r2
                r1.proto = r3
                r1.signature = r4
                r1.nameResolver = r5
                r1.typeTable = r6
                boolean r2 = r4.hasGetter()
                if (r2 == 0) goto L_0x0061
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r1.nameResolver
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = r1.signature
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r4.getter_
                java.lang.String r5 = "signature.getter"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                int r4 = r4.name_
                java.lang.String r3 = r3.getString(r4)
                r2.append(r3)
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r1.nameResolver
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = r1.signature
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r4.getter_
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                int r4 = r4.desc_
                java.lang.String r3 = r3.getString(r4)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                goto L_0x0119
            L_0x0061:
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r2 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = r1.proto
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r1.nameResolver
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r5 = r1.typeTable
                r6 = 1
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Field r2 = r2.getJvmFieldSignature(r3, r4, r5, r6)
                if (r2 == 0) goto L_0x011c
                java.lang.String r3 = r2.name
                java.lang.String r2 = r2.desc
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.getterName(r3)
                r4.append(r3)
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r3 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r3.getContainingDeclaration()
                java.lang.String r5 = "descriptor.containingDeclaration"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r5 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r5.getVisibility()
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
                java.lang.String r6 = "$"
                if (r5 == 0) goto L_0x00d1
                boolean r5 = r3 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
                if (r5 == 0) goto L_0x00d1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r3
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r3.classProto
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, java.lang.Integer> r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classModuleName
                java.lang.String r0 = "JvmProtoBuf.classModuleName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                java.lang.Object r3 = com.twitter.sdk.android.tweetui.TweetUtils.getExtensionOrNull(r3, r5)
                java.lang.Integer r3 = (java.lang.Integer) r3
                if (r3 == 0) goto L_0x00bf
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5 = r1.nameResolver
                int r3 = r3.intValue()
                java.lang.String r3 = r5.getString(r3)
                if (r3 == 0) goto L_0x00bf
                goto L_0x00c1
            L_0x00bf:
                java.lang.String r3 = "main"
            L_0x00c1:
                java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
                java.lang.String r3 = kotlin.reflect.jvm.internal.impl.name.NameUtils.sanitizeAsJavaIdentifier(r3)
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                goto L_0x0113
            L_0x00d1:
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r5 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r5.getVisibility()
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
                if (r5 == 0) goto L_0x0111
                boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
                if (r3 == 0) goto L_0x0111
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r3 = r1.descriptor
                if (r3 == 0) goto L_0x0109
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) r3
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r3 = r3.containerSource
                boolean r5 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource
                if (r5 == 0) goto L_0x0111
                kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource) r3
                kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r5 = r3.facadeClassName
                if (r5 == 0) goto L_0x0111
                java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
                kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getSimpleName()
                java.lang.String r3 = r3.asString()
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                goto L_0x0113
            L_0x0109:
                java.lang.NullPointerException r2 = new java.lang.NullPointerException
                java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor"
                r2.<init>(r3)
                throw r2
            L_0x0111:
                java.lang.String r3 = ""
            L_0x0113:
                java.lang.String r5 = "()"
                java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline63(r4, r3, r5, r2)
            L_0x0119:
                r1.string = r2
                return
            L_0x011c:
                kotlin.reflect.jvm.internal.KotlinReflectionInternalError r2 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
                java.lang.String r3 = "No field signature for property: "
                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r4 = r1.descriptor
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r2.<init>(r3)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty.<init>(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable):void");
        }

        public String asString() {
            return this.string;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class MappedKotlinProperty extends JvmPropertySignature {
        public final KotlinFunction getterSignature;
        public final KotlinFunction setterSignature;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public MappedKotlinProperty(KotlinFunction kotlinFunction, KotlinFunction kotlinFunction2) {
            // Intrinsics.checkNotNullParameter(kotlinFunction, "getterSignature");
            super(null);
            this.getterSignature = kotlinFunction;
            this.setterSignature = kotlinFunction2;
        }

        public String asString() {
            return this.getterSignature._signature;
        }
    }

    public JvmPropertySignature(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
