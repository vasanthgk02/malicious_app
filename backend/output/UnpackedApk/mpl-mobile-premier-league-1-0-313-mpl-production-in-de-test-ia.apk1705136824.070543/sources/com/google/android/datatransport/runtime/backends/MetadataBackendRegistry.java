package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class MetadataBackendRegistry implements BackendRegistry {
    public final BackendFactoryProvider backendFactoryProvider;
    public final Map<String, TransportBackend> backends = new HashMap();
    public final CreationContextFactory creationContextFactory;

    public static class BackendFactoryProvider {
        public final Context applicationContext;
        public Map<String, String> backendProviders = null;

        public BackendFactoryProvider(Context context) {
            this.applicationContext = context;
        }

        /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Map<java.lang.String, java.lang.String>] */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v7, types: [java.util.Map] */
        /* JADX WARNING: type inference failed for: r2v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.datatransport.runtime.backends.BackendFactory get(java.lang.String r14) {
            /*
                r13 = this;
                java.lang.String r0 = "Could not instantiate %s"
                java.lang.String r1 = "Could not instantiate %s."
                java.util.Map<java.lang.String, java.lang.String> r2 = r13.backendProviders
                r3 = 0
                r4 = 0
                if (r2 != 0) goto L_0x0080
                android.content.Context r2 = r13.applicationContext
                android.content.pm.PackageManager r5 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0026 }
                if (r5 != 0) goto L_0x0013
                goto L_0x0026
            L_0x0013:
                android.content.ComponentName r6 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0026 }
                java.lang.Class<com.google.android.datatransport.runtime.backends.TransportBackendDiscovery> r7 = com.google.android.datatransport.runtime.backends.TransportBackendDiscovery.class
                r6.<init>(r2, r7)     // Catch:{ NameNotFoundException -> 0x0026 }
                r2 = 128(0x80, float:1.8E-43)
                android.content.pm.ServiceInfo r2 = r5.getServiceInfo(r6, r2)     // Catch:{ NameNotFoundException -> 0x0026 }
                if (r2 != 0) goto L_0x0023
                goto L_0x0026
            L_0x0023:
                android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0026 }
                goto L_0x0027
            L_0x0026:
                r2 = r3
            L_0x0027:
                if (r2 != 0) goto L_0x002e
                java.util.Map r2 = java.util.Collections.emptyMap()
                goto L_0x007e
            L_0x002e:
                java.util.HashMap r5 = new java.util.HashMap
                r5.<init>()
                java.util.Set r6 = r2.keySet()
                java.util.Iterator r6 = r6.iterator()
            L_0x003b:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L_0x007d
                java.lang.Object r7 = r6.next()
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r2.get(r7)
                boolean r9 = r8 instanceof java.lang.String
                if (r9 == 0) goto L_0x003b
                java.lang.String r9 = "backend:"
                boolean r9 = r7.startsWith(r9)
                if (r9 == 0) goto L_0x003b
                java.lang.String r8 = (java.lang.String) r8
                r9 = -1
                java.lang.String r10 = ","
                java.lang.String[] r8 = r8.split(r10, r9)
                int r9 = r8.length
                r10 = 0
            L_0x0062:
                if (r10 >= r9) goto L_0x003b
                r11 = r8[r10]
                java.lang.String r11 = r11.trim()
                boolean r12 = r11.isEmpty()
                if (r12 == 0) goto L_0x0071
                goto L_0x007a
            L_0x0071:
                r12 = 8
                java.lang.String r12 = r7.substring(r12)
                r5.put(r11, r12)
            L_0x007a:
                int r10 = r10 + 1
                goto L_0x0062
            L_0x007d:
                r2 = r5
            L_0x007e:
                r13.backendProviders = r2
            L_0x0080:
                java.util.Map<java.lang.String, java.lang.String> r2 = r13.backendProviders
                java.lang.Object r14 = r2.get(r14)
                java.lang.String r14 = (java.lang.String) r14
                if (r14 != 0) goto L_0x008b
                return r3
            L_0x008b:
                r2 = 1
                java.lang.Class r5 = java.lang.Class.forName(r14)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                java.lang.Class<com.google.android.datatransport.runtime.backends.BackendFactory> r6 = com.google.android.datatransport.runtime.backends.BackendFactory.class
                java.lang.Class r5 = r5.asSubclass(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                com.google.android.datatransport.runtime.backends.BackendFactory r5 = (com.google.android.datatransport.runtime.backends.BackendFactory) r5     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00bd, InstantiationException -> 0x00b5, NoSuchMethodException -> 0x00ad, InvocationTargetException -> 0x00a5 }
                return r5
            L_0x00a5:
                java.lang.Object[] r1 = new java.lang.Object[r2]
                r1[r4] = r14
                java.lang.String.format(r0, r1)
                goto L_0x00ce
            L_0x00ad:
                java.lang.Object[] r1 = new java.lang.Object[r2]
                r1[r4] = r14
                java.lang.String.format(r0, r1)
                goto L_0x00ce
            L_0x00b5:
                java.lang.Object[] r0 = new java.lang.Object[r2]
                r0[r4] = r14
                java.lang.String.format(r1, r0)
                goto L_0x00ce
            L_0x00bd:
                java.lang.Object[] r0 = new java.lang.Object[r2]
                r0[r4] = r14
                java.lang.String.format(r1, r0)
                goto L_0x00ce
            L_0x00c5:
                java.lang.Object[] r0 = new java.lang.Object[r2]
                r0[r4] = r14
                java.lang.String r14 = "Class %s is not found."
                java.lang.String.format(r14, r0)
            L_0x00ce:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.MetadataBackendRegistry.BackendFactoryProvider.get(java.lang.String):com.google.android.datatransport.runtime.backends.BackendFactory");
        }
    }

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory2) {
        BackendFactoryProvider backendFactoryProvider2 = new BackendFactoryProvider(context);
        this.backendFactoryProvider = backendFactoryProvider2;
        this.creationContextFactory = creationContextFactory2;
    }

    public synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return this.backends.get(str);
        }
        BackendFactory backendFactory = this.backendFactoryProvider.get(str);
        if (backendFactory == null) {
            return null;
        }
        CreationContextFactory creationContextFactory2 = this.creationContextFactory;
        TransportBackend create = backendFactory.create(new AutoValue_CreationContext(creationContextFactory2.applicationContext, creationContextFactory2.wallClock, creationContextFactory2.monotonicClock, str));
        this.backends.put(str, create);
        return create;
    }
}
