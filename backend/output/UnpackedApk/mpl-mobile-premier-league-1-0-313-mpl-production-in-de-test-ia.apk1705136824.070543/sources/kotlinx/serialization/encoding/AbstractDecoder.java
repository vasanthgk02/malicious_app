package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0016\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\"\u001a\u00020\bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016JA\u0010%\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H&0)2\b\u0010*\u001a\u0004\u0018\u0001H&¢\u0006\u0002\u0010+J9\u0010,\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)2\b\u0010*\u001a\u0004\u0018\u0001H&¢\u0006\u0002\u0010+J-\u0010-\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)2\n\b\u0002\u0010*\u001a\u0004\u0018\u0001H&H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u000200H\u0016J\u0016\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u00102\u001a\u000203H\u0016J\u0016\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u00105\u001a\u00020'H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u00068"}, d2 = {"Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInline", "inlineDescriptor", "decodeInlineElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeValue", "endStructure", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AbstractDecoder.kt */
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public boolean decodeBoolean() {
        decodeValue();
        throw null;
    }

    public final boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeBoolean();
    }

    public abstract byte decodeByte();

    public final byte decodeByteElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeByte();
    }

    public char decodeChar() {
        decodeValue();
        throw null;
    }

    public final char decodeCharElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeChar();
    }

    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return -1;
    }

    public double decodeDouble() {
        decodeValue();
        throw null;
    }

    public final double decodeDoubleElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeDouble();
    }

    public int decodeEnum(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        decodeValue();
        throw null;
    }

    public float decodeFloat() {
        decodeValue();
        throw null;
    }

    public final float decodeFloatElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeFloat();
    }

    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return this;
    }

    public abstract int decodeInt();

    public final int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeInt();
    }

    public abstract long decodeLong();

    public final long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeLong();
    }

    public boolean decodeNotNullMark() {
        return true;
    }

    public Void decodeNull() {
        return null;
    }

    public final <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        if (!deserializationStrategy.getDescriptor().isNullable() && !decodeNotNullMark()) {
            return decodeNull();
        }
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return decodeSerializableValue(deserializationStrategy);
    }

    public boolean decodeSequentially() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }

    public final <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return decodeSerializableValue(deserializationStrategy);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return deserializationStrategy.deserialize(this);
    }

    public abstract short decodeShort();

    public final short decodeShortElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeShort();
    }

    public String decodeString() {
        decodeValue();
        throw null;
    }

    public final String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return decodeString();
    }

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }
}
