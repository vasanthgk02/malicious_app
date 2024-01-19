package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$containsTypeAliasParameters$1;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$requiresTypeAliasExpansion$1;

/* compiled from: TypeAliasExpander.kt */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion(null);
    public final TypeAliasExpansionReportStrategy reportStrategy;
    public final boolean shouldCheckBounds;

    /* compiled from: TypeAliasExpander.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
        this.reportStrategy = typeAliasExpansionReportStrategy;
        this.shouldCheckBounds = z;
    }

    public final void checkRepeatedAnnotations(Annotations<AnnotationDescriptor> annotations, Annotations<AnnotationDescriptor> annotations2) {
        HashSet hashSet = new HashSet();
        for (AnnotationDescriptor fqName : annotations) {
            hashSet.add(fqName.getFqName());
        }
        for (AnnotationDescriptor annotationDescriptor : annotations2) {
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    public final SimpleType combineAnnotations(SimpleType simpleType, Annotations annotations) {
        return TweetUtils.isError(simpleType) ? simpleType : TweetUtils.replace$default(simpleType, null, createCombinedAnnotations(simpleType, annotations), 1);
    }

    public final Annotations createCombinedAnnotations(KotlinType kotlinType, Annotations annotations) {
        if (TweetUtils.isError(kotlinType)) {
            return kotlinType.getAnnotations();
        }
        return TweetUtils.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    public final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection expandTypeProjection = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.descriptor.getUnderlyingType()), typeAliasExpansion, null, i);
        KotlinType type = expandTypeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "expandedProjection.type");
        SimpleType asSimpleType = TweetUtils.asSimpleType(type);
        if (TweetUtils.isError(asSimpleType)) {
            return asSimpleType;
        }
        boolean z3 = expandTypeProjection.getProjectionKind() == Variance.INVARIANT;
        if (!_Assertions.ENABLED || z3) {
            checkRepeatedAnnotations(asSimpleType.getAnnotations(), annotations);
            SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(combineAnnotations(asSimpleType, annotations), z);
            Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
            if (z2) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                TypeConstructor typeConstructor = typeAliasExpansion.descriptor.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                makeNullableIfNeeded = SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.arguments, z, Empty.INSTANCE));
            }
            return makeNullableIfNeeded;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type alias expansion: result for ");
        outline73.append(typeAliasExpansion.descriptor);
        outline73.append(" is ");
        outline73.append(expandTypeProjection.getProjectionKind());
        outline73.append(", should be invariant");
        throw new AssertionError(outline73.toString());
    }

    public final TypeProjection expandTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        KotlinType kotlinType;
        TypeProjection typeProjection2;
        TypeAliasExpansion typeAliasExpansion2 = typeAliasExpansion;
        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
        int i2 = i;
        TypeAliasDescriptor typeAliasDescriptor = typeAliasExpansion2.descriptor;
        if (i2 > 100) {
            throw new AssertionError(Intrinsics.stringPlus("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
        } else if (typeProjection.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection;
        } else {
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "underlyingProjection.type");
            TypeConstructor constructor = type.getConstructor();
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
            Variance variance = null;
            TypeProjection typeProjection3 = declarationDescriptor instanceof TypeParameterDescriptor ? typeAliasExpansion2.mapping.get(declarationDescriptor) : null;
            if (typeProjection3 == null) {
                UnwrappedType unwrap = typeProjection.getType().unwrap();
                if (!TweetUtils.isDynamic(unwrap)) {
                    SimpleType asSimpleType = TweetUtils.asSimpleType(unwrap);
                    if (!TweetUtils.isError(asSimpleType)) {
                        Intrinsics.checkNotNullParameter(asSimpleType, "<this>");
                        if (TypeUtilsKt.contains(asSimpleType, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE)) {
                            TypeConstructor constructor2 = asSimpleType.getConstructor();
                            ClassifierDescriptor declarationDescriptor2 = constructor2.getDeclarationDescriptor();
                            int i3 = 0;
                            boolean z = constructor2.getParameters().size() == asSimpleType.getArguments().size();
                            if (_Assertions.ENABLED && !z) {
                                throw new AssertionError(Intrinsics.stringPlus("Unexpected malformed type: ", asSimpleType));
                            } else if (!(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
                                if (declarationDescriptor2 instanceof TypeAliasDescriptor) {
                                    TypeAliasDescriptor typeAliasDescriptor2 = (TypeAliasDescriptor) declarationDescriptor2;
                                    if (typeAliasExpansion2.isRecursion(typeAliasDescriptor2)) {
                                        this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor2);
                                        typeProjection2 = new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(Intrinsics.stringPlus("Recursive type alias: ", typeAliasDescriptor2.getName())));
                                    } else {
                                        List<TypeProjection> arguments = asSimpleType.getArguments();
                                        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arguments, 10));
                                        for (T next : arguments) {
                                            int i4 = i3 + 1;
                                            if (i3 >= 0) {
                                                arrayList.add(expandTypeProjection((TypeProjection) next, typeAliasExpansion2, constructor2.getParameters().get(i3), i2 + 1));
                                                i3 = i4;
                                            } else {
                                                TweetUtils.throwIndexOverflow();
                                                throw null;
                                            }
                                        }
                                        Intrinsics.checkNotNullParameter(typeAliasDescriptor2, "typeAliasDescriptor");
                                        Intrinsics.checkNotNullParameter(arrayList, "arguments");
                                        List<TypeParameterDescriptor> parameters = typeAliasDescriptor2.getTypeConstructor().getParameters();
                                        Intrinsics.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
                                        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(parameters, 10));
                                        for (TypeParameterDescriptor original : parameters) {
                                            arrayList2.add(original.getOriginal());
                                        }
                                        TypeAliasExpansion typeAliasExpansion3 = new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor2, arrayList, ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) ArraysKt___ArraysJvmKt.zip(arrayList2, arrayList)), null);
                                        SimpleType expandRecursively = expandRecursively(typeAliasExpansion3, asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i2 + 1, false);
                                        SimpleType substituteArguments = substituteArguments(asSimpleType, typeAliasExpansion2, i2);
                                        if (!TweetUtils.isDynamic(expandRecursively)) {
                                            expandRecursively = SpecialTypesKt.withAbbreviation(expandRecursively, substituteArguments);
                                        }
                                        typeProjection2 = new TypeProjectionImpl(typeProjection.getProjectionKind(), expandRecursively);
                                    }
                                } else {
                                    SimpleType substituteArguments2 = substituteArguments(asSimpleType, typeAliasExpansion2, i2);
                                    TypeSubstitutor create = TypeSubstitutor.create((KotlinType) substituteArguments2);
                                    Intrinsics.checkNotNullExpressionValue(create, "create(substitutedType)");
                                    for (T next2 : substituteArguments2.getArguments()) {
                                        int i5 = i3 + 1;
                                        if (i3 >= 0) {
                                            TypeProjection typeProjection4 = (TypeProjection) next2;
                                            if (!typeProjection4.isStarProjection()) {
                                                KotlinType type2 = typeProjection4.getType();
                                                Intrinsics.checkNotNullExpressionValue(type2, "substitutedArgument.type");
                                                Intrinsics.checkNotNullParameter(type2, "<this>");
                                                if (!TypeUtilsKt.contains(type2, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE)) {
                                                    TypeProjection typeProjection5 = asSimpleType.getArguments().get(i3);
                                                    TypeParameterDescriptor typeParameterDescriptor3 = asSimpleType.getConstructor().getParameters().get(i3);
                                                    if (this.shouldCheckBounds) {
                                                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                                                        KotlinType type3 = typeProjection5.getType();
                                                        Intrinsics.checkNotNullExpressionValue(type3, "unsubstitutedArgument.type");
                                                        KotlinType type4 = typeProjection4.getType();
                                                        Intrinsics.checkNotNullExpressionValue(type4, "substitutedArgument.type");
                                                        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor3, "typeParameter");
                                                        Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
                                                        Intrinsics.checkNotNullParameter(type3, "unsubstitutedArgument");
                                                        Intrinsics.checkNotNullParameter(type4, "typeArgument");
                                                        Intrinsics.checkNotNullParameter(typeParameterDescriptor3, "typeParameterDescriptor");
                                                        Intrinsics.checkNotNullParameter(create, "substitutor");
                                                        for (KotlinType safeSubstitute : typeParameterDescriptor3.getUpperBounds()) {
                                                            KotlinType safeSubstitute2 = create.safeSubstitute(safeSubstitute, Variance.INVARIANT);
                                                            Intrinsics.checkNotNullExpressionValue(safeSubstitute2, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                                                            if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(type4, safeSubstitute2)) {
                                                                typeAliasExpansionReportStrategy.boundsViolationInSubstitution(safeSubstitute2, type3, type4, typeParameterDescriptor3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i3 = i5;
                                        } else {
                                            TweetUtils.throwIndexOverflow();
                                            throw null;
                                        }
                                    }
                                    typeProjection2 = new TypeProjectionImpl(typeProjection.getProjectionKind(), substituteArguments2);
                                }
                                return typeProjection2;
                            }
                        }
                    }
                }
                typeProjection2 = typeProjection;
                return typeProjection2;
            } else if (typeProjection3.isStarProjection()) {
                Intrinsics.checkNotNull(typeParameterDescriptor);
                TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
                Intrinsics.checkNotNullExpressionValue(makeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
                return makeStarProjection2;
            } else {
                UnwrappedType unwrap2 = typeProjection3.getType().unwrap();
                Variance projectionKind = typeProjection3.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
                Variance projectionKind2 = typeProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
                if (projectionKind2 != projectionKind) {
                    Variance variance2 = Variance.INVARIANT;
                    if (projectionKind2 != variance2) {
                        if (projectionKind == variance2) {
                            projectionKind = projectionKind2;
                        } else {
                            this.reportStrategy.conflictingProjection(typeAliasExpansion2.descriptor, typeParameterDescriptor2, unwrap2);
                        }
                    }
                }
                if (typeParameterDescriptor2 != null) {
                    variance = typeParameterDescriptor.getVariance();
                }
                if (variance == null) {
                    variance = Variance.INVARIANT;
                }
                Intrinsics.checkNotNullExpressionValue(variance, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
                if (variance != projectionKind) {
                    Variance variance3 = Variance.INVARIANT;
                    if (variance != variance3) {
                        if (projectionKind == variance3) {
                            projectionKind = variance3;
                        } else {
                            this.reportStrategy.conflictingProjection(typeAliasExpansion2.descriptor, typeParameterDescriptor2, unwrap2);
                        }
                    }
                }
                checkRepeatedAnnotations(type.getAnnotations(), unwrap2.getAnnotations());
                if (unwrap2 instanceof DynamicType) {
                    DynamicType dynamicType = (DynamicType) unwrap2;
                    Annotations createCombinedAnnotations = createCombinedAnnotations(dynamicType, type.getAnnotations());
                    Intrinsics.checkNotNullParameter(createCombinedAnnotations, "newAnnotations");
                    kotlinType = new DynamicType(TypeUtilsKt.getBuiltIns(dynamicType.upperBound), createCombinedAnnotations);
                } else {
                    SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(TweetUtils.asSimpleType(unwrap2), type.isMarkedNullable());
                    Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
                    kotlinType = combineAnnotations(makeNullableIfNeeded, type.getAnnotations());
                }
                return new TypeProjectionImpl(projectionKind, kotlinType);
            }
        }
    }

    public final SimpleType substituteArguments(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = simpleType.getConstructor();
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (T next : arguments) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                TypeProjection typeProjection = (TypeProjection) next;
                TypeProjection expandTypeProjection = expandTypeProjection(typeProjection, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
                if (!expandTypeProjection.isStarProjection()) {
                    expandTypeProjection = new TypeProjectionImpl(expandTypeProjection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(expandTypeProjection.getType(), typeProjection.getType().isMarkedNullable()));
                }
                arrayList.add(expandTypeProjection);
                i2 = i3;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        return TweetUtils.replace$default(simpleType, arrayList, null, 2);
    }
}
