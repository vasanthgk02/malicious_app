package co.hyperverge.crashguard.data.models;

import com.netcore.android.SMTConfigConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lco/hyperverge/crashguard/data/models/DateSerializer;", "Lkotlinx/serialization/KSerializer;", "Ljava/util/Date;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Serializers.kt */
public final class DateSerializer implements KSerializer<Date> {
    public static final Companion Companion = new Companion(null);
    public static final SimpleDateFormat dtFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.US);
    public final SerialDescriptor descriptor = TypeUtilsKt.PrimitiveSerialDescriptor("Date", STRING.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lco/hyperverge/crashguard/data/models/DateSerializer$Companion;", "", "()V", "dtFormat", "Ljava/text/SimpleDateFormat;", "getDtFormat", "()Ljava/text/SimpleDateFormat;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Serializers.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Date parse = dtFormat.parse(decoder.decodeString());
        Intrinsics.checkNotNull(parse);
        return parse;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, Object obj) {
        Date date = (Date) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(date, HSLCriteriaBuilder.VALUE);
        String format = dtFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "dtFormat.format(value)");
        encoder.encodeString(format);
    }
}
