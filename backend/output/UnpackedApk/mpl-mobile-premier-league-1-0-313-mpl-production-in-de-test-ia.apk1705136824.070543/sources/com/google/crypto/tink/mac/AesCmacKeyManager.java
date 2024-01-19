package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.AesCmacKey;
import com.google.crypto.tink.proto.AesCmacKey.Builder;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public final class AesCmacKeyManager extends KeyTypeManager<AesCmacKey> {
    public AesCmacKeyManager() {
        super(AesCmacKey.class, new PrimitiveFactory<Mac, AesCmacKey>(Mac.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                AesCmacKey aesCmacKey = (AesCmacKey) obj;
                PrfAesCmac prfAesCmac = new PrfAesCmac(aesCmacKey.keyValue_.toByteArray());
                AesCmacParams aesCmacParams = aesCmacKey.params_;
                if (aesCmacParams == null) {
                    aesCmacParams = AesCmacParams.DEFAULT_INSTANCE;
                }
                return new PrfMac(prfAesCmac, aesCmacParams.tagSize_);
            }
        });
    }

    public static void validateParams(AesCmacParams aesCmacParams) throws GeneralSecurityException {
        int i = aesCmacParams.tagSize_;
        if (i < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (i > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public KeyFactory<AesCmacKeyFormat, AesCmacKey> keyFactory() {
        return new KeyFactory<AesCmacKeyFormat, AesCmacKey>(this, AesCmacKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                AesCmacKeyFormat aesCmacKeyFormat = (AesCmacKeyFormat) messageLite;
                Builder builder = (Builder) AesCmacKey.DEFAULT_INSTANCE.createBuilder();
                builder.copyOnWrite();
                ((AesCmacKey) builder.instance).version_ = 0;
                byte[] randBytes = Random.randBytes(aesCmacKeyFormat.keySize_);
                ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                builder.copyOnWrite();
                AesCmacKey.access$300((AesCmacKey) builder.instance, copyFrom);
                AesCmacParams aesCmacParams = aesCmacKeyFormat.params_;
                if (aesCmacParams == null) {
                    aesCmacParams = AesCmacParams.DEFAULT_INSTANCE;
                }
                builder.copyOnWrite();
                AesCmacKey.access$500((AesCmacKey) builder.instance, aesCmacParams);
                return (AesCmacKey) builder.build();
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(AesCmacKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                AesCmacKeyFormat aesCmacKeyFormat = (AesCmacKeyFormat) messageLite;
                AesCmacParams aesCmacParams = aesCmacKeyFormat.params_;
                if (aesCmacParams == null) {
                    aesCmacParams = AesCmacParams.DEFAULT_INSTANCE;
                }
                AesCmacKeyManager.validateParams(aesCmacParams);
                if (aesCmacKeyFormat.keySize_ != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(AesCmacKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        AesCmacKey aesCmacKey = (AesCmacKey) messageLite;
        Validators.validateVersion(aesCmacKey.version_, 0);
        if (aesCmacKey.keyValue_.size() == 32) {
            AesCmacParams aesCmacParams = aesCmacKey.params_;
            if (aesCmacParams == null) {
                aesCmacParams = AesCmacParams.DEFAULT_INSTANCE;
            }
            validateParams(aesCmacParams);
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }
}
