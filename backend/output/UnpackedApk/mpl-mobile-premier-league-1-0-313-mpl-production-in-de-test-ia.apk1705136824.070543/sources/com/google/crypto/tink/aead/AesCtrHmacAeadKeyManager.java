package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey.Builder;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey> {
    public AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, new PrimitiveFactory<Aead, AesCtrHmacAeadKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                AesCtrHmacAeadKey aesCtrHmacAeadKey = (AesCtrHmacAeadKey) obj;
                AesCtrKeyManager aesCtrKeyManager = new AesCtrKeyManager();
                AesCtrKey aesCtrKey = aesCtrHmacAeadKey.aesCtrKey_;
                if (aesCtrKey == null) {
                    aesCtrKey = AesCtrKey.DEFAULT_INSTANCE;
                }
                return new EncryptThenAuthenticate((IndCpaCipher) aesCtrKeyManager.getPrimitive(aesCtrKey, IndCpaCipher.class), (Mac) new HmacKeyManager().getPrimitive(aesCtrHmacAeadKey.getHmacKey(), Mac.class), aesCtrHmacAeadKey.getHmacKey().getParams().tagSize_);
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey> keyFactory() {
        return new KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>(AesCtrHmacAeadKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = (AesCtrHmacAeadKeyFormat) messageLite;
                AesCtrKey aesCtrKey = (AesCtrKey) new AesCtrKeyManager().keyFactory().createKey(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat());
                KeyFactory<HmacKeyFormat, HmacKey> keyFactory = new HmacKeyManager().keyFactory();
                HmacKeyFormat hmacKeyFormat = aesCtrHmacAeadKeyFormat.hmacKeyFormat_;
                if (hmacKeyFormat == null) {
                    hmacKeyFormat = HmacKeyFormat.DEFAULT_INSTANCE;
                }
                Builder builder = (Builder) AesCtrHmacAeadKey.DEFAULT_INSTANCE.createBuilder();
                builder.copyOnWrite();
                AesCtrHmacAeadKey.access$300((AesCtrHmacAeadKey) builder.instance, aesCtrKey);
                builder.copyOnWrite();
                AesCtrHmacAeadKey.access$600((AesCtrHmacAeadKey) builder.instance, (HmacKey) keyFactory.createKey(hmacKeyFormat));
                if (AesCtrHmacAeadKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((AesCtrHmacAeadKey) builder.instance).version_ = 0;
                    return (AesCtrHmacAeadKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = (AesCtrHmacAeadKeyFormat) messageLite;
                new AesCtrKeyManager().keyFactory().validateKeyFormat(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat());
                KeyFactory<HmacKeyFormat, HmacKey> keyFactory = new HmacKeyManager().keyFactory();
                HmacKeyFormat hmacKeyFormat = aesCtrHmacAeadKeyFormat.hmacKeyFormat_;
                if (hmacKeyFormat == null) {
                    hmacKeyFormat = HmacKeyFormat.DEFAULT_INSTANCE;
                }
                keyFactory.validateKeyFormat(hmacKeyFormat);
                Validators.validateAesKeySize(aesCtrHmacAeadKeyFormat.getAesCtrKeyFormat().keySize_);
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(AesCtrHmacAeadKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = (AesCtrHmacAeadKey) messageLite;
        Validators.validateVersion(aesCtrHmacAeadKey.version_, 0);
        AesCtrKeyManager aesCtrKeyManager = new AesCtrKeyManager();
        AesCtrKey aesCtrKey = aesCtrHmacAeadKey.aesCtrKey_;
        if (aesCtrKey == null) {
            aesCtrKey = AesCtrKey.DEFAULT_INSTANCE;
        }
        aesCtrKeyManager.validateKey(aesCtrKey);
        new HmacKeyManager().validateKey(aesCtrHmacAeadKey.getHmacKey());
    }
}
