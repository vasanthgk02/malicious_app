package kotlinx.serialization.json.internal;

import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "forceNull", "", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "absenceIsNull", "descriptor", "index", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "coerceInputValue", "tag", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "decodeNotNullMark", "elementName", "desc", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    public boolean forceNull;
    public final SerialDescriptor polyDescriptor;
    public final String polyDiscriminator;
    public int position;
    public final JsonObject value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i) {
        // int i2 = i & 4;
        // int i3 = i & 8;
        // Intrinsics.checkNotNullParameter(json, "json");
        // Intrinsics.checkNotNullParameter(jsonObject, HSLCriteriaBuilder.VALUE);
        super(json, jsonObject, null);
        this.value = jsonObject;
        this.polyDiscriminator = null;
        this.polyDescriptor = null;
    }

    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (serialDescriptor == this.polyDescriptor) {
            return this;
        }
        return super.beginStructure(serialDescriptor);
    }

    public JsonElement currentElement(String str) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        return (JsonElement) ArraysKt___ArraysJvmKt.getValue(getValue(), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r5, r4, r7) != -3) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
        L_0x0005:
            int r0 = r8.position
            int r1 = r9.getElementsCount()
            if (r0 >= r1) goto L_0x009b
            int r0 = r8.position
            int r1 = r0 + 1
            r8.position = r1
            java.lang.String r0 = r8.getTag(r9, r0)
            int r1 = r8.position
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r8.forceNull = r3
            kotlinx.serialization.json.JsonObject r4 = r8.getValue()
            boolean r4 = r4.containsKey(r0)
            if (r4 != 0) goto L_0x0047
            kotlinx.serialization.json.Json r4 = r8.json
            kotlinx.serialization.json.JsonConfiguration r4 = r4.configuration
            boolean r4 = r4.explicitNulls
            if (r4 != 0) goto L_0x0042
            boolean r4 = r9.isElementOptional(r1)
            if (r4 != 0) goto L_0x0042
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r9.getElementDescriptor(r1)
            boolean r4 = r4.isNullable()
            if (r4 == 0) goto L_0x0042
            r4 = 1
            goto L_0x0043
        L_0x0042:
            r4 = 0
        L_0x0043:
            r8.forceNull = r4
            if (r4 == 0) goto L_0x0005
        L_0x0047:
            kotlinx.serialization.json.JsonConfiguration r4 = r8.configuration
            boolean r4 = r4.coerceInputValues
            if (r4 == 0) goto L_0x009a
            kotlinx.serialization.json.Json r4 = r8.json
            kotlinx.serialization.descriptors.SerialDescriptor r5 = r9.getElementDescriptor(r1)
            boolean r6 = r5.isNullable()
            if (r6 != 0) goto L_0x0062
            kotlinx.serialization.json.JsonElement r6 = r8.currentElement(r0)
            boolean r6 = r6 instanceof kotlinx.serialization.json.JsonNull
            if (r6 == 0) goto L_0x0062
            goto L_0x0098
        L_0x0062:
            kotlinx.serialization.descriptors.SerialKind r6 = r5.getKind()
            kotlinx.serialization.descriptors.SerialKind$ENUM r7 = kotlinx.serialization.descriptors.SerialKind.ENUM.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L_0x0097
            kotlinx.serialization.json.JsonElement r0 = r8.currentElement(r0)
            boolean r6 = r0 instanceof kotlinx.serialization.json.JsonPrimitive
            r7 = 0
            if (r6 == 0) goto L_0x007a
            kotlinx.serialization.json.JsonPrimitive r0 = (kotlinx.serialization.json.JsonPrimitive) r0
            goto L_0x007b
        L_0x007a:
            r0 = r7
        L_0x007b:
            if (r0 != 0) goto L_0x007e
            goto L_0x008c
        L_0x007e:
            java.lang.String r6 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            boolean r6 = r0 instanceof kotlinx.serialization.json.JsonNull
            if (r6 == 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            java.lang.String r7 = r0.getContent()
        L_0x008c:
            if (r7 != 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            int r0 = kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r5, r4, r7)
            r4 = -3
            if (r0 != r4) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r2 = 0
        L_0x0098:
            if (r2 != 0) goto L_0x0005
        L_0x009a:
            return r1
        L_0x009b:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeDecoder.decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor):int");
    }

    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    public String elementName(SerialDescriptor serialDescriptor, int i) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        String elementName = serialDescriptor.getElementName(i);
        if (!this.configuration.useAlternativeNames || getValue().keySet().contains(elementName)) {
            return elementName;
        }
        Map map = (Map) TypeUtilsKt.getSchemaCache(this.json).getOrPut(serialDescriptor, JsonNamesMapKt.JsonAlternativeNamesKey, new JsonTreeDecoder$elementName$alternativeNamesMap$1(serialDescriptor));
        Iterator<T> it = getValue().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Integer num = (Integer) map.get((String) t);
            if (num != null && num.intValue() == i) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        String str = (String) t;
        if (str != null) {
            elementName = str;
        }
        return elementName;
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Set<String> set;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.configuration.ignoreUnknownKeys && !(serialDescriptor.getKind() instanceof PolymorphicKind)) {
            if (!this.configuration.useAlternativeNames) {
                set = TypeUtilsKt.jsonCachedSerialNames(serialDescriptor);
            } else {
                Set jsonCachedSerialNames = TypeUtilsKt.jsonCachedSerialNames(serialDescriptor);
                Map map = (Map) TypeUtilsKt.getSchemaCache(this.json).get(serialDescriptor, JsonNamesMapKt.JsonAlternativeNamesKey);
                Iterable keySet = map == null ? null : map.keySet();
                if (keySet == null) {
                    keySet = EmptySet.INSTANCE;
                }
                set = ArraysKt___ArraysJvmKt.plus(jsonCachedSerialNames, keySet);
            }
            for (String next : getValue().keySet()) {
                if (!set.contains(next) && !Intrinsics.areEqual(next, this.polyDiscriminator)) {
                    String jsonObject = getValue().toString();
                    Intrinsics.checkNotNullParameter(next, "key");
                    Intrinsics.checkNotNullParameter(jsonObject, "input");
                    throw TypeUtilsKt.JsonDecodingException(-1, "Encountered unknown key '" + next + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + TypeUtilsKt.minify$default(jsonObject, 0, 1));
                }
            }
        }
    }

    public JsonObject getValue() {
        return this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        // Intrinsics.checkNotNullParameter(json, "json");
        // Intrinsics.checkNotNullParameter(jsonObject, HSLCriteriaBuilder.VALUE);
        super(json, jsonObject, null);
        this.value = jsonObject;
        this.polyDiscriminator = str;
        this.polyDescriptor = serialDescriptor;
    }
}
