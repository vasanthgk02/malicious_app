package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.PrimitiveSet.Prefix;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class Registry {
    public static final ConcurrentMap<String, Object> keyDeriverMap = new ConcurrentHashMap();
    public static final ConcurrentMap<String, KeyManagerContainer> keyManagerMap = new ConcurrentHashMap();
    public static final Logger logger = Logger.getLogger(Registry.class.getName());
    public static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    public static final ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap = new ConcurrentHashMap();

    public interface KeyManagerContainer {
        Class<?> getImplementingClass();

        <P> KeyManager<P> getKeyManager(Class<P> cls) throws GeneralSecurityException;

        KeyManager<?> getUntypedKeyManager();

        Set<Class<?>> supportedPrimitives();
    }

    static {
        new ConcurrentHashMap();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void ensureKeyManagerInsertable(java.lang.String r5, java.lang.Class<?> r6, boolean r7) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.crypto.tink.Registry> r0 = com.google.crypto.tink.Registry.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.Registry$KeyManagerContainer> r1 = keyManagerMap     // Catch:{ all -> 0x0083 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0083 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.Registry$KeyManagerContainer> r1 = keyManagerMap     // Catch:{ all -> 0x0083 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0083 }
            com.google.crypto.tink.Registry$KeyManagerContainer r1 = (com.google.crypto.tink.Registry.KeyManagerContainer) r1     // Catch:{ all -> 0x0083 }
            java.lang.Class r2 = r1.getImplementingClass()     // Catch:{ all -> 0x0083 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0049
            if (r7 == 0) goto L_0x0047
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r6 = newKeyAllowedMap     // Catch:{ all -> 0x0083 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0083 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x0030
            goto L_0x0047
        L_0x0030:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r7.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = "New keys are already disallowed for key type "
            r7.append(r1)     // Catch:{ all -> 0x0083 }
            r7.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0083 }
            r6.<init>(r5)     // Catch:{ all -> 0x0083 }
            throw r6     // Catch:{ all -> 0x0083 }
        L_0x0047:
            monitor-exit(r0)
            return
        L_0x0049:
            java.util.logging.Logger r7 = logger     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "Attempted overwrite of a registered key manager for key type "
            r2.append(r3)     // Catch:{ all -> 0x0083 }
            r2.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0083 }
            r7.warning(r2)     // Catch:{ all -> 0x0083 }
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0083 }
            r4 = 0
            r3[r4] = r5     // Catch:{ all -> 0x0083 }
            r5 = 1
            java.lang.Class r1 = r1.getImplementingClass()     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0083 }
            r3[r5] = r1     // Catch:{ all -> 0x0083 }
            r5 = 2
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0083 }
            r3[r5] = r6     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0083 }
            r7.<init>(r5)     // Catch:{ all -> 0x0083 }
            throw r7     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.Registry.ensureKeyManagerInsertable(java.lang.String, java.lang.Class, boolean):void");
    }

    public static synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String str) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainer;
        synchronized (Registry.class) {
            if (keyManagerMap.containsKey(str)) {
                keyManagerContainer = (KeyManagerContainer) keyManagerMap.get(str);
            } else {
                throw new GeneralSecurityException("No key manager found for key type " + str);
            }
        }
        return keyManagerContainer;
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return getPrimitiveInternal(str, ByteString.copyFrom(bArr), cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, java.lang.Class, java.lang.Class<P>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <P> P getPrimitiveInternal(java.lang.String r3, com.google.crypto.tink.shaded.protobuf.ByteString r4, java.lang.Class<P> r5) throws java.security.GeneralSecurityException {
        /*
            com.google.crypto.tink.Registry$KeyManagerContainer r3 = getKeyManagerContainerOrThrow(r3)
            if (r5 != 0) goto L_0x000b
            com.google.crypto.tink.KeyManager r3 = r3.getUntypedKeyManager()
            goto L_0x0019
        L_0x000b:
            java.util.Set r0 = r3.supportedPrimitives()
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0020
            com.google.crypto.tink.KeyManager r3 = r3.getKeyManager(r5)
        L_0x0019:
            com.google.crypto.tink.KeyManagerImpl r3 = (com.google.crypto.tink.KeyManagerImpl) r3
            java.lang.Object r3 = r3.getPrimitive(r4)
            return r3
        L_0x0020:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException
            java.lang.String r0 = "Primitive type "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r5 = r5.getName()
            r0.append(r5)
            java.lang.String r5 = " not supported by key manager of type "
            r0.append(r5)
            java.lang.Class r5 = r3.getImplementingClass()
            r0.append(r5)
            java.lang.String r5 = ", supported primitives: "
            r0.append(r5)
            java.util.Set r3 = r3.supportedPrimitives()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Iterator r3 = r3.iterator()
            r1 = 1
        L_0x004e:
            boolean r2 = r3.hasNext()
            if (r2 == 0) goto L_0x006a
            java.lang.Object r2 = r3.next()
            java.lang.Class r2 = (java.lang.Class) r2
            if (r1 != 0) goto L_0x0061
            java.lang.String r1 = ", "
            r5.append(r1)
        L_0x0061:
            java.lang.String r1 = r2.getCanonicalName()
            r5.append(r1)
            r1 = 0
            goto L_0x004e
        L_0x006a:
            java.lang.String r3 = r5.toString()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.Registry.getPrimitiveInternal(java.lang.String, com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Class):java.lang.Object");
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, Class<P> cls) throws GeneralSecurityException {
        byte[] bArr;
        if (cls != null) {
            Util.validateKeyset(keysetHandle.keyset);
            PrimitiveSet<P> primitiveSet = new PrimitiveSet<>(cls);
            for (Key key : keysetHandle.keyset.key_) {
                if (key.getStatus() == KeyStatusType.ENABLED) {
                    Object primitiveInternal = getPrimitiveInternal(key.getKeyData().typeUrl_, key.getKeyData().value_, cls);
                    if (key.getStatus() == KeyStatusType.ENABLED) {
                        int ordinal = key.getOutputPrefixType().ordinal();
                        if (ordinal != 1) {
                            if (ordinal != 2) {
                                if (ordinal == 3) {
                                    bArr = CryptoFormat.RAW_PREFIX;
                                } else if (ordinal != 4) {
                                    throw new GeneralSecurityException("unknown output prefix type");
                                }
                            }
                            bArr = ByteBuffer.allocate(5).put(0).putInt(key.keyId_).array();
                        } else {
                            bArr = ByteBuffer.allocate(5).put(1).putInt(key.keyId_).array();
                        }
                        Entry entry = new Entry(primitiveInternal, bArr, key.getStatus(), key.getOutputPrefixType(), key.keyId_);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(entry);
                        Prefix prefix = new Prefix(entry.getIdentifier(), null);
                        List list = (List) primitiveSet.primitives.put(prefix, Collections.unmodifiableList(arrayList));
                        if (list != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(list);
                            arrayList2.add(entry);
                            primitiveSet.primitives.put(prefix, Collections.unmodifiableList(arrayList2));
                        }
                        if (key.keyId_ != keysetHandle.keyset.primaryKeyId_) {
                            continue;
                        } else if (entry.status != KeyStatusType.ENABLED) {
                            throw new IllegalArgumentException("the primary entry has to be ENABLED");
                        } else if (!primitiveSet.getPrimitive(entry.getIdentifier()).isEmpty()) {
                            primitiveSet.primary = entry;
                        } else {
                            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
                        }
                    } else {
                        throw new GeneralSecurityException("only ENABLED key is allowed");
                    }
                }
            }
            return primitiveSet;
        }
        throw null;
    }

    public static synchronized MessageLite newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getKeyManagerContainerOrThrow(keyTemplate.typeUrl_).getUntypedKeyManager();
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.typeUrl_)).booleanValue()) {
                newKey = ((KeyManagerImpl) untypedKeyManager).newKey(keyTemplate.value_);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.typeUrl_);
            }
        }
        return newKey;
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            try {
                KeyManager<?> untypedKeyManager = getKeyManagerContainerOrThrow(keyTemplate.typeUrl_).getUntypedKeyManager();
                if (((Boolean) newKeyAllowedMap.get(keyTemplate.typeUrl_)).booleanValue()) {
                    newKeyData = ((KeyManagerImpl) untypedKeyManager).newKeyData(keyTemplate.value_);
                } else {
                    throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.typeUrl_);
                }
            }
        }
        return newKeyData;
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(final KeyTypeManager<KeyProtoT> keyTypeManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            String keyType = keyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, keyTypeManager.getClass(), z);
            if (!keyManagerMap.containsKey(keyType)) {
                keyManagerMap.put(keyType, new KeyManagerContainer() {
                    public Class<?> getImplementingClass() {
                        return KeyTypeManager.this.getClass();
                    }

                    public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                        try {
                            return new KeyManagerImpl(KeyTypeManager.this, cls);
                        } catch (IllegalArgumentException e2) {
                            throw new GeneralSecurityException("Primitive type not supported", e2);
                        }
                    }

                    public KeyManager<?> getUntypedKeyManager() {
                        KeyTypeManager keyTypeManager = KeyTypeManager.this;
                        return new KeyManagerImpl(keyTypeManager, keyTypeManager.firstPrimitiveClass);
                    }

                    public Set<Class<?>> supportedPrimitives() {
                        return KeyTypeManager.this.factories.keySet();
                    }
                });
                keyDeriverMap.put(keyType, new Object(keyTypeManager) {
                });
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(PrimitiveWrapper<B, P> primitiveWrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            Class primitiveClass = primitiveWrapper.getPrimitiveClass();
            if (primitiveWrapperMap.containsKey(primitiveClass)) {
                PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) primitiveWrapperMap.get(primitiveClass);
                if (!primitiveWrapper.getClass().equals(primitiveWrapper2.getClass())) {
                    Logger logger2 = logger;
                    logger2.warning("Attempted overwrite of a registered SetWrapper for type " + primitiveClass);
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{primitiveClass.getName(), primitiveWrapper2.getClass().getName(), primitiveWrapper.getClass().getName()}));
                }
            }
            primitiveWrapperMap.put(primitiveClass, primitiveWrapper);
        }
    }
}
