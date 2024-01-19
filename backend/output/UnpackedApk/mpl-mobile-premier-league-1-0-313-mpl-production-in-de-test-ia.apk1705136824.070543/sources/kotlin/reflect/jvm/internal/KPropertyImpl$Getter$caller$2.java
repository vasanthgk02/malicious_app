package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Getter;
import kotlin.reflect.jvm.internal.calls.Caller;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImpl$Getter$caller$2 extends Lambda implements Function0<Caller<?>> {
    public final /* synthetic */ Getter this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPropertyImpl$Getter$caller$2(Getter getter) {
        // this.this$0 = getter;
        super(0);
    }

    public Object invoke() {
        return TweetUtils.access$computeCallerForAccessor(this.this$0, true);
    }
}
