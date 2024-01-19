package com.facebook.systrace;

public final class SystraceMessage {
    public static final Builder NOOP_BUILDER = new NoopBuilder(null);

    public static abstract class Builder {
    }

    public static class NoopBuilder extends Builder {
        public NoopBuilder() {
        }

        public NoopBuilder(AnonymousClass1 r1) {
        }
    }
}
