package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key.Builder;
import com.google.crypto.tink.proto.ChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

public class ChaCha20Poly1305KeyManager extends KeyTypeManager<ChaCha20Poly1305Key> {
    public ChaCha20Poly1305KeyManager() {
        super(ChaCha20Poly1305Key.class, new PrimitiveFactory<Aead, ChaCha20Poly1305Key>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                return new ChaCha20Poly1305(((ChaCha20Poly1305Key) obj).keyValue_.toByteArray());
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key> keyFactory() {
        return new KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key>(ChaCha20Poly1305KeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat = (ChaCha20Poly1305KeyFormat) messageLite;
                Builder builder = (Builder) ChaCha20Poly1305Key.DEFAULT_INSTANCE.createBuilder();
                if (ChaCha20Poly1305KeyManager.this != null) {
                    builder.copyOnWrite();
                    ((ChaCha20Poly1305Key) builder.instance).version_ = 0;
                    byte[] randBytes = Random.randBytes(32);
                    ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                    builder.copyOnWrite();
                    ChaCha20Poly1305Key.access$300((ChaCha20Poly1305Key) builder.instance, copyFrom);
                    return (ChaCha20Poly1305Key) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat = (ChaCha20Poly1305KeyFormat) messageLite;
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(ChaCha20Poly1305Key.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        ChaCha20Poly1305Key chaCha20Poly1305Key = (ChaCha20Poly1305Key) messageLite;
        Validators.validateVersion(chaCha20Poly1305Key.version_, 0);
        if (chaCha20Poly1305Key.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
