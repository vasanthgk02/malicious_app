package androidx.databinding;

import java.util.Map;

public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
    }

    void addOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback);

    void removeOnMapChangedCallback(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback);
}
