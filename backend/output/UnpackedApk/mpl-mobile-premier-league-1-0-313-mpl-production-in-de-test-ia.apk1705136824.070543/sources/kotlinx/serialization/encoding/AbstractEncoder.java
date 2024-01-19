package kotlinx.serialization.encoding;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.StreamingJsonEncoder;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0015J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0016\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016J\u001e\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020#H\u0016J\u001e\u0010$\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020#J\b\u0010%\u001a\u00020\bH\u0016J?\u0010&\u001a\u00020\b\"\b\b\u0000\u0010'*\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\b\u0010\t\u001a\u0004\u0018\u0001H'H\u0016¢\u0006\u0002\u0010+J9\u0010,\u001a\u00020\b\"\u0004\b\u0000\u0010'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*2\u0006\u0010\t\u001a\u0002H'H\u0016¢\u0006\u0002\u0010+J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020.H\u0016J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020.J\u0010\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u000201H\u0016J\u001e\u00102\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u000201J\u0010\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u00065"}, d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInline", "inlineDescriptor", "encodeInlineElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeValue", "endStructure", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AbstractEncoder.kt */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return beginStructure(serialDescriptor);
    }

    public abstract void encodeBoolean(boolean z);

    public final void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeBoolean(z);
    }

    public abstract void encodeByte(byte b2);

    public final void encodeByteElement(SerialDescriptor serialDescriptor, int i, byte b2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeByte(b2);
    }

    public final void encodeCharElement(SerialDescriptor serialDescriptor, int i, char c2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        ((StreamingJsonEncoder) this).encodeString(String.valueOf(c2));
    }

    public abstract void encodeDouble(double d2);

    public final void encodeDoubleElement(SerialDescriptor serialDescriptor, int i, double d2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeDouble(d2);
    }

    public abstract boolean encodeElement(SerialDescriptor serialDescriptor, int i);

    public abstract void encodeFloat(float f2);

    public final void encodeFloatElement(SerialDescriptor serialDescriptor, int i, float f2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeFloat(f2);
    }

    public abstract void encodeInt(int i);

    public final void encodeIntElement(SerialDescriptor serialDescriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeInt(i2);
    }

    public abstract void encodeLong(long j);

    public final void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeLong(j);
    }

    public void encodeNotNullMark() {
        Intrinsics.checkNotNullParameter(this, "this");
    }

    public <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        encodeElement(serialDescriptor, i);
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (serializationStrategy.getDescriptor().isNullable()) {
            encodeSerializableValue(serializationStrategy, t);
        } else if (t == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(serializationStrategy, t);
        }
    }

    public <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        encodeElement(serialDescriptor, i);
        encodeSerializableValue(serializationStrategy, t);
    }

    public abstract <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t);

    public abstract void encodeShort(short s);

    public final void encodeShortElement(SerialDescriptor serialDescriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        encodeElement(serialDescriptor, i);
        encodeShort(s);
    }

    public abstract void encodeString(String str);

    public final void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        encodeElement(serialDescriptor, i);
        encodeString(str);
    }
}
