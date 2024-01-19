package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00db, code lost:
        if (r8.isOverridableBy(r7, r6, null, true).getResult() == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x001a
            boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x001a
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r7
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r6.getTypeConstructor()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r7.getTypeConstructor()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            goto L_0x00fe
        L_0x001a:
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r0 == 0) goto L_0x002e
            boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r0 == 0) goto L_0x002e
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r7
            kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1 r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE
            boolean r6 = r5.areTypeParametersEquivalent(r6, r7, r8, r9)
            goto L_0x00fe
        L_0x002e:
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
            if (r0 == 0) goto L_0x00e1
            boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
            if (r0 == 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r7
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner$Default r0 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE
            r1 = 0
            java.lang.String r2 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "kotlinTypeRefiner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            r3 = 1
            if (r2 == 0) goto L_0x0055
            goto L_0x00dd
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r6.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r7.getName()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 != 0) goto L_0x0065
            goto L_0x00df
        L_0x0065:
            if (r9 == 0) goto L_0x0080
            boolean r9 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
            if (r9 == 0) goto L_0x0080
            boolean r9 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
            if (r9 == 0) goto L_0x0080
            r9 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) r9
            boolean r9 = r9.isExpect()
            r2 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) r2
            boolean r2 = r2.isExpect()
            if (r9 == r2) goto L_0x0080
            goto L_0x00df
        L_0x0080:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = r6.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r7.getContainingDeclaration()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r9 == 0) goto L_0x00a0
            if (r8 != 0) goto L_0x0091
            goto L_0x00df
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = r5.singleSource(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r2 = r5.singleSource(r7)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r9 != 0) goto L_0x00a0
            goto L_0x00df
        L_0x00a0:
            boolean r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(r6)
            if (r9 != 0) goto L_0x00df
            boolean r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(r7)
            if (r9 == 0) goto L_0x00ad
            goto L_0x00df
        L_0x00ad:
            kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1 r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE
            boolean r9 = r5.ownersEquivalent(r6, r7, r9, r8)
            if (r9 != 0) goto L_0x00b6
            goto L_0x00df
        L_0x00b6:
            kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 r9 = new kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1
            r9.<init>(r5, r8, r6, r7)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r8 = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil
            r8.<init>(r9, r0)
            java.lang.String r9 = "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r9 = r8.isOverridableBy(r6, r7, r1, r3)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r9 = r9.getResult()
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE
            if (r9 != r0) goto L_0x00df
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo r6 = r8.isOverridableBy(r7, r6, r1, r3)
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r6 = r6.getResult()
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r7 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE
            if (r6 != r7) goto L_0x00df
        L_0x00dd:
            r6 = 1
            goto L_0x00fe
        L_0x00df:
            r6 = 0
            goto L_0x00fe
        L_0x00e1:
            boolean r8 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r8 == 0) goto L_0x00fa
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r8 == 0) goto L_0x00fa
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = r6.getFqName()
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r7
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r7.getFqName()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            goto L_0x00fe
        L_0x00fa:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
        L_0x00fe:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, boolean, boolean):boolean");
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        boolean z2 = true;
        if (Intrinsics.areEqual(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        if (Intrinsics.areEqual(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) || !ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, function2, z)) {
            return false;
        }
        if (typeParameterDescriptor.getIndex() != typeParameterDescriptor2.getIndex()) {
            z2 = false;
        }
        return z2;
    }

    public final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return ((Boolean) function2.invoke(containingDeclaration, containingDeclaration2)).booleanValue();
        }
        return areEquivalent(containingDeclaration, containingDeclaration2, z, true);
    }

    public final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) ArraysKt___ArraysJvmKt.singleOrNull((Iterable<? extends T>) overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }
}
