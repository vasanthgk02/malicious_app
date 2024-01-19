package co.hyperverge.crashguard.data.network;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/network/SentryResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/network/SentryResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SentryResponse.kt */
public final class SentryResponse$$serializer implements GeneratedSerializer<SentryResponse> {
    public static final SentryResponse$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        SentryResponse$$serializer sentryResponse$$serializer = new SentryResponse$$serializer();
        INSTANCE = sentryResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.network.SentryResponse", sentryResponse$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{TypeUtilsKt.getNullable(StringSerializer.INSTANCE)};
    }

    public SentryResponse deserialize(Decoder decoder) {
        Object obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i = 1;
        Object obj2 = null;
        if (beginStructure.decodeSequentially()) {
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
        } else {
            int i2 = 0;
            while (i != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    i = 0;
                } else if (decodeElementIndex == 0) {
                    obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, obj2);
                    i2 |= 1;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            obj = obj2;
        }
        beginStructure.endStructure(descriptor2);
        return new SentryResponse(i, (String) obj);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, SentryResponse sentryResponse) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(sentryResponse, HSLCriteriaBuilder.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Intrinsics.checkNotNullParameter(sentryResponse, "self");
        Intrinsics.checkNotNullParameter(beginStructure, "output");
        Intrinsics.checkNotNullParameter(descriptor2, "serialDesc");
        boolean z = true;
        if (!beginStructure.shouldEncodeElementDefault(descriptor2, 0) && sentryResponse.id == null) {
            z = false;
        }
        if (z) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, sentryResponse.id);
        }
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
