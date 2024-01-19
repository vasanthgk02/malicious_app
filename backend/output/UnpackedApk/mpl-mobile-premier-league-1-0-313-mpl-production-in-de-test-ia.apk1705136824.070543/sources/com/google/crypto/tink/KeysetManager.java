package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.Keyset.Builder;
import com.google.crypto.tink.proto.Keyset.Key;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collections;
import org.apache.fontbox.ttf.GlyfDescript;

public final class KeysetManager {
    public final Builder keysetBuilder;

    public KeysetManager(Builder builder) {
        this.keysetBuilder = builder;
    }

    public static int randPositiveInt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b2 = 0;
        while (b2 == 0) {
            secureRandom.nextBytes(bArr);
            b2 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << GlyfDescript.X_DUAL) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b2;
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        Keyset keyset = keysetHandle.keyset;
        if (keyset != null) {
            GeneratedMessageLite.Builder builder = (GeneratedMessageLite.Builder) keyset.dynamicMethod(MethodToInvoke.NEW_BUILDER);
            builder.copyOnWrite();
            builder.mergeFromInstance(builder.instance, keyset);
            return new KeysetManager((Builder) builder);
        }
        throw null;
    }

    @Deprecated
    public synchronized int addNewKey(KeyTemplate keyTemplate, boolean z) throws GeneralSecurityException {
        Key newKey;
        newKey = newKey(keyTemplate);
        Builder builder = this.keysetBuilder;
        builder.copyOnWrite();
        Keyset.access$1700((Keyset) builder.instance, newKey);
        if (z) {
            Builder builder2 = this.keysetBuilder;
            int i = newKey.keyId_;
            builder2.copyOnWrite();
            ((Keyset) builder2.instance).primaryKeyId_ = i;
        }
        return newKey.keyId_;
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        try {
        }
        return KeysetHandle.fromKeyset((Keyset) this.keysetBuilder.build());
    }

    public final synchronized boolean keyIdExists(int i) {
        for (Key key : Collections.unmodifiableList(((Keyset) this.keysetBuilder.instance).key_)) {
            if (key.keyId_ == i) {
                return true;
            }
        }
        return false;
    }

    public final synchronized Key newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        int randPositiveInt;
        newKeyData = Registry.newKeyData(keyTemplate);
        synchronized (this) {
            randPositiveInt = randPositiveInt();
            while (keyIdExists(randPositiveInt)) {
                randPositiveInt = randPositiveInt();
            }
        }
        OutputPrefixType forNumber = OutputPrefixType.forNumber(keyTemplate.outputPrefixType_);
        if (forNumber == null) {
            forNumber = OutputPrefixType.UNRECOGNIZED;
        }
        if (forNumber == OutputPrefixType.UNKNOWN_PREFIX) {
            forNumber = OutputPrefixType.TINK;
        }
        Key.Builder builder = (Key.Builder) Key.DEFAULT_INSTANCE.createBuilder();
        builder.copyOnWrite();
        Key.access$100((Key) builder.instance, newKeyData);
        builder.copyOnWrite();
        ((Key) builder.instance).keyId_ = randPositiveInt;
        KeyStatusType keyStatusType = KeyStatusType.ENABLED;
        builder.copyOnWrite();
        Key.access$500((Key) builder.instance, keyStatusType);
        builder.copyOnWrite();
        Key.access$1000((Key) builder.instance, forNumber);
        Key key = (Key) builder.build();
        return key;
    }
}
