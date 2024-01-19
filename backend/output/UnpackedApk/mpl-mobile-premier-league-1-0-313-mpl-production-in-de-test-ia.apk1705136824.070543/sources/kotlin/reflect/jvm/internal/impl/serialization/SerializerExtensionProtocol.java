package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;

/* compiled from: SerializerExtensionProtocol.kt */
public class SerializerExtensionProtocol {
    public final GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> classAnnotation;
    public final GeneratedExtension<ProtoBuf$Property, Value> compileTimeValue;
    public final GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> constructorAnnotation;
    public final GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> enumEntryAnnotation;
    public final ExtensionRegistryLite extensionRegistry;
    public final GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionAnnotation;
    public final GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> parameterAnnotation;
    public final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyAnnotation;
    public final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyGetterAnnotation;
    public final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertySetterAnnotation;
    public final GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation;
    public final GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<ProtoBuf$Package, Integer> generatedExtension, GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> generatedExtension2, GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> generatedExtension3, GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> generatedExtension4, GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension5, GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension6, GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension7, GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> generatedExtension8, GeneratedExtension<ProtoBuf$Property, Value> generatedExtension9, GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> generatedExtension10, GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> generatedExtension11, GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> generatedExtension12) {
        Intrinsics.checkNotNullParameter(extensionRegistryLite, "extensionRegistry");
        Intrinsics.checkNotNullParameter(generatedExtension, "packageFqName");
        Intrinsics.checkNotNullParameter(generatedExtension2, "constructorAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension3, "classAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension4, "functionAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension5, "propertyAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension6, "propertyGetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension7, "propertySetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension8, "enumEntryAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension9, "compileTimeValue");
        Intrinsics.checkNotNullParameter(generatedExtension10, "parameterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension11, "typeAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension12, "typeParameterAnnotation");
        this.extensionRegistry = extensionRegistryLite;
        this.constructorAnnotation = generatedExtension2;
        this.classAnnotation = generatedExtension3;
        this.functionAnnotation = generatedExtension4;
        this.propertyAnnotation = generatedExtension5;
        this.propertyGetterAnnotation = generatedExtension6;
        this.propertySetterAnnotation = generatedExtension7;
        this.enumEntryAnnotation = generatedExtension8;
        this.compileTimeValue = generatedExtension9;
        this.parameterAnnotation = generatedExtension10;
        this.typeAnnotation = generatedExtension11;
        this.typeParameterAnnotation = generatedExtension12;
    }
}
