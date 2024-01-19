package androidx.security.crypto;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

@Deprecated
public final class MasterKeys {
    static {
        new Builder("_androidx_security_master_key_", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build();
    }

    public static String getOrCreate(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        if (keyGenParameterSpec.getKeySize() != 256) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("invalid key size, want 256 bits got ");
            outline73.append(keyGenParameterSpec.getKeySize());
            outline73.append(" bits");
            throw new IllegalArgumentException(outline73.toString());
        } else if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("invalid block mode, want GCM got ");
            outline732.append(Arrays.toString(keyGenParameterSpec.getBlockModes()));
            throw new IllegalArgumentException(outline732.toString());
        } else if (keyGenParameterSpec.getPurposes() != 3) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            outline733.append(keyGenParameterSpec.getPurposes());
            throw new IllegalArgumentException(outline733.toString());
        } else if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("invalid padding mode, want NoPadding got ");
            outline734.append(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
            throw new IllegalArgumentException(outline734.toString());
        } else if (!keyGenParameterSpec.isUserAuthenticationRequired() || keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() >= 1) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (!instance.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator instance2 = KeyGenerator.getInstance(EncryptionHelper.algorithm, "AndroidKeyStore");
                    instance2.init(keyGenParameterSpec);
                    instance2.generateKey();
                } catch (ProviderException e2) {
                    throw new GeneralSecurityException(e2.getMessage(), e2);
                }
            }
            return keyGenParameterSpec.getKeystoreAlias();
        } else {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
    }
}
