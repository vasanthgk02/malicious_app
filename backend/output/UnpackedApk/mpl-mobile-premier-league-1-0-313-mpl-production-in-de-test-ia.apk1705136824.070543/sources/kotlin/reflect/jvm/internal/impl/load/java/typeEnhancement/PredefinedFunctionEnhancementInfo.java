package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedFunctionEnhancementInfo {
    public final List<TypeEnhancementInfo> parametersInfo;
    public final TypeEnhancementInfo returnTypeInfo;

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List<TypeEnhancementInfo> list) {
        Intrinsics.checkNotNullParameter(list, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = list;
    }

    public PredefinedFunctionEnhancementInfo() {
        EmptyList emptyList = EmptyList.INSTANCE;
        Intrinsics.checkNotNullParameter(emptyList, "parametersInfo");
        this.returnTypeInfo = null;
        this.parametersInfo = emptyList;
    }
}
