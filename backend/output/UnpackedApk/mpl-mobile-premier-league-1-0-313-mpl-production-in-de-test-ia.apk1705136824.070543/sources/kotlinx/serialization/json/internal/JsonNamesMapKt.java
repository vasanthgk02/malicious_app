package kotlinx.serialization.json.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.internal.DescriptorSchemaCache.Key;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\nH\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001aF\u0010\u0010\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H\bø\u0001\u0000\".\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"JsonAlternativeNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "", "", "", "getJsonAlternativeNamesKey$annotations", "()V", "getJsonAlternativeNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "buildAlternativeNamesMap", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonNameIndex", "json", "Lkotlinx/serialization/json/Json;", "name", "getJsonNameIndexOrThrow", "tryCoerceValue", "", "elementDescriptor", "peekNull", "Lkotlin/Function0;", "peekString", "onEnumCoercing", "", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonNamesMap.kt */
public final class JsonNamesMapKt {
    public static final Key<Map<String, Integer>> JsonAlternativeNamesKey = new Key<>();

    public static final Map<String, Integer> buildAlternativeNamesMap(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        int elementsCount = serialDescriptor.getElementsCount();
        Map map = null;
        if (elementsCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                List<Annotation> elementAnnotations = serialDescriptor.getElementAnnotations(i);
                ArrayList arrayList = new ArrayList();
                for (T next : elementAnnotations) {
                    if (next instanceof JsonNames) {
                        arrayList.add(next);
                    }
                }
                JsonNames jsonNames = (JsonNames) ArraysKt___ArraysJvmKt.singleOrNull((List<? extends T>) arrayList);
                if (jsonNames != null) {
                    String[] names = jsonNames.names();
                    if (names != null) {
                        int length = names.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String str = names[i3];
                            if (map == null) {
                                map = new ConcurrentHashMap(serialDescriptor.getElementsCount());
                            }
                            Intrinsics.checkNotNull(map);
                            if (!map.containsKey(str)) {
                                map.put(str, Integer.valueOf(i));
                                i3++;
                            } else {
                                StringBuilder outline80 = GeneratedOutlineSupport.outline80("The suggested name '", str, "' for property ");
                                outline80.append(serialDescriptor.getElementName(i));
                                outline80.append(" is already one of the names for property ");
                                outline80.append(serialDescriptor.getElementName(((Number) ArraysKt___ArraysJvmKt.getValue(map, str)).intValue()));
                                outline80.append(" in ");
                                outline80.append(serialDescriptor);
                                throw new JsonException(outline80.toString());
                            }
                        }
                    }
                }
                if (i2 >= elementsCount) {
                    break;
                }
                i = i2;
            }
        }
        return map == null ? ArraysKt___ArraysJvmKt.emptyMap() : map;
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        int elementIndex = serialDescriptor.getElementIndex(str);
        int i = -3;
        if (elementIndex != -3 || !json.configuration.useAlternativeNames) {
            return elementIndex;
        }
        Integer num = (Integer) ((Map) TypeUtilsKt.getSchemaCache(json).getOrPut(serialDescriptor, JsonAlternativeNamesKey, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(serialDescriptor))).get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, str);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + str + ExtendedMessageFormat.QUOTE);
    }
}
