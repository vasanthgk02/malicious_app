package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* compiled from: JavaVisibilities.kt */
public final class JavaVisibilities$PackageVisibility extends Visibility {
    public static final JavaVisibilities$PackageVisibility INSTANCE = new JavaVisibilities$PackageVisibility();

    public JavaVisibilities$PackageVisibility() {
        super("package", false);
    }

    public Integer compareTo(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        if (this == visibility) {
            return Integer.valueOf(0);
        }
        if (Visibilities.INSTANCE.isPrivate(visibility)) {
            return Integer.valueOf(1);
        }
        return Integer.valueOf(-1);
    }

    public String getInternalDisplayName() {
        return "public/*package*/";
    }

    public Visibility normalize() {
        return Protected.INSTANCE;
    }
}
