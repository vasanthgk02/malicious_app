package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KClassImpl.kt */
public final class KClassImpl$Data$typeParameters$2 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KClassImpl$Data$typeParameters$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    public Object invoke() {
        List<TypeParameterDescriptor> declaredTypeParameters = this.this$0.getDescriptor().getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(declaredTypeParameters, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
            KClassImpl kClassImpl = KClassImpl.this;
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
            arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
        }
        return arrayList;
    }
}
