package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LookupLocation.kt */
public final class Position implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final Position NO_POSITION = new Position(-1, -1);
    public final int column;
    public final int line;

    /* compiled from: LookupLocation.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return this.line == position.line && this.column == position.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Position(line=");
        outline73.append(this.line);
        outline73.append(", column=");
        return GeneratedOutlineSupport.outline56(outline73, this.column, ')');
    }
}
