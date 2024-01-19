package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Setter;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImpl$Setter$descriptor$2 extends Lambda implements Function0<PropertySetterDescriptor> {
    public final /* synthetic */ Setter this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPropertyImpl$Setter$descriptor$2(Setter setter) {
        // this.this$0 = setter;
        super(0);
    }

    public Object invoke() {
        PropertySetterDescriptor setter = this.this$0.getProperty().getDescriptor().getSetter();
        if (setter != null) {
            return setter;
        }
        PropertyDescriptor descriptor = this.this$0.getProperty().getDescriptor();
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            if (Annotations.Companion != null) {
                return TweetUtils.createDefaultSetter(descriptor, annotations, Companion.EMPTY);
            }
            throw null;
        }
        throw null;
    }
}
