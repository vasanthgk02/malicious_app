package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;

/* compiled from: ProtoEnumFlags.kt */
public final class ProtoEnumFlags {
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    /* compiled from: ProtoEnumFlags.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ProtoBuf$Modality.values().length];
            ProtoBuf$Modality protoBuf$Modality = ProtoBuf$Modality.FINAL;
            iArr[0] = 1;
            ProtoBuf$Modality protoBuf$Modality2 = ProtoBuf$Modality.OPEN;
            iArr[1] = 2;
            ProtoBuf$Modality protoBuf$Modality3 = ProtoBuf$Modality.ABSTRACT;
            iArr[2] = 3;
            ProtoBuf$Modality protoBuf$Modality4 = ProtoBuf$Modality.SEALED;
            iArr[3] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Modality.values().length];
            Modality modality = Modality.FINAL;
            iArr2[0] = 1;
            Modality modality2 = Modality.OPEN;
            iArr2[2] = 2;
            Modality modality3 = Modality.ABSTRACT;
            iArr2[3] = 3;
            Modality modality4 = Modality.SEALED;
            iArr2[1] = 4;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            ProtoBuf$Visibility protoBuf$Visibility = ProtoBuf$Visibility.INTERNAL;
            iArr3[0] = 1;
            ProtoBuf$Visibility protoBuf$Visibility2 = ProtoBuf$Visibility.PRIVATE;
            iArr3[1] = 2;
            ProtoBuf$Visibility protoBuf$Visibility3 = ProtoBuf$Visibility.PRIVATE_TO_THIS;
            iArr3[4] = 3;
            ProtoBuf$Visibility protoBuf$Visibility4 = ProtoBuf$Visibility.PROTECTED;
            iArr3[2] = 4;
            ProtoBuf$Visibility protoBuf$Visibility5 = ProtoBuf$Visibility.PUBLIC;
            iArr3[3] = 5;
            ProtoBuf$Visibility protoBuf$Visibility6 = ProtoBuf$Visibility.LOCAL;
            iArr3[5] = 6;
            int[] iArr4 = new int[Kind.values().length];
            Kind kind = Kind.CLASS;
            iArr4[0] = 1;
            Kind kind2 = Kind.INTERFACE;
            iArr4[1] = 2;
            Kind kind3 = Kind.ENUM_CLASS;
            iArr4[2] = 3;
            Kind kind4 = Kind.ENUM_ENTRY;
            iArr4[3] = 4;
            Kind kind5 = Kind.ANNOTATION_CLASS;
            iArr4[4] = 5;
            Kind kind6 = Kind.OBJECT;
            iArr4[5] = 6;
            Kind kind7 = Kind.COMPANION_OBJECT;
            iArr4[6] = 7;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ClassKind.values().length];
            ClassKind classKind = ClassKind.CLASS;
            iArr5[0] = 1;
            ClassKind classKind2 = ClassKind.INTERFACE;
            iArr5[1] = 2;
            ClassKind classKind3 = ClassKind.ENUM_CLASS;
            iArr5[2] = 3;
            ClassKind classKind4 = ClassKind.ENUM_ENTRY;
            iArr5[3] = 4;
            ClassKind classKind5 = ClassKind.ANNOTATION_CLASS;
            iArr5[4] = 5;
            ClassKind classKind6 = ClassKind.OBJECT;
            iArr5[5] = 6;
            int[] iArr6 = new int[Variance.values().length];
            Variance variance = Variance.IN;
            iArr6[0] = 1;
            Variance variance2 = Variance.OUT;
            iArr6[1] = 2;
            Variance variance3 = Variance.INV;
            iArr6[2] = 3;
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[Projection.values().length];
            Projection projection = Projection.IN;
            iArr7[0] = 1;
            Projection projection2 = Projection.OUT;
            iArr7[1] = 2;
            Projection projection3 = Projection.INV;
            iArr7[2] = 3;
            Projection projection4 = Projection.STAR;
            iArr7[3] = 4;
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[kotlin.reflect.jvm.internal.impl.types.Variance.values().length];
            kotlin.reflect.jvm.internal.impl.types.Variance variance4 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE;
            iArr8[1] = 1;
            kotlin.reflect.jvm.internal.impl.types.Variance variance5 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE;
            iArr8[2] = 2;
            kotlin.reflect.jvm.internal.impl.types.Variance variance6 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
            iArr8[0] = 3;
        }
    }
}
