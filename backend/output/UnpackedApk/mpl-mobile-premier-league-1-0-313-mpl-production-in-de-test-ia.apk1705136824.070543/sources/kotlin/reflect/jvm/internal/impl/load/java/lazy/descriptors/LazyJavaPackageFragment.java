package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public final Annotations annotations;
    public final NotNullLazyValue binaryClasses$delegate;

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5942c;
    public final JavaPackage jPackage;
    public final JvmPackageScope scope = new JvmPackageScope(this.f5942c, this.jPackage, this);
    public final NotNullLazyValue<List<FqName>> subPackages = this.f5942c.components.storageManager.createRecursionTolerantLazyValue(new LazyJavaPackageFragment$subPackages$1(this), EmptyList.INSTANCE);

    static {
        Class<LazyJavaPackageFragment> cls = LazyJavaPackageFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageFragment(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage) {
        Annotations annotations2;
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        // Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        super(lazyJavaResolverContext.components.module, javaPackage.getFqName());
        this.jPackage = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = TweetUtils.childForClassOrPackage$default(lazyJavaResolverContext, this, null, 0, 6);
        this.f5942c = childForClassOrPackage$default;
        this.binaryClasses$delegate = childForClassOrPackage$default.components.storageManager.createLazyValue(new LazyJavaPackageFragment$binaryClasses$2(this));
        LazyJavaResolverContext lazyJavaResolverContext2 = this.f5942c;
        if (!lazyJavaResolverContext2.components.javaTypeEnhancementState.disabledDefaultAnnotations) {
            annotations2 = TweetUtils.resolveAnnotations(lazyJavaResolverContext2, this.jPackage);
        } else if (Annotations.Companion != null) {
            annotations2 = Companion.EMPTY;
        } else {
            throw null;
        }
        this.annotations = annotations2;
        this.f5942c.components.storageManager.createLazyValue(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) TweetUtils.getValue(this.binaryClasses$delegate, $$delegatedProperties[0]);
    }

    public MemberScope getMemberScope() {
        return this.scope;
    }

    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public String toString() {
        return Intrinsics.stringPlus("Lazy Java package fragment: ", this.fqName);
    }
}
