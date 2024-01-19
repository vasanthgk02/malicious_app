package co.hyperverge.crashguard.data.models;

import co.hyperverge.crashguard.data.models.CrashEvent.Contexts;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.App;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.OS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/models/CrashEvent.Contexts.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEvent.kt */
public final class CrashEvent$Contexts$$serializer implements GeneratedSerializer<Contexts> {
    public static final CrashEvent$Contexts$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CrashEvent$Contexts$$serializer crashEvent$Contexts$$serializer = new CrashEvent$Contexts$$serializer();
        INSTANCE = crashEvent$Contexts$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.models.CrashEvent.Contexts", crashEvent$Contexts$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("app", true);
        pluginGeneratedSerialDescriptor.addElement("device", true);
        pluginGeneratedSerialDescriptor.addElement("os", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CrashEvent$Contexts$App$$serializer.INSTANCE, CrashEvent$Contexts$Device$$serializer.INSTANCE, CrashEvent$Contexts$OS$$serializer.INSTANCE};
    }

    public Contexts deserialize(Decoder decoder) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Object obj4 = null;
        if (beginStructure.decodeSequentially()) {
            obj3 = beginStructure.decodeSerializableElement(descriptor2, 0, CrashEvent$Contexts$App$$serializer.INSTANCE, null);
            obj = beginStructure.decodeSerializableElement(descriptor2, 1, CrashEvent$Contexts$Device$$serializer.INSTANCE, null);
            obj2 = beginStructure.decodeSerializableElement(descriptor2, 2, CrashEvent$Contexts$OS$$serializer.INSTANCE, null);
            i = 7;
        } else {
            Object obj5 = null;
            Object obj6 = null;
            int i2 = 0;
            boolean z = true;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    obj4 = beginStructure.decodeSerializableElement(descriptor2, 0, CrashEvent$Contexts$App$$serializer.INSTANCE, obj4);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    obj5 = beginStructure.decodeSerializableElement(descriptor2, 1, CrashEvent$Contexts$Device$$serializer.INSTANCE, obj5);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    obj6 = beginStructure.decodeSerializableElement(descriptor2, 2, CrashEvent$Contexts$OS$$serializer.INSTANCE, obj6);
                    i2 |= 4;
                } else {
                    throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj = obj5;
            obj3 = obj4;
            obj2 = obj6;
            i = i2;
        }
        beginStructure.endStructure(descriptor2);
        return new Contexts(i, (App) obj3, (Device) obj, (OS) obj2);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serialize(kotlinx.serialization.encoding.Encoder r39, co.hyperverge.crashguard.data.models.CrashEvent.Contexts r40) {
        /*
            r38 = this;
            r0 = r39
            r1 = r40
            java.lang.String r2 = "encoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r38.getDescriptor()
            kotlinx.serialization.encoding.CompositeEncoder r0 = r0.beginStructure(r2)
            java.lang.String r3 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = 0
            boolean r4 = r0.shouldEncodeElementDefault(r2, r3)
            r5 = 1
            if (r4 == 0) goto L_0x002e
            goto L_0x0044
        L_0x002e:
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App r4 = r1.app
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App r14 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r14)
            if (r4 != 0) goto L_0x0046
        L_0x0044:
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x0050
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App$$serializer r4 = co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App$$serializer.INSTANCE
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$App r6 = r1.app
            r0.encodeSerializableElement(r2, r3, r4, r6)
        L_0x0050:
            boolean r4 = r0.shouldEncodeElementDefault(r2, r5)
            if (r4 == 0) goto L_0x0057
            goto L_0x009d
        L_0x0057:
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r4 = r1.device
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r15 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device
            r6 = r15
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r3 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 1073741823(0x3fffffff, float:1.9999999)
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            if (r3 != 0) goto L_0x009f
        L_0x009d:
            r3 = 1
            goto L_0x00a0
        L_0x009f:
            r3 = 0
        L_0x00a0:
            if (r3 == 0) goto L_0x00a9
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device$$serializer r3 = co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device$$serializer.INSTANCE
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r4 = r1.device
            r0.encodeSerializableElement(r2, r5, r3, r4)
        L_0x00a9:
            r3 = 2
            boolean r4 = r0.shouldEncodeElementDefault(r2, r3)
            if (r4 == 0) goto L_0x00b1
            goto L_0x00c9
        L_0x00b1:
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS r4 = r1.os
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS r14 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r14)
            if (r4 != 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            if (r5 == 0) goto L_0x00d2
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS$$serializer r4 = co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS$$serializer.INSTANCE
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$OS r1 = r1.os
            r0.encodeSerializableElement(r2, r3, r4, r1)
        L_0x00d2:
            r0.endStructure(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.data.models.CrashEvent$Contexts$$serializer.serialize(kotlinx.serialization.encoding.Encoder, co.hyperverge.crashguard.data.models.CrashEvent$Contexts):void");
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
