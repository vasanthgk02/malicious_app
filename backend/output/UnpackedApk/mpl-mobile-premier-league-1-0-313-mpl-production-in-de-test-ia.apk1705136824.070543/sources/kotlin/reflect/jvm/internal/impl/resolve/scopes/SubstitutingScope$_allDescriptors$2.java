package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope$_allDescriptors$2 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    public final /* synthetic */ SubstitutingScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        // this.this$0 = substitutingScope;
        super(0);
    }

    public Object invoke() {
        SubstitutingScope substitutingScope = this.this$0;
        return substitutingScope.substitute(TweetUtils.getContributedDescriptors$default(substitutingScope.workerScope, null, null, 3, null));
    }
}
