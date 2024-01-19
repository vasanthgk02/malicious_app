package kotlin.reflect.jvm.internal.impl.protobuf;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder;

public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    public static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    public final SmallSortedMap<FieldDescriptorType, Object> fields = new SmallSortedMap<FieldDescriptorType, Object>(16) {
        public void makeImmutable() {
            if (!this.isImmutable) {
                for (int i = 0; i < getNumArrayEntries(); i++) {
                    java.util.Map.Entry arrayEntryAt = getArrayEntryAt(i);
                    if (((FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                        arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                    }
                }
                for (java.util.Map.Entry entry : getOverflowEntries()) {
                    if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            SmallSortedMap.super.makeImmutable();
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return SmallSortedMap.super.put((FieldDescriptorLite) obj, obj2);
        }
    };
    public boolean hasLazyField = false;
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

    public static int computeElementSizeNoTag(WireFormat$FieldType wireFormat$FieldType, Object obj) {
        int i;
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                return 8;
            case 1:
                ((Float) obj).floatValue();
                return 4;
            case 2:
                return CodedOutputStream.computeRawVarint64Size(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeRawVarint64Size(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                return 8;
            case 6:
                ((Integer) obj).intValue();
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                return 1;
            case 8:
                try {
                    byte[] bytes = ((String) obj).getBytes("UTF-8");
                    return CodedOutputStream.computeRawVarint32Size(bytes.length) + bytes.length;
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("UTF-8 not supported.", e2);
                }
            case 9:
                return ((MessageLite) obj).getSerializedSize();
            case 10:
                if (!(obj instanceof LazyField)) {
                    return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
                }
                LazyField lazyField = (LazyField) obj;
                if (lazyField.isDirty) {
                    i = lazyField.value.getSerializedSize();
                } else {
                    i = lazyField.bytes.size();
                }
                return CodedOutputStream.computeRawVarint32Size(i) + i;
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                byte[] bArr = (byte[]) obj;
                return CodedOutputStream.computeRawVarint32Size(bArr.length) + bArr.length;
            case 12:
                return CodedOutputStream.computeRawVarint32Size(((Integer) obj).intValue());
            case 13:
                if (obj instanceof EnumLite) {
                    return CodedOutputStream.computeInt32SizeNoTag(((EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return 4;
            case 15:
                ((Long) obj).longValue();
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return CodedOutputStream.computeRawVarint32Size((intValue >> 31) ^ (intValue << 1));
            case 17:
                long longValue = ((Long) obj).longValue();
                return CodedOutputStream.computeRawVarint64Size((longValue >> 63) ^ (longValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        int computeTagSize;
        int computeElementSizeNoTag;
        WireFormat$FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            int i = 0;
            if (fieldDescriptorLite.isPacked()) {
                for (Object computeElementSizeNoTag2 : (List) obj) {
                    i += computeElementSizeNoTag(liteType, computeElementSizeNoTag2);
                }
                computeTagSize = CodedOutputStream.computeTagSize(number) + i;
                computeElementSizeNoTag = CodedOutputStream.computeRawVarint32Size(i);
            } else {
                for (Object next : (List) obj) {
                    int computeTagSize2 = CodedOutputStream.computeTagSize(number);
                    if (liteType == WireFormat$FieldType.GROUP) {
                        computeTagSize2 *= 2;
                    }
                    i += computeElementSizeNoTag(liteType, next) + computeTagSize2;
                }
                return i;
            }
        } else {
            computeTagSize = CodedOutputStream.computeTagSize(number);
            if (liteType == WireFormat$FieldType.GROUP) {
                computeTagSize *= 2;
            }
            computeElementSizeNoTag = computeElementSizeNoTag(liteType, obj);
        }
        return computeElementSizeNoTag + computeTagSize;
    }

    public static int getWireFormatForFieldType(WireFormat$FieldType wireFormat$FieldType, boolean z) {
        if (z) {
            return 2;
        }
        return wireFormat$FieldType.getWireType();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat$FieldType wireFormat$FieldType, boolean z) throws IOException {
        byte[] bArr;
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(codedInputStream.readRawLittleEndian64()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(codedInputStream.readRawLittleEndian32()));
            case 2:
                return Long.valueOf(codedInputStream.readRawVarint64());
            case 3:
                return Long.valueOf(codedInputStream.readRawVarint64());
            case 4:
                return Integer.valueOf(codedInputStream.readRawVarint32());
            case 5:
                return Long.valueOf(codedInputStream.readRawLittleEndian64());
            case 6:
                return Integer.valueOf(codedInputStream.readRawLittleEndian32());
            case 7:
                return Boolean.valueOf(codedInputStream.readBool());
            case 8:
                String str = "";
                if (z) {
                    int readRawVarint32 = codedInputStream.readRawVarint32();
                    int i = codedInputStream.bufferPos;
                    if (readRawVarint32 > codedInputStream.bufferSize - i || readRawVarint32 <= 0) {
                        if (readRawVarint32 != 0) {
                            bArr = codedInputStream.readRawBytesSlowPath(readRawVarint32);
                            i = 0;
                        }
                        return str;
                    }
                    bArr = codedInputStream.buffer;
                    codedInputStream.bufferPos = i + readRawVarint32;
                    if (TweetUtils.isValidUtf8(bArr, i, i + readRawVarint32)) {
                        str = new String(bArr, i, readRawVarint32, "UTF-8");
                        return str;
                    }
                    throw new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
                }
                int readRawVarint322 = codedInputStream.readRawVarint32();
                if (readRawVarint322 <= codedInputStream.bufferSize - codedInputStream.bufferPos && readRawVarint322 > 0) {
                    str = new String(codedInputStream.buffer, codedInputStream.bufferPos, readRawVarint322, "UTF-8");
                    codedInputStream.bufferPos += readRawVarint322;
                } else if (readRawVarint322 != 0) {
                    str = new String(codedInputStream.readRawBytesSlowPath(readRawVarint322), "UTF-8");
                }
                return str;
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return codedInputStream.readBytes();
            case 12:
                return Integer.valueOf(codedInputStream.readRawVarint32());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(codedInputStream.readRawLittleEndian32());
            case 15:
                return Long.valueOf(codedInputStream.readRawLittleEndian64());
            case 16:
                int readRawVarint323 = codedInputStream.readRawVarint32();
                return Integer.valueOf((-(readRawVarint323 & 1)) ^ (readRawVarint323 >>> 1));
            case 17:
                long readRawVarint64 = codedInputStream.readRawVarint64();
                return Long.valueOf((-(readRawVarint64 & 1)) ^ (readRawVarint64 >>> 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void verifyType(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r2, java.lang.Object r3) {
        /*
            if (r3 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r0 = 1
            r1 = 0
            switch(r2) {
                case 0: goto L_0x003d;
                case 1: goto L_0x003a;
                case 2: goto L_0x0037;
                case 3: goto L_0x0034;
                case 4: goto L_0x0031;
                case 5: goto L_0x002e;
                case 6: goto L_0x0022;
                case 7: goto L_0x0019;
                case 8: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x003f
        L_0x0010:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            if (r2 != 0) goto L_0x002c
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField
            if (r2 == 0) goto L_0x002b
            goto L_0x002c
        L_0x0019:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x002c
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            if (r2 == 0) goto L_0x002b
            goto L_0x002c
        L_0x0022:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.ByteString
            if (r2 != 0) goto L_0x002c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            r1 = r0
            goto L_0x003f
        L_0x002e:
            boolean r1 = r3 instanceof java.lang.String
            goto L_0x003f
        L_0x0031:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L_0x003f
        L_0x0034:
            boolean r1 = r3 instanceof java.lang.Double
            goto L_0x003f
        L_0x0037:
            boolean r1 = r3 instanceof java.lang.Float
            goto L_0x003f
        L_0x003a:
            boolean r1 = r3 instanceof java.lang.Long
            goto L_0x003f
        L_0x003d:
            boolean r1 = r3 instanceof java.lang.Integer
        L_0x003f:
            if (r1 == 0) goto L_0x0042
            return
        L_0x0042:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L_0x004a:
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.verifyType(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, int i, Object obj) throws IOException {
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            int i2 = i << 3;
            codedOutputStream.writeRawVarint32(i2 | 3);
            ((MessageLite) obj).writeTo(codedOutputStream);
            codedOutputStream.writeRawVarint32(i2 | 4);
            return;
        }
        codedOutputStream.writeRawVarint32((i << 3) | getWireFormatForFieldType(wireFormat$FieldType, false));
        writeElementNoTag(codedOutputStream, wireFormat$FieldType, obj);
    }

    public static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, Object obj) throws IOException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                codedOutputStream.writeRawLittleEndian64(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                codedOutputStream.writeRawLittleEndian32(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                codedOutputStream.writeRawVarint64(((Long) obj).longValue());
                return;
            case 3:
                codedOutputStream.writeRawVarint64(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 5:
                codedOutputStream.writeRawLittleEndian64(((Long) obj).longValue());
                return;
            case 6:
                codedOutputStream.writeRawLittleEndian32(((Integer) obj).intValue());
                return;
            case 7:
                codedOutputStream.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case 8:
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                codedOutputStream.writeRawVarint32(bytes.length);
                codedOutputStream.writeRawBytes(bytes);
                return;
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
                codedOutputStream.writeRawVarint32(bArr.length);
                codedOutputStream.writeRawBytes(bArr);
                return;
            case 12:
                codedOutputStream.writeRawVarint32(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof EnumLite) {
                    codedOutputStream.writeEnumNoTag(((EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            case 14:
                codedOutputStream.writeRawLittleEndian32(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeRawLittleEndian64(((Long) obj).longValue());
                return;
            case 16:
                int intValue = ((Integer) obj).intValue();
                codedOutputStream.writeRawVarint32((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) obj).longValue();
                codedOutputStream.writeRawVarint64((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat$FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int i = 0;
                for (Object computeElementSizeNoTag : list) {
                    i += computeElementSizeNoTag(liteType, computeElementSizeNoTag);
                }
                codedOutputStream.writeRawVarint32(i);
                for (Object writeElementNoTag : list) {
                    writeElementNoTag(codedOutputStream, liteType, writeElementNoTag);
                }
                return;
            }
            for (Object writeElement : list) {
                writeElement(codedOutputStream, liteType, number, writeElement);
            }
        } else if (obj instanceof LazyField) {
            writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            writeElement(codedOutputStream, liteType, number, obj);
        }
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.isRepeated()) {
            verifyType(fielddescriptortype.getLiteType(), obj);
            Object field = getField(fielddescriptortype);
            if (field == null) {
                list = new ArrayList();
                this.fields.put(fielddescriptortype, list);
            } else {
                list = (List) field;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public final Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.fields.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
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

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public final void mergeFromField(Entry<FieldDescriptorType, Object> entry) {
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
            this.fields.put(fieldDescriptorLite, fieldDescriptorLite.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        } else {
            this.fields.put(fieldDescriptorLite, cloneIfMutable(value));
        }
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            verifyType(fielddescriptortype.getLiteType(), obj);
            r5 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(fielddescriptortype.getLiteType(), it.next());
            }
            r5 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r5 instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(fielddescriptortype, r5);
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> fieldSet = new FieldSet<>();
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
    }

    public final boolean isInitialized(Entry<FieldDescriptorType, Object> entry) {
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
