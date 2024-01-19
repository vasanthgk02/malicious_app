package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public final class LazyPackageViewDescriptorImpl$fragments$2 extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
    public final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        // this.this$0 = lazyPackageViewDescriptorImpl;
        super(0);
    }

    public Object invoke() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0.module;
        moduleDescriptorImpl.assertValid();
        return TweetUtils.packageFragments((CompositePackageFragmentProvider) moduleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue(), this.this$0.fqName);
    }
}
