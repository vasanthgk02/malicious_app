package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.HashSet;

public final class DirectedAcyclicGraph<T> {
    public final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    public final Pools$Pool<ArrayList<T>> mListPool = new Pools$SimplePool(10);
    public final ArrayList<T> mSortResult = new ArrayList<>();
    public final HashSet<T> mSortTmpMarked = new HashSet<>();

    public void addNode(T t) {
        if (!(this.mGraph.indexOfKey(t) >= 0)) {
            this.mGraph.put(t, null);
        }
    }

    public final void dfs(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = (ArrayList) this.mGraph.getOrDefault(t, null);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        dfs(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
