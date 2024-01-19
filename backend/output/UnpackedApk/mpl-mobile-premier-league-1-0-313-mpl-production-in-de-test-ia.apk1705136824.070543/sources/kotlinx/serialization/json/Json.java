package kotlinx.serialization.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStringBuilder;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StreamingJsonEncoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001e2\u0006\u0010\u001f\u001a\u0002H\u0012¢\u0006\u0002\u0010 J'\u0010!\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001e2\u0006\u0010\u001f\u001a\u0002H\u0012¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aR\u001c\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0001\u0002%&¨\u0006'"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "_schemaCache", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "get_schemaCache$kotlinx_serialization_json", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "getConfiguration", "()Lkotlinx/serialization/json/JsonConfiguration;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeFromJsonElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "decodeFromString", "string", "", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "encodeToJsonElement", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "encodeToString", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "parseToJsonElement", "Default", "Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/JsonImpl;", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Json.kt */
public abstract class Json implements StringFormat {
    public static final Default Default = new Default(null);
    public final DescriptorSchemaCache _schemaCache = new DescriptorSchemaCache();
    public final JsonConfiguration configuration;
    public final SerializersModule serializersModule;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/Json;", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Json.kt */
    public static final class Default extends Json {
        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Default(kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r14 = this;
                kotlinx.serialization.json.JsonConfiguration r15 = new kotlinx.serialization.json.JsonConfiguration
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 4095(0xfff, float:5.738E-42)
                r0 = r15
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                kotlinx.serialization.modules.SerializersModule r0 = kotlinx.serialization.modules.SerializersModuleKt.EmptySerializersModule
                r1 = 0
                r14.<init>(r15, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.Json.Default.<init>(kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule2, DefaultConstructorMarker defaultConstructorMarker) {
        this.configuration = jsonConfiguration;
        this.serializersModule = serializersModule2;
    }

    public final <T> T decodeFromString(DeserializationStrategy<T> deserializationStrategy, String str) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        StringJsonLexer stringJsonLexer = new StringJsonLexer(str);
        T decodeSerializableValue = new StreamingJsonDecoder(this, WriteMode.OBJ, stringJsonLexer, deserializationStrategy.getDescriptor()).decodeSerializableValue(deserializationStrategy);
        if (stringJsonLexer.consumeNextToken() == 10) {
            return decodeSerializableValue;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected EOF after parsing an object, but had ");
        outline73.append(stringJsonLexer.source.charAt(stringJsonLexer.currentPosition - 1));
        outline73.append(" instead");
        AbstractJsonLexer.fail$default(stringJsonLexer, outline73.toString(), 0, 2, null);
        throw null;
    }

    public final <T> String encodeToString(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        JsonStringBuilder jsonStringBuilder = new JsonStringBuilder();
        try {
            new StreamingJsonEncoder(jsonStringBuilder, this, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]).encodeSerializableValue(serializationStrategy, t);
            return jsonStringBuilder.toString();
        } finally {
            jsonStringBuilder.release();
        }
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
