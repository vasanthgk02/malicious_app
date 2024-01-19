package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements Function0<HashMap<JvmClassName, JvmClassName>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        // this.this$0 = lazyJavaPackageFragment;
        super(0);
    }

    public Object invoke() {
        HashMap hashMap = new HashMap();
        for (Entry next : this.this$0.getBinaryClasses$descriptors_jvm().entrySet()) {
            JvmClassName byInternalName = JvmClassName.byInternalName((String) next.getKey());
            Intrinsics.checkNotNullExpressionValue(byInternalName, "byInternalName(partInternalName)");
            KotlinClassHeader classHeader = ((KotlinJvmBinaryClass) next.getValue()).getClassHeader();
            int ordinal = classHeader.kind.ordinal();
            if (ordinal == 2) {
                hashMap.put(byInternalName, byInternalName);
            } else if (ordinal == 5) {
                String multifileClassName = classHeader.getMultifileClassName();
                if (multifileClassName != null) {
                    JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                    Intrinsics.checkNotNullExpressionValue(byInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    hashMap.put(byInternalName, byInternalName2);
                }
            }
        }
        return hashMap;
    }
}
