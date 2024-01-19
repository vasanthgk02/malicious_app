package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {
    public int hashCode;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void $$$reportNull$$$0(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto L_0x000c
            if (r9 == r1) goto L_0x000c
            if (r9 == r0) goto L_0x000c
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x000e
        L_0x000c:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        L_0x000e:
            r4 = 2
            if (r9 == r2) goto L_0x0017
            if (r9 == r1) goto L_0x0017
            if (r9 == r0) goto L_0x0017
            r5 = 3
            goto L_0x0018
        L_0x0017:
            r5 = 2
        L_0x0018:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L_0x0030
            if (r9 == r4) goto L_0x002b
            if (r9 == r1) goto L_0x0030
            if (r9 == r0) goto L_0x0030
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L_0x0032
        L_0x002b:
            java.lang.String r8 = "descriptor"
            r5[r7] = r8
            goto L_0x0032
        L_0x0030:
            r5[r7] = r6
        L_0x0032:
            if (r9 == r2) goto L_0x0040
            if (r9 == r1) goto L_0x003b
            if (r9 == r0) goto L_0x003b
            r5[r2] = r6
            goto L_0x0044
        L_0x003b:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L_0x0044
        L_0x0040:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L_0x0044:
            if (r9 == r2) goto L_0x0055
            if (r9 == r4) goto L_0x0051
            if (r9 == r1) goto L_0x0055
            if (r9 == r0) goto L_0x0055
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L_0x0055
        L_0x0051:
            java.lang.String r6 = "hasMeaningfulFqName"
            r5[r4] = r6
        L_0x0055:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L_0x0065
            if (r9 == r1) goto L_0x0065
            if (r9 == r0) goto L_0x0065
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L_0x006a
        L_0x0065:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L_0x006a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor.$$$reportNull$$$0(int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbstractClassTypeConstructor(kotlin.reflect.jvm.internal.impl.storage.StorageManager r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0009
            r1.<init>(r2)
            r1.hashCode = r0
            return
        L_0x0009:
            $$$reportNull$$$0(r0)
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public static boolean hasMeaningfulFqName(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor != null) {
            return !ErrorUtils.isError(classifierDescriptor) && !DescriptorUtils.isLocal(classifierDescriptor);
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r1).getFqName().equals(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6).getFqName()) != false) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.hashCode()
            int r3 = r5.hashCode()
            if (r1 == r3) goto L_0x0015
            return r2
        L_0x0015:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r6
            java.util.List r1 = r6.getParameters()
            int r1 = r1.size()
            java.util.List r3 = r5.getParameters()
            int r3 = r3.size()
            if (r1 == r3) goto L_0x002a
            return r2
        L_0x002a:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r5.getDeclarationDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r6.getDeclarationDescriptor()
            boolean r3 = hasMeaningfulFqName(r1)
            if (r3 == 0) goto L_0x00aa
            if (r6 == 0) goto L_0x0042
            boolean r3 = hasMeaningfulFqName(r6)
            if (r3 != 0) goto L_0x0042
            goto L_0x00aa
        L_0x0042:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x00aa
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r1.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r6.getName()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0057
            goto L_0x008a
        L_0x0057:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r6.getContainingDeclaration()
        L_0x005f:
            if (r1 == 0) goto L_0x00a9
            if (r6 == 0) goto L_0x00a9
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            if (r3 == 0) goto L_0x006a
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            goto L_0x00a9
        L_0x006a:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            if (r3 == 0) goto L_0x006f
            goto L_0x008a
        L_0x006f:
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r3 == 0) goto L_0x008c
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r3 == 0) goto L_0x008a
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r1
            kotlin.reflect.jvm.internal.impl.name.FqName r1 = r1.getFqName()
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = r6.getFqName()
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x008a
            goto L_0x00a9
        L_0x008a:
            r0 = 0
            goto L_0x00a9
        L_0x008c:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r3 == 0) goto L_0x0091
            goto L_0x008a
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r1.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r6.getName()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00a0
            goto L_0x008a
        L_0x00a0:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r6.getContainingDeclaration()
            goto L_0x005f
        L_0x00a9:
            return r0
        L_0x00aa:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor.equals(java.lang.Object):boolean");
    }

    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        DeclarationDescriptor containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List emptyList = Collections.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            $$$reportNull$$$0(3);
            throw null;
        }
        SmartList smartList = new SmartList();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        ClassDescriptor companionObjectDescriptor = classDescriptor.getCompanionObjectDescriptor();
        if (z && companionObjectDescriptor != null) {
            smartList.add(companionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(getDeclarationDescriptor());
        if (builtIns != null) {
            return builtIns;
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public abstract ClassDescriptor getDeclarationDescriptor();

    public final int hashCode() {
        int i;
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        if (hasMeaningfulFqName(declarationDescriptor)) {
            i = DescriptorUtils.getFqName(declarationDescriptor).hashCode();
        } else {
            i = System.identityHashCode(this);
        }
        this.hashCode = i;
        return i;
    }
}
