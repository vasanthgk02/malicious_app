package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J(\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0007J<\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0012\b\u0002\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000eH'J7\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0010\"\b\b\u0000\u0010\t*\u00020\u00012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u0002H\tH'¢\u0006\u0002\u0010\u0013J6\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\t\u0018\u00010\u0014\"\b\b\u0000\u0010\t*\u00020\u00012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\t0\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'\u0001\u0001\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "kclass", "Lkotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializedClassName", "", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerializersModule.kt */
public abstract class SerializersModule {
    public SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static KSerializer getContextual$default(SerializersModule serializersModule, KClass kClass, List list, int i, Object obj) {
        return serializersModule.getContextual(kClass, (i & 2) != 0 ? EmptyList.INSTANCE : null);
    }

    public abstract <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list);
}