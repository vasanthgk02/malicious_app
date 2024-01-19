package androidx.lifecycle;

import java.util.HashMap;

public class ViewModelStore {
    public final HashMap<String, ViewModel> mMap = new HashMap<>();

    public final void clear() {
        for (ViewModel clear : this.mMap.values()) {
            clear.clear();
        }
        this.mMap.clear();
    }
}
