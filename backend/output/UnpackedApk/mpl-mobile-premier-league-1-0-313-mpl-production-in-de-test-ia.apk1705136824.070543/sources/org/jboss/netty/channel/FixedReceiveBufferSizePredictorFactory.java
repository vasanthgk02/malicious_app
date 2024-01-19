package org.jboss.netty.channel;

public class FixedReceiveBufferSizePredictorFactory implements ReceiveBufferSizePredictorFactory {
    public final ReceiveBufferSizePredictor predictor;

    public FixedReceiveBufferSizePredictorFactory(int i) {
        this.predictor = new FixedReceiveBufferSizePredictor(i);
    }

    public ReceiveBufferSizePredictor getPredictor() throws Exception {
        return this.predictor;
    }
}
