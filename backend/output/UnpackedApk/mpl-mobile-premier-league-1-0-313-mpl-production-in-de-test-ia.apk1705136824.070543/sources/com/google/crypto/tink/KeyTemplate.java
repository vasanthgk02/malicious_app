package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyTemplate.Builder;
import com.google.crypto.tink.shaded.protobuf.ByteString;

public final class KeyTemplate {
    public final com.google.crypto.tink.proto.KeyTemplate kt;

    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    public KeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        this.kt = keyTemplate;
    }

    public static KeyTemplate create(String str, byte[] bArr, OutputPrefixType outputPrefixType) {
        com.google.crypto.tink.proto.OutputPrefixType outputPrefixType2;
        Builder builder = (Builder) com.google.crypto.tink.proto.KeyTemplate.DEFAULT_INSTANCE.createBuilder();
        builder.copyOnWrite();
        com.google.crypto.tink.proto.KeyTemplate keyTemplate = (com.google.crypto.tink.proto.KeyTemplate) builder.instance;
        if (keyTemplate != null) {
            str.getClass();
            keyTemplate.typeUrl_ = str;
            ByteString copyFrom = ByteString.copyFrom(bArr, 0, bArr.length);
            builder.copyOnWrite();
            com.google.crypto.tink.proto.KeyTemplate keyTemplate2 = (com.google.crypto.tink.proto.KeyTemplate) builder.instance;
            if (keyTemplate2 != null) {
                copyFrom.getClass();
                keyTemplate2.value_ = copyFrom;
                int ordinal = outputPrefixType.ordinal();
                if (ordinal == 0) {
                    outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.TINK;
                } else if (ordinal == 1) {
                    outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
                } else if (ordinal == 2) {
                    outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.RAW;
                } else if (ordinal == 3) {
                    outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
                } else {
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                builder.copyOnWrite();
                com.google.crypto.tink.proto.KeyTemplate.access$700((com.google.crypto.tink.proto.KeyTemplate) builder.instance, outputPrefixType2);
                return new KeyTemplate((com.google.crypto.tink.proto.KeyTemplate) builder.build());
            }
            throw null;
        }
        throw null;
    }
}
