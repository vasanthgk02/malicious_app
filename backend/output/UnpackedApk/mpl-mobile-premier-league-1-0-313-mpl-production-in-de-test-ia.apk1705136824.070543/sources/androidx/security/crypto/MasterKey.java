package androidx.security.crypto;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public final class MasterKey {
    public final String mKeyAlias;

    public static final class Builder {
        public final Context mContext;
        public final String mKeyAlias = "_androidx_security_master_key_";
        public KeyGenParameterSpec mKeyGenParameterSpec;
        public KeyScheme mKeyScheme;

        public Builder(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public MasterKey build() throws GeneralSecurityException, IOException {
            if (VERSION.SDK_INT < 23) {
                return new MasterKey(this.mKeyAlias, null);
            }
            if (this.mKeyScheme == null && this.mKeyGenParameterSpec == null) {
                throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
            }
            if (this.mKeyScheme == KeyScheme.AES256_GCM) {
                this.mKeyGenParameterSpec = new android.security.keystore.KeyGenParameterSpec.Builder(this.mKeyAlias, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build();
            }
            KeyGenParameterSpec keyGenParameterSpec = this.mKeyGenParameterSpec;
            if (keyGenParameterSpec != null) {
                return new MasterKey(MasterKeys.getOrCreate(keyGenParameterSpec), this.mKeyGenParameterSpec);
            }
            throw new NullPointerException("KeyGenParameterSpec was null after build() check");
        }

        public Builder setKeyScheme(KeyScheme keyScheme) {
            if (keyScheme.ordinal() != 0) {
                throw new IllegalArgumentException("Unsupported scheme: " + keyScheme);
            } else if (VERSION.SDK_INT < 23 || this.mKeyGenParameterSpec == null) {
                this.mKeyScheme = keyScheme;
                return this;
            } else {
                throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
            }
        }
    }

    public enum KeyScheme {
        AES256_GCM
    }

    public MasterKey(String str, Object obj) {
        this.mKeyAlias = str;
        if (VERSION.SDK_INT >= 23) {
            KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) obj;
        }
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MasterKey{keyAlias=");
        outline73.append(this.mKeyAlias);
        outline73.append(", isKeyStoreBacked=");
        boolean z = false;
        if (VERSION.SDK_INT >= 23) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load(null);
                z = instance.containsAlias(this.mKeyAlias);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            }
        }
        return GeneratedOutlineSupport.outline66(outline73, z, "}");
    }
}
