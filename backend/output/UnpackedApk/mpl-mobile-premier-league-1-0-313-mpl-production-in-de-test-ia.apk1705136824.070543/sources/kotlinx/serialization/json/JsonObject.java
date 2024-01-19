package kotlinx.serialization.json;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001!B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0001J\u0011\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0001H\u0001J\u0013\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0003J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\t\u0010\u001f\u001a\u00020\u0016H\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b0\u0007X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "", "get", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable(with = JsonObjectSerializer.class)
/* compiled from: JsonElement.kt */
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public final Map<String, JsonElement> content;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: JsonElement.kt */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.INSTANCE;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JsonObject(Map<String, ? extends JsonElement> map) {
        // Intrinsics.checkNotNullParameter(map, "content");
        super(null);
        this.content = map;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object compute(Object obj, BiFunction biFunction) {
        String str = (String) obj;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object computeIfAbsent(Object obj, Function function) {
        String str = (String) obj;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        String str = (String) obj;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "key");
        return this.content.containsKey(str);
    }

    public final boolean containsValue(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        JsonElement jsonElement = (JsonElement) obj;
        Intrinsics.checkNotNullParameter(jsonElement, HSLCriteriaBuilder.VALUE);
        return this.content.containsValue(jsonElement);
    }

    public final Set<Entry<String, JsonElement>> entrySet() {
        return this.content.entrySet();
    }

    public boolean equals(Object obj) {
        return Intrinsics.areEqual(this.content, obj);
    }

    public Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "key");
        return this.content.get(str);
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    public final Set<String> keySet() {
        return this.content.keySet();
    }

    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        String str = (String) obj;
        JsonElement jsonElement = (JsonElement) obj2;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object put(Object obj, Object obj2) {
        String str = (String) obj;
        JsonElement jsonElement = (JsonElement) obj2;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        String str = (String) obj;
        JsonElement jsonElement = (JsonElement) obj2;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object replace(Object obj, Object obj2) {
        String str = (String) obj;
        JsonElement jsonElement = (JsonElement) obj2;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.content.size();
    }

    public String toString() {
        return ArraysKt___ArraysJvmKt.joinToString$default(this.content.entrySet(), ",", "{", "}", 0, null, JsonObject$toString$1.INSTANCE, 24);
    }

    public final Collection<JsonElement> values() {
        return this.content.values();
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        JsonElement jsonElement = (JsonElement) obj2;
        JsonElement jsonElement2 = (JsonElement) obj3;
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
