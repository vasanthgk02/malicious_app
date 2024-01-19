package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {
    public final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        // this.this$0 = lazyPackageViewDescriptorImpl;
        super(0);
    }

    public Object invoke() {
        if (this.this$0.getFragments().isEmpty()) {
            return Empty.INSTANCE;
        }
        List<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(fragments, 10));
        for (PackageFragmentDescriptor memberScope : fragments) {
            arrayList.add(memberScope.getMemberScope());
        }
        LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl = this.this$0;
        List plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) arrayList, new SubpackagesScope(lazyPackageViewDescriptorImpl.module, lazyPackageViewDescriptorImpl.fqName));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("package view scope for ");
        outline73.append(this.this$0.fqName);
        outline73.append(" in ");
        outline73.append(this.this$0.module.getName());
        return ChainedMemberScope.create(outline73.toString(), plus);
    }
}
