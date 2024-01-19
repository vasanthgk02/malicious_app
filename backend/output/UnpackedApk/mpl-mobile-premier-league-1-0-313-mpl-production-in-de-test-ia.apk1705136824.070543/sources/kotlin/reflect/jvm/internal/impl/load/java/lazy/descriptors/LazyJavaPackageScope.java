package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.mpl.androidapp.login.LoginReactModule;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;

/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    public final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    public final JavaPackage jPackage;
    public final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    public final LazyJavaPackageFragment ownerDescriptor;

    /* compiled from: LazyJavaPackageScope.kt */
    public static final class FindClassRequest {
        public final JavaClass javaClass;
        public final Name name;

        public FindClassRequest(Name name2, JavaClass javaClass2) {
            Intrinsics.checkNotNullParameter(name2, "name");
            this.name = name2;
            this.javaClass = javaClass2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof FindClassRequest) && Intrinsics.areEqual(this.name, ((FindClassRequest) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    public static abstract class KotlinClassLookupResult {

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class Found extends KotlinClassLookupResult {
            public final ClassDescriptor descriptor;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public Found(ClassDescriptor classDescriptor) {
                // Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
                super(null);
                this.descriptor = classDescriptor;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = new NotFound();

            public NotFound() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            public SyntheticClass() {
                super(null);
            }
        }

        public KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageScope(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        // Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        // Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "ownerDescriptor");
        super(lazyJavaResolverContext);
        this.jPackage = javaPackage;
        this.ownerDescriptor = lazyJavaPackageFragment;
        this.knownClassNamesInPackage = lazyJavaResolverContext.components.storageManager.createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(lazyJavaResolverContext, this));
        this.classes = lazyJavaResolverContext.components.storageManager.createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, lazyJavaResolverContext));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>, code=kotlin.jvm.functions.Function1, for r5v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r4, kotlin.jvm.functions.Function1 r5) {
        /*
            r3 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK
            boolean r4 = r4.acceptsKinds(r0)
            if (r4 != 0) goto L_0x0012
            kotlin.collections.EmptySet r4 = kotlin.collections.EmptySet.INSTANCE
            return r4
        L_0x0012:
            kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<java.util.Set<java.lang.String>> r4 = r3.knownClassNamesInPackage
            java.lang.Object r4 = r4.invoke()
            java.util.Set r4 = (java.util.Set) r4
            if (r4 == 0) goto L_0x003a
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0025:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r4.next()
            java.lang.String r0 = (java.lang.String) r0
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r0)
            r5.add(r0)
            goto L_0x0025
        L_0x0039:
            return r5
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage r4 = r3.jPackage
            if (r5 != 0) goto L_0x0040
            kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r5 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.ALWAYS_TRUE
        L_0x0040:
            java.util.Collection r4 = r4.getClasses(r5)
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x004d:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x006d
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind r1 = r0.getLightClassOriginKind()
            kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind r2 = kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind.SOURCE
            if (r1 != r2) goto L_0x0063
            r0 = 0
            goto L_0x0067
        L_0x0063:
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getName()
        L_0x0067:
            if (r0 == 0) goto L_0x004d
            r5.add(r0)
            goto L_0x004d
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.computeClassNames(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Set");
    }

    public Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return EmptySet.INSTANCE;
    }

    public DeclaredMemberIndex computeMemberIndex() {
        return Empty.INSTANCE;
    }

    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return EmptySet.INSTANCE;
    }

    public final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (!SpecialNames.isSafeIdentifier(name)) {
            return null;
        }
        Set set = (Set) this.knownClassNamesInPackage.invoke();
        if (javaClass != null || set == null || set.contains(name.asString())) {
            return (ClassDescriptor) this.classes.invoke(new FindClassRequest(name, javaClass));
        }
        return null;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return findClassifier(name, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r5, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.CLASSIFIERS_MASK
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r1 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r1 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK
            r0 = r0 | r1
            boolean r5 = r5.acceptsKinds(r0)
            if (r5 != 0) goto L_0x001c
            kotlin.collections.EmptyList r5 = kotlin.collections.EmptyList.INSTANCE
            goto L_0x005f
        L_0x001c:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>> r5 = r4.allDescriptors
            java.lang.Object r5 = r5.invoke()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x002d:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r5.next()
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x0057
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getName()
            java.lang.String r3 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object r2 = r6.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0057
            r2 = 1
            goto L_0x0058
        L_0x0057:
            r2 = 0
        L_0x0058:
            if (r2 == 0) goto L_0x002d
            r0.add(r1)
            goto L_0x002d
        L_0x005e:
            r5 = r0
        L_0x005f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return EmptyList.INSTANCE;
    }

    public DeclarationDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
