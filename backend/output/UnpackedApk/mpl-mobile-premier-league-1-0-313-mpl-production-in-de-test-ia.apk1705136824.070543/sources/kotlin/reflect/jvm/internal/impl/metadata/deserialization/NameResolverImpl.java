package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.QualifiedName;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind;

/* compiled from: NameResolverImpl.kt */
public final class NameResolverImpl implements NameResolver {
    public final ProtoBuf$QualifiedNameTable qualifiedNames;
    public final ProtoBuf$StringTable strings;

    public NameResolverImpl(ProtoBuf$StringTable protoBuf$StringTable, ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        Intrinsics.checkNotNullParameter(protoBuf$StringTable, "strings");
        Intrinsics.checkNotNullParameter(protoBuf$QualifiedNameTable, "qualifiedNames");
        this.strings = protoBuf$StringTable;
        this.qualifiedNames = protoBuf$QualifiedNameTable;
    }

    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(i);
        List list = (List) traverseIds.first;
        String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default((List) traverseIds.second, ".", null, null, 0, null, null, 62);
        if (list.isEmpty()) {
            return joinToString$default;
        }
        return ArraysKt___ArraysJvmKt.joinToString$default(list, "/", null, null, 0, null, null, 62) + '/' + joinToString$default;
    }

    public String getString(int i) {
        String str = (String) this.strings.string_.get(i);
        Intrinsics.checkNotNullExpressionValue(str, "strings.getString(index)");
        return str;
    }

    public boolean isLocalClassName(int i) {
        return ((Boolean) traverseIds(i).third).booleanValue();
    }

    public final Triple<List<String>, List<String>, Boolean> traverseIds(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            QualifiedName qualifiedName = this.qualifiedNames.qualifiedName_.get(i);
            ProtoBuf$StringTable protoBuf$StringTable = this.strings;
            String str = (String) protoBuf$StringTable.string_.get(qualifiedName.shortName_);
            Kind kind = qualifiedName.kind_;
            Intrinsics.checkNotNull(kind);
            int ordinal = kind.ordinal();
            if (ordinal == 0) {
                linkedList2.addFirst(str);
            } else if (ordinal == 1) {
                linkedList.addFirst(str);
            } else if (ordinal == 2) {
                linkedList2.addFirst(str);
                z = true;
            }
            i = qualifiedName.parentQualifiedName_;
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }
}
