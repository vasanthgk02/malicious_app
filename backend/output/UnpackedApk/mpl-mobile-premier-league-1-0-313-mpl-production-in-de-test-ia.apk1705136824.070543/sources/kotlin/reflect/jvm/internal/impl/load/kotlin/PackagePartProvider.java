package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PackagePartProvider.kt */
public interface PackagePartProvider {

    /* compiled from: PackagePartProvider.kt */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        public List<String> findPackageParts(String str) {
            Intrinsics.checkNotNullParameter(str, "packageFqName");
            return EmptyList.INSTANCE;
        }
    }

    List<String> findPackageParts(String str);
}
