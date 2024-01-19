package kotlinx.serialization.internal;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\tJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", "composite", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Tuples.kt */
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {
    public final KSerializer<A> aSerializer;
    public final KSerializer<B> bSerializer;
    public final KSerializer<C> cSerializer;
    public final SerialDescriptor descriptor = TypeUtilsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], new TripleSerializer$descriptor$1(this));

    public TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        Intrinsics.checkNotNullParameter(kSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "bSerializer");
        Intrinsics.checkNotNullParameter(kSerializer3, "cSerializer");
        this.aSerializer = kSerializer;
        this.bSerializer = kSerializer2;
        this.cSerializer = kSerializer3;
    }

    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder beginStructure = decoder.beginStructure(this.descriptor);
        if (beginStructure.decodeSequentially()) {
            CompositeDecoder compositeDecoder = beginStructure;
            Object decodeSerializableElement$default = TypeUtilsKt.decodeSerializableElement$default(compositeDecoder, this.descriptor, 0, this.aSerializer, null, 8, null);
            Object decodeSerializableElement$default2 = TypeUtilsKt.decodeSerializableElement$default(compositeDecoder, this.descriptor, 1, this.bSerializer, null, 8, null);
            Object decodeSerializableElement$default3 = TypeUtilsKt.decodeSerializableElement$default(compositeDecoder, this.descriptor, 2, this.cSerializer, null, 8, null);
            beginStructure.endStructure(this.descriptor);
            return new Triple(decodeSerializableElement$default, decodeSerializableElement$default2, decodeSerializableElement$default3);
        }
        Object obj = TuplesKt.NULL;
        Object obj2 = obj;
        Object obj3 = obj2;
        while (true) {
            int decodeElementIndex = beginStructure.decodeElementIndex(this.descriptor);
            if (decodeElementIndex == -1) {
                beginStructure.endStructure(this.descriptor);
                Object obj4 = TuplesKt.NULL;
                if (obj == obj4) {
                    throw new SerializationException("Element 'first' is missing");
                } else if (obj2 == obj4) {
                    throw new SerializationException("Element 'second' is missing");
                } else if (obj3 != obj4) {
                    return new Triple(obj, obj2, obj3);
                } else {
                    throw new SerializationException("Element 'third' is missing");
                }
            } else if (decodeElementIndex == 0) {
                obj = TypeUtilsKt.decodeSerializableElement$default(beginStructure, this.descriptor, 0, this.aSerializer, null, 8, null);
            } else if (decodeElementIndex == 1) {
                obj2 = TypeUtilsKt.decodeSerializableElement$default(beginStructure, this.descriptor, 1, this.bSerializer, null, 8, null);
            } else if (decodeElementIndex == 2) {
                obj3 = TypeUtilsKt.decodeSerializableElement$default(beginStructure, this.descriptor, 2, this.cSerializer, null, 8, null);
            } else {
                throw new SerializationException(Intrinsics.stringPlus("Unexpected index ", Integer.valueOf(decodeElementIndex)));
            }
        }
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, Object obj) {
        Triple triple = (Triple) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(triple, HSLCriteriaBuilder.VALUE);
        CompositeEncoder beginStructure = encoder.beginStructure(this.descriptor);
        beginStructure.encodeSerializableElement(this.descriptor, 0, this.aSerializer, triple.first);
        beginStructure.encodeSerializableElement(this.descriptor, 1, this.bSerializer, triple.second);
        beginStructure.encodeSerializableElement(this.descriptor, 2, this.cSerializer, triple.third);
        beginStructure.endStructure(this.descriptor);
    }
}
