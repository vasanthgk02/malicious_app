package io.sentry.transport;

public final class NoOpTransportGate implements ITransportGate {
    public static final NoOpTransportGate instance = new NoOpTransportGate();

    public static NoOpTransportGate getInstance() {
        return instance;
    }

    public boolean isConnected() {
        return true;
    }
}
