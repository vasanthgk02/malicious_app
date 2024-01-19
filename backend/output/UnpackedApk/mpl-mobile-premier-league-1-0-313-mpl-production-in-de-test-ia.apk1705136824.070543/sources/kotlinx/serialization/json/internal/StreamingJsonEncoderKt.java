package kotlinx.serialization.json.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortSerializer;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"unsignedNumberDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getUnsignedNumberDescriptors$annotations", "()V", "isUnsignedNumber", "", "isUnsignedNumber$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: StreamingJsonEncoder.kt */
public final class StreamingJsonEncoderKt {
    public static final Set<SerialDescriptor> unsignedNumberDescriptors = TweetUtils.setOf((T[]) new SerialDescriptor[]{UIntSerializer.descriptor, ULongSerializer.descriptor, UByteSerializer.descriptor, UShortSerializer.descriptor});

    static {
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        ULongSerializer uLongSerializer = ULongSerializer.INSTANCE;
        UByteSerializer uByteSerializer = UByteSerializer.INSTANCE;
        UShortSerializer uShortSerializer = UShortSerializer.INSTANCE;
    }

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }
}
