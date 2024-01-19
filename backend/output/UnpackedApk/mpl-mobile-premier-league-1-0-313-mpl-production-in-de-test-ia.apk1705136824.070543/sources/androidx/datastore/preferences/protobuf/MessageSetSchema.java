package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension;
import androidx.datastore.preferences.protobuf.LazyField.LazyEntry;
import androidx.datastore.preferences.protobuf.Writer.FieldOrder;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public final class MessageSetSchema<T> implements Schema<T> {
    public final MessageLite defaultInstance;
    public final ExtensionSchema<?> extensionSchema;
    public final boolean hasExtensions;
    public final UnknownFieldSchema<?, ?> unknownFieldSchema;

    public MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema2;
        if (((ExtensionSchemaLite) extensionSchema2) != null) {
            this.hasExtensions = messageLite instanceof ExtendableMessage;
            this.extensionSchema = extensionSchema2;
            this.defaultInstance = messageLite;
            return;
        }
        throw null;
    }

    public boolean equals(T t, T t2) {
        UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = (UnknownFieldSetLiteSchema) this.unknownFieldSchema;
        if (unknownFieldSetLiteSchema != null) {
            UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) t).unknownFields;
            if (unknownFieldSetLiteSchema == null) {
                throw null;
            } else if (!unknownFieldSetLite.equals(((GeneratedMessageLite) t2).unknownFields)) {
                return false;
            } else {
                if (!this.hasExtensions) {
                    return true;
                }
                ExtensionSchemaLite extensionSchemaLite = (ExtensionSchemaLite) this.extensionSchema;
                if (extensionSchemaLite != null) {
                    FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) t).extensions;
                    if (extensionSchemaLite != null) {
                        return fieldSet.equals(((ExtendableMessage) t2).extensions);
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    public int getSerializedSize(T t) {
        if (((UnknownFieldSetLiteSchema) this.unknownFieldSchema) != null) {
            UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) t).unknownFields;
            int i = unknownFieldSetLite.memoizedSerializedSize;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < unknownFieldSetLite.count; i2++) {
                    int computeUInt32Size = CodedOutputStream.computeUInt32Size(2, unknownFieldSetLite.tags[i2] >>> 3);
                    i += CodedOutputStream.computeBytesSize(3, (ByteString) unknownFieldSetLite.objects[i2]) + computeUInt32Size + (CodedOutputStream.computeTagSize(1) * 2);
                }
                unknownFieldSetLite.memoizedSerializedSize = i;
            }
            int i3 = i + 0;
            if (!this.hasExtensions) {
                return i3;
            }
            if (((ExtensionSchemaLite) this.extensionSchema) != null) {
                FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) t).extensions;
                int i4 = 0;
                for (int i5 = 0; i5 < fieldSet.fields.getNumArrayEntries(); i5++) {
                    i4 += fieldSet.getMessageSetSerializedSize(fieldSet.fields.getArrayEntryAt(i5));
                }
                for (Entry messageSetSerializedSize : fieldSet.fields.getOverflowEntries()) {
                    i4 += fieldSet.getMessageSetSerializedSize(messageSetSerializedSize);
                }
                return i3 + i4;
            }
            throw null;
        }
        throw null;
    }

    public int hashCode(T t) {
        if (((UnknownFieldSetLiteSchema) this.unknownFieldSchema) != null) {
            int hashCode = ((GeneratedMessageLite) t).unknownFields.hashCode();
            if (!this.hasExtensions) {
                return hashCode;
            }
            if (((ExtensionSchemaLite) this.extensionSchema) != null) {
                return (hashCode * 53) + ((ExtendableMessage) t).extensions.hashCode();
            }
            throw null;
        }
        throw null;
    }

    public final boolean isInitialized(T t) {
        if (((ExtensionSchemaLite) this.extensionSchema) != null) {
            return ((ExtendableMessage) t).extensions.isInitialized();
        }
        throw null;
    }

    public void makeImmutable(T t) {
        if (((UnknownFieldSetLiteSchema) this.unknownFieldSchema) != null) {
            ((GeneratedMessageLite) t).unknownFields.isMutable = false;
            if (((ExtensionSchemaLite) this.extensionSchema) != null) {
                ((ExtendableMessage) t).extensions.makeImmutable();
                return;
            }
            throw null;
        }
        throw null;
    }

    public void mergeFrom(T t, T t2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    public T newInstance() {
        return ((Builder) this.defaultInstance.newBuilderForType()).buildPartial();
    }

    public final <UT, UB, ET extends FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema2, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema2, UB ub) throws IOException {
        int tag = reader.getTag();
        if (tag == 11) {
            int i = 0;
            Object obj = null;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == 16) {
                    i = reader.readUInt32();
                    obj = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, i);
                } else if (tag2 == 26) {
                    if (obj != null) {
                        ExtensionSchemaLite extensionSchemaLite = (ExtensionSchemaLite) extensionSchema2;
                        GeneratedExtension generatedExtension = (GeneratedExtension) obj;
                        throw null;
                    }
                    byteString = reader.readBytes();
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == 12) {
                if (byteString != null) {
                    if (obj != null) {
                        ExtensionSchemaLite extensionSchemaLite2 = (ExtensionSchemaLite) extensionSchema2;
                        GeneratedExtension generatedExtension2 = (GeneratedExtension) obj;
                        throw null;
                    }
                    unknownFieldSchema2.addLengthDelimited(ub, i, byteString);
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if ((tag & 7) != 2) {
            return reader.skipField();
        } else {
            Object findExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, tag >>> 3);
            if (findExtensionByNumber == null) {
                return unknownFieldSchema2.mergeOneFieldFrom(ub, reader);
            }
            GeneratedExtension generatedExtension3 = (GeneratedExtension) findExtensionByNumber;
            throw null;
        }
    }

    public void writeTo(T t, Writer writer) throws IOException {
        if (((ExtensionSchemaLite) this.extensionSchema) != null) {
            Iterator it = ((ExtendableMessage) t).extensions.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
                if (fieldDescriptorLite.getLiteJavaType() != WireFormat$JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                    throw new IllegalStateException("Found invalid MessageSet item.");
                } else if (entry instanceof LazyEntry) {
                    ((CodedOutputStreamWriter) writer).writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyEntry) entry).entry.getValue().toByteString());
                } else {
                    ((CodedOutputStreamWriter) writer).writeMessageSetItem(fieldDescriptorLite.getNumber(), entry.getValue());
                }
            }
            if (((UnknownFieldSetLiteSchema) this.unknownFieldSchema) != null) {
                UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) t).unknownFields;
                if (unknownFieldSetLite != null) {
                    CodedOutputStreamWriter codedOutputStreamWriter = (CodedOutputStreamWriter) writer;
                    if (codedOutputStreamWriter == null) {
                        throw null;
                    } else if (FieldOrder.ASCENDING == FieldOrder.DESCENDING) {
                        int i = unknownFieldSetLite.count;
                        while (true) {
                            i--;
                            if (i >= 0) {
                                codedOutputStreamWriter.writeMessageSetItem(unknownFieldSetLite.tags[i] >>> 3, unknownFieldSetLite.objects[i]);
                            } else {
                                return;
                            }
                        }
                    } else {
                        for (int i2 = 0; i2 < unknownFieldSetLite.count; i2++) {
                            codedOutputStreamWriter.writeMessageSetItem(unknownFieldSetLite.tags[i2] >>> 3, unknownFieldSetLite.objects[i2]);
                        }
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UnknownFieldSchema<?, ?> unknownFieldSchema2 = this.unknownFieldSchema;
        ExtensionSchema<?> extensionSchema2 = this.extensionSchema;
        Object builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t);
        FieldSet mutableExtensions = extensionSchema2.getMutableExtensions(t);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                unknownFieldSchema2.setBuilderToMessage(t, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema2, mutableExtensions, unknownFieldSchema2, builderFromMessage));
    }
}
