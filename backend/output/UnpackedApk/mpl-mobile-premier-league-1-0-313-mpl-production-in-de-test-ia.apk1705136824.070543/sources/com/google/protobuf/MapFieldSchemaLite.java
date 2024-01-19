package com.google.protobuf;

import com.google.protobuf.MapEntryLite.Metadata;
import java.util.Map;
import java.util.Map.Entry;

public class MapFieldSchemaLite implements MapFieldSchema {
    public Map<?, ?> forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    public Metadata<?, ?> forMapMetadata(Object obj) {
        return ((MapEntryLite) obj).metadata;
    }

    public Map<?, ?> forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    public int getSerializedSize(int i, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int i2 = 0;
        if (!mapFieldLite.isEmpty()) {
            for (Entry entry : mapFieldLite.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (mapEntryLite != null) {
                    i2 += CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(mapEntryLite.metadata, key, value)) + CodedOutputStream.computeTagSize(i);
                } else {
                    throw null;
                }
            }
        }
        return i2;
    }

    public boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).isMutable;
    }

    public Object mergeFrom(Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.ensureMutable();
            if (!mapFieldLite2.isEmpty()) {
                mapFieldLite.putAll(mapFieldLite2);
            }
        }
        return mapFieldLite;
    }

    public Object newMapField(Object obj) {
        return MapFieldLite.EMPTY_MAP_FIELD.mutableCopy();
    }

    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).isMutable = false;
        return obj;
    }
}
