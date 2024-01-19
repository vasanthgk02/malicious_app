package kotlin.reflect.jvm.internal.impl.builtins;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: CompanionObjectMapping.kt */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    public static final Set<ClassId> classIds;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        StandardNames standardNames = StandardNames.INSTANCE;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(set, 10));
        for (PrimitiveType primitiveType : set) {
            Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
            arrayList.add(child);
        }
        FqName safe = FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "string.toSafe()");
        List plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) arrayList, safe);
        FqName safe2 = FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List plus2 = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) plus, safe2);
        FqName safe3 = FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List plus3 = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) plus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = ((ArrayList) plus3).iterator();
        while (it.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it.next()));
        }
        classIds = linkedHashSet;
    }
}
