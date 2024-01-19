package com.google.crypto.tink.daead;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKey.Builder;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    public AesSivKeyManager() {
        super(AesSivKey.class, new PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                return new AesSiv(((AesSivKey) obj).keyValue_.toByteArray());
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public KeyFactory<AesSivKeyFormat, AesSivKey> keyFactory() {
        return new KeyFactory<AesSivKeyFormat, AesSivKey>(AesSivKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                Builder builder = (Builder) AesSivKey.DEFAULT_INSTANCE.createBuilder();
                byte[] randBytes = Random.randBytes(((AesSivKeyFormat) messageLite).keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesSivKey.access$300((AesSivKey) builder.instance, copyFrom);
                if (AesSivKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesSivKey) builder.instance).version_ = 0;
                    return (AesSivKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(AesSivKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                AesSivKeyFormat aesSivKeyFormat = (AesSivKeyFormat) messageLite;
                if (aesSivKeyFormat.keySize_ != 64) {
                    throw new InvalidAlgorithmParameterException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("invalid key size: "), aesSivKeyFormat.keySize_, ". Valid keys must have 64 bytes."));
                }
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(AesSivKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesSivKey aesSivKey = (AesSivKey) messageLite;
        Validators.validateVersion(aesSivKey.version_, 0);
        if (aesSivKey.keyValue_.size() != 64) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("invalid key size: ");
            outline73.append(aesSivKey.keyValue_.size());
            outline73.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(outline73.toString());
        }
    }
}
