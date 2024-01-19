package kotlinx.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\b\u0010\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u001b\b\u0000\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "fieldName", "", "(Ljava/lang/String;)V", "fieldNames", "", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "message", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerializationException.kt */
public final class MissingFieldException extends SerializationException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MissingFieldException(List<String> list, String str) {
        String str2;
        StringBuilder sb;
        // Intrinsics.checkNotNullParameter(list, "fieldNames");
        // Intrinsics.checkNotNullParameter(str, "serialName");
        // if (list.size() == 1) {
            // sb = GeneratedOutlineSupport.outline73("Field '");
            // GeneratedOutlineSupport.outline102(sb, list.get(0), "' is required for type with serial name '", str);
            // str2 = "', but it was missing";
        // } else {
            // sb = new StringBuilder();
            // sb.append("Fields ");
            // sb.append(list);
            // sb.append(" are required for type with serial name '");
            // sb.append(str);
            // str2 = "', but they were missing";
        // }
        // sb.append(str2);
        super(sb.toString(), null);
    }
}
