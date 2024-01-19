package co.hyperverge.crashguard.data.models;

import co.hyperverge.crashguard.data.models.CrashEvent.Contexts;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.App;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device;
import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.OS;
import co.hyperverge.crashguard.data.models.CrashEvent.User;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.sentry.SentryBaseEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.eclipse.paho.android.service.MqttServiceConstants;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/models/CrashEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEvent.kt */
public final class CrashEvent$$serializer implements GeneratedSerializer<CrashEvent> {
    public static final CrashEvent$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CrashEvent$$serializer crashEvent$$serializer = new CrashEvent$$serializer();
        INSTANCE = crashEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.models.CrashEvent", crashEvent$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("culprit", true);
        pluginGeneratedSerialDescriptor.addElement("platform", true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        pluginGeneratedSerialDescriptor.addElement("message", true);
        pluginGeneratedSerialDescriptor.addElement("contexts", true);
        pluginGeneratedSerialDescriptor.addElement(MqttServiceConstants.TRACE_EXCEPTION, true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement(Action.USER, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(DoubleSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), CrashEvent$Contexts$$serializer.INSTANCE, TypeUtilsKt.getNullable(CrashEvent$Exception$$serializer.INSTANCE), new HashMapSerializer(stringSerializer, stringSerializer), CrashEvent$User$$serializer.INSTANCE};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009a, code lost:
        r3 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ca, code lost:
        r3 = 7;
        r4 = 6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public co.hyperverge.crashguard.data.models.CrashEvent deserialize(kotlinx.serialization.encoding.Decoder r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r21.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 7
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 4
            r8 = 2
            r9 = 0
            r10 = 1
            r11 = 0
            if (r2 == 0) goto L_0x0059
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r9, r2, r11)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r10, r9, r11)
            kotlinx.serialization.internal.DoubleSerializer r10 = kotlinx.serialization.internal.DoubleSerializer.INSTANCE
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r10, r11)
            kotlinx.serialization.internal.StringSerializer r10 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r10, r11)
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$$serializer r10 = co.hyperverge.crashguard.data.models.CrashEvent$Contexts$$serializer.INSTANCE
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r7, r10, r11)
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$$serializer r10 = co.hyperverge.crashguard.data.models.CrashEvent$Exception$$serializer.INSTANCE
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r10, r11)
            kotlinx.serialization.internal.HashMapSerializer r10 = new kotlinx.serialization.internal.HashMapSerializer
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r10.<init>(r12, r12)
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r4, r10, r11)
            co.hyperverge.crashguard.data.models.CrashEvent$User$$serializer r10 = co.hyperverge.crashguard.data.models.CrashEvent$User$$serializer.INSTANCE
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r3, r10, r11)
            r10 = 255(0xff, float:3.57E-43)
            r11 = 255(0xff, float:3.57E-43)
            goto L_0x00df
        L_0x0059:
            r8 = r11
            r9 = r8
            r10 = r9
            r12 = r10
            r13 = r12
            r14 = r13
            r15 = r14
            r2 = 0
            r18 = 1
        L_0x0063:
            if (r18 == 0) goto L_0x00d3
            int r6 = r0.decodeElementIndex(r1)
            switch(r6) {
                case -1: goto L_0x00cd;
                case 0: goto L_0x00bf;
                case 1: goto L_0x00b3;
                case 2: goto L_0x00a8;
                case 3: goto L_0x009d;
                case 4: goto L_0x0092;
                case 5: goto L_0x0089;
                case 6: goto L_0x007b;
                case 7: goto L_0x0072;
                default: goto L_0x006c;
            }
        L_0x006c:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>(r6)
            throw r0
        L_0x0072:
            co.hyperverge.crashguard.data.models.CrashEvent$User$$serializer r6 = co.hyperverge.crashguard.data.models.CrashEvent$User$$serializer.INSTANCE
            java.lang.Object r8 = r0.decodeSerializableElement(r1, r3, r6, r8)
            r2 = r2 | 128(0x80, float:1.8E-43)
            goto L_0x009b
        L_0x007b:
            kotlinx.serialization.internal.HashMapSerializer r6 = new kotlinx.serialization.internal.HashMapSerializer
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r6.<init>(r3, r3)
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r4, r6, r10)
            r2 = r2 | 64
            goto L_0x009a
        L_0x0089:
            co.hyperverge.crashguard.data.models.CrashEvent$Exception$$serializer r3 = co.hyperverge.crashguard.data.models.CrashEvent$Exception$$serializer.INSTANCE
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r5, r3, r9)
            r2 = r2 | 32
            goto L_0x009a
        L_0x0092:
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$$serializer r3 = co.hyperverge.crashguard.data.models.CrashEvent$Contexts$$serializer.INSTANCE
            java.lang.Object r15 = r0.decodeSerializableElement(r1, r7, r3, r15)
            r2 = r2 | 16
        L_0x009a:
            r3 = 7
        L_0x009b:
            r6 = 3
            goto L_0x0063
        L_0x009d:
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r6 = 3
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r6, r3, r14)
            r2 = r2 | 8
            r3 = 7
            goto L_0x0063
        L_0x00a8:
            r6 = 3
            kotlinx.serialization.internal.DoubleSerializer r3 = kotlinx.serialization.internal.DoubleSerializer.INSTANCE
            r4 = 2
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r4, r3, r13)
            r2 = r2 | 4
            goto L_0x00ca
        L_0x00b3:
            r4 = 2
            r6 = 3
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = 1
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r4, r3, r12)
            r2 = r2 | 2
            goto L_0x00ca
        L_0x00bf:
            r4 = 1
            r6 = 3
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4 = 0
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r4, r3, r11)
            r2 = r2 | 1
        L_0x00ca:
            r3 = 7
            r4 = 6
            goto L_0x0063
        L_0x00cd:
            r4 = 0
            r6 = 3
            r4 = 6
            r18 = 0
            goto L_0x0063
        L_0x00d3:
            r3 = r8
            r5 = r9
            r4 = r10
            r9 = r12
            r8 = r13
            r6 = r14
            r7 = r15
            r20 = r11
            r11 = r2
            r2 = r20
        L_0x00df:
            r0.endStructure(r1)
            co.hyperverge.crashguard.data.models.CrashEvent r0 = new co.hyperverge.crashguard.data.models.CrashEvent
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            r13 = r9
            java.lang.String r13 = (java.lang.String) r13
            r14 = r8
            java.lang.Double r14 = (java.lang.Double) r14
            r15 = r6
            java.lang.String r15 = (java.lang.String) r15
            r16 = r7
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts r16 = (co.hyperverge.crashguard.data.models.CrashEvent.Contexts) r16
            r17 = r5
            co.hyperverge.crashguard.data.models.CrashEvent$Exception r17 = (co.hyperverge.crashguard.data.models.CrashEvent.Exception) r17
            r18 = r4
            java.util.HashMap r18 = (java.util.HashMap) r18
            r19 = r3
            co.hyperverge.crashguard.data.models.CrashEvent$User r19 = (co.hyperverge.crashguard.data.models.CrashEvent.User) r19
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.data.models.CrashEvent$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):co.hyperverge.crashguard.data.models.CrashEvent");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, CrashEvent crashEvent) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(crashEvent, HSLCriteriaBuilder.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Intrinsics.checkNotNullParameter(crashEvent, "self");
        Intrinsics.checkNotNullParameter(beginStructure, "output");
        Intrinsics.checkNotNullParameter(descriptor2, "serialDesc");
        boolean z = false;
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 0) || crashEvent.culprit != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, crashEvent.culprit);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 1) || !Intrinsics.areEqual(crashEvent.platform, SentryBaseEvent.DEFAULT_PLATFORM)) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, crashEvent.platform);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 2) || crashEvent.timestamp != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 2, DoubleSerializer.INSTANCE, crashEvent.timestamp);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 3) || crashEvent.message != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, crashEvent.message);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 4) || !Intrinsics.areEqual(crashEvent.contexts, new Contexts((App) null, (Device) null, (OS) null, 7))) {
            beginStructure.encodeSerializableElement(descriptor2, 4, CrashEvent$Contexts$$serializer.INSTANCE, crashEvent.contexts);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 5) || crashEvent.exception != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 5, CrashEvent$Exception$$serializer.INSTANCE, crashEvent.exception);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 6) || !Intrinsics.areEqual(crashEvent.tags, new HashMap())) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            beginStructure.encodeSerializableElement(descriptor2, 6, new HashMapSerializer(stringSerializer, stringSerializer), crashEvent.tags);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 7) || !Intrinsics.areEqual(crashEvent.user, new User((String) null, 1))) {
            z = true;
        }
        if (z) {
            beginStructure.encodeSerializableElement(descriptor2, 7, CrashEvent$User$$serializer.INSTANCE, crashEvent.user);
        }
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
