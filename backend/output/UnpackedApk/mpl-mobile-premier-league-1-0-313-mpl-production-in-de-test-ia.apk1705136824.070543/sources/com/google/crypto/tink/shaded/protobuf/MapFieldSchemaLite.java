package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite.Metadata;
import java.util.Map;
import java.util.Map.Entry;

public class MapFieldSchemaLite implements MapFieldSchema {
    public Map<?, ?> forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    public Metadata<?, ?> forMapMetadata(Object obj) {
        if (((MapEntryLite) obj) != null) {
            return null;
        }
        throw null;
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
                    i2 += CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(key, value)) + CodedOutputStream.computeTagSize(i);
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
                mapFieldLite = mapFieldLite.isEmpty() ? new MapFieldLite() : new MapFieldLite(mapFieldLite);
            }
            mapFieldLite.ensureMutable();
            if (!mapFieldLite2.isEmpty()) {
                mapFieldLite.putAll(mapFieldLite2);
            }
        }
        return mapFieldLite;
    }

    public Object newMapField(Object obj) {
        MapFieldLite mapFieldLite = MapFieldLite.EMPTY_MAP_FIELD;
        return mapFieldLite.isEmpty() ? new MapFieldLite() : new MapFieldLite(mapFieldLite);
    }

    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).isMutable = false;
        return obj;
    }
}
