package co.hyperverge.crashguard.data.models;

import co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value.StackTrace.Frame;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/models/CrashEvent.Exception.Value.StackTrace.Frame.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Exception$Value$StackTrace$Frame;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEvent.kt */
public final class CrashEvent$Exception$Value$StackTrace$Frame$$serializer implements GeneratedSerializer<Frame> {
    public static final CrashEvent$Exception$Value$StackTrace$Frame$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CrashEvent$Exception$Value$StackTrace$Frame$$serializer crashEvent$Exception$Value$StackTrace$Frame$$serializer = new CrashEvent$Exception$Value$StackTrace$Frame$$serializer();
        INSTANCE = crashEvent$Exception$Value$StackTrace$Frame$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.models.CrashEvent.Exception.Value.StackTrace.Frame", crashEvent$Exception$Value$StackTrace$Frame$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("function", false);
        pluginGeneratedSerialDescriptor.addElement("module", true);
        pluginGeneratedSerialDescriptor.addElement("lineno", true);
        pluginGeneratedSerialDescriptor.addElement("filename", true);
        pluginGeneratedSerialDescriptor.addElement("abs_path", true);
        pluginGeneratedSerialDescriptor.addElement("in_app", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, TypeUtilsKt.getNullable(stringSerializer), TypeUtilsKt.getNullable(IntSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    public Frame deserialize(Decoder decoder) {
        String str;
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Decoder decoder2 = decoder;
        Intrinsics.checkNotNullParameter(decoder2, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder2.beginStructure(descriptor2);
        String str2 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            str = decodeStringElement;
            i = 63;
        } else {
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            int i2 = 0;
            boolean z = true;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str2 = beginStructure.decodeStringElement(descriptor2, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj6);
                        i2 |= 2;
                        break;
                    case 2:
                        obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, obj7);
                        i2 |= 4;
                        break;
                    case 3:
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, obj8);
                        i2 |= 8;
                        break;
                    case 4:
                        obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, obj9);
                        i2 |= 16;
                        break;
                    case 5:
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, obj10);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj = obj6;
            obj2 = obj7;
            obj4 = obj8;
            obj3 = obj9;
            obj5 = obj10;
            str = str2;
            i = i2;
        }
        beginStructure.endStructure(descriptor2);
        Frame frame = new Frame(i, str, (String) obj, (Integer) obj2, (String) obj4, (String) obj3, (Boolean) obj5);
        return frame;
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Frame frame) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(frame, HSLCriteriaBuilder.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Intrinsics.checkNotNullParameter(frame, "self");
        Intrinsics.checkNotNullParameter(beginStructure, "output");
        Intrinsics.checkNotNullParameter(descriptor2, "serialDesc");
        boolean z = false;
        beginStructure.encodeStringElement(descriptor2, 0, frame.function);
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 1) || frame.module != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, frame.module);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 2) || frame.lineNo != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, frame.lineNo);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 3) || frame.filename != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, frame.filename);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 4) || frame.absPath != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, frame.absPath);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 5) || frame.inApp != null) {
            z = true;
        }
        if (z) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, frame.inApp);
        }
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
