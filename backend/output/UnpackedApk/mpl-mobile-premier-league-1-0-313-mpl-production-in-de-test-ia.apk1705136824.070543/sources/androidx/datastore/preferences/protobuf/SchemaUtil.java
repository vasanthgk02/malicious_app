package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor;
import androidx.datastore.preferences.protobuf.Internal.EnumVerifier;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.RandomAccess;

public final class SchemaUtil {
    public static final Class<?> GENERATED_MESSAGE_CLASS;
    public static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    public static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    public static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        GENERATED_MESSAGE_CLASS = cls;
    }

    public static int computeSizeBoolList(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return CodedOutputStream.computeBoolSize(i, true) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i2));
        }
        return computeTagSize;
    }

    public static int computeSizeEnumList(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeEnumListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeFixed32List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return CodedOutputStream.computeFixed32Size(i, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return CodedOutputStream.computeFixed64Size(i, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.computeGroupSize(i, list.get(i3), schema);
        }
        return i2;
    }

    public static int computeSizeInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeInt64List(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
        }
        return (CodedOutputStream.computeTagSize(i) * list.size()) + computeSizeInt64ListNoTag;
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeMessage(int i, Object obj, Schema schema) {
        int computeTagSize;
        int computeLengthDelimitedFieldSize;
        if (obj instanceof LazyFieldLite) {
            computeTagSize = CodedOutputStream.computeTagSize(i);
            computeLengthDelimitedFieldSize = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
        } else {
            computeTagSize = CodedOutputStream.computeTagSize(i);
            computeLengthDelimitedFieldSize = CodedOutputStream.computeLengthDelimitedFieldSize(((AbstractMessageLite) ((MessageLite) obj)).getSerializedSize(schema));
        }
        return computeLengthDelimitedFieldSize + computeTagSize;
    }

    public static int computeSizeMessageList(int i, List<?> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof LazyFieldLite) {
                computeTagSize = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) + computeTagSize;
            } else {
                computeTagSize += CodedOutputStream.computeLengthDelimitedFieldSize(((AbstractMessageLite) ((MessageLite) obj)).getSerializedSize(schema));
            }
        }
        return computeTagSize;
    }

    public static int computeSizeSInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeSInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeSInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeSInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeSInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeStringList(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i4 < size) {
                Object raw = lazyStringList.getRaw(i4);
                if (raw instanceof ByteString) {
                    i3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    i3 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize = i3 + computeTagSize;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof ByteString) {
                    i2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    i2 = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize = i2 + computeTagSize;
                i4++;
            }
        }
        return computeTagSize;
    }

    public static int computeSizeUInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeUInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int computeSizeUInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (!z) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeUInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB filterUnknownEnumList(int i, List<Integer> list, EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = storeUnknownEnum(i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = storeUnknownEnum(i, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        Class cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (UnknownFieldSchema) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        if (((ExtensionSchemaLite) extensionSchema) != null) {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) t2).extensions;
            if (!fieldSet.isEmpty()) {
                FieldSet mutableExtensions = extensionSchema.getMutableExtensions(t);
                if (mutableExtensions != null) {
                    for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
                        mutableExtensions.mergeFromField(fieldSet.fields.getArrayEntryAt(i));
                    }
                    for (Entry mergeFromField : fieldSet.fields.getOverflowEntries()) {
                        mutableExtensions.mergeFromField(mergeFromField);
                    }
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t, T t2, long j) {
        UnsafeUtil.MEMORY_ACCESSOR.putObject(t, j, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t, j), UnsafeUtil.getObject(t2, j)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        if (((UnknownFieldSetLiteSchema) unknownFieldSchema) != null) {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
            UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
            UnknownFieldSetLite unknownFieldSetLite2 = ((GeneratedMessageLite) t2).unknownFields;
            if (!unknownFieldSetLite2.equals(UnknownFieldSetLite.DEFAULT_INSTANCE)) {
                int i = unknownFieldSetLite.count + unknownFieldSetLite2.count;
                int[] copyOf = Arrays.copyOf(unknownFieldSetLite.tags, i);
                System.arraycopy(unknownFieldSetLite2.tags, 0, copyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.objects, i);
                System.arraycopy(unknownFieldSetLite2.objects, 0, copyOf2, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                unknownFieldSetLite = new UnknownFieldSetLite(i, copyOf, copyOf2, true);
            }
            generatedMessageLite.unknownFields = unknownFieldSetLite;
            return;
        }
        throw null;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            Class<?> cls2 = GENERATED_MESSAGE_CLASS;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB storeUnknownEnum(int i, int i2, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.newBuilder();
        }
        long j = (long) i2;
        if (((UnknownFieldSetLiteSchema) unknownFieldSchema) != null) {
            ((UnknownFieldSetLite) ub).storeField((i << 3) | 0, Long.valueOf(j));
            return ub;
        }
        throw null;
    }

    public static void writeBoolList(int i, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).booleanValue();
                        i3++;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.write(list.get(i2).booleanValue() ? (byte) 1 : 0);
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeBool(i, list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeBytesList(int i, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    codedOutputStreamWriter.output.writeBytes(i, list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void writeDoubleList(int i, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
                        double doubleValue = list.get(i2).doubleValue();
                        if (codedOutputStream != null) {
                            codedOutputStream.writeFixed64NoTag(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    CodedOutputStream codedOutputStream2 = codedOutputStreamWriter.output;
                    double doubleValue2 = list.get(i2).doubleValue();
                    if (codedOutputStream2 != null) {
                        codedOutputStream2.writeFixed64(i, Double.doubleToRawLongBits(doubleValue2));
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void writeEnumList(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeInt32NoTag(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeInt32(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeFixed32NoTag(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeFixed32(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeFixed64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeFixed64NoTag(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeFixed64(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeFloatList(int i, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
                        float floatValue = list.get(i2).floatValue();
                        if (codedOutputStream != null) {
                            codedOutputStream.writeFixed32NoTag(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    CodedOutputStream codedOutputStream2 = codedOutputStreamWriter.output;
                    float floatValue2 = list.get(i2).floatValue();
                    if (codedOutputStream2 != null) {
                        codedOutputStream2.writeFixed32(i, Float.floatToRawIntBits(floatValue2));
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void writeGroupList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    codedOutputStreamWriter.writeGroup(i, list.get(i2), schema);
                }
                return;
            }
            throw null;
        }
    }

    public static void writeInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeInt32NoTag(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeInt32(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeUInt64NoTag(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeUInt64(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    codedOutputStreamWriter.output.writeMessage(i, (MessageLite) list.get(i2), schema);
                }
                return;
            }
            throw null;
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeFixed32NoTag(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeFixed32(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeFixed64NoTag(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeFixed64(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeUInt32NoTag(CodedOutputStream.encodeZigZag32(list.get(i2).intValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeUInt32(i, CodedOutputStream.encodeZigZag32(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeSInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeUInt64NoTag(CodedOutputStream.encodeZigZag64(list.get(i2).longValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeUInt64(i, CodedOutputStream.encodeZigZag64(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeStringList(int i, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (list instanceof LazyStringList) {
                    LazyStringList lazyStringList = (LazyStringList) list;
                    while (i2 < list.size()) {
                        Object raw = lazyStringList.getRaw(i2);
                        if (raw instanceof String) {
                            codedOutputStreamWriter.output.writeString(i, (String) raw);
                        } else {
                            codedOutputStreamWriter.output.writeBytes(i, (ByteString) raw);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeString(i, list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeUInt32NoTag(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeUInt32(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void writeUInt64List(int i, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
            if (codedOutputStreamWriter != null) {
                int i2 = 0;
                if (z) {
                    codedOutputStreamWriter.output.writeTag(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
                    }
                    codedOutputStreamWriter.output.writeUInt32NoTag(i3);
                    while (i2 < list.size()) {
                        codedOutputStreamWriter.output.writeUInt64NoTag(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    codedOutputStreamWriter.output.writeUInt64(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }
}
