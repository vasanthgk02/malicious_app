package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;

public class FixedReceiveBufferSizePredictor implements ReceiveBufferSizePredictor {
    public final int bufferSize;

    public FixedReceiveBufferSizePredictor(int i) {
        if (i > 0) {
            this.bufferSize = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("bufferSize must greater than 0: ", i));
    }

    public int nextReceiveBufferSize() {
        return this.bufferSize;
    }

    public void previousReceiveBufferSize(int i) {
    }
}
