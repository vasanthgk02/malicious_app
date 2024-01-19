package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinType.kt */
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    public int cachedHashCode;

    public KotlinType() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.strictEqualTypesInternal(r4, r1, r7) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = r6.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7
            boolean r2 = r7.isMarkedNullable()
            if (r1 != r2) goto L_0x003c
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = r6.unwrap()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r7 = r7.unwrap()
            java.lang.String r2 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r3 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r4 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            java.lang.String r5 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            boolean r7 = kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.strictEqualTypesInternal(r4, r1, r7)
            if (r7 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.KotlinType.equals(java.lang.Object):boolean");
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int i;
        int i2 = this.cachedHashCode;
        if (i2 != 0) {
            return i2;
        }
        if (TweetUtils.isError(this)) {
            i = super.hashCode();
        } else {
            int hashCode = getArguments().hashCode();
            i = (isMarkedNullable() ? 1 : 0) + ((hashCode + (getConstructor().hashCode() * 31)) * 31);
        }
        this.cachedHashCode = i;
        return i;
    }

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract UnwrappedType unwrap();

    public KotlinType(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
