package com.google.crypto.tink;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.crypto.tink.integration.android.SharedPrefKeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class KeysetHandle {
    public final Keyset keyset;

    public KeysetHandle(Keyset keyset2) {
        this.keyset = keyset2;
    }

    public static final KeysetHandle fromKeyset(Keyset keyset2) throws GeneralSecurityException {
        if (keyset2 != null && keyset2.key_.size() > 0) {
            return new KeysetHandle(keyset2);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static final KeysetHandle read(SharedPrefKeysetReader sharedPrefKeysetReader, Aead aead) throws GeneralSecurityException, IOException {
        EncryptedKeyset encryptedKeyset = (EncryptedKeyset) GeneratedMessageLite.parseFrom(EncryptedKeyset.DEFAULT_INSTANCE, sharedPrefKeysetReader.readPref(), ExtensionRegistryLite.getEmptyRegistry());
        if (encryptedKeyset.encryptedKeyset_.size() != 0) {
            try {
                Keyset parseFrom = Keyset.parseFrom(aead.decrypt(encryptedKeyset.encryptedKeyset_.toByteArray(), new byte[0]), ExtensionRegistryLite.getEmptyRegistry());
                if (parseFrom.key_.size() > 0) {
                    return new KeysetHandle(parseFrom);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (InvalidProtocolBufferException unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } else {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class cls2;
        PrimitiveWrapper primitiveWrapper = (PrimitiveWrapper) Registry.primitiveWrapperMap.get(cls);
        if (primitiveWrapper == null) {
            cls2 = null;
        } else {
            cls2 = primitiveWrapper.getInputPrimitiveClass();
        }
        if (cls2 != null) {
            PrimitiveSet primitives = Registry.getPrimitives(this, cls2);
            PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) Registry.primitiveWrapperMap.get(cls);
            if (primitiveWrapper2 == null) {
                throw new GeneralSecurityException(GeneratedOutlineSupport.outline35(primitives.primitiveClass, GeneratedOutlineSupport.outline73("No wrapper found for ")));
            } else if (primitiveWrapper2.getInputPrimitiveClass().equals(primitives.primitiveClass)) {
                return primitiveWrapper2.wrap(primitives);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Wrong input primitive class, expected ");
                outline73.append(primitiveWrapper2.getInputPrimitiveClass());
                outline73.append(", got ");
                outline73.append(primitives.primitiveClass);
                throw new GeneralSecurityException(outline73.toString());
            }
        } else {
            throw new GeneralSecurityException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("No wrapper found for ")));
        }
    }

    public String toString() {
        return Util.getKeysetInfo(this.keyset).toString();
    }
}
