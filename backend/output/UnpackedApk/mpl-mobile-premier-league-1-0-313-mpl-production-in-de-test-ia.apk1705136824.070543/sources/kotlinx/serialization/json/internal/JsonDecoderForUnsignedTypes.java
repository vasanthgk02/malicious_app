package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "json", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/json/Json;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeByte", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInt", "decodeLong", "", "decodeShort", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StreamingJsonDecoder.kt */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    public final AbstractJsonLexer lexer;
    public final SerializersModule serializersModule;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer abstractJsonLexer, Json json) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.lexer = abstractJsonLexer;
        this.serializersModule = json.serializersModule;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A[Catch:{ IllegalArgumentException -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ IllegalArgumentException -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte decodeByte() {
        /*
            r5 = this;
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r5.lexer
            java.lang.String r1 = r0.consumeStringLenient()
            r2 = 0
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0036 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0036 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0036 }
            r3 = 10
            kotlin.UInt r3 = kotlin.text.CharsKt__CharKt.toUIntOrNull(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0036 }
            if (r3 == 0) goto L_0x002c
            int r3 = r3.data     // Catch:{ IllegalArgumentException -> 0x0036 }
            r4 = 255(0xff, float:3.57E-43)
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.uintCompare(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0036 }
            if (r4 <= 0) goto L_0x0025
            goto L_0x002c
        L_0x0025:
            byte r3 = (byte) r3     // Catch:{ IllegalArgumentException -> 0x0036 }
            kotlin.UByte r4 = new kotlin.UByte     // Catch:{ IllegalArgumentException -> 0x0036 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x0036 }
            goto L_0x002d
        L_0x002c:
            r4 = r2
        L_0x002d:
            if (r4 == 0) goto L_0x0032
            byte r0 = r4.data     // Catch:{ IllegalArgumentException -> 0x0036 }
            return r0
        L_0x0032:
            kotlin.text.CharsKt__CharKt.numberFormatError(r1)     // Catch:{ IllegalArgumentException -> 0x0036 }
            throw r2
        L_0x0036:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to parse type '"
            r3.append(r4)
            java.lang.String r4 = "UByte"
            r3.append(r4)
            java.lang.String r4 = "' for input '"
            r3.append(r4)
            r3.append(r1)
            r1 = 39
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            r4 = 2
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r0, r1, r3, r4, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonDecoderForUnsignedTypes.decodeByte():byte");
    }

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    public int decodeInt() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            Intrinsics.checkNotNullParameter(consumeStringLenient, "<this>");
            Intrinsics.checkNotNullParameter(consumeStringLenient, "<this>");
            UInt uIntOrNull = CharsKt__CharKt.toUIntOrNull(consumeStringLenient, 10);
            if (uIntOrNull != null) {
                return uIntOrNull.data;
            }
            CharsKt__CharKt.numberFormatError(consumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + "UInt" + "' for input '" + consumeStringLenient + ExtendedMessageFormat.QUOTE, 0, 2, null);
            throw null;
        }
    }

    public long decodeLong() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            Intrinsics.checkNotNullParameter(consumeStringLenient, "<this>");
            ULong uLongOrNull = CharsKt__CharKt.toULongOrNull(consumeStringLenient);
            if (uLongOrNull != null) {
                return uLongOrNull.data;
            }
            CharsKt__CharKt.numberFormatError(consumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + "ULong" + "' for input '" + consumeStringLenient + ExtendedMessageFormat.QUOTE, 0, 2, null);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030 A[Catch:{ IllegalArgumentException -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[Catch:{ IllegalArgumentException -> 0x0037 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public short decodeShort() {
        /*
            r5 = this;
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r5.lexer
            java.lang.String r1 = r0.consumeStringLenient()
            r2 = 0
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            r3 = 10
            kotlin.UInt r3 = kotlin.text.CharsKt__CharKt.toUIntOrNull(r1, r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            if (r3 == 0) goto L_0x002d
            int r3 = r3.data     // Catch:{ IllegalArgumentException -> 0x0037 }
            r4 = 65535(0xffff, float:9.1834E-41)
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.uintCompare(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0037 }
            if (r4 <= 0) goto L_0x0026
            goto L_0x002d
        L_0x0026:
            short r3 = (short) r3     // Catch:{ IllegalArgumentException -> 0x0037 }
            kotlin.UShort r4 = new kotlin.UShort     // Catch:{ IllegalArgumentException -> 0x0037 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            goto L_0x002e
        L_0x002d:
            r4 = r2
        L_0x002e:
            if (r4 == 0) goto L_0x0033
            short r0 = r4.data     // Catch:{ IllegalArgumentException -> 0x0037 }
            return r0
        L_0x0033:
            kotlin.text.CharsKt__CharKt.numberFormatError(r1)     // Catch:{ IllegalArgumentException -> 0x0037 }
            throw r2
        L_0x0037:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to parse type '"
            r3.append(r4)
            java.lang.String r4 = "UShort"
            r3.append(r4)
            java.lang.String r4 = "' for input '"
            r3.append(r4)
            r3.append(r1)
            r1 = 39
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            r4 = 2
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r0, r1, r3, r4, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonDecoderForUnsignedTypes.decodeShort():short");
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
