package com.google.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import com.google.protobuf.ByteString.CodedBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    public int memoizedHashCode = 0;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements com.google.protobuf.MessageLite.Builder {
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        Internal.checkNotNull(iterable);
        if (iterable instanceof LazyStringList) {
            List<?> underlyingElements = ((LazyStringList) iterable).getUnderlyingElements();
            LazyStringList lazyStringList = (LazyStringList) list;
            int size = list.size();
            for (Object next : underlyingElements) {
                if (next == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Element at index ");
                    outline73.append(lazyStringList.size() - size);
                    outline73.append(" is null.");
                    String sb = outline73.toString();
                    int size2 = lazyStringList.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            lazyStringList.remove(size2);
                        } else {
                            throw new NullPointerException(sb);
                        }
                    }
                } else if (next instanceof ByteString) {
                    lazyStringList.add((ByteString) next);
                } else {
                    lazyStringList.add((String) next);
                }
            }
        } else if (iterable instanceof PrimitiveNonBoxingCollection) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Element at index ");
                    outline732.append(list.size() - size3);
                    outline732.append(" is null.");
                    String sb2 = outline732.toString();
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        }
    }

    public int getSerializedSize(Schema schema) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this;
        int i = generatedMessageLite.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int serializedSize = schema.getSerializedSize(this);
        generatedMessageLite.memoizedSerializedSize = serializedSize;
        return serializedSize;
    }

    public final String getSerializingExceptionMessage(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Serializing ");
        outline73.append(getClass().getName());
        outline73.append(" to a ");
        outline73.append(str);
        outline73.append(" threw an IOException (should never happen).");
        return outline73.toString();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            if (newInstance.spaceLeft() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e2);
        }
    }

    public ByteString toByteString() {
        try {
            CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.output);
            return newCodedBuilder.build();
        } catch (IOException e2) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e2);
        }
    }
}
