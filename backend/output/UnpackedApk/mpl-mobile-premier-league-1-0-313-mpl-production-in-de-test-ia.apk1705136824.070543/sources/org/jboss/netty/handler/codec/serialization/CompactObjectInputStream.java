package org.jboss.netty.handler.codec.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

public class CompactObjectInputStream extends ObjectInputStream {
    public final ClassLoader classLoader;

    public CompactObjectInputStream(InputStream inputStream) throws IOException {
        this(inputStream, null);
    }

    public Class<?> loadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader2 = this.classLoader;
        if (classLoader2 == null) {
            classLoader2 = Thread.currentThread().getContextClassLoader();
        }
        if (classLoader2 != null) {
            return classLoader2.loadClass(str);
        }
        return Class.forName(str);
    }

    public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int read = read();
        if (read < 0) {
            throw new EOFException();
        } else if (read == 0) {
            return super.readClassDescriptor();
        } else {
            if (read == 1) {
                return ObjectStreamClass.lookup(loadClass(readUTF()));
            }
            throw new StreamCorruptedException(GeneratedOutlineSupport.outline41("Unexpected class descriptor type: ", read));
        }
    }

    public void readStreamHeader() throws IOException, StreamCorruptedException {
        byte readByte = readByte() & 255;
        if (readByte != 5) {
            throw new StreamCorruptedException(GeneratedOutlineSupport.outline41("Unsupported version: ", readByte));
        }
    }

    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return loadClass(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }

    public CompactObjectInputStream(InputStream inputStream, ClassLoader classLoader2) throws IOException {
        super(inputStream);
        this.classLoader = classLoader2;
    }
}
