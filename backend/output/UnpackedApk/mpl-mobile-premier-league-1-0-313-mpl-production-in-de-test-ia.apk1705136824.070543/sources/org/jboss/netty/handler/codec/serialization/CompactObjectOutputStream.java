package org.jboss.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

public class CompactObjectOutputStream extends ObjectOutputStream {
    public static final int TYPE_FAT_DESCRIPTOR = 0;
    public static final int TYPE_THIN_DESCRIPTOR = 1;

    public CompactObjectOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> forClass = objectStreamClass.forClass();
        if (forClass.isPrimitive() || forClass.isArray()) {
            write(0);
            super.writeClassDescriptor(objectStreamClass);
            return;
        }
        write(1);
        writeUTF(objectStreamClass.getName());
    }

    public void writeStreamHeader() throws IOException {
        writeByte(5);
    }
}
