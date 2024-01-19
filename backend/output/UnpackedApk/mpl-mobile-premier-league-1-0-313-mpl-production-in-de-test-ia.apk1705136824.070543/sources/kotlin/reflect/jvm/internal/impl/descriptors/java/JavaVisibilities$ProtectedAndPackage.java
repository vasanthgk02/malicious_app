package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* compiled from: JavaVisibilities.kt */
public final class JavaVisibilities$ProtectedAndPackage extends Visibility {
    public static final JavaVisibilities$ProtectedAndPackage INSTANCE = new JavaVisibilities$ProtectedAndPackage();

    public JavaVisibilities$ProtectedAndPackage() {
        super("protected_and_package", true);
    }

    public Integer compareTo(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        if (Intrinsics.areEqual(this, visibility)) {
            return Integer.valueOf(0);
        }
        if (visibility == Internal.INSTANCE) {
            return null;
        }
        return Integer.valueOf(Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1);
    }

    public String getInternalDisplayName() {
        return "protected/*protected and package*/";
    }

    public Visibility normalize() {
        return Protected.INSTANCE;
    }
}
