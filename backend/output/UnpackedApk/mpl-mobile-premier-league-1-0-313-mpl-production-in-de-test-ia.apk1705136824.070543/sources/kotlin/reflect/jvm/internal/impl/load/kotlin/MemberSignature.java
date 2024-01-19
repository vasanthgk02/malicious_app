package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;

/* compiled from: MemberSignature.kt */
public final class MemberSignature {
    public final String signature;

    public MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.signature = str;
    }

    public static final MemberSignature fromFieldNameAndDesc(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        return new MemberSignature(str + '#' + str2, null);
    }

    public static final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
        Intrinsics.checkNotNullParameter(jvmMemberSignature, "signature");
        if (jvmMemberSignature instanceof Method) {
            return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
        }
        if (jvmMemberSignature instanceof Field) {
            return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final MemberSignature fromMethod(NameResolver nameResolver, JvmMethodSignature jvmMethodSignature) {
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(jvmMethodSignature, "signature");
        return fromMethodNameAndDesc(nameResolver.getString(jvmMethodSignature.name_), nameResolver.getString(jvmMethodSignature.desc_));
    }

    public static final MemberSignature fromMethodNameAndDesc(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        return new MemberSignature(Intrinsics.stringPlus(str, str2), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberSignature) && Intrinsics.areEqual(this.signature, ((MemberSignature) obj).signature);
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("MemberSignature(signature="), this.signature, ')');
    }
}
