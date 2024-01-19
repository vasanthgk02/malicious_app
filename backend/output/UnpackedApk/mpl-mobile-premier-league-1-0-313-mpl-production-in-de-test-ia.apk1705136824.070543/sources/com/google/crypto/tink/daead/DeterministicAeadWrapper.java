package com.google.crypto.tink.daead;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {
    public static final Logger logger = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    public static class WrappedDeterministicAead implements DeterministicAead {
        public PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (Entry entry : this.primitives.getPrimitive(copyOfRange)) {
                    try {
                        return ((DeterministicAead) entry.primitive).decryptDeterministically(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e2) {
                        Logger logger = DeterministicAeadWrapper.logger;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ciphertext prefix matches a key, but cannot decrypt: ");
                        outline73.append(e2.toString());
                        logger.info(outline73.toString());
                    }
                }
            }
            for (Entry entry2 : this.primitives.getRawPrimitives()) {
                try {
                    return ((DeterministicAead) entry2.primitive).decryptDeterministically(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return TextAppearanceConfig.concat(this.primitives.primary.getIdentifier(), ((DeterministicAead) this.primitives.primary.primitive).encryptDeterministically(bArr, bArr2));
        }
    }

    public Class<DeterministicAead> getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    public Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    public Object wrap(PrimitiveSet primitiveSet) throws GeneralSecurityException {
        return new WrappedDeterministicAead(primitiveSet);
    }
}
