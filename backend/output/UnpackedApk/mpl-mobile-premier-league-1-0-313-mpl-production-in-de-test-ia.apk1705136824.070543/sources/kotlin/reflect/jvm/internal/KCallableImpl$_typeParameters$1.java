package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KCallableImpl.kt */
public final class KCallableImpl$_typeParameters$1 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    public final /* synthetic */ KCallableImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KCallableImpl$_typeParameters$1(KCallableImpl kCallableImpl) {
        // this.this$0 = kCallableImpl;
        super(0);
    }

    public Object invoke() {
        List<TypeParameterDescriptor> typeParameters = this.this$0.getDescriptor().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(typeParameters, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
            KCallableImpl kCallableImpl = this.this$0;
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
            arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
        }
        return arrayList;
    }
}
