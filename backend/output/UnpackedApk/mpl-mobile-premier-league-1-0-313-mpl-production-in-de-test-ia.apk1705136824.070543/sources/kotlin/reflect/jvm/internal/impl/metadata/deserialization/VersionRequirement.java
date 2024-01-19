package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.VersionKind;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirement {
    public final Integer errorCode;
    public final VersionKind kind;
    public final DeprecationLevel level;
    public final String message;
    public final Version version;

    /* compiled from: VersionRequirement.kt */
    public static final class Version {
        public static final Companion Companion = new Companion(null);
        public static final Version INFINITY = new Version(256, 256, 256);
        public final int major;
        public final int minor;
        public final int patch;

        /* compiled from: VersionRequirement.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return false;
            }
            Version version = (Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public String toString() {
            int i;
            StringBuilder sb;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        public Version(int i, int i2, int i3, int i4) {
            i3 = (i4 & 4) != 0 ? 0 : i3;
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }
    }

    public VersionRequirement(Version version2, VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        Intrinsics.checkNotNullParameter(version2, "version");
        Intrinsics.checkNotNullParameter(versionKind, "kind");
        Intrinsics.checkNotNullParameter(deprecationLevel, "level");
        this.version = version2;
        this.kind = versionKind;
        this.level = deprecationLevel;
        this.errorCode = num;
        this.message = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("since ");
        outline73.append(this.version);
        outline73.append(' ');
        outline73.append(this.level);
        Integer num = this.errorCode;
        String str = "";
        outline73.append(num != null ? Intrinsics.stringPlus(" error ", num) : str);
        String str2 = this.message;
        if (str2 != null) {
            str = Intrinsics.stringPlus(": ", str2);
        }
        outline73.append(str);
        return outline73.toString();
    }
}
