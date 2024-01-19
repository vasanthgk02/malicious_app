package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        // this.this$0 = lazyJavaPackageFragment;
        super(0);
    }

    public Object invoke() {
        Object obj;
        LazyJavaPackageFragment lazyJavaPackageFragment = this.this$0;
        PackagePartProvider packagePartProvider = lazyJavaPackageFragment.f5942c.components.packagePartProvider;
        String asString = lazyJavaPackageFragment.fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
        List<String> findPackageParts = packagePartProvider.findPackageParts(asString);
        LazyJavaPackageFragment lazyJavaPackageFragment2 = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (String str : findPackageParts) {
            ClassId classId = ClassId.topLevel(new FqName(JvmClassName.byInternalName(str).internalName.replace('/', '.')));
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
            KotlinJvmBinaryClass findKotlinClass = TweetUtils.findKotlinClass(lazyJavaPackageFragment2.f5942c.components.kotlinClassFinder, classId);
            if (findKotlinClass == null) {
                obj = null;
            } else {
                obj = new Pair(str, findKotlinClass);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList);
    }
}
