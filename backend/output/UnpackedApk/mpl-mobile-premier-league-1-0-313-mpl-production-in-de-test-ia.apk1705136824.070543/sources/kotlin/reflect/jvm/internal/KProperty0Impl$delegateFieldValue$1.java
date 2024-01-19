package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KProperty0Impl.kt */
public final class KProperty0Impl$delegateFieldValue$1 extends Lambda implements Function0<Object> {
    public final /* synthetic */ KProperty0Impl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KProperty0Impl$delegateFieldValue$1(KProperty0Impl kProperty0Impl) {
        // this.this$0 = kProperty0Impl;
        super(0);
    }

    public final Object invoke() {
        KProperty0Impl kProperty0Impl = this.this$0;
        Field computeDelegateField = kProperty0Impl.computeDelegateField();
        KProperty0Impl kProperty0Impl2 = this.this$0;
        Object coerceToExpectedReceiverType = TweetUtils.coerceToExpectedReceiverType(kProperty0Impl2.rawBoundReceiver, kProperty0Impl2.getDescriptor());
        try {
            if (coerceToExpectedReceiverType == KPropertyImpl.EXTENSION_PROPERTY_DELEGATE) {
                if (kProperty0Impl.getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException(ExtendedMessageFormat.QUOTE + kProperty0Impl + "' is not an extension property and thus getExtensionDelegate() " + "is not going to work, use getDelegate() instead");
                }
            }
            if (computeDelegateField != null) {
                return computeDelegateField.get(coerceToExpectedReceiverType);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
    }
}
