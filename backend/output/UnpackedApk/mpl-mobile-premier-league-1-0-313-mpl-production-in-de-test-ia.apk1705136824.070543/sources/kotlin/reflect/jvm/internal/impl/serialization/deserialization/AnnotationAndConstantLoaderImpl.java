package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    public final AnnotationDeserializer deserializer;
    public final SerializerExtensionProtocol protocol;

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(serializerExtensionProtocol, "protocol");
        this.protocol = serializerExtensionProtocol;
        this.deserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Iterable<ProtoBuf$Annotation> iterable;
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf$Constructor) {
            iterable = (List) ((ProtoBuf$Constructor) messageLite).getExtension(this.protocol.constructorAnnotation);
        } else if (messageLite instanceof ProtoBuf$Function) {
            iterable = (List) ((ProtoBuf$Function) messageLite).getExtension(this.protocol.functionAnnotation);
        } else if (messageLite instanceof ProtoBuf$Property) {
            int ordinal = annotatedCallableKind.ordinal();
            if (ordinal == 1) {
                iterable = (List) ((ProtoBuf$Property) messageLite).getExtension(this.protocol.propertyAnnotation);
            } else if (ordinal == 2) {
                iterable = (List) ((ProtoBuf$Property) messageLite).getExtension(this.protocol.propertyGetterAnnotation);
            } else if (ordinal == 3) {
                iterable = (List) ((ProtoBuf$Property) messageLite).getExtension(this.protocol.propertySetterAnnotation);
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Unknown message: ", messageLite).toString());
        }
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.nameResolver));
        }
        return arrayList;
    }

    public List<AnnotationDescriptor> loadClassAnnotations(Class classR) {
        Intrinsics.checkNotNullParameter(classR, "container");
        Iterable<ProtoBuf$Annotation> iterable = (List) classR.classProto.getExtension(this.protocol.classAnnotation);
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, classR.nameResolver));
        }
        return arrayList;
    }

    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$EnumEntry, "proto");
        Iterable<ProtoBuf$Annotation> iterable = (List) protoBuf$EnumEntry.getExtension(this.protocol.enumEntryAnnotation);
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.nameResolver));
        }
        return arrayList;
    }

    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        return EmptyList.INSTANCE;
    }

    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        return EmptyList.INSTANCE;
    }

    public Object loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Value value = (Value) TweetUtils.getExtensionOrNull(protoBuf$Property, this.protocol.compileTimeValue);
        if (value == null) {
            return null;
        }
        return this.deserializer.resolveValue(kotlinType, value, protoContainer.nameResolver);
    }

    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        return EmptyList.INSTANCE;
    }

    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(protoBuf$Type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Iterable<ProtoBuf$Annotation> iterable = (List) protoBuf$Type.getExtension(this.protocol.typeAnnotation);
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return arrayList;
    }

    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(protoBuf$TypeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Iterable<ProtoBuf$Annotation> iterable = (List) protoBuf$TypeParameter.getExtension(this.protocol.typeParameterAnnotation);
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return arrayList;
    }

    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics.checkNotNullParameter(protoBuf$ValueParameter, "proto");
        Iterable<ProtoBuf$Annotation> iterable = (List) protoBuf$ValueParameter.getExtension(this.protocol.parameterAnnotation);
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf$Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.deserializer.deserializeAnnotation(deserializeAnnotation, protoContainer.nameResolver));
        }
        return arrayList;
    }
}
