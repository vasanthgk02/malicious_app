package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements Function0<List<? extends FqName>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        // this.this$0 = lazyJavaPackageFragment;
        super(0);
    }

    public Object invoke() {
        Collection<JavaPackage> subPackages = this.this$0.jPackage.getSubPackages();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(subPackages, 10));
        for (JavaPackage fqName : subPackages) {
            arrayList.add(fqName.getFqName());
        }
        return arrayList;
    }
}
