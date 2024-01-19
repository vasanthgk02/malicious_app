package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.util.List;
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
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType;
import org.apache.commons.net.ftp.FTPReply;

public final class BuiltInsProtoBuf {
    public static final GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Class.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Property, Value> compileTimeValue;
    public static final GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Constructor.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$EnumEntry.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Function.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Package, Integer> packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Package.defaultInstance, Integer.valueOf(0), null, null, 151, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$ValueParameter.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, 152, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, 153, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Type.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$TypeParameter.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, FTPReply.FILE_STATUS_OK, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);

    static {
        ProtoBuf$Property protoBuf$Property = ProtoBuf$Property.defaultInstance;
        Value value = Value.defaultInstance;
        compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(protoBuf$Property, value, value, null, 151, WireFormat$FieldType.MESSAGE, Value.class);
    }
}
