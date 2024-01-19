package net.sf.json.util;

public abstract class JavaIdentifierTransformer {
    public static final JavaIdentifierTransformer NOOP = new NoopJavaIdentifierTransformer(null);

    public static final class NoopJavaIdentifierTransformer extends JavaIdentifierTransformer {
        public NoopJavaIdentifierTransformer(AnonymousClass1 r1) {
        }
    }
}
