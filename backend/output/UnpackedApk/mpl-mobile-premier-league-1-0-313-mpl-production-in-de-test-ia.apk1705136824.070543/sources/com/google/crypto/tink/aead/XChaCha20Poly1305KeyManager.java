package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.proto.XChaCha20Poly1305Key;
import com.google.crypto.tink.proto.XChaCha20Poly1305Key.Builder;
import com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import java.security.GeneralSecurityException;

public class XChaCha20Poly1305KeyManager extends KeyTypeManager<XChaCha20Poly1305Key> {
    public XChaCha20Poly1305KeyManager() {
        super(XChaCha20Poly1305Key.class, new PrimitiveFactory<Aead, XChaCha20Poly1305Key>(Aead.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                return new XChaCha20Poly1305(((XChaCha20Poly1305Key) obj).keyValue_.toByteArray());
            }
        });
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key> keyFactory() {
        return new KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key>(XChaCha20Poly1305KeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat = (XChaCha20Poly1305KeyFormat) messageLite;
                Builder builder = (Builder) XChaCha20Poly1305Key.DEFAULT_INSTANCE.createBuilder();
                if (XChaCha20Poly1305KeyManager.this != null) {
                    builder.copyOnWrite();
                    ((XChaCha20Poly1305Key) builder.instance).version_ = 0;
                    byte[] randBytes = Random.randBytes(32);
                    ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                    builder.copyOnWrite();
                    XChaCha20Poly1305Key.access$300((XChaCha20Poly1305Key) builder.instance, copyFrom);
                    return (XChaCha20Poly1305Key) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat = (XChaCha20Poly1305KeyFormat) messageLite;
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(XChaCha20Poly1305Key.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(MessageLite messageLite) throws GeneralSecurityException {
        XChaCha20Poly1305Key xChaCha20Poly1305Key = (XChaCha20Poly1305Key) messageLite;
        Validators.validateVersion(xChaCha20Poly1305Key.version_, 0);
        if (xChaCha20Poly1305Key.keyValue_.size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
