package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 extends Lambda implements Function1<ProtoBuf$Type, ProtoBuf$Type> {
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(TypeDeserializer typeDeserializer) {
        // this.this$0 = typeDeserializer;
        super(1);
    }

    public Object invoke(Object obj) {
        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
        Intrinsics.checkNotNullParameter(protoBuf$Type, "it");
        return TweetUtils.outerType(protoBuf$Type, this.this$0.f5949c.typeTable);
    }
}
