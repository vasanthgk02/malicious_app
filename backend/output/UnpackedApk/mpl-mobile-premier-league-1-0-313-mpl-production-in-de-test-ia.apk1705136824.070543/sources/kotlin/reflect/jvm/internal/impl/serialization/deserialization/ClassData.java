package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* compiled from: ClassData.kt */
public final class ClassData {
    public final ProtoBuf$Class classProto;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;
    public final SourceElement sourceElement;

    public ClassData(NameResolver nameResolver2, ProtoBuf$Class protoBuf$Class, BinaryVersion binaryVersion, SourceElement sourceElement2) {
        Intrinsics.checkNotNullParameter(nameResolver2, "nameResolver");
        Intrinsics.checkNotNullParameter(protoBuf$Class, "classProto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement2, "sourceElement");
        this.nameResolver = nameResolver2;
        this.classProto = protoBuf$Class;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual(this.nameResolver, classData.nameResolver) && Intrinsics.areEqual(this.classProto, classData.classProto) && Intrinsics.areEqual(this.metadataVersion, classData.metadataVersion) && Intrinsics.areEqual(this.sourceElement, classData.sourceElement);
    }

    public int hashCode() {
        int hashCode = this.classProto.hashCode();
        int hashCode2 = this.metadataVersion.hashCode();
        return this.sourceElement.hashCode() + ((hashCode2 + ((hashCode + (this.nameResolver.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ClassData(nameResolver=");
        outline73.append(this.nameResolver);
        outline73.append(", classProto=");
        outline73.append(this.classProto);
        outline73.append(", metadataVersion=");
        outline73.append(this.metadataVersion);
        outline73.append(", sourceElement=");
        outline73.append(this.sourceElement);
        outline73.append(')');
        return outline73.toString();
    }
}
