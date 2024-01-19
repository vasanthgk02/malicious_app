package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Builder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: TypeTable.kt */
public final class TypeTable {
    public final List<ProtoBuf$Type> types;

    public TypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
        Intrinsics.checkNotNullParameter(protoBuf$TypeTable, "typeTable");
        List<ProtoBuf$Type> list = protoBuf$TypeTable.type_;
        int i = 0;
        if ((protoBuf$TypeTable.bitField0_ & 1) == 1) {
            int i2 = protoBuf$TypeTable.firstNullable_;
            List<ProtoBuf$Type> list2 = protoBuf$TypeTable.type_;
            Intrinsics.checkNotNullExpressionValue(list2, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list2, 10));
            for (T next : list2) {
                int i3 = i + 1;
                if (i >= 0) {
                    ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) next;
                    if (i >= i2) {
                        if (protoBuf$Type != null) {
                            Builder newBuilder = ProtoBuf$Type.newBuilder(protoBuf$Type);
                            newBuilder.bitField0_ |= 2;
                            newBuilder.nullable_ = true;
                            protoBuf$Type = newBuilder.buildPartial();
                            if (!protoBuf$Type.isInitialized()) {
                                throw new UninitializedMessageException();
                            }
                        } else {
                            throw null;
                        }
                    }
                    arrayList.add(protoBuf$Type);
                    i = i3;
                } else {
                    TweetUtils.throwIndexOverflow();
                    throw null;
                }
            }
            list = arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(list, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.types = list;
    }

    public final ProtoBuf$Type get(int i) {
        return this.types.get(i);
    }
}
