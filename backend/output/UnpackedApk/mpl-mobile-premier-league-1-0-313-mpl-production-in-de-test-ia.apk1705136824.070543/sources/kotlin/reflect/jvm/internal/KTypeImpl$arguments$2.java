package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KTypeProjection.Companion;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    public final /* synthetic */ Function0 $computeJavaType;
    public final /* synthetic */ KTypeImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0 function0) {
        // this.this$0 = kTypeImpl;
        // this.$computeJavaType = function0;
        super(0);
    }

    public Object invoke() {
        KTypeProjection kTypeProjection;
        List<TypeProjection> arguments = this.this$0.type.getArguments();
        if (arguments.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        Lazy lazy = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(arguments, 10));
        int i = 0;
        for (T next : arguments) {
            int i2 = i + 1;
            Function0 function0 = null;
            if (i >= 0) {
                TypeProjection typeProjection = (TypeProjection) next;
                if (typeProjection.isStarProjection()) {
                    Companion companion = KTypeProjection.Companion;
                    kTypeProjection = KTypeProjection.star;
                } else {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                    if (this.$computeJavaType != null) {
                        function0 = new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i, this, lazy, null);
                    }
                    KTypeImpl kTypeImpl = new KTypeImpl(type, function0);
                    int ordinal = typeProjection.getProjectionKind().ordinal();
                    if (ordinal == 0) {
                        Companion companion2 = KTypeProjection.Companion;
                        Intrinsics.checkNotNullParameter(kTypeImpl, "type");
                        kTypeProjection = new KTypeProjection(KVariance.INVARIANT, kTypeImpl);
                    } else if (ordinal == 1) {
                        Companion companion3 = KTypeProjection.Companion;
                        Intrinsics.checkNotNullParameter(kTypeImpl, "type");
                        kTypeProjection = new KTypeProjection(KVariance.IN, kTypeImpl);
                    } else if (ordinal == 2) {
                        Companion companion4 = KTypeProjection.Companion;
                        Intrinsics.checkNotNullParameter(kTypeImpl, "type");
                        kTypeProjection = new KTypeProjection(KVariance.OUT, kTypeImpl);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                arrayList.add(kTypeProjection);
                i = i2;
            } else {
                TweetUtils.throwIndexOverflow();
                throw null;
            }
        }
        return arrayList;
    }
}
