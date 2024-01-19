package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImpl$_type$2 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ StarProjectionImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StarProjectionImpl$_type$2(StarProjectionImpl starProjectionImpl) {
        // this.this$0 = starProjectionImpl;
        super(0);
    }

    public Object invoke() {
        return TweetUtils.starProjectionType(this.this$0.typeParameter);
    }
}
