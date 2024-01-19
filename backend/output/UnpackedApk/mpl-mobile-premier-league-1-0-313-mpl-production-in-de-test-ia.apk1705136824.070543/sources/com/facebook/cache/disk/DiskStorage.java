package com.facebook.cache.disk;

import com.facebook.binaryresource.FileBinaryResource;
import java.io.IOException;
import java.util.Collection;

public interface DiskStorage {

    public interface Entry {
        String getId();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
    }

    void clearAll() throws IOException;

    boolean contains(String str, Object obj) throws IOException;

    Collection<Entry> getEntries() throws IOException;

    FileBinaryResource getResource(String str, Object obj) throws IOException;

    Inserter insert(String str, Object obj) throws IOException;

    boolean isExternal();

    void purgeUnexpectedResources();

    long remove(Entry entry) throws IOException;

    long remove(String str) throws IOException;
}
