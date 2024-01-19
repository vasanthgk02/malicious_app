package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    public static volatile ExtensionRegistryLite emptyRegistry;
    public final Map<ObjectIntPair, GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        public final int number;
        public final Object object;

        public ObjectIntPair(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.object == objectIntPair.object && this.number == objectIntPair.number) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(3:9|10|11)|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.datastore.preferences.protobuf.ExtensionRegistryLite getEmptyRegistry() {
        /*
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = emptyRegistry
            if (r0 != 0) goto L_0x002b
            java.lang.Class<androidx.datastore.preferences.protobuf.ExtensionRegistryLite> r1 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.class
            monitor-enter(r1)
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = emptyRegistry     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0026
            java.lang.Class<?> r0 = androidx.datastore.preferences.protobuf.ExtensionRegistryFactory.EXTENSION_REGISTRY_CLASS     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0022
            java.lang.String r2 = "getEmptyRegistry"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0022 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0022 }
            r3 = 0
            java.lang.Object r0 = r0.invoke(r3, r2)     // Catch:{ Exception -> 0x0022 }
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r0     // Catch:{ Exception -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = EMPTY_REGISTRY_LITE     // Catch:{ all -> 0x0028 }
        L_0x0024:
            emptyRegistry = r0     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ExtensionRegistryLite.getEmptyRegistry():androidx.datastore.preferences.protobuf.ExtensionRegistryLite");
    }

    public ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
