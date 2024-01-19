package org.jboss.netty.handler.codec.serialization;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class SwitchableInputStream extends FilterInputStream {
    public SwitchableInputStream() {
        super(null);
    }

    public void switchStream(InputStream inputStream) {
        this.in = inputStream;
    }
}
