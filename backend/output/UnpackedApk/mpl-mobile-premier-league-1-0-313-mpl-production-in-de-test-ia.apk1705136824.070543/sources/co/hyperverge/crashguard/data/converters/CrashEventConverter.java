package co.hyperverge.crashguard.data.converters;

import co.hyperverge.crashguard.data.models.CrashEvent;
import com.squareup.tape2.ObjectQueue.Converter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.Charsets;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.Json.Default;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lco/hyperverge/crashguard/data/converters/CrashEventConverter;", "Lcom/squareup/tape2/ObjectQueue$Converter;", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "()V", "from", "bytes", "", "toStream", "", "crashEvent", "outputStream", "Ljava/io/OutputStream;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEventConverter.kt */
public final class CrashEventConverter implements Converter<CrashEvent> {
    public Object from(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Default defaultR = Json.Default;
        return (CrashEvent) defaultR.decodeFromString(TypeUtilsKt.serializer(defaultR.getSerializersModule(), Reflection.typeOf(CrashEvent.class)), new String(bArr, Charsets.UTF_8));
    }

    public void toStream(Object obj, OutputStream outputStream) {
        CrashEvent crashEvent = (CrashEvent) obj;
        Intrinsics.checkNotNullParameter(crashEvent, "crashEvent");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        try {
            Default defaultR = Json.Default;
            byte[] bytes = defaultR.encodeToString(TypeUtilsKt.serializer(defaultR.serializersModule, Reflection.typeOf(CrashEvent.class)), crashEvent).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        } catch (Throwable th) {
            TweetUtils.createFailure(th);
        }
    }
}
