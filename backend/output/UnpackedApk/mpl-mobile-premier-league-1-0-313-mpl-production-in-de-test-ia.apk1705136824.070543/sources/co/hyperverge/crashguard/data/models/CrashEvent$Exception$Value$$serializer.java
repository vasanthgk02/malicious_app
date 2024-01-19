package co.hyperverge.crashguard.data.models;

import co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value;
import co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value.StackTrace;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/models/CrashEvent.Exception.Value.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEvent.kt */
public final class CrashEvent$Exception$Value$$serializer implements GeneratedSerializer<Value> {
    public static final CrashEvent$Exception$Value$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CrashEvent$Exception$Value$$serializer crashEvent$Exception$Value$$serializer = new CrashEvent$Exception$Value$$serializer();
        INSTANCE = crashEvent$Exception$Value$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value", crashEvent$Exception$Value$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement(HSLCriteriaBuilder.VALUE, true);
        pluginGeneratedSerialDescriptor.addElement("module", true);
        pluginGeneratedSerialDescriptor.addElement("stacktrace", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE)};
    }

    public Value deserialize(Decoder decoder) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE, null);
            obj = decodeNullableSerializableElement;
            i = 15;
        } else {
            obj4 = null;
            obj = null;
            Object obj5 = null;
            Object obj6 = null;
            int i2 = 0;
            boolean z = true;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, obj4);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj5);
                    i2 |= 4;
                } else if (decodeElementIndex == 3) {
                    obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE, obj6);
                    i2 |= 8;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            obj2 = obj5;
            obj3 = obj6;
        }
        beginStructure.endStructure(descriptor2);
        Value value = new Value(i, (String) obj4, (String) obj, (String) obj2, (StackTrace) obj3);
        return value;
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Value value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, HSLCriteriaBuilder.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Intrinsics.checkNotNullParameter(value, "self");
        Intrinsics.checkNotNullParameter(beginStructure, "output");
        Intrinsics.checkNotNullParameter(descriptor2, "serialDesc");
        boolean z = false;
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 0) || value.type != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, value.type);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 1) || value.value != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, value.value);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 2) || value.module != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, value.module);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 3) || value.stacktrace != null) {
            z = true;
        }
        if (z) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 3, CrashEvent$Exception$Value$StackTrace$$serializer.INSTANCE, value.stacktrace);
        }
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
