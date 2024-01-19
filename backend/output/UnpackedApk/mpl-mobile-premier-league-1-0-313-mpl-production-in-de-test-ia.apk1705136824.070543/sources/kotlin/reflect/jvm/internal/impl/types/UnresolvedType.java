package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
public final class UnresolvedType extends ErrorType {
    public final String presentableName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnresolvedType(String str, TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        // Intrinsics.checkNotNullParameter(str, "presentableName");
        // Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        // Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        // Intrinsics.checkNotNullParameter(list, "arguments");
        super(typeConstructor, memberScope, list, z, null, 16);
        this.presentableName = str;
    }

    public String getPresentableName() {
        return this.presentableName;
    }

    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        UnresolvedType unresolvedType = new UnresolvedType(this.presentableName, this.constructor, this.memberScope, this.arguments, z);
        return unresolvedType;
    }

    /* renamed from: refine  reason: collision with other method in class */
    public KotlinType m982refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    /* renamed from: refine  reason: collision with other method in class */
    public UnwrappedType m983refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
