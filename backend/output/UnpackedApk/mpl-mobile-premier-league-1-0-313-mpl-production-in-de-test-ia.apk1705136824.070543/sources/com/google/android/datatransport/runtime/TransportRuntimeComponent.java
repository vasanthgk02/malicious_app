package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;

public abstract class TransportRuntimeComponent implements Closeable {
    public void close() throws IOException {
        ((EventStore) ((DaggerTransportRuntimeComponent) this).sQLiteEventStoreProvider.get()).close();
    }
}
