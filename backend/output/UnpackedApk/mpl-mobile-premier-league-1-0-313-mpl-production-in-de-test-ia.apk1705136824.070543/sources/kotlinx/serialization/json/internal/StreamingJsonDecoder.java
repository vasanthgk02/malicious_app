package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001dH\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J!\u00109\u001a\u0002H:\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<H\u0016¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020AH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006F"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "currentIndex", "", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkLeadingComma", "", "coerceInputValue", "", "index", "decodeBoolean", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInt", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "decodeStringKey", "endStructure", "handleUnknown", "key", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StreamingJsonDecoder.kt */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public int currentIndex = -1;
    public final JsonElementMarker elementMarker;
    public final Json json;
    public final AbstractJsonLexer lexer;
    public final WriteMode mode;
    public final SerializersModule serializersModule;

    public StreamingJsonDecoder(Json json2, WriteMode writeMode, AbstractJsonLexer abstractJsonLexer, SerialDescriptor serialDescriptor) {
        JsonElementMarker jsonElementMarker;
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, "mode");
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.json = json2;
        this.mode = writeMode;
        this.lexer = abstractJsonLexer;
        this.serializersModule = json2.serializersModule;
        JsonConfiguration jsonConfiguration = json2.configuration;
        this.configuration = jsonConfiguration;
        if (jsonConfiguration.explicitNulls) {
            jsonElementMarker = null;
        } else {
            jsonElementMarker = new JsonElementMarker(serialDescriptor);
        }
        this.elementMarker = jsonElementMarker;
    }

    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode switchMode = TypeUtilsKt.switchMode(this.json, serialDescriptor);
        this.lexer.consumeNextToken(switchMode.begin);
        if (this.lexer.peekNextToken() != 4) {
            int ordinal = switchMode.ordinal();
            if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
                return new StreamingJsonDecoder(this.json, switchMode, this.lexer, serialDescriptor);
            }
            if (this.mode != switchMode || !this.json.configuration.explicitNulls) {
                return new StreamingJsonDecoder(this.json, switchMode, this.lexer, serialDescriptor);
            }
            return this;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, null);
        throw null;
    }

    public boolean decodeBoolean() {
        boolean z;
        if (this.configuration.isLenient) {
            AbstractJsonLexer abstractJsonLexer = this.lexer;
            int skipWhitespaces = abstractJsonLexer.skipWhitespaces();
            StringJsonLexer stringJsonLexer = (StringJsonLexer) abstractJsonLexer;
            if (skipWhitespaces != stringJsonLexer.source.length()) {
                if (stringJsonLexer.source.charAt(skipWhitespaces) == '\"') {
                    skipWhitespaces++;
                    z = true;
                } else {
                    z = false;
                }
                boolean consumeBoolean = abstractJsonLexer.consumeBoolean(skipWhitespaces);
                if (!z) {
                    return consumeBoolean;
                }
                if (abstractJsonLexer.currentPosition == stringJsonLexer.source.length()) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, 2, null);
                    throw null;
                } else if (stringJsonLexer.source.charAt(abstractJsonLexer.currentPosition) == '\"') {
                    abstractJsonLexer.currentPosition++;
                    return consumeBoolean;
                } else {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected closing quotation mark", 0, 2, null);
                    throw null;
                }
            } else {
                AbstractJsonLexer.fail$default(abstractJsonLexer, "EOF", 0, 2, null);
                throw null;
            }
        } else {
            AbstractJsonLexer abstractJsonLexer2 = this.lexer;
            return abstractJsonLexer2.consumeBoolean(abstractJsonLexer2.skipWhitespaces());
        }
    }

    public byte decodeByte() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        byte b2 = (byte) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) b2)) {
            return b2;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse byte for input '" + consumeNumericLiteral + ExtendedMessageFormat.QUOTE, 0, 2, null);
        throw null;
    }

    public char decodeChar() {
        String consumeStringLenient = this.lexer.consumeStringLenient();
        if (consumeStringLenient.length() == 1) {
            return consumeStringLenient.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected single char, but got '" + consumeStringLenient + ExtendedMessageFormat.QUOTE, 0, 2, null);
        throw null;
    }

    public double decodeDouble() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            double parseDouble = Double.parseDouble(consumeStringLenient);
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z = true;
                }
                if (!z) {
                    TypeUtilsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(parseDouble));
                    throw null;
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + "double" + "' for input '" + consumeStringLenient + ExtendedMessageFormat.QUOTE, 0, 2, null);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x0137 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlinx.serialization.json.internal.WriteMode r2 = r0.mode
            int r2 = r2.ordinal()
            r3 = 58
            java.lang.String r4 = "Unexpected trailing comma"
            r5 = -1
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x00a1
            if (r2 == r6) goto L_0x004b
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            boolean r1 = r1.tryConsumeComma()
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            boolean r2 = r2.canConsumeValue()
            if (r2 == 0) goto L_0x0041
            int r2 = r0.currentIndex
            if (r2 == r5) goto L_0x0039
            if (r1 == 0) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            java.lang.String r2 = "Expected end of the array or comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r2, r8, r6, r9)
            throw r9
        L_0x0039:
            int r1 = r0.currentIndex
            int r5 = r1 + 1
            r0.currentIndex = r5
            goto L_0x02b9
        L_0x0041:
            if (r1 != 0) goto L_0x0045
            goto L_0x02b9
        L_0x0045:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r4, r8, r6, r9)
            throw r9
        L_0x004b:
            int r1 = r0.currentIndex
            int r1 = r1 % r6
            if (r1 == 0) goto L_0x0052
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            if (r1 == 0) goto L_0x0060
            int r2 = r0.currentIndex
            if (r2 == r5) goto L_0x0065
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            boolean r2 = r2.tryConsumeComma()
            goto L_0x0066
        L_0x0060:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            r2.consumeNextToken(r3)
        L_0x0065:
            r2 = 0
        L_0x0066:
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r0.lexer
            boolean r3 = r3.canConsumeValue()
            if (r3 == 0) goto L_0x0095
            if (r1 == 0) goto L_0x008d
            int r1 = r0.currentIndex
            if (r1 != r5) goto L_0x0080
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            r2 = r2 ^ r7
            int r3 = r1.currentPosition
            if (r2 == 0) goto L_0x007c
            goto L_0x008d
        L_0x007c:
            r1.fail(r4, r3)
            throw r9
        L_0x0080:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            int r3 = r1.currentPosition
            if (r2 == 0) goto L_0x0087
            goto L_0x008d
        L_0x0087:
            java.lang.String r2 = "Expected comma after the key-value pair"
            r1.fail(r2, r3)
            throw r9
        L_0x008d:
            int r1 = r0.currentIndex
            int r5 = r1 + 1
            r0.currentIndex = r5
            goto L_0x02b9
        L_0x0095:
            if (r2 != 0) goto L_0x0099
            goto L_0x02b9
        L_0x0099:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            java.lang.String r2 = "Expected '}', but had ',' instead"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r2, r8, r6, r9)
            throw r9
        L_0x00a1:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            boolean r2 = r2.tryConsumeComma()
        L_0x00a7:
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r0.lexer
            boolean r10 = r10.canConsumeValue()
            r11 = 64
            r12 = 1
            if (r10 == 0) goto L_0x023a
            kotlinx.serialization.json.JsonConfiguration r2 = r0.configuration
            boolean r2 = r2.isLenient
            if (r2 == 0) goto L_0x00c0
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            java.lang.String r2 = r2.consumeStringLenientNotNull()
            goto L_0x00c6
        L_0x00c0:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            java.lang.String r2 = r2.consumeKeyString()
        L_0x00c6:
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r0.lexer
            r10.consumeNextToken(r3)
            kotlinx.serialization.json.Json r10 = r0.json
            int r10 = kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r1, r10, r2)
            r14 = -3
            if (r10 == r14) goto L_0x015a
            kotlinx.serialization.json.JsonConfiguration r15 = r0.configuration
            boolean r15 = r15.coerceInputValues
            if (r15 == 0) goto L_0x0137
            kotlinx.serialization.json.Json r15 = r0.json
            kotlinx.serialization.descriptors.SerialDescriptor r3 = r1.getElementDescriptor(r10)
            boolean r16 = r3.isNullable()
            if (r16 != 0) goto L_0x00f0
            kotlinx.serialization.json.internal.AbstractJsonLexer r6 = r0.lexer
            boolean r6 = r6.tryConsumeNotNull()
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x00f0
            goto L_0x012a
        L_0x00f0:
            kotlinx.serialization.descriptors.SerialKind r6 = r3.getKind()
            kotlinx.serialization.descriptors.SerialKind$ENUM r8 = kotlinx.serialization.descriptors.SerialKind.ENUM.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r8)
            if (r6 == 0) goto L_0x012c
            kotlinx.serialization.json.internal.AbstractJsonLexer r6 = r0.lexer
            kotlinx.serialization.json.JsonConfiguration r8 = r0.configuration
            boolean r8 = r8.isLenient
            byte r9 = r6.peekNextToken()
            if (r8 == 0) goto L_0x0112
            if (r9 == r7) goto L_0x010d
            if (r9 == 0) goto L_0x010d
            goto L_0x0114
        L_0x010d:
            java.lang.String r8 = r6.consumeStringLenient()
            goto L_0x011a
        L_0x0112:
            if (r9 == r7) goto L_0x0116
        L_0x0114:
            r8 = 0
            goto L_0x011c
        L_0x0116:
            java.lang.String r8 = r6.consumeString()
        L_0x011a:
            r6.peekedString = r8
        L_0x011c:
            if (r8 != 0) goto L_0x011f
            goto L_0x012c
        L_0x011f:
            int r3 = kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r3, r15, r8)
            if (r3 != r14) goto L_0x012c
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r0.lexer
            r3.consumeString()
        L_0x012a:
            r3 = 1
            goto L_0x012d
        L_0x012c:
            r3 = 0
        L_0x012d:
            if (r3 == 0) goto L_0x0137
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r0.lexer
            boolean r3 = r3.tryConsumeComma()
            r6 = 0
            goto L_0x015c
        L_0x0137:
            kotlinx.serialization.json.internal.JsonElementMarker r1 = r0.elementMarker
            if (r1 != 0) goto L_0x013c
            goto L_0x0157
        L_0x013c:
            kotlinx.serialization.internal.ElementMarker r1 = r1.origin
            if (r10 >= r11) goto L_0x0148
            long r2 = r1.lowerMarks
            long r4 = r12 << r10
            long r2 = r2 | r4
            r1.lowerMarks = r2
            goto L_0x0157
        L_0x0148:
            int r2 = r10 >>> 6
            int r2 = r2 + r5
            r3 = r10 & 63
            long[] r1 = r1.highMarksArray
            r4 = r1[r2]
            long r6 = r12 << r3
            long r3 = r6 | r4
            r1[r2] = r3
        L_0x0157:
            r5 = r10
            goto L_0x02b9
        L_0x015a:
            r3 = 0
            r6 = 1
        L_0x015c:
            if (r6 == 0) goto L_0x0232
            kotlinx.serialization.json.JsonConfiguration r3 = r0.configuration
            boolean r6 = r3.ignoreUnknownKeys
            r8 = 6
            if (r6 == 0) goto L_0x0201
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            boolean r3 = r3.isLenient
            if (r2 == 0) goto L_0x01ff
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            byte r9 = r2.peekNextToken()
            r10 = 8
            if (r9 == r10) goto L_0x017f
            if (r9 == r8) goto L_0x017f
            r2.consumeStringLenient()
            goto L_0x01ef
        L_0x017f:
            byte r9 = r2.peekNextToken()
            if (r9 != r7) goto L_0x018f
            if (r3 == 0) goto L_0x018b
            r2.consumeStringLenient()
            goto L_0x017f
        L_0x018b:
            r2.consumeKeyString()
            goto L_0x017f
        L_0x018f:
            if (r9 != r10) goto L_0x0192
            goto L_0x0194
        L_0x0192:
            if (r9 != r8) goto L_0x0196
        L_0x0194:
            r11 = 1
            goto L_0x0197
        L_0x0196:
            r11 = 0
        L_0x0197:
            if (r11 == 0) goto L_0x01a1
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r6.add(r9)
            goto L_0x01e6
        L_0x01a1:
            r11 = 9
            if (r9 != r11) goto L_0x01c2
            java.lang.Object r9 = kotlin.collections.ArraysKt___ArraysJvmKt.last(r6)
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            if (r9 != r10) goto L_0x01b5
            com.twitter.sdk.android.tweetui.TweetUtils.removeLast(r6)
            goto L_0x01e6
        L_0x01b5:
            int r1 = r2.currentPosition
            kotlinx.serialization.json.internal.StringJsonLexer r2 = (kotlinx.serialization.json.internal.StringJsonLexer) r2
            java.lang.String r2 = r2.source
            java.lang.String r3 = "found ] instead of }"
            kotlinx.serialization.json.internal.JsonDecodingException r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.JsonDecodingException(r1, r3, r2)
            throw r1
        L_0x01c2:
            r11 = 7
            if (r9 != r11) goto L_0x01e2
            java.lang.Object r9 = kotlin.collections.ArraysKt___ArraysJvmKt.last(r6)
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            if (r9 != r8) goto L_0x01d5
            com.twitter.sdk.android.tweetui.TweetUtils.removeLast(r6)
            goto L_0x01e6
        L_0x01d5:
            int r1 = r2.currentPosition
            kotlinx.serialization.json.internal.StringJsonLexer r2 = (kotlinx.serialization.json.internal.StringJsonLexer) r2
            java.lang.String r2 = r2.source
            java.lang.String r3 = "found } instead of ]"
            kotlinx.serialization.json.internal.JsonDecodingException r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.JsonDecodingException(r1, r3, r2)
            throw r1
        L_0x01e2:
            r11 = 10
            if (r9 == r11) goto L_0x01f6
        L_0x01e6:
            r2.consumeNextToken()
            int r9 = r6.size()
            if (r9 != 0) goto L_0x017f
        L_0x01ef:
            kotlinx.serialization.json.internal.AbstractJsonLexer r2 = r0.lexer
            boolean r2 = r2.tryConsumeComma()
            goto L_0x0233
        L_0x01f6:
            java.lang.String r1 = "Unexpected end of input due to malformed JSON during ignoring unknown keys"
            r3 = 2
            r4 = 0
            r5 = 0
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r2, r1, r4, r3, r5)
            throw r5
        L_0x01ff:
            r5 = 0
            throw r5
        L_0x0201:
            r4 = 0
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            if (r1 == 0) goto L_0x0230
            java.lang.String r3 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            int r3 = r1.currentPosition
            java.lang.String r3 = r1.substring(r4, r3)
            int r3 = kotlin.text.CharsKt__CharKt.lastIndexOf$default(r3, r2, r4, r4, r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Encountered an unknown key '"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys."
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r1.fail(r2, r3)
            r1 = 0
            throw r1
        L_0x0230:
            r1 = 0
            throw r1
        L_0x0232:
            r2 = r3
        L_0x0233:
            r3 = 58
            r6 = 2
            r8 = 0
            r9 = 0
            goto L_0x00a7
        L_0x023a:
            if (r2 != 0) goto L_0x02ba
            kotlinx.serialization.json.internal.JsonElementMarker r1 = r0.elementMarker
            if (r1 != 0) goto L_0x0242
            goto L_0x02b9
        L_0x0242:
            kotlinx.serialization.internal.ElementMarker r1 = r1.origin
            kotlinx.serialization.descriptors.SerialDescriptor r2 = r1.descriptor
            int r2 = r2.getElementsCount()
        L_0x024a:
            long r3 = r1.lowerMarks
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0274
            long r3 = ~r3
            int r3 = java.lang.Long.numberOfTrailingZeros(r3)
            long r6 = r1.lowerMarks
            long r8 = r12 << r3
            long r6 = r6 | r8
            r1.lowerMarks = r6
            kotlin.jvm.functions.Function2<kotlinx.serialization.descriptors.SerialDescriptor, java.lang.Integer, java.lang.Boolean> r4 = r1.readIfAbsent
            kotlinx.serialization.descriptors.SerialDescriptor r6 = r1.descriptor
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            java.lang.Object r4 = r4.invoke(r6, r7)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x024a
            r5 = r3
            goto L_0x02b9
        L_0x0274:
            if (r2 <= r11) goto L_0x02b8
            long[] r2 = r1.highMarksArray
            int r2 = r2.length
            int r2 = r2 + r5
            if (r2 < 0) goto L_0x02b8
            r8 = 0
        L_0x027d:
            int r3 = r8 + 1
            int r4 = r3 * 64
            long[] r9 = r1.highMarksArray
            r10 = r9[r8]
        L_0x0285:
            int r9 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x02ae
            long r14 = ~r10
            int r9 = java.lang.Long.numberOfTrailingZeros(r14)
            long r14 = r12 << r9
            long r10 = r10 | r14
            int r9 = r9 + r4
            kotlin.jvm.functions.Function2<kotlinx.serialization.descriptors.SerialDescriptor, java.lang.Integer, java.lang.Boolean> r14 = r1.readIfAbsent
            kotlinx.serialization.descriptors.SerialDescriptor r15 = r1.descriptor
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.Object r5 = r14.invoke(r15, r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x02ac
            long[] r1 = r1.highMarksArray
            r1[r8] = r10
            r5 = r9
            goto L_0x02b9
        L_0x02ac:
            r5 = -1
            goto L_0x0285
        L_0x02ae:
            long[] r4 = r1.highMarksArray
            r4[r8] = r10
            if (r3 <= r2) goto L_0x02b5
            goto L_0x02b8
        L_0x02b5:
            r8 = r3
            r5 = -1
            goto L_0x027d
        L_0x02b8:
            r5 = -1
        L_0x02b9:
            return r5
        L_0x02ba:
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            r2 = 2
            r3 = 0
            r5 = 0
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r1, r4, r3, r2, r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor):int");
    }

    public int decodeEnum(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, decodeString());
    }

    public float decodeFloat() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            float parseFloat = Float.parseFloat(consumeStringLenient);
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z = true;
                }
                if (!z) {
                    TypeUtilsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(parseFloat));
                    throw null;
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + "float" + "' for input '" + consumeStringLenient + ExtendedMessageFormat.QUOTE, 0, 2, null);
            throw null;
        }
    }

    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(this.lexer, this.json);
        }
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return this;
    }

    public int decodeInt() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        int i = (int) consumeNumericLiteral;
        if (consumeNumericLiteral == ((long) i)) {
            return i;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse int for input '" + consumeNumericLiteral + ExtendedMessageFormat.QUOTE, 0, 2, null);
        throw null;
    }

    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.configuration, this.lexer).read();
    }

    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    public boolean decodeNotNullMark() {
        boolean z;
        JsonElementMarker jsonElementMarker = this.elementMarker;
        if (jsonElementMarker == null) {
            z = false;
        } else {
            z = jsonElementMarker.isUnmarkedNull;
        }
        if (z || !this.lexer.tryConsumeNotNull()) {
            return false;
        }
        return true;
    }

    public Void decodeNull() {
        return null;
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return TypeUtilsKt.decodeSerializableValuePolymorphic(this, deserializationStrategy);
    }

    public short decodeShort() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        short s = (short) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) s)) {
            return s;
        }
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse short for input '" + consumeNumericLiteral + ExtendedMessageFormat.QUOTE, 0, 2, null);
        throw null;
    }

    public String decodeString() {
        if (this.configuration.isLenient) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.lexer.consumeNextToken(this.mode.end);
    }

    public final Json getJson() {
        return this.json;
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}
