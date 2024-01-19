package com.google.crypto.tink;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    public final Class<KeyProtoT> clazz;
    public final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    public final Class<?> firstPrimitiveClass;

    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT> {
        public final Class<KeyFormatProtoT> clazz;

        public KeyFactory(Class<KeyFormatProtoT> cls) {
            this.clazz = cls;
        }

        public abstract KeyT createKey(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void validateKeyFormat(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
    }

    public static abstract class PrimitiveFactory<PrimitiveT, KeyT> {
        public final Class<PrimitiveT> clazz;

        public PrimitiveFactory(Class<PrimitiveT> cls) {
            this.clazz = cls;
        }

        public abstract PrimitiveT getPrimitive(KeyT keyt) throws GeneralSecurityException;
    }

    @SafeVarargs
    public KeyTypeManager(Class<KeyProtoT> cls, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        this.clazz = cls;
        HashMap hashMap = new HashMap();
        int length = primitiveFactoryArr.length;
        int i = 0;
        while (i < length) {
            PrimitiveFactory<?, KeyProtoT> primitiveFactory = primitiveFactoryArr[i];
            if (!hashMap.containsKey(primitiveFactory.clazz)) {
                hashMap.put(primitiveFactory.clazz, primitiveFactory);
                i++;
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("KeyTypeManager constructed with duplicate factories for primitive ");
                outline73.append(primitiveFactory.clazz.getCanonicalName());
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        if (primitiveFactoryArr.length > 0) {
            this.firstPrimitiveClass = primitiveFactoryArr[0].clazz;
        } else {
            this.firstPrimitiveClass = Void.class;
        }
        this.factories = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        PrimitiveFactory primitiveFactory = this.factories.get(cls);
        if (primitiveFactory != null) {
            return primitiveFactory.getPrimitive(keyprotot);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Requested primitive class ");
        outline73.append(cls.getCanonicalName());
        outline73.append(" not supported.");
        throw new IllegalArgumentException(outline73.toString());
    }

    public abstract KeyFactory<?, KeyProtoT> keyFactory();

    public abstract KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString) throws InvalidProtocolBufferException;

    public abstract void validateKey(KeyProtoT keyprotot) throws GeneralSecurityException;
}
