package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.KeysetInfo.Builder;
import com.google.crypto.tink.proto.KeysetInfo.KeyInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

public class Util {
    static {
        Charset.forName("UTF-8");
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        Builder builder = (Builder) KeysetInfo.DEFAULT_INSTANCE.createBuilder();
        int i = keyset.primaryKeyId_;
        builder.copyOnWrite();
        ((KeysetInfo) builder.instance).primaryKeyId_ = i;
        for (Key key : keyset.key_) {
            KeyInfo.Builder builder2 = (KeyInfo.Builder) KeyInfo.DEFAULT_INSTANCE.createBuilder();
            String str = key.getKeyData().typeUrl_;
            builder2.copyOnWrite();
            KeyInfo.access$100((KeyInfo) builder2.instance, str);
            KeyStatusType status = key.getStatus();
            builder2.copyOnWrite();
            KeyInfo.access$500((KeyInfo) builder2.instance, status);
            OutputPrefixType outputPrefixType = key.getOutputPrefixType();
            builder2.copyOnWrite();
            KeyInfo.access$1000((KeyInfo) builder2.instance, outputPrefixType);
            int i2 = key.keyId_;
            builder2.copyOnWrite();
            ((KeyInfo) builder2.instance).keyId_ = i2;
            builder.copyOnWrite();
            KeysetInfo.access$1700((KeysetInfo) builder.instance, (KeyInfo) builder2.build());
        }
        return (KeysetInfo) builder.build();
    }

    public static void validateKeyset(Keyset keyset) throws GeneralSecurityException {
        int i = keyset.primaryKeyId_;
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (Key key : keyset.key_) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                if (!(key.keyData_ != null)) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(key.keyId_)}));
                } else if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(key.keyId_)}));
                } else if (key.getStatus() != KeyStatusType.UNKNOWN_STATUS) {
                    if (key.keyId_ == i) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    KeyMaterialType forNumber = KeyMaterialType.forNumber(key.getKeyData().keyMaterialType_);
                    if (forNumber == null) {
                        forNumber = KeyMaterialType.UNRECOGNIZED;
                    }
                    if (forNumber != KeyMaterialType.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i2++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(key.keyId_)}));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
