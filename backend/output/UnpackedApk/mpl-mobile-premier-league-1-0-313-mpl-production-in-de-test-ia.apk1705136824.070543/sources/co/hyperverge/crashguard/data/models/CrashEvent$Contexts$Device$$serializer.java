package co.hyperverge.crashguard.data.models;

import co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device;
import com.xiaomi.mipush.sdk.Constants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"co/hyperverge/crashguard/data/models/CrashEvent.Contexts.Device.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lco/hyperverge/crashguard/data/models/CrashEvent$Contexts$Device;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEvent.kt */
public final class CrashEvent$Contexts$Device$$serializer implements GeneratedSerializer<Device> {
    public static final CrashEvent$Contexts$Device$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    static {
        CrashEvent$Contexts$Device$$serializer crashEvent$Contexts$Device$$serializer = new CrashEvent$Contexts$Device$$serializer();
        INSTANCE = crashEvent$Contexts$Device$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device", crashEvent$Contexts$Device$$serializer, 30);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("family", true);
        pluginGeneratedSerialDescriptor.addElement("model", true);
        pluginGeneratedSerialDescriptor.addElement("arch", true);
        pluginGeneratedSerialDescriptor.addElement("orientation", true);
        pluginGeneratedSerialDescriptor.addElement("manufacturer", true);
        pluginGeneratedSerialDescriptor.addElement(Constants.PHONE_BRAND, true);
        pluginGeneratedSerialDescriptor.addElement("online", true);
        pluginGeneratedSerialDescriptor.addElement("charging", true);
        pluginGeneratedSerialDescriptor.addElement("simulator", true);
        pluginGeneratedSerialDescriptor.addElement("timezone", true);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("language", true);
        pluginGeneratedSerialDescriptor.addElement("archs", true);
        pluginGeneratedSerialDescriptor.addElement("model_id", true);
        pluginGeneratedSerialDescriptor.addElement("battery_level", true);
        pluginGeneratedSerialDescriptor.addElement("screen_resolution", true);
        pluginGeneratedSerialDescriptor.addElement("screen_density", true);
        pluginGeneratedSerialDescriptor.addElement("screen_dpi", true);
        pluginGeneratedSerialDescriptor.addElement("low_memory", true);
        pluginGeneratedSerialDescriptor.addElement("memory_size", true);
        pluginGeneratedSerialDescriptor.addElement("free_memory", true);
        pluginGeneratedSerialDescriptor.addElement("storage_size", true);
        pluginGeneratedSerialDescriptor.addElement("free_storage", true);
        pluginGeneratedSerialDescriptor.addElement("boot_time", true);
        pluginGeneratedSerialDescriptor.addElement("battery_temperature", true);
        pluginGeneratedSerialDescriptor.addElement("connection_type", true);
        pluginGeneratedSerialDescriptor.addElement("screen_height_pixels", true);
        pluginGeneratedSerialDescriptor.addElement("screen_width_pixels", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, TypeUtilsKt.getNullable(stringSerializer), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(BooleanSerializer.INSTANCE), TypeUtilsKt.getNullable(BooleanSerializer.INSTANCE), TypeUtilsKt.getNullable(BooleanSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(FloatSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(FloatSerializer.INSTANCE), TypeUtilsKt.getNullable(IntSerializer.INSTANCE), TypeUtilsKt.getNullable(BooleanSerializer.INSTANCE), TypeUtilsKt.getNullable(LongSerializer.INSTANCE), TypeUtilsKt.getNullable(LongSerializer.INSTANCE), TypeUtilsKt.getNullable(LongSerializer.INSTANCE), TypeUtilsKt.getNullable(LongSerializer.INSTANCE), TypeUtilsKt.getNullable(new DateSerializer()), TypeUtilsKt.getNullable(FloatSerializer.INSTANCE), TypeUtilsKt.getNullable(StringSerializer.INSTANCE), TypeUtilsKt.getNullable(IntSerializer.INSTANCE), TypeUtilsKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r38v0 */
    /* JADX WARNING: type inference failed for: r39v0 */
    /* JADX WARNING: type inference failed for: r40v0 */
    /* JADX WARNING: type inference failed for: r41v0 */
    /* JADX WARNING: type inference failed for: r42v0 */
    /* JADX WARNING: type inference failed for: r44v0 */
    /* JADX WARNING: type inference failed for: r45v0 */
    /* JADX WARNING: type inference failed for: r46v0 */
    /* JADX WARNING: type inference failed for: r47v0 */
    /* JADX WARNING: type inference failed for: r48v0 */
    /* JADX WARNING: type inference failed for: r49v0 */
    /* JADX WARNING: type inference failed for: r50v0 */
    /* JADX WARNING: type inference failed for: r51v0 */
    /* JADX WARNING: type inference failed for: r52v0 */
    /* JADX WARNING: type inference failed for: r25v4 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r38v2 */
    /* JADX WARNING: type inference failed for: r25v5 */
    /* JADX WARNING: type inference failed for: r25v6 */
    /* JADX WARNING: type inference failed for: r25v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r25v8 */
    /* JADX WARNING: type inference failed for: r25v9 */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r25v10 */
    /* JADX WARNING: type inference failed for: r2v22, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r26v11 */
    /* JADX WARNING: type inference failed for: r25v11 */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r27v12 */
    /* JADX WARNING: type inference failed for: r25v12 */
    /* JADX WARNING: type inference failed for: r26v12 */
    /* JADX WARNING: type inference failed for: r2v29, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r28v13 */
    /* JADX WARNING: type inference failed for: r25v13 */
    /* JADX WARNING: type inference failed for: r26v13 */
    /* JADX WARNING: type inference failed for: r27v13 */
    /* JADX WARNING: type inference failed for: r3v23, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r29v14 */
    /* JADX WARNING: type inference failed for: r25v14 */
    /* JADX WARNING: type inference failed for: r26v14 */
    /* JADX WARNING: type inference failed for: r27v14 */
    /* JADX WARNING: type inference failed for: r28v14 */
    /* JADX WARNING: type inference failed for: r25v15 */
    /* JADX WARNING: type inference failed for: r26v15 */
    /* JADX WARNING: type inference failed for: r27v15 */
    /* JADX WARNING: type inference failed for: r28v15 */
    /* JADX WARNING: type inference failed for: r29v15 */
    /* JADX WARNING: type inference failed for: r3v28, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r31v16 */
    /* JADX WARNING: type inference failed for: r25v16 */
    /* JADX WARNING: type inference failed for: r26v16 */
    /* JADX WARNING: type inference failed for: r27v16 */
    /* JADX WARNING: type inference failed for: r28v16 */
    /* JADX WARNING: type inference failed for: r29v16 */
    /* JADX WARNING: type inference failed for: r2v43, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r32v17 */
    /* JADX WARNING: type inference failed for: r25v17 */
    /* JADX WARNING: type inference failed for: r26v17 */
    /* JADX WARNING: type inference failed for: r27v17 */
    /* JADX WARNING: type inference failed for: r28v17 */
    /* JADX WARNING: type inference failed for: r29v17 */
    /* JADX WARNING: type inference failed for: r31v17 */
    /* JADX WARNING: type inference failed for: r3v33, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r33v18 */
    /* JADX WARNING: type inference failed for: r25v18 */
    /* JADX WARNING: type inference failed for: r26v18 */
    /* JADX WARNING: type inference failed for: r27v18 */
    /* JADX WARNING: type inference failed for: r28v18 */
    /* JADX WARNING: type inference failed for: r29v18 */
    /* JADX WARNING: type inference failed for: r31v18 */
    /* JADX WARNING: type inference failed for: r32v18 */
    /* JADX WARNING: type inference failed for: r2v50, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r34v19 */
    /* JADX WARNING: type inference failed for: r25v19 */
    /* JADX WARNING: type inference failed for: r26v19 */
    /* JADX WARNING: type inference failed for: r27v19 */
    /* JADX WARNING: type inference failed for: r28v19 */
    /* JADX WARNING: type inference failed for: r29v19 */
    /* JADX WARNING: type inference failed for: r31v19 */
    /* JADX WARNING: type inference failed for: r32v19 */
    /* JADX WARNING: type inference failed for: r33v19 */
    /* JADX WARNING: type inference failed for: r3v38, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r35v20 */
    /* JADX WARNING: type inference failed for: r25v20 */
    /* JADX WARNING: type inference failed for: r26v20 */
    /* JADX WARNING: type inference failed for: r27v20 */
    /* JADX WARNING: type inference failed for: r28v20 */
    /* JADX WARNING: type inference failed for: r29v20 */
    /* JADX WARNING: type inference failed for: r31v20 */
    /* JADX WARNING: type inference failed for: r32v20 */
    /* JADX WARNING: type inference failed for: r33v20 */
    /* JADX WARNING: type inference failed for: r34v20 */
    /* JADX WARNING: type inference failed for: r2v57, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r23v20 */
    /* JADX WARNING: type inference failed for: r25v21 */
    /* JADX WARNING: type inference failed for: r26v21 */
    /* JADX WARNING: type inference failed for: r27v21 */
    /* JADX WARNING: type inference failed for: r28v21 */
    /* JADX WARNING: type inference failed for: r29v21 */
    /* JADX WARNING: type inference failed for: r31v21 */
    /* JADX WARNING: type inference failed for: r32v21 */
    /* JADX WARNING: type inference failed for: r33v21 */
    /* JADX WARNING: type inference failed for: r34v21 */
    /* JADX WARNING: type inference failed for: r35v21 */
    /* JADX WARNING: type inference failed for: r3v44, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r22v23 */
    /* JADX WARNING: type inference failed for: r25v22 */
    /* JADX WARNING: type inference failed for: r26v22 */
    /* JADX WARNING: type inference failed for: r27v22 */
    /* JADX WARNING: type inference failed for: r28v22 */
    /* JADX WARNING: type inference failed for: r29v22 */
    /* JADX WARNING: type inference failed for: r31v22 */
    /* JADX WARNING: type inference failed for: r32v22 */
    /* JADX WARNING: type inference failed for: r33v22 */
    /* JADX WARNING: type inference failed for: r34v22 */
    /* JADX WARNING: type inference failed for: r35v22 */
    /* JADX WARNING: type inference failed for: r23v21 */
    /* JADX WARNING: type inference failed for: r2v64, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r21v23 */
    /* JADX WARNING: type inference failed for: r25v23 */
    /* JADX WARNING: type inference failed for: r26v23 */
    /* JADX WARNING: type inference failed for: r27v23 */
    /* JADX WARNING: type inference failed for: r28v23 */
    /* JADX WARNING: type inference failed for: r29v23 */
    /* JADX WARNING: type inference failed for: r31v23 */
    /* JADX WARNING: type inference failed for: r32v23 */
    /* JADX WARNING: type inference failed for: r33v23 */
    /* JADX WARNING: type inference failed for: r34v23 */
    /* JADX WARNING: type inference failed for: r35v23 */
    /* JADX WARNING: type inference failed for: r23v22 */
    /* JADX WARNING: type inference failed for: r22v24 */
    /* JADX WARNING: type inference failed for: r3v49, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r20v23 */
    /* JADX WARNING: type inference failed for: r25v24 */
    /* JADX WARNING: type inference failed for: r26v24 */
    /* JADX WARNING: type inference failed for: r27v24 */
    /* JADX WARNING: type inference failed for: r28v24 */
    /* JADX WARNING: type inference failed for: r29v24 */
    /* JADX WARNING: type inference failed for: r31v24 */
    /* JADX WARNING: type inference failed for: r32v24 */
    /* JADX WARNING: type inference failed for: r33v24 */
    /* JADX WARNING: type inference failed for: r34v24 */
    /* JADX WARNING: type inference failed for: r35v24 */
    /* JADX WARNING: type inference failed for: r23v23 */
    /* JADX WARNING: type inference failed for: r22v25 */
    /* JADX WARNING: type inference failed for: r21v24 */
    /* JADX WARNING: type inference failed for: r2v71, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r19v24 */
    /* JADX WARNING: type inference failed for: r25v25 */
    /* JADX WARNING: type inference failed for: r26v25 */
    /* JADX WARNING: type inference failed for: r27v25 */
    /* JADX WARNING: type inference failed for: r28v25 */
    /* JADX WARNING: type inference failed for: r29v25 */
    /* JADX WARNING: type inference failed for: r31v25 */
    /* JADX WARNING: type inference failed for: r32v25 */
    /* JADX WARNING: type inference failed for: r33v25 */
    /* JADX WARNING: type inference failed for: r34v25 */
    /* JADX WARNING: type inference failed for: r35v25 */
    /* JADX WARNING: type inference failed for: r23v24 */
    /* JADX WARNING: type inference failed for: r22v26 */
    /* JADX WARNING: type inference failed for: r21v25 */
    /* JADX WARNING: type inference failed for: r20v24 */
    /* JADX WARNING: type inference failed for: r4v31, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r25v26 */
    /* JADX WARNING: type inference failed for: r26v26 */
    /* JADX WARNING: type inference failed for: r27v26 */
    /* JADX WARNING: type inference failed for: r28v26 */
    /* JADX WARNING: type inference failed for: r29v26 */
    /* JADX WARNING: type inference failed for: r31v26 */
    /* JADX WARNING: type inference failed for: r32v26 */
    /* JADX WARNING: type inference failed for: r33v26 */
    /* JADX WARNING: type inference failed for: r34v26 */
    /* JADX WARNING: type inference failed for: r35v26 */
    /* JADX WARNING: type inference failed for: r23v25 */
    /* JADX WARNING: type inference failed for: r22v27 */
    /* JADX WARNING: type inference failed for: r21v26 */
    /* JADX WARNING: type inference failed for: r20v25 */
    /* JADX WARNING: type inference failed for: r19v25 */
    /* JADX WARNING: type inference failed for: r4v36, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: type inference failed for: r4v38, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r14v10 */
    /* JADX WARNING: type inference failed for: r4v40, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r4v42, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r4v44, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r4v46, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r4v50, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r4v52, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r4v54, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r2v80, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r23v27 */
    /* JADX WARNING: type inference failed for: r2v82, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r22v29 */
    /* JADX WARNING: type inference failed for: r2v87, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r20v27 */
    /* JADX WARNING: type inference failed for: r2v89, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r19v27 */
    /* JADX WARNING: type inference failed for: r2v91, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r18v38 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r4v56 */
    /* JADX WARNING: type inference failed for: r2v116 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r15v36 */
    /* JADX WARNING: type inference failed for: r14v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r25v30 */
    /* JADX WARNING: type inference failed for: r25v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x025d, code lost:
        r10 = r10 | r4;
        r18 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0260, code lost:
        r25 = r38;
        r26 = r39;
        r27 = r40;
        r28 = r41;
        r29 = r42;
        r30 = r43;
        r31 = r44;
        r32 = r45;
        r33 = r46;
        r34 = r47;
        r35 = r48;
        r23 = r49;
        r22 = r50;
        r21 = r51;
        r20 = r52;
        r19 = r54;
        r5 = r55;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0637, code lost:
        r25 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x06d1, code lost:
        r3 = r18;
        r4 = r19;
        r52 = r20;
        r51 = r21;
        r50 = r22;
        r49 = r23;
        r38 = r25;
        r39 = r26;
        r40 = r27;
        r41 = r28;
        r42 = r29;
        r43 = r30;
        r44 = r31;
        r45 = r32;
        r46 = r33;
        r47 = r34;
        r48 = r35;
        r15 = r15;
        r14 = r14;
        r13 = r13;
        r12 = r12;
        r11 = r11;
        r9 = r9;
        r8 = r8;
        r7 = r7;
        r6 = r6;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x06d1, code lost:
        r25 = r25;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r15v6
      assigns: []
      uses: []
      mth insns count: 827
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 19 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public co.hyperverge.crashguard.data.models.CrashEvent.Contexts.Device deserialize(kotlinx.serialization.encoding.Decoder r59) {
        /*
            r58 = this;
            r0 = r59
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r58.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r11 = 11
            r12 = 10
            r13 = 9
            r14 = 7
            r15 = 6
            r3 = 5
            r4 = 3
            r6 = 8
            r5 = 4
            r7 = 2
            r8 = 0
            r9 = 1
            r10 = 0
            if (r2 == 0) goto L_0x015e
            java.lang.String r2 = r0.decodeStringElement(r1, r8)
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r9, r8, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r7 = r0.decodeNullableSerializableElement(r1, r7, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r9, r10)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r15, r9, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r14, r15, r10)
            kotlinx.serialization.internal.BooleanSerializer r15 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            java.lang.Object r6 = r0.decodeNullableSerializableElement(r1, r6, r15, r10)
            kotlinx.serialization.internal.BooleanSerializer r15 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r13, r15, r10)
            kotlinx.serialization.internal.BooleanSerializer r15 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r12, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r11, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r24 = r2
            r2 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r23 = r2
            r2 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            r22 = r2
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r15.<init>(r2)
            r2 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r21 = r2
            r2 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.FloatSerializer r15 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r20 = r2
            r2 = 16
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r19 = r2
            r2 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.FloatSerializer r15 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r18 = r2
            r2 = 18
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.IntSerializer r15 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r17 = r2
            r2 = 19
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            kotlinx.serialization.internal.BooleanSerializer r15 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r16 = r2
            r2 = 20
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r10)
            r15 = 21
            r59 = r2
            kotlinx.serialization.internal.LongSerializer r2 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 22
            r25 = r2
            kotlinx.serialization.internal.LongSerializer r2 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 23
            r26 = r2
            kotlinx.serialization.internal.LongSerializer r2 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 24
            r27 = r2
            kotlinx.serialization.internal.LongSerializer r2 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 25
            r28 = r2
            co.hyperverge.crashguard.data.models.DateSerializer r2 = new co.hyperverge.crashguard.data.models.DateSerializer
            r2.<init>()
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 26
            r29 = r2
            kotlinx.serialization.internal.FloatSerializer r2 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 27
            r30 = r2
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 28
            r31 = r2
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r15 = 29
            r32 = r2
            kotlinx.serialization.internal.IntSerializer r2 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r15, r2, r10)
            r10 = 1073741823(0x3fffffff, float:1.9999999)
            r36 = r2
            r10 = r4
            r15 = r6
            r6 = r18
            r4 = r19
            r2 = r23
            r33 = r30
            r34 = r31
            r35 = r32
            r37 = 1073741823(0x3fffffff, float:1.9999999)
            r18 = r11
            r30 = r27
            r31 = r28
            r32 = r29
            r27 = r59
            r11 = r5
            r28 = r25
            r29 = r26
            r26 = r16
            r25 = r17
            r17 = r12
            r16 = r13
            r12 = r3
            r13 = r9
            r3 = r20
            r9 = r7
            r7 = r24
            goto L_0x075c
        L_0x015e:
            r2 = r10
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r11 = r9
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r36 = r15
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r49 = r48
            r50 = r49
            r51 = r50
            r52 = r51
            r10 = 0
            r53 = 1
        L_0x0190:
            if (r53 == 0) goto L_0x06f5
            r54 = r4
            int r4 = r0.decodeElementIndex(r1)
            switch(r4) {
                case -1: goto L_0x06a5;
                case 0: goto L_0x0672;
                case 1: goto L_0x0639;
                case 2: goto L_0x0603;
                case 3: goto L_0x05ce;
                case 4: goto L_0x0598;
                case 5: goto L_0x0562;
                case 6: goto L_0x052c;
                case 7: goto L_0x04f5;
                case 8: goto L_0x04bd;
                case 9: goto L_0x0485;
                case 10: goto L_0x044d;
                case 11: goto L_0x0415;
                case 12: goto L_0x03dd;
                case 13: goto L_0x03a5;
                case 14: goto L_0x0368;
                case 15: goto L_0x032e;
                case 16: goto L_0x02f5;
                case 17: goto L_0x02be;
                case 18: goto L_0x0284;
                case 19: goto L_0x024f;
                case 20: goto L_0x023e;
                case 21: goto L_0x022d;
                case 22: goto L_0x021c;
                case 23: goto L_0x020b;
                case 24: goto L_0x01fa;
                case 25: goto L_0x01e5;
                case 26: goto L_0x01d7;
                case 27: goto L_0x01c5;
                case 28: goto L_0x01b3;
                case 29: goto L_0x01a1;
                default: goto L_0x019b;
            }
        L_0x019b:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>(r4)
            throw r0
        L_0x01a1:
            r4 = 29
            r55 = r5
            kotlinx.serialization.internal.IntSerializer r5 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r7)
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r10 = r10 | r5
            r18 = r3
            r7 = r4
            goto L_0x0260
        L_0x01b3:
            r55 = r5
            r4 = 28
            kotlinx.serialization.internal.IntSerializer r5 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r9)
            r5 = 268435456(0x10000000, float:2.524355E-29)
            r10 = r10 | r5
            r18 = r3
            r9 = r4
            goto L_0x0260
        L_0x01c5:
            r55 = r5
            r4 = 27
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r8)
            r5 = 134217728(0x8000000, float:3.85186E-34)
            r10 = r10 | r5
            r18 = r3
            r8 = r4
            goto L_0x0260
        L_0x01d7:
            r55 = r5
            r4 = 26
            kotlinx.serialization.internal.FloatSerializer r5 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r4, r5, r2)
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x025d
        L_0x01e5:
            r55 = r5
            r4 = 25
            co.hyperverge.crashguard.data.models.DateSerializer r5 = new co.hyperverge.crashguard.data.models.DateSerializer
            r5.<init>()
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r11)
            r5 = 33554432(0x2000000, float:9.403955E-38)
            r10 = r10 | r5
            r18 = r3
            r11 = r4
            goto L_0x0260
        L_0x01fa:
            r55 = r5
            r4 = 24
            kotlinx.serialization.internal.LongSerializer r5 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r12)
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r10 = r10 | r5
            r18 = r3
            r12 = r4
            goto L_0x0260
        L_0x020b:
            r55 = r5
            r4 = 23
            kotlinx.serialization.internal.LongSerializer r5 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r13)
            r5 = 8388608(0x800000, float:1.1754944E-38)
            r10 = r10 | r5
            r18 = r3
            r13 = r4
            goto L_0x0260
        L_0x021c:
            r55 = r5
            r4 = 22
            kotlinx.serialization.internal.LongSerializer r5 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r6)
            r5 = 4194304(0x400000, float:5.877472E-39)
            r10 = r10 | r5
            r18 = r3
            r6 = r4
            goto L_0x0260
        L_0x022d:
            r55 = r5
            r4 = 21
            kotlinx.serialization.internal.LongSerializer r5 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r5, r14)
            r5 = 2097152(0x200000, float:2.938736E-39)
            r10 = r10 | r5
            r18 = r3
            r14 = r4
            goto L_0x0260
        L_0x023e:
            r55 = r5
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r5 = 20
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r5, r4, r15)
            r15 = 1048576(0x100000, float:1.469368E-39)
            r10 = r10 | r15
            r18 = r3
            r15 = r4
            goto L_0x0260
        L_0x024f:
            r55 = r5
            r5 = 20
            kotlinx.serialization.internal.IntSerializer r4 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r5 = 19
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r5, r4, r3)
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x025d:
            r10 = r10 | r4
            r18 = r3
        L_0x0260:
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r5 = r55
            goto L_0x0637
        L_0x0284:
            r55 = r5
            r5 = 19
            kotlinx.serialization.internal.FloatSerializer r4 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r17 = r2
            r5 = r55
            r2 = 18
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r2, r4, r5)
            r5 = 262144(0x40000, float:3.67342E-40)
            r10 = r10 | r5
            r18 = r3
            r5 = r4
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            goto L_0x0637
        L_0x02be:
            r17 = r2
            r2 = 18
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r18 = r3
            r2 = r54
            r3 = 17
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r4 = 131072(0x20000, float:1.83671E-40)
            r10 = r10 | r4
            r19 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            goto L_0x0637
        L_0x02f5:
            r17 = r2
            r18 = r3
            r2 = r54
            r3 = 17
            kotlinx.serialization.internal.FloatSerializer r4 = kotlinx.serialization.internal.FloatSerializer.INSTANCE
            r19 = r2
            r3 = r52
            r2 = 16
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r4 = 65536(0x10000, float:9.1835E-41)
            r10 = r10 | r4
            r20 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            goto L_0x0637
        L_0x032e:
            r17 = r2
            r18 = r3
            r3 = r52
            r19 = r54
            r2 = 16
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r20 = r3
            r2 = r51
            r3 = 15
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r4 = 32768(0x8000, float:4.5918E-41)
            r10 = r10 | r4
            r21 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            goto L_0x0637
        L_0x0368:
            r17 = r2
            r18 = r3
            r2 = r51
            r20 = r52
            r19 = r54
            r3 = 15
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r3 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r4.<init>(r3)
            r21 = r2
            r3 = r50
            r2 = 14
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 16384(0x4000, float:2.2959E-41)
            r22 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            goto L_0x0637
        L_0x03a5:
            r17 = r2
            r18 = r3
            r3 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 14
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r22 = r3
            r2 = r49
            r3 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 8192(0x2000, float:1.148E-41)
            r23 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            goto L_0x0637
        L_0x03dd:
            r17 = r2
            r18 = r3
            r2 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 13
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r23 = r2
            r3 = r48
            r2 = 12
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 4096(0x1000, float:5.74E-42)
            r35 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            goto L_0x0637
        L_0x0415:
            r17 = r2
            r18 = r3
            r3 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 12
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r35 = r3
            r2 = r47
            r3 = 11
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 2048(0x800, float:2.87E-42)
            r34 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            goto L_0x0637
        L_0x044d:
            r17 = r2
            r18 = r3
            r2 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 11
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r34 = r2
            r3 = r46
            r2 = 10
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 1024(0x400, float:1.435E-42)
            r33 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            goto L_0x0637
        L_0x0485:
            r17 = r2
            r18 = r3
            r3 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 10
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r33 = r3
            r2 = r45
            r3 = 9
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 512(0x200, float:7.17E-43)
            r32 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            goto L_0x0637
        L_0x04bd:
            r17 = r2
            r18 = r3
            r2 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 9
            kotlinx.serialization.internal.BooleanSerializer r4 = kotlinx.serialization.internal.BooleanSerializer.INSTANCE
            r32 = r2
            r3 = r44
            r2 = 8
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 256(0x100, float:3.59E-43)
            r31 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            goto L_0x0637
        L_0x04f5:
            r17 = r2
            r18 = r3
            r3 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 8
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r31 = r3
            r2 = r43
            r3 = 7
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 128(0x80, float:1.8E-43)
            r30 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            goto L_0x0637
        L_0x052c:
            r17 = r2
            r18 = r3
            r2 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 7
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r30 = r2
            r3 = r42
            r2 = 6
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 64
            r29 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            goto L_0x0637
        L_0x0562:
            r17 = r2
            r18 = r3
            r3 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 6
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r29 = r3
            r2 = r41
            r3 = 5
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 32
            r28 = r2
            r2 = r17
            r25 = r38
            r26 = r39
            r27 = r40
            goto L_0x0637
        L_0x0598:
            r17 = r2
            r18 = r3
            r2 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 5
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r28 = r2
            r3 = r40
            r2 = 4
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 16
            r27 = r3
            r2 = r17
            r25 = r38
            r26 = r39
            goto L_0x0637
        L_0x05ce:
            r17 = r2
            r18 = r3
            r3 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 4
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r27 = r3
            r2 = r39
            r3 = 3
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 8
            r26 = r2
            r2 = r17
            r25 = r38
            goto L_0x0637
        L_0x0603:
            r17 = r2
            r18 = r3
            r2 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 3
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r26 = r2
            r3 = r38
            r2 = 2
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r2, r4, r3)
            r10 = r10 | 4
            r25 = r3
            r2 = r17
        L_0x0637:
            r3 = 1
            goto L_0x066f
        L_0x0639:
            r17 = r2
            r18 = r3
            r3 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r2 = 2
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            r25 = r3
            r2 = r37
            r3 = 1
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r3, r4, r2)
            r10 = r10 | 2
            r37 = r2
            r2 = r17
        L_0x066f:
            r4 = 0
            goto L_0x06d1
        L_0x0672:
            r17 = r2
            r18 = r3
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 1
            r4 = 0
            java.lang.String r24 = r0.decodeStringElement(r1, r4)
            r10 = r10 | 1
            r2 = r17
            r36 = r24
            goto L_0x06d1
        L_0x06a5:
            r17 = r2
            r18 = r3
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r19 = r54
            r3 = 1
            r4 = 0
            r2 = r17
            r53 = 0
        L_0x06d1:
            r3 = r18
            r4 = r19
            r52 = r20
            r51 = r21
            r50 = r22
            r49 = r23
            r38 = r25
            r39 = r26
            r40 = r27
            r41 = r28
            r42 = r29
            r43 = r30
            r44 = r31
            r45 = r32
            r46 = r33
            r47 = r34
            r48 = r35
            goto L_0x0190
        L_0x06f5:
            r17 = r2
            r18 = r3
            r19 = r4
            r2 = r37
            r25 = r38
            r26 = r39
            r27 = r40
            r28 = r41
            r29 = r42
            r30 = r43
            r31 = r44
            r32 = r45
            r33 = r46
            r34 = r47
            r35 = r48
            r23 = r49
            r22 = r50
            r21 = r51
            r20 = r52
            r37 = r10
            r4 = r20
            r3 = r21
            r21 = r22
            r22 = r23
            r10 = r26
            r16 = r32
            r32 = r11
            r26 = r18
            r11 = r27
            r18 = r34
            r34 = r8
            r27 = r15
            r15 = r31
            r8 = r2
            r31 = r12
            r12 = r28
            r2 = r35
            r35 = r9
            r28 = r14
            r9 = r25
            r14 = r30
            r25 = r5
            r30 = r13
            r13 = r29
            r29 = r6
            r6 = r19
            r56 = r36
            r36 = r7
            r7 = r56
            r57 = r33
            r33 = r17
            r17 = r57
        L_0x075c:
            r0.endStructure(r1)
            co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device r0 = new co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device
            r5 = r0
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            java.lang.Boolean r17 = (java.lang.Boolean) r17
            java.lang.String r18 = (java.lang.String) r18
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            r20 = r22
            java.lang.String r20 = (java.lang.String) r20
            java.util.List r21 = (java.util.List) r21
            r22 = r3
            java.lang.String r22 = (java.lang.String) r22
            r23 = r4
            java.lang.Float r23 = (java.lang.Float) r23
            r24 = r6
            java.lang.String r24 = (java.lang.String) r24
            java.lang.Float r25 = (java.lang.Float) r25
            java.lang.Integer r26 = (java.lang.Integer) r26
            java.lang.Boolean r27 = (java.lang.Boolean) r27
            java.lang.Long r28 = (java.lang.Long) r28
            java.lang.Long r29 = (java.lang.Long) r29
            java.lang.Long r30 = (java.lang.Long) r30
            java.lang.Long r31 = (java.lang.Long) r31
            java.util.Date r32 = (java.util.Date) r32
            java.lang.Float r33 = (java.lang.Float) r33
            java.lang.String r34 = (java.lang.String) r34
            java.lang.Integer r35 = (java.lang.Integer) r35
            java.lang.Integer r36 = (java.lang.Integer) r36
            r6 = r37
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):co.hyperverge.crashguard.data.models.CrashEvent$Contexts$Device");
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Device device) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(device, HSLCriteriaBuilder.VALUE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Intrinsics.checkNotNullParameter(device, "self");
        Intrinsics.checkNotNullParameter(beginStructure, "output");
        Intrinsics.checkNotNullParameter(descriptor2, "serialDesc");
        boolean z = false;
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 0) || !Intrinsics.areEqual(device.type, "device")) {
            beginStructure.encodeStringElement(descriptor2, 0, device.type);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 1) || device.name != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, device.name);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 2) || device.family != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, device.family);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 3) || device.model != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, device.model);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 4) || device.arch != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, device.arch);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 5) || device.orientation != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, device.orientation);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 6) || device.manufacturer != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, device.manufacturer);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 7) || device.brand != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, device.brand);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 8) || device.online != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, device.online);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 9) || device.charging != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 9, BooleanSerializer.INSTANCE, device.charging);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 10) || device.simulator != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 10, BooleanSerializer.INSTANCE, device.simulator);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 11) || device.timezone != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, device.timezone);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 12) || device.id != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, device.id);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 13) || device.language != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, device.language);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 14) || device.archs != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 14, new ArrayListSerializer(StringSerializer.INSTANCE), device.archs);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 15) || device.modelId != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, device.modelId);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 16) || device.batteryLevel != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 16, FloatSerializer.INSTANCE, device.batteryLevel);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 17) || device.screenResolution != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, device.screenResolution);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 18) || device.screenDensity != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 18, FloatSerializer.INSTANCE, device.screenDensity);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 19) || device.screenDpi != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 19, IntSerializer.INSTANCE, device.screenDpi);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 20) || device.lowMemory != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 20, BooleanSerializer.INSTANCE, device.lowMemory);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 21) || device.memorySizeBytes != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 21, LongSerializer.INSTANCE, device.memorySizeBytes);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 22) || device.freeMemoryBytes != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 22, LongSerializer.INSTANCE, device.freeMemoryBytes);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 23) || device.storageSizeBytes != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 23, LongSerializer.INSTANCE, device.storageSizeBytes);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 24) || device.freeStorageBytes != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 24, LongSerializer.INSTANCE, device.freeStorageBytes);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 25) || device.bootTime != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 25, new DateSerializer(), device.bootTime);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 26) || device.batteryTemperature != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 26, FloatSerializer.INSTANCE, device.batteryTemperature);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 27) || device.connectionType != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 27, StringSerializer.INSTANCE, device.connectionType);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 28) || device.screenHeightPx != null) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 28, IntSerializer.INSTANCE, device.screenHeightPx);
        }
        if (beginStructure.shouldEncodeElementDefault(descriptor2, 29) || device.screenWidthPx != null) {
            z = true;
        }
        if (z) {
            beginStructure.encodeNullableSerializableElement(descriptor2, 29, IntSerializer.INSTANCE, device.screenWidthPx);
        }
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return TypeUtilsKt.typeParametersSerializers(this);
    }
}
