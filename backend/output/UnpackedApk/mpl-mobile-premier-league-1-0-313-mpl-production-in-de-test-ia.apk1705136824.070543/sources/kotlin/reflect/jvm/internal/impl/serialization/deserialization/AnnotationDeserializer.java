package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.ErrorValueWithMessage;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: AnnotationDeserializer.kt */
public final class AnnotationDeserializer {
    public final ModuleDescriptor module;
    public final NotFoundClasses notFoundClasses;

    /* compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            Type type = Type.BYTE;
            iArr[0] = 1;
            Type type2 = Type.CHAR;
            iArr[1] = 2;
            Type type3 = Type.SHORT;
            iArr[2] = 3;
            Type type4 = Type.INT;
            iArr[3] = 4;
            Type type5 = Type.LONG;
            iArr[4] = 5;
            Type type6 = Type.FLOAT;
            iArr[5] = 6;
            Type type7 = Type.DOUBLE;
            iArr[6] = 7;
            Type type8 = Type.BOOLEAN;
            iArr[7] = 8;
            Type type9 = Type.STRING;
            iArr[8] = 9;
            Type type10 = Type.CLASS;
            iArr[9] = 10;
            Type type11 = Type.ENUM;
            iArr[10] = 11;
            Type type12 = Type.ANNOTATION;
            iArr[11] = 12;
            Type type13 = Type.ARRAY;
            iArr[12] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses2;
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf$Annotation protoBuf$Annotation, NameResolver nameResolver) {
        Object obj;
        Intrinsics.checkNotNullParameter(protoBuf$Annotation, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor findNonGenericClassAcrossDependencies = TweetUtils.findNonGenericClassAcrossDependencies(this.module, TweetUtils.getClassId(nameResolver, protoBuf$Annotation.id_), this.notFoundClasses);
        Map emptyMap = ArraysKt___ArraysJvmKt.emptyMap();
        if (protoBuf$Annotation.argument_.size() != 0 && !ErrorUtils.isError(findNonGenericClassAcrossDependencies) && DescriptorUtils.isAnnotationClass(findNonGenericClassAcrossDependencies)) {
            Collection<ClassConstructorDescriptor> constructors = findNonGenericClassAcrossDependencies.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) ArraysKt___ArraysJvmKt.singleOrNull((Iterable<? extends T>) constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                int mapCapacity = TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(valueParameters, 10));
                if (mapCapacity < 16) {
                    mapCapacity = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                for (T next : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) next).getName(), next);
                }
                List<Argument> list = protoBuf$Annotation.argument_;
                Intrinsics.checkNotNullExpressionValue(list, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (Argument argument : list) {
                    Intrinsics.checkNotNullExpressionValue(argument, "it");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) linkedHashMap.get(TweetUtils.getName(nameResolver, argument.nameId_));
                    Object obj2 = 0;
                    if (valueParameterDescriptor != null) {
                        Name name = TweetUtils.getName(nameResolver, argument.nameId_);
                        KotlinType type = valueParameterDescriptor.getType();
                        Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                        Value value = argument.value_;
                        Intrinsics.checkNotNullExpressionValue(value, "proto.value");
                        ConstantValue resolveValue = resolveValue(type, value, nameResolver);
                        if (doesValueConformToExpectedType(resolveValue, type, value)) {
                            obj2 = resolveValue;
                        }
                        if (obj == 0) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected argument value: actual type ");
                            outline73.append(value.type_);
                            outline73.append(" != expected type ");
                            outline73.append(type);
                            String sb = outline73.toString();
                            Intrinsics.checkNotNullParameter(sb, "message");
                            obj = new ErrorValueWithMessage(sb);
                        }
                        obj2 = new Pair(name, obj);
                    }
                    if (obj2 != 0) {
                        arrayList.add(obj2);
                    }
                }
                emptyMap = ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) arrayList);
            }
        }
        return new AnnotationDescriptorImpl(findNonGenericClassAcrossDependencies.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    public final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, Value value) {
        int i;
        Type type = value.type_;
        if (type == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i == 10) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
                return true;
            }
        } else if (i != 13) {
            return Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
        } else {
            if ((constantValue instanceof ArrayValue) && ((List) ((ArrayValue) constantValue).value).size() == value.arrayElement_.size()) {
                KotlinType arrayElementType = this.module.getBuiltIns().getArrayElementType(kotlinType);
                Intrinsics.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                ArrayValue arrayValue = (ArrayValue) constantValue;
                Collection collection = (Collection) arrayValue.value;
                Intrinsics.checkNotNullParameter(collection, "<this>");
                IntRange intRange = new IntRange(0, collection.size() - 1);
                if ((intRange instanceof Collection) && ((Collection) intRange).isEmpty()) {
                    return true;
                }
                IntIterator it = intRange.iterator();
                while (((IntProgressionIterator) it).hasNext) {
                    int nextInt = it.nextInt();
                    Value value2 = value.arrayElement_.get(nextInt);
                    Intrinsics.checkNotNullExpressionValue(value2, "value.getArrayElement(i)");
                    if (!doesValueConformToExpectedType((ConstantValue) ((List) arrayValue.value).get(nextInt), arrayElementType, value2)) {
                    }
                }
                return true;
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Deserialized ArrayValue should have the same number of elements as the original array value: ", constantValue).toString());
        }
        return false;
    }

    public final ConstantValue<?> resolveValue(KotlinType kotlinType, Value value, NameResolver nameResolver) {
        int i;
        ConstantValue<?> constantValue;
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Intrinsics.checkNotNullParameter(value, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        boolean outline108 = GeneratedOutlineSupport.outline108(Flags.IS_UNSIGNED, value.flags_, "IS_UNSIGNED.get(value.flags)");
        Type type = value.type_;
        if (type == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        switch (i) {
            case 1:
                byte b2 = (byte) ((int) value.intValue_);
                return outline108 ? new UByteValue(b2) : new ByteValue(b2);
            case 2:
                constantValue = new CharValue<>((char) ((int) value.intValue_));
                break;
            case 3:
                short s = (short) ((int) value.intValue_);
                return outline108 ? new UShortValue(s) : new ShortValue(s);
            case 4:
                int i2 = (int) value.intValue_;
                if (!outline108) {
                    constantValue = new IntValue<>(i2);
                    break;
                } else {
                    constantValue = new UIntValue<>(i2);
                    break;
                }
            case 5:
                long j = value.intValue_;
                return outline108 ? new ULongValue<>(j) : new LongValue<>(j);
            case 6:
                constantValue = new FloatValue<>(value.floatValue_);
                break;
            case 7:
                constantValue = new DoubleValue<>(value.doubleValue_);
                break;
            case 8:
                new BooleanValue<>(value.intValue_ != 0);
                break;
            case 9:
                constantValue = new StringValue<>(nameResolver.getString(value.stringValue_));
                break;
            case 10:
                constantValue = new KClassValue<>(TweetUtils.getClassId(nameResolver, value.classId_), value.arrayDimensionCount_);
                break;
            case 11:
                constantValue = new EnumValue<>(TweetUtils.getClassId(nameResolver, value.classId_), TweetUtils.getName(nameResolver, value.enumValueId_));
                break;
            case 12:
                ProtoBuf$Annotation protoBuf$Annotation = value.annotation_;
                Intrinsics.checkNotNullExpressionValue(protoBuf$Annotation, "value.annotation");
                constantValue = new AnnotationValue<>(deserializeAnnotation(protoBuf$Annotation, nameResolver));
                break;
            case 13:
                List<Value> list = value.arrayElement_;
                Intrinsics.checkNotNullExpressionValue(list, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
                for (Value value2 : list) {
                    SimpleType anyType = this.module.getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics.checkNotNullExpressionValue(value2, "it");
                    arrayList.add(resolveValue(anyType, value2, nameResolver));
                }
                Intrinsics.checkNotNullParameter(arrayList, HSLCriteriaBuilder.VALUE);
                Intrinsics.checkNotNullParameter(kotlinType, "type");
                return new ArrayValue(arrayList, new ConstantValueFactory$createArrayValue$1(kotlinType));
            default:
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported annotation argument type: ");
                outline73.append(value.type_);
                outline73.append(" (expected ");
                outline73.append(kotlinType);
                outline73.append(')');
                throw new IllegalStateException(outline73.toString().toString());
        }
        return constantValue;
    }
}
