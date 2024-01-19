package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey.Builder;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey> {
    public KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, new PrimitiveFactory<Aead, KmsEnvelopeAeadKey>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                KmsEnvelopeAeadKey kmsEnvelopeAeadKey = (KmsEnvelopeAeadKey) obj;
                KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = kmsEnvelopeAeadKey.params_;
                if (kmsEnvelopeAeadKeyFormat == null) {
                    kmsEnvelopeAeadKeyFormat = KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE;
                }
                String str = kmsEnvelopeAeadKeyFormat.kekUri_;
                Aead aead = KmsClients.get(str).getAead(str);
                KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat2 = kmsEnvelopeAeadKey.params_;
                if (kmsEnvelopeAeadKeyFormat2 == null) {
                    kmsEnvelopeAeadKeyFormat2 = KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE;
                }
                KeyTemplate keyTemplate = kmsEnvelopeAeadKeyFormat2.dekTemplate_;
                if (keyTemplate == null) {
                    keyTemplate = KeyTemplate.DEFAULT_INSTANCE;
                }
                return new KmsEnvelopeAead(keyTemplate, aead);
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey> keyFactory() {
        return new KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>(KmsEnvelopeAeadKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                Builder builder = (Builder) KmsEnvelopeAeadKey.DEFAULT_INSTANCE.createBuilder();
                builder.copyOnWrite();
                KmsEnvelopeAeadKey.access$300((KmsEnvelopeAeadKey) builder.instance, (KmsEnvelopeAeadKeyFormat) messageLite);
                if (KmsEnvelopeAeadKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((KmsEnvelopeAeadKey) builder.instance).version_ = 0;
                    return (KmsEnvelopeAeadKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = (KmsEnvelopeAeadKeyFormat) messageLite;
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.REMOTE;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(KmsEnvelopeAeadKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        Validators.validateVersion(((KmsEnvelopeAeadKey) messageLite).version_, 0);
    }
}
