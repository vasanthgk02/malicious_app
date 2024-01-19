package kotlin.reflect.jvm.internal.impl.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Map.Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: JavaTypeEnhancementState.kt */
public final class JavaTypeEnhancementState$description$2 extends Lambda implements Function0<String[]> {
    public final /* synthetic */ JavaTypeEnhancementState this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaTypeEnhancementState$description$2(JavaTypeEnhancementState javaTypeEnhancementState) {
        // this.this$0 = javaTypeEnhancementState;
        super(0);
    }

    public Object invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.globalJsr305Level.getDescription());
        ReportLevel reportLevel = this.this$0.migrationLevelForJsr305;
        if (reportLevel != null) {
            arrayList.add(Intrinsics.stringPlus("under-migration:", reportLevel.getDescription()));
        }
        for (Entry next : this.this$0.userDefinedLevelForSpecificJsr305Annotation.entrySet()) {
            StringBuilder outline72 = GeneratedOutlineSupport.outline72('@');
            outline72.append((String) next.getKey());
            outline72.append(':');
            outline72.append(((ReportLevel) next.getValue()).getDescription());
            arrayList.add(outline72.toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
