package kotlin.reflect.jvm.internal.impl.descriptors;

import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Visibility.kt */
public abstract class Visibility {
    public final boolean isPublicAPI;
    public final String name;

    public Visibility(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.isPublicAPI = z;
    }

    public Integer compareTo(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Visibilities visibilities = Visibilities.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "first");
        Intrinsics.checkNotNullParameter(visibility, AnonymousClass27.SECOND);
        if (this == visibility) {
            return Integer.valueOf(0);
        }
        Integer num = Visibilities.ORDERED_VISIBILITIES.get(this);
        Integer num2 = Visibilities.ORDERED_VISIBILITIES.get(visibility);
        if (num == null || num2 == null || Intrinsics.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
