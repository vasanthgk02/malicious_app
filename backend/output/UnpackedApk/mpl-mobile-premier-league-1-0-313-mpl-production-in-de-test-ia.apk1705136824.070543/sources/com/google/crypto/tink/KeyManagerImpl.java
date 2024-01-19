package com.google.crypto.tink;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyData.Builder;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

public class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    public final KeyTypeManager<KeyProtoT> keyTypeManager;
    public final Class<PrimitiveT> primitiveClass;

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager2, Class<PrimitiveT> cls) {
        if (keyTypeManager2.factories.keySet().contains(cls) || Void.class.equals(cls)) {
            this.keyTypeManager = keyTypeManager2;
            this.primitiveClass = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{keyTypeManager2.toString(), cls.getName()}));
    }

    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            MessageLite parseKey = this.keyTypeManager.parseKey(byteString);
            if (!Void.class.equals(this.primitiveClass)) {
                this.keyTypeManager.validateKey(parseKey);
                return this.keyTypeManager.getPrimitive(parseKey, this.primitiveClass);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException(GeneratedOutlineSupport.outline35(this.keyTypeManager.clazz, GeneratedOutlineSupport.outline73("Failures parsing proto of type ")), e2);
        }
    }

    public final MessageLite newKey(ByteString byteString) throws GeneralSecurityException {
        try {
            KeyFactory keyFactory = this.keyTypeManager.keyFactory();
            MessageLite parseKeyFormat = keyFactory.parseKeyFormat(byteString);
            keyFactory.validateKeyFormat(parseKeyFormat);
            return (MessageLite) keyFactory.createKey(parseKeyFormat);
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException(GeneratedOutlineSupport.outline35(this.keyTypeManager.keyFactory().clazz, GeneratedOutlineSupport.outline73("Failures parsing proto of type ")), e2);
        }
    }

    public final KeyData newKeyData(ByteString byteString) throws GeneralSecurityException {
        try {
            KeyFactory keyFactory = this.keyTypeManager.keyFactory();
            MessageLite parseKeyFormat = keyFactory.parseKeyFormat(byteString);
            keyFactory.validateKeyFormat(parseKeyFormat);
            Builder builder = (Builder) KeyData.DEFAULT_INSTANCE.createBuilder();
            String keyType = this.keyTypeManager.getKeyType();
            builder.copyOnWrite();
            KeyData.access$100((KeyData) builder.instance, keyType);
            ByteString byteString2 = ((MessageLite) keyFactory.createKey(parseKeyFormat)).toByteString();
            builder.copyOnWrite();
            KeyData.access$400((KeyData) builder.instance, byteString2);
            KeyMaterialType keyMaterialType = this.keyTypeManager.keyMaterialType();
            builder.copyOnWrite();
            KeyData.access$700((KeyData) builder.instance, keyMaterialType);
            return (KeyData) builder.build();
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }
}
