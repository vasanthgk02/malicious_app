package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.proto.AesGcmSivKey;
import com.google.crypto.tink.proto.AesGcmSivKey.Builder;
import com.google.crypto.tink.proto.AesGcmSivKeyFormat;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesGcmSivKeyManager extends KeyTypeManager<AesGcmSivKey> {
    public AesGcmSivKeyManager() {
        super(AesGcmSivKey.class, new PrimitiveFactory<Aead, AesGcmSivKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                return new AesGcmSiv(((AesGcmSivKey) obj).keyValue_.toByteArray());
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public KeyFactory<AesGcmSivKeyFormat, AesGcmSivKey> keyFactory() {
        return new KeyFactory<AesGcmSivKeyFormat, AesGcmSivKey>(AesGcmSivKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                Builder builder = (Builder) AesGcmSivKey.DEFAULT_INSTANCE.createBuilder();
                byte[] randBytes = Random.randBytes(((AesGcmSivKeyFormat) messageLite).keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesGcmSivKey.access$300((AesGcmSivKey) builder.instance, copyFrom);
                if (AesGcmSivKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesGcmSivKey) builder.instance).version_ = 0;
                    return (AesGcmSivKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(AesGcmSivKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                Validators.validateAesKeySize(((AesGcmSivKeyFormat) messageLite).keySize_);
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(AesGcmSivKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesGcmSivKey aesGcmSivKey = (AesGcmSivKey) messageLite;
        Validators.validateVersion(aesGcmSivKey.version_, 0);
        Validators.validateAesKeySize(aesGcmSivKey.keyValue_.size());
    }
}
