package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: FlexibleTypeDeserializer.kt */
public interface FlexibleTypeDeserializer {

    /* compiled from: FlexibleTypeDeserializer.kt */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = new ThrowException();

        public KotlinType create(ProtoBuf$Type protoBuf$Type, String str, SimpleType simpleType, SimpleType simpleType2) {
            Intrinsics.checkNotNullParameter(protoBuf$Type, "proto");
            Intrinsics.checkNotNullParameter(str, "flexibleId");
            Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
            Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf$Type protoBuf$Type, String str, SimpleType simpleType, SimpleType simpleType2);
}
