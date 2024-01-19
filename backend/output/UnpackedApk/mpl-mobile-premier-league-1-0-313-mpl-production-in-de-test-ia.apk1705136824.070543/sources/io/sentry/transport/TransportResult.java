package io.sentry.transport;

public abstract class TransportResult {

    public static final class ErrorTransportResult extends TransportResult {
        public final int responseCode;

        public ErrorTransportResult(int i) {
            super();
            this.responseCode = i;
        }

        public int getResponseCode() {
            return this.responseCode;
        }

        public boolean isSuccess() {
            return false;
        }
    }

    public static final class SuccessTransportResult extends TransportResult {
        public static final SuccessTransportResult INSTANCE = new SuccessTransportResult();

        public SuccessTransportResult() {
            super();
        }

        public int getResponseCode() {
            return -1;
        }

        public boolean isSuccess() {
            return true;
        }
    }

    public static TransportResult error(int i) {
        return new ErrorTransportResult(i);
    }

    public static TransportResult success() {
        return SuccessTransportResult.INSTANCE;
    }

    public abstract int getResponseCode();

    public abstract boolean isSuccess();

    public TransportResult() {
    }

    public static TransportResult error() {
        return error(-1);
    }
}
