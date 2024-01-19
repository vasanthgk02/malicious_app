package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* compiled from: TypeSystemContext.kt */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int i) {
        super(i);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof TypeArgumentMarker)) {
            return false;
        }
        return super.contains((TypeArgumentMarker) obj);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof TypeArgumentMarker)) {
            return -1;
        }
        return super.indexOf((TypeArgumentMarker) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof TypeArgumentMarker)) {
            return -1;
        }
        return super.lastIndexOf((TypeArgumentMarker) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof TypeArgumentMarker)) {
            return false;
        }
        return super.remove((TypeArgumentMarker) obj);
    }
}
