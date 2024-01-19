package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MapBuilder<K, V> {
    public final Map<K, V> contributions;

    public MapBuilder(int i) {
        this.contributions = new LinkedHashMap(i < 3 ? i + 1 : i < 1073741824 ? (int) ((((float) i) / 0.75f) + 1.0f) : Integer.MAX_VALUE);
    }

    public Map<K, V> build() {
        if (this.contributions.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.contributions);
    }
}
