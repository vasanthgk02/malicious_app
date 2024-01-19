package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T> {
    public final T actualVersion;
    public final ClassId classId;
    public final T expectedVersion;
    public final String filePath;

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId2) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(classId2, "classId");
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = str;
        this.classId = classId2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.expectedVersion;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return this.classId.hashCode() + GeneratedOutlineSupport.outline11(this.filePath, (hashCode + i) * 31, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("IncompatibleVersionErrorData(actualVersion=");
        outline73.append(this.actualVersion);
        outline73.append(", expectedVersion=");
        outline73.append(this.expectedVersion);
        outline73.append(", filePath=");
        outline73.append(this.filePath);
        outline73.append(", classId=");
        outline73.append(this.classId);
        outline73.append(')');
        return outline73.toString();
    }
}
