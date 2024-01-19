package kotlin.reflect.jvm.internal.impl.descriptors;

public interface SourceElement {
    public static final SourceElement NO_SOURCE = new SourceElement() {
        public SourceFile getContainingFile() {
            return SourceFile.NO_SOURCE_FILE;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    };

    SourceFile getContainingFile();
}
