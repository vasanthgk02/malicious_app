package com.google.crypto.tink.mac;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveSet.Entry;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class MacWrapper implements PrimitiveWrapper<Mac, Mac> {
    public static final Logger logger = Logger.getLogger(MacWrapper.class.getName());

    public static class WrappedMac implements Mac {
        public final byte[] formatVersion = {0};
        public final PrimitiveSet<Mac> primitives;

        public WrappedMac(PrimitiveSet primitiveSet, AnonymousClass1 r3) {
            this.primitives = primitiveSet;
        }

        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.primary.outputPrefixType.equals(OutputPrefixType.LEGACY)) {
                return TextAppearanceConfig.concat(this.primitives.primary.getIdentifier(), ((Mac) this.primitives.primary.primitive).computeMac(TextAppearanceConfig.concat(bArr, this.formatVersion)));
            }
            return TextAppearanceConfig.concat(this.primitives.primary.getIdentifier(), ((Mac) this.primitives.primary.primitive).computeMac(bArr));
        }

        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (Entry entry : this.primitives.getPrimitive(copyOf)) {
                    try {
                        if (entry.outputPrefixType.equals(OutputPrefixType.LEGACY)) {
                            ((Mac) entry.primitive).verifyMac(copyOfRange, TextAppearanceConfig.concat(bArr2, this.formatVersion));
                        } else {
                            ((Mac) entry.primitive).verifyMac(copyOfRange, bArr2);
                        }
                        return;
                    } catch (GeneralSecurityException e2) {
                        Logger logger = MacWrapper.logger;
                        logger.info("tag prefix matches a key, but cannot verify: " + e2);
                    }
                }
                for (Entry entry2 : this.primitives.getRawPrimitives()) {
                    try {
                        ((Mac) entry2.primitive).verifyMac(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }
    }

    public Class<Mac> getInputPrimitiveClass() {
        return Mac.class;
    }

    public Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    public Object wrap(PrimitiveSet primitiveSet) throws GeneralSecurityException {
        return new WrappedMac(primitiveSet, null);
    }
}
