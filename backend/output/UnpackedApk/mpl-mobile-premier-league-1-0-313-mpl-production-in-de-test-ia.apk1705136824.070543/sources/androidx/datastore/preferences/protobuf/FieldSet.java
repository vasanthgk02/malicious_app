package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal.EnumLite;
import androidx.datastore.preferences.protobuf.LazyField.LazyIterator;
import androidx.datastore.preferences.protobuf.MessageLite.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class FieldSet<T extends FieldDescriptorLite<T>> {
    public static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    public final SmallSortedMap<T, Object> fields = SmallSortedMap.newFieldMap(16);
    public boolean hasLazyField;
    public boolean isImmutable;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        WireFormat$JavaType getLiteJavaType();

        WireFormat$FieldType getLiteType();

        int getNumber();

        Builder internalMergeFrom(Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    public FieldSet() {
    }

    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int computeElementSize(WireFormat$FieldType wireFormat$FieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeElementSizeNoTag(wireFormat$FieldType, obj) + computeTagSize;
    }

    public static int computeElementSizeNoTag(WireFormat$FieldType wireFormat$FieldType, Object obj) {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                CodedOutputStream.computeDoubleSizeNoTag();
                return 8;
            case 1:
                ((Float) obj).floatValue();
                CodedOutputStream.computeFloatSizeNoTag();
                return 4;
            case 2:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                CodedOutputStream.computeFixed64SizeNoTag();
                return 8;
            case 6:
                ((Integer) obj).intValue();
                CodedOutputStream.computeFixed32SizeNoTag();
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                CodedOutputStream.computeBoolSizeNoTag();
                return 1;
            case 8:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                if (obj instanceof EnumLite) {
                    return CodedOutputStream.computeInt32SizeNoTag(((EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                CodedOutputStream.computeSFixed32SizeNoTag();
                return 4;
            case 15:
                ((Long) obj).longValue();
                CodedOutputStream.computeSFixed64SizeNoTag();
                return 8;
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat$FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        int i = 0;
        if (fieldDescriptorLite.isPacked()) {
            for (Object computeElementSizeNoTag : (List) obj) {
                i += computeElementSizeNoTag(liteType, computeElementSizeNoTag);
            }
            return CodedOutputStream.computeTagSize(number) + i + CodedOutputStream.computeUInt32SizeNoTag(i);
        }
        for (Object computeElementSize : (List) obj) {
            i += computeElementSize(liteType, number, computeElementSize);
        }
        return i;
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, int i, Object obj) throws IOException {
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            codedOutputStream.writeTag(i, 3);
            ((MessageLite) obj).writeTo(codedOutputStream);
            codedOutputStream.writeTag(i, 4);
            return;
        }
        codedOutputStream.writeTag(i, wireFormat$FieldType.getWireType());
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                codedOutputStream.writeFixed64NoTag(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                codedOutputStream.writeFixed32NoTag(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 3:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 5:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 6:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 7:
                codedOutputStream.write(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                }
            case 9:
                ((MessageLite) obj).writeTo(codedOutputStream);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                codedOutputStream.writeByteArrayNoTag(bArr, 0, bArr.length);
                return;
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof EnumLite) {
                    codedOutputStream.writeInt32NoTag(((EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                    return;
                }
            case 14:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeUInt32NoTag(CodedOutputStream.encodeZigZag32(((Integer) obj).intValue()));
                return;
            case 17:
                codedOutputStream.writeUInt64NoTag(CodedOutputStream.encodeZigZag64(((Long) obj).longValue()));
                return;
            default:
                return;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.fields.equals(((FieldSet) obj).fields);
    }

    public Object getField(T t) {
        Object obj = this.fields.get(t);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public final int getMessageSetSerializedSize(Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
            return computeFieldSize(fieldDescriptorLite, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value) + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeUInt32Size(2, ((FieldDescriptorLite) entry.getKey()).getNumber()) + (CodedOutputStream.computeTagSize(1) * 2);
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(((MessageLite) value).getSerializedSize()) + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeUInt32Size(2, ((FieldDescriptorLite) entry.getKey()).getNumber()) + (CodedOutputStream.computeTagSize(1) * 2);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Entry isInitialized : this.fields.getOverflowEntries()) {
            if (!isInitialized(isInitialized)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Entry<T, Object>> iterator() {
        if (this.hasLazyField) {
            return new LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public final void mergeFromField(Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (fieldDescriptorLite.isRepeated()) {
            Object field = getField(fieldDescriptorLite);
            if (field == null) {
                field = new ArrayList();
            }
            for (Object cloneIfMutable : (List) value) {
                ((List) field).add(cloneIfMutable(cloneIfMutable));
            }
            this.fields.put(fieldDescriptorLite, field);
        } else if (fieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            Object field2 = getField(fieldDescriptorLite);
            if (field2 == null) {
                this.fields.put(fieldDescriptorLite, cloneIfMutable(value));
                return;
            }
            this.fields.put(fieldDescriptorLite, ((GeneratedMessageLite.Builder) fieldDescriptorLite.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value)).build());
        } else {
            this.fields.put(fieldDescriptorLite, cloneIfMutable(value));
        }
    }

    public void setField(T t, Object obj) {
        if (!t.isRepeated()) {
            verifyType(t.getLiteType(), obj);
            r5 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(t.getLiteType(), it.next());
            }
            r5 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r5 instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(t, r5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if ((r4 instanceof androidx.datastore.preferences.protobuf.LazyField) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r4 instanceof androidx.datastore.preferences.protobuf.Internal.EnumLite) == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void verifyType(androidx.datastore.preferences.protobuf.WireFormat$FieldType r3, java.lang.Object r4) {
        /*
            r2 = this;
            androidx.datastore.preferences.protobuf.Internal.checkNotNull(r4)
            androidx.datastore.preferences.protobuf.WireFormat$JavaType r3 = r3.getJavaType()
            int r3 = r3.ordinal()
            r0 = 1
            r1 = 0
            switch(r3) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003b;
                case 2: goto L_0x0038;
                case 3: goto L_0x0035;
                case 4: goto L_0x0032;
                case 5: goto L_0x002f;
                case 6: goto L_0x0023;
                case 7: goto L_0x001a;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0040
        L_0x0011:
            boolean r3 = r4 instanceof androidx.datastore.preferences.protobuf.MessageLite
            if (r3 != 0) goto L_0x002d
            boolean r3 = r4 instanceof androidx.datastore.preferences.protobuf.LazyField
            if (r3 == 0) goto L_0x002c
            goto L_0x002d
        L_0x001a:
            boolean r3 = r4 instanceof java.lang.Integer
            if (r3 != 0) goto L_0x002d
            boolean r3 = r4 instanceof androidx.datastore.preferences.protobuf.Internal.EnumLite
            if (r3 == 0) goto L_0x002c
            goto L_0x002d
        L_0x0023:
            boolean r3 = r4 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r3 != 0) goto L_0x002d
            boolean r3 = r4 instanceof byte[]
            if (r3 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            r1 = r0
            goto L_0x0040
        L_0x002f:
            boolean r1 = r4 instanceof java.lang.String
            goto L_0x0040
        L_0x0032:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L_0x0040
        L_0x0035:
            boolean r1 = r4 instanceof java.lang.Double
            goto L_0x0040
        L_0x0038:
            boolean r1 = r4 instanceof java.lang.Float
            goto L_0x0040
        L_0x003b:
            boolean r1 = r4 instanceof java.lang.Long
            goto L_0x0040
        L_0x003e:
            boolean r1 = r4 instanceof java.lang.Integer
        L_0x0040:
            if (r1 == 0) goto L_0x0043
            return
        L_0x0043:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Wrong object type used with protocol message reflection."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldSet.verifyType(androidx.datastore.preferences.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public FieldSet<T> clone() {
        FieldSet<T> fieldSet = new FieldSet<>();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Entry arrayEntryAt = this.fields.getArrayEntryAt(i);
            fieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Entry entry : this.fields.getOverflowEntries()) {
            fieldSet.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSet.hasLazyField = this.hasLazyField;
        return fieldSet;
    }

    public FieldSet(boolean z) {
        makeImmutable();
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Entry<T, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            if (fieldDescriptorLite.isRepeated()) {
                for (MessageLite isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof LazyField) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }
}
