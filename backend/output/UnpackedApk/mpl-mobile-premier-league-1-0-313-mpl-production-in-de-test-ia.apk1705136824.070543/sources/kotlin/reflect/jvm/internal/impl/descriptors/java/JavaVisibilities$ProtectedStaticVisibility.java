package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* compiled from: JavaVisibilities.kt */
public final class JavaVisibilities$ProtectedStaticVisibility extends Visibility {
    public static final JavaVisibilities$ProtectedStaticVisibility INSTANCE = new JavaVisibilities$ProtectedStaticVisibility();

    public JavaVisibilities$ProtectedStaticVisibility() {
        super("protected_static", true);
    }

    public String getInternalDisplayName() {
        return "protected/*protected static*/";
    }

    public Visibility normalize() {
        return Protected.INSTANCE;
    }
}
