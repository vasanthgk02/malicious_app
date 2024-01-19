package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImpl$_descriptor$1 extends Lambda implements Function0<PropertyDescriptor> {
    public final /* synthetic */ KPropertyImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPropertyImpl$_descriptor$1(KPropertyImpl kPropertyImpl) {
        // this.this$0 = kPropertyImpl;
        super(0);
    }

    public Object invoke() {
        String str;
        KPropertyImpl kPropertyImpl = this.this$0;
        KDeclarationContainerImpl kDeclarationContainerImpl = kPropertyImpl.container;
        String str2 = kPropertyImpl.name;
        String str3 = kPropertyImpl.signature;
        MatcherMatchResult matcherMatchResult = null;
        if (kDeclarationContainerImpl != null) {
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "signature");
            Regex regex = KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
            if (regex != null) {
                Intrinsics.checkNotNullParameter(str3, "input");
                Matcher matcher = regex.nativePattern.matcher(str3);
                Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
                if (matcher.matches()) {
                    matcherMatchResult = new MatcherMatchResult(matcher, str3);
                }
                boolean z = true;
                if (matcherMatchResult != null) {
                    String str4 = matcherMatchResult.getDestructured().match.getGroupValues().get(1);
                    PropertyDescriptor localProperty = kDeclarationContainerImpl.getLocalProperty(Integer.parseInt(str4));
                    if (localProperty != null) {
                        return localProperty;
                    }
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("Local property #", str4, " not found in ");
                    outline80.append(kDeclarationContainerImpl.getJClass());
                    throw new KotlinReflectionInternalError(outline80.toString());
                }
                Name identifier = Name.identifier(str2);
                Intrinsics.checkNotNullExpressionValue(identifier, "Name.identifier(name)");
                Collection<PropertyDescriptor> properties = kDeclarationContainerImpl.getProperties(identifier);
                ArrayList arrayList = new ArrayList();
                for (T next : properties) {
                    RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.INSTANCE;
                    if (Intrinsics.areEqual(RuntimeTypeMapper.mapPropertySignature((PropertyDescriptor) next).asString(), str3)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.isEmpty()) {
                    StringBuilder outline82 = GeneratedOutlineSupport.outline82("Property '", str2, "' (JVM signature: ", str3, ") not resolved in ");
                    outline82.append(kDeclarationContainerImpl);
                    throw new KotlinReflectionInternalError(outline82.toString());
                } else if (arrayList.size() == 1) {
                    return (PropertyDescriptor) ArraysKt___ArraysJvmKt.single((List<? extends T>) arrayList);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next2 = it.next();
                        DescriptorVisibility visibility = ((PropertyDescriptor) next2).getVisibility();
                        Object obj = linkedHashMap.get(visibility);
                        if (obj == null) {
                            obj = new ArrayList();
                            linkedHashMap.put(visibility, obj);
                        }
                        ((List) obj).add(next2);
                    }
                    KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 = KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE;
                    Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
                    Intrinsics.checkNotNullParameter(kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2, "comparator");
                    TreeMap treeMap = new TreeMap(kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2);
                    treeMap.putAll(linkedHashMap);
                    Collection values = treeMap.values();
                    Intrinsics.checkNotNullExpressionValue(values, "properties\n             …                }).values");
                    List list = (List) ArraysKt___ArraysJvmKt.last((Iterable<? extends T>) values);
                    if (list.size() == 1) {
                        Intrinsics.checkNotNullExpressionValue(list, "mostVisibleProperties");
                        return (PropertyDescriptor) ArraysKt___ArraysJvmKt.first(list);
                    }
                    Name identifier2 = Name.identifier(str2);
                    Intrinsics.checkNotNullExpressionValue(identifier2, "Name.identifier(name)");
                    String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default(kDeclarationContainerImpl.getProperties(identifier2), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30);
                    StringBuilder outline822 = GeneratedOutlineSupport.outline82("Property '", str2, "' (JVM signature: ", str3, ") not resolved in ");
                    outline822.append(kDeclarationContainerImpl);
                    outline822.append(':');
                    if (joinToString$default.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        str = " no members found";
                    } else {
                        str = 10 + joinToString$default;
                    }
                    outline822.append(str);
                    throw new KotlinReflectionInternalError(outline822.toString());
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }
}
