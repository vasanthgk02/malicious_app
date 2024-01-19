package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmMemberSignature.kt */
public abstract class JvmMemberSignature {

    /* compiled from: JvmMemberSignature.kt */
    public static final class Field extends JvmMemberSignature {
        public final String desc;
        public final String name;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Field(String str, String str2) {
            // Intrinsics.checkNotNullParameter(str, "name");
            // Intrinsics.checkNotNullParameter(str2, "desc");
            super(null);
            this.name = str;
            this.desc = str2;
        }

        public String asString() {
            return this.name + ':' + this.desc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual(this.name, field.name) && Intrinsics.areEqual(this.desc, field.desc);
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.desc.hashCode() + (this.name.hashCode() * 31);
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Method extends JvmMemberSignature {
        public final String desc;
        public final String name;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Method(String str, String str2) {
            // Intrinsics.checkNotNullParameter(str, "name");
            // Intrinsics.checkNotNullParameter(str2, "desc");
            super(null);
            this.name = str;
            this.desc = str2;
        }

        public String asString() {
            return Intrinsics.stringPlus(this.name, this.desc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual(this.name, method.name) && Intrinsics.areEqual(this.desc, method.desc);
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.desc.hashCode() + (this.name.hashCode() * 31);
        }
    }

    public JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
