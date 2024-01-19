package kotlinx.serialization.json.internal;

import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
public final class JsonTreeMapDecoder extends JsonTreeDecoder {
    public final List<String> keys;
    public int position = -1;
    public final int size;
    public final JsonObject value;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonTreeMapDecoder(Json json, JsonObject jsonObject) {
        // Intrinsics.checkNotNullParameter(json, "json");
        // Intrinsics.checkNotNullParameter(jsonObject, HSLCriteriaBuilder.VALUE);
        super(json, jsonObject, null, null, 12);
        this.value = jsonObject;
        List<String> list = ArraysKt___ArraysJvmKt.toList(jsonObject.keySet());
        this.keys = list;
        this.size = list.size() * 2;
    }

    public JsonElement currentElement(String str) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        if (this.position % 2 == 0) {
            return new JsonLiteral(str, true);
        }
        return (JsonElement) ArraysKt___ArraysJvmKt.getValue(this.value, str);
    }

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i = this.position;
        if (i >= this.size - 1) {
            return -1;
        }
        int i2 = i + 1;
        this.position = i2;
        return i2;
    }

    public String elementName(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        return this.keys.get(i / 2);
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public JsonElement getValue() {
        return this.value;
    }

    /* renamed from: getValue  reason: collision with other method in class */
    public JsonObject m990getValue() {
        return this.value;
    }
}
