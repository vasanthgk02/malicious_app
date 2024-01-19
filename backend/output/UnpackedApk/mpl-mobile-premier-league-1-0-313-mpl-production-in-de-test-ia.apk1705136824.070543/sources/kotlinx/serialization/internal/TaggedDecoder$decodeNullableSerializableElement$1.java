package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n"}, d2 = {"<anonymous>", "T", "", "Tag"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Tagged.kt */
public final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements Function0<T> {
    public final /* synthetic */ DeserializationStrategy<T> $deserializer;
    public final /* synthetic */ T $previousValue;
    public final /* synthetic */ TaggedDecoder<Tag> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TaggedDecoder$decodeNullableSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<T> deserializationStrategy, T t) {
        // this.this$0 = taggedDecoder;
        // this.$deserializer = deserializationStrategy;
        // this.$previousValue = t;
        super(0);
    }

    public final T invoke() {
        if (this.this$0.decodeNotNullMark()) {
            TaggedDecoder<Tag> taggedDecoder = this.this$0;
            DeserializationStrategy<T> deserializationStrategy = this.$deserializer;
            if (taggedDecoder != null) {
                Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
                return taggedDecoder.decodeSerializableValue(deserializationStrategy);
            }
            throw null;
        } else if (this.this$0 != null) {
            return null;
        } else {
            throw null;
        }
    }
}
