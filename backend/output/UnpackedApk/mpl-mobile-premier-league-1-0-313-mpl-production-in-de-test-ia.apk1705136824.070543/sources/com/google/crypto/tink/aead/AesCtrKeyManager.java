package com.google.crypto.tink.aead;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKey.Builder;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class AesCtrKeyManager extends KeyTypeManager<AesCtrKey> {
    public AesCtrKeyManager() {
        super(AesCtrKey.class, new PrimitiveFactory<IndCpaCipher, AesCtrKey>(IndCpaCipher.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                AesCtrKey aesCtrKey = (AesCtrKey) obj;
                byte[] byteArray = aesCtrKey.keyValue_.toByteArray();
                AesCtrParams aesCtrParams = aesCtrKey.params_;
                if (aesCtrParams == null) {
                    aesCtrParams = AesCtrParams.DEFAULT_INSTANCE;
                }
                return new AesCtrJceCipher(byteArray, aesCtrParams.ivSize_);
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public KeyFactory<AesCtrKeyFormat, AesCtrKey> keyFactory() {
        return new KeyFactory<AesCtrKeyFormat, AesCtrKey>(AesCtrKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) messageLite;
                Builder builder = (Builder) AesCtrKey.DEFAULT_INSTANCE.createBuilder();
                AesCtrParams aesCtrParams = aesCtrKeyFormat.params_;
                if (aesCtrParams == null) {
                    aesCtrParams = AesCtrParams.DEFAULT_INSTANCE;
                }
                builder.copyOnWrite();
                AesCtrKey.access$300((AesCtrKey) builder.instance, aesCtrParams);
                byte[] randBytes = Random.randBytes(aesCtrKeyFormat.keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesCtrKey.access$600((AesCtrKey) builder.instance, copyFrom);
                if (AesCtrKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesCtrKey) builder.instance).version_ = 0;
                    return (AesCtrKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(AesCtrKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) messageLite;
                Validators.validateAesKeySize(aesCtrKeyFormat.keySize_);
                AesCtrKeyManager aesCtrKeyManager = AesCtrKeyManager.this;
                AesCtrParams aesCtrParams = aesCtrKeyFormat.params_;
                if (aesCtrParams == null) {
                    aesCtrParams = AesCtrParams.DEFAULT_INSTANCE;
                }
                if (aesCtrKeyManager != null) {
                    int i = aesCtrParams.ivSize_;
                    if (i < 12 || i > 16) {
                        throw new GeneralSecurityException("invalid IV size");
                    }
                    return;
                }
                throw null;
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(AesCtrKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(AesCtrKey aesCtrKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCtrKey.version_, 0);
        Validators.validateAesKeySize(aesCtrKey.keyValue_.size());
        AesCtrParams aesCtrParams = aesCtrKey.params_;
        if (aesCtrParams == null) {
            aesCtrParams = AesCtrParams.DEFAULT_INSTANCE;
        }
        int i = aesCtrParams.ivSize_;
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
