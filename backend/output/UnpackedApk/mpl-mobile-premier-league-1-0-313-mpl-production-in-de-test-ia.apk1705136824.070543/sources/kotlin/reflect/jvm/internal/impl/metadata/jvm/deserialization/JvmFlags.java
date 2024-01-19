package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField;

/* compiled from: JvmFlags.kt */
public final class JvmFlags {
    public static final BooleanFlagField ARE_INTERFACE_METHOD_BODIES_INSIDE;
    public static final JvmFlags INSTANCE = null;
    public static final BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = FlagField.booleanFirst();

    static {
        BooleanFlagField booleanFirst = FlagField.booleanFirst();
        ARE_INTERFACE_METHOD_BODIES_INSIDE = booleanFirst;
        FlagField.booleanAfter(booleanFirst);
    }
}
