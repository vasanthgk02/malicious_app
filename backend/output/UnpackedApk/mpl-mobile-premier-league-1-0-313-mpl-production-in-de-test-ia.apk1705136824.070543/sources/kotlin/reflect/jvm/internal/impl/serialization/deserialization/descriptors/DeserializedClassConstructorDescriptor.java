package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements DeserializedCallableMemberDescriptor {
    public final DeserializedContainerSource containerSource;
    public CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
    public final NameResolver nameResolver;
    public final ProtoBuf$Constructor proto;
    public final TypeTable typeTable;
    public final VersionRequirementTable versionRequirementTable;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassConstructorDescriptor(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, Kind kind, ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        // ProtoBuf$Constructor protoBuf$Constructor2 = protoBuf$Constructor;
        // NameResolver nameResolver3 = nameResolver2;
        // TypeTable typeTable3 = typeTable2;
        // VersionRequirementTable versionRequirementTable3 = versionRequirementTable2;
        // ClassDescriptor classDescriptor2 = classDescriptor;
        // Intrinsics.checkNotNullParameter(classDescriptor, "containingDeclaration");
        // Annotations annotations2 = annotations;
        // Intrinsics.checkNotNullParameter(annotations, "annotations");
        // Intrinsics.checkNotNullParameter(kind, "kind");
        // Intrinsics.checkNotNullParameter(protoBuf$Constructor2, "proto");
        // Intrinsics.checkNotNullParameter(nameResolver3, "nameResolver");
        // Intrinsics.checkNotNullParameter(typeTable3, "typeTable");
        // Intrinsics.checkNotNullParameter(versionRequirementTable3, "versionRequirementTable");
        super(classDescriptor, constructorDescriptor, annotations, z, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        this.proto = protoBuf$Constructor2;
        this.nameResolver = nameResolver3;
        this.typeTable = typeTable3;
        this.versionRequirementTable = versionRequirementTable3;
        this.containerSource = deserializedContainerSource;
        this.coroutinesExperimentalCompatibilityMode = CoroutinesCompatibilityMode.COMPATIBLE;
    }

    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public MessageLite getProto() {
        return this.proto;
    }

    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public List<VersionRequirement> getVersionRequirements() {
        return TweetUtils.getVersionRequirements(this);
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isSuspend() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }

    public DeserializedClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Annotations annotations, SourceElement sourceElement) {
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor2, "newOwner");
        Kind kind2 = kind;
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Annotations annotations2 = annotations;
        Intrinsics.checkNotNullParameter(annotations2, "annotations");
        SourceElement sourceElement2 = sourceElement;
        Intrinsics.checkNotNullParameter(sourceElement2, DefaultSettingsSpiCall.SOURCE_PARAM);
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor((ClassDescriptor) declarationDescriptor2, (ConstructorDescriptor) functionDescriptor, annotations2, this.isPrimary, kind2, this.proto, this.nameResolver, this.typeTable, this.versionRequirementTable, this.containerSource, sourceElement2);
        deserializedClassConstructorDescriptor.hasStableParameterNames = this.hasStableParameterNames;
        CoroutinesCompatibilityMode coroutinesCompatibilityMode = this.coroutinesExperimentalCompatibilityMode;
        Intrinsics.checkNotNullParameter(coroutinesCompatibilityMode, "<set-?>");
        deserializedClassConstructorDescriptor.coroutinesExperimentalCompatibilityMode = coroutinesCompatibilityMode;
        return deserializedClassConstructorDescriptor;
    }
}
