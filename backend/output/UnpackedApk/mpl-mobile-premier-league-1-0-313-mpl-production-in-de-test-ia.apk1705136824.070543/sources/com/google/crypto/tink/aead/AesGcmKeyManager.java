package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKey.Builder;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesGcmKeyManager extends KeyTypeManager<AesGcmKey> {
    public AesGcmKeyManager() {
        super(AesGcmKey.class, new PrimitiveFactory<Aead, AesGcmKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                return new AesGcmJce(((AesGcmKey) obj).keyValue_.toByteArray());
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public KeyFactory<AesGcmKeyFormat, AesGcmKey> keyFactory() {
        return new KeyFactory<AesGcmKeyFormat, AesGcmKey>(AesGcmKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                Builder builder = (Builder) AesGcmKey.DEFAULT_INSTANCE.createBuilder();
                byte[] randBytes = Random.randBytes(((AesGcmKeyFormat) messageLite).keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesGcmKey.access$300((AesGcmKey) builder.instance, copyFrom);
                if (AesGcmKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesGcmKey) builder.instance).version_ = 0;
                    return (AesGcmKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(AesGcmKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                Validators.validateAesKeySize(((AesGcmKeyFormat) messageLite).keySize_);
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(AesGcmKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesGcmKey aesGcmKey = (AesGcmKey) messageLite;
        Validators.validateVersion(aesGcmKey.version_, 0);
        Validators.validateAesKeySize(aesGcmKey.keyValue_.size());
    }
}
