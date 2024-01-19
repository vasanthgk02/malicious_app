package com.facebook.imagepipeline.systrace;

public class FrescoSystrace {
    public static final ArgsBuilder NO_OP_ARGS_BUILDER = new NoOpArgsBuilder();
    public static volatile Systrace sInstance = null;

    public interface ArgsBuilder {
        ArgsBuilder arg(String str, double d2);

        ArgsBuilder arg(String str, int i);

        ArgsBuilder arg(String str, long j);

        ArgsBuilder arg(String str, Object obj);

        void flush();
    }

    public static final class NoOpArgsBuilder implements ArgsBuilder {
        public NoOpArgsBuilder() {
        }

        public ArgsBuilder arg(String str, double d2) {
            return this;
        }

        public ArgsBuilder arg(String str, int i) {
            return this;
        }

        public ArgsBuilder arg(String str, long j) {
            return this;
        }

        public ArgsBuilder arg(String str, Object obj) {
            return this;
        }

        public void flush() {
        }
    }

    public interface Systrace {
        void beginSection(String str);

        ArgsBuilder beginSectionWithArgs(String str);

        void endSection();

        boolean isTracing();
    }

    public static void beginSection(String str) {
        getInstance().beginSection(str);
    }

    public static ArgsBuilder beginSectionWithArgs(String str) {
        return getInstance().beginSectionWithArgs(str);
    }

    public static void endSection() {
        getInstance().endSection();
    }

    public static Systrace getInstance() {
        if (sInstance == null) {
            synchronized (FrescoSystrace.class) {
                if (sInstance == null) {
                    sInstance = new DefaultFrescoSystrace();
                }
            }
        }
        return sInstance;
    }

    public static boolean isTracing() {
        return getInstance().isTracing();
    }

    public static void provide(Systrace systrace) {
        sInstance = systrace;
    }
}
