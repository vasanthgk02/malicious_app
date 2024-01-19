package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKey.Builder;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey> {
    public AesEaxKeyManager() {
        super(AesEaxKey.class, new PrimitiveFactory<Aead, AesEaxKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                AesEaxKey aesEaxKey = (AesEaxKey) obj;
                return new AesEaxJce(aesEaxKey.keyValue_.toByteArray(), aesEaxKey.getParams().ivSize_);
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public KeyFactory<AesEaxKeyFormat, AesEaxKey> keyFactory() {
        return new KeyFactory<AesEaxKeyFormat, AesEaxKey>(AesEaxKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                AesEaxKeyFormat aesEaxKeyFormat = (AesEaxKeyFormat) messageLite;
                Builder builder = (Builder) AesEaxKey.DEFAULT_INSTANCE.createBuilder();
                byte[] randBytes = Random.randBytes(aesEaxKeyFormat.keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesEaxKey.access$600((AesEaxKey) builder.instance, copyFrom);
                AesEaxParams params = aesEaxKeyFormat.getParams();
                builder.copyOnWrite();
                AesEaxKey.access$300((AesEaxKey) builder.instance, params);
                if (AesEaxKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesEaxKey) builder.instance).version_ = 0;
                    return (AesEaxKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(AesEaxKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                AesEaxKeyFormat aesEaxKeyFormat = (AesEaxKeyFormat) messageLite;
                Validators.validateAesKeySize(aesEaxKeyFormat.keySize_);
                if (aesEaxKeyFormat.getParams().ivSize_ != 12 && aesEaxKeyFormat.getParams().ivSize_ != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(AesEaxKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesEaxKey aesEaxKey = (AesEaxKey) messageLite;
        Validators.validateVersion(aesEaxKey.version_, 0);
        Validators.validateAesKeySize(aesEaxKey.keyValue_.size());
        if (aesEaxKey.getParams().ivSize_ != 12 && aesEaxKey.getParams().ivSize_ != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
