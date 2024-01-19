package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: DefaultBuiltIns.kt */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final DefaultBuiltIns Instance = new DefaultBuiltIns(false, 1);

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DefaultBuiltIns(boolean z, int i) {
        // z = (i & 1) != 0 ? true : z;
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            createBuiltInsModule(false);
        }
    }
}
