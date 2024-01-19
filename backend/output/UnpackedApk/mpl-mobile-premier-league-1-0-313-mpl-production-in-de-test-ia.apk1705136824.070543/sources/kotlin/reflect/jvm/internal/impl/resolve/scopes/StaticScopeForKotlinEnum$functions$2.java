package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    public final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        // this.this$0 = staticScopeForKotlinEnum;
        super(0);
    }

    public Object invoke() {
        return TweetUtils.listOf((T[]) new SimpleFunctionDescriptor[]{TweetUtils.createEnumValueOfMethod(this.this$0.containingClass), TweetUtils.createEnumValuesMethod(this.this$0.containingClass)});
    }
}
