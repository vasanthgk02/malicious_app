package kotlin.reflect.jvm.internal.impl.resolve;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.mpl.androidapp.login.LoginReactModule;
import com.netcore.android.utility.f;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class OverridingUtil {
    public static final OverridingUtil DEFAULT;
    public static final TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    public static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS;
    public final TypeConstructorEquality equalityAxioms;
    public final KotlinTypeRefiner kotlinTypeRefiner;

    public static class OverrideCompatibilityInfo {
        public static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        public final Result overridable;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void $$$reportNull$$$0(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto L_0x000f
                if (r10 == r2) goto L_0x000f
                if (r10 == r1) goto L_0x000f
                if (r10 == r0) goto L_0x000f
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L_0x0011
            L_0x000f:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L_0x0011:
                if (r10 == r3) goto L_0x001b
                if (r10 == r2) goto L_0x001b
                if (r10 == r1) goto L_0x001b
                if (r10 == r0) goto L_0x001b
                r5 = 2
                goto L_0x001c
            L_0x001b:
                r5 = 3
            L_0x001c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L_0x0032
                if (r10 == r2) goto L_0x0032
                if (r10 == r1) goto L_0x002f
                if (r10 == r0) goto L_0x0032
                r5[r8] = r7
                goto L_0x0036
            L_0x002f:
                r5[r8] = r6
                goto L_0x0036
            L_0x0032:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L_0x0036:
                switch(r10) {
                    case 1: goto L_0x0046;
                    case 2: goto L_0x0046;
                    case 3: goto L_0x0046;
                    case 4: goto L_0x0046;
                    case 5: goto L_0x0041;
                    case 6: goto L_0x003c;
                    default: goto L_0x0039;
                }
            L_0x0039:
                r5[r3] = r6
                goto L_0x0048
            L_0x003c:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L_0x0048
            L_0x0041:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L_0x0048
            L_0x0046:
                r5[r3] = r7
            L_0x0048:
                if (r10 == r3) goto L_0x005b
                if (r10 == r2) goto L_0x0056
                if (r10 == r1) goto L_0x0051
                if (r10 == r0) goto L_0x0051
                goto L_0x005f
            L_0x0051:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L_0x005f
            L_0x0056:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L_0x005f
            L_0x005b:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L_0x005f:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L_0x0071
                if (r10 == r2) goto L_0x0071
                if (r10 == r1) goto L_0x0071
                if (r10 == r0) goto L_0x0071
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L_0x0076
            L_0x0071:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L_0x0076:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.$$$reportNull$$$0(int):void");
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
                throw null;
            } else if (str != null) {
                this.overridable = result;
            } else {
                $$$reportNull$$$0(4);
                throw null;
            }
        }

        public static OverrideCompatibilityInfo conflict(String str) {
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public static OverrideCompatibilityInfo incompatible(String str) {
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public Result getResult() {
            Result result = this.overridable;
            if (result != null) {
                return result;
            }
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public class OverridingUtilTypeCheckerContext extends ClassicTypeCheckerContext {
        public final Map<TypeConstructor, TypeConstructor> matchingTypeConstructors;

        public OverridingUtilTypeCheckerContext(Map<TypeConstructor, TypeConstructor> map) {
            super(true, true, true, OverridingUtil.this.kotlinTypeRefiner);
            this.matchingTypeConstructors = map;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
            if (r3.equals(r5) != false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
            if (r0.equals(r6) != false) goto L_0x0036;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean areEqualTypeConstructors(kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6) {
            /*
                r4 = this;
                boolean r0 = super.areEqualTypeConstructors(r5, r6)
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x003d
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.this
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker$TypeConstructorEquality r0 = r0.equalityAxioms
                boolean r0 = r0.equals(r5, r6)
                if (r0 == 0) goto L_0x0013
                goto L_0x0036
            L_0x0013:
                java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor> r0 = r4.matchingTypeConstructors
                if (r0 != 0) goto L_0x0018
                goto L_0x0038
            L_0x0018:
                java.lang.Object r0 = r0.get(r5)
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r0
                java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor> r3 = r4.matchingTypeConstructors
                java.lang.Object r3 = r3.get(r6)
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r3
                if (r0 == 0) goto L_0x002e
                boolean r6 = r0.equals(r6)
                if (r6 != 0) goto L_0x0036
            L_0x002e:
                if (r3 == 0) goto L_0x0038
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L_0x0038
            L_0x0036:
                r5 = 1
                goto L_0x0039
            L_0x0038:
                r5 = 0
            L_0x0039:
                if (r5 == 0) goto L_0x003c
                goto L_0x003d
            L_0x003c:
                r1 = 0
            L_0x003d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverridingUtilTypeCheckerContext.areEqualTypeConstructors(kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):boolean");
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        int i3 = i;
        if (!(i3 == 9 || i3 == 10 || i3 == 14 || i3 == 19 || i3 == 93 || i3 == 96 || i3 == 101)) {
            switch (i3) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i3) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i3) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i3) {
                                        case 88:
                                        case 89:
                                        case 90:
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
        if (!(i3 == 9 || i3 == 10 || i3 == 14 || i3 == 19 || i3 == 93 || i3 == 96 || i3 == 101)) {
            switch (i3) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i3) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i3) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i3) {
                                        case 88:
                                        case 89:
                                        case 90:
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
        switch (i3) {
            case 1:
            case 2:
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = f.f1288a;
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = LoginReactModule.RESULT;
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case 75:
                objArr[0] = "typeChecker";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = "name";
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case 87:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case 85:
            case 104:
                objArr[0] = "strategy";
                break;
            case 55:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case 57:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 61:
            case 63:
                objArr[0] = "notOverridden";
                break;
            case 65:
            case 67:
            case 71:
                objArr[0] = "a";
                break;
            case 66:
            case 68:
            case 73:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case 70:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case 72:
                objArr[0] = "aReturnType";
                break;
            case 74:
                objArr[0] = "bReturnType";
                break;
            case 76:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case 97:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
            default:
                objArr[0] = "equalityAxioms";
                break;
        }
        if (i3 == 9 || i3 == 10) {
            objArr[1] = "filterOverrides";
        } else if (i3 != 14) {
            if (i3 != 19) {
                if (i3 == 93) {
                    objArr[1] = "getMinimalModality";
                } else if (i3 == 96) {
                    objArr[1] = "filterVisibleFakeOverrides";
                } else if (i3 != 101) {
                    switch (i3) {
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            break;
                        default:
                            switch (i3) {
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                    objArr[1] = "isOverridableByWithoutExternalConditions";
                                    break;
                                default:
                                    switch (i3) {
                                        case 78:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                            objArr[1] = "selectMostSpecificMember";
                                            break;
                                        default:
                                            switch (i3) {
                                                case 88:
                                                case 89:
                                                case 90:
                                                    objArr[1] = "determineModalityForFakeOverride";
                                                    break;
                                                default:
                                                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    objArr[1] = "extractMembersOverridableInBothWays";
                }
            }
            objArr[1] = "isOverridableBy";
        } else {
            objArr[1] = "getOverriddenDeclarations";
        }
        switch (i3) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerContext";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 55:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 61:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case 63:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 65:
            case 66:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 76:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case 85:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case 87:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i3 == 9 || i3 == 10 || i3 == 14 || i3 == 19 || i3 == 93 || i3 == 96 || i3 == 101)) {
            switch (i3) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i3) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i3) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i3) {
                                        case 88:
                                        case 89:
                                        case 90:
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

    static {
        Class<ExternalOverridabilityCondition> cls = ExternalOverridabilityCondition.class;
        EXTERNAL_CONDITIONS = ArraysKt___ArraysJvmKt.toList(ServiceLoader.load(cls, cls.getClassLoader()));
        AnonymousClass1 r0 = new TypeConstructorEquality() {
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                    throw null;
                } else if (typeConstructor2 != null) {
                    return typeConstructor.equals(typeConstructor2);
                } else {
                    $$$reportNull$$$0(1);
                    throw null;
                }
            }
        };
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = r0;
        DEFAULT = new OverridingUtil(r0, Default.INSTANCE);
    }

    public OverridingUtil(TypeConstructorEquality typeConstructorEquality, KotlinTypeRefiner kotlinTypeRefiner2) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (kotlinTypeRefiner2 != null) {
            this.equalityAxioms = typeConstructorEquality;
            this.kotlinTypeRefiner = kotlinTypeRefiner2;
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public static void collectOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(15);
            throw null;
        } else if (set == null) {
            $$$reportNull$$$0(16);
            throw null;
        } else if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor collectOverriddenDeclarations : callableMemberDescriptor.getOverriddenDescriptors()) {
                collectOverriddenDeclarations(collectOverriddenDeclarations, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    public static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor type : callableDescriptor.getValueParameters()) {
            arrayList.add(type.getType());
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r2 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void createAndBindFakeOverride(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r15, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r16, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy r17) {
        /*
            r0 = r15
            r1 = r16
            r6 = r17
            r2 = 0
            if (r0 == 0) goto L_0x01c9
            if (r1 == 0) goto L_0x01c3
            if (r6 == 0) goto L_0x01bd
            if (r1 == 0) goto L_0x01b7
            if (r0 == 0) goto L_0x01b1
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$5 r3 = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$5
            r3.<init>()
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysJvmKt.filter(r15, r3)
            r4 = r3
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0024
            r7 = r0
            goto L_0x0025
        L_0x0024:
            r7 = r3
        L_0x0025:
            java.util.Iterator r0 = r7.iterator()
            r3 = 0
            r5 = 1
            r8 = 0
            r9 = 0
        L_0x002d:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0074
            java.lang.Object r10 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r10
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r11 = r10.getModality()
            int r11 = r11.ordinal()
            if (r11 == 0) goto L_0x0067
            if (r11 == r5) goto L_0x0050
            r10 = 2
            if (r11 == r10) goto L_0x004e
            r10 = 3
            if (r11 == r10) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            r9 = 1
            goto L_0x002d
        L_0x004e:
            r8 = 1
            goto L_0x002d
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Member cannot have SEALED modality: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0067:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            if (r0 == 0) goto L_0x006e
        L_0x006b:
            r2 = r0
            goto L_0x0182
        L_0x006e:
            r0 = 88
            $$$reportNull$$$0(r0)
            throw r2
        L_0x0074:
            boolean r0 = r16.isExpect()
            if (r0 == 0) goto L_0x008c
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r16.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r10 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            if (r0 == r10) goto L_0x008c
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r16.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r10 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            if (r0 == r10) goto L_0x008c
            r0 = 1
            goto L_0x008d
        L_0x008c:
            r0 = 0
        L_0x008d:
            if (r8 == 0) goto L_0x009c
            if (r9 != 0) goto L_0x009c
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            if (r0 == 0) goto L_0x0096
            goto L_0x006b
        L_0x0096:
            r0 = 89
            $$$reportNull$$$0(r0)
            throw r2
        L_0x009c:
            if (r8 != 0) goto L_0x00b2
            if (r9 == 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00a7
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r16.getModality()
            goto L_0x00a9
        L_0x00a7:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
        L_0x00a9:
            if (r0 == 0) goto L_0x00ac
            goto L_0x006b
        L_0x00ac:
            r0 = 90
            $$$reportNull$$$0(r0)
            throw r2
        L_0x00b2:
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.util.Iterator r9 = r7.iterator()
        L_0x00bb:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00db
            java.lang.Object r10 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r10
            if (r10 == 0) goto L_0x00d5
            java.util.LinkedHashSet r11 = new java.util.LinkedHashSet
            r11.<init>()
            collectOverriddenDeclarations(r10, r11)
            r8.addAll(r11)
            goto L_0x00bb
        L_0x00d5:
            r0 = 13
            $$$reportNull$$$0(r0)
            throw r2
        L_0x00db:
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x010c
            java.util.Iterator r9 = r8.iterator()
            java.lang.Object r9 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(r9)
            java.lang.String r10 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.types.checker.Ref<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner>> r10 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt.REFINER_CAPABILITY
            java.lang.Object r9 = r9.getCapability(r10)
            kotlin.reflect.jvm.internal.impl.types.checker.Ref r9 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r9
            if (r9 != 0) goto L_0x0100
            r9 = r2
            goto L_0x0104
        L_0x0100:
            T r9 = r9.value
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9 = (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) r9
        L_0x0104:
            if (r9 == 0) goto L_0x0108
            r9 = 1
            goto L_0x0109
        L_0x0108:
            r9 = 0
        L_0x0109:
            if (r9 == 0) goto L_0x010c
            r3 = 1
        L_0x010c:
            int r9 = r8.size()
            if (r9 > r5) goto L_0x0113
            goto L_0x014f
        L_0x0113:
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x011c:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x014e
            java.lang.Object r10 = r8.next()
            java.util.Iterator r11 = r9.iterator()
        L_0x012a:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x014a
            java.lang.Object r12 = r11.next()
            r13 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r13
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r12
            boolean r14 = overrides(r13, r12, r3, r5)
            if (r14 == 0) goto L_0x0143
            r11.remove()
            goto L_0x012a
        L_0x0143:
            boolean r12 = overrides(r12, r13, r3, r5)
            if (r12 == 0) goto L_0x012a
            goto L_0x011c
        L_0x014a:
            r9.add(r10)
            goto L_0x011c
        L_0x014e:
            r8 = r9
        L_0x014f:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = r16.getModality()
            if (r3 == 0) goto L_0x01ab
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            java.util.Iterator r8 = r8.iterator()
        L_0x015b:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x017f
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r9
            if (r0 == 0) goto L_0x0173
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r10 = r9.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r11 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            if (r10 != r11) goto L_0x0173
            r9 = r3
            goto L_0x0177
        L_0x0173:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = r9.getModality()
        L_0x0177:
            int r10 = r9.compareTo(r5)
            if (r10 >= 0) goto L_0x015b
            r5 = r9
            goto L_0x015b
        L_0x017f:
            if (r5 == 0) goto L_0x01a5
            r2 = r5
        L_0x0182:
            if (r4 == 0) goto L_0x0187
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            goto L_0x0189
        L_0x0187:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED
        L_0x0189:
            r3 = r0
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$4 r0 = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$4
            r0.<init>()
            java.lang.Object r0 = selectMostSpecificMember(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            r5 = 0
            r1 = r16
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = r0.copy(r1, r2, r3, r4, r5)
            r6.setOverriddenDescriptors(r0, r7)
            r6.addFakeOverride(r0)
            return
        L_0x01a5:
            r0 = 93
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01ab:
            r0 = 92
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01b1:
            r0 = 95
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01b7:
            r0 = 94
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01bd:
            r0 = 85
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01c3:
            r0 = 84
            $$$reportNull$$$0(r0)
            throw r2
        L_0x01c9:
            r0 = 83
            $$$reportNull$$$0(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.createAndBindFakeOverride(java.util.Collection, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy):void");
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h == null) {
            $$$reportNull$$$0(97);
            throw null;
        } else if (collection != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h);
            CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(h);
            Iterator<H> it = collection.iterator();
            while (it.hasNext()) {
                H next = it.next();
                CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(next);
                if (h == next) {
                    it.remove();
                } else {
                    Result bothWaysOverridability = getBothWaysOverridability(callableDescriptor, callableDescriptor2);
                    if (bothWaysOverridability == Result.OVERRIDABLE) {
                        arrayList.add(next);
                        it.remove();
                    } else if (bothWaysOverridability == Result.CONFLICT) {
                        function12.invoke(next);
                        it.remove();
                    }
                }
            }
            return arrayList;
        } else {
            $$$reportNull$$$0(98);
            throw null;
        }
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverrideCompatibilityInfo overrideCompatibilityInfo;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(38);
            throw null;
        } else if (callableDescriptor2 != null) {
            boolean z = callableDescriptor instanceof FunctionDescriptor;
            if (!z || (callableDescriptor2 instanceof FunctionDescriptor)) {
                boolean z2 = callableDescriptor instanceof PropertyDescriptor;
                if (!z2 || (callableDescriptor2 instanceof PropertyDescriptor)) {
                    if (!z && !z2) {
                        throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
                    } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
                        return OverrideCompatibilityInfo.incompatible("Name mismatch");
                    } else {
                        boolean z3 = false;
                        boolean z4 = callableDescriptor.getExtensionReceiverParameter() == null;
                        if (callableDescriptor2.getExtensionReceiverParameter() == null) {
                            z3 = true;
                        }
                        if (z4 != z3) {
                            overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
                        } else {
                            overrideCompatibilityInfo = callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size() ? OverrideCompatibilityInfo.incompatible("Value parameter number mismatch") : null;
                        }
                        if (overrideCompatibilityInfo != null) {
                            return overrideCompatibilityInfo;
                        }
                        return null;
                    }
                }
            }
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        } else {
            $$$reportNull$$$0(39);
            throw null;
        }
    }

    public static Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        Result result = DEFAULT.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        Result result2 = DEFAULT.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        Result result3 = Result.OVERRIDABLE;
        if (result == result3 && result2 == result3) {
            return result3;
        }
        Result result4 = Result.CONFLICT;
        return (result == result4 || result2 == result4) ? Result.CONFLICT : Result.INCOMPATIBLE;
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(65);
            throw null;
        } else if (callableDescriptor2 != null) {
            KotlinType returnType = callableDescriptor.getReturnType();
            KotlinType returnType2 = callableDescriptor2.getReturnType();
            boolean z = false;
            if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
                return false;
            }
            Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> createTypeChecker = DEFAULT.createTypeChecker(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
            if (callableDescriptor instanceof FunctionDescriptor) {
                return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeChecker);
            }
            if (callableDescriptor instanceof PropertyDescriptor) {
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
                PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                PropertySetterDescriptor setter2 = propertyDescriptor2.getSetter();
                if (!((setter == null || setter2 == null) ? true : isVisibilityMoreSpecific(setter, setter2))) {
                    return false;
                }
                if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                    return ((NewKotlinTypeCheckerImpl) createTypeChecker.first).equalTypes((ClassicTypeCheckerContext) createTypeChecker.second, returnType.unwrap(), returnType2.unwrap());
                }
                if ((propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeChecker)) {
                    z = true;
                }
                return z;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected callable: ");
            outline73.append(callableDescriptor.getClass());
            throw new IllegalArgumentException(outline73.toString());
        } else {
            $$$reportNull$$$0(66);
            throw null;
        }
    }

    public static boolean isReturnTypeMoreSpecific(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2, Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> pair) {
        if (kotlinType == null) {
            $$$reportNull$$$0(72);
            throw null;
        } else if (kotlinType2 != null) {
            return ((NewKotlinTypeCheckerImpl) pair.first).isSubtypeOf((ClassicTypeCheckerContext) pair.second, kotlinType.unwrap(), kotlinType2.unwrap());
        } else {
            $$$reportNull$$$0(74);
            throw null;
        }
    }

    public static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        Integer compare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return compare == null || compare.intValue() >= 0;
    }

    public static <D extends CallableDescriptor> boolean overrides(D d2, D d3, boolean z, boolean z2) {
        if (d2 == null) {
            $$$reportNull$$$0(11);
            throw null;
        } else if (d3 == null) {
            $$$reportNull$$$0(12);
            throw null;
        } else if (!d2.equals(d3) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d2.getOriginal(), d3.getOriginal(), z, z2)) {
            return true;
        } else {
            CallableDescriptor original = d3.getOriginal();
            Iterator it = ((HashSet) DescriptorUtils.getAllOverriddenDescriptors(d2)).iterator();
            while (it.hasNext()) {
                if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, (CallableDescriptor) it.next(), z, z2)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void resolveUnknownVisibilityForMember(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.Unit> r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x011f
            java.util.Collection r1 = r6.getOverriddenDescriptors()
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = r2.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED
            if (r3 != r4) goto L_0x000b
            resolveUnknownVisibilityForMember(r2, r7)
            goto L_0x000b
        L_0x0023:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = r6.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED
            if (r1 == r2) goto L_0x002c
            return
        L_0x002c:
            java.util.Collection r1 = r6.getOverriddenDescriptors()
            if (r1 == 0) goto L_0x0119
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x003b
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.DEFAULT_VISIBILITY
            goto L_0x0088
        L_0x003b:
            java.util.Iterator r2 = r1.iterator()
        L_0x003f:
            r3 = r0
        L_0x0040:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r4.getVisibility()
            if (r3 != 0) goto L_0x0053
            goto L_0x0060
        L_0x0053:
            java.lang.Integer r5 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(r4, r3)
            if (r5 != 0) goto L_0x005a
            goto L_0x003f
        L_0x005a:
            int r5 = r5.intValue()
            if (r5 <= 0) goto L_0x0040
        L_0x0060:
            r3 = r4
            goto L_0x0040
        L_0x0062:
            if (r3 != 0) goto L_0x0065
            goto L_0x0085
        L_0x0065:
            java.util.Iterator r2 = r1.iterator()
        L_0x0069:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r4.getVisibility()
            java.lang.Integer r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(r3, r4)
            if (r4 == 0) goto L_0x0085
            int r4 = r4.intValue()
            if (r4 >= 0) goto L_0x0069
        L_0x0085:
            r2 = r0
            goto L_0x0088
        L_0x0087:
            r2 = r3
        L_0x0088:
            if (r2 != 0) goto L_0x008c
        L_0x008a:
            r2 = r0
            goto L_0x00bb
        L_0x008c:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r3 = r6.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            if (r3 != r4) goto L_0x00b7
            java.util.Iterator r1 = r1.iterator()
        L_0x0098:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00bb
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = r3.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            if (r4 == r5) goto L_0x0098
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = r3.getVisibility()
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0098
            goto L_0x008a
        L_0x00b7:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = r2.normalize()
        L_0x00bb:
            if (r2 != 0) goto L_0x00c5
            if (r7 == 0) goto L_0x00c2
            r7.invoke(r6)
        L_0x00c2:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC
            goto L_0x00c6
        L_0x00c5:
            r1 = r2
        L_0x00c6:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
            if (r3 == 0) goto L_0x00f6
            r3 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r3 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r3
            if (r1 == 0) goto L_0x00f0
            r3.visibility = r1
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r6
            java.util.List r6 = r6.getAccessors()
            java.util.Iterator r6 = r6.iterator()
        L_0x00db:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0118
            java.lang.Object r1 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor) r1
            if (r2 != 0) goto L_0x00eb
            r3 = r0
            goto L_0x00ec
        L_0x00eb:
            r3 = r7
        L_0x00ec:
            resolveUnknownVisibilityForMember(r1, r3)
            goto L_0x00db
        L_0x00f0:
            r6 = 16
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.$$$reportNull$$$0(r6)
            throw r0
        L_0x00f6:
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
            if (r7 == 0) goto L_0x0107
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl r6 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) r6
            if (r1 == 0) goto L_0x0101
            r6.visibility = r1
            goto L_0x0118
        L_0x0101:
            r6 = 9
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.$$$reportNull$$$0(r6)
            throw r0
        L_0x0107:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl r6 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl) r6
            r6.visibility = r1
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = r6.getCorrespondingProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r7 = r7.getVisibility()
            if (r1 == r7) goto L_0x0118
            r7 = 0
            r6.isDefault = r7
        L_0x0118:
            return
        L_0x0119:
            r6 = 107(0x6b, float:1.5E-43)
            $$$reportNull$$$0(r6)
            throw r0
        L_0x011f:
            r6 = 105(0x69, float:1.47E-43)
            $$$reportNull$$$0(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.resolveUnknownVisibilityForMember(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.jvm.functions.Function1):void");
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        H h;
        boolean z;
        if (collection.size() == 1) {
            H first = ArraysKt___ArraysJvmKt.first((Iterable<? extends T>) collection);
            if (first != null) {
                return first;
            }
            $$$reportNull$$$0(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(collection, 10));
        for (H invoke : collection) {
            arrayList2.add(function1.invoke(invoke));
        }
        H first2 = ArraysKt___ArraysJvmKt.first((Iterable<? extends T>) collection);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(first2);
        for (H next : collection) {
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(next);
            if (callableDescriptor2 != null) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!isMoreSpecific(callableDescriptor2, (CallableDescriptor) it.next())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
                if (isMoreSpecific(callableDescriptor2, callableDescriptor) && !isMoreSpecific(callableDescriptor, callableDescriptor2)) {
                    first2 = next;
                }
            } else {
                $$$reportNull$$$0(69);
                throw null;
            }
        }
        if (arrayList.isEmpty()) {
            if (first2 != null) {
                return first2;
            }
            $$$reportNull$$$0(79);
            throw null;
        } else if (arrayList.size() == 1) {
            H first3 = ArraysKt___ArraysJvmKt.first((Iterable<? extends T>) arrayList);
            if (first3 != null) {
                return first3;
            }
            $$$reportNull$$$0(80);
            throw null;
        } else {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    h = null;
                    break;
                }
                h = it2.next();
                if (!TweetUtils.isFlexible(((CallableDescriptor) function1.invoke(h)).getReturnType())) {
                    break;
                }
            }
            if (h != null) {
                return h;
            }
            H first4 = ArraysKt___ArraysJvmKt.first((Iterable<? extends T>) arrayList);
            if (first4 != null) {
                return first4;
            }
            $$$reportNull$$$0(82);
            throw null;
        }
    }

    public final boolean areTypesEquivalent(KotlinType kotlinType, KotlinType kotlinType2, Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> pair) {
        if (kotlinType == null) {
            $$$reportNull$$$0(44);
            throw null;
        } else if (kotlinType2 == null) {
            $$$reportNull$$$0(45);
            throw null;
        } else if (pair != null) {
            if (TweetUtils.isError(kotlinType) && TweetUtils.isError(kotlinType2)) {
                return true;
            }
            return ((NewKotlinTypeCheckerImpl) pair.first).equalTypes((ClassicTypeCheckerContext) pair.second, kotlinType.unwrap(), kotlinType2.unwrap());
        } else {
            $$$reportNull$$$0(46);
            throw null;
        }
    }

    public final Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> createTypeChecker(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        OverridingUtilTypeCheckerContext overridingUtilTypeCheckerContext;
        if (list == null) {
            $$$reportNull$$$0(40);
            throw null;
        } else if (list2 != null) {
            NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = new NewKotlinTypeCheckerImpl(this.kotlinTypeRefiner);
            if (list == null) {
                $$$reportNull$$$0(42);
                throw null;
            } else if (list2 != null) {
                if (list.isEmpty()) {
                    overridingUtilTypeCheckerContext = new OverridingUtilTypeCheckerContext(null);
                } else {
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < list.size(); i++) {
                        hashMap.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
                    }
                    overridingUtilTypeCheckerContext = new OverridingUtilTypeCheckerContext(hashMap);
                }
                return new Pair<>(newKotlinTypeCheckerImpl, overridingUtilTypeCheckerContext);
            } else {
                $$$reportNull$$$0(43);
                throw null;
            }
        } else {
            $$$reportNull$$$0(41);
            throw null;
        }
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        boolean z;
        Collection<? extends CallableMemberDescriptor> collection3 = collection;
        ClassDescriptor classDescriptor2 = classDescriptor;
        final OverridingStrategy overridingStrategy2 = overridingStrategy;
        if (name == null) {
            $$$reportNull$$$0(50);
            throw null;
        } else if (collection3 == null) {
            $$$reportNull$$$0(51);
            throw null;
        } else if (collection2 == null) {
            $$$reportNull$$$0(52);
            throw null;
        } else if (classDescriptor2 != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection3);
            for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
                if (callableMemberDescriptor != null) {
                    ArrayList arrayList = new ArrayList(collection.size());
                    SmartSet create = SmartSet.create();
                    for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                        Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor2).getResult();
                        boolean z2 = !DescriptorVisibilities.isPrivate(callableMemberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor2, callableMemberDescriptor);
                        int ordinal = result.ordinal();
                        if (ordinal == 0) {
                            if (z2) {
                                create.add(callableMemberDescriptor2);
                            }
                            arrayList.add(callableMemberDescriptor2);
                        } else if (ordinal == 2) {
                            if (z2) {
                                Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "fromSuper");
                                Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fromCurrent");
                                ((NonReportingOverrideStrategy) overridingStrategy2).conflict(callableMemberDescriptor2, callableMemberDescriptor);
                            }
                            arrayList.add(callableMemberDescriptor2);
                        }
                    }
                    overridingStrategy2.setOverriddenDescriptors(callableMemberDescriptor, create);
                    linkedHashSet.removeAll(arrayList);
                } else {
                    $$$reportNull$$$0(57);
                    throw null;
                }
            }
            if (linkedHashSet.size() >= 2) {
                DeclarationDescriptor containingDeclaration = ((CallableMemberDescriptor) linkedHashSet.iterator().next()).getContainingDeclaration();
                Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
                if (!linkedHashSet.isEmpty()) {
                    Iterator it = linkedHashSet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!Boolean.valueOf(((CallableMemberDescriptor) it.next()).getContainingDeclaration() == containingDeclaration).booleanValue()) {
                            z = false;
                            break;
                        }
                    }
                }
            }
            z = true;
            if (z) {
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    createAndBindFakeOverride(Collections.singleton((CallableMemberDescriptor) it2.next()), classDescriptor2, overridingStrategy2);
                }
                return;
            }
            LinkedList linkedList = new LinkedList(linkedHashSet);
            while (!linkedList.isEmpty()) {
                Intrinsics.checkNotNullParameter(linkedList, "descriptors");
                boolean z3 = !linkedList.isEmpty();
                if (!_Assertions.ENABLED || z3) {
                    Iterator it3 = linkedList.iterator();
                    final CallableMemberDescriptor callableMemberDescriptor3 = null;
                    while (it3.hasNext()) {
                        CallableMemberDescriptor callableMemberDescriptor4 = (CallableMemberDescriptor) it3.next();
                        if (callableMemberDescriptor3 != null) {
                            Integer compare = DescriptorVisibilities.compare(callableMemberDescriptor3.getVisibility(), callableMemberDescriptor4.getVisibility());
                            if (compare != null) {
                                if (compare.intValue() >= 0) {
                                }
                            }
                        }
                        callableMemberDescriptor3 = callableMemberDescriptor4;
                    }
                    Intrinsics.checkNotNull(callableMemberDescriptor3);
                    createAndBindFakeOverride(extractMembersOverridableInBothWays(callableMemberDescriptor3, linkedList, new Function1<CallableMemberDescriptor, CallableDescriptor>() {
                        public Object invoke(Object obj) {
                            return (CallableMemberDescriptor) obj;
                        }
                    }, new Function1<CallableMemberDescriptor, Unit>() {
                        public Object invoke(Object obj) {
                            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                            OverridingStrategy overridingStrategy = OverridingStrategy.this;
                            CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor3;
                            NonReportingOverrideStrategy nonReportingOverrideStrategy = (NonReportingOverrideStrategy) overridingStrategy;
                            if (nonReportingOverrideStrategy != null) {
                                Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "first");
                                Intrinsics.checkNotNullParameter(callableMemberDescriptor, AnonymousClass27.SECOND);
                                nonReportingOverrideStrategy.conflict(callableMemberDescriptor2, callableMemberDescriptor);
                                return Unit.INSTANCE;
                            }
                            throw null;
                        }
                    }), classDescriptor2, overridingStrategy2);
                } else {
                    throw new AssertionError("Assertion failed");
                }
            }
        } else {
            $$$reportNull$$$0(53);
            throw null;
        }
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(17);
            throw null;
        } else if (callableDescriptor2 != null) {
            return isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        } else {
            $$$reportNull$$$0(18);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7 A[LOOP:1: B:18:0x0061->B:39:0x00c7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00c0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r18, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 0
            if (r1 == 0) goto L_0x0169
            if (r2 == 0) goto L_0x0163
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r4 = getBasicOverridabilityProblem(r18, r19)
            if (r4 == 0) goto L_0x0012
            return r4
        L_0x0012:
            java.util.List r4 = compiledValueParameters(r18)
            java.util.List r5 = compiledValueParameters(r19)
            java.util.List r6 = r18.getTypeParameters()
            java.util.List r7 = r19.getTypeParameters()
            int r8 = r6.size()
            int r9 = r7.size()
            r10 = 0
            if (r8 == r9) goto L_0x005c
        L_0x002d:
            r1 = r4
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r2 = r1.size()
            java.lang.String r3 = "Type parameter number mismatch"
            if (r10 >= r2) goto L_0x0057
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            java.lang.Object r1 = r1.get(r10)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            r6 = r5
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r6 = r6.get(r10)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            boolean r1 = r2.equalTypes(r1, r6)
            if (r1 != 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible(r3)
            return r1
        L_0x0054:
            int r10 = r10 + 1
            goto L_0x002d
        L_0x0057:
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict(r3)
            return r1
        L_0x005c:
            kotlin.Pair r8 = r0.createTypeChecker(r6, r7)
            r9 = 0
        L_0x0061:
            int r11 = r6.size()
            if (r9 >= r11) goto L_0x00d6
            java.lang.Object r11 = r6.get(r9)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r11
            java.lang.Object r13 = r7.get(r9)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r13
            if (r11 == 0) goto L_0x00d0
            if (r13 == 0) goto L_0x00ca
            java.util.List r11 = r11.getUpperBounds()
            java.util.ArrayList r14 = new java.util.ArrayList
            java.util.List r13 = r13.getUpperBounds()
            r14.<init>(r13)
            int r13 = r11.size()
            int r15 = r14.size()
            if (r13 == r15) goto L_0x008f
            goto L_0x00bb
        L_0x008f:
            java.util.Iterator r11 = r11.iterator()
        L_0x0093:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00bd
            java.lang.Object r13 = r11.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r13
            java.util.ListIterator r15 = r14.listIterator()
        L_0x00a3:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x00bb
            java.lang.Object r16 = r15.next()
            r12 = r16
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r12
            boolean r12 = r0.areTypesEquivalent(r13, r12, r8)
            if (r12 == 0) goto L_0x00a3
            r15.remove()
            goto L_0x0093
        L_0x00bb:
            r12 = 0
            goto L_0x00be
        L_0x00bd:
            r12 = 1
        L_0x00be:
            if (r12 != 0) goto L_0x00c7
            java.lang.String r1 = "Type parameter bounds mismatch"
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible(r1)
            return r1
        L_0x00c7:
            int r9 = r9 + 1
            goto L_0x0061
        L_0x00ca:
            r1 = 48
            $$$reportNull$$$0(r1)
            throw r3
        L_0x00d0:
            r1 = 47
            $$$reportNull$$$0(r1)
            throw r3
        L_0x00d6:
            r6 = 0
        L_0x00d7:
            r7 = r4
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            int r9 = r7.size()
            if (r6 >= r9) goto L_0x00ff
            java.lang.Object r7 = r7.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7
            r9 = r5
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.Object r9 = r9.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
            boolean r7 = r0.areTypesEquivalent(r7, r9, r8)
            if (r7 != 0) goto L_0x00fc
            java.lang.String r1 = "Value parameter type mismatch"
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible(r1)
            return r1
        L_0x00fc:
            int r6 = r6 + 1
            goto L_0x00d7
        L_0x00ff:
            boolean r4 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r4 == 0) goto L_0x011e
            boolean r4 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r4 == 0) goto L_0x011e
            r4 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isSuspend()
            r5 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5
            boolean r5 = r5.isSuspend()
            if (r4 == r5) goto L_0x011e
            java.lang.String r1 = "Incompatible suspendability"
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict(r1)
            return r1
        L_0x011e:
            if (r20 == 0) goto L_0x015a
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r18.getReturnType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r19.getReturnType()
            if (r1 == 0) goto L_0x015a
            if (r2 == 0) goto L_0x015a
            boolean r4 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r2)
            if (r4 == 0) goto L_0x013a
            boolean r4 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r1)
            if (r4 == 0) goto L_0x013a
            r12 = 1
            goto L_0x013b
        L_0x013a:
            r12 = 0
        L_0x013b:
            if (r12 != 0) goto L_0x015a
            A r4 = r8.first
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r4 = (kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl) r4
            B r5 = r8.second
            kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext r5 = (kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext) r5
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r2 = r2.unwrap()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = r1.unwrap()
            boolean r1 = r4.isSubtypeOf(r5, r2, r1)
            if (r1 != 0) goto L_0x015a
            java.lang.String r1 = "Return type mismatch"
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict(r1)
            return r1
        L_0x015a:
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.SUCCESS
            if (r1 == 0) goto L_0x015f
            return r1
        L_0x015f:
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.$$$reportNull$$$0(r10)
            throw r3
        L_0x0163:
            r1 = 29
            $$$reportNull$$$0(r1)
            throw r3
        L_0x0169:
            r1 = 28
            $$$reportNull$$$0(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.isOverridableByWithoutExternalConditions(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, boolean):kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo");
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(20);
            throw null;
        } else if (callableDescriptor2 != null) {
            OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z);
            boolean z2 = isOverridableByWithoutExternalConditions.getResult() == Result.OVERRIDABLE;
            for (ExternalOverridabilityCondition next : EXTERNAL_CONDITIONS) {
                if (next.getContract() != Contract.CONFLICTS_ONLY && (!z2 || next.getContract() != Contract.SUCCESS_ONLY)) {
                    int ordinal = next.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (ordinal == 0) {
                        z2 = true;
                    } else if (ordinal == 1) {
                        return OverrideCompatibilityInfo.conflict("External condition failed");
                    } else {
                        if (ordinal == 2) {
                            return OverrideCompatibilityInfo.incompatible("External condition");
                        }
                    }
                }
            }
            if (!z2) {
                return isOverridableByWithoutExternalConditions;
            }
            for (ExternalOverridabilityCondition next2 : EXTERNAL_CONDITIONS) {
                if (next2.getContract() == Contract.CONFLICTS_ONLY) {
                    int ordinal2 = next2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (ordinal2 == 0) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Contract violation in ");
                        outline73.append(next2.getClass().getName());
                        outline73.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(outline73.toString());
                    } else if (ordinal2 == 1) {
                        return OverrideCompatibilityInfo.conflict("External condition failed");
                    } else {
                        if (ordinal2 == 2) {
                            return OverrideCompatibilityInfo.incompatible("External condition");
                        }
                    }
                }
            }
            OverrideCompatibilityInfo overrideCompatibilityInfo = OverrideCompatibilityInfo.SUCCESS;
            if (overrideCompatibilityInfo != null) {
                return overrideCompatibilityInfo;
            }
            OverrideCompatibilityInfo.$$$reportNull$$$0(0);
            throw null;
        } else {
            $$$reportNull$$$0(21);
            throw null;
        }
    }
}
