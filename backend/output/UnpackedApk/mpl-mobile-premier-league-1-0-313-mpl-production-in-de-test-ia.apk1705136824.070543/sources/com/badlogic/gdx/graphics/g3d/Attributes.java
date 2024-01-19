package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;
import java.util.Comparator;
import java.util.Iterator;

public class Attributes implements Iterable<Attribute>, Comparator<Attribute>, Comparable<Attributes> {
    public final Array<Attribute> attributes = new Array<>();
    public long mask;
    public boolean sorted = true;

    private final void disable(long j) {
        this.mask = (~j) & this.mask;
    }

    private final void enable(long j) {
        this.mask = j | this.mask;
    }

    public int attributesHash() {
        sort();
        int i = this.attributes.size;
        long j = this.mask + 71;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 7) & 65535;
            j += this.mask * ((long) ((Attribute) this.attributes.get(i3)).hashCode()) * ((long) i2);
        }
        return (int) (j ^ (j >> 32));
    }

    public void clear() {
        this.mask = 0;
        this.attributes.clear();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Attributes)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return same((Attributes) obj, true);
    }

    public final Attribute get(long j) {
        if (has(j)) {
            int i = 0;
            while (true) {
                Array<Attribute> array = this.attributes;
                if (i >= array.size) {
                    break;
                } else if (((Attribute) array.get(i)).type == j) {
                    return (Attribute) this.attributes.get(i);
                } else {
                    i++;
                }
            }
        }
        return null;
    }

    public final long getMask() {
        return this.mask;
    }

    public final boolean has(long j) {
        return j != 0 && (this.mask & j) == j;
    }

    public int hashCode() {
        return attributesHash();
    }

    public int indexOf(long j) {
        if (has(j)) {
            int i = 0;
            while (true) {
                Array<Attribute> array = this.attributes;
                if (i >= array.size) {
                    break;
                } else if (((Attribute) array.get(i)).type == j) {
                    return i;
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public final Iterator<Attribute> iterator() {
        return this.attributes.iterator();
    }

    public final void remove(long j) {
        for (int i = this.attributes.size - 1; i >= 0; i--) {
            long j2 = ((Attribute) this.attributes.get(i)).type;
            if ((j & j2) == j2) {
                this.attributes.removeIndex(i);
                disable(j2);
                this.sorted = false;
            }
        }
        sort();
    }

    public final boolean same(Attributes attributes2, boolean z) {
        if (attributes2 == this) {
            return true;
        }
        if (attributes2 == null || this.mask != attributes2.mask) {
            return false;
        }
        if (!z) {
            return true;
        }
        sort();
        attributes2.sort();
        int i = 0;
        while (true) {
            Array<Attribute> array = this.attributes;
            if (i >= array.size) {
                return true;
            }
            if (!((Attribute) array.get(i)).equals((Attribute) attributes2.attributes.get(i))) {
                return false;
            }
            i++;
        }
    }

    public final void set(Attribute attribute) {
        int indexOf = indexOf(attribute.type);
        if (indexOf < 0) {
            enable(attribute.type);
            this.attributes.add(attribute);
            this.sorted = false;
        } else {
            this.attributes.set(indexOf, attribute);
        }
        sort();
    }

    public int size() {
        return this.attributes.size;
    }

    public final void sort() {
        if (!this.sorted) {
            this.attributes.sort(this);
            this.sorted = true;
        }
    }

    public final int compare(Attribute attribute, Attribute attribute2) {
        return (int) (attribute.type - attribute2.type);
    }

    public int compareTo(Attributes attributes2) {
        int i = 0;
        if (attributes2 == this) {
            return 0;
        }
        long j = this.mask;
        long j2 = attributes2.mask;
        int i2 = -1;
        if (j != j2) {
            if (j >= j2) {
                i2 = 1;
            }
            return i2;
        }
        sort();
        attributes2.sort();
        int i3 = 0;
        while (true) {
            Array<Attribute> array = this.attributes;
            if (i3 >= array.size) {
                return 0;
            }
            int compareTo = ((Attribute) array.get(i3)).compareTo(attributes2.attributes.get(i3));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    i = -1;
                } else if (compareTo > 0) {
                    i = 1;
                }
                return i;
            }
            i3++;
        }
    }

    public final <T extends Attribute> T get(Class<T> cls, long j) {
        return get(j);
    }

    public final Array<Attribute> get(Array<Attribute> array, long j) {
        int i = 0;
        while (true) {
            Array<Attribute> array2 = this.attributes;
            if (i >= array2.size) {
                return array;
            }
            if ((((Attribute) array2.get(i)).type & j) != 0) {
                array.add(this.attributes.get(i));
            }
            i++;
        }
    }

    public final boolean same(Attributes attributes2) {
        return same(attributes2, false);
    }

    public final void set(Attribute attribute, Attribute attribute2) {
        set(attribute);
        set(attribute2);
    }

    public final void set(Attribute attribute, Attribute attribute2, Attribute attribute3) {
        set(attribute);
        set(attribute2);
        set(attribute3);
    }

    public final void set(Attribute attribute, Attribute attribute2, Attribute attribute3, Attribute attribute4) {
        set(attribute);
        set(attribute2);
        set(attribute3);
        set(attribute4);
    }

    public final void set(Attribute... attributeArr) {
        for (Attribute attribute : attributeArr) {
            set(attribute);
        }
    }

    public final void set(Iterable<Attribute> iterable) {
        for (Attribute attribute : iterable) {
            set(attribute);
        }
    }
}
