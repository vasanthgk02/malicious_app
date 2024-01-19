package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends InputStream {
    public int counter = 0;

    /* renamed from: in  reason: collision with root package name */
    public InputStream f6152in;

    public CountingInputStream(InputStream inputStream) {
        this.f6152in = inputStream;
    }

    public int getCounter() {
        return this.counter;
    }

    public int read() throws IOException {
        int read = this.f6152in.read();
        if (read != -1) {
            this.counter++;
        }
        return read;
    }

    public void resetCounter() {
        this.counter = 0;
    }
}
