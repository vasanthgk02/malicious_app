package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0002\u0010\u000bB/\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020/H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020!2\u0006\u0010\"\u001a\u00020+H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010\"\u001a\u000208H\u0016J\b\u00109\u001a\u00020!H\u0016J?\u0010:\u001a\u00020!\"\b\b\u0000\u0010;*\u00020<2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H;0>2\b\u0010\"\u001a\u0004\u0018\u0001H;H\u0016¢\u0006\u0002\u0010?J)\u0010@\u001a\u00020!\"\u0004\b\u0000\u0010;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H;0>2\u0006\u0010\"\u001a\u0002H;H\u0016¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020!2\u0006\u0010\"\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010G\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nX\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006H"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "output", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "composer", "Lkotlinx/serialization/json/internal/Composer;", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonEncoder;", "polymorphicDiscriminator", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInline", "Lkotlinx/serialization/encoding/Encoder;", "inlineDescriptor", "encodeInt", "encodeJsonElement", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StreamingJsonEncoder.kt */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    public final Composer composer;
    public final JsonConfiguration configuration;
    public boolean forceQuoting;
    public final Json json;
    public final WriteMode mode;
    public final JsonEncoder[] modeReuseCache;
    public String polymorphicDiscriminator;
    public final SerializersModule serializersModule;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StreamingJsonEncoder(JsonStringBuilder jsonStringBuilder, Json json2, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        // Intrinsics.checkNotNullParameter(jsonStringBuilder, "output");
        // Intrinsics.checkNotNullParameter(json2, "json");
        // Intrinsics.checkNotNullParameter(writeMode, "mode");
        // Intrinsics.checkNotNullParameter(jsonEncoderArr, "modeReuseCache");
        // Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        // Intrinsics.checkNotNullParameter(json2, "json");
        this(json2.configuration.prettyPrint ? new ComposerWithPrettyPrint(jsonStringBuilder, json2) : new Composer(jsonStringBuilder), json2, writeMode, jsonEncoderArr);
    }

    public CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode switchMode = TypeUtilsKt.switchMode(this.json, serialDescriptor);
        char c2 = switchMode.begin;
        if (c2 != 0) {
            this.composer.print(c2);
            this.composer.indent();
        }
        JsonEncoder jsonEncoder = null;
        if (this.polymorphicDiscriminator != null) {
            this.composer.nextItem();
            String str = this.polymorphicDiscriminator;
            Intrinsics.checkNotNull(str);
            encodeString(str);
            this.composer.print(':');
            this.composer.space();
            encodeString(serialDescriptor.getSerialName());
            this.polymorphicDiscriminator = null;
        }
        if (this.mode == switchMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        if (jsonEncoderArr != null) {
            jsonEncoder = jsonEncoderArr[switchMode.ordinal()];
        }
        if (jsonEncoder == null) {
            jsonEncoder = new StreamingJsonEncoder(this.composer, this.json, switchMode, this.modeReuseCache);
        }
        return jsonEncoder;
    }

    public void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            this.composer.sb.append(String.valueOf(z));
        }
    }

    public void encodeByte(byte b2) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(b2));
        } else {
            this.composer.print(b2);
        }
    }

    public void encodeChar(char c2) {
        encodeString(String.valueOf(c2));
    }

    public void encodeDouble(double d2) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(d2));
        } else {
            this.composer.sb.append(String.valueOf(d2));
        }
        if (!this.configuration.allowSpecialFloatingPointValues) {
            if (!(!Double.isInfinite(d2) && !Double.isNaN(d2))) {
                throw TypeUtilsKt.InvalidFloatingPointEncoded(Double.valueOf(d2), this.composer.sb.toString());
            }
        }
    }

    public boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int ordinal = this.mode.ordinal();
        if (ordinal != 1) {
            boolean z = false;
            if (ordinal == 2) {
                Composer composer2 = this.composer;
                if (!composer2.writingFirst) {
                    if (i % 2 == 0) {
                        composer2.print(',');
                        this.composer.nextItem();
                        z = true;
                    } else {
                        composer2.print(':');
                        this.composer.space();
                    }
                    this.forceQuoting = z;
                } else {
                    this.forceQuoting = true;
                    composer2.nextItem();
                }
            } else if (ordinal != 3) {
                Composer composer3 = this.composer;
                if (!composer3.writingFirst) {
                    composer3.print(',');
                }
                this.composer.nextItem();
                encodeString(serialDescriptor.getElementName(i));
                this.composer.print(':');
                this.composer.space();
            } else {
                if (i == 0) {
                    this.forceQuoting = true;
                }
                if (i == 1) {
                    this.composer.print(',');
                    this.composer.space();
                    this.forceQuoting = false;
                }
            }
        } else {
            Composer composer4 = this.composer;
            if (!composer4.writingFirst) {
                composer4.print(',');
            }
            this.composer.nextItem();
        }
        return true;
    }

    public void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        encodeString(serialDescriptor.getElementName(i));
    }

    public void encodeFloat(float f2) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(f2));
        } else {
            this.composer.sb.append(String.valueOf(f2));
        }
        if (!this.configuration.allowSpecialFloatingPointValues) {
            if (!(!Float.isInfinite(f2) && !Float.isNaN(f2))) {
                throw TypeUtilsKt.InvalidFloatingPointEncoded(Float.valueOf(f2), this.composer.sb.toString());
            }
        }
    }

    public Encoder encodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new StreamingJsonEncoder((Composer) new ComposerForUnsignedNumbers(this.composer.sb), this.json, this.mode, (JsonEncoder[]) null);
        }
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return this;
    }

    public void encodeInt(int i) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(i));
        } else {
            this.composer.print(i);
        }
    }

    public void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    public void encodeNull() {
        this.composer.print((String) "null");
    }

    public <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (t != null || this.configuration.explicitNulls) {
            super.encodeNullableSerializableElement(serialDescriptor, i, serializationStrategy, t);
        }
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || this.json.configuration.useArrayPolymorphism) {
            serializationStrategy.serialize(this, t);
            return;
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
        String classDiscriminator = TypeUtilsKt.classDiscriminator(serializationStrategy.getDescriptor(), this.json);
        if (t != null) {
            SerializationStrategy findPolymorphicSerializer = TypeUtilsKt.findPolymorphicSerializer(abstractPolymorphicSerializer, (Encoder) this, t);
            SerialKind kind = findPolymorphicSerializer.getDescriptor().getKind();
            Intrinsics.checkNotNullParameter(kind, "kind");
            if (kind instanceof ENUM) {
                throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
            } else if (kind instanceof PrimitiveKind) {
                throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
            } else if (!(kind instanceof PolymorphicKind)) {
                this.polymorphicDiscriminator = classDiscriminator;
                findPolymorphicSerializer.serialize(this, t);
            } else {
                throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
    }

    public void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(s));
        } else {
            this.composer.print(s);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6 A[LOOP:1: B:13:0x004f->B:24:0x00a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8 A[EDGE_INSN: B:33:0x00a8->B:25:0x00a8 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encodeString(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.json.internal.Composer r1 = r12.composer
            r2 = 0
            if (r1 == 0) goto L_0x00c1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.json.internal.JsonStringBuilder r0 = r1.sb
            if (r0 == 0) goto L_0x00c0
            java.lang.String r1 = "string"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            int r1 = r13.length()
            r2 = 2
            int r1 = r1 + r2
            int r3 = r0.size
            r0.ensureTotalCapacity(r3, r1)
            char[] r1 = r0.array
            int r3 = r0.size
            int r4 = r3 + 1
            r5 = 34
            r1[r3] = r5
            int r3 = r13.length()
            r6 = 0
            r13.getChars(r6, r3, r1, r4)
            int r3 = r3 + r4
            if (r4 >= r3) goto L_0x00b9
            r7 = r4
        L_0x0039:
            int r8 = r7 + 1
            char r9 = r1[r7]
            byte[] r10 = kotlinx.serialization.json.internal.StringOpsKt.ESCAPE_MARKERS
            int r11 = r10.length
            if (r9 >= r11) goto L_0x00b4
            byte r9 = r10[r9]
            if (r9 == 0) goto L_0x00b4
            int r1 = r7 - r4
            int r3 = r13.length()
            r4 = 1
            if (r1 >= r3) goto L_0x00a8
        L_0x004f:
            int r8 = r1 + 1
            r0.ensureTotalCapacity(r7, r2)
            char r1 = r13.charAt(r1)
            byte[] r9 = kotlinx.serialization.json.internal.StringOpsKt.ESCAPE_MARKERS
            int r10 = r9.length
            if (r1 >= r10) goto L_0x009b
            byte r9 = r9[r1]
            if (r9 != 0) goto L_0x0069
            char[] r9 = r0.array
            int r10 = r7 + 1
            char r1 = (char) r1
            r9[r7] = r1
            goto L_0x00a2
        L_0x0069:
            if (r9 != r4) goto L_0x008b
            java.lang.String[] r9 = kotlinx.serialization.json.internal.StringOpsKt.ESCAPE_STRINGS
            r1 = r9[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r9 = r1.length()
            r0.ensureTotalCapacity(r7, r9)
            char[] r9 = r0.array
            int r10 = r1.length()
            r1.getChars(r6, r10, r9, r7)
            int r1 = r1.length()
            int r1 = r1 + r7
            r0.size = r1
            r7 = r1
            goto L_0x00a3
        L_0x008b:
            char[] r1 = r0.array
            r10 = 92
            r1[r7] = r10
            int r10 = r7 + 1
            char r9 = (char) r9
            r1[r10] = r9
            int r7 = r7 + 2
            r0.size = r7
            goto L_0x00a3
        L_0x009b:
            char[] r9 = r0.array
            int r10 = r7 + 1
            char r1 = (char) r1
            r9[r7] = r1
        L_0x00a2:
            r7 = r10
        L_0x00a3:
            if (r8 < r3) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r1 = r8
            goto L_0x004f
        L_0x00a8:
            r0.ensureTotalCapacity(r7, r4)
            char[] r13 = r0.array
            int r1 = r7 + 1
            r13[r7] = r5
            r0.size = r1
            goto L_0x00bf
        L_0x00b4:
            if (r8 < r3) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r7 = r8
            goto L_0x0039
        L_0x00b9:
            int r13 = r3 + 1
            r1[r3] = r5
            r0.size = r13
        L_0x00bf:
            return
        L_0x00c0:
            throw r2
        L_0x00c1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.encodeString(java.lang.String):void");
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.unIndent();
            this.composer.nextItem();
            this.composer.print(this.mode.end);
        }
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.configuration.encodeDefaults;
    }

    public StreamingJsonEncoder(Composer composer2, Json json2, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer2, "composer");
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, "mode");
        this.composer = composer2;
        this.json = json2;
        this.mode = writeMode;
        this.modeReuseCache = jsonEncoderArr;
        this.serializersModule = json2.serializersModule;
        this.configuration = json2.configuration;
        int ordinal = writeMode.ordinal();
        JsonEncoder[] jsonEncoderArr2 = this.modeReuseCache;
        if (jsonEncoderArr2 == null) {
            return;
        }
        if (jsonEncoderArr2[ordinal] != null || jsonEncoderArr2[ordinal] != this) {
            this.modeReuseCache[ordinal] = this;
        }
    }
}
