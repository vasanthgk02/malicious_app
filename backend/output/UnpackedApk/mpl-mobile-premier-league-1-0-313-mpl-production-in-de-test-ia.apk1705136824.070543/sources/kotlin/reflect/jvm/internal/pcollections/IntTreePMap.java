package kotlin.reflect.jvm.internal.pcollections;

public final class IntTreePMap<V> {
    public static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.EMPTYNODE);
    public final IntTree<V> root;

    public IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }
}
