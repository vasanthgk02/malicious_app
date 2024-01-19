package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.mpl.androidapp.login.LoginReactModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class TypeUtils {
    public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomConstructor("DONT_CARE", ErrorUtils.createErrorTypeConstructorWithCustomDebugName("DONT_CARE", ErrorUtils.ERROR_CLASS));
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    public static class SpecialType extends DelegatingSimpleType {
        public final String name;

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void $$$reportNull$$$0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L_0x0009
                if (r9 == r0) goto L_0x0009
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto L_0x000b
            L_0x0009:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            L_0x000b:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L_0x0013
                if (r9 == r0) goto L_0x0013
                r5 = 3
                goto L_0x0014
            L_0x0013:
                r5 = 2
            L_0x0014:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L_0x0030
                if (r9 == r4) goto L_0x002b
                if (r9 == r3) goto L_0x0026
                if (r9 == r0) goto L_0x0030
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L_0x0032
            L_0x0026:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L_0x0032
            L_0x002b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L_0x0032
            L_0x0030:
                r5[r7] = r6
            L_0x0032:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L_0x003e
                if (r9 == r0) goto L_0x003b
                r5[r1] = r6
                goto L_0x0043
            L_0x003b:
                r5[r1] = r7
                goto L_0x0043
            L_0x003e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L_0x0043:
                if (r9 == r1) goto L_0x0057
                if (r9 == r4) goto L_0x0053
                if (r9 == r3) goto L_0x0050
                if (r9 == r0) goto L_0x0057
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L_0x0057
            L_0x0050:
                r5[r4] = r7
                goto L_0x0057
            L_0x0053:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L_0x0057:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L_0x0065
                if (r9 == r0) goto L_0x0065
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L_0x006a
            L_0x0065:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L_0x006a:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType.$$$reportNull$$$0(int):void");
        }

        public SpecialType(String str) {
            this.name = str;
        }

        public SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        public SpecialType refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            $$$reportNull$$$0(3);
            throw null;
        }

        public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
            throw new IllegalStateException(this.name);
        }

        public String toString() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            $$$reportNull$$$0(1);
            throw null;
        }

        public SimpleType makeNullableAsSpecified(boolean z) {
            throw new IllegalStateException(this.name);
        }

        public SimpleType replaceAnnotations(Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(0);
                throw null;
            }
            throw new IllegalStateException(this.name);
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        int i3 = i;
        if (!(i3 == 4 || i3 == 9 || i3 == 11 || i3 == 15 || i3 == 17 || i3 == 19 || i3 == 26 || i3 == 35 || i3 == 47 || i3 == 52 || i3 == 6 || i3 == 7)) {
            switch (i3) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i3 == 4 || i3 == 9 || i3 == 11 || i3 == 15 || i3 == 17 || i3 == 19 || i3 == 26 || i3 == 35 || i3 == 47 || i3 == 52 || i3 == 6 || i3 == 7)) {
            switch (i3) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    i2 = 3;
                    break;
            }
        }
        i2 = 2;
        Object[] objArr = new Object[i2];
        switch (i3) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY;
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = LoginReactModule.RESULT;
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "parameterDescriptor";
                break;
            case 46:
            case 50:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 48:
            case 49:
                objArr[0] = "supertypes";
                break;
            case 51:
            case 54:
                objArr[0] = "expectedType";
                break;
            case 53:
                objArr[0] = "literalTypeConstructor";
                break;
            default:
                objArr[0] = "type";
                break;
        }
        if (i3 != 4) {
            if (i3 != 9) {
                if (i3 == 11 || i3 == 15) {
                    objArr[1] = "makeUnsubstitutedType";
                } else if (i3 == 17) {
                    objArr[1] = "getDefaultTypeProjections";
                } else if (i3 == 19) {
                    objArr[1] = "getImmediateSupertypes";
                } else if (i3 == 26) {
                    objArr[1] = "getAllSupertypes";
                } else if (i3 == 35) {
                    objArr[1] = "substituteProjectionsForParameters";
                } else if (i3 != 47) {
                    if (i3 != 52) {
                        if (!(i3 == 6 || i3 == 7)) {
                            switch (i3) {
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                    break;
                                default:
                                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                                    break;
                            }
                        }
                    }
                    objArr[1] = "getPrimitiveNumberType";
                } else {
                    objArr[1] = "getDefaultPrimitiveNumberType";
                }
            }
            objArr[1] = "makeNullableIfNeeded";
        } else {
            objArr[1] = "makeNullableAsSpecified";
        }
        switch (i3) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
                objArr[2] = "makeStarProjection";
                break;
            case 46:
            case 48:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 49:
                objArr[2] = "findByFqName";
                break;
            case 50:
            case 51:
            case 53:
            case 54:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 59:
                objArr[2] = "isTypeParameter";
                break;
            case 60:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 61:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i3 == 4 || i3 == 9 || i3 == 11 || i3 == 15 || i3 == 17 || i3 == 19 || i3 == 26 || i3 == 35 || i3 == 47 || i3 == 52 || i3 == 6 || i3 == 7)) {
            switch (i3) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
        }
        th = new IllegalStateException(format);
        throw th;
    }

    public static boolean acceptsNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
            throw null;
        } else if (kotlinType.isMarkedNullable()) {
            return true;
        } else {
            if (!TweetUtils.isFlexible(kotlinType) || !acceptsNullable(TweetUtils.asFlexibleType(kotlinType).upperBound)) {
                return false;
            }
            return true;
        }
    }

    public static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1) {
        if (function1 != null) {
            return contains(kotlinType, function1, null);
        }
        $$$reportNull$$$0(43);
        throw null;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (TypeParameterDescriptor defaultType : list) {
                arrayList.add(new TypeProjectionImpl(defaultType.getDefaultType()));
            }
            return ArraysKt___ArraysJvmKt.toList(arrayList);
        }
        $$$reportNull$$$0(16);
        throw null;
    }

    public static boolean isNullableType(KotlinType kotlinType) {
        if (kotlinType != null) {
            boolean z = true;
            if (kotlinType.isMarkedNullable()) {
                return true;
            }
            if (TweetUtils.isFlexible(kotlinType) && isNullableType(TweetUtils.asFlexibleType(kotlinType).upperBound)) {
                return true;
            }
            Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            if (kotlinType.unwrap() instanceof DefinitelyNotNullType) {
                return false;
            }
            if (isTypeParameter(kotlinType)) {
                if (!(kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor)) {
                    TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
                    Collection<KotlinType> supertypes = kotlinType.getConstructor().getSupertypes();
                    ArrayList arrayList = new ArrayList(supertypes.size());
                    for (KotlinType next : supertypes) {
                        if (next != null) {
                            KotlinType substitute = create.substitute(next, Variance.INVARIANT);
                            Object makeNullableIfNeeded = substitute != null ? makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable()) : null;
                            if (makeNullableIfNeeded != null) {
                                arrayList.add(makeNullableIfNeeded);
                            }
                        } else {
                            $$$reportNull$$$0(21);
                            throw null;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (isNullableType((KotlinType) it.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                return z;
            }
            TypeConstructor constructor = kotlinType.getConstructor();
            if (constructor instanceof IntersectionTypeConstructor) {
                for (KotlinType isNullableType : constructor.getSupertypes()) {
                    if (isNullableType(isNullableType)) {
                        return true;
                    }
                }
            }
            return false;
        }
        $$$reportNull$$$0(27);
        throw null;
    }

    public static boolean isTypeParameter(KotlinType kotlinType) {
        if ((kotlinType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) kotlinType.getConstructor().getDeclarationDescriptor() : null) != null) {
            return true;
        }
        kotlinType.getConstructor();
        return false;
    }

    public static KotlinType makeNotNullable(KotlinType kotlinType) {
        if (kotlinType != null) {
            return makeNullableAsSpecified(kotlinType, false);
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public static KotlinType makeNullableAsSpecified(KotlinType kotlinType, boolean z) {
        if (kotlinType != null) {
            UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
            if (makeNullableAsSpecified != null) {
                return makeNullableAsSpecified;
            }
            $$$reportNull$$$0(4);
            throw null;
        }
        $$$reportNull$$$0(3);
        throw null;
    }

    public static KotlinType makeNullableIfNeeded(KotlinType kotlinType, boolean z) {
        if (kotlinType != null) {
            return z ? makeNullableAsSpecified(kotlinType, true) : kotlinType;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        $$$reportNull$$$0(45);
        throw null;
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (!ErrorUtils.isError(classifierDescriptor)) {
            return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
        }
        return ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
    }

    public static boolean noExpectedType(KotlinType kotlinType) {
        if (kotlinType != null) {
            return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1, SmartSet<KotlinType> smartSet) {
        FlexibleType flexibleType = null;
        if (function1 == null) {
            $$$reportNull$$$0(44);
            throw null;
        } else if (kotlinType == null) {
            return false;
        } else {
            UnwrappedType unwrap = kotlinType.unwrap();
            if (noExpectedType(kotlinType)) {
                return ((Boolean) function1.invoke(unwrap)).booleanValue();
            }
            if (smartSet != null && smartSet.contains(kotlinType)) {
                return false;
            }
            if (((Boolean) function1.invoke(unwrap)).booleanValue()) {
                return true;
            }
            if (smartSet == null) {
                smartSet = SmartSet.create();
            }
            smartSet.add(kotlinType);
            if (unwrap instanceof FlexibleType) {
                flexibleType = (FlexibleType) unwrap;
            }
            if (flexibleType != null && (contains(flexibleType.lowerBound, function1, smartSet) || contains(flexibleType.upperBound, function1, smartSet))) {
                return true;
            }
            if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).original, function1, smartSet)) {
                return true;
            }
            TypeConstructor constructor = kotlinType.getConstructor();
            if (constructor instanceof IntersectionTypeConstructor) {
                for (KotlinType contains : ((IntersectionTypeConstructor) constructor).intersectedTypes) {
                    if (contains(contains, function1, smartSet)) {
                        return true;
                    }
                }
                return false;
            }
            for (TypeProjection next : kotlinType.getArguments()) {
                if (!next.isStarProjection()) {
                    if (contains(next.getType(), function1, smartSet)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static SimpleType makeNullableIfNeeded(SimpleType simpleType, boolean z) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (z) {
            SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
            if (makeNullableAsSpecified != null) {
                return makeNullableAsSpecified;
            }
            $$$reportNull$$$0(6);
            throw null;
        } else if (simpleType != null) {
            return simpleType;
        } else {
            $$$reportNull$$$0(7);
            throw null;
        }
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
            throw null;
        } else if (memberScope == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (function1 != null) {
            List<TypeProjection> defaultTypeProjections = getDefaultTypeProjections(typeConstructor.getParameters());
            if (Annotations.Companion != null) {
                return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Companion.EMPTY, typeConstructor, defaultTypeProjections, false, memberScope, function1);
            }
            throw null;
        } else {
            $$$reportNull$$$0(14);
            throw null;
        }
    }
}
