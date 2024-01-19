package kotlin.reflect.jvm.internal.impl.types.checker;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor$refine$1$1 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    public final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NewCapturedTypeConstructor$refine$1$1(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        // this.this$0 = newCapturedTypeConstructor;
        // this.$kotlinTypeRefiner = kotlinTypeRefiner;
        super(0);
    }

    public Object invoke() {
        Iterable<UnwrappedType> iterable = (List) this.this$0._supertypes$delegate.getValue();
        if (iterable == null) {
            iterable = EmptyList.INSTANCE;
        }
        KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
        for (UnwrappedType refine : iterable) {
            arrayList.add(refine.refine(kotlinTypeRefiner));
        }
        return arrayList;
    }
}
