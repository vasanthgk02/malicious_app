package androidx.datastore.preferences.protobuf;

public class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    public void addLengthDelimited(Object obj, int i, ByteString byteString) {
        ((UnknownFieldSetLite) obj).storeField((i << 3) | 2, byteString);
    }

    public Object getBuilderFromMessage(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.DEFAULT_INSTANCE) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
        generatedMessageLite.unknownFields = unknownFieldSetLite2;
        return unknownFieldSetLite2;
    }

    public Object newBuilder() {
        return new UnknownFieldSetLite(0, new int[8], new Object[8], true);
    }

    public void setBuilderToMessage(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (UnknownFieldSetLite) obj2;
    }

    public boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }
}
