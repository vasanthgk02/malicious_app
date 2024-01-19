package com.google.crypto.tink.subtle;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

public final class PrfHmacJce implements Prf {
    public final String algorithm;
    public final Key key;
    public final ThreadLocal<Mac> localMac = new ThreadLocal<Mac>() {
        public Object initialValue() {
            try {
                Mac mac = (Mac) EngineFactory.MAC.getInstance(PrfHmacJce.this.algorithm);
                mac.init(PrfHmacJce.this.key);
                return mac;
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    };
    public final int maxOutputLength;

    public PrfHmacJce(String str, Key key2) throws GeneralSecurityException {
        this.algorithm = str;
        this.key = key2;
        if (key2.getEncoded().length >= 16) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.maxOutputLength = 20;
            } else if (c2 == 1) {
                this.maxOutputLength = 32;
            } else if (c2 == 2) {
                this.maxOutputLength = 48;
            } else if (c2 == 3) {
                this.maxOutputLength = 64;
            } else {
                throw new NoSuchAlgorithmException(GeneratedOutlineSupport.outline50("unknown Hmac algorithm: ", str));
            }
            this.localMac.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.maxOutputLength) {
            this.localMac.get().update(bArr);
            return Arrays.copyOf(this.localMac.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
