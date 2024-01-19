package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* compiled from: RuntimeTypeMapper.kt */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = null;
    public static final ClassId JAVA_LANG_VOID;

    static {
        ClassId classId = ClassId.topLevel(new FqName((String) "java.lang.Void"));
        Intrinsics.checkNotNullExpressionValue(classId, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = classId;
    }

    public static final PrimitiveType getPrimitiveType(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
        return jvmPrimitiveType.getPrimitiveType();
    }

    public static final KotlinFunction mapJvmFunctionSignature(FunctionDescriptor functionDescriptor) {
        String jvmMethodNameIfSpecial = TweetUtils.getJvmMethodNameIfSpecial(functionDescriptor);
        if (jvmMethodNameIfSpecial == null) {
            if (functionDescriptor instanceof PropertyGetterDescriptor) {
                String asString = DescriptorUtilsKt.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.getterName(asString);
            } else if (functionDescriptor instanceof PropertySetterDescriptor) {
                String asString2 = DescriptorUtilsKt.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.setterName(asString2);
            } else {
                jvmMethodNameIfSpecial = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(jvmMethodNameIfSpecial, "descriptor.name.asString()");
            }
        }
        return new KotlinFunction(new Method(jvmMethodNameIfSpecial, MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 1)));
    }

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction] */
    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.reflect.Method, kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction]
      uses: [kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction, java.lang.reflect.Method]
      mth insns count: 82
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.JvmPropertySignature mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7) {
        /*
            java.lang.String r0 = "possiblyOverriddenProperty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r7 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(r7)
            java.lang.String r0 = "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r7.getOriginal()
            java.lang.String r7 = "DescriptorUtils.unwrapFa…rriddenProperty).original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
            r0 = 0
            if (r7 == 0) goto L_0x003d
            r7 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) r7
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r2 = r7.proto
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature
            java.lang.String r4 = "JvmProtoBuf.propertySignature"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Object r3 = com.twitter.sdk.android.tweetui.TweetUtils.getExtensionOrNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3
            if (r3 == 0) goto L_0x00be
            kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty r6 = new kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r7.nameResolver
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r5 = r7.typeTable
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        L_0x003d:
            boolean r7 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            if (r7 == 0) goto L_0x00be
            r7 = r1
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r7 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = r7.getSource()
            boolean r2 = r7 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r2 != 0) goto L_0x004d
            r7 = r0
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r7
            if (r7 == 0) goto L_0x0056
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r7 = r7.getJavaElement()
            goto L_0x0057
        L_0x0056:
            r7 = r0
        L_0x0057:
            boolean r2 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField
            if (r2 == 0) goto L_0x0065
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField r0 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField r7 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField) r7
            java.lang.reflect.Field r7 = r7.member
            r0.<init>(r7)
            goto L_0x0099
        L_0x0065:
            boolean r2 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r2 == 0) goto L_0x009a
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty r2 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r7 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r7
            java.lang.reflect.Method r7 = r7.member
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x007a
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r1 = r1.getSource()
            goto L_0x007b
        L_0x007a:
            r1 = r0
        L_0x007b:
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r3 != 0) goto L_0x0080
            r1 = r0
        L_0x0080:
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r1 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r1
            if (r1 == 0) goto L_0x0089
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = r1.getJavaElement()
            goto L_0x008a
        L_0x0089:
            r1 = r0
        L_0x008a:
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r3 != 0) goto L_0x008f
            r1 = r0
        L_0x008f:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r1
            if (r1 == 0) goto L_0x0095
            java.lang.reflect.Method r0 = r1.member
        L_0x0095:
            r2.<init>(r7, r0)
            r0 = r2
        L_0x0099:
            return r0
        L_0x009a:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Incorrect resolution sequence for Java field "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " (source = "
            r2.append(r1)
            r2.append(r7)
            r7 = 41
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.<init>(r7)
            throw r0
        L_0x00be:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor r7 = r1.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r7 = mapJvmFunctionSignature(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x00d3
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r0 = mapJvmFunctionSignature(r1)
        L_0x00d3:
            kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty r1 = new kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty
            r1.<init>(r7, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):kotlin.reflect.jvm.internal.JvmPropertySignature");
    }

    public static final JvmFunctionSignature mapSignature(FunctionDescriptor functionDescriptor) {
        JvmFunctionSignature jvmFunctionSignature;
        JvmFunctionSignature jvmFunctionSignature2;
        Intrinsics.checkNotNullParameter(functionDescriptor, "possiblySubstitutedFunction");
        CallableMemberDescriptor unwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(functionDescriptor);
        Intrinsics.checkNotNullExpressionValue(unwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) unwrapFakeOverride).getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedCallableMemberDescriptor) {
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) original;
            MessageLite proto = deserializedCallableMemberDescriptor.getProto();
            if (proto instanceof ProtoBuf$Function) {
                Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf$Function) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable());
                if (jvmMethodSignature != null) {
                    return new KotlinFunction(jvmMethodSignature);
                }
            }
            if (proto instanceof ProtoBuf$Constructor) {
                Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf$Constructor) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable());
                if (jvmConstructorSignature != null) {
                    DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
                    if (InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                        jvmFunctionSignature2 = new KotlinFunction(jvmConstructorSignature);
                    } else {
                        jvmFunctionSignature2 = new KotlinConstructor(jvmConstructorSignature);
                    }
                    return jvmFunctionSignature2;
                }
            }
            return mapJvmFunctionSignature(original);
        }
        JavaElement javaElement = null;
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement2 = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement2 instanceof ReflectJavaMethod) {
                javaElement = javaElement2;
            }
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) javaElement;
            if (reflectJavaMethod != null) {
                java.lang.reflect.Method method = reflectJavaMethod.member;
                if (method != null) {
                    return new JavaMethod(method);
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        } else if (original instanceof JavaClassConstructorDescriptor) {
            SourceElement source2 = ((JavaClassConstructorDescriptor) original).getSource();
            if (!(source2 instanceof JavaSourceElement)) {
                source2 = null;
            }
            JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
            if (javaSourceElement2 != null) {
                javaElement = javaSourceElement2.getJavaElement();
            }
            if (javaElement instanceof ReflectJavaConstructor) {
                jvmFunctionSignature = new JavaConstructor(((ReflectJavaConstructor) javaElement).member);
            } else {
                if (javaElement instanceof ReflectJavaClass) {
                    ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement;
                    if (reflectJavaClass.isAnnotationType()) {
                        jvmFunctionSignature = new FakeJavaAnnotationConstructor(reflectJavaClass.klass);
                    }
                }
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement + ')');
            }
            return jvmFunctionSignature;
        } else {
            boolean z = true;
            if (!(original.getName().equals(StandardNames.ENUM_VALUE_OF) && TweetUtils.isEnumSpecialMethod(original))) {
                if (!(original.getName().equals(StandardNames.ENUM_VALUES) && TweetUtils.isEnumSpecialMethod(original))) {
                    Name name = original.getName();
                    CloneableClassScope cloneableClassScope = CloneableClassScope.Companion;
                    if (!Intrinsics.areEqual(name, CloneableClassScope.CLONE_NAME) || !original.getValueParameters().isEmpty()) {
                        z = false;
                    }
                }
            }
            if (z) {
                return mapJvmFunctionSignature(original);
            }
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
    }
}
