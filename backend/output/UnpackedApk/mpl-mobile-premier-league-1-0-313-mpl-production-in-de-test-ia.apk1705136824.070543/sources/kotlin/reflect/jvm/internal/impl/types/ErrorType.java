package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
public class ErrorType extends SimpleType {
    public final List<TypeProjection> arguments;
    public final TypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final MemberScope memberScope;
    public final String presentableName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope2) {
        // Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        // Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        this(typeConstructor, memberScope2, null, false, null, 28);
    }

    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope2, List<TypeProjection> list, boolean z, String str, int i) {
        list = (i & 4) != 0 ? EmptyList.INSTANCE : list;
        z = (i & 8) != 0 ? false : z;
        String str2 = (i & 16) != 0 ? "???" : null;
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(str2, "presentableName");
        this.constructor = typeConstructor;
        this.memberScope = memberScope2;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.presentableName = str2;
    }

    public Annotations getAnnotations() {
        if (Annotations.Companion != null) {
            return Companion.EMPTY;
        }
        throw null;
    }

    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public String getPresentableName() {
        return this.presentableName;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return this;
    }

    /* renamed from: replaceAnnotations  reason: collision with other method in class */
    public UnwrappedType m977replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return this;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.constructor);
        if (this.arguments.isEmpty()) {
            str = "";
        } else {
            str = ArraysKt___ArraysJvmKt.joinToString(this.arguments, ", ", "<", ">", -1, "...", null);
        }
        sb.append(str);
        return sb.toString();
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        ErrorType errorType = new ErrorType(this.constructor, this.memberScope, this.arguments, z, null, 16);
        return errorType;
    }
}
