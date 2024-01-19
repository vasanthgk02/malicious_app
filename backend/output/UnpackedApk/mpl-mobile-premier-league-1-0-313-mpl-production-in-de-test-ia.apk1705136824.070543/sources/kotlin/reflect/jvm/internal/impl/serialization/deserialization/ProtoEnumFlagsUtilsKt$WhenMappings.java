package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;

/* compiled from: ProtoEnumFlagsUtils.kt */
public final /* synthetic */ class ProtoEnumFlagsUtilsKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        int[] iArr = new int[ProtoBuf$MemberKind.values().length];
        ProtoBuf$MemberKind protoBuf$MemberKind = ProtoBuf$MemberKind.DECLARATION;
        iArr[0] = 1;
        ProtoBuf$MemberKind protoBuf$MemberKind2 = ProtoBuf$MemberKind.FAKE_OVERRIDE;
        iArr[1] = 2;
        ProtoBuf$MemberKind protoBuf$MemberKind3 = ProtoBuf$MemberKind.DELEGATION;
        iArr[2] = 3;
        ProtoBuf$MemberKind protoBuf$MemberKind4 = ProtoBuf$MemberKind.SYNTHESIZED;
        iArr[3] = 4;
        $EnumSwitchMapping$0 = iArr;
        int[] iArr2 = new int[Kind.values().length];
        Kind kind = Kind.DECLARATION;
        iArr2[0] = 1;
        Kind kind2 = Kind.FAKE_OVERRIDE;
        iArr2[1] = 2;
        Kind kind3 = Kind.DELEGATION;
        iArr2[2] = 3;
        Kind kind4 = Kind.SYNTHESIZED;
        iArr2[3] = 4;
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
        $EnumSwitchMapping$2 = iArr3;
    }
}
