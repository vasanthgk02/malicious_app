package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KTypeParameterImpl.kt */
public final class KTypeParameterImpl$upperBounds$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    public final /* synthetic */ KTypeParameterImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KTypeParameterImpl$upperBounds$2(KTypeParameterImpl kTypeParameterImpl) {
        // this.this$0 = kTypeParameterImpl;
        super(0);
    }

    public Object invoke() {
        List<KotlinType> upperBounds = this.this$0.descriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(upperBounds, 10));
        for (KotlinType kTypeImpl : upperBounds) {
            arrayList.add(new KTypeImpl(kTypeImpl, null));
        }
        return arrayList;
    }
}
