package kotlin.reflect.jvm.internal.pcollections;

public final class IntTree<V> {
    public static final IntTree<Object> EMPTYNODE = new IntTree<>();
    public final long key;
    public final IntTree<V> left;
    public final IntTree<V> right;
    public final int size;
    public final V value;

    public IntTree() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public V get(long j) {
        if (this.size == 0) {
            return null;
        }
        long j2 = this.key;
        if (j < j2) {
            return this.left.get(j - j2);
        }
        if (j > j2) {
            return this.right.get(j - j2);
        }
        return this.value;
    }

    public IntTree<V> plus(long j, V v) {
        if (this.size == 0) {
            IntTree intTree = new IntTree(j, v, this, this);
            return intTree;
        }
        long j2 = this.key;
        if (j < j2) {
            return rebalanced(this.left.plus(j - j2, v), this.right);
        }
        if (j > j2) {
            return rebalanced(this.left, this.right.plus(j - j2, v));
        }
        if (v == this.value) {
            return this;
        }
        IntTree intTree2 = new IntTree(j, v, this.left, this.right);
        return intTree2;
    }

    public final IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        IntTree<V> intTree3;
        IntTree<V> intTree4 = intTree;
        IntTree<V> intTree5 = intTree2;
        if (intTree4 == this.left && intTree5 == this.right) {
            return this;
        }
        long j = this.key;
        V v = this.value;
        int i = intTree4.size;
        int i2 = intTree5.size;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                IntTree<V> intTree6 = intTree4.left;
                IntTree<V> intTree7 = intTree4.right;
                if (intTree7.size < intTree6.size * 2) {
                    long j2 = intTree4.key;
                    V v2 = intTree4.value;
                    IntTree intTree8 = new IntTree(-j2, v, intTree7.withKey(intTree7.key + j2), intTree2);
                    intTree3 = new IntTree<>(j2 + j, v2, intTree6, intTree8);
                } else {
                    IntTree<V> intTree9 = intTree7.left;
                    IntTree<V> intTree10 = intTree7.right;
                    long j3 = intTree7.key;
                    long j4 = intTree4.key + j3 + j;
                    V v3 = intTree7.value;
                    IntTree intTree11 = new IntTree(-j3, intTree4.value, intTree6, intTree9.withKey(intTree9.key + j3));
                    long j5 = intTree4.key;
                    long j6 = intTree7.key;
                    IntTree withKey = intTree10.withKey(intTree10.key + j6 + j5);
                    IntTree intTree12 = new IntTree((-j5) - j6, v, withKey, intTree2);
                    IntTree<V> intTree13 = new IntTree<>(j4, v3, intTree11, intTree12);
                    intTree3 = intTree13;
                }
            } else if (i2 >= i * 5) {
                IntTree<V> intTree14 = intTree5.left;
                IntTree<V> intTree15 = intTree5.right;
                if (intTree14.size < intTree15.size * 2) {
                    long j7 = intTree5.key;
                    V v4 = intTree5.value;
                    IntTree intTree16 = new IntTree(-j7, v, intTree, intTree14.withKey(intTree14.key + j7));
                    IntTree<V> intTree17 = new IntTree<>(j7 + j, v4, intTree16, intTree15);
                    intTree3 = intTree17;
                } else {
                    IntTree<V> intTree18 = intTree14.left;
                    IntTree<V> intTree19 = intTree14.right;
                    long j8 = intTree14.key;
                    long j9 = intTree5.key;
                    V v5 = intTree14.value;
                    IntTree intTree20 = new IntTree((-j9) - j8, v, intTree, intTree18.withKey(intTree18.key + j8 + j9));
                    long j10 = intTree14.key;
                    IntTree intTree21 = new IntTree(-j10, intTree5.value, intTree19.withKey(intTree19.key + j10), intTree15);
                    IntTree<V> intTree22 = new IntTree<>(j8 + j9 + j, v5, intTree20, intTree21);
                    intTree3 = intTree22;
                }
            }
            return intTree3;
        }
        intTree3 = new IntTree<>(j, v, intTree, intTree2);
        return intTree3;
    }

    public final IntTree<V> withKey(long j) {
        if (this.size == 0 || j == this.key) {
            return this;
        }
        IntTree intTree = new IntTree(j, this.value, this.left, this.right);
        return intTree;
    }

    public IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j;
        this.value = v;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }
}
