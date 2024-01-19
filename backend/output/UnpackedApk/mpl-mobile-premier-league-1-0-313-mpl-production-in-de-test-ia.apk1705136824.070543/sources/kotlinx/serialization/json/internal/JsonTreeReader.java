package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J!\u0010\u000f\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "stackDepth", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readDeepRecursive", "readObject", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonTreeReader.kt */
public final class JsonTreeReader {
    public final boolean isLenient;
    public final AbstractJsonLexer lexer;
    public int stackDepth;

    public JsonTreeReader(JsonConfiguration jsonConfiguration, AbstractJsonLexer abstractJsonLexer) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        this.lexer = abstractJsonLexer;
        this.isLenient = jsonConfiguration.isLenient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object access$readObject(kotlinx.serialization.json.internal.JsonTreeReader r17, kotlin.DeepRecursiveScope r18, kotlin.coroutines.Continuation r19) {
        /*
            r0 = r17
            r1 = r19
            r2 = 0
            if (r0 == 0) goto L_0x00f4
            boolean r3 = r1 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r3 == 0) goto L_0x001a
            r3 = r1
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r3 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x001a
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001f
        L_0x001a:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r3 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r3.<init>(r0, r1)
        L_0x001f:
            java.lang.Object r1 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r3.label
            r6 = 7
            r7 = 6
            r8 = 1
            r9 = 2
            r10 = 0
            r11 = 4
            if (r5 == 0) goto L_0x0054
            if (r5 != r8) goto L_0x004c
            java.lang.Object r0 = r3.L$3
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r12 = r3.L$1
            kotlinx.serialization.json.internal.JsonTreeReader r12 = (kotlinx.serialization.json.internal.JsonTreeReader) r12
            java.lang.Object r13 = r3.L$0
            kotlin.DeepRecursiveScope r13 = (kotlin.DeepRecursiveScope) r13
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            r16 = r5
            r5 = r0
            r0 = r12
            r12 = r4
            r4 = r3
            r3 = r16
            goto L_0x00b9
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0054:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            byte r1 = r1.consumeNextToken(r7)
            kotlinx.serialization.json.internal.AbstractJsonLexer r5 = r0.lexer
            byte r5 = r5.peekNextToken()
            if (r5 == r11) goto L_0x00ec
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            r12 = r4
            r4 = r3
            r3 = r1
            r1 = r18
        L_0x006f:
            kotlinx.serialization.json.internal.AbstractJsonLexer r13 = r0.lexer
            boolean r13 = r13.canConsumeValue()
            if (r13 == 0) goto L_0x00d4
            boolean r3 = r0.isLenient
            if (r3 == 0) goto L_0x0082
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r0.lexer
            java.lang.String r3 = r3.consumeStringLenient()
            goto L_0x0088
        L_0x0082:
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r0.lexer
            java.lang.String r3 = r3.consumeString()
        L_0x0088:
            kotlinx.serialization.json.internal.AbstractJsonLexer r13 = r0.lexer
            r14 = 5
            r13.consumeNextToken(r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r4.L$0 = r1
            r4.L$1 = r0
            r4.L$2 = r3
            r4.L$3 = r5
            r4.label = r8
            r14 = r1
            kotlin.DeepRecursiveScopeImpl r14 = (kotlin.DeepRecursiveScopeImpl) r14
            if (r14 == 0) goto L_0x00d3
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r15)
            r14.cont = r4
            r14.value = r13
            kotlin.coroutines.intrinsics.CoroutineSingletons r13 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r13 != r13) goto L_0x00b1
            java.lang.String r14 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
        L_0x00b1:
            if (r13 != r12) goto L_0x00b4
            goto L_0x00e3
        L_0x00b4:
            r16 = r13
            r13 = r1
            r1 = r16
        L_0x00b9:
            kotlinx.serialization.json.JsonElement r1 = (kotlinx.serialization.json.JsonElement) r1
            r5.put(r3, r1)
            kotlinx.serialization.json.internal.AbstractJsonLexer r1 = r0.lexer
            byte r3 = r1.consumeNextToken()
            if (r3 == r11) goto L_0x00d1
            if (r3 != r6) goto L_0x00c9
            goto L_0x00d1
        L_0x00c9:
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.lexer
            java.lang.String r1 = "Expected end of the object or comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r0, r1, r10, r9, r2)
            throw r2
        L_0x00d1:
            r1 = r13
            goto L_0x006f
        L_0x00d3:
            throw r2
        L_0x00d4:
            if (r3 != r7) goto L_0x00dc
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.lexer
            r0.consumeNextToken(r6)
            goto L_0x00de
        L_0x00dc:
            if (r3 == r11) goto L_0x00e4
        L_0x00de:
            kotlinx.serialization.json.JsonObject r12 = new kotlinx.serialization.json.JsonObject
            r12.<init>(r5)
        L_0x00e3:
            return r12
        L_0x00e4:
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.lexer
            java.lang.String r1 = "Unexpected trailing comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r0, r1, r10, r9, r2)
            throw r2
        L_0x00ec:
            kotlinx.serialization.json.internal.AbstractJsonLexer r0 = r0.lexer
            java.lang.String r1 = "Unexpected leading comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.fail$default(r0, r1, r10, r9, r2)
            throw r2
        L_0x00f4:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.access$readObject(kotlinx.serialization.json.internal.JsonTreeReader, kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JsonElement read() {
        JsonElement jsonElement;
        String str;
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            int i = this.stackDepth + 1;
            this.stackDepth = i;
            if (i == 200) {
                jsonElement = (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
            } else {
                byte consumeNextToken = this.lexer.consumeNextToken(6);
                if (this.lexer.peekNextToken() != 4) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    while (this.lexer.canConsumeValue()) {
                        if (this.isLenient) {
                            str = this.lexer.consumeStringLenient();
                        } else {
                            str = this.lexer.consumeString();
                        }
                        this.lexer.consumeNextToken(5);
                        linkedHashMap.put(str, read());
                        consumeNextToken = this.lexer.consumeNextToken();
                        if (consumeNextToken != 4 && consumeNextToken != 7) {
                            AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, 2, null);
                            throw null;
                        }
                    }
                    if (consumeNextToken == 6) {
                        this.lexer.consumeNextToken(7);
                    } else if (consumeNextToken == 4) {
                        AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, null);
                        throw null;
                    }
                    jsonElement = new JsonObject(linkedHashMap);
                } else {
                    AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, null);
                    throw null;
                }
            }
            this.stackDepth--;
            return jsonElement;
        } else if (peekNextToken == 8) {
            return readArray();
        } else {
            AbstractJsonLexer.fail$default(this.lexer, Intrinsics.stringPlus("Cannot begin reading element, unexpected token: ", Byte.valueOf(peekNextToken)), 0, 2, null);
            throw null;
        }
    }

    public final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.lexer.canConsumeValue()) {
                arrayList.add(read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    AbstractJsonLexer abstractJsonLexer = this.lexer;
                    boolean z = consumeNextToken == 9;
                    int i = abstractJsonLexer.currentPosition;
                    if (!z) {
                        abstractJsonLexer.fail("Expected end of the array or comma", i);
                        throw null;
                    }
                }
            }
            if (consumeNextToken == 8) {
                this.lexer.consumeNextToken(9);
            } else if (consumeNextToken == 4) {
                AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, null);
                throw null;
            }
            return new JsonArray(arrayList);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, null);
        throw null;
    }

    public final JsonPrimitive readValue(boolean z) {
        String str;
        if (this.isLenient || !z) {
            str = this.lexer.consumeStringLenient();
        } else {
            str = this.lexer.consumeString();
        }
        if (z || !Intrinsics.areEqual(str, "null")) {
            return new JsonLiteral(str, z);
        }
        return JsonNull.INSTANCE;
    }
}
