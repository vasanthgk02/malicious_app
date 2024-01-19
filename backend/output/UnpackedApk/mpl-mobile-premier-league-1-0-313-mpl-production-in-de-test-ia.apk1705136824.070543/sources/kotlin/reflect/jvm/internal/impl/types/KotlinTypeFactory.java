package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    static {
        KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 kotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    }

    public static final SimpleType computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(list, "arguments");
        TypeAliasExpander typeAliasExpander = new TypeAliasExpander(DO_NOTHING.INSTANCE, false);
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(parameters, 10));
        for (TypeParameterDescriptor original : parameters) {
            arrayList.add(original.getOriginal());
        }
        TypeAliasExpansion typeAliasExpansion = new TypeAliasExpansion(null, typeAliasDescriptor, list, ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) ArraysKt___ArraysJvmKt.zip(arrayList, list)), null);
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            return typeAliasExpander.expandRecursively(typeAliasExpansion, annotations, false, 0, true);
        }
        throw null;
    }

    public static final UnwrappedType flexibleType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        if (Intrinsics.areEqual(simpleType, simpleType2)) {
            return simpleType;
        }
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    public static final SimpleType integerLiteralType(Annotations annotations, IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        EmptyList emptyList = EmptyList.INSTANCE;
        MemberScope createErrorScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(annotations, integerLiteralTypeConstructor, emptyList, z, createErrorScope);
    }

    public static final SimpleType simpleNotNullType(Annotations annotations, ClassDescriptor classDescriptor, List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(annotations, typeConstructor, list, false, null, 16);
    }

    public static final SimpleType simpleType(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, KotlinTypeRefiner kotlinTypeRefiner) {
        MemberScope create;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        if (!annotations.isEmpty() || !list.isEmpty() || z || typeConstructor.getDeclarationDescriptor() == null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                create = declarationDescriptor.getDefaultType().getMemberScope();
            } else if (declarationDescriptor instanceof ClassDescriptor) {
                if (kotlinTypeRefiner == null) {
                    kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(declarationDescriptor));
                }
                ModuleAwareClassDescriptor moduleAwareClassDescriptor = null;
                if (list.isEmpty()) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                    Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
                    Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                    Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
                    Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                    if (classDescriptor instanceof ModuleAwareClassDescriptor) {
                        moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor;
                    }
                    if (moduleAwareClassDescriptor == null) {
                        create = classDescriptor.getUnsubstitutedMemberScope();
                        Intrinsics.checkNotNullExpressionValue(create, "this.unsubstitutedMemberScope");
                    } else {
                        create = moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner);
                    }
                } else {
                    ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                    TypeSubstitution create2 = TypeConstructorSubstitution.Companion.create(typeConstructor, list);
                    Intrinsics.checkNotNullParameter(classDescriptor2, "<this>");
                    Intrinsics.checkNotNullParameter(create2, "typeSubstitution");
                    Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                    Intrinsics.checkNotNullParameter(classDescriptor2, "<this>");
                    Intrinsics.checkNotNullParameter(create2, "typeSubstitution");
                    Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                    if (classDescriptor2 instanceof ModuleAwareClassDescriptor) {
                        moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor2;
                    }
                    if (moduleAwareClassDescriptor == null) {
                        create = classDescriptor2.getMemberScope(create2);
                        Intrinsics.checkNotNullExpressionValue(create, "this.getMemberScope(\n                typeSubstitution\n            )");
                    } else {
                        create = moduleAwareClassDescriptor.getMemberScope(create2, kotlinTypeRefiner);
                    }
                }
            } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
                create = ErrorUtils.createErrorScope(Intrinsics.stringPlus("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor).getName()), true);
                Intrinsics.checkNotNullExpressionValue(create, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            } else if (typeConstructor instanceof IntersectionTypeConstructor) {
                create = TypeIntersectionScope.Companion.create("member scope for intersection type", ((IntersectionTypeConstructor) typeConstructor).intersectedTypes);
            } else {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
            }
            MemberScope memberScope = create;
            KotlinTypeFactory$simpleType$1 kotlinTypeFactory$simpleType$1 = new KotlinTypeFactory$simpleType$1(INSTANCE, typeConstructor, list, annotations, z);
            return simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, list, z, memberScope, kotlinTypeFactory$simpleType$1);
        }
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor2);
        SimpleType defaultType = declarationDescriptor2.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return defaultType;
    }

    public static /* synthetic */ SimpleType simpleType$default(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z, KotlinTypeRefiner kotlinTypeRefiner, int i) {
        int i2 = i & 16;
        return simpleType(annotations, typeConstructor, list, z, null);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 kotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 = new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(INSTANCE, typeConstructor, list, annotations, z, memberScope);
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor, list, z, memberScope, kotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1);
        return annotations.isEmpty() ? simpleTypeImpl : new AnnotatedSimpleType(simpleTypeImpl, annotations);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor, list, z, memberScope, function1);
        return annotations.isEmpty() ? simpleTypeImpl : new AnnotatedSimpleType(simpleTypeImpl, annotations);
    }
}
