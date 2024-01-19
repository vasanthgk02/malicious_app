package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    public final FqName fqName;
    public final NotNullLazyValue fragments$delegate;
    public final MemberScope memberScope;
    public final ModuleDescriptorImpl module;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyPackageViewDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl r3, kotlin.reflect.jvm.internal.impl.name.FqName r4, kotlin.reflect.jvm.internal.impl.storage.StorageManager r5) {
        /*
            r2 = this;
            java.lang.String r0 = "module"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r0 == 0) goto L_0x0039
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r4.shortNameOrSpecial()
            r2.<init>(r0, r1)
            r2.module = r3
            r2.fqName = r4
            kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$fragments$2 r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$fragments$2
            r3.<init>(r2)
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r3 = r5.createLazyValue(r3)
            r2.fragments$delegate = r3
            kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter r3 = new kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter
            kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$memberScope$1 r4 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$memberScope$1
            r4.<init>(r2)
            r3.<init>(r5, r4)
            r2.memberScope = r3
            return
        L_0x0039:
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl, kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d2);
    }

    public boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        boolean z = false;
        if (packageViewDescriptor == null) {
            return false;
        }
        if (Intrinsics.areEqual(this.fqName, packageViewDescriptor.getFqName()) && Intrinsics.areEqual(this.module, packageViewDescriptor.getModule())) {
            z = true;
        }
        return z;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        if (this.fqName.isRoot()) {
            return null;
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.module;
        FqName parent = this.fqName.parent();
        Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
        return moduleDescriptorImpl.getPackage(parent);
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public List<PackageFragmentDescriptor> getFragments() {
        return (List) TweetUtils.getValue(this.fragments$delegate, $$delegatedProperties[0]);
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public ModuleDescriptor getModule() {
        return this.module;
    }

    public int hashCode() {
        return this.fqName.hashCode() + (this.module.hashCode() * 31);
    }

    public boolean isEmpty() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getFragments().isEmpty();
    }
}
