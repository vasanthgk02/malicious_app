package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: DeserializedClassDataFinder.kt */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    public final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider2) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider2, "packageFragmentProvider");
        this.packageFragmentProvider = packageFragmentProvider2;
    }

    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        PackageFragmentProvider packageFragmentProvider2 = this.packageFragmentProvider;
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        Iterator it = ((ArrayList) TweetUtils.packageFragments(packageFragmentProvider2, packageFqName)).iterator();
        while (it.hasNext()) {
            PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) it.next();
            if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                ClassData findClassData = ((DeserializedPackageFragmentImpl) ((DeserializedPackageFragment) packageFragmentDescriptor)).classDataFinder.findClassData(classId);
                if (findClassData != null) {
                    return findClassData;
                }
            }
        }
        return null;
    }
}
