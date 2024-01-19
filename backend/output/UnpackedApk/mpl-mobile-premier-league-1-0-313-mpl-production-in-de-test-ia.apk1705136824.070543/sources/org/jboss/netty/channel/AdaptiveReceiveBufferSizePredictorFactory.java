package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;

public class AdaptiveReceiveBufferSizePredictorFactory implements ReceiveBufferSizePredictorFactory {
    public final int initial;
    public final int maximum;
    public final int minimum;

    public AdaptiveReceiveBufferSizePredictorFactory() {
        this(64, 1024, 65536);
    }

    public ReceiveBufferSizePredictor getPredictor() throws Exception {
        return new AdaptiveReceiveBufferSizePredictor(this.minimum, this.initial, this.maximum);
    }

    public AdaptiveReceiveBufferSizePredictorFactory(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("minimum: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("initial: ", i2));
        } else if (i3 >= i2) {
            this.minimum = i;
            this.initial = i2;
            this.maximum = i3;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maximum: ", i3));
        }
    }
}
