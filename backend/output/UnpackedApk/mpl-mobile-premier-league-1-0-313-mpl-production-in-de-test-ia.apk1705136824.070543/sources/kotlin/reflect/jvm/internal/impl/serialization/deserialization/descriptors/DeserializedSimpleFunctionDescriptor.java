package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedSimpleFunctionDescriptor extends SimpleFunctionDescriptorImpl implements DeserializedCallableMemberDescriptor {
    public final DeserializedContainerSource containerSource;
    public CoroutinesCompatibilityMode coroutinesExperimentalCompatibilityMode;
    public final NameResolver nameResolver;
    public final ProtoBuf$Function proto;
    public final TypeTable typeTable;
    public final VersionRequirementTable versionRequirementTable;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedSimpleFunctionDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, Kind kind, ProtoBuf$Function protoBuf$Function, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        // ProtoBuf$Function protoBuf$Function2 = protoBuf$Function;
        // NameResolver nameResolver3 = nameResolver2;
        // TypeTable typeTable3 = typeTable2;
        // VersionRequirementTable versionRequirementTable3 = versionRequirementTable2;
        // DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        // Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        // Annotations annotations2 = annotations;
        // Intrinsics.checkNotNullParameter(annotations, "annotations");
        // Intrinsics.checkNotNullParameter(name, "name");
        // Intrinsics.checkNotNullParameter(kind, "kind");
        // Intrinsics.checkNotNullParameter(protoBuf$Function2, "proto");
        // Intrinsics.checkNotNullParameter(nameResolver3, "nameResolver");
        // Intrinsics.checkNotNullParameter(typeTable3, "typeTable");
        // Intrinsics.checkNotNullParameter(versionRequirementTable3, "versionRequirementTable");
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        this.proto = protoBuf$Function2;
        this.nameResolver = nameResolver3;
        this.typeTable = typeTable3;
        this.versionRequirementTable = versionRequirementTable3;
        this.containerSource = deserializedContainerSource;
        this.coroutinesExperimentalCompatibilityMode = CoroutinesCompatibilityMode.COMPATIBLE;
    }

    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Name name2;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            Name name3 = getName();
            Intrinsics.checkNotNullExpressionValue(name3, "name");
            name2 = name3;
        } else {
            name2 = name;
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name2, kind, this.proto, this.nameResolver, this.typeTable, this.versionRequirementTable, this.containerSource, sourceElement);
        deserializedSimpleFunctionDescriptor.hasStableParameterNames = this.hasStableParameterNames;
        deserializedSimpleFunctionDescriptor.coroutinesExperimentalCompatibilityMode = this.coroutinesExperimentalCompatibilityMode;
        return deserializedSimpleFunctionDescriptor;
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

    public final SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends UserDataKey<?>, ?> map, CoroutinesCompatibilityMode coroutinesCompatibilityMode) {
        Intrinsics.checkNotNullParameter(list, "typeParameters");
        Intrinsics.checkNotNullParameter(list2, "unsubstitutedValueParameters");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(map, "userDataMap");
        Intrinsics.checkNotNullParameter(coroutinesCompatibilityMode, "isExperimentalCoroutineInReleaseEnvironment");
        super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility, map);
        Intrinsics.checkNotNullExpressionValue(this, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.coroutinesExperimentalCompatibilityMode = coroutinesCompatibilityMode;
        return this;
    }
}
