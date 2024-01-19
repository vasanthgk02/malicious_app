package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004B\u0015\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0014¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\r*\u00028\u00022\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010 \u001a\u00028\u0000H$¢\u0006\u0002\u0010!R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000\u0001\u0005\"#$%&¨\u0006'"}, d2 = {"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CollectionSerializers.kt */
public abstract class ListLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {
    public final KSerializer<Element> elementSerializer;

    public ListLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        super(null);
        this.elementSerializer = kSerializer;
    }

    public abstract SerialDescriptor getDescriptor();

    public abstract void insert(Builder builder, int i, Element element);

    public final void readAll(CompositeDecoder compositeDecoder, Builder builder, int i, int i2) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        } else if (i2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                readElement(compositeDecoder, i3 + i, builder, false);
                if (i4 < i2) {
                    i3 = i4;
                } else {
                    return;
                }
            }
        }
    }

    public void readElement(CompositeDecoder compositeDecoder, int i, Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        insert(builder, i, TypeUtilsKt.decodeSerializableElement$default(compositeDecoder, getDescriptor(), i, this.elementSerializer, null, 8, null));
    }

    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(collection);
        CompositeEncoder beginCollection = encoder.beginCollection(getDescriptor(), collectionSize);
        Iterator collectionIterator = collectionIterator(collection);
        if (collectionSize > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                beginCollection.encodeSerializableElement(getDescriptor(), i, this.elementSerializer, collectionIterator.next());
                if (i2 >= collectionSize) {
                    break;
                }
                i = i2;
            }
        }
        beginCollection.endStructure(getDescriptor());
    }
}
