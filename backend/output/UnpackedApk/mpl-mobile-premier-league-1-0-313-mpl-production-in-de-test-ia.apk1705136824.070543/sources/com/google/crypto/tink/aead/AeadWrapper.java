package com.google.crypto.tink.aead;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class AeadWrapper implements PrimitiveWrapper<Aead, Aead> {
    public static final Logger logger = Logger.getLogger(AeadWrapper.class.getName());

    public static class WrappedAead implements Aead {
        public final PrimitiveSet<Aead> pSet;

        public WrappedAead(PrimitiveSet primitiveSet, AnonymousClass1 r2) {
            this.pSet = primitiveSet;
        }

        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (Entry entry : this.pSet.getPrimitive(copyOfRange)) {
                    try {
                        return ((Aead) entry.primitive).decrypt(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e2) {
                        Logger logger = AeadWrapper.logger;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ciphertext prefix matches a key, but cannot decrypt: ");
                        outline73.append(e2.toString());
                        logger.info(outline73.toString());
                    }
                }
            }
            for (Entry entry2 : this.pSet.getRawPrimitives()) {
                try {
                    return ((Aead) entry2.primitive).decrypt(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return TextAppearanceConfig.concat(this.pSet.primary.getIdentifier(), ((Aead) this.pSet.primary.primitive).encrypt(bArr, bArr2));
        }
    }

    public Class<Aead> getInputPrimitiveClass() {
        return Aead.class;
    }

    public Class<Aead> getPrimitiveClass() {
        return Aead.class;
    }

    public Object wrap(PrimitiveSet primitiveSet) throws GeneralSecurityException {
        return new WrappedAead(primitiveSet, null);
    }
}
