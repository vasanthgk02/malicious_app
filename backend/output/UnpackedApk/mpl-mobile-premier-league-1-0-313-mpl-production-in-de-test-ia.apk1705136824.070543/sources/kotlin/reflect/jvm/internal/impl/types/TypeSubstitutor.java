package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1;
import org.apache.fontbox.cmap.CMapParser;

public class TypeSubstitutor {
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    public final TypeSubstitution substitution;

    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                            }
                    }
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                            }
                    }
            }
        }
        i2 = 2;
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = AnonymousClass27.SECOND;
                break;
            case 4:
                objArr[0] = "substitutionContext";
                break;
            case 5:
                objArr[0] = "context";
                break;
            case 8:
            case 13:
                objArr[0] = "type";
                break;
            case 9:
            case 14:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 15:
            case 16:
            case 34:
                objArr[0] = "typeProjection";
                break;
            case 17:
            case 26:
                objArr[0] = "originalProjection";
                break;
            case 24:
                objArr[0] = "originalType";
                break;
            case 25:
                objArr[0] = "substituted";
                break;
            case 31:
                objArr[0] = "annotations";
                break;
            case 33:
            case 36:
                objArr[0] = "typeParameterVariance";
                break;
            case 37:
                objArr[0] = "projectionKind";
                break;
            default:
                objArr[0] = "substitution";
                break;
        }
        if (i == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i == 7) {
            objArr[1] = "getSubstitution";
        } else if (i != 32) {
            if (i != 35) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                        objArr[1] = "safeSubstitute";
                        break;
                    default:
                        switch (i) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                                objArr[1] = "unsafeSubstitute";
                                break;
                            default:
                                switch (i) {
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                        objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                        break;
                                    default:
                                        switch (i) {
                                            case 38:
                                            case 39:
                                            case 40:
                                                break;
                                            default:
                                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                break;
                                        }
                                }
                        }
                }
            }
            objArr[1] = "combine";
        } else {
            objArr[1] = "filterOutUnsafeVariance";
        }
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                break;
            case 2:
            case 3:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 6:
                objArr[2] = "<init>";
                break;
            case 8:
            case 9:
                objArr[2] = "safeSubstitute";
                break;
            case 13:
            case 14:
            case 15:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 17:
                objArr[2] = "unsafeSubstitute";
                break;
            case 24:
            case 25:
            case 26:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 31:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[2] = "combine";
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            th = new IllegalArgumentException(format);
                                            break;
                                    }
                            }
                    }
            }
        }
        th = new IllegalStateException(format);
        throw th;
    }

    public TypeSubstitutor(TypeSubstitution typeSubstitution) {
        if (typeSubstitution != null) {
            this.substitution = typeSubstitution;
        } else {
            $$$reportNull$$$0(6);
            throw null;
        }
    }

    public static Variance combine(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            $$$reportNull$$$0(33);
            throw null;
        } else if (typeProjection == null) {
            $$$reportNull$$$0(34);
            throw null;
        } else if (!typeProjection.isStarProjection()) {
            return combine(variance, typeProjection.getProjectionKind());
        } else {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 != null) {
                return variance2;
            }
            $$$reportNull$$$0(35);
            throw null;
        }
    }

    public static VarianceConflictType conflictType(Variance variance, Variance variance2) {
        if (variance == Variance.IN_VARIANCE && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == Variance.IN_VARIANCE) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor create(TypeSubstitution typeSubstitution) {
        return new TypeSubstitutor(typeSubstitution);
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(2);
            throw null;
        } else if (typeSubstitution2 != null) {
            Intrinsics.checkNotNullParameter(typeSubstitution, "first");
            Intrinsics.checkNotNullParameter(typeSubstitution2, AnonymousClass27.SECOND);
            if (typeSubstitution.isEmpty()) {
                typeSubstitution = typeSubstitution2;
            } else if (!typeSubstitution2.isEmpty()) {
                typeSubstitution = new DisjointKeysUnionTypeSubstitution(typeSubstitution, typeSubstitution2, null);
            }
            return create(typeSubstitution);
        } else {
            $$$reportNull$$$0(3);
            throw null;
        }
    }

    public static String safeToString(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!TypeUtilsKt.isProcessCanceledException(th)) {
                return "[Exception while computing toString(): " + th + CMapParser.MARK_END_OF_ARRAY;
            }
            throw th;
        }
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution != null) {
            return typeSubstitution;
        }
        $$$reportNull$$$0(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public KotlinType safeSubstitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
            throw null;
        } else if (variance == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (!isEmpty()) {
            try {
                KotlinType type = unsafeSubstitute(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
                if (type != null) {
                    return type;
                }
                $$$reportNull$$$0(11);
                throw null;
            } catch (SubstitutionException e2) {
                return ErrorUtils.createErrorType(e2.getMessage());
            }
        } else if (kotlinType != null) {
            return kotlinType;
        } else {
            $$$reportNull$$$0(10);
            throw null;
        }
    }

    public KotlinType substitute(KotlinType kotlinType, Variance variance) {
        TypeProjection typeProjectionImpl;
        if (kotlinType == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (variance != null) {
            TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
            if (this.substitution.approximateCapturedTypes() || this.substitution.approximateContravariantCapturedTypes()) {
                boolean approximateContravariantCapturedTypes = this.substitution.approximateContravariantCapturedTypes();
                if (substituteWithoutApproximation == null) {
                    substituteWithoutApproximation = null;
                } else if (!substituteWithoutApproximation.isStarProjection()) {
                    KotlinType type = substituteWithoutApproximation.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                    if (TypeUtils.contains(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.INSTANCE)) {
                        Variance projectionKind = substituteWithoutApproximation.getProjectionKind();
                        Intrinsics.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
                        if (projectionKind == Variance.OUT_VARIANCE) {
                            typeProjectionImpl = new TypeProjectionImpl(projectionKind, (KotlinType) TypeUtilsKt.approximateCapturedTypes(type).upper);
                        } else if (approximateContravariantCapturedTypes) {
                            typeProjectionImpl = new TypeProjectionImpl(projectionKind, (KotlinType) TypeUtilsKt.approximateCapturedTypes(type).lower);
                        } else {
                            TypeSubstitutor create = create((TypeSubstitution) new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1());
                            Intrinsics.checkNotNullExpressionValue(create, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
                            substituteWithoutApproximation = create.substituteWithoutApproximation(substituteWithoutApproximation);
                        }
                        substituteWithoutApproximation = typeProjectionImpl;
                    }
                }
            }
            if (substituteWithoutApproximation == null) {
                return null;
            }
            return substituteWithoutApproximation.getType();
        } else {
            $$$reportNull$$$0(14);
            throw null;
        }
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
            throw null;
        } else if (isEmpty()) {
            return typeProjection;
        } else {
            try {
                return unsafeSubstitute(typeProjection, null, 0);
            } catch (SubstitutionException unused) {
                return null;
            }
        }
    }

    public final TypeProjection unsafeSubstitute(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor, int i) throws SubstitutionException {
        KotlinType kotlinType;
        TypeSubstitutor typeSubstitutor;
        KotlinType kotlinType2;
        KotlinType kotlinType3 = null;
        if (typeProjection != null) {
            TypeSubstitution typeSubstitution = this.substitution;
            if (i > 100) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Recursion too deep. Most likely infinite loop while substituting ");
                outline73.append(safeToString(typeProjection));
                outline73.append("; substitution: ");
                outline73.append(safeToString(typeSubstitution));
                throw new IllegalStateException(outline73.toString());
            } else if (typeProjection.isStarProjection()) {
                return typeProjection;
            } else {
                KotlinType type = typeProjection.getType();
                if (type instanceof TypeWithEnhancement) {
                    TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
                    UnwrappedType origin = typeWithEnhancement.getOrigin();
                    KotlinType enhancement = typeWithEnhancement.getEnhancement();
                    TypeProjection unsafeSubstitute = unsafeSubstitute(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
                    return new TypeProjectionImpl(unsafeSubstitute.getProjectionKind(), TweetUtils.wrapEnhancement(unsafeSubstitute.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
                }
                if (!TweetUtils.isDynamic(type) && !(type.unwrap() instanceof RawType)) {
                    TypeProjection typeProjection2 = this.substitution.get(type);
                    if (typeProjection2 == null) {
                        typeProjection2 = null;
                    } else if (type.getAnnotations().hasAnnotation(FqNames.unsafeVariance)) {
                        TypeConstructor constructor = typeProjection2.getType().getConstructor();
                        if (constructor instanceof NewCapturedTypeConstructor) {
                            TypeProjection typeProjection3 = ((NewCapturedTypeConstructor) constructor).projection;
                            Variance projectionKind = typeProjection3.getProjectionKind();
                            if (conflictType(typeProjection.getProjectionKind(), projectionKind) == VarianceConflictType.OUT_IN_IN_POSITION) {
                                typeProjection2 = new TypeProjectionImpl(typeProjection3.getType());
                            } else if (typeParameterDescriptor != null && conflictType(typeParameterDescriptor.getVariance(), projectionKind) == VarianceConflictType.OUT_IN_IN_POSITION) {
                                typeProjection2 = new TypeProjectionImpl(typeProjection3.getType());
                            }
                        }
                    }
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    if (typeProjection2 == null && TweetUtils.isFlexible(type)) {
                        Intrinsics.checkNotNullParameter(type, "<this>");
                        UnwrappedType unwrap = type.unwrap();
                        CustomTypeVariable customTypeVariable = unwrap instanceof CustomTypeVariable ? (CustomTypeVariable) unwrap : null;
                        if (!(customTypeVariable == null ? false : customTypeVariable.isTypeVariable())) {
                            FlexibleType asFlexibleType = TweetUtils.asFlexibleType(type);
                            int i2 = i + 1;
                            TypeProjection unsafeSubstitute2 = unsafeSubstitute(new TypeProjectionImpl(projectionKind2, asFlexibleType.lowerBound), typeParameterDescriptor, i2);
                            TypeProjection unsafeSubstitute3 = unsafeSubstitute(new TypeProjectionImpl(projectionKind2, asFlexibleType.upperBound), typeParameterDescriptor, i2);
                            Variance projectionKind3 = unsafeSubstitute2.getProjectionKind();
                            if (unsafeSubstitute2.getType() == asFlexibleType.lowerBound && unsafeSubstitute3.getType() == asFlexibleType.upperBound) {
                                return typeProjection;
                            }
                            return new TypeProjectionImpl(projectionKind3, KotlinTypeFactory.flexibleType(TweetUtils.asSimpleType(unsafeSubstitute2.getType()), TweetUtils.asSimpleType(unsafeSubstitute3.getType())));
                        }
                    }
                    if (!KotlinBuiltIns.isNothing(type) && !TweetUtils.isError(type)) {
                        if (typeProjection2 != null) {
                            VarianceConflictType conflictType = conflictType(projectionKind2, typeProjection2.getProjectionKind());
                            if (!TweetUtils.isCaptured(type)) {
                                int ordinal = conflictType.ordinal();
                                if (ordinal == 1) {
                                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                                }
                                if (ordinal == 2) {
                                    throw new SubstitutionException("Out-projection in in-position");
                                }
                            }
                            Intrinsics.checkNotNullParameter(type, "<this>");
                            UnwrappedType unwrap2 = type.unwrap();
                            CustomTypeVariable customTypeVariable2 = unwrap2 instanceof CustomTypeVariable ? (CustomTypeVariable) unwrap2 : null;
                            if (customTypeVariable2 == null || !customTypeVariable2.isTypeVariable()) {
                                customTypeVariable2 = null;
                            }
                            if (typeProjection2.isStarProjection()) {
                                return typeProjection2;
                            }
                            if (customTypeVariable2 != null) {
                                kotlinType2 = customTypeVariable2.substitutionResult(typeProjection2.getType());
                            } else {
                                kotlinType2 = TypeUtils.makeNullableIfNeeded(typeProjection2.getType(), type.isMarkedNullable());
                            }
                            if (!type.getAnnotations().isEmpty()) {
                                Annotations filterAnnotations = this.substitution.filterAnnotations(type.getAnnotations());
                                if (filterAnnotations != null) {
                                    if (filterAnnotations.hasAnnotation(FqNames.unsafeVariance)) {
                                        filterAnnotations = new FilteredAnnotations(filterAnnotations, new Function1<FqName, Boolean>() {
                                            public Object invoke(Object obj) {
                                                FqName fqName = (FqName) obj;
                                                if (fqName != null) {
                                                    return Boolean.valueOf(!fqName.equals(FqNames.unsafeVariance));
                                                }
                                                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"}));
                                            }
                                        });
                                    }
                                    kotlinType2 = TypeUtilsKt.replaceAnnotations(kotlinType2, new CompositeAnnotations(kotlinType2.getAnnotations(), filterAnnotations));
                                } else {
                                    $$$reportNull$$$0(31);
                                    throw null;
                                }
                            }
                            if (conflictType == VarianceConflictType.NO_CONFLICT) {
                                projectionKind2 = combine(projectionKind2, typeProjection2.getProjectionKind());
                            }
                            return new TypeProjectionImpl(projectionKind2, kotlinType2);
                        }
                        KotlinType type2 = typeProjection.getType();
                        Variance projectionKind4 = typeProjection.getProjectionKind();
                        if (!(type2.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                            Intrinsics.checkNotNullParameter(type2, "<this>");
                            Intrinsics.checkNotNullParameter(type2, "<this>");
                            UnwrappedType unwrap3 = type2.unwrap();
                            AbbreviatedType abbreviatedType = unwrap3 instanceof AbbreviatedType ? (AbbreviatedType) unwrap3 : null;
                            if (abbreviatedType == null) {
                                kotlinType = null;
                            } else {
                                kotlinType = abbreviatedType.abbreviation;
                            }
                            if (kotlinType != null) {
                                TypeSubstitution typeSubstitution2 = this.substitution;
                                if (!(typeSubstitution2 instanceof IndexedParametersSubstitution) || !typeSubstitution2.approximateContravariantCapturedTypes()) {
                                    typeSubstitutor = this;
                                } else {
                                    IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) this.substitution;
                                    typeSubstitutor = new TypeSubstitutor(new IndexedParametersSubstitution(indexedParametersSubstitution.parameters, indexedParametersSubstitution.arguments, false));
                                }
                                kotlinType3 = typeSubstitutor.substitute(kotlinType, Variance.INVARIANT);
                            }
                            List<TypeParameterDescriptor> parameters = type2.getConstructor().getParameters();
                            List arguments = type2.getArguments();
                            ArrayList arrayList = new ArrayList(parameters.size());
                            boolean z = false;
                            for (int i3 = 0; i3 < parameters.size(); i3++) {
                                TypeParameterDescriptor typeParameterDescriptor2 = parameters.get(i3);
                                TypeProjection typeProjection4 = (TypeProjection) arguments.get(i3);
                                TypeProjection unsafeSubstitute4 = unsafeSubstitute(typeProjection4, typeParameterDescriptor2, i + 1);
                                int ordinal2 = conflictType(typeParameterDescriptor2.getVariance(), unsafeSubstitute4.getProjectionKind()).ordinal();
                                if (ordinal2 != 0) {
                                    if (ordinal2 == 1 || ordinal2 == 2) {
                                        unsafeSubstitute4 = TypeUtils.makeStarProjection(typeParameterDescriptor2);
                                    }
                                } else if (typeParameterDescriptor2.getVariance() != Variance.INVARIANT && !unsafeSubstitute4.isStarProjection()) {
                                    unsafeSubstitute4 = new TypeProjectionImpl(Variance.INVARIANT, unsafeSubstitute4.getType());
                                }
                                if (unsafeSubstitute4 != typeProjection4) {
                                    z = true;
                                }
                                arrayList.add(unsafeSubstitute4);
                            }
                            if (z) {
                                arguments = arrayList;
                            }
                            Annotations filterAnnotations2 = this.substitution.filterAnnotations(type2.getAnnotations());
                            Intrinsics.checkNotNullParameter(type2, "<this>");
                            Intrinsics.checkNotNullParameter(arguments, "newArguments");
                            Intrinsics.checkNotNullParameter(filterAnnotations2, "newAnnotations");
                            KotlinType replace$default = TweetUtils.replace$default(type2, arguments, filterAnnotations2, null, 4);
                            if ((replace$default instanceof SimpleType) && (kotlinType3 instanceof SimpleType)) {
                                replace$default = SpecialTypesKt.withAbbreviation((SimpleType) replace$default, (SimpleType) kotlinType3);
                            }
                            typeProjection = new TypeProjectionImpl(projectionKind4, replace$default);
                        }
                    }
                }
                return typeProjection;
            }
        } else {
            $$$reportNull$$$0(17);
            throw null;
        }
    }

    public static TypeSubstitutor create(KotlinType kotlinType) {
        if (kotlinType != null) {
            return create(TypeConstructorSubstitution.Companion.create(kotlinType.getConstructor(), kotlinType.getArguments()));
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public static Variance combine(Variance variance, Variance variance2) {
        if (variance == null) {
            $$$reportNull$$$0(36);
            throw null;
        } else if (variance2 != null) {
            Variance variance3 = Variance.INVARIANT;
            if (variance == variance3) {
                if (variance2 != null) {
                    return variance2;
                }
                $$$reportNull$$$0(38);
                throw null;
            } else if (variance2 == variance3) {
                if (variance != null) {
                    return variance;
                }
                $$$reportNull$$$0(39);
                throw null;
            } else if (variance != variance2) {
                throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and " + "projection kind '" + variance2 + "' cannot be combined");
            } else if (variance2 != null) {
                return variance2;
            } else {
                $$$reportNull$$$0(40);
                throw null;
            }
        } else {
            $$$reportNull$$$0(37);
            throw null;
        }
    }
}
