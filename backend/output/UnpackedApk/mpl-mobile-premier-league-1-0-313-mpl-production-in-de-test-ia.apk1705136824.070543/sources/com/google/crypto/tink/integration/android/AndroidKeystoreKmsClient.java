package com.google.crypto.tink.integration.android;

import android.os.Build.VERSION;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;

public final class AndroidKeystoreKmsClient implements KmsClient {
    public KeyStore keyStore;
    public final String keyUri;

    public static final class Builder {
        public KeyStore keyStore = null;
        public String keyUri = null;

        public Builder() {
            if (VERSION.SDK_INT >= 23) {
                try {
                    KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                    this.keyStore = instance;
                    instance.load(null);
                } catch (IOException | GeneralSecurityException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
        }
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        Builder builder = new Builder();
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void generateNewAeadKey(java.lang.String r6) throws java.security.GeneralSecurityException {
        /*
            java.lang.String r0 = "AndroidKeyStore"
            java.lang.String r1 = "android-keystore://"
            com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient$Builder r2 = new com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient$Builder
            r2.<init>()
            java.security.KeyStore r2 = r2.keyStore
            java.lang.String r3 = com.google.crypto.tink.subtle.Validators.validateKmsKeyUriAndRemovePrefix(r1, r6)     // Catch:{ all -> 0x0075 }
            boolean r2 = r2.containsAlias(r3)     // Catch:{ NullPointerException -> 0x0014 }
            goto L_0x0025
        L_0x0014:
            r4 = 20
            java.lang.Thread.sleep(r4)     // Catch:{ IOException -> 0x006e, InterruptedException -> 0x0021 }
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x006e, InterruptedException -> 0x0021 }
            r4 = 0
            r2.load(r4)     // Catch:{ IOException -> 0x006e, InterruptedException -> 0x0021 }
        L_0x0021:
            boolean r2 = r2.containsAlias(r3)     // Catch:{ all -> 0x0075 }
        L_0x0025:
            if (r2 != 0) goto L_0x005c
            java.lang.String r6 = com.google.crypto.tink.subtle.Validators.validateKmsKeyUriAndRemovePrefix(r1, r6)
            java.lang.String r1 = "AES"
            javax.crypto.KeyGenerator r0 = javax.crypto.KeyGenerator.getInstance(r1, r0)
            android.security.keystore.KeyGenParameterSpec$Builder r1 = new android.security.keystore.KeyGenParameterSpec$Builder
            r2 = 3
            r1.<init>(r6, r2)
            r6 = 256(0x100, float:3.59E-43)
            android.security.keystore.KeyGenParameterSpec$Builder r6 = r1.setKeySize(r6)
            java.lang.String r1 = "GCM"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            android.security.keystore.KeyGenParameterSpec$Builder r6 = r6.setBlockModes(r1)
            java.lang.String r1 = "NoPadding"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            android.security.keystore.KeyGenParameterSpec$Builder r6 = r6.setEncryptionPaddings(r1)
            android.security.keystore.KeyGenParameterSpec r6 = r6.build()
            r0.init(r6)
            r0.generateKey()
            return
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r6
            java.lang.String r6 = "cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again"
            java.lang.String r6 = java.lang.String.format(r6, r1)
            r0.<init>(r6)
            throw r0
        L_0x006e:
            r6 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0075 }
            r0.<init>(r6)     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.generateNewAeadKey(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean doesSupport(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)
            return r1
        L_0x0010:
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0023
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            monitor-exit(r2)
            return r1
        L_0x0026:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.doesSupport(java.lang.String):boolean");
    }

    public synchronized Aead getAead(String str) throws GeneralSecurityException {
        AndroidKeystoreAesGcm androidKeystoreAesGcm;
        try {
            if (this.keyUri != null) {
                if (!this.keyUri.equals(str)) {
                    throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.keyUri, str}));
                }
            }
            androidKeystoreAesGcm = new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix("android-keystore://", str), this.keyStore);
            byte[] randBytes = Random.randBytes(10);
            byte[] bArr = new byte[0];
            if (!Arrays.equals(randBytes, androidKeystoreAesGcm.decrypt(androidKeystoreAesGcm.encrypt(randBytes, bArr), bArr))) {
                throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
            }
        }
        return androidKeystoreAesGcm;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hasKey(java.lang.String r3) throws java.security.GeneralSecurityException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r3 = com.google.crypto.tink.subtle.Validators.validateKmsKeyUriAndRemovePrefix(r0, r3)     // Catch:{ all -> 0x002f }
            java.security.KeyStore r0 = r2.keyStore     // Catch:{ NullPointerException -> 0x000f }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ NullPointerException -> 0x000f }
            monitor-exit(r2)
            return r3
        L_0x000f:
            r0 = 20
            java.lang.Thread.sleep(r0)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            r2.keyStore = r0     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
        L_0x0020:
            java.security.KeyStore r0 = r2.keyStore     // Catch:{ all -> 0x002f }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return r3
        L_0x0028:
            r3 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x002f }
            r0.<init>(r3)     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.hasKey(java.lang.String):boolean");
    }

    public AndroidKeystoreKmsClient(Builder builder, AnonymousClass1 r2) {
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }
}
