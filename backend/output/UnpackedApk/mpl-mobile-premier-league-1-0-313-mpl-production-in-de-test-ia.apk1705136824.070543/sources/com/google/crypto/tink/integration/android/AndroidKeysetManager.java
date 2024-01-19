package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;

public final class AndroidKeysetManager {
    public KeysetManager keysetManager;

    public static final class Builder {
        public KeyStore keyStore = null;
        public KeyTemplate keyTemplate = null;
        public KeysetManager keysetManager;
        public Aead masterKey = null;
        public String masterKeyUri = null;
        public SharedPrefKeysetReader reader = null;
        public boolean useKeystore = true;
        public KeysetWriter writer = null;

        public synchronized AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            try {
                if (this.masterKeyUri != null) {
                    this.masterKey = readOrGenerateNewMasterKey();
                }
                this.keysetManager = readOrGenerateNewKeyset();
            }
            return new AndroidKeysetManager(this, null);
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.crypto.tink.KeysetManager readOrGenerateNewKeyset() throws java.security.GeneralSecurityException, java.io.IOException {
            /*
                r7 = this;
                com.google.crypto.tink.Aead r0 = r7.masterKey     // Catch:{ FileNotFoundException -> 0x0026 }
                if (r0 == 0) goto L_0x000f
                com.google.crypto.tink.integration.android.SharedPrefKeysetReader r1 = r7.reader     // Catch:{ InvalidProtocolBufferException | GeneralSecurityException -> 0x000f }
                com.google.crypto.tink.KeysetHandle r0 = com.google.crypto.tink.KeysetHandle.read(r1, r0)     // Catch:{ InvalidProtocolBufferException | GeneralSecurityException -> 0x000f }
                com.google.crypto.tink.KeysetManager r0 = com.google.crypto.tink.KeysetManager.withKeysetHandle(r0)     // Catch:{ InvalidProtocolBufferException | GeneralSecurityException -> 0x000f }
                goto L_0x0025
            L_0x000f:
                com.google.crypto.tink.integration.android.SharedPrefKeysetReader r0 = r7.reader     // Catch:{ FileNotFoundException -> 0x0026 }
                byte[] r0 = r0.readPref()     // Catch:{ FileNotFoundException -> 0x0026 }
                com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r1 = com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite.getEmptyRegistry()     // Catch:{ FileNotFoundException -> 0x0026 }
                com.google.crypto.tink.proto.Keyset r0 = com.google.crypto.tink.proto.Keyset.parseFrom(r0, r1)     // Catch:{ FileNotFoundException -> 0x0026 }
                com.google.crypto.tink.KeysetHandle r0 = com.google.crypto.tink.KeysetHandle.fromKeyset(r0)     // Catch:{ FileNotFoundException -> 0x0026 }
                com.google.crypto.tink.KeysetManager r0 = com.google.crypto.tink.KeysetManager.withKeysetHandle(r0)     // Catch:{ FileNotFoundException -> 0x0026 }
            L_0x0025:
                return r0
            L_0x0026:
                com.google.crypto.tink.KeyTemplate r0 = r7.keyTemplate
                if (r0 == 0) goto L_0x0183
                com.google.crypto.tink.KeysetManager r0 = new com.google.crypto.tink.KeysetManager
                com.google.crypto.tink.proto.Keyset r1 = com.google.crypto.tink.proto.Keyset.DEFAULT_INSTANCE
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$Builder r1 = r1.createBuilder()
                com.google.crypto.tink.proto.Keyset$Builder r1 = (com.google.crypto.tink.proto.Keyset.Builder) r1
                r0.<init>(r1)
                com.google.crypto.tink.KeyTemplate r1 = r7.keyTemplate
                monitor-enter(r0)
                com.google.crypto.tink.proto.KeyTemplate r1 = r1.kt     // Catch:{ all -> 0x0180 }
                r2 = 0
                r0.addNewKey(r1, r2)     // Catch:{ all -> 0x0180 }
                monitor-exit(r0)
                com.google.crypto.tink.KeysetHandle r1 = r0.getKeysetHandle()
                com.google.crypto.tink.proto.Keyset r1 = r1.keyset
                com.google.crypto.tink.proto.KeysetInfo r1 = com.google.crypto.tink.Util.getKeysetInfo(r1)
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList<com.google.crypto.tink.proto.KeysetInfo$KeyInfo> r1 = r1.keyInfo_
                java.lang.Object r1 = r1.get(r2)
                com.google.crypto.tink.proto.KeysetInfo$KeyInfo r1 = (com.google.crypto.tink.proto.KeysetInfo.KeyInfo) r1
                int r1 = r1.keyId_
                monitor-enter(r0)
                r3 = 0
            L_0x0058:
                com.google.crypto.tink.proto.Keyset$Builder r4 = r0.keysetBuilder     // Catch:{ all -> 0x017d }
                MessageType r4 = r4.instance     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.proto.Keyset r4 = (com.google.crypto.tink.proto.Keyset) r4     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList<com.google.crypto.tink.proto.Keyset$Key> r4 = r4.key_     // Catch:{ all -> 0x017d }
                int r4 = r4.size()     // Catch:{ all -> 0x017d }
                if (r3 >= r4) goto L_0x0166
                com.google.crypto.tink.proto.Keyset$Builder r4 = r0.keysetBuilder     // Catch:{ all -> 0x017d }
                MessageType r4 = r4.instance     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.proto.Keyset r4 = (com.google.crypto.tink.proto.Keyset) r4     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList<com.google.crypto.tink.proto.Keyset$Key> r4 = r4.key_     // Catch:{ all -> 0x017d }
                java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.proto.Keyset$Key r4 = (com.google.crypto.tink.proto.Keyset.Key) r4     // Catch:{ all -> 0x017d }
                int r5 = r4.keyId_     // Catch:{ all -> 0x017d }
                if (r5 != r1) goto L_0x0162
                com.google.crypto.tink.proto.KeyStatusType r3 = r4.getStatus()     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.proto.KeyStatusType r4 = com.google.crypto.tink.proto.KeyStatusType.ENABLED     // Catch:{ all -> 0x017d }
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x017d }
                if (r3 == 0) goto L_0x014b
                com.google.crypto.tink.proto.Keyset$Builder r3 = r0.keysetBuilder     // Catch:{ all -> 0x017d }
                r3.copyOnWrite()     // Catch:{ all -> 0x017d }
                MessageType r3 = r3.instance     // Catch:{ all -> 0x017d }
                com.google.crypto.tink.proto.Keyset r3 = (com.google.crypto.tink.proto.Keyset) r3     // Catch:{ all -> 0x017d }
                r3.primaryKeyId_ = r1     // Catch:{ all -> 0x017d }
                monitor-exit(r0)
                com.google.crypto.tink.Aead r1 = r7.masterKey
                if (r1 == 0) goto L_0x0122
                com.google.crypto.tink.KeysetHandle r1 = r0.getKeysetHandle()
                com.google.crypto.tink.KeysetWriter r3 = r7.writer
                com.google.crypto.tink.Aead r4 = r7.masterKey
                com.google.crypto.tink.proto.Keyset r1 = r1.keyset
                byte[] r5 = r1.toByteArray()
                byte[] r6 = new byte[r2]
                byte[] r5 = r4.encrypt(r5, r6)
                byte[] r2 = new byte[r2]     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                byte[] r2 = r4.decrypt(r5, r2)     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r4 = com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite.getEmptyRegistry()     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                com.google.crypto.tink.proto.Keyset r2 = com.google.crypto.tink.proto.Keyset.parseFrom(r2, r4)     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                boolean r2 = r2.equals(r1)     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                if (r2 == 0) goto L_0x0112
                com.google.crypto.tink.proto.EncryptedKeyset r2 = com.google.crypto.tink.proto.EncryptedKeyset.DEFAULT_INSTANCE
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$Builder r2 = r2.createBuilder()
                com.google.crypto.tink.proto.EncryptedKeyset$Builder r2 = (com.google.crypto.tink.proto.EncryptedKeyset.Builder) r2
                com.google.crypto.tink.shaded.protobuf.ByteString r4 = com.google.crypto.tink.shaded.protobuf.ByteString.copyFrom(r5)
                r2.copyOnWrite()
                MessageType r5 = r2.instance
                com.google.crypto.tink.proto.EncryptedKeyset r5 = (com.google.crypto.tink.proto.EncryptedKeyset) r5
                r6 = 0
                if (r5 == 0) goto L_0x0111
                r4.getClass()
                r5.encryptedKeyset_ = r4
                com.google.crypto.tink.proto.KeysetInfo r1 = com.google.crypto.tink.Util.getKeysetInfo(r1)
                r2.copyOnWrite()
                MessageType r4 = r2.instance
                com.google.crypto.tink.proto.EncryptedKeyset r4 = (com.google.crypto.tink.proto.EncryptedKeyset) r4
                if (r4 == 0) goto L_0x0110
                r1.getClass()
                r4.keysetInfo_ = r1
                com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite r1 = r2.build()
                com.google.crypto.tink.proto.EncryptedKeyset r1 = (com.google.crypto.tink.proto.EncryptedKeyset) r1
                com.google.crypto.tink.integration.android.SharedPrefKeysetWriter r3 = (com.google.crypto.tink.integration.android.SharedPrefKeysetWriter) r3
                android.content.SharedPreferences$Editor r2 = r3.editor
                java.lang.String r3 = r3.keysetName
                byte[] r1 = r1.toByteArray()
                java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.encode(r1)
                android.content.SharedPreferences$Editor r1 = r2.putString(r3, r1)
                boolean r1 = r1.commit()
                if (r1 == 0) goto L_0x0108
                goto L_0x0142
            L_0x0108:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Failed to write to SharedPreferences"
                r0.<init>(r1)
                throw r0
            L_0x0110:
                throw r6
            L_0x0111:
                throw r6
            L_0x0112:
                java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                java.lang.String r1 = "cannot encrypt keyset"
                r0.<init>(r1)     // Catch:{ InvalidProtocolBufferException -> 0x011a }
                throw r0     // Catch:{ InvalidProtocolBufferException -> 0x011a }
            L_0x011a:
                java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
                java.lang.String r1 = "invalid keyset, corrupted key material"
                r0.<init>(r1)
                throw r0
            L_0x0122:
                com.google.crypto.tink.KeysetHandle r1 = r0.getKeysetHandle()
                com.google.crypto.tink.KeysetWriter r2 = r7.writer
                com.google.crypto.tink.proto.Keyset r1 = r1.keyset
                com.google.crypto.tink.integration.android.SharedPrefKeysetWriter r2 = (com.google.crypto.tink.integration.android.SharedPrefKeysetWriter) r2
                android.content.SharedPreferences$Editor r3 = r2.editor
                java.lang.String r2 = r2.keysetName
                byte[] r1 = r1.toByteArray()
                java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.encode(r1)
                android.content.SharedPreferences$Editor r1 = r3.putString(r2, r1)
                boolean r1 = r1.commit()
                if (r1 == 0) goto L_0x0143
            L_0x0142:
                return r0
            L_0x0143:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Failed to write to SharedPreferences"
                r0.<init>(r1)
                throw r0
            L_0x014b:
                java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x017d }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
                r3.<init>()     // Catch:{ all -> 0x017d }
                java.lang.String r4 = "cannot set key as primary because it's not enabled: "
                r3.append(r4)     // Catch:{ all -> 0x017d }
                r3.append(r1)     // Catch:{ all -> 0x017d }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x017d }
                r2.<init>(r1)     // Catch:{ all -> 0x017d }
                throw r2     // Catch:{ all -> 0x017d }
            L_0x0162:
                int r3 = r3 + 1
                goto L_0x0058
            L_0x0166:
                java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x017d }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
                r3.<init>()     // Catch:{ all -> 0x017d }
                java.lang.String r4 = "key not found: "
                r3.append(r4)     // Catch:{ all -> 0x017d }
                r3.append(r1)     // Catch:{ all -> 0x017d }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x017d }
                r2.<init>(r1)     // Catch:{ all -> 0x017d }
                throw r2     // Catch:{ all -> 0x017d }
            L_0x017d:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x0180:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x0183:
                java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
                java.lang.String r1 = "cannot read or generate keyset"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeysetManager.Builder.readOrGenerateNewKeyset():com.google.crypto.tink.KeysetManager");
        }

        public final Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            AndroidKeystoreKmsClient androidKeystoreKmsClient;
            if (!(VERSION.SDK_INT >= 23)) {
                return null;
            }
            if (this.keyStore != null) {
                com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.Builder builder = new com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.Builder();
                KeyStore keyStore2 = this.keyStore;
                if (keyStore2 != null) {
                    builder.keyStore = keyStore2;
                    androidKeystoreKmsClient = new AndroidKeystoreKmsClient(builder, null);
                } else {
                    throw new IllegalArgumentException("val cannot be null");
                }
            } else {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            }
            boolean hasKey = androidKeystoreKmsClient.hasKey(this.masterKeyUri);
            if (!hasKey) {
                try {
                    AndroidKeystoreKmsClient.generateNewAeadKey(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException unused) {
                    return null;
                }
            }
            try {
                return androidKeystoreKmsClient.getAead(this.masterKeyUri);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!hasKey) {
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.masterKeyUri}), e2);
            }
        }

        public Builder withMasterKeyUri(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.useKeystore) {
                this.masterKeyUri = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public Builder withSharedPref(Context context, String str, String str2) throws IOException {
            if (context != null) {
                this.reader = new SharedPrefKeysetReader(context, str, str2);
                this.writer = new SharedPrefKeysetWriter(context, str, str2);
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }
    }

    public AndroidKeysetManager(Builder builder, AnonymousClass1 r2) throws GeneralSecurityException, IOException {
        this.keysetManager = builder.keysetManager;
    }
}
