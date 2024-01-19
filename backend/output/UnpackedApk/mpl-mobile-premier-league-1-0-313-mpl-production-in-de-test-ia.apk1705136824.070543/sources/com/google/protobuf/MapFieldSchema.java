package com.google.protobuf;

import com.google.protobuf.MapEntryLite.Metadata;
import java.util.Map;

public interface MapFieldSchema {
    Map<?, ?> forMapData(Object obj);

    Metadata<?, ?> forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
