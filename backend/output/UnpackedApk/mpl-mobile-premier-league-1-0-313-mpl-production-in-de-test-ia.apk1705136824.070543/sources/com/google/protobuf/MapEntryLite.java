package com.google.protobuf;

import java.io.IOException;

public class MapEntryLite<K, V> {
    public final K key;
    public final Metadata<K, V> metadata;
    public final V value;

    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat$FieldType keyType;
        public final WireFormat$FieldType valueType;

        public Metadata(WireFormat$FieldType wireFormat$FieldType, K k, WireFormat$FieldType wireFormat$FieldType2, V v) {
            this.keyType = wireFormat$FieldType;
            this.defaultKey = k;
            this.valueType = wireFormat$FieldType2;
            this.defaultValue = v;
        }
    }

    public MapEntryLite(WireFormat$FieldType wireFormat$FieldType, K k, WireFormat$FieldType wireFormat$FieldType2, V v) {
        this.metadata = new Metadata<>(wireFormat$FieldType, k, wireFormat$FieldType2, v);
        this.key = k;
        this.value = v;
    }

    public static <K, V> int computeSerializedSize(Metadata<K, V> metadata2, K k, V v) {
        return FieldSet.computeElementSize(metadata2.valueType, 2, v) + FieldSet.computeElementSize(metadata2.keyType, 1, k);
    }

    public static <K, V> void writeTo(CodedOutputStream codedOutputStream, Metadata<K, V> metadata2, K k, V v) throws IOException {
        FieldSet.writeElement(codedOutputStream, metadata2.keyType, 1, k);
        FieldSet.writeElement(codedOutputStream, metadata2.valueType, 2, v);
    }
}
