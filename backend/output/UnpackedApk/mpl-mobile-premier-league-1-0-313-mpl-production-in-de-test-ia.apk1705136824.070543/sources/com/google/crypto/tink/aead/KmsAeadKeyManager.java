package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKey.Builder;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey> {
    public KmsAeadKeyManager() {
        super(KmsAeadKey.class, new PrimitiveFactory<Aead, KmsAeadKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                KmsAeadKeyFormat kmsAeadKeyFormat = ((KmsAeadKey) obj).params_;
                if (kmsAeadKeyFormat == null) {
                    kmsAeadKeyFormat = KmsAeadKeyFormat.DEFAULT_INSTANCE;
                }
                String str = kmsAeadKeyFormat.keyUri_;
                return KmsClients.get(str).getAead(str);
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public KeyFactory<KmsAeadKeyFormat, KmsAeadKey> keyFactory() {
        return new KeyFactory<KmsAeadKeyFormat, KmsAeadKey>(KmsAeadKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                Builder builder = (Builder) KmsAeadKey.DEFAULT_INSTANCE.createBuilder();
                builder.copyOnWrite();
                KmsAeadKey.access$300((KmsAeadKey) builder.instance, (KmsAeadKeyFormat) messageLite);
                if (KmsAeadKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((KmsAeadKey) builder.instance).version_ = 0;
                    return (KmsAeadKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(KmsAeadKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                KmsAeadKeyFormat kmsAeadKeyFormat = (KmsAeadKeyFormat) messageLite;
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.REMOTE;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(KmsAeadKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        Validators.validateVersion(((KmsAeadKey) messageLite).version_, 0);
    }
}
