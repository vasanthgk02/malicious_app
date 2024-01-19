package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* compiled from: context.kt */
public final class DeserializationContext {
    public final DeserializationComponents components;
    public final DeserializedContainerSource containerSource;
    public final DeclarationDescriptor containingDeclaration;
    public final MemberDeserializer memberDeserializer;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;
    public final TypeDeserializer typeDeserializer;
    public final TypeTable typeTable;
    public final VersionRequirementTable versionRequirementTable;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0063, code lost:
        r0 = r0.getPresentableString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0067, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializationContext(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r12, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r13, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r14, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r15, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r16, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r17, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r18, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r19, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r20) {
        /*
            r11 = this;
            r8 = r11
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            java.lang.String r6 = "components"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r6)
            java.lang.String r6 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r6)
            java.lang.String r6 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r6)
            java.lang.String r6 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r6)
            java.lang.String r6 = "versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "metadataVersion"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.lang.String r6 = "typeParameters"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            r11.<init>()
            r8.components = r0
            r8.nameResolver = r1
            r8.containingDeclaration = r2
            r8.typeTable = r3
            r8.versionRequirementTable = r4
            r8.metadataVersion = r5
            r0 = r18
            r8.containerSource = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer
            java.lang.String r0 = "Deserializer for \""
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r8.containingDeclaration
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r1.getName()
            r0.append(r1)
            r1 = 34
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r0 = r8.containerSource
            if (r0 != 0) goto L_0x0063
            goto L_0x0069
        L_0x0063:
            java.lang.String r0 = r0.getPresentableString()
            if (r0 != 0) goto L_0x006b
        L_0x0069:
            java.lang.String r0 = "[container not found]"
        L_0x006b:
            r5 = r0
            r6 = 0
            r10 = 32
            r0 = r9
            r1 = r11
            r2 = r19
            r3 = r20
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.typeDeserializer = r9
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer
            r0.<init>(r11)
            r8.memberDeserializer = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer, java.util.List):void");
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, BinaryVersion binaryVersion, int i) {
        BinaryVersion binaryVersion2 = null;
        NameResolver nameResolver3 = (i & 4) != 0 ? deserializationContext.nameResolver : null;
        TypeTable typeTable3 = (i & 8) != 0 ? deserializationContext.typeTable : null;
        VersionRequirementTable versionRequirementTable3 = (i & 16) != 0 ? deserializationContext.versionRequirementTable : null;
        if ((i & 32) != 0) {
            binaryVersion2 = deserializationContext.metadataVersion;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver3, typeTable3, versionRequirementTable3, binaryVersion2);
    }

    public final DeserializationContext childContext(DeclarationDescriptor declarationDescriptor, List<ProtoBuf$TypeParameter> list, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, BinaryVersion binaryVersion) {
        VersionRequirementTable versionRequirementTable3;
        BinaryVersion binaryVersion2 = binaryVersion;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        List<ProtoBuf$TypeParameter> list2 = list;
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(nameResolver2, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable2, "typeTable");
        VersionRequirementTable versionRequirementTable4 = versionRequirementTable2;
        Intrinsics.checkNotNullParameter(versionRequirementTable4, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(binaryVersion2, "metadataVersion");
        DeserializationComponents deserializationComponents = this.components;
        Intrinsics.checkNotNullParameter(binaryVersion2, "version");
        Intrinsics.checkNotNullParameter(binaryVersion2, "version");
        boolean z = true;
        if (binaryVersion2.major != 1 || binaryVersion2.minor < 4) {
            z = false;
        }
        if (z) {
            versionRequirementTable3 = versionRequirementTable4;
        } else {
            versionRequirementTable3 = this.versionRequirementTable;
        }
        DeserializationContext deserializationContext = new DeserializationContext(deserializationComponents, nameResolver2, declarationDescriptor, typeTable2, versionRequirementTable3, binaryVersion, this.containerSource, this.typeDeserializer, list);
        return deserializationContext;
    }
}
