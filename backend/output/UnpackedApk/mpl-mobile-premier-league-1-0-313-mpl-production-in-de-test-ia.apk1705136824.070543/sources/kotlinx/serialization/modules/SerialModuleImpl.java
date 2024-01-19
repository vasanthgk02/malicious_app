package kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B´\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012&\u0010\b\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\n\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000bj\u0006\u0012\u0002\b\u0003`\u00100\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J:\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0007\"\b\b\u0000\u0010\u0017*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u001bH\u0016J7\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u001d\"\b\b\u0000\u0010\u0017*\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00170\u00042\u0006\u0010\u001f\u001a\u0002H\u0017H\u0016¢\u0006\u0002\u0010 J6\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0017\u0018\u00010\u000f\"\b\b\u0000\u0010\u0017*\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00170\u00042\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000RI\u0010\n\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000bj\u0006\u0012\u0002\b\u0003`\u00100\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2NamedSerializers", "", "polyBase2DefaultProvider", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicProvider;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", "T", "", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerializersModule.kt */
public final class SerialModuleImpl extends SerializersModule {
    public final Map<KClass<?>, ContextualProvider> class2ContextualFactory;
    public final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultProvider;
    public final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> map, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> map2, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> map3, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> map4) {
        // Intrinsics.checkNotNullParameter(map, "class2ContextualFactory");
        // Intrinsics.checkNotNullParameter(map2, "polyBase2Serializers");
        // Intrinsics.checkNotNullParameter(map3, "polyBase2NamedSerializers");
        // Intrinsics.checkNotNullParameter(map4, "polyBase2DefaultProvider");
        super(null);
        this.class2ContextualFactory = map;
        this.polyBase2Serializers = map2;
        this.polyBase2NamedSerializers = map3;
        this.polyBase2DefaultProvider = map4;
    }

    public <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        KSerializer<?> invoke = contextualProvider == null ? null : contextualProvider.invoke(list);
        if (invoke instanceof KSerializer) {
            return invoke;
        }
        return null;
    }
}
