package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyFieldLite {
    public ByteString bytes;
    public volatile boolean isDirty;
    public volatile MessageLite value;
}
